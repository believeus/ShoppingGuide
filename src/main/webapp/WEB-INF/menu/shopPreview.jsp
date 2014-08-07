<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="com.etech.variable.Variables" %>
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
	<script type="text/javascript" src="js/jquery.promptu-menu.js"></script>
<style>
body {
	font-family: "Microsoft YaHei" ! important;
	font-size:10px !important;
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
	background-color: #0ab5d9;
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
	color: #c7c7c7;
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
#shop {
	background-color: #dce5e5;	
}
#shop > div {
	display: inline-block;
	width: 126px;
	margin-left: 8px;
}
#shop > div > div {
	padding: 2px;
	background-color: #fff;
	margin-top: 10px;
	border-bottom: 1px solid #BFBFBF;
	outline: 1px solid #CCC;
}
#shop p {
	margin: 2px 4px;
	color: #0275a5;
}
#shop_spn {
	margin: 0px 3px;
}
#shop_spn span {
	display: inline-block;
	font-size: 8px;
	margin: 1px;
	padding: 0px 2px;
	color: #fff;
	background-color: #0cb6d7;
}
#shop_spn + div {
	margin: 2px 4px;
}#shop_spn + div > span {
	display: inline-block;
	width: 30px;
	color: #b0b0b0;
}
#gengduo {
	background-color: #DEE3E6;
	height: 25px;
	padding-top: 15px;
}
#gengduo div {
	text-align: center;
	font-size: 14px;
	color: #0db6dc;
	text-decoration: underline;
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
		$(".promptumenu_window").css("height","435px"); 
	});
</script>
  </head>
  
  <body>
	<!-- 引用尾部页面 -->
	<jsp:include page="../include/header.jsp" flush="true" />
	
	<div id="iphone">
		<div id="div_0">
	        <div id="div01">
	            <p>${shop.shopName }</p>
	        </div>
	        <div>
	        	<c:forEach var="path" items="${paths }">
		            <img src="<%=Variables.shopURL %>${path}" width="278"/>
	        	</c:forEach>
	        </div>
	        <div id="spn">
	        	<c:forEach var="feature" items="${shop.features }" varStatus="status">
	        		<c:if test="${status.index %2 ==1}">
		        		<span>${feature.featureName }</span>
	        		</c:if>
	        		<c:if test="${status.index %2 ==0}">
		        		<span style="background:#5fc996">${feature.featureName }</span>
	        		</c:if>
	        		<c:if test="${status.index %3 ==0}">
		        		<span style="background:#e26b77">${feature.featureName }</span>
	        		</c:if>
	        	</c:forEach>
	           <!--  <span>潮流</span>
	            <span style="background:#5fc996">精致韩风</span>
	            <span style="background:#e26b77">欧美简约</span> -->
	        </div>
	        <div id="sp2_rady">
	            <ol>
	                <li>${shop.shopName }</li>
	                <li>${shop.address }</li>
	                <li>${shop.phoneNumber }</li>
	                <li>${shop.qq }</li>
	            </ol>
	            <div id="sp2_ra">
	                <p>${shop.bePraisedCount }</p>
	                <p style="width:85px;">${shop.fansCount }</p>
	                <p style="width:auto;">${shop.viewCount }</p>
	            </div>
	        </div>
	        <div id="shop">
	            <div>
		            <c:forEach var="goods" items="${list1 }">
		            	<div>
		                    <img src="<%=Variables.goodsPhotoURL %>${goods.goodsPhotoUrl}" width="122"/>
		                    <p>${goods.goodsName }</p>
		                    <div id="shop_spn">
		                    	<c:forEach var="feature" items="${goods.features }">
			                        <span>${feature.featureName }</span>
		                    	</c:forEach>
		                    </div>
		                    <div>
		                        <img src="images/zhan.png" />
		                        <span>${goods.bePraisedCount }</span>
		                        <img src="images/browse.png" />
		                        <span>${goods.viewCount }</span>
		                    </div>
		              </div>
		            </c:forEach>
	            </div>
	            <div>
	                <c:forEach var="goods" items="${list2 }">
		            	<div>
		                    <img src="<%=Variables.goodsPhotoURL %>${goods.goodsPhotoUrl}" width="122"/>
		                    <p>${goods.goodsName }</p>
		                    <div id="shop_spn">
		                    	<c:forEach var="feature" items="${goods.features }">
			                        <span>${feature.featureName }</span>
		                    	</c:forEach>
		                    </div>
		                    <div>
		                        <img src="images/zhan.png" />
		                        <span>${goods.bePraisedCount }</span>
		                        <img src="images/browse.png" />
		                        <span>${goods.viewCount }</span>
		                    </div>
		              </div>
		            </c:forEach>
	            </div>
	        </div>
	        <div id="gengduo">
	            <div>更多</div>
	        </div>
		</div>
	</div>
	
	<!-- 引用尾部页面 -->
	<jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
