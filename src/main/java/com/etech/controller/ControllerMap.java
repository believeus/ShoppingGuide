package com.etech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.dao.EtechComDao;
import com.etech.entity.Tcity;

@Controller
public class ControllerMap {
	private static final Log log = LogFactory.getLog(ControllerMap.class);
	@Resource
	private EtechComDao etechComDao;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getCity")
	public void getCity(int selected,HttpServletResponse response) throws IOException{
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<Tcity> citysList=(List<Tcity>) etechComDao.findObjectList(Tcity.class, "provinceId", selected);
		log.debug("len:"+citysList.size());
		Tcity city=null;
		out.println("<response>");
		for(int i=0;i<citysList.size();i++)
		{
			city=citysList.get(i);
			log.debug("city==name:"+city.getCityName()+";id:"+city.getCityId());
			out.print("<city>");
		    out.print("<cityname>"+city.getCityName()+"</cityname>");
		    out.print("<cityvalue>"+city.getCityId()+"</cityvalue>");
		   out.print("</city>");
		}
		out.print("</response>");
	}
	
}
