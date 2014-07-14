package com.etech.controller;

import java.io.PrintWriter;
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

@Controller
public class ControllerRegistSuccess {
	private static final Log log = LogFactory
			.getLog(ControllerRegistUserName.class);
	@Resource
	private EtechService etechService;
	/**
	 * Begin Author:yangQiXian Data:2014=07-03 AddReason:注册成功
	 */
	@RequestMapping(value = "/registSuccess")
	public void registSuccess(Tshopsuser regUser,String submit, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (!StringUtils.isEmpty(regUser)) {
			regUser.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
			regUser.setGrade(0);
			regUser.setNickName("爱乐逛");
			regUser.setPageView(0);
			regUser.setScore(0);
			// 只有从sessionFactory中获取的对象才能updata
			String userName = regUser.getUserName();
			Tshopsuser comUser = (Tshopsuser) etechService
					.findObjectByProperty(Tshopsuser.class, "userName",
							userName);
			// log.debug("regUser.id:" + regUser.getId());
			HttpSession session = request.getSession();
			session.setAttribute("sessionUser", comUser);
			etechService.merge(regUser);
			String url = "";
			StringBuilder sb = new StringBuilder();
			sb.append("<script type='text/javascript'>")
					.append("top.location.href=" + url).append("</script>");
			log.debug(sb.toString());
			PrintWriter pw = new PrintWriter(response.getOutputStream());
			pw.write(sb.toString());
			pw.close();
			log.debug("form userinfo,regist success");
		}
		/**
		 * End Author:yangQiXian Data:2014=07-03 AddReason:注册成功
		 */
	}
}
