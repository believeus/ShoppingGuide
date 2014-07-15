package com.etech.webutil;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import net.sf.json.JSONObject;

public class Brower {
	private static final Log log=LogFactory.getLog(Brower.class);
	/* 将map类型转换成json格式输出到浏览器 */
	public static void outJson(Map<String,Object> map, ServletResponse response) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			OutputStream out = response.getOutputStream();
			JSONObject json=JSONObject.fromObject(map);
			PrintWriter writer = new PrintWriter(out);
			log.debug(json.toString());
			writer.println(json.toString());
			writer.flush();
			writer.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//根据url重定向
	public static void redirect(String url,ServletResponse response){
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("<script type='text/javascript'>")
			.append("top.location.href='"+url+"'").append("</script>");
			log.debug(sb.toString());
			PrintWriter pw=new PrintWriter(response.getOutputStream());
			pw.write(sb.toString());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
