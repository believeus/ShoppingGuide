package com.etech.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.dao.EtechComDao;
import com.etech.entity.Tphoneuser;

@Controller
public class ControllerChangeNote {
	private static final Log log = LogFactory.getLog(ControllerChangeNote.class);
	@Resource
	private EtechComDao etechComDao;
	
	@RequestMapping("/toChangeNote")
	public String toChangeNote(int phoneUserId,String nickName){
		log.debug("phoneUserId"+":"+phoneUserId+";nickName:"+nickName);
		Tphoneuser user=(Tphoneuser) etechComDao.findObject(Tphoneuser.class,"phoneUserId", phoneUserId);
		user.setNickName(nickName);
		etechComDao.saveOrUpdata(user);
		
		return "/showFans.jhtml";
	}
	
}
