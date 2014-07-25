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
import com.etech.variable.Variables;

/**Begin Author:wuqiwei Data:2014-05-26 Email:1058633117@qq.com AddReason:用户登录业务逻辑 */
@Controller
public class ControllerLogin {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService userService;
	
	@RequestMapping(value = "/ajaxLoginValid")
	public @ResponseBody String ajaxLoginValid(Tshopuser shopuser, HttpServletResponse response,HttpSession session) throws Exception {
		log.debug("current user name:"+shopuser.getUserName());
		log.debug("current user passowrd:"+shopuser.getPassword());
		Tshopuser sessionUser = (Tshopuser) userService.findObject(Tshopuser.class, "userName", shopuser.getUserName());
			if(!StringUtils.isEmpty(sessionUser)){
				String oldPassword = DigestUtils.md5Hex(shopuser.getPassword());
				if(sessionUser.getUserName().equals(shopuser.getUserName())){
					String password =DigestUtils.md5Hex(shopuser.getPassword());
					log.debug(password);
					if(oldPassword.equals(password)){
						session.setAttribute(Variables.sessionUser,sessionUser);
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