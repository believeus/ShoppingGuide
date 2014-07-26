package com.etech.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.etech.entity.Tfindpasswordforshopuser;
import com.etech.entity.Tshop;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.variable.Variables;
/**
 * 设置
 * @author ztx
 *
 */

@Controller
public class ControllerSetting {
	
	@Resource
	private EtechService etechService;
	private static final Log log=LogFactory.getLog(ControllerSetting.class);
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value="/updatePsd")
	public String menuView(){
		return "/WEB-INF/setting/updatePsd.jsp";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value="/findPsd")
	public String findPsdJsp(){
		return "/WEB-INF/setting/findPsd.jsp";
	}
	@RequestMapping(value="findPsdLogic")
	public String findPsdLogic(HttpServletRequest request){
		Tfindpasswordforshopuser findpassword=new Tfindpasswordforshopuser();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multipartRequest.getFileMap();
		String licenseImg = "";
		for (MultipartFile file : files.values()) {
			InputStream inputStream;
			try {
				inputStream = file.getInputStream();
				if(inputStream.available()==0)continue;
				String originName=file.getOriginalFilename();
				String extention = originName.substring(originName.lastIndexOf(".") + 1);
				 // get the license save path
				licenseImg=UUID.randomUUID()+"."+extention;
				log.debug("upload path:"+Variables.shopLicenseImgPath+licenseImg);
				FileUtils.copyInputStreamToFile(inputStream, new File(Variables.shopLicenseImgPath+licenseImg));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String telphoneNum=request.getParameter("telphoneNum");
		findpassword.setUserName(telphoneNum);
		findpassword.setPhoneNumber(telphoneNum);
		findpassword.setLicensePhoto(licenseImg);
		short unprocess=0;
		findpassword.setState(unprocess);
		findpassword.setApplyTime(new Timestamp(System.currentTimeMillis()));
		findpassword.setStateChangeTime(new Timestamp(System.currentTimeMillis()));
		findpassword.setPhoneUserActiveCount(0);
		etechService.saveOrUpdate(findpassword);
		request.setAttribute("message", "等待审核中");
		return "/WEB-INF/menu/success.jsp";
	}
	/**
	 * 关联帐号
	 * @return
	 */
	@RequestMapping(value="/aboutUserNum")
	public String shopView(){
		return "/WEB-INF/setting/aboutUserNum.jsp";
	}
	@RequestMapping(value="/ajaxMacthPwd")
	public @ResponseBody String ajaxMacthPwd(HttpServletRequest request,String oldPassword){
		HttpSession session = request.getSession();
		Integer shopUserId  = ((Tshopuser)session.getAttribute(Variables.sessionUser)).getShopUserId();
		Tshopuser shopuser =(Tshopuser)etechService.findObject(Tshopuser.class,"shopUserId",shopUserId);
		oldPassword=DigestUtils.md5Hex(oldPassword);
		if(!oldPassword.equals(shopuser.getPassword())){
			return "false"; 
		}
		return "true";
	}
	
	
	@RequestMapping(value="/modifyPwd")
	public String modifyPwd(HttpServletRequest request){
		HttpSession session = request.getSession();
		String shopUserId=request.getParameter("shopUserId");
		String confirmPsd=request.getParameter("confirmPsd");
		Tshopuser shopuser =(Tshopuser)etechService.findObject(Tshopuser.class,"shopUserId",Integer.parseInt(shopUserId));
		shopuser.setPassword(DigestUtils.md5Hex(confirmPsd));
		etechService.saveOrUpdate(shopuser);
		session.setAttribute(Variables.sessionUser,shopuser);
		request.setAttribute("message", "密码更新成功！");
		return "/WEB-INF/menu/success.jsp";
	}
	
	@RequestMapping(value="/relationCount")
	public String relationCount(HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer shopuserId = ((Tshopuser)session.getAttribute(Variables.sessionUser)).getShopUserId();
		Tshopuser sessionUser=(Tshopuser)etechService.findObject(Tshopuser.class, "shopUserId",shopuserId);
		String phoneNumber=request.getParameter("phoneNumber");
		String confirmPsd=request.getParameter("confirmPsd");
		log.debug("phoneNumber:"+phoneNumber+" confirmPsd:"+confirmPsd);
		// 密码md5生成摘要
		confirmPsd=DigestUtils.md5Hex(confirmPsd);
		Tshopuser shopuser=new Tshopuser();
		shopuser.setUserName(phoneNumber);
		shopuser.setPhoneNumber(phoneNumber);
		shopuser.setPassword(confirmPsd);
		shopuser.setScore(0);
		shopuser.setGrade((short)1);
		shopuser.setGender(Variables.man);
		// 创建时间
		shopuser.setAddTime(new Timestamp(System.currentTimeMillis()));
		shopuser.setState((short)Variables.reviewing);
		shopuser.setLoginCount(1);
		shopuser.setDefaultShopId(Variables.unRegister);
		etechService.saveOrUpdate(shopuser);
		for (Tshop shop : sessionUser.getShops()) {
			shop.getShopusers().add(shopuser);
			etechService.saveOrUpdate(shop);
		}
		request.setAttribute("message", "关联"+phoneNumber+"手机号成功！");
		return "/WEB-INF/menu/success.jsp";
	}
}
