package com.etech.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.webutil.Brower;

@Controller
public class ControllerEditShopMsg {
	
	@RequestMapping(value="/editShopName")
	public void editShopName(String shopName,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(shopName)){
			if(shopName.length()>=1 && shopName.length()<=10){
				message.put("property", "editShopName");
				message.put("message","success");
				Brower.outJson(message, response);
			}else{
				message.put("property", "editShopName");
				message.put("message","error");
				Brower.outJson(message, response);
			}
		}else{
			message.put("property", "editShopName");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}
	
	@RequestMapping(value="/priceRange")
	public void priceRange(String priceRange,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(priceRange)){
			message.put("property", "priceRange");
			message.put("message","success");
			Brower.outJson(message, response);
		}else{
			message.put("property", "priceRange");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}
	
	@RequestMapping(value="/phoneNum")
	public void phoneNum(String phoneNum,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(phoneNum)){
			boolean matches = phoneNum.matches(
					"^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
			if(matches == false){
				message.put("property", "phoneNum");
				message.put("message","error");
				Brower.outJson(message, response);
			}else{
				message.put("property", "phoneNum");
				message.put("message","success");
				Brower.outJson(message, response);
			}
		}else{
			message.put("property", "phoneNum");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}
	
	@RequestMapping(value="/qqNum")
	public void qqNum(String qqNum,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(qqNum)){
				message.put("property", "qqNum");
				message.put("message","success");
				Brower.outJson(message, response);
		}else{
			message.put("property", "qqNum");
			message.put("message","error");
			Brower.outJson(message, response);
		}
	}
	
}
