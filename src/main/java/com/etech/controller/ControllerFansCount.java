package com.etech.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.entity.Tcity;
import com.etech.entity.Tphoneuser;
import com.etech.entity.Tprovince;
import com.etech.entity.Tshopfavorite;
import com.etech.service.EtechOthersService;
import com.etech.service.EtechService;

@Controller
public class ControllerFansCount {
	private static final Log log = LogFactory.getLog(ControllerFansCount.class);
	@Resource
	private EtechService etechService;
	@Resource
	private EtechOthersService etechOthersService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansSexCount")
	public String fansSexCount(HttpServletRequest request,Integer shopId){
		//通过一个商铺id关联商铺的phoneuser粉丝
		List<Tshopfavorite> shopFavorite=(List<Tshopfavorite>) etechService.findObjectList(Tshopfavorite.class, "shopId", shopId);
		Double[] sexCount=new Double[3];
		if(!CollectionUtils.isEmpty(shopFavorite)){
			List<Tphoneuser> users=new ArrayList<Tphoneuser>();
			int len=shopFavorite.size();
			for(int i=0;i<len;i++){
				String nickName=shopFavorite.get(i).getFansNickName();
				Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class, "nickName", nickName);
				if(StringUtils.isEmpty(user)){
					log.debug("找不到NickName为"+nickName+"的用户！");
				}else{
					users.add(user);
				}
			}
			
			sexCount=etechOthersService.findSexCount(users);
		}
		request.setAttribute("manPrecent", sexCount[0]);
		request.setAttribute("womanPrecent", sexCount[1]);
		request.setAttribute("unknown", sexCount[2]);
		request.setAttribute("shopId", shopId);
		
		return "/WEB-INF/menu/FansCount.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansAgeCount")
	public String fansAgeCount(HttpServletRequest request,Integer shopId){
		List<Tshopfavorite> shopFavorite=(List<Tshopfavorite>) etechService.findObjectList(Tshopfavorite.class, "shopId", shopId);
		List<Tphoneuser> users=new ArrayList<Tphoneuser>();
		int len=shopFavorite.size();
		for(int i=0;i<len;i++){
			String nickName=shopFavorite.get(i).getFansNickName();
			Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class, "nickName", nickName);
			if(StringUtils.isEmpty(user)){
				log.debug("找不到NickName为"+nickName+"的用户！");
			}else{
				users.add(user);
			}
		}
		
		Double[] ageCount=etechOthersService.getAge(users);
		request.setAttribute("ageCount", ageCount);
		request.setAttribute("shopId", shopId);
		
		return "/WEB-INF/menu/FansCountForAge.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansConstellationCount")
	public String fansConstellationCount(HttpServletRequest request,Integer shopId){
		List<Tshopfavorite> shopFavorite=(List<Tshopfavorite>) etechService.findObjectList(Tshopfavorite.class, "shopId", shopId);
		Double[] constellat=new Double[13];
		if(!CollectionUtils.isEmpty(shopFavorite)){
			List<Tphoneuser> users=new ArrayList<Tphoneuser>();
			int len=shopFavorite.size();
			for(int i=0;i<len;i++){
				String nickName=shopFavorite.get(i).getFansNickName();
				Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class, "nickName", nickName);
				if(StringUtils.isEmpty(user)){
					log.debug("找不到NickName为"+nickName+"的用户！");
				}else{
					users.add(user);
				}
			}
			constellat=etechOthersService.getConstellation(users);
		}
		request.setAttribute("constellat", constellat);
		request.setAttribute("shopId", shopId);
		
		return "/WEB-INF/menu/FansCountForConstellation.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansCzCount")
	public String fansCZCount(HttpServletRequest request,Integer shopId){
		List<Tshopfavorite> shopFavorite=(List<Tshopfavorite>) etechService.findObjectList(Tshopfavorite.class, "shopId", shopId);
		Double[] cZPrecent=new Double[13];
		if(!CollectionUtils.isEmpty(shopFavorite)){
			List<Tphoneuser> users=new ArrayList<Tphoneuser>();
			int len=shopFavorite.size();
			for(int i=0;i<len;i++){
				String nickName=shopFavorite.get(i).getFansNickName();
				Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class, "nickName", nickName);
				if(StringUtils.isEmpty(user)){
					log.debug("找不到NickName为"+nickName+"的用户！");
				}else{
					users.add(user);
				}
			}
			cZPrecent=etechOthersService.getCZ(users);
		}
		request.setAttribute("cZPrecent", cZPrecent);
		request.setAttribute("shopId", shopId);
		
		return "/WEB-INF/menu/FansCountForCZ.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansJobsCount")
	public String fansJobsCount(HttpServletRequest request,Integer shopId){
		List<Tshopfavorite> shopFavorite=(List<Tshopfavorite>) etechService.findObjectList(Tshopfavorite.class, "shopId", shopId);
		
		if(!CollectionUtils.isEmpty(shopFavorite)){
			List<Tphoneuser> users=new ArrayList<Tphoneuser>();
			int leng=shopFavorite.size();
			for(int i=0;i<leng;i++){
				String nickName=shopFavorite.get(i).getFansNickName();
				Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class, "nickName", nickName);
				if(StringUtils.isEmpty(user)){
					log.debug("找不到NickName为"+nickName+"的用户！");
				}else{
					users.add(user);
				}
			}
			String[] arr=etechOthersService.getJob(users);
			int len=arr.length/2;
			log.debug("len:"+len);
			String[] name=new String[len];
			String[] pre=new String[len];
			System.arraycopy(arr, 0, name, 0, len);
			System.arraycopy(arr, len, pre, 0, len);
			
			request.setAttribute("name", name);
			request.setAttribute("pre", pre);
		}else{
			String[] name={""};
			String[] pre=new String[name.length];
			request.setAttribute("name", name);
			request.setAttribute("pre", pre);
		}
		
		
		request.setAttribute("shopId", shopId);
		
		return "/WEB-INF/menu/FansCountForJob.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansAreaCount")
	public String fansAreaCount(HttpServletRequest request,int cityId,Integer shopId){
		//获取tcity对象
		Tcity city=(Tcity) etechService.findObject(Tcity.class, cityId);
		String cityName=city.getCityName();
		int provinceId=city.getProvinceId();
		Tprovince pro=(Tprovince) etechService.findObject(Tprovince.class, provinceId);
		String provinceName=pro.getProvinceName();
		request.setAttribute("cityName", cityName);
		request.setAttribute("provinceName", provinceName);
		
		String[] pre=etechOthersService.getArea(cityId,shopId);
		int len=pre.length/2;
		String[] area=new String[len];
		String[] precent=new String[len];
		System.arraycopy(pre, 0, area, 0, len);
		System.arraycopy(pre, len, precent, 0, len);
		request.setAttribute("area", area);
		request.setAttribute("precent", precent);
		
		log.debug("area:1:"+area[0]+";2:"+area[1]);
		
		List<Tprovince> province= (List<Tprovince>) etechService.findObjectList(Tprovince.class);
		request.setAttribute("province", province);
		request.setAttribute("shopId", shopId);
		return "/WEB-INF/menu/FansCountForArea.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/fansFavouriteCount")
	public String fansFavouriteCount(HttpServletRequest request,Integer shopId){
		List<Tshopfavorite> shopFavorite=(List<Tshopfavorite>) etechService.findObjectList(Tshopfavorite.class, "shopId", shopId);
		
		List<Tphoneuser> users=new ArrayList<Tphoneuser>();
		int leng=shopFavorite.size();
		for(int i=0;i<leng;i++){
			String nickName=shopFavorite.get(i).getFansNickName();
			Tphoneuser user=(Tphoneuser) etechService.findObject(Tphoneuser.class, "nickName", nickName);
			if(StringUtils.isEmpty(user)){
				log.debug("找不到NickName为"+nickName+"的用户！");
			}else{
				//System.out.println(users.size());
				if (users.size() > 10) {
					continue;
				}else {
					users.add(user);
				}
			}
		}
		List<List<String>> combine=etechOthersService.getFavourite(users);
		List<List<String>> result=new ArrayList<List<String>>();
		int len=combine.size();
		boolean[] bool=new boolean[len];
		Random random=new Random();
		
		while(result.size()<len){
			int r=random.nextInt(len);
			log.debug("r:"+r);
			if(bool[r] == false){
				result.add(combine.get(r));
				log.debug("size:"+result.size());
				bool[r]=true;
			}
		}
		String[] fname=new String[len];
		Double[] fper=new Double[len];
		for(int i=0;i<len;i++){
			fname[i]=result.get(i).get(0);
			fper[i]=Double.parseDouble(result.get(i).get(1));
		}
		
		request.setAttribute("fname", fname);
		request.setAttribute("fper", fper);
		request.setAttribute("shopId", shopId);
		
		return "/WEB-INF/menu/FansCountForFavourite.jsp";
	}
	
}
