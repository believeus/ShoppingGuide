package com.etech.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tshop;
import com.etech.service.EtechService;
/**
 * 菜单
 * @author ztx
 *
 */

@Controller
public class ControllerMenu {
	
	@Resource
	private EtechService etechService;
	
	/**
	 * 菜单
	 * @return
	 */
	@RequestMapping(value="/menu")
	public String menuView(){
		return "/WEB-INF/menu/menu.jsp";
	}
	
	/**
	 * 我的店铺
	 * @return
	 */
	@RequestMapping(value="/myShop")
	public String shopView(){
		return "/WEB-INF/menu/myShop.jsp";
	}
	/**
	 * 我的商品
	 * @return
	 */
	@RequestMapping(value="/myProducts")
	public String productView(){
		return "/WEB-INF/menu/myProducts.jsp";
	}
	/**
	 * 店铺信息
	 * @return
	 */
	@RequestMapping(value="/shopMsg")
	public String shopMsg(Integer shopId,HttpServletRequest request){
		Tshop tshop = (Tshop) etechService.findObject(Tshop.class, 1);
		request.setAttribute("tshop", tshop);
		return "/WEB-INF/menu/shopMessage.jsp";
	}
	/**
	 * 编辑店铺信息
	 * @return
	 */
	@RequestMapping(value="/editShopMsg")
	public String editShopMsg(){
		return "/WEB-INF/menu/editShop.jsp";
	}
	/**
	 * 点赞记录
	 * @return
	 */
	@RequestMapping(value="/hitPraise")
	public String hitPraise(){
		return "/WEB-INF/menu/hitPraise.jsp";
	}
	/**
	 * 我的粉丝
	 * @return
	 */
	@RequestMapping(value="/myFans")
	public String myFans(){
		return "/WEB-INF/menu/myFans.jsp";
	}
	/**
	 * 资讯详情
	 * @return
	 */
	@RequestMapping(value="/information")
	public String information(){
		return "/WEB-INF/menu/Information.jsp";
	}
	/**
	 * 资讯列表
	 * @return
	 */
	@RequestMapping(value="/infoList")
	public String infoList(){
		return "/WEB-INF/menu/InfoList.jsp";
	}
	
}
