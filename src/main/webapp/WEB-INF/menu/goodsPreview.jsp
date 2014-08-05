<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.etech.variable.Variables" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品预览</title>
    
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
#butt {
	width:570px;
	height:100px;
	background-color:#00B4CB;
	border:1px solid #69cdcd;
	border-radius:10px;
	margin:0px auto 50px auto;
}
#butt p {
	margin:0px;
	line-height:100px;
	text-align:center;
	color:#fff;
	font-size:28px;
	width:275px;
	float:left;
	cursor:pointer;
}
</style>
  </head>
  
  <body>
   <!-- 引用尾部页面 -->
    <jsp:include page="../include/header.jsp" flush="true" />
    <div id="div0">
	<div id="div01">
    	<p>${tgoods.goodsName }</p>
    </div>
    <div>
    	<c:if test="${tgLi1.goodsPhotoUrl ==''}">
			
		</c:if>
		<c:if test="${tgLi1.goodsPhotoUrl !=''}">
			<img src="<%=Variables.goodsPhotoURL %>${tgoods.goodsPhotoUrl }" width="645">
		</c:if>
    </div>
    <div id="spn">
    <c:forEach var="feature" items="${tgoods.features }">
    	<span>${feature.featureName }</span>
    </c:forEach>
    </div>
    <div style="margin:25px 38px; height:33px;">
    	<div id="titi_1"></div>
        <div id="titi_2">商品介绍</div>
    </div>
    <hr />
    <div id="sp1_font">
    	<p>${tgoods.introduction }</p>
    </div>
    <div style="margin:50px auto 25px 38px; height:33px;">
    	<div id="titi_1"></div>
        <div id="titi_2">店铺信息</div>
    </div>
    <hr />
    <div id="sp2_rady">
    	<ol>
        	<li>${shop.shopName }</li>
            <li>${shop.address }</li>
            <li>${shop.phoneNumber }</li>
            <li>${shop.qq }</li>
        </ol>
        <div id="sp2_ra">
        	<p>
            	<span>${shop.bePraisedCount }</span>
            </p>
            <p style="width:195px;">
           		<span>${shop.fansCount }</span>
            </p>
            <p style="width:auto;">
            	<span>${shop.viewCount }</span>
            </p>
        </div>
    </div>
    <div id="butt">
		<p style="margin-right:20px;" title="提交" onClick="javascript:window.location.href='/myProducts.jhtml?shopId=${shop.shopId}'">提交</p>    
		<p title="取消" onClick="javascript:window.location.href='/deletePro.jhtml?goodsId=${tgoods.goodsId}'">取消</p>    
    </div>
</div>
	<!-- 引用尾部页面 -->
    <jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
