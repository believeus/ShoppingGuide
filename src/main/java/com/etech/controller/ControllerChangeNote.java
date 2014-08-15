package com.etech.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tphoneuser;
import com.etech.entity.Tshopfavorite;
import com.etech.service.EtechService;
import com.etech.webutil.Brower;

@Controller
public class ControllerChangeNote {
	private static final Log log = LogFactory.getLog(ControllerChangeNote.class);
	@Resource
	private EtechService etechService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/toChangeNote")
	public void toChangeNote(int phoneUserId,String nickName,HttpServletResponse response){
		log.debug("phoneUserId"+":"+phoneUserId+";nickName:"+nickName);
		
		List<Tphoneuser> phoneUsers=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		int len=phoneUsers.size();
		List<String> userNick=new ArrayList<String>();
		for(int i=0;i<len;i++){
			userNick.add(phoneUsers.get(i).getNickName());
			//log.debug("NickName:"+phoneUsers.get(i).getNickName());
		}
		Map<String, Object> message=new HashMap<String, Object>();
		if(!StringUtils.isEmpty(nickName.trim())){
			if(userNick.contains(nickName.trim())){
				message.put("property", "toChangeNote");
				message.put("message","error");
				Brower.outJson(message, response);
			}else{
				Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class,"phoneUserId", phoneUserId);
				String nickString=user.getNickName(); 
				Tshopfavorite shopfavorite=(Tshopfavorite) etechService.findObject(Tshopfavorite.class, "fansNickName", nickString);
				// shopfavorite 可肯能为空 报错
				shopfavorite.setFansNickName(nickName.trim());
				user.setNickName(nickName.trim());
				etechService.saveOrUpdate(shopfavorite);
				etechService.saveOrUpdate(user);
				
				message.put("property", "toChangeNote");
				message.put("message","success");
				Brower.outJson(message, response);
			}
		}else{
			Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class,"phoneUserId", phoneUserId);
			String nickString=user.getNickName();
			Tshopfavorite shopfavorite=(Tshopfavorite) etechService.findObject(Tshopfavorite.class, "fansNickName", nickString);
			shopfavorite.setFansNickName("");
			user.setNickName("");
			etechService.saveOrUpdate(user);
			etechService.saveOrUpdate(shopfavorite);
			
			message.put("property", "toChangeNote");
			message.put("message","nu");
			Brower.outJson(message, response);
		}
	}	
}
