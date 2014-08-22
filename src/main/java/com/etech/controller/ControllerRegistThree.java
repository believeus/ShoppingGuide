package com.etech.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etech.entity.Tfeature;
import com.etech.entity.Tshop;
import com.etech.entity.Tshopfeature;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.variable.Variables;

@Controller
public class ControllerRegistThree {
	private static final Log log = LogFactory.getLog(ControllerRegisterOne.class);
	@Resource
	private EtechService etechService;
	
	
	@RequestMapping(value="/register3")
	public String registerView3(HttpServletRequest request,ServletResponse response){
		HttpSession session = request.getSession();
		Integer shopUserId=((Tshopuser)session.getAttribute(Variables.sessionUser)).getShopUserId();
		 Tshopuser shopuser=(Tshopuser)etechService.findObject(Tshopuser.class, shopUserId);
		// the user unfinish the one step register,then jump to one step /register.jhtml
		if(shopuser==null){
			return "redirect:/register.jhtml";
		// the user unfinish the second step register,then jump to one step /register2.jhtml
		}else if(shopuser.getShops().isEmpty()){
			return "redirect:/register2.jhtml";
		}
		@SuppressWarnings("unchecked")
//		List<Tfeature> tList = (List<Tfeature>)etechService.findObjectList(Tfeature.class, "featureType",new Short((short) 0));
//		List<Tfeature> tList = (List<Tfeature>)etechService.findObjectList(Tfeature.class,"featureType", (short)0);
		List<Tfeature> tList = (List<Tfeature>)etechService.findObjectList(Tfeature.class,"featureType", (short)0,"objectFlag","111");
		request.setAttribute("tList", tList);
		return "/WEB-INF/register3.jsp";
	}
	
	@RequestMapping(value="/insertFeature")
	public @ResponseBody String insertFeature(String feature,ServletResponse response){
		Tfeature tfeature=new Tfeature();
		tfeature.setFeatureName(feature);
		tfeature.setFeatureType((short)1);
		tfeature.setObjectFlag("111");
		tfeature.setCount(0);
		etechService.saveOrUpdate(tfeature);
		return tfeature.getFeatureId()+"";
	}
	
	@RequestMapping(value = "/saveFeature")
	public @ResponseBody String saveFeature(String featureIds,HttpServletRequest request,ServletResponse response){
		 log.debug("featureIds:"+featureIds);
		  String userId=request.getParameter("sessionUserId");
		  log.debug("userId:"+userId);
		  if(StringUtils.isEmpty(userId)){
			return "error";
		  }
		  Tshopuser shopuser=(Tshopuser)etechService.findObject(Tshopuser.class, Integer.parseInt(userId));
		  List<Tshop> shops = shopuser.getShops();
		  List<Tfeature> tfeatures = new ArrayList<Tfeature>();
		 for (String featureId : featureIds.split(",")) {
			Tfeature feature=(Tfeature)etechService.findObject(Tfeature.class, Integer.valueOf(featureId));
			tfeatures.add(feature);
			log.debug("feature.name:"+feature.getFeatureName());
			for (Iterator<Tshop> iterator = shops.iterator(); iterator.hasNext();) {
				Tshop tshop = (Tshop) iterator.next();
				Tshopfeature shopfeature=new Tshopfeature();
				shopfeature.setFeatureId(feature.getFeatureId());
				shopfeature.setShopId(tshop.getShopId());
				shopfeature.setAddTime(new Timestamp(System.currentTimeMillis()));
				etechService.merge(shopfeature);
				String shopFeature = "";
				for (int i = 0; i < tfeatures.size(); i++) {
					if (i==tfeatures.size()-1) {
						shopFeature += tfeatures.get(i).getFeatureName();
					}else {
						shopFeature += tfeatures.get(i).getFeatureName()+",";
					}
				}
				tshop.setShopFeature(shopFeature);
				tshop.setShopFeatureIds(featureIds);
				etechService.saveOrUpdate(tshop);
			}
		 }
		return "success";
	}
}
