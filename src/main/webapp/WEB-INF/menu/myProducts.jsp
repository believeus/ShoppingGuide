<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.etech.variable.Variables" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	height: 395px;
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
	width: 230px;
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
	width: auto;
/* 	width: 230px; */
	height: auto;
	overflow: hidden;
	margin-bottom: 25px;
	float: left;
	/* margin-right: 25px; */
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
    left: 378px;
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
    left: 0;
    line-height: 32px;
   /*  position: relative; */
    text-align: center;
    top: -178px;
    width: 230px;
    margin-top:-32px;
    opacity:0.9;
    cursor:pointer;
}
</style>
<script type="text/javascript">
	$().ready(function() {
		 var pros =  $(".pro_list");
		// alert(pros.length);
		 pros.each(function(){
			$(this).hover(function(){
				$(this).find(".middle-money").css("display","block");
			},function(){
				$(this).find(".middle-money").css("display","none");
			});
			$(this).find(".middle-money").click(function(){
				//alert($(this).find(".middle-money").text());
				//$(this).find(".middle-money").text() == "下架";
			});
		 });
		 
	});
</script>
</head>

<body bgcolor="">
	<!-- 引用尾部页面 -->
	<jsp:include page="../include/header.jsp" flush="true" />

	<div class="s_main">
		<p
			style="color: #69CDCD; font-size: 20px; padding-left: 25px;margin:0;line-height:40px;">商品列表</p>
		<img src="/images/line.png">
		<p>
			<input type="button" value="添加" title="点击添加商品" style="padding:0 5px 0 25px;"
				onClick="javascript:window.location.href='/goodsAdd.jhtml?shopId=${shopId}'"><s class="addPro"></s>
			<input type="button" value="刷新" title="点击刷新" style="padding:0 5px 0 25px;"
				onClick="javascript:window.location.reload();"><s class="reload"></s>
			<input type="button" value="每页显示" style="padding:0 15px 0 5px;"><s class="pageshow"></s>
			<span>共有<font color="#69CDCD">${size }</font>条数据</span>
			<input type="text" name="" style="float:right;">
			<s class="findPro" title="点击搜索商品" onClick="alert('xx');"></s>
		</p>
		<!-- 商品列表  第一列 -->
		<div class="p_list01">
			<c:forEach var="tgLi1" items="${tgLi}">
				<div class="pro_list">
					<div class="pro_img">
						<img src="<%=Variables.goodsPhotoURL %>${tgLi1.goodsPhotoUrl }" width="230" height="200">
						<span class="middle-money" style="display:none;">上架</span>
					</div>
					<div class="pro_name">${tgLi1.goodsName}</div>
					<div class="pro_spec">
						<c:forEach var="feature" items="${tgLi1.features}">
							<span>${feature.featureName }</span>
						</c:forEach>
					</div>
					<div class="pro_dis">
		    			${tgLi1.introduction}
		   			</div> 
					<div class="pro_hit">
						<span class="pro_hit_1">${tgLi1.bePraisedCount}赞</span>
						<span class="pro_hit_span" style="float:right;">${tgLi1.viewCount}点击</span>
					</div>
					<!-- <div class="middle-money">上架</div> -->
				</div>
			</c:forEach>
		</div>
		
	</div>

		<!-- 引用尾部页面 -->
		<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
