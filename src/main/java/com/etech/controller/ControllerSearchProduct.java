package com.etech.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.dao.Pageable;
import com.etech.entity.Tgoods;
import com.etech.service.EtechService;

@Controller
public class ControllerSearchProduct {
	@Resource
	private EtechService etechService;
	@RequestMapping(value="/searchProduct")
	public String searchProduct(String key){
		String hql = "from Tgoods goods where goods.goodsName like '%"+key+"%' ";
		List<Tgoods> goods = (List<Tgoods>) etechService.findObjectList(hql, 10);
		return "/WEB-INF/menu/myProducts.jsp";
	}
}
