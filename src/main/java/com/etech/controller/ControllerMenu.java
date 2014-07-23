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
import com.etech.entity.Tnews;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tshop;
import com.etech.service.EtechService;
/**
 * menu
 * @author ztx
 *
 */

@Controller
public class ControllerMenu {
	private static final Log log = LogFactory.getLog(ControllerRegisterOne.class);
	@Resource
	private EtechService etechService;
	
	/**
	 * menu
	 * @return
	 */
	@RequestMapping(value="/menu")
	public String menuView(){
		return "/WEB-INF/menu/menu.jsp";
	}
	
	/**
	 * my shop
	 * @return
	 */
	@RequestMapping(value="/myShop")
	public String shopView(){
		return "/WEB-INF/menu/myShop.jsp";
	}
	/**
	 * my goods
	 * @return
	 */
	@RequestMapping(value="/myProducts")
	public String productView(HttpServletRequest request){
		List<Tgoods> tgLi1 = new ArrayList<Tgoods>();
		List<Tgoods> tgLi2 = new ArrayList<Tgoods>();
		List<Tgoods> tgLi3 = new ArrayList<Tgoods>();
		List<Tgoods> tgLi4 = new ArrayList<Tgoods>();
		@SuppressWarnings("unchecked")
		List<Tgoods> tgLi = (List<Tgoods>) etechService.findObjectList(Tgoods.class);
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
	 * shop msg
	 * @return
	 */
	@RequestMapping(value="/shopMsg")
	public String shopMsg(Integer shopId,HttpServletRequest request){
		Tshop tshop = (Tshop) etechService.findObject(Tshop.class, 2);
		request.setAttribute("tshop", tshop);
		log.debug("SHOW SHOPINFO");
		return "/WEB-INF/menu/shopMessage.jsp";
	}
	/**
	 * edit shop msg
	 * @return
	 */
	@RequestMapping(value="/editShopMsg")
	public String editShopMsg(){
		return "/WEB-INF/menu/editShop.jsp";
	}
	/**
	 * hit praise
	 * @return
	 */
	@RequestMapping(value="/hitPraise")
	public String hitPraise(){
		return "/WEB-INF/menu/hitPraise.jsp";
	}
	/**
	 * my Fans
	 * @return
	 */
	@RequestMapping(value="/myFans")
	public String myFans(HttpServletRequest request){
		
		
		
		return "/WEB-INF/menu/myFans.jsp";
	}
	/**
	 * information
	 * @return
	 */
	@RequestMapping(value="/information")
	public String information(HttpServletRequest request,Integer newsId){
		Tnews news = (Tnews) etechService.findObject(Tnews.class, newsId);
		request.setAttribute("news", news);
		return "/WEB-INF/menu/Information.jsp";
	}
	/**
	 * information list
	 * @return
	 */
	@RequestMapping(value="/infoList")
	public String infoList(HttpServletRequest request){
		
		@SuppressWarnings("unchecked")
		//select all news from tNews
		List<Tnews> news = (List<Tnews>) etechService.findObjectList(Tnews.class);
		
		for (Tnews tnews : news) {
			String content = tnews.getContent();
			if (content.length() >30) {
				content = content.substring(0,news.size()) +"...";
			}
		}
		request.setAttribute("news", news);
		
		return "/WEB-INF/menu/InfoList.jsp";
	}
	
	/**
	 * the Statistics of Fans
	 * @return
	 */
	@RequestMapping(value = "/fansCount")
	public String FansCount(String url){
		if (url.equals("sex")) {
			return "/WEB-INF/menu/FansCount.jsp";
		}else if (url.equals("age")) {
			return "/WEB-INF/menu/FansCountForAge.jsp";
		}else if (url.equals("area")) {
			return "/WEB-INF/menu/FansCountForArea.jsp";
		}else if (url.equals("constellation")) {
			return "/WEB-INF/menu/FansCountForConstellation.jsp";
		}else if (url.equals("favourite")) {
			return "/WEB-INF/menu/FansCountForFavourite.jsp";
		}else if (url.equals("job")) {
			return "/WEB-INF/menu/FansCountForJob.jsp";
		}else if (url.equals("CZ")) {
			return "/WEB-INF/menu/FansCountForCZ.jsp";
		}else{
			return "/WEB-INF/login.jsp";
		}
	}
	@RequestMapping(value="/associate")
	public String associate(){
		
		return "/WEB-INF/setting/aboutUserNum.jsp";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value="/editPassword")
	public String editPassword(){
		
		return "/WEB-INF/setting/updatePsd.jsp";
	}
	
	/**
	 * 找回密码
	 * @return
	 */
	@RequestMapping(value="/toFindPsd")
	public String findPsd(){
		
		return "/WEB-INF/setting/findPsd.jsp";
	}
	
	/**
	 * 店铺添加
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addShop")
	public String loginView(HttpServletRequest request){
		
		List<Tgoodstype> range=(List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class);
		request.setAttribute("range", range);
		return "/WEB-INF/menu/addShop.jsp";
	}
	
}
