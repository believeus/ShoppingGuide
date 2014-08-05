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
import com.etech.entity.Tarea;
import com.etech.entity.Tfeature;
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
	
	@RequestMapping(value="/findSexCount")
	public double[] findSexCount(List<Tphoneuser> user){
		int size=user.size();
		log.debug("user:"+size+";1:"+user.get(0).getGender());
		int[] sexCount=new int[3];
		double[] percent=new double[3];
		for(int i=0;i<size;i++){
			if(!StringUtils.isEmpty(user.get(i).getGender())){
				String sex=user.get(i).getGender().trim();
				if(sex.equals("男")){
					sexCount[0]++;
					log.debug("sexCount[0]:"+sexCount[0]);
				}else{
					sexCount[1]++;
					log.debug("sexCount[1]:"+sexCount[1]);
				}
			}else{
				sexCount[2]++;
				log.debug("sexCount[2]:"+sexCount[2]);
			}
		}
		DecimalFormat df=new DecimalFormat(".##");
		for(int i=0;i<2;i++){
			percent[i]=Double.parseDouble(
					df.format(
							(double)sexCount[i]/size*100));
			log.debug("percent"+i+":"+percent[i]);
		}
		percent[2]=Double.parseDouble(
				df.format(
						(100.00-percent[0]-percent[1])));
		log.debug("percent[2]:"+percent[2]);
		return percent;	
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findObject(int phoneUserId){
		List<Tfeature> list= (List<Tfeature>) etechComDao.findObjectList(Tfeature.class);
		//所有feature id
		List<Integer> featureID=new ArrayList<Integer>();
		int len=list.size();	
		for(int i=0;i<len;i++){
			int id=list.get(i).getFeatureId();
			featureID.add(id);
			log.debug("allId:"+id);
		}
		//根据粉丝id获取Tphoneuserfeature对象
		List<Tphoneuserfeature> tfeature= (List<Tphoneuserfeature>) etechComDao.findObjectList(Tphoneuserfeature.class,"phoneUserId", phoneUserId);
		List<Integer> allFeatureID=new ArrayList<Integer>();
		int size=tfeature.size();	
		for(int i=0;i<size;i++){
			int id=tfeature.get(i).getFeatureId();
			allFeatureID.add(id);
			log.debug("allUserId:"+id);
		}
		List<String> featureName=new ArrayList<String>();
		for(int i=0;i<len;i++){
			int fId=featureID.get(i);
			log.debug("fId:"+fId);
			for(int j=0;j<size;j++){
				int userId=allFeatureID.get(j);
				log.debug("userId:"+userId);
				if(userId == fId){
					String name=list.get(i).getFeatureName();
					featureName.add(name);
					log.debug("name:"+name);
					break;
				}
			}
		}
		
		return featureName;
	}
	
	
	public double[] getAge(List<Tphoneuser> user){
		
		int[] ageCount=new int[6];
		int num=user.size();
		for(int i=0;i<num;i++){
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
		double[] percent = new double[6];
		DecimalFormat df=new DecimalFormat(".##");
		for(int i=0;i<6;i++){
			percent[i]=Double.parseDouble(
					df.format(
							(double)ageCount[i]/num*100));
			log.debug("percent"+i+":"+percent[i]);
		}
		return percent;
		
	}
	
	public Double[] getCZ(List<Tphoneuser> user){
		String animals[]={"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
		int num[] =new int[13];
		int size=user.size();
		for(int i=0;i<size;i++){
			String name=user.get(i).getZodiac();
			if(!StringUtils.isEmpty(name)){
				for(int j=0;j<12;j++){
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
		for(int i=0;i<13;i++){
			animalPre.add(
					Double.parseDouble(
							df.format(
									(double)num[i]/size*100)));
			log.debug("animalPre"+i+":"+animalPre.get(i));
		}
		
		Double[] precent=(Double[])animalPre.toArray(new Double[13]);
		
		return precent;
		
	}
	
	public Double[] getConstellation(List<Tphoneuser> user){
		String[] constellate={"白羊座","金牛座","双子座","巨蟹座","狮子座","处女座","天秤座","天蝎座","射手座","摩羯座","水瓶座","双鱼座"};
		int num[] =new int[13];
		int size=user.size();
		log.debug("user:"+user.get(0).getConstellation()+";2:"+user.get(2).getConstellation());
		for(int i=0;i<size;i++){
			String name=user.get(i).getConstellation();
			if(!StringUtils.isEmpty(name)){
				for(int j=0;j<12;j++){
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
		for(int i=0;i<13;i++){
			constellatPre.add(
					Double.parseDouble(
							df.format(
									(double)num[i]/size*100)));
		}
		
		
		// 可不可能是这样:constellatPre 是新定义的一个数组,new String[constellatPre.size()] 
		Double[] arr=(Double[]) constellatPre.toArray(new Double[13]);
		
		return arr;
		
	}
	
	@SuppressWarnings("unchecked")
	public String[] getJob(List<Tphoneuser> user){
		int userSize=user.size();
		List<Tprofession> profession=(List<Tprofession>) etechComDao.findObjectList(Tprofession.class);
		int size=profession.size();
		List<String> allJobs=new ArrayList<String>();
		String[] total=new String[size*2];
		log.debug("len:"+total.length);
		for(int i=0;i<size;i++){
			total[i]=profession.get(i).getProfessionName();
			log.debug("total:"+total[i]);
		}
		
		for(int i=0;i<userSize;i++){
			for(int j=0;j<size;j++){
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
		
		int[] num=new int[size];
		for(int i=0;i<size;i++){
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
		//all phoneusers areaid
		List<Integer> allUserAreaId=new ArrayList<Integer>();
		for(int i=0;i<userSize;i++){
			int ids=users.get(i).getAreaId();
			allUserAreaId.add(ids);
			log.debug("ids"+i+":"+ids);
		}
		
		//获取该市下的所有区
		List<Tarea> areas=(List<Tarea>) etechComDao.findObjectList(Tarea.class, "cityId", cityId);
		int areaSize=areas.size();
		int len=areaSize+2;
		int thisCityNum=0;
		//最终名字与比例
		String[] areaPre=new String[len*2];
		//统计名字个数
		int[] areaNum=new int[len];
		//统计比例
		String[] preCent=new String[len];
		//该市下所有区id
		List<Integer> areaId=new ArrayList<Integer>();
		areaPre[0]="未知";
		areaPre[1]="其它地区";
		
		for(int i=0;i<areaSize;i++){
			areaPre[i+2]=areas.get(i).getAreaName();
			log.debug("areaName:"+areas.get(i).getAreaName());
			areaId.add(areas.get(i).getAreaId());
		}
		//
		int allUserAreaIdSize=allUserAreaId.size();
		for(int i=0;i<allUserAreaIdSize;i++){
			int userIdForArea=allUserAreaId.get(i);
			if(userIdForArea != -1){
				if(areaId.contains(userIdForArea)){
					for(int j=0;j<areaSize;j++){
						int id=areaId.get(j);
						if(id == userIdForArea){
							areaNum[j+2]++;
							thisCityNum++;
							log.debug("areaNum"+(j+2)+":"+areaNum[j+2]);
							log.debug("thisCityNum:"+thisCityNum);
							break;
						}
					}
				}else{
					areaNum[1]++;
					thisCityNum++;
					log.debug("areaNum[1]:"+areaNum[1]);
					log.debug("thisCityNum:"+thisCityNum);
				}
			}else{
				areaNum[0]++;
				thisCityNum++;
				log.debug("areaNum[0]:"+areaNum[0]);
				log.debug("thisCityNum:"+thisCityNum);
			}
			
		}
		
		
		DecimalFormat df=new DecimalFormat(".##");
		for(int k=0;k<areaSize+2;k++){
			preCent[k]=df.format(
							(double)areaNum[k]/thisCityNum*100);
			log.debug("areaPre"+k+":"+preCent[k]);
			areaPre[len++]=preCent[k];
		}
		
		return areaPre;
	}
	
@SuppressWarnings("unchecked")
public String[] getFavourite(List<Tphoneuser> user){
		
		List<Tfeature> list= (List<Tfeature>) etechComDao.findObjectList(Tfeature.class);
		List<Integer> allFeatureId=new ArrayList<Integer>();
		//特色总个数
		int listSize=list.size();
		//综合特色和比例
		String[] total=new String[listSize*2];
		//特色人数
		int[] num=new int[listSize];
		//遍历特色对象，获得特色id
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
			//获得每个粉丝的喜好对象
			List<Tphoneuserfeature> featureIdList=(List<Tphoneuserfeature>) etechComDao.findObjectList(Tphoneuserfeature.class, "phoneUserId", phoneId);
			
			//若
			int len=featureIdList.size();
			log.debug("len:"+len);
			for(int j=0;j<len;j++){
				log.debug("j:"+j);
				int featureId=featureIdList.get(j).getFeatureId();
				log.debug("featureId:"+featureId);
				for(int k=0;k<listSize;k++){
					if(featureId == allFeatureId.get(k)){
						num[k]++;
						log.debug("num"+k+":"+num[k]);
						break;
					}
				}
				
			}
		}
		DecimalFormat df=new DecimalFormat(".##");
		for(int i=0;i<listSize;i++){
			total[i+listSize]=df.format(
					(double)num[i]/user.size()*100);
			log.debug("num"+i+":"+num[i]);
			log.debug("length:"+length+";size:"+user.size());
		}
		return total;
	}
	
}
