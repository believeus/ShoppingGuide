package com.etech.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.service.EtechService;
/**
 * 设置
 * @author ztx
 *
 */

@Controller
public class ControllerSetting {
	
	@Resource
	private EtechService userService;
	
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
	
}
