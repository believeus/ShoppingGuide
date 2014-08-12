package com.etech.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.etech.dao.EtechComDao;
import com.etech.entity.Tcity;
import com.etech.entity.Tfeature;
import com.etech.entity.Tgoods;
import com.etech.entity.Tgoodspraisehistory;
import com.etech.entity.Tmarket;
import com.etech.entity.Tnews;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tprovince;
import com.etech.entity.Tphoneuser;
import com.etech.entity.Tphoneuserfeature;
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
	private EtechComDao etechComDao;
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
		List<Tgoods> tgoods1 = new ArrayList<Tgoods>();
		List<Tgoods> tgoods2 = new ArrayList<Tgoods>();
		List<Tgoods> tgoods3 = new ArrayList<Tgoods>();
		List<Tgoods> tgoods4 = new ArrayList<Tgoods>();
		for (int i = 0; i < tgLi.size(); i+=4) {
			tgoods1.add(tgLi.get(i));
			if (i+1 < tgLi.size()) {
				tgoods2.add(tgLi.get(i+1));
			}
			if (i+2 < tgLi.size()) {
				tgoods3.add(tgLi.get(i+2));
			}
			if (i+3 < tgLi.size()) {
				tgoods4.add(tgLi.get(i+3));
			}
		}
		request.setAttribute("tgoods1", tgoods1);
		request.setAttribute("tgoods2", tgoods2);
		request.setAttribute("tgoods3", tgoods3);
		request.setAttribute("tgoods4", tgoods4);
		
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
		String[] path = tshop.getShopPhotoUrl().split("#");
		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i]+"====path");
		}
		request.setAttribute("path", path);//shop msg
		
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
		
		String[] path = tshop.getShopPhotoUrl().split("#");
		request.setAttribute("path", path);//shop photo url
		
		List<Tgoodstype> range=(List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class,"parentId",10);
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
		Tshop shop = (Tshop) etechService.findObject(Tshop.class,"shopId", shopId);
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
					if(count>1){
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
		
		
		// get shopName from form
		String shopName=request.getParameter("shopName");
		
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
		shop.setShopDefaultPhotoWidth(0);
		shop.setShopDefaultPhotoHeight(0);
		// 这里会有八张全部都替换了
		if(!StringUtils.isEmpty(appendImg)){
			List<String> oldlist = new ArrayList<String>(Arrays.asList(shop.getShopPhotoUrl().split("#")));
			List<String> newList = new ArrayList<String>(Arrays.asList(appendImg.split("#")));
			oldlist.removeAll(newList);
			for (String string : oldlist) {
				appendImg+=string+"#"; 
			}
			shop.setShopPhotoUrl(appendImg);
		}
		String[] path = shop.getShopPhotoUrl().split("#");
		request.setAttribute("path", path);
		
		// shop goodstype many to many goodstype,mapped by goodstype
		String[] goodsTypeIds = request.getParameterValues("goodsTypeId");
		shop.getGoodsTypes().removeAll(shop.getGoodsTypes());
		for (String goodsTypeId : goodsTypeIds) {
			Tgoodstype goodstype=(Tgoodstype)etechService.findObject(Tgoodstype.class, Integer.valueOf(goodsTypeId));
			shop.getGoodsTypes().add(goodstype);
		}
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
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/hitPraise")
	public String hitPraise(HttpServletRequest request,Integer goodsId){
		//查找某商品的点赞记录(谁点赞查谁)
		List<Tgoodspraisehistory> gphs = (List<Tgoodspraisehistory>) etechService.findObjectList(Tgoodspraisehistory.class, "goodsId",goodsId);
		List<Tphoneuser> tphoneusers = new ArrayList<Tphoneuser>();
		for (Tgoodspraisehistory tgoodspraisehistory : gphs) {
			Tphoneuser puser = (Tphoneuser) etechService.findObject(Tphoneuser.class, "phoneUserId", tgoodspraisehistory.getPhoneUserId());
			tphoneusers.add(puser);
			List<Tphoneuserfeature> tpfs = (List<Tphoneuserfeature>) etechService.findObjectList(Tphoneuserfeature.class, "phoneUserId", tgoodspraisehistory.getPhoneUserId());
			for (Tphoneuserfeature tphoneuserfeature : tpfs) {
				tphoneuserfeature.getFeatureId();
			}
		}
		
		
		request.setAttribute("tphoneusers", tphoneusers);
		request.setAttribute("goodsId", goodsId);
		return "/WEB-INF/menu/hitPraise.jsp";
	}
	
	@RequestMapping("/changeNote")
	public String toChangeNote(int phoneUserId,String nickName){
		log.debug("phoneUserId"+":"+phoneUserId+";nickName:"+nickName);
		Tphoneuser user=(Tphoneuser) etechComDao.findObject(Tphoneuser.class,"phoneUserId", phoneUserId);
		user.setNickName(nickName);
		etechComDao.saveOrUpdata(user);
		
		return "/showFans.jhtml";
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
		request.setAttribute("size", news.size());
		
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
			return "/provinceCity.jhtml";
		}else if (url.equals("constellation")) {
			return "redirect:/fansConstellationCount.jhtml";
		}else if (url.equals("favourite")) {
			return "redirect:/fansFavouriteCount.jhtml";
		}else if (url.equals("job")) {
			return "redirect:/fansJobsCount.jhtml";
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
		@SuppressWarnings("unchecked")
		List<Tgoods> tgoods = (List<Tgoods>) etechService.findObjectList(Tgoods.class,"shopId",shopId);
		String[] paths = shop.getShopPhotoUrl().split("#");
		request.setAttribute("paths", paths);
		request.setAttribute("shop", shop);
		request.setAttribute("tgoods", tgoods);
		List<Tgoods> list1 = new ArrayList<Tgoods>();
		List<Tgoods> list2 = new ArrayList<Tgoods>();
		for (int i = 0; i < tgoods.size(); i+=2) {
			list1.add(tgoods.get(i));
			if (i+1 < tgoods.size()) {
				list2.add(tgoods.get(i+1));
			}
		}
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		
		
		return "/WEB-INF/menu/shopPreview.jsp";
	}
	
	/**
	 * 商品预览
	 * @return
	 */
	@RequestMapping(value = "/goodsPreview")
	public String goodsPreview(Integer tgoodsId,HttpServletRequest request){
		Tgoods tgoods = (Tgoods) etechService.findObject(Tgoods.class, "goodsId", tgoodsId);
		String[] path = tgoods.getGoodsPhotoUrl().split("#");
		Tshop shop = (Tshop) etechService.findObject(Tshop.class, "shopId", tgoods.getShopId());
		request.setAttribute("path", path);
		request.setAttribute("tgoods", tgoods);
		request.setAttribute("shop", shop);
		return "/WEB-INF/menu/goodsPreview.jsp";
		
	}
	/**
	 * for list of province and city
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/map")
	public String mapThree(HttpServletRequest request){
		
		List<Tprovince> province= (List<Tprovince>) etechComDao.findObjectList(Tprovince.class);
		request.setAttribute("province", province);
		
		int len=province.size();
		log.debug("length:"+len);
		List<List<Tcity>> allCity=new ArrayList<List<Tcity>>();
		for(int i=0;i<len;i++){
			int proId=province.get(i).getProvinceId();
			List<Tcity> citysList=(List<Tcity>) etechComDao.findObjectList(Tcity.class, "provinceId", proId);
			
			allCity.add(citysList);
		}
		request.setAttribute("allCity", allCity);
		
		return "/WEB-INF/menu/Map.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/provinceCity")
	public String provinceCity(HttpServletRequest request){
		
		List<Tprovince> province= (List<Tprovince>) etechComDao.findObjectList(Tprovince.class);
		request.setAttribute("province", province);
		
		return "/WEB-INF/menu/Map.jsp";
	}
	
	
	/**
	 * 删掉预览后不保存的商品
	 * @param goodsId
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/deletePro")
	public void delete(Integer goodsId,HttpServletRequest request, HttpServletResponse response) throws IOException{
		Tgoods tgoods = (Tgoods) etechService.findObject(Tgoods.class, "goodsId", goodsId);
		Integer shopId = tgoods.getShopId();
		etechService.delete(tgoods);//删掉商品
		response.sendRedirect("/myProducts.jhtml?shopId="+shopId);
	}
	
	/**
	 * update goods isOnSale
	 * @return
	 */
	@RequestMapping(value="/updateIsOnSale")
	public @ResponseBody void ajaxupdate(Integer goodsId,short isOnSale){
		etechService.update(goodsId,isOnSale);
	}
	
	/**
	 * 查找上架(下架)商品
	 * @param isOnSale
	 * @param shopId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/isOnSale")
	public String isOnSaleList(short isOnSale,Integer shopId,HttpServletRequest request){
		if (isOnSale == (short)1) {
			List<Tgoods> tgLi = etechService.findList(isOnSale,shopId);
			List<Tgoods> tgoods1 = new ArrayList<Tgoods>();
			List<Tgoods> tgoods2 = new ArrayList<Tgoods>();
			List<Tgoods> tgoods3 = new ArrayList<Tgoods>();
			List<Tgoods> tgoods4 = new ArrayList<Tgoods>();
			for (int i = 0; i < tgLi.size(); i+=4) {
				tgoods1.add(tgLi.get(i));
				if (i+1 < tgLi.size()) {
					tgoods2.add(tgLi.get(i+1));
				}
				if (i+2 < tgLi.size()) {
					tgoods3.add(tgLi.get(i+2));
				}
				if (i+3 < tgLi.size()) {
					tgoods4.add(tgLi.get(i+3));
				}
			}
			request.setAttribute("tgoods1", tgoods1);
			request.setAttribute("tgoods2", tgoods2);
			request.setAttribute("tgoods3", tgoods3);
			request.setAttribute("tgoods4", tgoods4);
			request.setAttribute("shopId", shopId);
			request.setAttribute("size", tgLi.size());
		}else if (isOnSale == (short)0) {
			List<Tgoods> tgLi = etechService.findList(isOnSale,shopId);
			List<Tgoods> tgoods1 = new ArrayList<Tgoods>();
			List<Tgoods> tgoods2 = new ArrayList<Tgoods>();
			List<Tgoods> tgoods3 = new ArrayList<Tgoods>();
			List<Tgoods> tgoods4 = new ArrayList<Tgoods>();
			for (int i = 0; i < tgLi.size(); i+=4) {
				tgoods1.add(tgLi.get(i));
				if (i+1 < tgLi.size()) {
					tgoods2.add(tgLi.get(i+1));
				}
				if (i+2 < tgLi.size()) {
					tgoods3.add(tgLi.get(i+2));
				}
				if (i+3 < tgLi.size()) {
					tgoods4.add(tgLi.get(i+3));
				}
			}
			request.setAttribute("tgoods1", tgoods1);
			request.setAttribute("tgoods2", tgoods2);
			request.setAttribute("tgoods3", tgoods3);
			request.setAttribute("tgoods4", tgoods4);
			request.setAttribute("shopId", shopId);
			request.setAttribute("size", tgLi.size());
		}
		return "/WEB-INF/menu/myProducts.jsp";
	}
	
	@RequestMapping(value="/selectGoodsType")
	public String selectGoodsType(HttpServletRequest request,Integer shopId){
		// Tgoodstype
		@SuppressWarnings("unchecked")
		List<Tgoodstype> gList = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class);
		request.setAttribute("gList", gList);
		request.setAttribute("shopId", shopId);
		return "/WEB-INF/menu/selectGoodsType.jsp";
	}
}
