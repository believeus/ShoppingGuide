package com.etech.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tphoneuser;
import com.etech.service.EtechOthersService;
import com.etech.service.EtechService;

@Controller
public class ControllerFansCount {
	private static final Log log = LogFactory.getLog(ControllerFansCount.class);
	@Resource
	private EtechService etechService;
	@Resource
	private EtechOthersService etechOthersService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/fansSexCount")
	public String fansSexCount(HttpServletRequest request){
		
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		log.debug("users:"+users);
		List sexCount=etechOthersService.findSexCount(users);
		request.setAttribute("manPrecent", sexCount.get(0));
		request.setAttribute("womanPrecent", sexCount.get(1));
		request.setAttribute("unknown", sexCount.get(2));
		
		return "/WEB-INF/menu/FansCount.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansAgeCount")
	public String fansAgeCount(HttpServletRequest request){
		
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		double[] ageCount=etechOthersService.getAge(users);
		request.setAttribute("ageCount", ageCount);
		
		return "/WEB-INF/menu/FansCountForAge.jsp";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/fansConstellationCount")
	public String fansConstellationCount(HttpServletRequest request){
		
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		
		Double[] constellat=etechOthersService.getConstellation(users);
		request.setAttribute("constellat", constellat);
		
		return "/WEB-INF/menu/FansCountForConstellation.jsp";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/fansCzCount")
	public String fansCZCount(HttpServletRequest request){
		
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		
		List cZPrecent=etechOthersService.getCZ(users);
		request.setAttribute("cZPrecent", cZPrecent);
		
		return "/WEB-INF/menu/FansCountForCZ.jsp";
	}
	
}
