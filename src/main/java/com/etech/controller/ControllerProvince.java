package com.etech.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etech.entity.Tarea;
import com.etech.entity.Tcity;
import com.etech.entity.Tmarket;
import com.etech.entity.Tprovince;
import com.etech.service.EtechService;

@Controller
public class ControllerProvince {
	@Resource
	private EtechService etechService;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/initProvice", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String getProvice(){
		List<Tprovince> provinceList=(List<Tprovince>)etechService.findObjectList(Tprovince.class);
		String proviceIdName="";
		int count=0;
		for (Tprovince tprovince : provinceList) {
			count++;
			if(count!=provinceList.size())
			 proviceIdName+=tprovince.getProvinceId()+":"+tprovince.getProvinceName()+",";
			else {
			  proviceIdName+=tprovince.getProvinceId()+":"+tprovince.getProvinceName();
			}
		}
		return proviceIdName;
	}
	@RequestMapping(value="/initCity", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String getCity(String id){
		List<Tcity> cityList = (List<Tcity>)etechService.findObjectList(Tcity.class,"provinceId",Integer.parseInt(id));
		String cityIdName="";
		int count=0;
		for (Tcity tcity : cityList) {
			count++;
			if(count!=cityList.size())
			 cityIdName+=tcity.getCityId()+":"+tcity.getCityName()+",";
			else 
			 cityIdName+=tcity.getCityId()+":"+tcity.getCityName();
		}
		return cityIdName;
	}
	@RequestMapping(value="/initArea", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String getArea(Integer id){
		List<Tarea> areaList = (List<Tarea>)etechService.findObjectList(Tarea.class,"cityId",id);
		String areaIdName="";
		int count=0;
		for (Tarea tarea : areaList) {
			count++;
			if(count!=areaList.size())
			 areaIdName+=tarea.getAreaId()+":"+tarea.getAreaName()+",";
			else 
				 areaIdName+=tarea.getAreaId()+":"+tarea.getAreaName();
		}
		return areaIdName;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/initMarket", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String getMarket(Integer id){
		List<Tmarket> marketList = (List<Tmarket>)etechService.findObjectList(Tmarket.class,"areaId",id);
		String marketIdName="";
		int count=0;
		for (Tmarket market : marketList) {
			count++;
			if(count!=marketList.size())
			 marketIdName+=market.getMarketId()+":"+market.getMarketName()+",";
			else 
			 marketIdName+=market.getMarketId()+":"+market.getMarketName();
		}
		return marketIdName;
	}
}
