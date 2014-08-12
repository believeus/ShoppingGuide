package com.etech.controller;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import com.etech.entity.Tshopuserlogin;
import com.etech.service.EtechService;
import com.etech.variable.Variables;
import com.etech.webutil.CookieUtil;

/**Begin Author:wuqiwei Data:2014-05-26 Email:1058633117@qq.com AddReason:用户登录业务逻辑 */
@Controller
public class ControllerLogin {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService etechService;
	@Resource
	private CookieUtil cookieUtil;
	@RequestMapping(value = "/ajaxLoginValid")
	public @ResponseBody String ajaxLoginValid(Tshopuser shopuser,HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		log.debug("current user phoneNumber:"+shopuser.getPhoneNumber());
		log.debug("current user passowrd:"+shopuser.getPassword());
		Tshopuser sessionUser = (Tshopuser) etechService.findObject(Tshopuser.class, Variables.phoneNumber, shopuser.getPhoneNumber());
			if(!StringUtils.isEmpty(sessionUser)){
				String oldPassword = DigestUtils.md5Hex(shopuser.getPassword());
				log.debug("sessionUser phoneNumber:"+sessionUser.getPhoneNumber()+" formUser phoneNumber:"+shopuser.getPhoneNumber());
				if(sessionUser.getPhoneNumber().equals(shopuser.getPhoneNumber())){
					String password =DigestUtils.md5Hex(shopuser.getPassword());
					log.debug(password);
					if(oldPassword.equals(password)){
						sessionUser.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
						Integer loginCount = sessionUser.getLoginCount();
						sessionUser.setLoginCount(loginCount++);
						Tshopuserlogin userLogin=new Tshopuserlogin();
						userLogin.setLoginTime(new Timestamp(System.currentTimeMillis()));
						userLogin.setLoginType(Variables.webLogin);
						String remoteIp = request.getHeader("X-Real-IP");
						userLogin.setIpaddress(remoteIp);
						userLogin.setShopuser(sessionUser);
						etechService.saveOrUpdate(userLogin);
						session.setAttribute(Variables.sessionUser,sessionUser);
						if(sessionUser.getShops().isEmpty()){
							return "/register2.jhtml";
						}
						String rememberme = request.getParameter("rememberme");
						if(!StringUtils.isEmpty(rememberme)){
							cookieUtil.saveCookie(shopuser.getPhoneNumber(), password, response);
						}
						return "/menu.jhtml";
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
	public String loginView(HttpServletRequest request,HttpServletResponse response){
		String referer = request.getHeader("Referer");
		if(!StringUtils.isEmpty(referer)&&referer.contains("logout.jhtml")){
			return "/WEB-INF/login.jsp";
		}
		try {
			boolean autoLogin = cookieUtil.autoLogin(request, response);
			if (autoLogin) {
				return "redirect:/menu.jhtml";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/WEB-INF/login.jsp";
	}
}
/**End Author:wuqiwei Data:2014-05-26 Email:1058633117@qq.com AddReason:用户登录业务逻辑 */