package com.etech.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.etech.entity.Tfeature;
import com.etech.entity.Tgoods;
import com.etech.entity.Tgoodsfeature;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.variable.Variables;

@Controller
public class ControllerGoodsAdd {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService etechService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/goodsAdd")
	public String addGoodsView(HttpServletRequest request,Integer shopId) {
		// Tgoodstype
		List<Tgoodstype> gList = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class,"hasChild",(short)1);
		request.setAttribute("gList", gList);
		// Tfeature
		List<Tfeature> tfeatures = (List<Tfeature>) etechService.findObjectList(Tfeature.class);
		request.setAttribute("tfeatures", tfeatures);
		request.setAttribute("shopId", shopId);
		
		return "/WEB-INF/menu/goodsAdd.jsp";
	}

	@RequestMapping(value = "/goodsAdd2")
	public String addGoodsView2(HttpServletRequest request,Integer shopId) {
		request.setAttribute("shopId", shopId);
		return "/WEB-INF/menu/goodsAdd2.jsp";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addDetailedGoods")
	public String addGoods(Tgoods tGoods, HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Tshopuser sessionUser = (Tshopuser) session.getAttribute(Variables.sessionUser);
		String featureIds=request.getParameter("featureIds");
		//goods feature
		List<Tfeature> tfeatures = new ArrayList<Tfeature>();
		
		if (!StringUtils.isEmpty(tGoods)) {
			tGoods.setPublishUserId(sessionUser.getShopUserId());
			tGoods.setAddTime(new Timestamp(System.currentTimeMillis()));
			tGoods.setBePraisedCount(0);
			tGoods.setViewCount(0);
			tGoods.setShopId(Integer.parseInt(request.getParameter("shopId")));
			tGoods.setExamineState((short) 0);
			tGoods.setIsOnSale((short) 1);
			tGoods.setIsRecommend(Variables.unRecommend);
			tGoods.setIntroduction(request.getParameter("goodsDetail"));
			tGoods.setGoodsName(request.getParameter("goodsName"));
			tGoods.setPublishFlag((short) 0);
			tGoods.setModifyState((short)0);
			String goodsTypeId=request.getParameter("goodsTypeId");
			Tgoodstype goodstype=(Tgoodstype)etechService.findObject(Tgoodstype.class, Integer.valueOf(goodsTypeId));
			tGoods.getGoodsTypes().removeAll(tGoods.getGoodsTypes());
			tGoods.getGoodsTypes().add(goodstype);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = multipartRequest.getFileMap();
			String goodsImg = "";
			String shopImg=""; 
			for (MultipartFile file : files.values()) {
				InputStream inputStream;
				try {
					
					inputStream = file.getInputStream();
					if(inputStream.available()==0)continue;
					String originName=file.getOriginalFilename();
					String extention = originName.substring(originName.lastIndexOf(".") + 1);
					log.debug("upload file name:"+file.getName());
					if(file.getName().equals("goodsImg")){
					  // get the goods save path
					  goodsImg=UUID.randomUUID()+"."+extention;
					  log.debug("upload path:"+Variables.goodsPhotoImgPath+goodsImg);
					  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.goodsPhotoImgPath+goodsImg));
					}else {
						shopImg=UUID.randomUUID()+"."+extention;
						FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopImgPath+shopImg));
						shopImg+="#";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			log.debug("shop image sava db url:"+shopImg);
			System.out.println(goodsImg+"=goodsImg");
			if(goodsImg ==""){
				tGoods.setGoodsPhotoUrl("95f220ae-8a37-45a8-8d26-0629897b9f4b.jpg");
			}else {
				tGoods.setGoodsPhotoUrl(goodsImg);
			}
			etechService.saveOrUpdate(tGoods);
			if(!featureIds.isEmpty()){
				for (String featureId : featureIds.split(",")) {
					Tgoodsfeature goodsfeature=new Tgoodsfeature();
					goodsfeature.setFeatureId(Integer.parseInt(featureId));
					goodsfeature.setGoodsId(tGoods.getGoodsId());
					goodsfeature.setAddTime(new Timestamp(System.currentTimeMillis()));
					etechService.merge(goodsfeature);
					Tfeature tfeature = (Tfeature) etechService.findObject(Tfeature.class, "featureId", Integer.parseInt(featureId));
					tfeatures.add(tfeature);
				} 
			}
			//tGoods.setFeatures(tfeatures);
			List<Tgoods> tgLi = (List<Tgoods>) etechService.findObjectList(Tgoods.class, "shopId",Integer.parseInt(request.getParameter("shopId")));
			request.setAttribute("tgLi", tgLi);
			request.setAttribute("size", tgLi.size());
			request.setAttribute("shopId", request.getParameter("shopId"));
//			response.sendRedirect("/myProducts.jhtml?shopId="+tGoods.getShopId());
			response.sendRedirect("/goodsPreview.jhtml?tgoodsId="+tGoods.getGoodsId());
			return "/WEB-INF/menu/myProducts.jsp";
		} else {
			return "/WEB-INF/login.jsp";
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addSimpleGoods")
	public String addSimpleGoods(Tgoods tGoods, HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		//Tshopuser sessionUser = (Tshopuser) session.getAttribute(Variables.sessionUser);
		String shopId = request.getParameter("shopId");
		if (!StringUtils.isEmpty(tGoods)) {
			tGoods.setGoodsName("");
			tGoods.setPublishUserId(2);
			tGoods.setAddTime(new Timestamp(new Date().getTime()));
			tGoods.setBePraisedCount(0);
			tGoods.setViewCount(0);
			tGoods.setShopId(Integer.parseInt(shopId));
			tGoods.setExamineState((short) 0);
			tGoods.setIsOnSale((short) 1);
			tGoods.setPublishFlag((short) 1);
			tGoods.setIsRecommend(Variables.unRecommend);
			tGoods.setIntroduction(request.getParameter("goodsDetail"));
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = multipartRequest.getFileMap();
			String goodsImg = "";
			String shopImg=""; 
			for (MultipartFile file : files.values()) {
				InputStream inputStream;
				try {
					
					inputStream = file.getInputStream();
					if(inputStream.available()==0)continue;
					String originName=file.getOriginalFilename();
					String extention = originName.substring(originName.lastIndexOf(".") + 1);
					log.debug("upload file name:"+file.getName());
					if(file.getName().equals("goodsImg")){
					  // get the goods save path
					  goodsImg=UUID.randomUUID()+"."+extention;
					  log.debug("upload path:"+Variables.goodsPhotoImgPath+goodsImg);
					  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.goodsPhotoImgPath+goodsImg));
					}else {
						shopImg=UUID.randomUUID()+"."+extention;
						FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopImgPath+shopImg));
						shopImg+="#";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			log.debug("shop image sava db url:"+shopImg);
			tGoods.setGoodsPhotoUrl(goodsImg);
			etechService.saveOrUpdate(tGoods);
			
			List<Tgoods> tgLi = (List<Tgoods>) etechService.findObjectList(Tgoods.class, "shopId",Integer.parseInt(shopId));
			request.setAttribute("tgLi", tgLi);
			request.setAttribute("size", tgLi.size());
			request.setAttribute("shopId", shopId);
//			response.sendRedirect("/myProducts.jhtml?shopId="+shopId);
			response.sendRedirect("/goodsPreview.jhtml?tgoodsId="+tGoods.getGoodsId());
			return "/WEB-INF/menu/myProducts.jsp";
		} else {
			return "/WEB-INF/login.jsp";
		}

	}
}
