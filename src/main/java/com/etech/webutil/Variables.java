package com.etech.webutil;


public class Variables {
	// variables for loginName
	public static final String loginName="loginName";
	public static final String idcard="idcard";
	public static final String username="userName";
	public static final String phoneNumber="phoneNumber";
	public static final String sessionUser="sessionUser";
	public static final String man="男";
	public static final String woman="女";
	public static final int unRegister=-1;
	// the shopuser or shop reviewing
	public static final int reviewing=0;
	//the shopuser or shop review success
	public static final int reviewSuccess=1;
	// the shopuser of shop review unpass
	public static final int reviewUnpass=2;
	// the shopuser of shop  forbidden
	public static final int forbidden=3;
	// the shopuser of shop invalid
	public static final int invalid=4;
	//phone validate code
	public static final String validCode="validCode";
	public static final Integer marketId = 1;
	public static final String shopOwnerName = "shopOwnerName";
	public static final Short isRecommend = 0;
	public static final Short state = 0;
	public static final Integer initViewCount=0;
	public static final Integer bePraisedCount=0;
	public static final Integer initFansCount=0;
	public static final Double latitude=0.0;
	public static final Double longitude=0.0;
	public static final Integer parentId=1;
	public static final Short hasChild=0;
	public static final Short featureType=0;
	public static final Integer initCount=0;
	//validate webservice interface
	public static final String webserviceValidCode=PropertiesUtils.findValue("shopping.properties", "webserviceValidCode");
	public static String shopLicenseImgPath=PropertiesUtils.findValue("shopping.properties","ShopLicenseImgPath");;





}
