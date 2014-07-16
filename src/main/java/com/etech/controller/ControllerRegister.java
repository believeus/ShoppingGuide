package com.etech.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
import com.etech.webutil.Variables;
import com.etech.webutil.Brower;
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
	@RequestMapping(value="/achieveValidCode")
	public void achieveValidCode(String phoneNumber){
		log.debug("current phoneNumber:"+phoneNumber);
	}
	/**End Author:wuqiwei Data:2014-07-15 AddReason:获取手机验证码*/
	
	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:验证电话验证码是否一致*/
	public @ResponseBody String validateNumberCode(String phoneNumber,String numberCode){
		return "";
	}
	
	/**End Author:wuqiwei Data:2014-07-15 AddReason:验证电话验证码是否一致*/
	
	@RequestMapping(value = "/ajaxComValidReg")
	public void ajaxComValidReg(Tshopsuser regUser,String submit ,String rpasswprd,
			String cpPhone, HttpSession session, HttpServletResponse response) {
		log.debug("current regUser reginName:" + regUser.getUserName());
		Tshopsuser sessionUser = (Tshopsuser) session.getAttribute("user");
		Map<String, Object> message = new HashMap<String, Object>();
		if (StringUtils.isEmpty(regUser.getUserName())) {
			message.put("property", "userName");
			message.put("message", "用户名必填!");
			Brower.outJson(message, response);
			return;
		}
		if(regUser.getUserName().equals(sessionUser.getUserName())){
			message.put("property", "userName");
			message.put("message", "用户名已存在！");
			Brower.outJson(message, response);
			return;
		}
		boolean matches = regUser.getUserName().matches(
				"^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		boolean matches1 = regUser
				.getUserName()
				.matches(
						"^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		boolean matches2 = regUser.getUserName().matches("[a-zA-Z0-9]{6,}");
		if (matches == false && matches1 == false && matches2 == false) {
			message.put("property", "loginName");
			message.put("message", "用户名必须为手机号，或者邮箱，或者必须大于6位的字母数字组合");
			Brower.outJson(message, response);
			return;
		}
		if (matches == true) {
			message.put("message", "手机号输入框隐藏");
			Brower.outJson(message, response);
			return;
		}
		if (regUser.getPhoneNumber().isEmpty()) {
			message.put("property", "phoneNumber");
			message.put("message", "手机号必须输入！");
			Brower.outJson(message, response);
			return;
		}
		// 用户注册
		if (StringUtils.isEmpty(sessionUser)) {
			if (StringUtils.isEmpty(regUser.getPassword())) {
				message.put("property", "password");
				message.put("message", "密码必填!");
				Brower.outJson(message, response);
				return;
			}
			if (StringUtils.isEmpty(rpasswprd)) {
				message.put("property", "comfirmPwd");
				message.put("message", "确定密码必填!");
				Brower.outJson(message, response);
				return;
			}
			if (!regUser.getPassword().equals(rpasswprd)) {
				message.put("property", "comfirmPwd");
				message.put("message", "密码和确定密码不一致!");
				Brower.outJson(message, response);
				return;
			}
		}
		log.debug("Idcard:" + regUser.getIdnumber());
		if (!StringUtils.isEmpty(regUser.getIdnumber())) {
			// 身份证正则表达式
			boolean matcheIdCard1 = regUser
					.getIdnumber()
					.matches(
							"^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[A-Z])$");
			boolean matcheIdCard2 = regUser
					.getIdnumber()
					.matches(
							"/^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$/");
			// 身份证验证不匹配
			if (matcheIdCard1 == false && matcheIdCard2 == false) {
				message.put("property", "idcard");
				message.put("message", "身份证格式不对");
				Brower.outJson(message, response);
				return;
			}
			if (StringUtils.isEmpty(sessionUser)) {
				// 验证身份证号是否存在过
				Tshopsuser user = (Tshopsuser) etechService
						.findObject(Tshopsuser.class,
								Variables.idcard, regUser.getIdnumber());
				log.debug("idcard:" + regUser.getIdnumber());
				log.debug("current user:" + user);
				if (!StringUtils.isEmpty(user)) {
					message.put("property", "idcard");
					message.put("message", "身份证号已存在,请重新填写");
					Brower.outJson(message, response);
					return;
				}
				// 如果提交的表单中的性别和身份证计算的不一致,则返回身份证计算的性别
				int sexIndex = Integer.parseInt(regUser.getIdnumber()
						.substring(16, regUser.getIdnumber().length() - 1));
				String sex = sexIndex % 2 != 0 ? "man" : "woman";
				log.debug("sex:" + regUser.getGender());
				if (!regUser.getGender().equals(sex)) {
					message.put("sex", sex);
					Brower.outJson(message, response);
					return;
				} else {
					// 前台无论如何都要接受这个sex值，不可省略。
					message.put("sex", sex);
				}
				log.debug("phone" + cpPhone);

			}
		}
		// 用户注册
		if (StringUtils.isEmpty(sessionUser)) {
			Tshopsuser user = (Tshopsuser) etechService.findObject(
					Tshopsuser.class, Variables.loginName,
					regUser.getUserName());
			if (!StringUtils.isEmpty(user)) {
				message.put("property", "loginName");
				message.put("message", "用户名已存在");
				Brower.outJson(message, response);
				return;
			}
			// 用户编辑
		} else {
			Tshopsuser user = (Tshopsuser) etechService.findObject(
					Tshopsuser.class, "id", regUser.getShopUserId());
			// 编辑用户名和原用户名不等
			if (!user.getUserName().equals(regUser.getUserName())) {
				user = (Tshopsuser) etechService.findObject(
						Tshopsuser.class, Variables.loginName,
						regUser.getUserName());
				if (!StringUtils.isEmpty(user)) {
					message.put("property", "loginName");
					message.put("message", "用户名已存在");
					Brower.outJson(message, response);
					return;
				}
			}
		}
		// 表单点击提交
		if ("submit".equals(submit)) {
			// 注册
			if (StringUtils.isEmpty(sessionUser)) {
				String password = DigestUtils.md5Hex(regUser.getPassword());
				regUser.setPassword(password);
				// 编辑个人资料
			} else {
				// 如果用户修改个人资料，并修改了密码,更新密码
				if (!StringUtils.isEmpty(regUser.getPassword())) {
					String password = DigestUtils.md5Hex(regUser.getPassword());
					regUser.setPassword(password);
				} else {
					log.debug(sessionUser.getUserName() + ":"
							+ sessionUser.getPassword());
					regUser.setPassword(sessionUser.getPassword());
					log.debug(regUser.getPassword());
				}
			}
			

			// 用户注册
			if (StringUtils.isEmpty(sessionUser)) {
				// 只有从sessionFactory中获取的对象才能updata
				Tshopsuser comUser = (Tshopsuser) etechService.findObject(
						Tshopsuser.class, regUser.getShopUserId());
				log.debug("regUser.id:" + regUser.getShopUserId());
				session.setAttribute("sessionUser", comUser);
				etechService.merge(regUser);
			}
			message.put("message", "success");
			Brower.outJson(message, response);
		} else {
			// 完成所有验证
			message.put("message", "finish");
			Brower.outJson(message, response);
		}
	}
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
