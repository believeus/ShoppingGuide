package com.etech.controller;

import java.sql.Timestamp;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.etech.entity.Tshopsuser;
import com.etech.service.EtechService;
import com.etech.webutil.Brower;
import com.etech.webutil.Variables;

@Controller
public class ControllerRegistSuccess {
	private static final Log log = LogFactory.getLog(ControllerRegistUserName.class);
	@Resource
	private EtechService etechService;
	/**
	 * Begin Author:yangQiXian Data:2014=07-03 AddReason:注册成功
	 */
	@RequestMapping(value = "/registSuccess")
	public void registSuccess(Tshopsuser shopsuser, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (!StringUtils.isEmpty(shopsuser)) {
			HttpSession session = request.getSession();
			shopsuser.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
			shopsuser.setGrade((short) 0);;
			shopsuser.setNickName("爱乐逛");
			shopsuser.setPageView(0);
			shopsuser.setScore(0);
			etechService.saveOrUpdate(shopsuser);
			session.setAttribute(Variables.sessionUser, shopsuser);
			String url = "";
			Brower.redirect(url, response);
		}
		/**
		 * End Author:yangQiXian Data:2014=07-03 AddReason:注册成功
		 */
	}
}
