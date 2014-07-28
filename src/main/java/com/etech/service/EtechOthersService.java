package com.etech.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etech.dao.EtechComDao;
import com.etech.entity.Tfeature;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tphoneuser;
import com.etech.entity.Tphoneuserfeature;

@Service
public class EtechOthersService {
	private static final Log log = LogFactory.getLog(EtechOthersService.class);
	@Resource
	private EtechComDao etechComDao;
	@Resource
	private EtechAgeBirthdayService etechAgeBirthdayService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/findSexCount")
	public List findSexCount(List<Tphoneuser> user){
		log.debug("user:"+user.size()+";1:"+user.get(0).getGender());
		double[] sexCount=new double[6];
		for(int i=0;i<user.size();i++){
			if(!StringUtils.isEmpty(user.get(i).getGender())){
				if(user.get(i).getGender().trim().equals("男")){
					sexCount[0]++;
				}else{
					sexCount[1]++;
				}
			}else{
				sexCount[2]++;
			}
		}
		List list=new ArrayList();
		DecimalFormat df=new DecimalFormat(".##");
		for(int i=3;i<sexCount.length-1;i++){
			sexCount[i]=sexCount[i-3]/(sexCount[0]+sexCount[1] +sexCount[2])*100;
			list.add(df.format(sexCount[i]));
		}
		sexCount[5]=100.00-Double.parseDouble(df.format(sexCount[3]))-Double.parseDouble(df.format(sexCount[4]));
		list.add(sexCount[5]);
		return list;	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List findObject(int phoneUserId){
		
		List<Tphoneuserfeature> tfeature= (List<Tphoneuserfeature>) etechComDao.findObjectList(Tphoneuserfeature.class, phoneUserId);
		List<String> featureName=new ArrayList();
		List featureID=new ArrayList();
		if (!StringUtils.isEmpty(tfeature)) {
			for(int i=0;i<tfeature.size();i++){
				featureID.add(tfeature.get(i).getFeatureId());
			}
			for(int i=0;i<featureID.size();i++){
				Integer id=(Integer) featureID.get(i);
				List<Tfeature> feature=(List<Tfeature>) etechComDao.findObjectList(Tfeature.class, id);
				featureName.add(feature.get(i).getFeatureName());
			}
		}
		
		return featureName;
	}
	
	
	public double[] getAge(List<Tphoneuser> user){
		
		double[] ageCount=new double[12];
		for(int i=0;i<user.size();i++){
			Date birthday=user.get(i).getBirthday();
			if(StringUtils.isEmpty(birthday)){
				ageCount[5]++;
			}else{
				double age=etechAgeBirthdayService.getAgeByBirthday(birthday);
				if(age>=10 && age<=19){
					ageCount[0]++;
				}else if(age>=20 && age<=29){
					ageCount[1]++;
				}else if(age>=30 && age<=39){
					ageCount[2]++;
				}else if(age>=40 && age<=49){
					ageCount[3]++;
				}else if(age>=50 && age<=59){
					ageCount[4]++;
				}else{
					ageCount[5]++;
				}
			}
		}
		double[] arr = new double[6];
		DecimalFormat df=new DecimalFormat(".##");
		for(int i=6;i<ageCount.length-1;i++){
			ageCount[i]=Double.parseDouble(df.format(ageCount[i-6]/(ageCount[0]+ageCount[1]+ageCount[2]+ageCount[3]+ageCount[4]+ageCount[5])));
		}
		ageCount[11]=100.00-ageCount[6]+ageCount[7]+ageCount[8]+ageCount[9]+ageCount[10];
		System.arraycopy(ageCount, 6, arr, 0, 6);
		log.debug("ageCount[11]:"+ageCount[11]);
		log.debug("arr:"+arr[0]+";"+arr[5]);
		return arr;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getCZ(List<Tphoneuser> user){
		String animals[]={"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
		int num[] =new int[13];
		
		for(int i=0;i<user.size();i++){
			String name=user.get(i).getZodiac();
			if(!StringUtils.isEmpty(name)){
				for(int j=0;j<animals.length;i++){
					if(animals[j].equals(name)){
						num[j]++;
					}
				}
			}else{
				num[12]++;
			}
		}

		DecimalFormat df=new DecimalFormat(".##");
		List animalPre=new ArrayList();
		for(int i=0;i<num.length;i++){
			animalPre.add(Double.parseDouble(df.format((double)num[i]/user.size()*100)));
		}
		
		return animalPre;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Double[] getConstellation(List<Tphoneuser> user){
		String[] constellate={"白羊座","金牛座","双子座","巨蟹座","狮子座","处女座","天秤座","天蝎座","射手座","摩羯座","水瓶座","双鱼座"};
		int num[] =new int[13];
		log.debug("user:"+user.get(0).getConstellation()+";2:"+user.get(2).getConstellation());
		for(int i=0;i<user.size();i++){
			String name=user.get(i).getConstellation();
			if(!StringUtils.isEmpty(name)){
				for(int j=0;j<constellate.length;i++){
					if(constellate[j].equals(name)){
						num[j]++;
					}
				}
			}else{
				num[12]++;
			}
		}

		DecimalFormat df=new DecimalFormat(".##");
		List<Double> constellatPre=new ArrayList<Double>();
		for(int i=0;i<num.length;i++){
			constellatPre.add(Double.parseDouble(df.format((double)num[i]/user.size()*100)));
		}
		
		
		// 可不可能是这样:constellatPre 是新定义的一个数组,new String[constellatPre.size()] 
		System.out.println(constellatPre.size());
		Double[] arr=(Double[]) constellatPre.toArray(new Double[constellatPre.size()]);
		
		return arr;
		
	}
	
}
