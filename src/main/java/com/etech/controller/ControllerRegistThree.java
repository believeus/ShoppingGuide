package com.etech.controller;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.etech.entity.Tfeature;
import com.etech.entity.Tshopfeature;
import com.etech.service.EtechService;

@Controller
public class ControllerRegistThree {
	private static final Log log = LogFactory.getLog(ControllerRegister.class);
	@Resource
	private EtechService etechService;
	/**Begin Author:yangQiXian Data:2014-07-17 AddReason:添加商品特色到数据库*/
	@RequestMapping(value = "/saveFeature")
	public void saveFeature(String [] featureName,Tshopfeature tshopfeature,HttpServletResponse response,HttpSession session,HttpServletRequest request)
	throws Exception
	{
		
		//log.debug(featureName.length);
		//Tshop tshop = (Tshop)session.getAttribute("tshop");
		if(!StringUtils.isEmpty(tshopfeature)){
			tshopfeature.setAddTime(new Timestamp(new Date().getTime()));
			tshopfeature.setShopId(2);
			if(!StringUtils.isEmpty(featureName)){
				int featureId = 0;
				for (int i = 0; i < featureName.length; i++) {
					Tfeature tfeature = (Tfeature) etechService.findObject(Tfeature.class, "featureName", featureName[i]);
					featureId = tfeature.getFeatureId();
					tshopfeature.setFeatureId(featureId);
					etechService.saveOrUpdate(tshopfeature);
				}
			}else {
				return;
			}
			log.debug("SAVE tFeature SUCCESS");
		}else{
			return;
		}
	}
	/**End Author:yangQiXian Data:2014-07-17 AddReason:添加商品特色到数据库*/
	
	
}
