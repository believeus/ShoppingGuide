package com.etech.test;

import java.util.List;

import com.etech.entity.Tfeature;
import com.etech.service.EtechService;

public class Test {

	public static void main(String[] args) {
		EtechService etechService= new EtechService();
		String HQL="select * from Tfeature";
		@SuppressWarnings("unchecked")
		List<Tfeature> tList = (List<Tfeature>)etechService.findListByHQL(HQL);
			System.out.println(tList.size());

	}

}
