package com.etech.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tfindpasswordforshopuser;
import com.etech.service.EtechService;
import com.etech.webutil.Brower;

@Controller
public class ControllerFindPsd {
	
	@Resource
	private EtechService etechService;
	
	
}
