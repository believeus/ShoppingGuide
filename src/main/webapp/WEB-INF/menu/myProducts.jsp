<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.etech.variable.Variables" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的商品</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script language="JavaScript" src="js/jquery.js"></script>

<style type="text/css">
.s_main {
	width: 1000px;
	height: auto;
	overflow: hidden;
	margin: 20px auto;
	background: #FFFFFF;
}

.s_main input[type='button'] {
	height: 30px;
	background: #5AB5B6;
	border: 1px solid #5AB5B6;
	border-radius: 4px;
	color: #FFFFFF;
	cursor: pointer;
	margin-right: 10px;
	padding: 0 13px;
}

.s_main input[type='text'] {
	height: 30px;
	border: 2px solid #5AB5B6;
}

.pro_list {
	width: 228px;
	height: auto;
	overflow: hidden;
	float: left;
	/* margin-right: 40px; */
	margin-bottom: 25px;
	border:1px solid #e4e4e4;
	border-radius:4px;
	
	margin-right:20px;
}
.pro_list:hover {
	border:1px solid #59B5B4;
}

.pro_img {
	width: 230px;
	height: auto;
	min-height:32px;
	display:inline-block;
}

.pro_name {
	width: 230px;
	padding: 5px 3px;
	font-size: 17px;
}

.pro_spec {
	width: 230px;
	height: auto;
	line-height: 35px;
	padding: 5px 3px;
}

.pro_spec span {
	background: #EFEFEF;
	border-radius: 2px;
	height: 20px;
	margin-right: 10px;
	margin-bottom:10px;
	padding: 5px 15px;
	display:inline-block;
	line-height:20px;
}

.pro_dis {
	color: #8f8e8d;
	height: auto;
	line-height: 25px;
	text-indent: 20px;
	width: 222px;
	padding: 5px 3px;
}

.pro_hit {
	width: 225px;
	padding: 5px 3px;
	height:auto;
	overflow:hidden;
}

.pro_hit_span {
	background: #58B3B4;
	color: #FFFFFF;
	border-radius: 2px;
	padding: 0 4px;
	height: 25px;
	line-height: 25px;
	cursor: pointer;
	margin-right:3px;
}

.p_list01 {
 	width: 230px;
	height: auto;
	overflow: hidden;
	margin-bottom: 25px;
	float: left;
	margin-right: 25px;
}
.findPro{
	background:url(/images/bg.png);
	background-position:-356px -455px;
	width:32px;
	height:30px;
	position:absolute;
	right:150px;
	cursor:pointer;
}
.findPro:hover{
	border-left:2px solid #5AB5B6;
	width:30px;
	height:28px;
}
.addPro{
	background: url(/images/bg.png) repeat scroll 0 -324px rgba(0, 0, 0, 0);
    height: 25px;
    left: 150px;
    position: absolute;
    width: 20px;
}
.reload{
	background: url(/images/bg.png) repeat scroll -40px -355px rgba(0, 0, 0, 0);
    height: 25px;
    left: 230px;
    position: absolute;
    width: 20px;
}
.pageshow{
	background: url(/images/bg.png) repeat scroll 0 -355px rgba(0, 0, 0, 0);
    height: 25px;
    left: 370px;
    position: absolute;
    width: 20px;
}
.pro_hit_1{
	float:left;
	background:url(/images/bg.png);
	background-position:-358px -387px;
	width:75px;
	height:25px;
	text-align:right;
	color:#FFFFFF;
	line-height:25px;
}
.middle-money {
    background: url(/images/middle-money_bj.png) repeat-x scroll 0 0 rgba(0, 0, 0, 0);
    bottom: 0;
    color: #ffffff;
    font-family: "微软雅黑";
    font-size: 13px;
    font-weight: bold;
    height: 32px;
    line-height: 32px;
   	position: relative;
    text-align: center;
    width: 230px;
    margin-top:-32px;
    opacity:0.9;
    cursor:pointer;
    display:none;
}
.tick{
	width:60px;
	height:60px;
	background:url(/images/bg.png) repeat-x scroll 0 0 rgba(0, 0, 0, 0);
	background-position:-361px -319px;
	margin-left: 168px;
	position: absolute;
	/* left: 168px;
    position: relative;
    top: -154px; */
}
.selectPro{
	border: 1px solid #e4e4e4;
    height: 50px;
    left: 408px;
    position: absolute;
    text-align: center;
    width: 60px;
    display:none;
    margin-top:-6px;
}
.selectPro a{
	border-top: 1px dotted #ccc;
    display: block;
    font-size: 12px;
    height: 25px;
    line-height: 25px;
}
.selectPro a:hover{
	text-decoration:underline;
}
#allPro{
	border:1px solid #e4e4e4;
	margin-left: -2px;
    padding-left: 5px;
    padding-top: 4px;
}
.specigoods{
	width: 100px; 
	height: 30px; 
	float: left; 
	text-align: center; 
	line-height: 30px;
	cursor:pointer;
	background:#D9F2F2;
}
.specigoods:hover{
	background:#5AB5B6;
	color:#FFFFFF;
}
.current{
	background:#5AB5B6;
	color:#FFFFFF;
}
</style>
<script type="text/javascript">
	$().ready(function() {
		
		$("#allPro").mouseout(function(){
			$(".selectPro").hide();	
		}).mouseover(function(){
			$(".selectPro").show();	
		});
		$(".selectPro").mouseout(function(){
			$(".selectPro").hide();			
		}).mouseover(function(){
			$(".selectPro").show();	
		});
		
		//alert(window.location.href);
		var str = window.location.href;
		var url = str.substring(str.indexOf("&")+1,str.length);
		//alert("url="+url);
		if(url == "isOnSale=1"){
			$("#up").addClass("current");			
		}else if(url == "isOnSale=0"){
			$("#down").addClass("current");			
		}
			
		
		 var pros =  $(".pro_list");
		// alert(pros.length);
		 pros.each(function(){
			/* if($(this).find(".middle-money").attr("value") == "1"){
				$(this).find(".tick").css("display","block");
			}else{
				$(this).find(".tick").css("display","none");
			}  */
			$(this).hover(function(){
				$(this).find(".middle-money").css("display","block");
			},function(){
				$(this).find(".middle-money").css("display","none");
			});
			$(this).find(".middle-money").click(function(){
				if($(this).attr("value") == 0){
					if(confirm("确定要上架吗？")){
						$.ajax({
							type: "GET",
							url:"/updateIsOnSale.jhtml?isOnSale=0&goodsId="+$(this).attr("id"),
							success:function(data){
								location.replace(window.location.href);
								//$(this).attr("value") == "1";
							}
						});
						$(this).html("下架");
						$(this).parent().find(".tick").css("display","block");
					}
				}else{
					if(confirm("确定要下架吗？")){
						$.ajax({
							type: "GET",
							url:"/updateIsOnSale.jhtml?isOnSale=1&goodsId="+$(this).attr("id"),
							success:function(data){
								location.replace(window.location.href);
								//$(this).attr("value") == "0";
							}
						});
						$(this).html("上架");
						$(this).parent().find(".tick").css("display","none");
					}
				}
			});
		 });
		 
	});
</script>
</head>

<body bgcolor="">
	<!-- 引用尾部页面 -->
	<jsp:include page="../include/header.jsp" flush="true" />
	
	<div class="s_main">
		<p>所在位置：
			<a href="/menu.jhtml" title="菜单">菜单</a> >
   			<a href="/myShop.jhtml?shopId=${shopId }" title="我的店铺">我的店铺</a> >
			<a href="/myProducts.jhtml?shopId=${shopId }" title="商品列表">商品列表</a>
		</p>
		<p style="color: #69CDCD; font-size: 20px; padding-left: 25px;margin:0;line-height:40px;">商品列表</p>
		<img src="/images/line.png">
		<div style="margin: 10px 0px; width: 1000px; height: 40px;">
			<input type="button" value="添加" title="点击添加商品" style="padding:0 5px 0 25px;float:left;"
				onClick="javascript:window.location.href='/goodsAdd.jhtml?shopId=${shopId}'"><s class="addPro"></s>
			<input type="button" value="刷新" title="点击刷新" style="padding:0 5px 0 25px;float:left;"
				onClick="javascript:window.location.reload();"><s class="reload"></s>
			<input type="button" value="每页显示" style="padding:0 15px 0 5px;float:left;"><s class="pageshow"></s>
			<!-- 商品上下架 -->
			<div style="height: 30px; width: 230px; float: left;">
				<div id="up" class="specigoods" onClick="javascript:window.location.href='/isOnSale.jhtml?shopId=${shopId }&isOnSale=1'">上架商品</div>
				<div id="down" class="specigoods" onClick="javascript:window.location.href='/isOnSale.jhtml?shopId=${shopId }&isOnSale=0'">下架商品</div>
			</div>
			<div style="width: 100px; float: left; height: 30px; line-height: 30px;">
				共有<font color="#69CDCD">${size }</font>条数据
			</div>
			<form action="/searchProduct.jhtml" method="post" style="float:right;">
				<input type="hidden" name="shopId" value="${shopId }"/>
				<input type="text" name="key" style="float:right;">
				<input class="findPro" title="点击搜索商品" type="submit" value="" style="border:0;"/>
			</form>
		</div>
		<!-- 商品列表  第一列 -->
		<div class="p_list01">
			<c:forEach var="tgLi1" items="${tgoods1}">
				<div class="pro_list">
					<div class="pro_img">
						<span class="tick" style="display:none;"></span>
						<c:if test="${tgLi1.goodsDefaultPhotoUrl !=null}">
							<img src="<%=Variables.goodsPhotoURL %>${tgLi1.goodsDefaultPhotoUrl }" width="230">
						</c:if>
						<c:if test="${tgLi1.goodsPhotoUrl != '' && tgLi1.goodsDefaultPhotoUrl ==null}">
							<img src="<%=Variables.goodsPhotoURL %>${tgLi1.goodsPhotoUrl }" width="230">
						</c:if>
						<c:if test="${tgLi1.goodsDefaultPhotoUrl ==null}">
							
						</c:if>
						<span class="middle-money" id="${tgLi1.goodsId}" <c:if test="${tgLi1.goodsPhotoUrl ==''}">style="top:20px;"</c:if> value="${tgLi1.isOnSale}">
							<c:if test="${tgLi1.isOnSale =='0'}">
								上架
							</c:if>
							<c:if test="${tgLi1.isOnSale =='1'}">
								下架
							</c:if>
						</span>
					</div>
					<div class="pro_name">${tgLi1.goodsName}</div>
					<div class="pro_spec">
						<c:forEach var="feature" items="${tgLi1.features}" varStatus="status">
							<c:if test="${status.index %4 ==0 }">
								<span style="background:#0BB5D9;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==1 }">
								<span style="background:#49BF85;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==2 }">
								<span style="background:#E36B77;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==3 }">
								<span style="background:#F8B95A;color:#ffffff;">${feature.featureName }</span>
							</c:if>
						</c:forEach>
					</div>
					<div class="pro_dis" title="${tgLi1.introduction }">
		    			${fn:substring(tgLi1.introduction, 0, 28)}...
		   			</div> 
					<div class="pro_hit">
						<a href="/hitPraise.jhtml?goodsId=${tgLi1.goodsId }" title="点赞"><span class="pro_hit_1">${tgLi1.bePraisedCount}赞</span></a>
						<a href="/hitCount.jhtml?goodsId=${tgLi1.goodsId }" title="浏览"><span class="pro_hit_span" style="float:right;">${tgLi1.viewCount}点击</span></a>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- 商品列表  第二列 -->
		<div class="p_list01">
			<c:forEach var="tgLi1" items="${tgoods2}">
				<div class="pro_list">
					<div class="pro_img">
						<span class="tick" style="display:none;"></span>
						<c:if test="${tgLi1.goodsDefaultPhotoUrl !=null}">
							<img src="<%=Variables.goodsPhotoURL %>${tgLi1.goodsDefaultPhotoUrl }" width="230">
						</c:if>
						<c:if test="${tgLi1.goodsPhotoUrl != '' && tgLi1.goodsDefaultPhotoUrl ==null}">
							<img src="<%=Variables.goodsPhotoURL %>${tgLi1.goodsPhotoUrl }" width="230">
						</c:if>
						<c:if test="${tgLi1.goodsDefaultPhotoUrl ==null}">
							
						</c:if>
						<span class="middle-money" id="${tgLi1.goodsId}" <c:if test="${tgLi1.goodsPhotoUrl ==''}">style="top:20px;"</c:if> value="${tgLi1.isOnSale}">
							<c:if test="${tgLi1.isOnSale =='0'}">
								上架
							</c:if>
							<c:if test="${tgLi1.isOnSale =='1'}">
								下架
							</c:if>
						</span>
					</div>
					<div class="pro_name">${tgLi1.goodsName}</div>
					<div class="pro_spec">
						<c:forEach var="feature" items="${tgLi1.features}" varStatus="status">
							<c:if test="${status.index %4 ==0 }">
								<span style="background:#0BB5D9;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==1 }">
								<span style="background:#49BF85;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==2 }">
								<span style="background:#E36B77;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==3 }">
								<span style="background:#F8B95A;color:#ffffff;">${feature.featureName }</span>
							</c:if>
						</c:forEach>
					</div>
					<div class="pro_dis" title="${tgLi1.introduction }">
		    			${fn:substring(tgLi1.introduction, 0, 28)}...
		   			</div> 
					<div class="pro_hit">
						<a href="/hitPraise.jhtml?goodsId=${tgLi1.goodsId }" title="点赞"><span class="pro_hit_1">${tgLi1.bePraisedCount}赞</span></a>
						<a href="/hitCount.jhtml?goodsId=${tgLi1.goodsId }" title="浏览"><span class="pro_hit_span" style="float:right;">${tgLi1.viewCount}点击</span></a>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- 商品列表  第三列 -->
		<div class="p_list01">
			<c:forEach var="tgLi1" items="${tgoods3}">
				<div class="pro_list">
					<div class="pro_img">
						<span class="tick" style="display:none;"></span>
						<c:if test="${tgLi1.goodsDefaultPhotoUrl !=null}">
							<img src="<%=Variables.goodsPhotoURL %>${tgLi1.goodsDefaultPhotoUrl }" width="230">
						</c:if>
						<c:if test="${tgLi1.goodsPhotoUrl != '' && tgLi1.goodsDefaultPhotoUrl ==null}">
							<img src="<%=Variables.goodsPhotoURL %>${tgLi1.goodsPhotoUrl }" width="230">
						</c:if>
						<c:if test="${tgLi1.goodsDefaultPhotoUrl ==null}">
							
						</c:if>
						<span class="middle-money" id="${tgLi1.goodsId}" <c:if test="${tgLi1.goodsPhotoUrl ==''}">style="top:20px;"</c:if> value="${tgLi1.isOnSale}">
							<c:if test="${tgLi1.isOnSale =='0'}">
								上架
							</c:if>
							<c:if test="${tgLi1.isOnSale =='1'}">
								下架
							</c:if>
						</span>
					</div>
					<div class="pro_name">${tgLi1.goodsName}</div>
					<div class="pro_spec">
						<c:forEach var="feature" items="${tgLi1.features}" varStatus="status">
							<c:if test="${status.index %4 ==0 }">
								<span style="background:#0BB5D9;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==1 }">
								<span style="background:#49BF85;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==2 }">
								<span style="background:#E36B77;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==3 }">
								<span style="background:#F8B95A;color:#ffffff;">${feature.featureName }</span>
							</c:if>
						</c:forEach>
					</div>
					<div class="pro_dis" title="${tgLi1.introduction }">
		    			${fn:substring(tgLi1.introduction, 0, 28)}...
		   			</div> 
					<div class="pro_hit">
						<a href="/hitPraise.jhtml?goodsId=${tgLi1.goodsId }" title="点赞"><span class="pro_hit_1">${tgLi1.bePraisedCount}赞</span></a>
						<a href="/hitCount.jhtml?goodsId=${tgLi1.goodsId }" title="浏览"><span class="pro_hit_span" style="float:right;">${tgLi1.viewCount}点击</span></a>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- 商品列表  第四列 -->
		<div class="p_list01" style="margin-right:0;">
			<c:forEach var="tgLi1" items="${tgoods4}">
				<div class="pro_list">
					<div class="pro_img">
						<span class="tick" style="display:none;"></span>
						<c:if test="${tgLi1.goodsDefaultPhotoUrl !=null}">
							<img src="<%=Variables.goodsPhotoURL %>${tgLi1.goodsDefaultPhotoUrl }" width="230">
						</c:if>
						<c:if test="${tgLi1.goodsPhotoUrl != '' && tgLi1.goodsDefaultPhotoUrl ==null}">
							<img src="<%=Variables.goodsPhotoURL %>${tgLi1.goodsPhotoUrl }" width="230">
						</c:if>
						<c:if test="${tgLi1.goodsDefaultPhotoUrl ==null}">
							
						</c:if>
						<span class="middle-money" id="${tgLi1.goodsId}" <c:if test="${tgLi1.goodsPhotoUrl ==''}">style="top:20px;"</c:if> value="${tgLi1.isOnSale}">
							<c:if test="${tgLi1.isOnSale =='0'}">
								上架
							</c:if>
							<c:if test="${tgLi1.isOnSale =='1'}">
								下架
							</c:if>
						</span>
					</div>
					<div class="pro_name">${tgLi1.goodsName}</div>
					<div class="pro_spec">
						<c:forEach var="feature" items="${tgLi1.features}" varStatus="status">
							<c:if test="${status.index %4 ==0 }">
								<span style="background:#0BB5D9;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==1 }">
								<span style="background:#49BF85;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==2 }">
								<span style="background:#E36B77;color:#ffffff;">${feature.featureName }</span>
							</c:if>
							<c:if test="${status.index %4 ==3 }">
								<span style="background:#F8B95A;color:#ffffff;">${feature.featureName }</span>
							</c:if>
						</c:forEach>
					</div>
					<div class="pro_dis" title="${tgLi1.introduction }">
		    			${fn:substring(tgLi1.introduction, 0, 28)}...
		   			</div> 
					<div class="pro_hit">
						<a href="/hitPraise.jhtml?goodsId=${tgLi1.goodsId }" title="点赞"><span class="pro_hit_1">${tgLi1.bePraisedCount}赞</span></a>
						<a href="/hitCount.jhtml?goodsId=${tgLi1.goodsId }" title="浏览"><span class="pro_hit_span" style="float:right;">${tgLi1.viewCount}点击</span></a>
					</div>
				</div>
			</c:forEach>
		</div>
		
	</div>

		<!-- 引用尾部页面 -->
		<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
