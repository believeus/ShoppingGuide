package com.etech.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tshopsuser;
import com.etech.service.EtechService;
import com.etech.util.EtechGobal;
import com.etech.util.JsonOutToBrower;

public class ControllerRegister {

	private static final Log log = LogFactory.getLog(ControllerRegister.class);
	@Resource
	private EtechService etechService;

	/**
	 * Begin Author:wuqiwei Data:2014=05-26 Email:1058633117@qq.com
	 * AddReason:普通用户注册页面
	 */
	@RequestMapping(value = "/personalReg")
	public String personalRegister() {
		return "register/personalRegister";
	}

	/**
	 * Begin Author:wuqiwei Data:2014=05-26 Email:1058633117@qq.com
	 * AddReason:ajax判断一般用户的ajax验证
	 */
	@RequestMapping(value = "/ajaxComValidReg")
	public void ajaxComValidReg(Tshopsuser regUser,String submit ,String rpasswprd,
			String cpPhone, HttpSession session, HttpServletResponse response) {
		log.debug("current regUser reginName:" + regUser.getUserName());
		Tshopsuser sessionUser = (Tshopsuser) session.getAttribute("user");
		Map<String, Object> message = new HashMap<String, Object>();
		if (StringUtils.isEmpty(regUser.getUserName())) {
			message.put("property", "userName");
			message.put("message", "用户名必填!");
			JsonOutToBrower.out(message, response);
			return;
		}
		if(regUser.getUserName().equals(sessionUser.getUserName())){
			message.put("property", "userName");
			message.put("message", "用户名已存在！");
			JsonOutToBrower.out(message, response);
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
			JsonOutToBrower.out(message, response);
			return;
		}
		if (matches == true) {
			message.put("message", "手机号输入框隐藏");
			JsonOutToBrower.out(message, response);
			return;
		}
		if (regUser.getPhoneNumber().isEmpty()) {
			message.put("property", "phoneNumber");
			message.put("message", "手机号必须输入！");
			JsonOutToBrower.out(message, response);
			return;
		}
		// 用户注册
		if (StringUtils.isEmpty(sessionUser)) {
			if (StringUtils.isEmpty(regUser.getPassword())) {
				message.put("property", "password");
				message.put("message", "密码必填!");
				JsonOutToBrower.out(message, response);
				return;
			}
			if (StringUtils.isEmpty(rpasswprd)) {
				message.put("property", "comfirmPwd");
				message.put("message", "确定密码必填!");
				JsonOutToBrower.out(message, response);
				return;
			}
			if (!regUser.getPassword().equals(rpasswprd)) {
				message.put("property", "comfirmPwd");
				message.put("message", "密码和确定密码不一致!");
				JsonOutToBrower.out(message, response);
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
				JsonOutToBrower.out(message, response);
				return;
			}
			if (StringUtils.isEmpty(sessionUser)) {
				// 验证身份证号是否存在过
				Tshopsuser user = (Tshopsuser) etechService
						.findObjectByProperty(Tshopsuser.class,
								EtechGobal.idcard, regUser.getIdnumber());
				log.debug("idcard:" + regUser.getIdnumber());
				log.debug("current user:" + user);
				if (!StringUtils.isEmpty(user)) {
					message.put("property", "idcard");
					message.put("message", "身份证号已存在,请重新填写");
					JsonOutToBrower.out(message, response);
					return;
				}
				// 如果提交的表单中的性别和身份证计算的不一致,则返回身份证计算的性别
				int sexIndex = Integer.parseInt(regUser.getIdnumber()
						.substring(16, regUser.getIdnumber().length() - 1));
				String sex = sexIndex % 2 != 0 ? "man" : "woman";
				log.debug("sex:" + regUser.getGender());
				if (!regUser.getGender().equals(sex)) {
					message.put("sex", sex);
					JsonOutToBrower.out(message, response);
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
			Tshopsuser user = (Tshopsuser) etechService.findObjectByProperty(
					Tshopsuser.class, EtechGobal.loginName,
					regUser.getUserName());
			if (!StringUtils.isEmpty(user)) {
				message.put("property", "loginName");
				message.put("message", "用户名已存在");
				JsonOutToBrower.out(message, response);
				return;
			}
			// 用户编辑
		} else {
			Tshopsuser user = (Tshopsuser) etechService.findObjectByProperty(
					Tshopsuser.class, "id", regUser.getShopId());
			// 编辑用户名和原用户名不等
			if (!user.getUserName().equals(regUser.getUserName())) {
				user = (Tshopsuser) etechService.findObjectByProperty(
						Tshopsuser.class, EtechGobal.loginName,
						regUser.getUserName());
				if (!StringUtils.isEmpty(user)) {
					message.put("property", "loginName");
					message.put("message", "用户名已存在");
					JsonOutToBrower.out(message, response);
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
				Tshopsuser comUser = (Tshopsuser) etechService.findObjectById(
						Tshopsuser.class, regUser.getShopId());
				log.debug("regUser.id:" + regUser.getShopId());
				session.setAttribute("sessionUser", comUser);
				etechService.merge(regUser);
			}
			message.put("message", "success");
			JsonOutToBrower.out(message, response);
		} else {
			// 完成所有验证
			message.put("message", "finish");
			JsonOutToBrower.out(message, response);
		}
	}
	/**
	 * End Author:wuqiwei Data:2014=05-26 Email:1058633117@qq.com
	 * AddReason:ajax判断一般用户的ajax验证
	 */

}
