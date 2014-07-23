package com.etech.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tfeature;
import com.etech.entity.Tshop;
import com.etech.entity.Tshopfeature;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.webutil.Brower;

@Controller
public class ControllerRegistThree {
	private static final Log log = LogFactory.getLog(ControllerRegister.class);
	@Resource
	private EtechService etechService;
	/**Begin Author:yangQiXian Data:2014-07-17 AddReason:添加商品特色到数据库*/
	@RequestMapping(value = "/saveFeature")
	public void saveFeature(String featureIds,HttpServletRequest request,ServletResponse response){
		 log.debug("featureIds:"+featureIds);
		  String userId=request.getParameter("sessionUserId");
		  log.debug("userId:"+userId);
		  if(StringUtils.isEmpty(userId)){
			  String url="/login.jhtml";
			  Brower.redirect(url, response);
			  return;
		  }
		  Tshopuser shopuser=(Tshopuser)etechService.findObject(Tshopuser.class, Integer.parseInt(userId));
		  List<Tshop> shops = shopuser.getShops();
		 for (String featureId : featureIds.split(",")) {
			Tfeature feature=(Tfeature)etechService.findObject(Tfeature.class, Integer.valueOf(featureId));
			log.debug("feature.name:"+feature.getFeatureName());
			for (Iterator<Tshop> iterator = shops.iterator(); iterator.hasNext();) {
				Tshop tshop = (Tshop) iterator.next();
				Tshopfeature shopfeature=new Tshopfeature();
				shopfeature.setShopFeatureId(feature.getFeatureId());
				shopfeature.setShopId(tshop.getShopId());
				shopfeature.setAddTime(new Timestamp(System.currentTimeMillis()));
				etechService.merge(shopfeature);
			}
		 }
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("msg", "success");
		Brower.outJson(map, response);
		
	}
	/**End Author:yangQiXian Data:2014-07-17 AddReason:添加商品特色到数据库*/
	
	
}
