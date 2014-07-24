package com.etech.controller;

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
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;

/**Begin Author:wuqiwei Data:2014-05-26 Email:1058633117@qq.com AddReason:用户登录业务逻辑 */
@Controller
public class ControllerLogin {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService userService;
	
	@RequestMapping(value = "/ajaxLoginValid")
	public @ResponseBody String ajaxLoginValid(Tshopuser formUser, HttpServletResponse response,HttpSession session) throws Exception {
		log.debug("current user name:"+formUser.getUserName());
		log.debug("current user passowrd:"+formUser.getPassword());
		Tshopuser sessionUser = (Tshopuser) userService.findObject(Tshopuser.class, "userName", formUser.getUserName());
			if(!StringUtils.isEmpty(sessionUser)){
				String oldPassword = DigestUtils.md5Hex(formUser.getPassword());
				if(sessionUser.getUserName().equals(formUser.getUserName())){
					String password =DigestUtils.md5Hex(formUser.getPassword());
					log.debug(password);
					if(oldPassword.equals(password)){
						return "success";
					}
				}else {
					return "error";
				}
			}else{
				return "error";
			}
			return "error";
		
	}
	
	@RequestMapping(value="/login")
	public String loginView(){
		return "/WEB-INF/login.jsp";
	}
}
/**End Author:wuqiwei Data:2014-05-26 Email:1058633117@qq.com AddReason:用户登录业务逻辑 */