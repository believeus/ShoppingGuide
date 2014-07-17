package com.etech.webutil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesUtils {
	/** 以UTF8的形式加载属性文件 */
	public static Properties loadPropertyUTF8(String propertyClassPath) {
		Properties props = null;
		try {
			props = new Properties();
			props.load(new InputStreamReader(PropertiesUtils.class
					.getClassLoader().getResourceAsStream(propertyClassPath), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

	/** 属性替换 */
	public static void propertyReplace(String propertyClassPath, String key, String value) {
		try {
			Properties properties = loadPropertyUTF8(propertyClassPath);
			properties.setProperty(key, value);
			String url = PropertiesUtils.class.getClassLoader()
					.getResource(propertyClassPath).toString().replace("file:", "");
			OutputStream fos = new FileOutputStream(url);
			OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
			properties.store(writer, "");
			fos.close();// 关闭流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**获取属性值*/
	public static String findValue(String propertyClassPath,String key){
		Properties properties = loadPropertyUTF8(propertyClassPath);
		String value=(String)properties.get(key);
		return value;
	}
}
