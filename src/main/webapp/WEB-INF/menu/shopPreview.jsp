<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>店铺预览</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="JavaScript" src="js/jquery.js"></script>
<style>
body {
	margin:0px;
	font-family: "Microsoft YaHei" ! important;
	font-size:22px;
	color:#999;
}
#div0 {
	width:645px; 
	margin:0px auto;
	border:1px solid #999;
	outline:2px solid #CCC;
}
#div01 {
	width:640px;
	height:129px;
	background-image:url(/images/shop_titl.jpg);
	color:#fff;
	text-align:center;
}
#div01 p {
	display:inline-block;
	margin:60px auto 0px;
	font-size:36px;
}
#spn {
	margin:10px 33px;	
}
#spn span {
	display:inline-block;
	margin:5px 5px;
	padding:3px 10px;
	color:#fff;
	background-color:#69cdcd;
}
#titi_1 {
	clear:left;
	float:left;
	width:8px;
	height:32px;
	background-color:#69cdcd;
}
#titi_2 {
	float:left;
	color:#38A0AB;
	font-size:24px;
	margin-left:10px;
}
hr {
	border-color:#FCFFFF;
	margin-left:38px;
	margin-top:-10px;
}
#sp1_font {
	margin:20px 65px;
}
#sp1_font p{
	margin:10px 0px;
}
#sp2_rady {
	width:645px; 
	height:455px; 
	color:#666;
	background-image:url(/images/shop.jpg);
	border-bottom:1px solid #C2C6C5; 
	outline:1px solid #C7CBCA;
}
#sp2_rady ol {
	list-style:none;
	
	margin:0px;
	padding-left:160px;
}
#sp2_rady li {
	font-size:26px;
	line-height:82px;
}
#sp2_ra {
	margin:40px auto auto 115px;
}
#sp2_ra p {
	display:inline-block;
	font-size:26px;
	margin:0px;
	width:185px;
}
#shop {
	background-color:#DEE3E6; 
	
}
#shop > div {
	display:inline-block;
	width:300px;
	margin-top:10px;
	margin-left:14px;
}
#shop > div > div {
	padding:5px;
	background-color:#fff;
	margin-top:15px;
	border-bottom:1px solid #BFBFBF;
	outline:2px solid #CCC;
}
#shop p {
	margin:auto 10px;
	color:#037C91;
}
#shop_spn {
	margin:0px 5px;	
}
#shop_spn span {
	display:inline-block;
	font-size:20px;
	margin:3px;
	padding:0px 5px;
	color:#fff;
	background-color:#69cdcd;
}
#shop_spn + div {
	margin:auto 10px;
}#shop_spn + div > span {
	display:inline-block;
	width:90px;
}
#gengduo {
	background-color:#DEE3E6;
	height:90px;
	padding-top:30px;
}
#gengduo div {
	text-align:center;
	font-size:32px;
	color:#33CCCC;
	text-decoration:underline;
}
</style>
  </head>
  
  <body>
  		<!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
  	<div id="div0">
	<div id="div01">
    	<p>${shop.shopName}</p>
    </div>
    <div>
    	<img src="/images/shop_img.jpg" />
    </div>
    <div id="spn">
    	<c:forEach var="feature" items="${shop.features }">
    		<span>${feature.featureName }</span>
    	</c:forEach>
    </div>
    <div id="sp2_rady">
    	<ol>
        	<li>时尚潮流专卖店</li>
            <li>${shop.address }</li>
            <li>${shop.phoneNumber }</li>
            <li>12312321321${shop.qq }</li>
        </ol>
        <div id="sp2_ra">
        	<p>
            	<span>${bePraisedCount }</span>
            </p>
            <p style="width:195px;">
           		<span>${shop.fansCount }</span>
            </p>
            <p style="width:auto;">
            	<span>${shop.viewCount }</span>
            </p>
        </div>
    </div>
    <div id="shop">
    	<div>
    	<!-- 商品列表 -->
    	<%-- <c:forEach var="" items="">
    		
    	</c:forEach> --%>
        	<div>
            	<img src="/images/img11.png" />
                <p>潮流水彩双袋双肩包</p>
                <div id="shop_spn">
                    <span>潮流</span>
                    <span>精致韩风</span>
                    <span>潮流</span>
                    <span>精致韩风</span>
                    <span>欧美简约</span>
                    <span>潮流</span>
                    <span>欧美简约</span>
                    <span>潮流</span>
                    <span>精致韩风</span>
                </div>
                <div>
                	<img src="/images/zhan.png" />
                    <span>123</span>
                    <img src="/images/browse.png" />
                    <span>4567</span>
                </div>
            </div>
            <div>
            	<img src="/images/img22.png" />
                <p>潮流水彩双袋双肩包</p>
                <div id="shop_spn">
                    <span>潮流</span>
                    <span>精致韩风</span>
                    <span>潮流</span>
                    <span>精致韩风</span>
                    <span>欧美简约</span>
                    <span>潮流</span>
                    <span>欧美简约</span>
                    <span>潮流</span>
                    <span>精致韩风</span>
                </div>
                <div>
                	<img src="/images/zhan.png" />
                    <span>123</span>
                    <img src="/images/browse.png" />
                    <span>4567</span>
                </div>
            </div>
        </div>
        <div>
        	<div>
            	<img src="/images/img22.png" />
                <p>潮流水彩双袋双肩包</p>
                <div id="shop_spn">
                    <span>潮流</span>
                    <span>精致韩风</span>
                    <span>潮流</span>
                    <span>精致韩风</span>
                    <span>欧美简约</span>
                    <span>潮流</span>
                    <span>欧美简约</span>
                    <span>潮流</span>
                    <span>精致韩风</span>
                </div>
                <div>
                	<img src="/images/zhan.png" />
                    <span>123</span>
                    <img src="/images/browse.png" />
                    <span>4567</span>
                </div>
            </div>
            <div>
            	<img src="/images/img11.png" />
                <p>潮流水彩双袋双肩包</p>
                <div id="shop_spn">
                    <span>潮流</span>
                    <span>精致韩风</span>
                    <span>潮流</span>
                    <span>精致韩风</span>
                    <span>欧美简约</span>
                    <span>潮流</span>
                    <span>欧美简约</span>
                    <span>潮流</span>
                    <span>精致韩风</span>
                </div>
                <div>
                	<img src="/images/zhan.png" />
                    <span>123</span>
                    <img src="/images/browse.png" />
                    <span>4567</span>
                </div>
            </div>
        </div>
    </div>
    <div id="gengduo">
    	<div>更多</div>
    </div>
</div>
 		<!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
