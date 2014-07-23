package com.etech.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.service.EtechService;
import com.etech.webutil.Brower;

@Controller
public class ControllerFindPsd {
	
	private EtechService etechService;
	
	@RequestMapping(value="/licenseNum")
	public void licenseNum(String license,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(license)){
			if(license.length() != 13){
				message.put("property", "licenseNum");
				message.put("message","error");
				Brower.outJson(message, response);
			}else{
				message.put("property", "licenseNum");
				message.put("message","success");
				Brower.outJson(message, response);
			}
		}else{
			message.put("property", "licenseNum");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}
	
	@RequestMapping(value="/userNum")
	public void userNum(String userNum,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(userNum)){
			boolean matches = userNum.matches(
					"^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
			if(matches == false){
				message.put("property", "userNum");
				message.put("message","error");
				Brower.outJson(message, response);
			}else{
				message.put("property", "userNum");
				message.put("message","success");
				//发送含有验证码的短信
				
				Brower.outJson(message, response);
			}
		}else{
			message.put("property", "userNum");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}
	
	@RequestMapping(value="/submit")
	public void submit(String license,String userNum,String telphone,String yanzhengma){
		
		
	}
}
