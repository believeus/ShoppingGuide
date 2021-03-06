package com.etech.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.coobird.thumbnailator.Thumbnails;

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
import com.etech.webutil.ImageUtil;
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
	public String findPsdJsp(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "http://*");
		//response.setHeader("Access-Control-Allow-Origin", "*");
		return "/WEB-INF/setting/findPsd.jsp";
	}
	
	/**
	 * 找回密码
	 * @param request
	 * @return
	 */
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
//				UUID randomUUID = UUID.randomUUID(); 
				String GUID = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*1000000);
				licenseImg=GUID+"."+extention;
				String licenseSmallImg=Variables.shopLicenseImgPath+GUID+"_small."+extention;
				log.debug("upload path:"+Variables.shopLicenseImgPath+licenseImg);
				log.debug("upload small path:"+licenseSmallImg);
				FileUtils.copyInputStreamToFile(inputStream, new File(Variables.findPasswordImgPath+licenseImg));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String telphoneNum=request.getParameter("telphoneNum");
		String userName = request.getParameter("userName");
		//etechService.findObject(Tshopuser.class, "userName", userName);
		findpassword.setUserName(userName);
		findpassword.setPhoneNumber(telphoneNum);
		findpassword.setLicensePhoto(licenseImg);
		short unprocess=0;
		findpassword.setState(unprocess);
		findpassword.setApplyTime(new Timestamp(System.currentTimeMillis()));
		findpassword.setStateChangeTime(new Timestamp(System.currentTimeMillis()));
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
		System.out.println(shopuser.getDefaultShopId());
		oldPassword=DigestUtils.md5Hex(oldPassword);
		if(!oldPassword.equals(shopuser.getPassword())){
			return "<script>parent.document.getElementById('returnValue').value=false;</script>"; 
		}
		return "<script>parent.document.getElementById('returnValue').value=true;</script>";
	}
	/*easyDialog.open({container: {header: '提示',content: '验证码不匹配'},overlay: false});*/
	
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
		System.out.println(sessionUser.getDefaultShopId());
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
		shopuser.setDefaultShopId(sessionUser.getDefaultShopId());
		etechService.saveOrUpdate(shopuser);
		for (Tshop shop : sessionUser.getShops()) {
			shop.getShopusers().add(shopuser);
			etechService.saveOrUpdate(shop);
		}
		request.setAttribute("message", "关联"+phoneNumber+"手机号成功！");
		return "/WEB-INF/menu/success.jsp";
	}
	
	/**
	 * 
	 * @param request
	 * @param featureNames
	 * @return
	 */
	@RequestMapping(value="/insertBussnessScope")
	public @ResponseBody String insertBussnessScope(HttpServletRequest request,String featureNames){
		log.debug(featureNames);
		HttpSession session = request.getSession();
		Integer shopuserId = ((Tshopuser)session.getAttribute(Variables.sessionUser)).getShopUserId();
		Tshopuser sessionUser=(Tshopuser)etechService.findObject(Tshopuser.class, "shopUserId",shopuserId);
		Tshop tshop = sessionUser.getShops().get(0);
		tshop.setShopBusinessScope(featureNames);//setShopBusinessScope 是经营范围  而featureNames是店铺特色。
		etechService.saveOrUpdate(tshop);
		return "success";
		
	}
}
