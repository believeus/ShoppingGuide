package com.etech.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import com.etech.service.EtechService;

@Controller
public class ControllerFindPsd {
	
	@Resource
	private EtechService etechService;
	
	public String findPsd(HttpServletRequest request){
		return "";
	}
}
