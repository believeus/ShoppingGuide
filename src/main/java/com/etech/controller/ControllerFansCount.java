package com.etech.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.dao.EtechComDao;
import com.etech.entity.Tcity;
import com.etech.entity.Tphoneuser;
import com.etech.entity.Tprovince;
import com.etech.service.EtechOthersService;
import com.etech.service.EtechService;

@Controller
public class ControllerFansCount {
	private static final Log log = LogFactory.getLog(ControllerFansCount.class);
	@Resource
	private EtechService etechService;
	@Resource
	private EtechOthersService etechOthersService;
	@Resource
	private EtechComDao etechComDao;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansSexCount")
	public String fansSexCount(HttpServletRequest request){
		
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		log.debug("users:"+users);
		double[] sexCount=etechOthersService.findSexCount(users);
		request.setAttribute("manPrecent", sexCount[0]);
		request.setAttribute("womanPrecent", sexCount[1]);
		request.setAttribute("unknown", sexCount[2]);
		
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansConstellationCount")
	public String fansConstellationCount(HttpServletRequest request){
		
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		
		Double[] constellat=etechOthersService.getConstellation(users);
		request.setAttribute("constellat", constellat);
		
		return "/WEB-INF/menu/FansCountForConstellation.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansCzCount")
	public String fansCZCount(HttpServletRequest request){
		
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		
		Double[] cZPrecent=etechOthersService.getCZ(users);
		request.setAttribute("cZPrecent", cZPrecent);
		
		return "/WEB-INF/menu/FansCountForCZ.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansJobsCount")
	public String fansJobsCount(HttpServletRequest request){
		
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		
		String[] arr=etechOthersService.getJob(users);
		int len=arr.length/2;
		log.debug("len:"+len);
		String[] name=new String[len];
		String[] pre=new String[len];
		System.arraycopy(arr, 0, name, 0, len);
		System.arraycopy(arr, len, pre, 0, len);
		
		request.setAttribute("name", name);
		log.debug("name:1:"+name[0]+";2:"+name[1]);
		log.debug("pre:1:"+pre[0]+";2:"+pre[1]);
		request.setAttribute("pre", pre);
		
		return "/WEB-INF/menu/FansCountForJob.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansAreaCount")
	public String fansAreaCount(HttpServletRequest request,int cityId){
		//获取tcity对象
		Tcity city=(Tcity) etechComDao.findObject(Tcity.class, cityId);
		String cityName=city.getCityName();
		request.setAttribute("cityName", cityName);
		
		String[] pre=etechOthersService.getArea(cityId);
		int len=pre.length/2;
		String[] area=new String[len];
		String[] precent=new String[len];
		System.arraycopy(pre, 0, area, 0, len);
		System.arraycopy(pre, len, precent, 0, len);
		request.setAttribute("area", area);
		request.setAttribute("precent", precent);
		
		log.debug("area:1:"+area[0]+";2:"+area[1]);
		
		List<Tprovince> province= (List<Tprovince>) etechComDao.findObjectList(Tprovince.class);
		request.setAttribute("province", province);
		
		return "/WEB-INF/menu/FansCountForArea.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansFavouriteCount")
	public String fansFavouriteCount(HttpServletRequest request){
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		
		String[] combine=etechOthersService.getFavourite(users);
		int len=combine.length/2;
		String[] fname=new String[len];
		String[] fper=new String[len];
		System.arraycopy(combine, 0, fname, 0, len);
		System.arraycopy(combine, len, fper, 0, len);
		request.setAttribute("fname", fname);
		request.setAttribute("fper", fper);
		
		return "/WEB-INF/menu/FansCountForFavourite.jsp";
	}
	
}
