package com.etech.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.etech.entity.Tgoods;
import com.etech.service.EtechService;

@Controller
public class ControllerSearchProduct {
	@Resource
	private EtechService etechService;
	@RequestMapping(value="/searchProduct")
	public String searchProduct(String key,HttpServletRequest request){
		Integer shopId=Integer.parseInt(request.getParameter("shopId"));
		String hql = "from Tgoods goods where goods.goodsName like '%"+key+"%' or goods.introduction like '%"+key+"%' and goods.shopId='"+shopId+"'";
		List<Tgoods> tgLi = (List<Tgoods>) etechService.findObjectList(hql, 10);
		request.setAttribute("tgLi", tgLi);
		List<Tgoods> tgoods1 = new ArrayList<Tgoods>();
		List<Tgoods> tgoods2 = new ArrayList<Tgoods>();
		List<Tgoods> tgoods3 = new ArrayList<Tgoods>();
		List<Tgoods> tgoods4 = new ArrayList<Tgoods>();
		for (int i = 0; i < tgLi.size(); i+=4) {
			tgoods1.add(tgLi.get(i));
			if (i+1 < tgLi.size()) {
				tgoods2.add(tgLi.get(i+1));
			}
			if (i+2 < tgLi.size()) {
				tgoods3.add(tgLi.get(i+2));
			}
			if (i+3 < tgLi.size()) {
				tgoods4.add(tgLi.get(i+3));
			}
		}
		request.setAttribute("tgoods1", tgoods1);
		request.setAttribute("tgoods2", tgoods2);
		request.setAttribute("tgoods3", tgoods3);
		request.setAttribute("tgoods4", tgoods4);
		
		request.setAttribute("size", tgLi.size());
		request.setAttribute("shopId", shopId);
		return "/WEB-INF/menu/myProducts.jsp";
	}
}
