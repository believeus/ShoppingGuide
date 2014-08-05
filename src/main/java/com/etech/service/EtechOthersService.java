package com.etech.service;

import java.sql.Timestamp;
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
import com.etech.entity.Tarea;
import com.etech.entity.Tfeature;
import com.etech.entity.Tgoodstype;
import com.etech.entity.Tphoneuser;
import com.etech.entity.Tphoneuserfeature;
import com.etech.entity.Tprofession;

@Service
public class EtechOthersService {
	private static final Log log = LogFactory.getLog(EtechOthersService.class);
	@Resource
	private EtechComDao etechComDao;
	@Resource
	private EtechService etechService;
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
	
	public Double[] getCZ(List<Tphoneuser> user){
		String animals[]={"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
		int num[] =new int[13];
		
		for(int i=0;i<user.size();i++){
			String name=user.get(i).getZodiac();
			if(!StringUtils.isEmpty(name)){
				for(int j=0;j<animals.length;j++){
					if(animals[j].equals(name)){
						num[j]++;
					}
				}
			}else{
				num[12]++;
			}
		}

		DecimalFormat df=new DecimalFormat(".##");
		List<Double> animalPre=new ArrayList<Double>();
		for(int i=0;i<num.length;i++){
			animalPre.add(
					Double.parseDouble(
							df.format(
									(double)num[i]/user.size()*100)));
		}
		
		Double[] precent=(Double[])animalPre.toArray(new Double[animalPre.size()]);
		
		return precent;
		
	}
	
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
	
	@SuppressWarnings("unchecked")
	public String[] getJob(List<Tphoneuser> user){
		
		List<Tprofession> profession=(List<Tprofession>) etechComDao.findObjectList(Tprofession.class);
		
		List<String> allJobs=new ArrayList<String>();
		String[] total=new String[profession.size()*2];
		log.debug("len:"+total.length);
		for(int i=0;i<profession.size();i++){
			total[i]=profession.get(i).getProfessionName();
			log.debug("total:"+total[i]);
		}
		
		for(int i=0;i<user.size();i++){
			for(int j=0;j<profession.size();j++){
				int userProid=user.get(i).getProfessionId();
				int proid=profession.get(j).getProfessionId();
				
				log.debug("name:"+profession.get(j).getProfessionName());
				
				log.debug("userProid:"+userProid);
				log.debug("proid:"+proid);
				String name=profession.get(j).getProfessionName();
				if(userProid == proid){
					log.debug("===========================");
					allJobs.add(name);
					log.debug("addname:"+allJobs.get(i));
				}
			}
		}
		
		int[] num=new int[profession.size()];
		for(int i=0;i<profession.size();i++){
			for(int j=0;j<allJobs.size();j++){
				if(allJobs.get(j).equals(profession.get(i).getProfessionName())){
					num[i]++;
					log.debug("num:"+i+":"+num[i]);
				}
			}
		}
		DecimalFormat df=new DecimalFormat(".##");
		for(int i=0;i<num.length;i++){
			log.debug("num"+i+":"+num[i]);
			total[i+profession.size()]=df.format(
							(double)num[i]/allJobs.size()*100);
		}
		log.debug("total:1:"+total[0]+";1:"+total[1]+";2:"+total[2]+";3:"+total[3]);
		return total;
		
	}
	
	@SuppressWarnings("unchecked")
	public String[] getArea(Integer cityId){
		
		List<Tphoneuser> users=(List<Tphoneuser>) etechService.findObjectList(Tphoneuser.class);
		int userSize=users.size();
		//all phoneusers id
		List<Integer> allUserAreaId=new ArrayList<Integer>();
		for(int i=0;i<userSize;i++){
			int ids=users.get(i).getAreaId();
			allUserAreaId.add(ids);
		}
		
		//获取该市下的所有区
		List<Tarea> areas=(List<Tarea>) etechComDao.findObjectList(Tarea.class, "cityId", cityId);
		int areaSize=areas.size();
		int len=areaSize+1;
		int thisCityNum=0;
		//最终名字与比例
		String[] areaPre=new String[len*2];
		//统计名字个数
		int[] areaNum=new int[len];
		//统计比例
		String[] preCent=new String[len];
		areaPre[0]="无";
		
		for(int i=0;i<areaSize;i++){
			areaPre[i+1]=areas.get(i).getAreaName();
			log.debug("areaName:"+areas.get(i).getAreaName());
		}
		
		int allUserAreaIdSize=allUserAreaId.size();
		for(int i=0;i<allUserAreaIdSize;i++){
			int userIdForArea=allUserAreaId.get(i);
			if(userIdForArea != -1){
				for(int j=0;j<areaSize;j++){
					int areaId=areas.get(j).getAreaId();
					if(userIdForArea == areaId){
						areaNum[j+1]++;
						thisCityNum++;
					}
				}
			}else{
				areaNum[0]++;
				thisCityNum++;
				log.debug("areaNum[0]:"+areaNum[0]);
				log.debug("thisCityNum:"+thisCityNum);
			}
			
		}
		
		
		DecimalFormat df=new DecimalFormat(".##");
		for(int k=0;k<areaSize+1;k++){
			preCent[k]=df.format(
							(double)areaNum[k]/thisCityNum*100);
			log.debug("areaPre:"+preCent[k]);
			areaPre[len++]=preCent[k];
		}
		
		return areaPre;
	}
	
@SuppressWarnings("unchecked")
public String[] getFavourite(List<Tphoneuser> user){
		
		List<Tfeature> list= (List<Tfeature>) etechComDao.findObjectList(Tfeature.class);
		//获取所有特色的id
		List<Integer> allFeatureId=new ArrayList<Integer>();
		int listSize=list.size();
		String[] total=new String[listSize*2];
		int[] num=new int[listSize];
		String[] percent=new String[listSize];
		for(int i=0;i<listSize;i++){
			int id=list.get(i).getFeatureId();
			allFeatureId.add(id);
			log.debug("id"+id);
			total[i]=list.get(i).getFeatureName();
			log.debug("featureName:"+total[i]);
		}
		//通过用户id获取用户特色id
		int length=user.size();
		log.debug("length："+length);
		for(int i=0;i<length;i++){
			int phoneId=user.get(i).getPhoneUserId();
			List<Tphoneuserfeature> featureIdList=(List<Tphoneuserfeature>) etechComDao.findObjectList(Tphoneuserfeature.class, "phoneUserId", phoneId);
			if(featureIdList.isEmpty()){
				Tphoneuserfeature tphoneuserfeature=new Tphoneuserfeature();
				tphoneuserfeature.setFeatureId(1);
				tphoneuserfeature.setPhoneUserFeatureId(3);
				tphoneuserfeature.setPhoneUserId(1);
				tphoneuserfeature.setAddTime(new Timestamp(233246546));
				featureIdList.add(tphoneuserfeature);
			}
			//若
			int len=featureIdList.size();
			log.debug("len:"+len);
			for(int a=0;a<len;a++){
				log.debug("a:"+a);
				int featureId=featureIdList.get(a).getFeatureId();
				log.debug("featureId:"+featureId);
				for(int k=0;k<listSize;k++){
					if(featureId == allFeatureId.get(k)){
						num[k]++;
						log.debug("num"+k+":"+num[k]);
					}
				}
				
			}
		}
		DecimalFormat df=new DecimalFormat(".##");
		for(int i=0;i<listSize;i++){
			percent[i+listSize]=df.format(
							(double)num[i]/length*100);
			log.debug("percent"+i+":"+percent[i]);
		}
		return total;
	}
	
}
