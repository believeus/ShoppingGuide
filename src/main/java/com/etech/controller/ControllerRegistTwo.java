package com.etech.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tgoodstype;
import com.etech.service.EtechService;

@Controller
public class ControllerRegistTwo {
	private static final Log log = LogFactory.getLog(ControllerRegister.class);
	@Resource
	private EtechService etechService;
	/**Begin Author:yangQiXian Data:2014-07-16 AddReason:返回经营范围*/
	@RequestMapping(value = "/showGoodsType")
	public String goodType(HttpServletRequest request){
	@SuppressWarnings("unchecked")
	List<Tgoodstype> gList = (List<Tgoodstype>)etechService.getListByClass(Tgoodstype.class, 3);
	request.setAttribute("gList", gList);
	 log.debug(gList.size());
		return "WEB-INF/register2.jhtml";
	}
	/**End Author:yangQiXian Data:2014-07-16 AddReason:返回经营范围*/
}
