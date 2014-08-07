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
	<script type="text/javascript" src="js/jquery.promptu-menu.js"></script>
<style>
body {
	font-family: "Microsoft YaHei" ! important;
	font-size:10px;
}
#iphone {
	background-image:url(images/iPhone4s.png);
	background-repeat:no-repeat;
	padding:122px 0 0 23px;
	width:303px;
	height:541px;
	margin:auto;
}
#div_0 {
	width:278px; 
	/**height:429px; **/
}
#div01 {
	width: 278px;
	height: 56px;
	background-image: url(images/shop_titl.jpg);
	color: #fff;
	text-align: center;
}
#div01 p {
	display: inline-block;
	font-size: 16px;
	margin: 26px 0px 0px;
}
#spn {
	margin: 5px 13px;
}
#spn span {
	display: inline-block;
	margin: 2px;
	padding: 1px 5px;
	color: #fff;
	background-color: #69cdcd;
}
.titi_ {
	margin:5px 15px;
	height:33px;
}
.titi_ div:first-of-type {
	clear: left;
	float: left;
	width: 4px;
	height: 16px;
	background-color: #69cdcd;
}
.titi_ div:last-of-type {
	float: left;
	color: #00b4cb;
	font-size: 13px;
	margin-left: 4px;
}
hr {
	border-color: #FCFFFF;
	margin-top:-17px;
	margin-left:14px;
}
#sp1_font {
	margin: 10px 0 20px 26px;
}
#sp1_font p{
	margin: 4px 0px;
	color: #bbb;
}
#sp2_rady {
	width: 278px;
	height: 191px;
	color: #888888;
	background-image: url(images/shop.jpg);
}
#sp2_rady ol {
	list-style: none;
	margin: 0px;
	padding-left: 70px;
}
#sp2_rady li {
	font-size: 11px;
	line-height: 36px;
}
#sp2_ra {
	margin: 16px auto auto 55px;
}
#sp2_ra p {
	display: inline-block;
	font-size: 11px;
	margin: 0px;
	width: 80px;
}
#butt {
	width: 240px;
	height: 40px;
	background-color: #00B4CB;
	border: 1px solid #69cdcd;
	border-radius: 5px;
	margin: 0px auto 50px auto;
}
#butt p {
	margin: 0px;
	line-height: 40px;
	text-align: center;
	color: #fff;
	font-size: 13px;
	float:left;
	width:105px;
	cursor:pointer;
}
</style>
<script type="text/javascript">
	$().ready(function(){
		  $("#div_0").promptumenu({
			'columns': 3,
			'rows': 4,
			'direction': 'vertical',
			'width': 'auto',
			'height': 'auto',
			'pages': true,
			'showPage': true,
			'duration': 500,
			'inertia': 200
		});
		$(".promptumenu_window").css("height","417px");
	});
</script>
  </head>
  
  <body>
   <!-- 引用尾部页面 -->
    <jsp:include page="../include/header.jsp" flush="true" />

<div id="iphone">
    <div id="div_0">
   	  	<div id="div01">
            <p>${tgoods.goodsName }</p>
        </div>
            <div>
                <img src="<%=Variables.goodsPhotoURL %>${tgoods.goodsPhotoUrl }" width="278">
            </div>
            <div id="spn">
            	<c:forEach var="feature" items="${tgoods.features }">
			    	<span>${feature.featureName }</span>
			    </c:forEach>
            </div>
            <div class="titi_">
              <div></div>
              <div>商品介绍</div>
            </div>
            <hr />
            <div id="sp1_font">
                <p>${tgoods.introduction }</p>
            </div>
            <div class="titi_">
              <div></div>
                <div>店铺信息</div>
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
		            <p style="width: 85px;">
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
</div>
	<!-- 引用尾部页面 -->
    <jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
