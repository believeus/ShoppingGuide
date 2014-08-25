package com.etech.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.etech.entity.Tgoodstype;
import com.etech.entity.Tmarket;
import com.etech.entity.Tshop;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.webutil.LatitudeUtils;
import com.etech.variable.Variables;

@Controller
public class ControllerAddShops {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService etechService;
	@Resource
	private EtechService userService;
	
	@RequestMapping(value="/addShopDetails")

//	public String addShop(Tshopbusinessscope bscope,Tshop newShop,String shopName,String businessRange,String priceRange,String businessLicense,HttpServletRequest request,HttpSession session){
//		String[] range=businessRange.split(",");
//		for(int i=0;i<range.length;i++){
//			List gType=(List) etechService.findObject(Tgoodstype.class, "GoodsTypeName", range[i]);
//			int goodType=gType.getGoodsTypeId();
//			bscope.setShopId(newShop.getShopId());
//			bscope.setGoodsTypeId(goodType);
//			etechService.saveOrUpdate(bscope);
//		}

	public String addShop(HttpServletRequest request,HttpServletResponse response){
		String shopuserId=request.getParameter("shopuserId");
		String lisenceId=request.getParameter("lisenceId");
		HttpSession session = request.getSession();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multipartRequest.getFileMap();
		String licenseImg = "";
		String shopImg=""; 
		for (MultipartFile file : files.values()) {
			InputStream inputStream;
			try {
				
				inputStream = file.getInputStream();
				if(inputStream.available()==0)continue;
				String originName=file.getOriginalFilename();
				String extention = originName.substring(originName.lastIndexOf(".") + 1);
				log.debug("upload file name:"+file.getName());
				if(file.getName().equals("shopLicenseImg")){
				  // get the license save path
				  licenseImg=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*1000000)+"."+extention;
				  log.debug("upload path:"+Variables.shopLicenseImgPath+licenseImg);
				  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopLicenseImgPath+licenseImg));
				}else {
					shopImg=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*1000000)+"."+extention;
					FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopImgPath+shopImg));
					shopImg+=",";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.debug("shop image sava db url:"+shopImg);
		String goodsTypeId=request.getParameter("goodsTypeId");
		Tgoodstype goodstype=(Tgoodstype)etechService.findObject(Tgoodstype.class, Integer.valueOf(goodsTypeId));
		
		// get shop address from form
		String address=request.getParameter("address");
		Map<String, String> latitude = LatitudeUtils.getLatitude(address);
		String lat=latitude.get("lat");
		String lng=latitude.get("lng");
		// get shopName from form
		String shopName=request.getParameter("shopName");
		
		Tshopuser tshopuser = (Tshopuser) etechService.findObject(Tshopuser.class, Integer.parseInt(shopuserId));
		
		String marketId=request.getParameter("marketId");
		Tmarket market=(Tmarket)etechService.findObject(Tmarket.class, Integer.valueOf(marketId));
		Tshop shop=new Tshop();
		shop.setMarket(market);
		shop.setShopName(shopName);
		shop.setShopOwnerName(tshopuser.getRealName());
		shop.setAddress(address);
		shop.setBusinessLicenseNo(lisenceId);
		shop.setBusinessLicensePhotoUrl(licenseImg);
		shop.setIsRecommend(Variables.unRecommend);
		shop.setLatitude(Double.valueOf(lat));
		shop.setLongitude(Double.valueOf(lng));
		shop.setState((short)Variables.reviewing);
		shop.setAddTime(new Timestamp(System.currentTimeMillis()));
		shop.setViewCount(0);
		shop.setBePraisedCount(0);
		shop.setFansCount(0);
		shop.setShopPhotoUrl(shopImg);
		etechService.saveOrUpdate(shop);
		// shop goodstype many to many goodstype,mapped by goodstype
		shop.getGoodsTypes().add(goodstype);
		// shop shopusers many to many Tshopuser mapped by shopusers
		Tshopuser currentUser=(Tshopuser) etechService.findObject(Tshopuser.class,"shopUserId", Integer.valueOf(shopuserId));
		shop.getShopusers().add(currentUser);
		etechService.saveOrUpdate(shop);

		session.setAttribute(Variables.sessionUser, currentUser);
		
		Tshopuser user = (Tshopuser) userService.findObject(Tshopuser.class, Integer.parseInt(shopuserId));
		List<Tshop> shops = user.getShops();
		session.setAttribute("shops", shops);
		
		return "/WEB-INF/menu/menu.jsp";
	}
}
