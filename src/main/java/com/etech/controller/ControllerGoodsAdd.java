package com.etech.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tgoods;
import com.etech.service.EtechService;
@Controller
public class ControllerGoodsAdd {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService etechService;
	@RequestMapping(value="/goodsAdd")
	public String addGoodsView(){
		return "/WEB-INF/menu/goodsAdd.jsp";
	}
	@RequestMapping(value="/goodsAdd2")
	public String addGoodsView2(){
		return "/WEB-INF/menu/goodsAdd2.jsp";
	}
	@RequestMapping(value="/addGoods")
	public void addGoods(Tgoods tGoods){
		
		
	}
	
}
