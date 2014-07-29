package com.etech.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
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

import com.etech.entity.Tfeature;
import com.etech.entity.Tgoods;
import com.etech.entity.Tmarket;
import com.etech.entity.Tnews;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tshop;
import com.etech.entity.Tshopfeature;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.variable.Variables;
import com.etech.webutil.LatitudeUtils;
/**
 * menu
 * @author ztx
 *
 */

@Controller
public class ControllerMenu {
	private static final Log log = LogFactory.getLog(ControllerRegisterOne.class);
	@Resource
	private EtechService etechService;
	@Resource
	private EtechService userService;
	
	/**
	 * menu
	 * @return
	 */
	@RequestMapping(value="/menu")
	public String menuView(String phoneNumber,HttpServletRequest request,HttpSession session){
		
		Tshopuser sessionUser = (Tshopuser) session.getAttribute(Variables.sessionUser);
		sessionUser = (Tshopuser) userService.findObject(Tshopuser.class, "phoneNumber", sessionUser.getPhoneNumber());
		if (sessionUser != null) {
			List<Tshop> shops = sessionUser.getShops();
			request.setAttribute("shops", shops);
		}
		return "/WEB-INF/menu/menu.jsp";
	}
	
	/**
	 * my shop
	 * @return
	 */
	@RequestMapping(value="/myShop")
	public String shopView(Integer shopId,HttpServletRequest request){
		Tshop shop = (Tshop) etechService.findObject(Tshop.class, shopId);
		request.setAttribute("shop", shop);
		System.out.println(shop.getShopName()+"=name");
		return "/WEB-INF/menu/myShop.jsp";
	}
	/**
	 * my goods
	 * @return
	 */
	@RequestMapping(value="/myProducts")
	public String productView(HttpServletRequest request,Integer shopId){
		@SuppressWarnings("unchecked")
		List<Tgoods> tgLi = (List<Tgoods>) etechService.findObjectList(Tgoods.class,"shopId",shopId);
		request.setAttribute("tgLi", tgLi);
		request.setAttribute("size", tgLi.size());
		request.setAttribute("shopId", shopId);
		return "/WEB-INF/menu/myProducts.jsp";
	}
	/**
	 * shop msg
	 * @return
	 */
	@RequestMapping(value="/shopMsg")
	public String shopMsg(Integer shopId,HttpServletRequest request){
		Tshop tshop = (Tshop) etechService.findObject(Tshop.class, shopId);
		request.setAttribute("tshop", tshop);//shop msg
		
//		List<Tfeature> tfeatures = (List<Tfeature>) etechService.findObjectList(Tfeature.class);
		List<Tfeature> tfeatures = tshop.getFeatures();
		request.setAttribute("features", tfeatures);//shop tfeatures
		
		log.debug("SHOW SHOPINFO");
		return "/WEB-INF/menu/shopMessage.jsp";
	}
	/**
	 * edit shop msg
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/editShopMsg")
	public String editShopMsg(HttpServletRequest request,Integer shopId){
		
		Tshop tshop = (Tshop) etechService.findObject(Tshop.class, shopId);
		request.setAttribute("tshop", tshop);//shop msg
		List<Tgoodstype> range=(List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class);
		request.setAttribute("range", range);//shop range
		
		List<Tfeature> tfeatures = (List<Tfeature>) etechService.findObjectList(Tfeature.class);
		request.setAttribute("features", tfeatures);//shop tfeatures
		
		List<Tfeature> shopfeatures = tshop.getFeatures();
		request.setAttribute("shopfeatures", shopfeatures);//shop tfeatures
		
		List<Tmarket> marketList = (List<Tmarket>) etechService.findObjectList(Tmarket.class);
		request.setAttribute("marketList", marketList);//shop market
		
		List<Tgoodstype> tgoodstypes = tshop.getGoodsTypes();
		request.setAttribute("tgoodstypes", tgoodstypes);
		
		return "/WEB-INF/menu/editShop.jsp";
	}
	
	/**
	 * update shop
	 * @return
	 */
	@RequestMapping(value="/updateShop")
	public String updateShop(Integer shopId, HttpServletRequest request){
		String shopuserId=request.getParameter("shopuserId");
		String lisenceId=request.getParameter("lisenceId");
		String featureIds=request.getParameter("featureIds");
		System.out.println(featureIds);
		// delete before relationship for shop and feature
		etechService.delete(Tshopfeature.class,"shopId",shopId);
		
		List<Tfeature> tfeatures = new ArrayList<Tfeature>();
		if(!featureIds.isEmpty()){
			for (String featureId : featureIds.split(",")) {
				Tshopfeature shopfeature=new Tshopfeature();
				shopfeature.setFeatureId(Integer.parseInt(featureId));
				shopfeature.setShopId(shopId);
				shopfeature.setAddTime(new Timestamp(System.currentTimeMillis()));
				etechService.merge(shopfeature);
				Tfeature tfeature = (Tfeature) etechService.findObject(Tfeature.class, "featureId", Integer.parseInt(featureId));
				tfeatures.add(tfeature);
			} 
		}
		HttpSession session = request.getSession();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multipartRequest.getFileMap();
		int count=0;
		String licenseImg = "";
		String appendImg="";
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
				  licenseImg=UUID.randomUUID()+"."+extention;
				  log.debug("upload path:"+Variables.shopLicenseImgPath+licenseImg);
				  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopLicenseImgPath+licenseImg));
				}else {
					shopImg=UUID.randomUUID()+"."+extention;
					FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopImgPath+shopImg));
					if(count==files.size()){
						appendImg+=shopImg+"#";
					}else {
						appendImg+=shopImg;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.debug("shop image sava db url:"+appendImg);
		String goodsTypeId=request.getParameter("goodsTypeId");
		Tgoodstype goodstype=(Tgoodstype)etechService.findObject(Tgoodstype.class, Integer.valueOf(goodsTypeId));
		
		// get shopName from form
		String shopName=request.getParameter("shopName");
		Tshop shop = (Tshop) etechService.findObject(Tshop.class,"shopId", shopId);
		Tshopuser sessionUser = (Tshopuser) etechService.findObject(Tshopuser.class, Integer.parseInt(shopuserId));
		String marketId=request.getParameter("marketId");
		Tmarket market=(Tmarket)etechService.findObject(Tmarket.class, Integer.valueOf(marketId));
		shop.setMarket(market);
		shop.setShopName(shopName);
		shop.setShopOwnerName(sessionUser.getNickName());
		// get shop address from form
		String address=request.getParameter("address");
		if (address.equals("")) {
			address = shop.getAddress();
			Map<String, String> latitude = LatitudeUtils.getLatitude(address);
			String lat=latitude.get("lat");
			String lng=latitude.get("lng");
			shop.setLatitude(Double.valueOf(lat));
			shop.setLongitude(Double.valueOf(lng));
			shop.setAddress(address);
		}else {
			Map<String, String> latitude = LatitudeUtils.getLatitude(address);
			String lat=latitude.get("lat");
			String lng=latitude.get("lng");
			shop.setLatitude(Double.valueOf(lat));
			shop.setLongitude(Double.valueOf(lng));
			shop.setAddress(address);
		}
		String priceRange = request.getParameter("priceRange");
		shop.setPriceRange(priceRange);
		String phoneNum = request.getParameter("phoneNum");
		shop.setPhoneNumber(phoneNum);
		shop.setBusinessLicenseNo(lisenceId);
		if (!StringUtils.isEmpty(licenseImg)) {
			log.debug("licenseImg:"+licenseImg);
			shop.setBusinessLicensePhotoUrl(licenseImg);
		}
		shop.setIsRecommend(Variables.unRecommend);
		
		shop.setState((short)Variables.reviewing);
		shop.setAddTime(new Timestamp(System.currentTimeMillis()));
		shop.setViewCount(0);
		shop.setBePraisedCount(0);
		shop.setFansCount(0);
		// 这里会有八张全部都替换了
		if(!StringUtils.isEmpty(appendImg)){
			shop.setShopPhotoUrl(appendImg);
		}
		// shop goodstype many to many goodstype,mapped by goodstype
		shop.getGoodsTypes().removeAll(shop.getGoodsTypes());
		shop.getGoodsTypes().add(goodstype);
		etechService.saveOrUpdate(shop);//更新 

		session.setAttribute(Variables.sessionUser, sessionUser);
		request.setAttribute("tshop", shop);
		request.setAttribute("features", tfeatures);
		return "/WEB-INF/menu/shopMessage.jsp";
	}
	/**
	 * hit praise
	 * @return
	 */
	@RequestMapping(value="/hitPraise")
	public String hitPraise(){
		return "/WEB-INF/menu/hitPraise.jsp";
	}
	/**
	 * my Fans
	 * @return
	 */
	@RequestMapping(value="/myFans")
	public String myFans(HttpServletRequest request){
		return "/WEB-INF/menu/myFans.jsp";
	}
	/**
	 * information
	 * @return
	 */
	@RequestMapping(value="/information")
	public String information(HttpServletRequest request,Integer newsId){
		Tnews news = (Tnews) etechService.findObject(Tnews.class, newsId);
		request.setAttribute("news", news);
		return "/WEB-INF/menu/Information.jsp";
	}
	/**
	 * information list
	 * @return
	 */
	@RequestMapping(value="/infoList")
	public String infoList(HttpServletRequest request){
		
		@SuppressWarnings("unchecked")
		//select all news from tNews
		List<Tnews> news = (List<Tnews>) etechService.findObjectList(Tnews.class);
		
		for (Tnews tnews : news) {
			String content = tnews.getContent();
			if (content.length() >30) {
				content = content.substring(0,news.size()) +"...";
			}
		}
		request.setAttribute("news", news);
		
		return "/WEB-INF/menu/InfoList.jsp";
	}
	
	/**
	 * the Statistics of Fans
	 * @return
	 */
	@RequestMapping(value = "/fansCount")
	public String FansCount(String url){
		if (url.equals("sex")) {
			return "redirect:/fansSexCount.jhtml";
		}else if (url.equals("age")) {
			return "redirect:/fansAgeCount.jhtml";
		}else if (url.equals("area")) {
			return "/WEB-INF/menu/FansCountForArea.jsp";
		}else if (url.equals("constellation")) {
			return "redirect:/fansConstellationCount.jhtml";
		}else if (url.equals("favourite")) {
			return "/WEB-INF/menu/FansCountForFavourite.jsp";
		}else if (url.equals("job")) {
			return "/WEB-INF/menu/FansCountForJob.jsp";
		}else if (url.equals("CZ")) {
			return "redirect:/fansCzCount.jhtml";
		}else{
			return "/login.jhtml";
		}
	}
	@RequestMapping(value="/associate")
	public String associate(){
		
		return "/WEB-INF/setting/aboutUserNum.jsp";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value="/editPassword")
	public String editPassword(){
		
		return "/WEB-INF/setting/updatePsd.jsp";
	}
	
	/**
	 * 找回密码
	 * @return
	 */
	@RequestMapping(value="/toFindPsd")
	public String findPsd(){
		return "/WEB-INF/setting/findPsd.jsp";
	}
	
	/**
	 * 店铺添加
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addShop")
	public String loginView(HttpServletRequest request){
		
		List<Tgoodstype> range=(List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class);
		request.setAttribute("range", range);
		List<Tmarket> marketList=(List<Tmarket>)etechService.findObjectList(Tmarket.class);
		request.setAttribute("marketList", marketList);
		return "/WEB-INF/menu/addShop.jsp";
	}
	
	/**
	 * 店铺预览
	 * @return
	 */
	@RequestMapping(value = "/shopPreview")
	public String shopPreview(Integer shopId,HttpServletRequest request){
		Tshop shop =  (Tshop) etechService.findObject(Tshop.class, "shopId", shopId);
		request.setAttribute("shop", shop);
		return "/WEB-INF/menu/shopPreview.jsp";
	}
	
	/**
	 * 商品预览
	 * @return
	 */
	@RequestMapping(value = "goodsPreview")
	public String goodsPreview(Integer tgoodsId,HttpServletRequest request){
		Tgoods tgoods = (Tgoods) etechService.findObject(Tgoods.class, "goodsId", tgoodsId);
		request.setAttribute("tgoods", tgoods);
		return "/WEB-INF/menu/goodsPreview.jsp";
	}
	
}
