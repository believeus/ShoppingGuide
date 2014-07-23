package com.etech.controller;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.etech.webutil.Brower;

@Controller
public class ControllerLogout {
	private static final Log log = LogFactory.getLog(ControllerLogout.class);
	
	@RequestMapping(value="/logout")
	public void logout(HttpSession session,ServletResponse response){
		session.invalidate();
		log.debug("current operate logout");
		Brower.redirect("/login.jhtml", response);
	}
	
	
}
