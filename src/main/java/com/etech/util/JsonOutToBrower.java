package com.etech.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class JsonOutToBrower {
	/* 将map类型转换成json格式输出到浏览器 */
	public static void out(Map<String,Object> map, HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			OutputStream out = response.getOutputStream();
			JSONObject json=JSONObject.fromObject(map);
			PrintWriter writer = new PrintWriter(out);
			writer.println(json.toString());
			writer.flush();
			writer.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
