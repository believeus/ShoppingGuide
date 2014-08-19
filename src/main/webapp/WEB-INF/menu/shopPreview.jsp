<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<style type="text/css">
	#banner {position:relative; width:278px; height:auto; border:1px solid #666; overflow:hidden;}
	#banner_list{width:278px;height:auto;}
	#banner_list img {border:0px;}
	#banner_bg {position:absolute; bottom:0;background-color:#000;height:30px;filter: Alpha(Opacity=30);opacity:0.3;z-index:1000;
	cursor:pointer; width:278px; }
	#banner_info{position:absolute; bottom:0; left:5px;height:22px;color:#fff;z-index:1001;cursor:pointer}
	#banner_text {position:absolute;width:120px;z-index:1002; right:3px; bottom:3px;}
	#banner ul {position:absolute;list-style-type:none;filter: Alpha(Opacity=80);opacity:0.8; border:1px solid #fff;z-index:1002;
	margin:0; padding:0; bottom:3px; right:5px;}
	#banner ul li { padding:0px 8px;float:left;display:block;color:#FFF;border:#e5eaff 1px solid;background:#6f4f67;cursor:pointer}
	#banner ul li.on { background:#900}
	/* #banner_list a{position:absolute;}  */
</style>
<script type="text/javascript">
	$().ready(function(){
		 $("#div_0").promptumenu({
			'columns': 2,
			'rows': 20,
			'direction': 'vertical',
			'width': 'auto',
			'height': 'auto',
			'pages': true,
			'showPage': true,
			'duration': 500,
			'inertia': 200
		});
		$(".promptumenu_window").css("height","415px"); 
	});
</script>
<script type="text/javascript">
		var t = n = 0, count;
		$(document).ready(function(){
		count=$("#banner_list a").length;
		$("#banner_list a:not(:first-child)").hide();
		$("#banner_info").html($("#banner_list a:first-child").find("img").attr('alt'));
		$("#banner_info").click(function(){window.open($("#banner_list a:first-child").attr('href'), "_blank")});
		$("#banner li").click(function() {
		var i = $(this).text() - 1;
		n = i;
		if (i >= count) return;
		$("#banner_info").html($("#banner_list a").eq(i).find("img").attr('alt'));
		$("#banner_info").unbind().click(function(){window.open($("#banner_list a").eq(i).attr('href'), "_blank")})
		$("#banner_list a").filter(":visible").fadeOut(500).parent().children().eq(i).fadeIn(1000);
		document.getElementById("banner").style.background="";
		$(this).toggleClass("on");
		$(this).siblings().removeAttr("class");
		});
		t = setInterval("showAuto()", 4000);
		$("#banner").hover(function(){clearInterval(t)}, function(){t = setInterval("showAuto()", 4000);});
		})
	
		function showAuto()
		{
		n = n >=(count - 1) ? 0 : ++n;
		$("#banner li").eq(n).trigger('click');
		}
	</script>
  </head>
  
  <body>
	<!-- 引用尾部页面 -->
	<jsp:include page="../include/header.jsp" flush="true" />
	<div style="width:1000px;margin:0 auto;">
		<p style="font-size: 14px;">所在位置：
			<a title="菜单" href="/menu.jhtml">菜单</a> &gt;
	  		<a title="我的店铺" href="/myShop.jhtml?shopId=${shop.shopId }">我的店铺</a> &gt;
			<a title="店铺预览" href="/shopPreview.jhtml?shopId=${shop.shopId }">店铺预览</a>
		</p>
		<p style="color: #69CDCD; font-size: 20px; padding-left: 25px;margin:0;line-height:40px;">
			店铺预览
			<input type="button" value="返回" onClick="window.history.back();" style="float:right;background:#5ab5b6;border: 1px solid #5ab5b6;border-radius: 4px;color: #ffffff;cursor: pointer;height: 30px;margin-right: 10px;padding: 0 13px;">	
		</p>
		<img src="/images/line.png">
	</div>
	<div id="iphone">
		<div id="div_0">
	        <div id="div01">
	            <p>${shop.shopName }</p>
	        </div>
	        <div>
	        	<div id="banner">
					<div id="banner_bg"></div> 
					<div id="banner_info"></div> 
					<ul>
						<c:forEach items="${paths }" var="path" varStatus="status">
							<li <c:if test="${status.index ==0 }"> class="on" </c:if> >${status.index+1}</li>
						</c:forEach>
					</ul>
					<div id="banner_list">
						<c:forEach items="${paths }" var="path">
							<a href="javascript:void(0);" title="">
								<img src="<%=Variables.shopURL %>${path }" title="" alt="" width="278" />
							</a>
						</c:forEach>
					</div>
				</div>
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
		                    <img src="<%=Variables.goodsPhotoURL %>${goods.shopId}/${goods.goodsPhotoUrl}" width="122"/>
		                    <p>${goods.goodsName }</p>
		                    <div id="shop_spn">
		                    	<c:forEach var="feature" items="${goods.features }" varStatus="status">
			                        <c:if test="${status.index %4 ==0 }">
										<span style="background:#0BB5D9;color:#FFFFFF;">${feature.featureName }</span>
									</c:if>
									<c:if test="${status.index %4 ==1 }">
										<span class="p_speci_p" style="background:#49BF85;color:#FFFFFF;">${feature.featureName }</span>
									</c:if>
									<c:if test="${status.index %4 ==2 }">
										<span class="p_speci_p" style="background:#E36B77;color:#FFFFFF;">${feature.featureName }</span>
									</c:if>
									<c:if test="${status.index %4 ==3 }">
										<span class="p_speci_p" style="background:#F8B95A;color:#FFFFFF;">${feature.featureName }</span>
									</c:if>
		                    	</c:forEach>
		                    </div>
		                    <div style="color:#555555;" title="${goods.introduction }">
		                    	${fn:substring(goods.introduction, 0, 20)}...	
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
		                    <img src="<%=Variables.goodsPhotoURL %>${goods.shopId}/${goods.goodsPhotoUrl}" width="122"/>
		                    <p>${goods.goodsName }</p>
		                    <div id="shop_spn">
		                    	<c:forEach var="feature" items="${goods.features }">
			                        <span>${feature.featureName }</span>
		                    	</c:forEach>
		                    </div>
		                    <div style="color:#555555;" title="${goods.introduction }">
		                    	${fn:substring(goods.introduction, 0, 20)}...	
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
