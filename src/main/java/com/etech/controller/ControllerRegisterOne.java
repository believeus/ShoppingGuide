package com.etech.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.variable.Variables;
import com.etech.webutil.Brower;
import com.etech.webutil.WebServiceValidCode;
import com.etech.webutil.WebServiceValidCodeForFindPassword;
@Controller
public class ControllerRegisterOne {

	private static final Log log = LogFactory.getLog(ControllerRegisterOne.class);
	@Resource
	private EtechService etechService;

	@RequestMapping(value="/validatePhoneNumber")
	public @ResponseBody String validateMobile(String phoneNumber){
		log.debug("current register phoneNumber:"+phoneNumber);
		// 根据手机号查找该用户是否被注册
		Tshopuser shopuser = (Tshopuser)etechService.findObject(Tshopuser.class, Variables.username, phoneNumber);
		// 该手机号被注册
		if(!StringUtils.isEmpty(shopuser)){
			return "false";
		}
		// 该手机号未被注册
		return "true";
	}
	@RequestMapping(value="/validatePhoneNumber2")
	public @ResponseBody String validateMobile2(String phoneNumber){
		log.debug("current register phoneNumber:"+phoneNumber);
		// 根据手机号查找该用户是否被注册
		Tshopuser shopuser = (Tshopuser)etechService.findObject(Tshopuser.class, Variables.username, phoneNumber);
		// 该手机号被注册
		if(!StringUtils.isEmpty(shopuser)){
			return "<script>parent.document.getElementById('returnValue_pn').value=false;</script>";
		}
		// 该手机号未被注册
		return "<script>parent.document.getElementById('returnValue_pn').value=true;</script>";
	}
	
	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:获取手机验证码*/
	@RequestMapping(value="/generateValidCode")
	public void generateValidCode(String phoneNumber,HttpSession session,ServletResponse response){
		log.debug("current phoneNumber:"+phoneNumber);
		String validCode = WebServiceValidCode.getCode(phoneNumber);
		log.debug("validCode:"+validCode);
		session.setAttribute(Variables.validCode, validCode);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("returnCode", validCode);
		Brower.outJson(map, response);
	}
	/**End Author:wuqiwei Data:2014-07-15 AddReason:获取手机验证码*/
	
	/**
	 * findPassword
	 * @param phoneNumber
	 * @param session
	 * @param response
	 */
	@RequestMapping(value="/generateValidCodeTwo")
	public void generateValidCode2(String phoneNumber,HttpSession session,ServletResponse response){
		log.debug("current phoneNumber:"+phoneNumber);
		String validCode = WebServiceValidCodeForFindPassword.getCode(phoneNumber);
		log.debug("validCode:"+validCode);
		session.setAttribute(Variables.validCode, validCode);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("returnCode", validCode);
		Brower.outJson(map, response);
	}
	
	//注册验证码
	@RequestMapping(value="/validateNumberCode")
	public @ResponseBody String validateNumberCode(String numberCode,HttpSession session){
		String sessionCode = (String)session.getAttribute(Variables.validCode);
		//response.addHeader("Access-Control-Allow-Origin","*");
		log.debug("input valid code:"+numberCode+" session Valid code:"+sessionCode);
		// 验证码不匹配
		if (sessionCode != null) {
			if(!sessionCode.equals(numberCode)){
				return "false";
			}
		}else {
			return "false";
		}
		return "true";
	}
	/**
	 * 找回密码验证码
	 */
	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:验证电话验证码是否一致*/
	@RequestMapping(value="/validateNumberCode2")
	public @ResponseBody String validateNumberCode2(String numberCode,HttpSession session){
		String sessionCode = (String)session.getAttribute(Variables.validCode);
		//response.addHeader("Access-Control-Allow-Origin","*");
		log.debug("input valid code:"+numberCode+" session Valid code:"+sessionCode);
		// 验证码不匹配
		if (sessionCode != null) {
			if(!sessionCode.equals(numberCode)){
				return "<script>parent.document.getElementById('returnValue').value=false;</script>";
			}
		}else {
			return "<script>parent.document.getElementById('returnValue').value=false;</script>";
		}
		return "<script>parent.document.getElementById('returnValue').value=true;</script>";
	}
	/**End Author:wuqiwei Data:2014-07-15 AddReason:验证电话验证码是否一致*/
	
	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:表单验证通过后,将该保存到数据库*/
	@RequestMapping(value="/dealRegister")
	public void dealRegister(Tshopuser shopuser,HttpSession session,ServletResponse response){
		log.debug("current register phoneNumber:"+shopuser.getPhoneNumber());
		shopuser.setUserName(shopuser.getPhoneNumber());
		// 密码md5加密
		String password=DigestUtils.md5Hex(shopuser.getPassword());
		shopuser.setPassword(password);
		shopuser.setScore(0);
		shopuser.setGrade((short)1);
		shopuser.setGender(Variables.man);
		shopuser.setPhoneNumber(shopuser.getPhoneNumber());
		// 创建时间
		shopuser.setAddTime(new Timestamp(System.currentTimeMillis()));
		shopuser.setState((short)Variables.reviewing);
		shopuser.setLoginCount(1);
		// 没有注册店铺
		shopuser.setDefaultShopId(Variables.unRegister);
		etechService.saveOrUpdate(shopuser);
		session.setAttribute(Variables.sessionUser, shopuser);
		Brower.redirect("/register2.jhtml", response);
	}
	
	@RequestMapping(value="/register")
	public String registerView(){
		return "/WEB-INF/register.jsp";
	}
	
}
