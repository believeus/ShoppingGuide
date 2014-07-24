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

import com.etech.entity.Tgoods;
import com.etech.entity.Tgoodstype;
import com.etech.service.EtechService;
import com.etech.variable.Variables;

@Controller
public class ControllerGoodsAdd {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService etechService;

	/** Begin Author:yangQiXian Data:2014-07-21 AddReason:返回商品类型和特色 */
	@RequestMapping(value = "/goodsAdd")
	public String addGoodsView(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		// 商品类型
		List<Tgoodstype> gList = (List<Tgoodstype>) etechService.findObjectList(Tgoodstype.class);
		request.setAttribute("gList", gList);
		log.debug(gList.size());
		return "/WEB-INF/menu/goodsAdd.jsp";
	}

	/** End Author:yangQiXian Data:2014-07-21 AddReason:返回商品特色 */
	@RequestMapping(value = "/goodsAdd2")
	public String addGoodsView2() {
		return "/WEB-INF/menu/goodsAdd2.jsp";
	}

	/** Begin Author:yangQiXian Data:2014-07-21 AddReason:添加商品详细信息 */
	@RequestMapping(value = "/addDetailedGoods")
	public void addGoods(Tgoods tGoods, HttpSession session,
			HttpServletResponse response) throws Exception {
		if (!StringUtils.isEmpty(tGoods)) {
			tGoods.setPublishUserId(2);
			tGoods.setAddTime(new Timestamp(new Date().getTime()));
			tGoods.setBePraisedCount(0);
			tGoods.setViewCount(0);
			tGoods.setShopId(2);
			tGoods.setExamineState((short) 0);
			tGoods.setIsOnSale((short) 1);
			tGoods.setIsRecommend(Variables.unRecommend);
			etechService.saveOrUpdate(tGoods);
		} else {
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

	/** End Author:yangQiXian Data:2014-07-21 AddReason:添加商品详细信息 */
	/** Begin Author:yangQiXian Data:2014-07-21 AddReason:添加商品简便信息 */
	@RequestMapping(value = "/addSimpleGoods")
	public void addSimpleGoods(Tgoods tGoods, HttpSession session,
			HttpServletResponse response) throws Exception {
		if (!StringUtils.isEmpty(tGoods)) {
			tGoods.setGoodsName("");
			tGoods.setPublishUserId(2);
			tGoods.setAddTime(new Timestamp(new Date().getTime()));
			tGoods.setBePraisedCount(0);
			tGoods.setViewCount(0);
			tGoods.setShopId(2);
			tGoods.setExamineState((short) 0);
			tGoods.setIsOnSale((short) 1);
			tGoods.setIsRecommend(Variables.unRecommend);
			etechService.saveOrUpdate(tGoods);
		} else {
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
	/** End Author:yangQiXian Data:2014-07-21 AddReason:添加商品简便信息 */

}
