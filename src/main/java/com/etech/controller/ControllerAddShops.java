package com.etech.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tbusinessscope;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tshop;
import com.etech.service.EtechService;
import com.etech.webutil.Variables;

@Controller
public class ControllerAddShops {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService etechService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/addShopDetails")
	public String addShop(Tbusinessscope bscope,Tshop newShop,String shopName,String businessRange,String priceRange,String businessLicense,HttpServletRequest request,HttpSession session){
		
		
//		String[] range=businessRange.split(",");
//		for(int i=0;i<range.length;i++){
//			List gType=(List) etechService.findObject(Tgoodstype.class, "GoodsTypeName", range[i]);
//			int goodType=gType.getGoodsTypeId();
//			bscope.setShopId(newShop.getShopId());
//			bscope.setGoodsTypeId(goodType);
//			etechService.saveOrUpdate(bscope);
//		}
		
		
		//页面已经传过来的值
		newShop.setShopName(shopName);
		newShop.setPriceRange(priceRange);
		
		//值可以从页传过来
		newShop.setAddress(new String("光谷"));
		newShop.setFansCount(12);
		newShop.setLatitude(12.1);
		newShop.setLongitude(1.5);
		//可以通过session找到信息
//		Tshopsuser user=(Tshopsuser) session.getAttribute("formUser");
//		newShop.setShopOwnerName(user.getUserName());
		newShop.setShopOwnerName("BFBFB");
		//设置默认值
		newShop.setAddTime(new Timestamp(System.currentTimeMillis()));
		newShop.setBePraisedCount(Variables.bePraisedCount);
		newShop.setIsRecommend(Variables.isRecommend);
		newShop.setState(Variables.state);
		newShop.setViewCount(Variables.initViewCount);
		//还有一些属性可以为空值，可以通过页面传值
		newShop.setBusinessLicenseNo(businessLicense);
		
//		etechService.saveOrUpdate(newShop);
		
		List<Tshop> allShop=(List<Tshop>) etechService.findObjectList(Tshop.class);
		request.setAttribute("allShop", allShop);
		
		return "/WEB-INF/menu/menu.jsp";
	}
}
