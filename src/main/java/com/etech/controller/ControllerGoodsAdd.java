package com.etech.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.etech.entity.Tfeature;
import com.etech.entity.Tgoods;
import com.etech.entity.Tgoodsfeature;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.variable.Variables;
import com.sun.image.codec.jpeg.JPEGCodec;  
import com.sun.image.codec.jpeg.JPEGImageEncoder; 

@SuppressWarnings("restriction")
@Controller
public class ControllerGoodsAdd {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService etechService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/goodsAdd")
	public String addGoodsView(HttpServletRequest request,Integer shopId) {
		// Tgoodstype
		List<Tgoodstype> gList = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", 10);
		request.setAttribute("gList", gList);
		// Tfeature
		List<Tfeature> tfeatures = (List<Tfeature>) etechService.findObjectList(Tfeature.class,"featureType",(short)0);
		request.setAttribute("tfeatures", tfeatures);
		request.setAttribute("shopId", shopId);
		String featureIds = request.getParameter("featureIds");
		List<Tgoodstype> tgoodstypes = new ArrayList<Tgoodstype>();
		if (featureIds != null && featureIds != "") {
			String[] features = featureIds.split(",");
			for (int i = 0; i < features.length; i++) {
				Tgoodstype tgoodstype = (Tgoodstype) etechService.findObject(Tgoodstype.class, "goodsTypeId", Integer.parseInt(features[i]));
				tgoodstypes.add(tgoodstype);
			}
			request.setAttribute("tgoodstypes", tgoodstypes);
			request.setAttribute("size", tgoodstypes.size());
		}else {
			request.setAttribute("size", 0);
		}
		
		return "/WEB-INF/menu/goodsAdd.jsp";
	}
	
	/**
	 * 查找商品类别
	 * @param cId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/findChildGoodsType")
	public @ResponseBody Map<String, Object> findChildGoodsType(Integer cId){
		System.out.println(cId);
		List<Tgoodstype> tgoodstypes = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class, "parentId", cId);
		
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		//此处是亮点，只要将所需忽略字段加到数组中即可，
		//在上述案例中，所要忽略的是“shops”，“goodses”,那么将其添到数组中即可，在实际测试中，我发现在所返回数组中，存在大量无用属性,会导致死循环报错
		jsonConfig.setExcludes(new String[]{"shops"}); 
		jsonConfig.setExcludes(new String[]{"goodses"}); 
		
		JSONArray jsonArray = JSONArray.fromObject(tgoodstypes,jsonConfig); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", jsonArray);
		map.put("message", "success");
		return map;
	}
	
	@RequestMapping(value="/goodsType")
	public @ResponseBody String goodsType(HttpServletRequest request,Integer shopId,String featureIds){
		
		List<Tgoodstype> tgoodstypes = new ArrayList<Tgoodstype>();
		if (featureIds != null && featureIds != "") {
			String[] features = featureIds.split(",");
			for (int i = 0; i < features.length; i++) {
				Tgoodstype tgoodstype = (Tgoodstype) etechService.findObject(Tgoodstype.class, "goodsTypeId", Integer.parseInt(features[i]));
				tgoodstypes.add(tgoodstype);
			}
			request.setAttribute("tgoodstypes", tgoodstypes);
			request.setAttribute("size", tgoodstypes.size());
		}else {
			request.setAttribute("size", 0);
		}
		return "success";
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
			String[] goodsTypeIds = request.getParameterValues("goodsTypeId");
			if (!StringUtils.isEmpty(goodsTypeIds)) {
				for (String goodsTypeId : goodsTypeIds) {
					Tgoodstype goodstype=(Tgoodstype)etechService.findObject(Tgoodstype.class, Integer.valueOf(goodsTypeId));
					tGoods.getGoodsTypes().add(goodstype);
				}
			}
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = multipartRequest.getFileMap();
			String goodsImg = "";
			String shopImg=""; 
			String appendImg = "";
			for (MultipartFile file : files.values()) {
				InputStream inputStream;
				try {
					inputStream = file.getInputStream();
					FileOutputStream out = null;  
					if(inputStream.available()==0)continue;
					String originName=file.getOriginalFilename();
					String extention = originName.substring(originName.lastIndexOf(".") + 1);
					log.debug("upload file name:"+file.getName());
					if(file.getName().contains("goodsImg")){
					  // get the goods save path
					  UUID randomUUID = UUID.randomUUID(); 
					  goodsImg=randomUUID+"."+extention;
					  String goodsImgSmall=Variables.goodsPhotoImgPath+randomUUID+"_small."+extention;
					  log.debug("upload path:"+Variables.goodsPhotoImgPath+goodsImg);
					  log.debug("upload small path :"+goodsImgSmall);
					  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.goodsPhotoImgPath+goodsImg));
					  appendImg+= goodsImg+"#";
					  
					  //读入文件    
		              File imgSmall = new File(Variables.goodsPhotoImgPath+goodsImg);    
		              // 构造Image对象    
		              BufferedImage src = ImageIO.read(imgSmall);
		              int width = src.getWidth();    
		              int height = src.getHeight();   
		              BufferedImage tag = new BufferedImage(width , height , BufferedImage.TYPE_INT_RGB);    
		              //绘制自定义的图片  
		              tag.getGraphics().drawImage(src, 0, 0, Variables.imagewidth, height , null);    
		              out = new FileOutputStream(goodsImgSmall);    
		              JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);    
		              encoder.encode(tag);
		              
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			log.debug("shop image sava db url:"+shopImg);
			log.debug("goods image sava db url:"+appendImg);
			String moren = request.getParameter("moren");
			if (!StringUtils.isEmpty(moren)) {
				String[] goodsImgPath = appendImg.split("#");
				for (int i = 0; i < goodsImgPath.length; i++) {
					if(i == Integer.parseInt(moren)){
						tGoods.setGoodsDefaultPhotoUrl(goodsImgPath[i]);
					}
				}
			}
			if(goodsImg ==""){
				tGoods.setGoodsPhotoUrl("95f220ae-8a37-45a8-8d26-0629897b9f4b.jpg");
			}else {
				tGoods.setGoodsPhotoUrl(appendImg);
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
			tGoods.setModifyState((short)0);
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = multipartRequest.getFileMap();
			String goodsImg = "";
			String shopImg=""; 
			String appendImg = "";
			for (MultipartFile file : files.values()) {
				InputStream inputStream;
				try {
					inputStream = file.getInputStream();
					FileOutputStream out = null;  
					if(inputStream.available()==0)continue;
					String originName=file.getOriginalFilename();
					String extention = originName.substring(originName.lastIndexOf(".") + 1);
					log.debug("upload file name:"+file.getName());
					if(file.getName().contains("goodsImg")){
					  // get the goods save path
					  UUID randomUUID = UUID.randomUUID(); 
					  goodsImg=randomUUID+"."+extention;
					  String goodsImgSmall=Variables.goodsPhotoImgPath+randomUUID+"_small."+extention;
					  log.debug("upload path:"+Variables.goodsPhotoImgPath+goodsImg);
					  log.debug("upload small path :"+goodsImgSmall);
					  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.goodsPhotoImgPath+goodsImg));
					  appendImg+= goodsImg+"#";
			          //读入文件    
		              File imgSmall = new File(Variables.goodsPhotoImgPath+goodsImg);    
		              // 构造Image对象    
		              BufferedImage src = ImageIO.read(imgSmall);
		              int width = src.getWidth();    
		              int height = src.getHeight();   
		              BufferedImage tag = new BufferedImage(width , height , BufferedImage.TYPE_INT_RGB);    
		              //绘制自定义的图片  
		              tag.getGraphics().drawImage(src, 0, 0, Variables.imagewidth, height , null);    
		              out = new FileOutputStream(goodsImgSmall);    
		              JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);    
		              encoder.encode(tag);
		              
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			log.debug("All path:"+appendImg);
			String moren = request.getParameter("moren");
			if (!StringUtils.isEmpty(moren)) {
				String[] goodsImgPath = appendImg.split("#");
				for (int i = 0; i < goodsImgPath.length; i++) {
					if(i == Integer.parseInt(moren)){
						tGoods.setGoodsDefaultPhotoUrl(goodsImgPath[i]);
					}
				}
			}
			log.debug("shop image sava db url:"+shopImg);
			tGoods.setGoodsPhotoUrl(appendImg);
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
