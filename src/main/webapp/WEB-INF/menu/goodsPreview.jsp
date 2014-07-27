<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
}
</style>
  </head>
  
  <body>
   <!-- 引用尾部页面 -->
    <jsp:include page="../include/header.jsp" flush="true" />
    <div id="div0">
	<div id="div01">
    	<p>时尚双肩包</p>
    </div>
    <div>
    	<img src="/images/img_tel.png" />
    </div>
    <div id="spn">
    	<span>潮流</span>
        <span>精致韩风</span>
        <span>欧美简约</span>
    	<span>潮流</span>
        <span>精致韩风</span>
        <span>欧美简约</span>
        <span>潮流</span>
        <span>精致韩风</span>
        <span>欧美简约</span>
    	<span>潮流</span>
        <span>精致韩风</span>
        <span>欧美简约</span>
    </div>
    <div style="margin:25px 38px; height:33px;">
    	<div id="titi_1"></div>
        <div id="titi_2">商品介绍</div>
    </div>
    <hr />
    <div id="sp1_font">
    	<p>商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍</p>
        <p>商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍商品介绍</p>
    </div>
    <div style="margin:50px auto 25px 38px; height:33px;">
    	<div id="titi_1"></div>
        <div id="titi_2">店铺信息</div>
    </div>
    <hr />
    <div id="sp2_rady">
    	<ol>
        	<li>时尚潮流专卖店</li>
            <li>秦园中路18号</li>
            <li>18612345678</li>
            <li>123456789</li>
        </ol>
        <div id="sp2_ra">
        	<p>
            	<span>123</span>
            </p>
            <p style="width:195px;">
           		<span>4567</span>
            </p>
            <p style="width:auto;">
            	<span>4567</span>
            </p>
        </div>
    </div>
    <div id="butt">
		<p>编辑</p>    
    </div>
</div>
	<!-- 引用尾部页面 -->
    <jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
