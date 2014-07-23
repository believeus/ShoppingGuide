package com.etech.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tshopuser;
import com.etech.webutil.Brower;

@Controller
public class ControllerAboutUserNum {

//	验证关联帐号中输入的当前密码
	@RequestMapping(value="/ajaxAssociatePasswordValid")
	public void aboutUserPassword(String password,HttpServletResponse response,HttpSession session){
		Map<String, Object> message=new HashMap<String, Object>();
		
		if(StringUtils.isEmpty(password)){
			message.put("property", "associatePassword");
			message.put("message","nu");
			Brower.outJson(message, response);
			return;
		}
		
		
		Tshopuser sunao=new Tshopuser();
		sunao.setUserName("sunao");
		sunao.setPassword("1234");
		session.setAttribute("formUser", sunao);
		
		Tshopuser user=(Tshopuser) session.getAttribute("formUser");
		
		String pwd=user.getPassword();
		
		String psd=DigestUtils.md5Hex(password);
		if(!StringUtils.isEmpty(psd)){
			System.out.println("123"+psd+","+pwd);
			if(psd.equals(pwd)){
				message.put("property", "associatePassword");
				message.put("message","success");
				Brower.outJson(message, response);
			}else{
				message.put("property", "associatePassword");
				message.put("message","error");
				Brower.outJson(message, response);
			}
		}
	}
	
//	验证关联帐号中输入的新帐号格式
	@RequestMapping(value="/ajaxAssociateUserValid")
	public void aboutUser(String aboutUser,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(aboutUser)){
			boolean matches = aboutUser.matches(
					"^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
			if(matches == false){
				message.put("property", "associateNewUser");
				message.put("message","error");
				Brower.outJson(message, response);
			}else{
				message.put("property", "associateNewUser");
				message.put("message","success");
				Brower.outJson(message, response);
			}
		}else{
			message.put("property", "associateNewUser");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
		
	}
	
	
//	验证关联帐号中输入的新密码(还差特殊字符验证和必需含有字母)
	@RequestMapping(value="/ajaxAssociateNewPwdValid")
	public void aboutPwd(String aboutPwd,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(aboutPwd)){
			if(aboutPwd.length()>=6 && aboutPwd.length()<=18){
				message.put("property", "associateNewPassword");
				message.put("message","success");
				Brower.outJson(message, response);
			}else{
				message.put("property", "associateNewPassword");
				message.put("message","error");
				Brower.outJson(message, response);
			}
		}else{
			message.put("property", "associateNewPassword");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}
	
//	验证两次输入的密码相同
	@RequestMapping(value="/ajaxAssociateComparePwdValid")
	public void comparedTwoPwd(String aboutPwd,String comfirmPwd,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(comfirmPwd)){
			if(comfirmPwd.equals(aboutPwd)){
				message.put("property", "associateComparePwd");
				message.put("message","success");
				Brower.outJson(message, response);
			}else{
				message.put("property", "associateComparePwd");
				message.put("message","error");
				Brower.outJson(message, response);
			}
		}else{
			message.put("property", "associateComparePwd");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}
	
}
