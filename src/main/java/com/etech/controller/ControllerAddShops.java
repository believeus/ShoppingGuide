package com.etech.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.service.EtechService;

@Controller
public class ControllerAddShops {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService etechService;
	
	@RequestMapping(value="/addShops")
	public String loginView(){
		return "/main/addShops.jsp";
	}
}
