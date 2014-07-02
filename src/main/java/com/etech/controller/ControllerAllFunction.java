package com.etech.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mydfs.storage.server.MydfsTrackerServer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.etech.entity.Tgoods;
import com.etech.service.EtechService;
import com.etech.util.JsonOutToBrower;

@Component
public class ControllerAllFunction {
	private static final Log log = LogFactory
			.getLog(ControllerAllFunction.class);
	
	@Resource
	private EtechService etechService;
	

	// 保存和修改商品信息
	public void savaShopInfo(Tgoods goods,HttpServletRequest request) {
		String submit = request.getParameter("submit");
		goods.setPublishTime(new Timestamp(System.currentTimeMillis()));
		goods.setStateChangeTime(new Timestamp(System.currentTimeMillis()));
		if (submit.equals("保存"))
			etechService.saveOrUpdata(goods);
		else
			etechService.saveOrUpdata(goods);

	}

	// 删除商品信息
	public void deleteGoodsInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String[] ids = request.getParameterValues("ids");
		if (!StringUtils.isEmpty(ids)) {
			List<String> idList = new ArrayList<String>();
			for (String id : ids) {
				idList.add(id);
			}
			String values = idList.toString().replace("[", "(")
					.replace("]", ")");
			String hql = "delete from Tgoods where id in " + values;
			etechService.delete(hql);
		}
		// 删除后页面刷新
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "success");
		JsonOutToBrower.out(map, response);
	}

}
