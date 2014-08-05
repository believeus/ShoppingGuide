package com.etech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tphoneuser;
import com.etech.service.EtechOthersService;
import com.etech.service.EtechService;

@Controller(value="/showMyfans")
public class ControllerMyFans {
	private static final org.apache.commons.logging.Log log =LogFactory.getLog(ControllerMyFans.class);
	@Resource
	private EtechService etechService;
	@Resource
	private EtechOthersService etechOthersService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/showFans")
	public String showFans(HttpServletRequest request){
		
		List<Tphoneuser> fans=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		
		request.setAttribute("fans", fans);
		
		List<List<String>> featurelist=new ArrayList<List<String>>();
		for(int i=0;i<fans.size();i++){
			int id=fans.get(i).getPhoneUserId();
			log.debug("phoneUserId:"+id);
			List<String> feature= etechOthersService.findObject(id);
			log.debug("length:"+feature.size());
			featurelist.add(feature);
			log.debug("fSize:"+featurelist.size());
			log.debug("featurelist"+i+":"+featurelist.get(i).size());
		}
		request.setAttribute("featurelist", featurelist);
		return "/WEB-INF/menu/myFans.jsp";
	}

}
