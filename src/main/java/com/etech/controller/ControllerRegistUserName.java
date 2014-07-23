package com.etech.controller;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.webutil.Brower;
@Controller
public class ControllerRegistUserName {
	private static final Log log = LogFactory
			.getLog(ControllerRegistUserName.class);
	@Resource
	private EtechService etechService;
	/**
	 * Begin Author:yangQiXian Data:2014=07-02 AddReason:ajax判断用户名的ajax验证
	 */
	@RequestMapping(value = "/ajaxRegValidateUserName")
	public void ajaxComValidUserName(Tshopuser regUser,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.debug("current regUser reginName:" + regUser.getUserName());
		String userName = regUser.getUserName();
		Tshopuser sessionUser = (Tshopuser) etechService.findObject(Tshopuser.class, "userName", userName);
		Map<String, Object> message = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(sessionUser)) {
			if (regUser.getUserName().equals(sessionUser.getUserName())) {
				message.put("property", "userName");
				message.put("message", "userNameError");
				Brower.outJson(message, response);
				return;
			}
		} 
	}
	/**
	 * Begin Author:yangQiXian Data:2014=07-06 AddReason:用户注册页面
	 */
	@RequestMapping(value = "/regist")
	public String personalRegister() {
		return "/main/regist.jsp";
	}
}
/**
 * End Author:yangQiXian Data:2014=07-02 AddReason:ajax判断用户名的ajax验证
 */

