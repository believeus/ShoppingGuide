package com.etech.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.webutil.Variables;
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
	public String findPsd(){
		return "/WEB-INF/setting/findPsd.jsp";
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
		return "/WEB-INF/menu/pwdModifySuccess.jsp";
	} 
}
