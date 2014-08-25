package com.etech.webutil;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.etech.variable.Variables;

public class WebServiceQRCode {
	public static String getQRCode(String shopID) {
		String url=Variables.webserviceQRCode+shopID;
		System.out.println("current webservice url:"+url);
		String QRCode = "";
		try {
			HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setDoOutput(true); 
			// 设置是否从httpUrlConnection读入，默认情况下是true; 
			connection.setDoInput(true); 
			// Post 请求不能使用缓存 
			connection.setUseCaches(false); 
			connection.connect();
			InputStream in = connection.getInputStream();
			QRCode = IOUtils.toString(in, "UTF-8");
			 JSONObject json = JSONObject.fromObject(QRCode);
			 QRCode=json.getString("data");
			 QRCode=(String)JSONObject.fromObject(JSONArray.fromObject(QRCode).get(0)).get("Result");
			 FileUtils.copyInputStreamToFile(in,new File(Variables.shopQRCodePath+QRCode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return QRCode;
	}
public static void main(String[] args) {
	String str2 = "湖北省武汉市洪山区乐天城一楼";
	int a = str2.indexOf("区");
	String area = str2.substring(0,a+1);
	System.out.println(area);
}
}
