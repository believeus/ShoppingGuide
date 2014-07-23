package com.etech.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tshopuser;
import com.etech.webutil.Brower;

@Controller
public class ControllerUpdatePassword {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);

//	验证修改密码中旧密码
	@RequestMapping(value="/ajaxoldPwdValid")
	public void oldPassword(String oldPassword,HttpServletResponse response,HttpSession session){
		Map<String, Object> message=new HashMap<String, Object>();
		
		if(StringUtils.isEmpty(oldPassword)){
			message.put("property", "oldPassword");
			message.put("message","nu");
			Brower.outJson(message, response);
			return;
		}

		
		Tshopuser user=(Tshopuser) session.getAttribute("formUser");
		
		String psd=user.getPassword();
		
		String oldPwd=DigestUtils.md5Hex(oldPassword);
		if(oldPwd.equals(psd)){
			message.put("property", "oldPassword");
			message.put("message","success");
			Brower.outJson(message, response);
		}else{
			message.put("property", "oldPassword");
			message.put("message","error");
			Brower.outJson(message, response);
		}
	}
	
//	验证修改密码中新密码(还差特殊字符验证和必需含有字母)
	@RequestMapping(value="/ajaxnewPwdValid")
	public void newPassword(String newPwd,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(newPwd)){
			if(newPwd.length()>=6 && newPwd.length()<=18){
				message.put("property", "newPwd");
				message.put("message","success");
				Brower.outJson(message, response);
			}else{
				message.put("property", "newPwd");
				message.put("message","error");
				Brower.outJson(message, response);
			}
		}else{
			message.put("property", "newPwd");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}
//	验证两密码相同	
	@RequestMapping(value="/ajaxcomparePwdValid")
	public void comparePwd(String newPwd,String comfirmNewPwd,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(comfirmNewPwd)){
			if(comfirmNewPwd.equals(newPwd)){
				message.put("property", "compareTwoPwd");
				message.put("message","success");
				Brower.outJson(message, response);
			}else{
				message.put("property", "compareTwoPwd");
				message.put("message","error");
				Brower.outJson(message, response);
			}
		}else{
			message.put("property", "compareTwoPwd");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}
	
	
}
