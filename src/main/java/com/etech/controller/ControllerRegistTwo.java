package com.etech.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.etech.entity.Tgoodstype;
import com.etech.entity.Tmarket;
import com.etech.entity.Tshop;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.variable.Variables;
import com.etech.webutil.Brower;
import com.etech.webutil.LatitudeUtils;

@Controller
public class ControllerRegistTwo {
	private static final Log log = LogFactory.getLog(ControllerRegisterOne.class);
	@Resource
	private EtechService etechService;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/register2")
	public String registerView2(HttpServletRequest request,ServletResponse response){
		HttpSession session = request.getSession();
		Tshopuser shopuser=(Tshopuser)session.getAttribute(Variables.sessionUser);
		// the user unfinish the one step register,then jump the one step register page
		if(shopuser==null){
			String url="/register.jhtml";
			Brower.redirect(url, response);
		}
		List<Tgoodstype> gList = (List<Tgoodstype>)etechService.findObjectList(Tgoodstype.class);
		request.setAttribute("gList", gList);
		List<Tmarket> marketList=(List<Tmarket>)etechService.findObjectList(Tmarket.class);
		request.setAttribute("marketList", marketList);
		return "/WEB-INF/register2.jsp";
	}
	
	
	@RequestMapping(value="/dealRegister2")
	public void dealRegister2(Tshopuser shopuser,HttpServletRequest request,ServletResponse response){
		String shopuserId=request.getParameter("shopuserId");
		if(StringUtils.isEmpty(shopuserId)){
			Brower.redirect("/login.jhtml", response);
			return;
		}
		HttpSession session = request.getSession();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multipartRequest.getFileMap();
		String licenseImg = "";
		String shopImg="";
		String appendImg="";
		int count=0;
		for (MultipartFile file : files.values()) {
			InputStream inputStream;
			count++;
			try {
				
				inputStream = file.getInputStream();
				if(inputStream.available()==0)continue;
				String originName=file.getOriginalFilename();
				String extention = originName.substring(originName.lastIndexOf(".") + 1);
				log.debug("upload file name:"+file.getName());
				if(file.getName().equals("shopLicenseImg")){
				  // get the license save path
				  licenseImg=UUID.randomUUID()+"."+extention;
				  log.debug("upload path:"+Variables.shopLicenseImgPath+licenseImg);
				  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopLicenseImgPath+licenseImg));
				}else {
					shopImg=UUID.randomUUID()+"."+extention;
					FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopImgPath+shopImg));
					if(count==files.size()){
						appendImg+=shopImg;
					}else {
						appendImg+=shopImg+"#";
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.debug("shop image sava db url:"+appendImg);
		String goodsTypeId=request.getParameter("goodsTypeId");
		Tgoodstype goodstype=(Tgoodstype)etechService.findObject(Tgoodstype.class, Integer.valueOf(goodsTypeId));
		
		// get shop address from form
		String address=request.getParameter("address");
		Map<String, String> latitude = LatitudeUtils.getLatitude(address);
		String lat=latitude.get("lat");
		String lng=latitude.get("lng");
		// get shopName from form
		String shopName=request.getParameter("shopName");
		String marketId=request.getParameter("marketId");
		String shopOwnerName=request.getParameter("shopOwnerName");
		Tmarket market=(Tmarket)etechService.findObject(Tmarket.class, Integer.valueOf(marketId));
		Tshop shop=new Tshop();
		shop.setMarket(market);
		shop.setShopName(shopName);
		shop.setShopOwnerName(shopOwnerName);
		shop.setAddress(address);
		shop.setBusinessLicensePhotoUrl(licenseImg);
		shop.setIsRecommend(Variables.unRecommend);
		shop.setLatitude(Double.valueOf(lat));
		shop.setLongitude(Double.valueOf(lng));
		shop.setState((short)Variables.reviewing);
		shop.setAddTime(new Timestamp(System.currentTimeMillis()));
		shop.setViewCount(0);
		shop.setBePraisedCount(0);
		shop.setFansCount(0);
		shop.setShopPhotoUrl(appendImg);
		etechService.saveOrUpdate(shop);
		// shop goodstype many to many goodstype,mapped by goodstype
		shop.getGoodsTypes().add(goodstype);
		// shop shopusers many to many Tshopuser mapped by shopusers
		Tshopuser currentUser=(Tshopuser) etechService.findObject(Tshopuser.class,"shopUserId", Integer.valueOf(shopuserId));
		shop.getShopusers().add(currentUser);
		etechService.saveOrUpdate(shop);
		
		@SuppressWarnings("unchecked")
		List<Tshop> shops = (List<Tshop>) etechService.findObjectList(Tshop.class, Integer.parseInt(shopuserId));
		session.setAttribute("shops", shops);
		
		session.setAttribute(Variables.sessionUser, currentUser);
		Brower.redirect("/register3.jhtml", response);
	}
}
