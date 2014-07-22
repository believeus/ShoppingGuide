package com.etech.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.etech.entity.Tfeature;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tmarket;
import com.etech.entity.Tshop;
import com.etech.entity.Tshopsuser;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.variable.Variables;
import com.etech.webutil.Brower;
import com.etech.webutil.LatitudeUtils;
import com.etech.webutil.PropertiesUtils;
import com.etech.webutil.WebServiceValidCode;
@Controller
public class ControllerRegister {

	private static final Log log = LogFactory.getLog(ControllerRegister.class);
	@Resource
	private EtechService etechService;

	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:验证电话号码是否被注册过*/
	@RequestMapping(value="/validatePhoneNumber")
	public @ResponseBody String validateMobile(String phoneNumber){
		log.debug("current register phoneNumber:"+phoneNumber);
		// 根据手机号查找该用户是否被注册
		Tshopsuser shopuser = (Tshopsuser)etechService.findObject(Tshopsuser.class, Variables.phoneNumber, phoneNumber);
		// 该手机号被注册
		if(!StringUtils.isEmpty(shopuser)){
			return "false";
		}
		// 该手机号未被注册
		return "true";
	}
	/**End Author:wuqiwei Data:2014-07-15 AddReason:验证电话号码是否被注册过*/
	
	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:获取手机验证码*/
	@RequestMapping(value="/generateValidCode")
	public void generateValidCode(String phoneNumber,HttpSession session,ServletResponse response){
		log.debug("current phoneNumber:"+phoneNumber);
		String validCode = WebServiceValidCode.getCode(phoneNumber);
		log.debug("validCode:"+validCode);
		session.setAttribute(Variables.validCode, validCode);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("returnCode", validCode);
		Brower.outJson(map, response);
	}
	/**End Author:wuqiwei Data:2014-07-15 AddReason:获取手机验证码*/
	
	
	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:验证电话验证码是否一致*/
	@RequestMapping(value="/validateNumberCode")
	public @ResponseBody String validateNumberCode(String numberCode,HttpSession session){
		String sessionCode = (String)session.getAttribute(Variables.validCode);
		log.debug("input valid code:"+numberCode+" session Valid code:"+sessionCode);
		if(!sessionCode.equals(numberCode)){
			return "false";
		}
		// 验证码不匹配
		return "true";
	}
	/**End Author:wuqiwei Data:2014-07-15 AddReason:验证电话验证码是否一致*/
	
	/**Begin Author:wuqiwei Data:2014-07-15 AddReason:表单验证通过后,将该保存到数据库*/
	@RequestMapping(value="/dealRegister")
	public void dealRegister(Tshopuser shopuser,HttpSession session,ServletResponse response){
		log.debug("current register phoneNumber:"+shopuser.getPhoneNumber());
		shopuser.setUserName(shopuser.getPhoneNumber());
		// 密码md5加密
		String password=DigestUtils.md5Hex(shopuser.getPassword());
		shopuser.setPassword(password);
		shopuser.setScore(0);
		shopuser.setGrade((short)1);
		shopuser.setGender(Variables.man);
		// 创建时间
		shopuser.setAddTime(new Timestamp(System.currentTimeMillis()));
		shopuser.setPageView(0);
		shopuser.setState((short)Variables.reviewing);
		// 没有注册店铺
		shopuser.setDefaultShopId(Variables.unRegister);
		etechService.saveOrUpdate(shopuser);
		session.setAttribute(Variables.sessionUser, shopuser);
		Brower.redirect("/register2.jhtml", response);
	}
	/**End Author:wuqiwei   Data:2014-07-15 AddReason:表单验证通过后,将该用户保存到数据库*/
	@RequestMapping(value="/dealRegister2")
	public void dealRegister2(Tshopsuser shopuser,HttpServletRequest request,ServletResponse response){
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
				log.debug("upload file stuffix:"+extention);
				if(file.getName().equals("licenseImg")){
				  // get the license save path
				  licenseImg=UUID.randomUUID()+"."+extention;
				  FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopLicenseImgPath+licenseImg));
				}else {
					shopImg=UUID.randomUUID()+"."+extention;
					FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopImgPath+shopImg));
					shopImg+="#";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		HttpSession session = request.getSession();
		Tshopuser sessionUser=(Tshopuser)session.getAttribute(Variables.sessionUser);
		
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
		shop.setShopPhotoUrl(shopImg);
		etechService.saveOrUpdate(shop);
		// shop goodstype many to many goodstype,mapped by goodstype
		shop.getGoodsTypes().add(goodstype);
		// shop shopusers many to many Tshopuser mapped by shopusers
		Tshopuser currentUser=(Tshopuser) etechService.findObject(Tshopuser.class,"shopUserId", 2);
		shop.getShopusers().add(currentUser);
		etechService.saveOrUpdate(shop);

		session.setAttribute(Variables.sessionUser, currentUser);
		Brower.redirect("/register3.jhtml", response);
	}
	
	/** 
	 * End Author:wuqiwei Data:2014=05-26 Email:1058633117@qq.com
	 * AddReason:ajax判断一般用户的ajax验证
	 */

	/**
	 * 注册
	 * @return
	 */
	@RequestMapping(value="/register")
	public String registerView(){
		return "/WEB-INF/register.jsp";
	}
	/**Begin Author:yangQiXian Data:2014-07-16 AddReason:返回经营范围*/
	@RequestMapping(value="/register2")
	public String registerView2(HttpServletRequest request,ServletResponse response){
		HttpSession session = request.getSession();
		Tshopuser shopuser=(Tshopuser)session.getAttribute(Variables.sessionUser);
		// the user unfinish the one step register,then jump the one step register page
		/*if(shopsuser==null){
			String url="/register.jhtml";
			Brower.redirect(url, response);
		}*/
		String hql="from Tgoodstype";
		@SuppressWarnings("unchecked")
		List<Tgoodstype> gList = (List<Tgoodstype>)etechService.findObjectList(Tgoodstype.class);
		request.setAttribute("gList", gList);
		List<Tmarket> marketList=(List<Tmarket>)etechService.findObjectList(Tmarket.class);
		request.setAttribute("marketList", marketList);
		return "/WEB-INF/register2.jsp";
	}
	/**End Author:yangQiXian Data:2014-07-16 AddReason:返回经营范围*/
	
	/**Begin Author:yangQiXian Data:2014-07-17 AddReason:返回商品特色*/
	@RequestMapping(value="/register3")
	public String registerView3(HttpServletRequest request,ServletResponse response){
		HttpSession session = request.getSession();
		Tshopuser shopuser=(Tshopuser)session.getAttribute(Variables.sessionUser);
		// the user unfinish the one step register,then jump to one step /register.jhtml
		if(shopuser==null){
			String url="/register.jhtml";
			Brower.redirect(url, response);
		// the user unfinish the second step register,then jump to one step /register2.jhtml
		}else if(shopuser.getShops().isEmpty()){
			String url="/register2.jhtml";
			Brower.redirect(url, response);
		}
		
		@SuppressWarnings("unchecked")
		List<Tfeature> tList = (List<Tfeature>)etechService.findObjectList(Tfeature.class, Integer.MAX_VALUE);
		request.setAttribute("tList", tList);
		log.debug(tList.size());
		return "/WEB-INF/register3.jsp";
	}
	/**End Author:yangQiXian Data:2014-07-17 AddReason:返回商品特色*/
}
