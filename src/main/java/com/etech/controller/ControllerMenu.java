package com.etech.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.service.EtechService;
/**
 * 菜单
 * @author ztx
 *
 */

@Controller
public class ControllerMenu {
	
	@Resource
	private EtechService userService;
	
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
	 * 添加商品(普通添加)
	 * @return
	 */
	@RequestMapping(value="/productAdd")
	public String productadd(){
		return "/WEB-INF/menu/goodsAdd.jsp";
	}
	/**
	 * 添加商品(灵活添加)
	 * @return
	 */
	@RequestMapping(value="/productAdd2")
	public String productadd2(){
		return "/WEB-INF/menu/goodsAdd2.jsp";
	}
	/**
	 * 店铺信息
	 * @return
	 */
	@RequestMapping(value="/shopMsg")
	public String shopMsg(){
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
