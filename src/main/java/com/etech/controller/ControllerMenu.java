package com.etech.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tgoods;
import com.etech.entity.Tshop;
import com.etech.service.EtechService;
/**
 * 菜单
 * @author ztx
 *
 */

@Controller
public class ControllerMenu {
	private static final Log log = LogFactory.getLog(ControllerRegister.class);
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
	public String productView(HttpServletRequest request){
		List<Tgoods> tgLi1 = new ArrayList<Tgoods>();
		List<Tgoods> tgLi2 = new ArrayList<Tgoods>();
		List<Tgoods> tgLi3 = new ArrayList<Tgoods>();
		List<Tgoods> tgLi4 = new ArrayList<Tgoods>();
		@SuppressWarnings("unchecked")
		List<Tgoods> tgLi = (List<Tgoods>) etechService.getListByClass(Tgoods.class, Integer.MAX_VALUE);
		for (int i = 0; i < tgLi.size(); i++) {
			int num=tgLi.get(i).getGoodsId()+4;
			if(num%4==0){
				tgLi1.add(tgLi.get(i));
			}else if(num%4==1){
				tgLi2.add(tgLi.get(i));
			}else if(num%4==2){
				tgLi3.add(tgLi.get(i));
			}else if(num%4==3){
				tgLi4.add(tgLi.get(i));
			}
		}
		log.debug(tgLi1.size());
		log.debug(tgLi2.size());
		log.debug(tgLi3.size());
		log.debug(tgLi4.size());
		request.setAttribute("tgLi1", tgLi1);
		request.setAttribute("tgLi2", tgLi2);
		request.setAttribute("tgLi3", tgLi3);
		request.setAttribute("tgLi4", tgLi4);
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
		log.debug("SHOW SHOPINFO");
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
