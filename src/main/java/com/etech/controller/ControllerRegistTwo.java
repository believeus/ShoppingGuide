package com.etech.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
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
import com.etech.webutil.ImageUtil;
import com.etech.webutil.LatitudeUtils;
import com.etech.webutil.WebServiceQRCode;

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
		List<Tgoodstype> gList = (List<Tgoodstype>)etechService.findObjectList(Tgoodstype.class,"parentId",10);
		request.setAttribute("gList", gList);
		List<Tmarket> marketList=(List<Tmarket>)etechService.findObjectList(Tmarket.class);
		request.setAttribute("marketList", marketList);
		return "/WEB-INF/register2.jsp";
	}
	
	
	@RequestMapping(value="/dealRegister2")
	public void dealRegister2(Tshopuser shopuser,HttpServletRequest request,ServletResponse response) throws IOException{
		String shopuserId=request.getParameter("shopuserId");
		Tshopuser user = (Tshopuser) etechService.findObject(Tshopuser.class, "shopUserId", Integer.parseInt(shopuserId));
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
//			UUID randomUUID = UUID.randomUUID();
			String GUID = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*1000000);
			InputStream inputStream;
			count++;
			try {
				inputStream = file.getInputStream();
				if(inputStream.available()==0)continue;
				String originName=file.getOriginalFilename();
				String extention = originName.substring(originName.lastIndexOf(".") + 1);
				log.debug("upload file name:"+file.getName());
				String path="";
				String smallPath="";
				if(file.getName().equals("shopLicenseImg")){
				  // get the license save path
				  licenseImg=GUID+"."+extention;
				  path=Variables.shopLicenseImgPath+licenseImg;
				  // 缩略图
				  smallPath=Variables.shopLicenseImgPath+GUID+"_small."+extention;
				  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopLicenseImgPath+licenseImg));
				  
				}else {
					shopImg=GUID+"."+extention;
					path=Variables.shopImgPath+shopImg;
					// 缩略图
					smallPath=Variables.shopImgPath+GUID+"_small."+extention;
					FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopImgPath+shopImg));
					
					if(count>1){
						appendImg+=shopImg+",";
					}else {
						appendImg+=shopImg;
					}
				}
				 log.debug("upload path:"+path);
				 
	              //读入文件    
				  File imgSmall= new File(path);    
	              // 构造Image对象    
	              BufferedImage src = ImageIO.read(imgSmall);
	              ImageUtil.scaleImg(path, smallPath, src.getHeight(), Variables.imagewidth);
	              
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.debug("shop image sava db url:"+appendImg);
		
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
		//店铺默认图片
		String moren = request.getParameter("moren");
		if (!StringUtils.isEmpty(moren)) {
			String[] shopImgPath = appendImg.split(",");
			for (int i = 0; i < shopImgPath.length; i++) {
				if(i == Integer.parseInt(moren)){
					shop.setShopDefaultPhotoURL((shopImgPath[i]));
					String defaultPhoto = Variables.shopImgPath+shopImgPath[i];
					//读入文件    
					File imgSmall= new File(defaultPhoto);    
					// 构造Image对象    
					BufferedImage src = ImageIO.read(imgSmall);
					//获取默认图片宽高
					Integer width = src.getWidth();
					Integer height = src.getHeight();
					if (width == null) {
						shop.setShopDefaultPhotoHeight(0);
					}else {
						shop.setShopDefaultPhotoHeight(height);
					}
					if (height == null) {
						shop.setShopDefaultPhotoWidth(0);
					}else {
						shop.setShopDefaultPhotoWidth(width);
					}
				}
			}
		}else {
			shop.setShopDefaultPhotoHeight(0);
			shop.setShopDefaultPhotoWidth(0);
		}
		shop.setMarket(market);
		shop.setPriceRange(request.getParameter("priceRange"));
		shop.setBusinessLicenseNo(request.getParameter("businessLicenseNo"));
		shop.setShopName(shopName);
		shop.setShopOwnerName(shopOwnerName);
		String addressNew = request.getParameter("area");
		/*if (addressNew.equals(address)) {
			shop.setAddress(address);
		}else {
			shop.setAddress("其他");
		}*/
		String str1 = addressNew.substring(0,addressNew.indexOf("区")+1);
		String str2 = address.substring(0,address.indexOf("区")+1);
		String are = "其他";
		if(str1.equals(str2)){
			are = address.substring(address.indexOf("区")+1);
			shop.setAddress(are);
		}else{
			shop.setAddress(are);
		}
		shop.setBusinessLicensePhotoUrl(licenseImg);
		shop.setIsRecommend(Variables.unRecommend);
		shop.setLatitude(Double.valueOf(lat));
		shop.setLongitude(Double.valueOf(lng));
		shop.setState((short)Variables.reviewing);
		shop.setAddTime(new Timestamp(System.currentTimeMillis()));
		shop.setViewCount(0);
		shop.setBePraisedCount(0);
		shop.setFansCount(0);
		shop.setPhoneNumber(user.getPhoneNumber());
		shop.setShopPhotoUrl(appendImg);
		String qq = request.getParameter("qq");
		if(qq != null){
			shop.setQq(qq);
		}else {
			shop.setQq("10000");
		}
		etechService.saveOrUpdate(shop);
		user.setDefaultShopId(shop.getShopId());
		etechService.saveOrUpdate(user);
		// shop goodstype many to many goodstype,mapped by goodstype
		String[] goodsTypeIds = request.getParameterValues("goodsTypeId");
		String shopBusinessScopeIds = "";
		for (int i = 0; i < goodsTypeIds.length; i++) {
			if (i==goodsTypeIds.length-1) {
				shopBusinessScopeIds += goodsTypeIds[i];
			}else {
				shopBusinessScopeIds += goodsTypeIds[i] +",";
			}
		}
		shop.setShopBusinessScopeIds(shopBusinessScopeIds);
		for (String goodsTypeId : goodsTypeIds) {
			Tgoodstype goodstype=(Tgoodstype)etechService.findObject(Tgoodstype.class, Integer.valueOf(goodsTypeId));
			shop.getGoodsTypes().add(goodstype);
		}
		List<String> bs = new ArrayList<String>();
		List<Tgoodstype> goodsTypes = shop.getGoodsTypes();
		for (Tgoodstype tgoodstype : goodsTypes) {
			String tgoodsTypeName = tgoodstype.getGoodsTypeName();
			bs.add(tgoodsTypeName);
		}
		String shopBusinessScope = "";
		for (int i = 0; i < bs.size(); i++) {
			if (i==bs.size()-1) {
				shopBusinessScope += bs.get(i);
			}else {
				shopBusinessScope += bs.get(i) +",";
			}
		}
 		shop.setShopBusinessScope(shopBusinessScope);
		// shop shopusers many to many Tshopuser mapped by shopusers
		Tshopuser currentUser=(Tshopuser) etechService.findObject(Tshopuser.class,"shopUserId", Integer.valueOf(shopuserId));
		shop.getShopusers().add(currentUser);
		etechService.saveOrUpdate(shop);
		String qrCode = WebServiceQRCode.getQRCode(shop.getShopId()+"");
		shop.setQrcode(qrCode);
		etechService.saveOrUpdate(shop);
		
		/*@SuppressWarnings("unchecked")
		List<Tshop> shops = (List<Tshop>) etechService.findObjectList(Tshop.class,"phoneNumber", Integer.valueOf(user.getPhoneNumber()));
		session.setAttribute("shops", shops);*/
		
		session.setAttribute(Variables.sessionUser, currentUser);
		Brower.redirect("/register3.jhtml", response);
	}
}
