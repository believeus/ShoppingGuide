package com.etech.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tgoods;
import com.etech.service.EtechService;
import com.etech.util.EtechGobal;
import com.etech.util.JsonOutToBrower;

@Controller
public class ControllerGoods extends ControllerAllFunction {
	@Resource
	private EtechService addGoodService;

	// 添加商品信息页
	@RequestMapping(value = "/personalReg")
	public String personalRegister() {
		return "register/personalRegister";
	}
	//删除商品信息
	public String deleteGoods(HttpServletRequest request,HttpServletResponse response){
		super.deleteGoodsInfo(request,response);
		return "deletesuccess";
		
	}
	/**
	 * Begin Author:wuqiwei Data:2014=05-26 Email:1058633117@qq.com
	 * AddReason:ajax判断商品信息添加验证
	 */
	public void ajaxValidaAddGoods(Tgoods goods,String type, String gName, String gBrand,
			int gTypeId, String gKeywords, String gPrice, String gDiscount,
			String submit, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		Map<String, Object> message = new HashMap<String, Object>();
		// 验证必要验证信息
		if (StringUtils.isEmpty(gName.trim())) {
			message.put("property", "gName");
			message.put("message", "商品名称必须填！");
			JsonOutToBrower.out(message, response);
			return;
		}
	
		if (gTypeId <= 0) {
			message.put("property", "gTypeId");
			message.put("message", "商品类型必须选择!");
			JsonOutToBrower.out(message, response);
			return;
		}
	
		if (Integer.parseInt(gDiscount) <= 0) {
			message.put("property", "gDiscount");
			message.put("message", "商品折扣必须填入!(折扣为1-0.1之间)");
			JsonOutToBrower.out(message, response);
			return;
		}
		if (StringUtils.isEmpty(gKeywords.trim())) {
			message.put("property", "gName");
			message.put("message", "商品关键字必须填！");
			JsonOutToBrower.out(message, response);
			return;
		}
	
			if ("保存".equals(submit)) {

				// 保存

				super.savaShopInfo(goods,request);

			}else
			{
				//更新
				super.savaShopInfo(goods,request);
			}
		

	}
	

}
