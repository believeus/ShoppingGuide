package com.etech.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
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

import com.etech.dao.Page;
import com.etech.dao.Pageable;
import com.etech.entity.Tfeature;
import com.etech.entity.Tgoods;
import com.etech.entity.Tgoodspraisehistory;
import com.etech.entity.Tgoodsviewhistory;
import com.etech.entity.Tmarket;
import com.etech.entity.Tnews;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tphoneuser;
import com.etech.entity.Tshop;
import com.etech.entity.Tshopfavorite;
import com.etech.entity.Tshopfeature;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechOthersService;
import com.etech.service.EtechService;
import com.etech.variable.Variables;
import com.etech.webutil.ImageUtil;
import com.etech.webutil.LatitudeUtils;
import com.etech.webutil.PaginationUtil;
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
	@Resource
	private EtechOthersService etechOthersService;
	
	/**
	 * menu
	 * @return
	 */
	@RequestMapping(value="/menu")
	public String menuView(String phoneNumber,HttpServletRequest request,HttpSession session){
		
		Tshopuser sessionUser = (Tshopuser) session.getAttribute(Variables.sessionUser);
		sessionUser = (Tshopuser) userService.findObject(Tshopuser.class, "userName", sessionUser.getUserName());
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
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/myProducts")
	public String productView(HttpServletRequest request,Integer shopId){
		String pageNumber = request.getParameter("pageNumber");
		// 如果为空，则设置为1
		if (StringUtils.isEmpty(pageNumber)) {
			pageNumber="1";
		}
		Pageable pageable=new Pageable(Integer.valueOf(pageNumber),20);
		String hql = "from Tgoods as entity where entity.shopId ="+shopId+" order by id desc";
		Page<?> page = etechService.findObjectList(hql, pageable);
		
		List<Tgoods> tgLi = (List<Tgoods>) page.getContent();
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
		
		request.setAttribute("size",page.getTotal());
		request.setAttribute("shopId", shopId);
		// 分页
		PaginationUtil.pagination(request, page.getPageNumber(),page.getTotalPages(), 0);
		return "/WEB-INF/menu/myProducts.jsp";
	}
	
	/**
	 * 商品信息
	 * @param goodsId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/goodsMsg")
	public String goodsMsg(Integer goodsId,HttpServletRequest request){
		Tgoods tgoods = (Tgoods) etechService.findObject(Tgoods.class, goodsId);
		request.setAttribute("tgoods", tgoods);
		request.setAttribute("features", tgoods.getFeatures());
		request.setAttribute("goodsTypes", tgoods.getGoodsTypes());
		String[] paths = tgoods.getGoodsPhotoUrl().split(",");
		request.setAttribute("paths", paths);
		request.setAttribute("shopId", tgoods.getShopId());
		return "/WEB-INF/menu/goodsMsg.jsp";
	}
	
	/**
	 * 编辑商品
	 * @param goodsId
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/editGoods")
	public String editGoods(Integer goodsId,HttpServletRequest request){
		Tgoods tgoods = (Tgoods) etechService.findObject(Tgoods.class, goodsId);
		request.setAttribute("tgoods", tgoods);
		request.setAttribute("shopId", tgoods.getShopId());
		String[] paths = tgoods.getGoodsPhotoUrl().split(",");
		request.setAttribute("paths", paths);
		// Tgoodstype
		List<Tgoodstype> gList = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 10);
		request.setAttribute("gList", gList);
		// Tfeature
		List<Tfeature> tfeatures = (List<Tfeature>) etechService.findObjectList(Tfeature.class,"featureType",(short)0,"objectFlag","111");
		request.setAttribute("tfeatures", tfeatures);
		request.setAttribute("goodsTypes", tgoods.getGoodsTypes());
		request.setAttribute("tgoodsFeatures", tgoods.getFeatures());
		
		//-商品2级分类----------------------------
		List<Tgoodstype> gt1 = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 31);
		request.setAttribute("gt1", gt1);
		List<Tgoodstype> gt2 = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 32);
		request.setAttribute("gt2", gt2);
		List<Tgoodstype> gt3 = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 33);
		request.setAttribute("gt3", gt3);
		List<Tgoodstype> gt4 = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 34);
		request.setAttribute("gt4", gt4);
		List<Tgoodstype> gt5 = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 35);
		request.setAttribute("gt5", gt5);
		List<Tgoodstype> gt6 = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 36);
		request.setAttribute("gt6", gt6);
		List<Tgoodstype> gt7 = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 37);
		request.setAttribute("gt7", gt7);
		List<Tgoodstype> gt8 = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 38);
		request.setAttribute("gt8", gt8);
		List<Tgoodstype> gt9 = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 39);
		request.setAttribute("gt9", gt9);
		
		return "/WEB-INF/menu/goodsEdit.jsp";
	}
	
	/**
	 * 修改商品
	 * @param goodsId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateGoods")
	public String updateGoods(Integer goodsId,HttpServletRequest request){
		Tgoods tgoods = (Tgoods) etechService.findObject(Tgoods.class, goodsId);
		String deleteImgs = request.getParameter("deleteImgs");
		if (StringUtils.isEmpty(deleteImgs)) {
			deleteImgs="";
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multipartRequest.getFileMap();
		String goodsImg = "";
		String appendImg = "";
		for (MultipartFile file : files.values()) {
			InputStream inputStream;
			try {
			 inputStream = file.getInputStream();
			 if(inputStream.available()==0)continue;
			 String originName=file.getOriginalFilename();
			 String extention = originName.substring(originName.lastIndexOf(".") + 1);
			 log.debug("upload file name:"+file.getName());
		     // get the goods save path
			 // UUID randomUUID = UUID.randomUUID(); 
			  String GUID = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*1000000);
			  goodsImg=GUID+"."+extention;
			  String goodsImgSmall=Variables.goodsPhotoImgPath+tgoods.getShopId()+"/"+GUID+"_small."+extention;
			  log.debug("upload path:"+Variables.goodsPhotoImgPath+tgoods.getShopId()+"/"+goodsImg);
			  log.debug("upload small path :"+goodsImgSmall);
			  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.goodsPhotoImgPath+tgoods.getShopId()+"/"+goodsImg));
			  appendImg+= goodsImg+",";
	          //读入文件    
              File imgSmall = new File(Variables.goodsPhotoImgPath+tgoods.getShopId()+"/"+goodsImg);    
              // 构造Image对象    
              BufferedImage src = ImageIO.read(imgSmall);
              ImageUtil.scaleImg(Variables.goodsPhotoImgPath+tgoods.getShopId()+"/"+goodsImg, goodsImgSmall, src.getHeight(), Variables.imagewidth);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.debug("All path:"+appendImg);
		
		List<String> oldlist = new ArrayList<String>(Arrays.asList(tgoods.getGoodsPhotoUrl().split(",")));
		log.debug("tgoods.getGoodsPhotoUrl()--list:"+oldlist);
		List<String> deleteList = new ArrayList<String>(Arrays.asList(deleteImgs.split(",")));
		log.debug("deleteList:"+deleteList);
		oldlist.removeAll(deleteList);
		for (String string : oldlist) {
			appendImg+=string+","; 
		}
		log.debug("tgoods.getGoodsPhotoUrl()--list:"+appendImg);
		// 设置图片。
		tgoods.setGoodsPhotoUrl(appendImg);
		etechService.saveOrUpdate(tgoods);
		return "redirect:/goodsMsg.jhtml?goodsId="+tgoods.getGoodsId();
	}
	
	/**
	 * shop msg
	 * @return
	 */
	@RequestMapping(value="/shopMsg")
	public String shopMsg(Integer shopId,HttpServletRequest request){
		Tshop tshop = (Tshop) etechService.findObject(Tshop.class, shopId);
		request.setAttribute("tshop", tshop);//shop msg
		String[] path = tshop.getShopPhotoUrl().split(",");
		
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
		
		String[] path = tshop.getShopPhotoUrl().split(",");
		request.setAttribute("path", path);//shop photo url
		
		List<Tgoodstype> range=(List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class,"parentId",10);
		request.setAttribute("range", range);//shop range
		
		List<Tfeature> tfeatures = (List<Tfeature>) etechService.findObjectList(Tfeature.class, "featureType", (short)0,"objectFlag","111");
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
	 * @throws IOException 
	 */
	@RequestMapping(value="/updateShop")
	public String updateShop(Integer shopId, HttpServletRequest request) throws IOException{
		String shopuserId=request.getParameter("shopuserId");
		String lisenceId=request.getParameter("lisenceId");
		String featureIds=request.getParameter("featureIds");
		String deleteImgs = request.getParameter("deleteImgs");
		if (StringUtils.isEmpty(deleteImgs)) {
			deleteImgs="";
		}
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
				if(file.getName().equals("businessLicensePhoto")){
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
					shop.setShopDefaultPhotoHeight(height);
					shop.setShopDefaultPhotoWidth(width);
				}
			}
		}
		
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
			if (latitude == null) {
				shop.setLatitude(0d);
				shop.setLongitude(0d);
			}else {
				String lat=latitude.get("lat");
				String lng=latitude.get("lng");
				shop.setLatitude(Double.valueOf(lat));
				shop.setLongitude(Double.valueOf(lng));
				//shop.setAddress(address);
			}
		}else {
			Map<String, String> latitude = LatitudeUtils.getLatitude(address);
			if (latitude == null) {
				shop.setLatitude(0d);
				shop.setLongitude(0d);
			}else {
				String lat=latitude.get("lat");
				String lng=latitude.get("lng");
				shop.setLatitude(Double.valueOf(lat));
				shop.setLongitude(Double.valueOf(lng));
				//shop.setAddress(address);
			}
		} 
		String addressNew = request.getParameter("area");
		if (addressNew != null) {
			if (addressNew.equals(address)) {
				shop.setAddress(address);
			}else {
				shop.setAddress("其他");
			}
		}else {
			shop.setAddress("其他");
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
		List<String> oldlist = new ArrayList<String>(Arrays.asList(shop.getShopPhotoUrl().split(",")));
		log.debug("shop.getShopPhotoUrl()--list:"+oldlist);
		List<String> deleteList = new ArrayList<String>(Arrays.asList(deleteImgs.split(",")));
		log.debug("deleteList:"+deleteList);
		oldlist.removeAll(deleteList);
		for (String string : oldlist) {
			appendImg+=string+","; 
		}
		log.debug("shop.getShopPhotoUrl()--list:"+appendImg);
		shop.setShopPhotoUrl(appendImg);
		
		
		String[] path = shop.getShopPhotoUrl().split(",");
		request.setAttribute("path", path);
		
		// shop goodstype many to many goodstype,mapped by goodstype
		String[] goodsTypeIds = request.getParameterValues("goodsTypeId");
		shop.getGoodsTypes().removeAll(shop.getGoodsTypes());
		for (String goodsTypeId : goodsTypeIds) {
			Tgoodstype goodstype=(Tgoodstype)etechService.findObject(Tgoodstype.class, Integer.valueOf(goodsTypeId));
			shop.getGoodsTypes().add(goodstype);
		}
		shop.setState((short)0);
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
		//查找某商品的点赞记录
		List<Tgoodspraisehistory> gphs = (List<Tgoodspraisehistory>) etechService.findObjectList(Tgoodspraisehistory.class, "goodsId",goodsId);
		List<Tphoneuser> tphoneusers = new ArrayList<Tphoneuser>();
		List<Tfeature> tfeatures = new ArrayList<Tfeature>();
		
		List<List<String>> featurelist1=new ArrayList<List<String>>();
		List<List<String>> featurelist2=new ArrayList<List<String>>();
		List<List<String>> featurelist3=new ArrayList<List<String>>();
		for (Tgoodspraisehistory tgoodspraisehistory : gphs) {
			Tphoneuser puser = (Tphoneuser) etechService.findObject(Tphoneuser.class, "phoneUserId", tgoodspraisehistory.getPhoneUserId());
			tphoneusers.add(puser);
			for (int i = 0; i < gphs.size(); i++) {
				int id = puser.getPhoneUserId();
				List<String> feature= etechOthersService.findObject(id);
				int yu=(i+3)%3;
				if(yu == 0){
					featurelist1.add(feature);
				}else if(yu == 1){
					featurelist2.add(feature);
				}else{
					featurelist3.add(feature);
				}
			}
		}
		request.setAttribute("tphoneusers", tphoneusers);
		request.setAttribute("tfeatures", tfeatures);
		request.setAttribute("featurelist1", featurelist1);
		request.setAttribute("featurelist2", featurelist2);
		request.setAttribute("featurelist3", featurelist3);
		request.setAttribute("goodsId", goodsId);
		return "/WEB-INF/menu/hitPraise.jsp";
	}
	
	/**
	 * hit count
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/hitCount")
	public String hitCount(HttpServletRequest request,Integer goodsId){
		//查找某商品的浏览记录
		List<Tgoodsviewhistory> gphs = (List<Tgoodsviewhistory>) etechService.findObjectList(Tgoodsviewhistory.class, "goodsId",goodsId);
		List<Tphoneuser> tphoneusers = new ArrayList<Tphoneuser>();
		List<Tfeature> tfeatures = new ArrayList<Tfeature>();
		
		List<List<String>> featurelist1=new ArrayList<List<String>>();
		List<List<String>> featurelist2=new ArrayList<List<String>>();
		List<List<String>> featurelist3=new ArrayList<List<String>>();
		for (Tgoodsviewhistory tgoodsviewhistory : gphs) {
			Tphoneuser puser = (Tphoneuser) etechService.findObject(Tphoneuser.class, "phoneUserId", tgoodsviewhistory.getPhoneUserId());
			tphoneusers.add(puser);
			for (int i = 0; i < gphs.size(); i++) {
				int id = puser.getPhoneUserId();
				List<String> feature= etechOthersService.findObject(id);
				int yu=(i+3)%3;
				if(yu == 0){
					featurelist1.add(feature);
				}else if(yu == 1){
					featurelist2.add(feature);
				}else{
					featurelist3.add(feature);
				}
			}
		}
		request.setAttribute("tphoneusers", tphoneusers);
		request.setAttribute("tfeatures", tfeatures);
		request.setAttribute("featurelist1", featurelist1);
		request.setAttribute("featurelist2", featurelist2);
		request.setAttribute("featurelist3", featurelist3);
		request.setAttribute("goodsId", goodsId);
		return "/WEB-INF/menu/hitCount.jsp";
	}
	
	@RequestMapping("/changeNote")
	public @ResponseBody Map<String, Object> toChangeNote(int phoneUserId,String nickName){
		log.debug("phoneUserId"+":"+phoneUserId+";nickName:"+nickName);
		Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class,"phoneUserId", phoneUserId);
		user.setNickName(nickName);
		etechService.saveOrUpdate(user);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message", "success");
		data.put("user", user);
		return data;
	}
	
	/**
	 * my Fans
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/showFans")
	public String showFans(HttpServletRequest request,Integer shopId){
		Integer sid=shopId;
		List<Tshopfavorite> fans=(List<Tshopfavorite>) etechService.findObjectList(Tshopfavorite.class,"shopId",shopId);
		log.debug("length:"+fans.size());
		Map<Integer, Date> sortTimeMap=new HashMap<Integer, Date>();
		int len=fans.size();
		for(int i=0;i<len;i++){
			sortTimeMap.put(fans.get(i).getShopFavoriteId(), fans.get(i).getAddTime());
		}
		log.debug("sortSize:"+sortTimeMap.size());
		//sort by addTime
		List<Map.Entry<Integer, Date>> newest=new ArrayList<Map.Entry<Integer, Date>>(sortTimeMap.entrySet());
		Collections.sort(newest, new Comparator<Map.Entry<Integer, Date>>(){

			@Override
			public int compare(Entry<Integer, Date> o1, Entry<Integer, Date> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
			
		});
		//get the list of fans by nickname
		List<Tphoneuser> phoneFans=new ArrayList<Tphoneuser>();
		for(int i=0;i<len;i++){
			int sortId=newest.get(i).getKey();
			log.debug("sortId:"+sortId);
			for(int j=0;j<len;j++){
				int fansid=fans.get(j).getShopFavoriteId();
				log.debug("fansid:"+fansid);
				if(fansid == sortId){
					String nick=fans.get(j).getFansNickName();
					log.debug("nick:"+nick);
//					Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class, "nickName", nick);
//					
//					if(StringUtils.isEmpty(user)){
//						log.debug("找不到NickName为"+nick+"的用户！");
//					}else{
//						phoneFans.add(user);
//						log.debug("id:"+user.getPhoneUserId());
//					}
					List<Tphoneuser> user= (List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class, "nickName", nick);
					phoneFans.addAll(user);
					break;
				}
			}
		}
		//divide into three part
		log.debug("length:"+phoneFans.size());
		List<Tphoneuser> phoneuser1=new ArrayList<Tphoneuser>();
		List<Tphoneuser> phoneuser2=new ArrayList<Tphoneuser>();
		List<Tphoneuser> phoneuser3=new ArrayList<Tphoneuser>();
		int size=phoneFans.size();
		for(int i=0;i<size;i++){
			Tphoneuser user=phoneFans.get(i);
			int yu=(i+3)%3;
			if(yu == 0){
				phoneuser1.add(user);
			}else if(yu == 1){
				phoneuser2.add(user);
			}else{
				phoneuser3.add(user);
			}
		}
		request.setAttribute("phoneuser1", phoneuser1);
		request.setAttribute("phoneuser2", phoneuser2);
		request.setAttribute("phoneuser3", phoneuser3);
		
		List<List<String>> featurelist1=new ArrayList<List<String>>();
		List<List<String>> featurelist2=new ArrayList<List<String>>();
		List<List<String>> featurelist3=new ArrayList<List<String>>();
		for(int i=0;i<size;i++){
			int id=phoneFans.get(i).getPhoneUserId();
			log.debug("phoneUserId:"+id);
			List<String> feature= etechOthersService.findObject(id);
			log.debug("length:"+feature.size());
			
			int yu=(i+3)%3;
			if(yu == 0){
				featurelist1.add(feature);
			}else if(yu == 1){
				featurelist2.add(feature);
			}else{
				featurelist3.add(feature);
			}
			
			log.debug("fSize:"+featurelist1.size()+";2:"+featurelist1.size()+";3:"+featurelist3.size());
		}
		log.debug("shopId:"+sid);
		request.setAttribute("shopId", sid);
		request.setAttribute("featurelist1", featurelist1);
		request.setAttribute("featurelist2", featurelist2);
		request.setAttribute("featurelist3", featurelist3);
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
			String content2 = content.replaceAll("<[^>]+>", "");
			tnews.setContent(content2);
//			etechService.saveOrUpdate(tnews);
//			news.add(tnews);
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
	public String FansCount(String url,Integer shopId){
		if (url.equals("sex")) {
			return "redirect:/fansSexCount.jhtml?shopId="+shopId;
		}else if (url.equals("age")) {
			return "redirect:/fansAgeCount.jhtml?shopId="+shopId;
		}else if (url.equals("area")) {
			return "/provinceCity.jhtml?shopId="+shopId;
		}else if (url.equals("constellation")) {
			return "redirect:/fansConstellationCount.jhtml?shopId="+shopId;
		}else if (url.equals("favourite")) {
			return "redirect:/fansFavouriteCount.jhtml?shopId="+shopId;
		}else if (url.equals("job")) {
			return "redirect:/fansJobsCount.jhtml?shopId="+shopId;
		}else if (url.equals("CZ")) {
			return "redirect:/fansCzCount.jhtml?shopId="+shopId;
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
		String[] paths = shop.getShopPhotoUrl().split(",");
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
		String[] path = tgoods.getGoodsPhotoUrl().split(",");
		Tshop shop = (Tshop) etechService.findObject(Tshop.class, "shopId", tgoods.getShopId());
		request.setAttribute("path", path);
		request.setAttribute("tgoods", tgoods);
		request.setAttribute("shop", shop);
		return "/WEB-INF/menu/goodsPreview.jsp";
		
	}
	
	
	@RequestMapping(value="/provinceCity")
	public String provinceCity(HttpServletRequest request,Integer shopId){
		
		return "redirect:/fansAreaCount.jhtml?shopId="+shopId+"&cityId="+159;
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
