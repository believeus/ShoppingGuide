package mydfs.storage.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wuqiwei
 * Email 1058633117@qq.com
 * Data   2014-06-05
 * AddReason 文件上传会出现视频和附件这些比较大的文件
 * 			 并且,并且后期tomcat进行集群的时候，访问
 * 			 公共图片数据的时候，常规的方式出现访问
 * 			 上的烦人事,数据迁移的时候变得困难。
 *           故自己写了一个文件管理系统，管理上传的文件
 * */
public class MydfsStorageServer {

	private ServerSocket serverSocket;
	private ExecutorService executorService;
	private boolean stop=false;
	//监听本机的哪个ip地址
	private String host;
	// 本地监听端口
	private int port;
	private int workers;
	// 文件存放的基目录
	private String basepath;
	// 返回路径的前缀
	private String pathPrefix;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public int getWorkers() {
		return workers;
	}

	public void setWorkers(int workers) {
		this.workers = workers;
	}

	public String getPathPrefix() {
		return pathPrefix;
	}

	public void setPathPrefix(String pathPrefix) {
		this.pathPrefix = pathPrefix;
	}

	public MydfsStorageServer() {
		this.pathPrefix = "group/M00";
	}

	public MydfsStorageServer(int port, String basepath, int workers,String host) {
			this.port = port;
			this.workers = workers;
			this.basepath = basepath;
			this.host=host;
			// 指定前缀方便访问之用
			this.pathPrefix = "group/M00";
	}

	@SuppressWarnings("resource")
	public void startServer() throws IOException {
		serverSocket = new ServerSocket();
		//ServerSocket 绑定的ip和端口号
		SocketAddress socketAddress=new InetSocketAddress(host,port);
		serverSocket.bind(socketAddress);
		// 初始化存储文件文件夹
		Folder.initFolder(basepath);
		
		executorService = Executors.newFixedThreadPool(workers);
		System.out.print("Storage Server start!");
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						if(stop)break;
						final Socket socket = serverSocket.accept();
						//保存客户端上传的文件,并返回文件存储的路径给客户端
						// 每次接受一个客户端连接都执行一个线程
						executorService.execute(new Runnable() {

							@Override
							public void run() {
								try {
									InputStream in = socket.getInputStream();
									DataInputStream datais=new DataInputStream(in);
									String status = datais.readUTF();
									//获取文件数据
									if(status.equals("receive")){
										// 读取到请求的url
										String url = datais.readUTF();
										Pattern regex = Pattern.compile("/[A-Z0-9]{2}/[A-Z0-9]{2}/[A-Za-z0-9-]+\\.[a-z]+");
										Matcher matcher = regex.matcher(url);
										if(matcher.find()){
											String storepath=basepath+matcher.group();
											System.out.println("storepath:"+storepath);
											OutputStream outputStream = socket.getOutputStream();
											BufferedOutputStream bos=new BufferedOutputStream(outputStream);
											
											byte[] buf=new byte[1024];
											int len=0;
											File file=new File(storepath);
											InputStream inputStream=new FileInputStream(file);
											BufferedInputStream bis=new BufferedInputStream(inputStream);
											while ((len=bis.read(buf))!=-1) {
												bos.write(buf, 0, len);
												bos.flush();
											}
											System.out.println(url+" output success");
											bos.close();
											inputStream.close();
										}
										return;
									}
									// 文件上传
									if(status.equals("upload")){
										// 获取文件后缀名
										String extension=datais.readUTF();
										System.out.println("client file stuffix: "+extension);
										String uuid = UUID.randomUUID().toString().toUpperCase();
										// 得到存储路径
										String storepath = Folder.getStoragePath(uuid);
										// 文件存储路径
										File file = new File(storepath);
										OutputStream out = new FileOutputStream(file);
										BufferedOutputStream bos = new BufferedOutputStream(out);
										// 获取文件流的大小
										int size = datais.readInt();
										System.out.println("server file size:" + size);
										// InputStreamReader将字节流转化为字符流
										BufferedInputStream br = new BufferedInputStream(in);
										// 读取客户端数据
										int len = 0;
										byte[] buf = new byte[1024];
										//客户端不关闭,br.read(buf);会一直等待,所以必须
										//手动判断退出循环
										System.out.println("virtual times:"+(float)size/(float)buf.length);
										double times=Math.ceil((float)size / (float)buf.length);
										System.out.println("read times:"+times);
										for (int i = 0; i < times; i++) {
											len = br.read(buf);
											bos.write(buf, 0, len);
											bos.flush();
										}
										// 获取文件的类型
										String fileType = FileType.getTypeByFile(file);
										//如果查询的后缀名不在定义范围内,使用客户端传递过来的后缀名
										if(fileType==null)fileType=extension;
										storepath = storepath + "."+fileType ;
										// 将文件改名
										file.renameTo(new File(storepath));
										storepath=storepath.replaceAll(basepath, pathPrefix);
										System.out.println("access path:"+storepath);
										out = socket.getOutputStream();
										DataOutputStream socketOut=new DataOutputStream(out);
										socketOut.writeUTF(storepath);
										bos.flush();
										bos.close();
										br.close();
										socketOut.close();
										return;
									}
									// 删除StoreServer中的数据
									if(status.equals("remove")){
										boolean success=false;
										OutputStream out = socket.getOutputStream();
										DataOutputStream dataos = new DataOutputStream(out);
										// 读取到请求的url
										String url = datais.readUTF();
										Pattern regex = Pattern.compile("/[A-Z0-9]{2}/[A-Z0-9]{2}/[A-Za-z0-9-]+\\.[a-z]+");
										Matcher matcher = regex.matcher(url);
										if(matcher.find()){
											String storepath=basepath+matcher.group();
											System.out.println("file disk store path:"+storepath);
											File file=new File(storepath);
											if(file.exists())success= file.delete();
										}
										dataos.writeBoolean(success);
										dataos.flush();
										dataos.close();
										return;
									}
									
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}).start();

	}

	public void stopServer() {
		stop=true;
		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
			if (executorService != null) {
				executorService.shutdown();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MydfsStorageServer mydfsStorageServer=new MydfsStorageServer(9999, "/data/mydfs/store/", 4, "192.168.1.120");
		try {
			mydfsStorageServer.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
