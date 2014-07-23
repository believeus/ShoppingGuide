package com.etech.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tshop;
import com.etech.service.EtechService;

@Controller
public class ControllerShowShopInfo {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService etechService;
	/**Begin Author:yangQiXian Data:2014-07-21 AddReason:显示商铺信息*/
//	@RequestMapping(value = "/ShowShopInfo")
//	public void ShowShopInfo(Integer ShopId,HttpServletRequest request){
//		if(ShopId>0){
//			Tshop tshop = (Tshop) etechService.findObject(Tshop.class, ShopId);
//			request.setAttribute("tshop", tshop);
//			
//		}
//		
//	}
	/**End Author:yangQiXian Data:2014-07-21 AddReason:显示商铺信息*/
	
	/**Begin Author:sunao Data:2014-07-22 AddReason:显示商铺信息*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ShowShopInfo")
	public String ShowShopInfo(HttpServletRequest request){
		List<Tshop> allShop=(List<Tshop>) etechService.findObjectList(Tshop.class);
		request.setAttribute("allShop", allShop);
		return "/WEB-INF/menu/menu.jsp";
	}
	/**End Author:sunao Data:2014-07-22 AddReason:显示商铺信息*/
}
