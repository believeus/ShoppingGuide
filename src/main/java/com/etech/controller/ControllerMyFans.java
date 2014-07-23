package com.etech.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tphoneuser;
import com.etech.service.EtechService;

@Controller(value="/showMyfans")
public class ControllerMyFans {
	
	@Resource
	private EtechService etechService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/showFans")
	public String showFans(HttpSession session){
		
		List<Tphoneuser> fans=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		
		session.setAttribute("fans", fans);
		
		return "/WEB-INF/menu/myFans.jsp";
	}

}
