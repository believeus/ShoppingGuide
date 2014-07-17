package com.etech.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tbusinessscope;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tshop;
import com.etech.service.EtechService;
import com.etech.webutil.Variables;

@Controller
public class ControllerRegistTwo {
	private static final Log log = LogFactory.getLog(ControllerRegister.class);
	@Resource
	private EtechService etechService;
	/**Begin Author:yangQiXian Data:2014-07-16 AddReason:添加商铺信息*/
	@RequestMapping(value = "/regTwoSuccess")
	public void addShop(Tshop tshop,Tgoodstype tgoodstype,Tbusinessscope busines,HttpServletResponse response,HttpSession session)
	throws Exception
	{
		if(!StringUtils.isEmpty(tshop)&&!StringUtils.isEmpty(tgoodstype)){
			tshop.setAddTime(new Timestamp(new Date().getTime()));
			tshop.setBePraisedCount(Variables.bePraisedCount);
			tshop.setFansCount(Variables.initFansCount);
			tshop.setMarketId(Variables.marketId);
			tshop.setViewCount(Variables.initViewCount);
			tshop.setState(Variables.state);
			tshop.setIsRecommend(Variables.isRecommend);
			tshop.setLatitude(Variables.latitude);
			tshop.setLongitude(Variables.longitude);
			tshop.setShopOwnerName(Variables.shopOwnerName);
			etechService.saveOrUpdata(tshop);
			
			tgoodstype.setHasChild(Variables.hasChild);
			tgoodstype.setParentId(Variables.parentId);
			etechService.saveOrUpdata(tgoodstype);
			
			busines.setGoodsTypeId(tgoodstype.getGoodsTypeId());
			busines.setShopId(tshop.getShopId());
			log.debug("register2 SAVE SUCCESS");
			session.setAttribute("tshop", tshop);
		}else{
			return;
		}
		
		
		String url = "";
		StringBuilder sb = new StringBuilder();
		sb.append("<script type='text/javascript'>")
				.append("top.location.href=" + url).append("</script>");
		log.debug(sb.toString());
		PrintWriter pw = new PrintWriter(response.getOutputStream());
		pw.write(sb.toString());
		pw.close();
		
	}
	/**End Author:yangQiXian Data:2014-07-16 AddReason:添加商铺信息*/
}
