package com.etech.webutil;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import com.etech.variable.Variables;

public class WebServiceValidCodeForFindPassword {
	public static String getCode(String phoneNumber) {
		String url=Variables.webserviceFindPassword+phoneNumber;
		System.out.println("current webservice url:"+url);
		String validCode = "";
		try {
			HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setDoOutput(true); 
			// 设置是否从httpUrlConnection读入，默认情况下是true; 
			connection.setDoInput(true); 
			// Post 请求不能使用缓存 
			connection.setUseCaches(false); 
			connection.connect();
			InputStream in = connection.getInputStream();
			validCode = IOUtils.toString(in, "UTF-8");
			Pattern regex = Pattern.compile("[0-9]{4}");
			Matcher matcher = regex.matcher(validCode);
			if(matcher.find()){
				validCode=matcher.group();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validCode;
	}
	
	public static void main(String[] args) {
		String str = "湖北省武汉市洪山区街道口未来城E座2401";
		System.out.println(str.substring(str.indexOf("区")+1));
	}
}
