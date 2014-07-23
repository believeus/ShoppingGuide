package com.etech.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.webutil.Brower;

@Controller
public class ControllerValIdnumAndRealName {
	private static final Log log = LogFactory
			.getLog(ControllerRegistUserName.class);
	@Resource
	private EtechService etechService;
	/**
	 * Begin Author:yangQiXian Data:2014=07-03 AddReason:ajax验证身份证和真实姓名
	 */
	@RequestMapping(value = "/registidnumberandrealname")
	public void registIdAndRN(Tshopuser regUser, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> message = new HashMap<String, Object>();
		
		if (!StringUtils.isEmpty(regUser.getIdnumber())) {
		
			log.debug(regUser.getIdnumber());
			boolean matcheIdCard1 = regUser
					.getIdnumber()
					.matches(
							"^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[A-Z])$");
			boolean matcheIdCard2 = regUser
					.getIdnumber()
					.matches(
							"/^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$/");
			if(matcheIdCard1==false&&matcheIdCard2==false){
				message.put("property", "idnumber");
				message.put("message", "error");
				Brower.outJson(message, response);
				return;
			}else{
				message.put("property", "idnumber");
				message.put("message", "success");
				Brower.outJson(message, response);
				return;
			}
			
		}else {
			message.put("property", "idnumber");
			message.put("message", "nullInfo");
			Brower.outJson(message, response);
			return;
		}
		/**
		 * End Author:yangQiXian Data:2014=07-03 AddReason:ajax验证身份证和真实姓名
		 */
	}
}
