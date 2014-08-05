package com.etech.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.dao.EtechComDao;
import com.etech.entity.Tcity;
import com.etech.entity.Tphoneuser;
import com.etech.service.EtechOthersService;
import com.etech.service.EtechService;
import com.etech.webutil.Brower;

@Controller
public class ControllerFansCount {
	private static final Log log = LogFactory.getLog(ControllerFansCount.class);
	@Resource
	private EtechService etechService;
	@Resource
	private EtechOthersService etechOthersService;
	@Resource
	private EtechComDao etechComDao;
	
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
		log.debug("len"+len);
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
	
	@RequestMapping(value="/fansAreaCount")
	public String fansAreaCount(HttpServletRequest request,int id){
		//获取tcity对象
		Tcity city=(Tcity) etechComDao.findObject(Tcity.class, id);
		String name=city.getCityName();
		request.setAttribute("name", name);
		
		String[] pre=etechOthersService.getArea(id);
		int len=pre.length/2;
		String[] area=new String[len];
		String[] precent=new String[len];
		System.arraycopy(pre, 0, area, 0, len);
		System.arraycopy(pre, len, precent, 0, len);
		request.setAttribute("area", area);
		request.setAttribute("precent", precent);
		
		log.debug("area:1:"+area[0]+";2:"+area[1]);
		
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/shi")
	public void shi(HttpSession session,int sheng,HttpServletResponse response){
		Map<String, Object> message=new HashMap<String, Object>();
		List<Tcity> citys=(List<Tcity>) etechComDao.findObjectList(Tcity.class, "provinceId", sheng);
		session.setAttribute("citys", citys);
		if(!StringUtils.isEmpty(sheng)){
			message.put("property", "shi");
			message.put("message","success");
			Brower.outJson(message, response);
		}else{
			message.put("property", "shi");
			message.put("message","error");
			Brower.outJson(message, response);
		}
	}
	
}
