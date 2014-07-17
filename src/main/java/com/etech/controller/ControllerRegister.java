package com.etech.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etech.entity.Tshopsuser;
import com.etech.service.EtechService;
import com.etech.webutil.Brower;
import com.etech.webutil.Variables;
import com.etech.webutil.WebServiceValidCode;
@Controller
public class ControllerRegister {

	private static final Log log = LogFactory.getLog(ControllerRegister.class);
	@Resource
	private EtechService etechService;

	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:验证电话号码是否被注册过*/
	@RequestMapping(value="/validatePhoneNumber")
	public @ResponseBody String validateMobile(String phoneNumber){
		log.debug("current register phoneNumber:"+phoneNumber);
		// 根据手机号查找该用户是否被注册
		Tshopsuser shopuser = (Tshopsuser)etechService.findObject(Tshopsuser.class, Variables.phoneNumber, phoneNumber);
		// 该手机号被注册
		if(!StringUtils.isEmpty(shopuser)){
			return "false";
		}
		// 该手机号未被注册
		return "true";
	}
	/**End Author:wuqiwei Data:2014-07-15 AddReason:验证电话号码是否被注册过*/
	
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
	
	
	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:验证电话验证码是否一致*/
	@RequestMapping(value="/validateNumberCode")
	public @ResponseBody String validateNumberCode(String numberCode,HttpSession session){
		String sessionCode = (String)session.getAttribute(Variables.validCode);
		log.debug("input valid code:"+numberCode+" session Valid code:"+sessionCode);
		if(!sessionCode.equals(numberCode)){
			return "false";
		}
		// 验证码不匹配
		return "true";
	}
	/**End Author:wuqiwei Data:2014-07-15 AddReason:验证电话验证码是否一致*/
	
	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:表单验证通过后,将该保存到数据库*/
	@RequestMapping(value="/dealRegister")
	public void register(Tshopsuser shopuser,HttpSession session,ServletResponse response){
		log.debug("current register phoneNumber:"+shopuser.getPhoneNumber());
		shopuser.setUserName(shopuser.getPhoneNumber());
		// 密码md5加密
		String password=DigestUtils.md5Hex(shopuser.getPassword());
		shopuser.setPassword(password);
		shopuser.setScore(0);
		shopuser.setGrade((short)1);
		shopuser.setGender(Variables.man);
		// 创建时间
		shopuser.setAddTime(new Timestamp(System.currentTimeMillis()));
		shopuser.setPageView(0);
		shopuser.setState((short)Variables.reviewing);
		// 没有注册店铺
		shopuser.setDefaultShopId(Variables.unRegister);
		etechService.saveOrUpdata(shopuser);
		session.setAttribute(Variables.sessionUser, shopuser);
		Brower.redirect("/register2.jhtml", response);
	}
	
	/**End Author:wuqiwei   Data:2014-07-15 AddReason:表单验证通过后,将该用户保存到数据库*/
	
	/** 
	 * End Author:wuqiwei Data:2014=05-26 Email:1058633117@qq.com
	 * AddReason:ajax判断一般用户的ajax验证
	 */

	/**
	 * 注册
	 * @return
	 */
	@RequestMapping(value="/register")
	public String registerView(){
		return "/WEB-INF/register.jsp";
	}
	@RequestMapping(value="/register2")
	public String registerView2(){
		return "/WEB-INF/register2.jsp";
	}
	@RequestMapping(value="/register3")
	public String registerView3(){
		return "/WEB-INF/register3.jsp";
	}
}
