package com.etech.variable;

import com.etech.webutil.PropertiesUtils;


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
	public static Short webLogin=1;
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
	// the shop out of service
	public static final int outOfservice=3;
	//phone validate code
	public static final String validCode="validCode";
	public static final Integer marketId = 1;
	public static final String shopOwnerName = "shopOwnerName";
	public static final Short unRecommend = 0;
	public static final Short weiXinRecommend=1;
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
	// validate webservice QRCode
	public static final String webserviceQRCode=PropertiesUtils.findValue("shopping.properties", "webserviceQRCode");
	// validate webservice FindPassword
	public static final String webserviceFindPassword=PropertiesUtils.findValue("shopping.properties", "webserviceFindPassword");
	// the market image save path
	public static final String marketImgPath=PropertiesUtils.findValue("shopping.properties", "MarketImgPath");
	// the phone user head phone save path
	public static final String phoneUserHeadImgPath=PropertiesUtils.findValue("shopping.properties", "phoneUserHeadImgPath");
	// the advert image save path
	public static final String advertImgPath=PropertiesUtils.findValue("shopping.properties", "AdvertImgPath");
	// the shop image save path
	public static final String shopImgPath=PropertiesUtils.findValue("shopping.properties", "ShopImgPath");
	// the goods image save path
	public static final String goodsPhotoImgPath=PropertiesUtils.findValue("shopping.properties", "GoodsPhotoImgPath");
	// the shop QRCode
	public static final String shopQRCodePath=PropertiesUtils.findValue("shopping.properties", "ShopQRCodePath");
	// the shop licence save path
	public static final String shopLicenseImgPath=PropertiesUtils.findValue("shopping.properties", "ShopLicenseImgPath");
	// the shop logo save path
	public static final String shopsLogoImgPath=PropertiesUtils.findValue("shopping.properties", "ShopsLogoImgPath");
	// the er wei ma image save path
	public static final String shopQRCodeImgPath=PropertiesUtils.findValue("shopping.properties", "ShopQRCodeImgPath");
	// the shop user head image save path
	public static final String shopUserHeadImgPath=PropertiesUtils.findValue("shopping.properties", "shopUserHeadImgPath");
	// the find password image save path
	public static final String findPasswordImgPath=PropertiesUtils.findValue("shopping.properties", "FindPasswordImgPath");
	
	// the market img access url
	public static final String marketURL=PropertiesUtils.findValue("shopping.properties", "marketURL");
	// the phone User img access url
	public static final String phoneUserHeadURL=PropertiesUtils.findValue("shopping.properties", "phoneUserHeadURL");
	// the advert acccess url
	public static final String advertURL=PropertiesUtils.findValue("shopping.properties", "advertURL");
	// the shop image access url
	public static final String shopURL=PropertiesUtils.findValue("shopping.properties", "shopURL");
	// the goods photo image access url
	public static final String goodsPhotoURL=PropertiesUtils.findValue("shopping.properties", "goodsPhotoURL");
	// the shop license image access url
	public static final String shopLicenseURL=PropertiesUtils.findValue("shopping.properties", "shopLicenseURL");
	// the shop logo image access url
	public static final String shopsLogoURL=PropertiesUtils.findValue("shopping.properties", "shopsLogoURL");
	// the shop er wei ma image access url
	public static final String shopQRCodeURL=PropertiesUtils.findValue("shopping.properties", "shopQRCodeURL");
	// the shop user head image access url
	public static final String shopUserHeadURL=PropertiesUtils.findValue("shopping.properties", "shopUserHeadURL");
	// the shop find password image access url
	public static final String findPasswordURL=PropertiesUtils.findValue("shopping.properties", "findPasswordURL");
	// imagewidth
	public static final int imagewidth=Integer.parseInt(PropertiesUtils.findValue("shopping.properties", "imagewidth"));
	// the Domain name
	public static final String domainName=PropertiesUtils.findValue("shopping.properties", "domainName");

}
