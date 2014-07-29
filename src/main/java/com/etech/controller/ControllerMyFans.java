package com.etech.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.etech.entity.Tphoneuser;
import com.etech.service.EtechOthersService;
import com.etech.service.EtechService;

@Controller(value="/showMyfans")
public class ControllerMyFans {
	
	@Resource
	private EtechService etechService;
	@Resource
	private EtechOthersService etechOthersService;
	
	@SuppressWarnings({ "unchecked"})
	@RequestMapping(value="/showFans")
	public String showFans(HttpServletRequest request){
		
		List<Tphoneuser> fans=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		
		request.setAttribute("fans", fans);
		
		List<String> featurelist=new ArrayList<String>();
		for(int i=0;i<fans.size();i++){
			int id=fans.get(i).getPhoneUserId();
			List<String> feature= etechOthersService.findObject(id);
			featurelist.addAll(feature);
		}
		request.setAttribute("featurelist", featurelist);
		return "/WEB-INF/menu/myFans.jsp";
	}

}
