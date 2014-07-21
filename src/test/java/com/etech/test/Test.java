package com.etech.test;

import java.util.List;

import com.etech.entity.Tfeature;
import com.etech.entity.Tgoodstype;
import com.etech.service.EtechService;

public class Test {

	public static void main(String[] args) {
		EtechService etechService= new EtechService();
		List<Tgoodstype> gList = (List<Tgoodstype>)etechService.getListByClass(Tgoodstype.class, Integer.MAX_VALUE);
		//request.setAttribute("gList", gList);
			System.out.println(gList.size());

	}

}
