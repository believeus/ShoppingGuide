<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<base href="<%=basePath%>">

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
	width: 230px;
	height: auto;
	overflow: hidden;
	float: left;
	/* margin-right: 40px; */
	margin-bottom: 25px;
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
	padding: 5px 15px;
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

.pro_hit span {
	background: #58B3B4;
	color: #FFFFFF;
	border-radius: 2px;
	padding: 0 4px;
	height: 25px;
	line-height: 25px;
	cursor: pointer;
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
}
</style>
<script type="text/javascript">
	$().ready(function() {
		
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
				onClick="javascript:window.location.href='/goodsAdd.jhtml'"><s class="addPro"></s>
			<input type="button" value="刷新" title="点击刷新" style="padding:0 5px 0 25px;"
				onClick="javascript:window.location.reload();"><s class="reload"></s>
			<input type="button" value="每页显示" style="padding:0 15px 0 5px;"><s class="pageshow"></s>
			<span>共有<font color="#69CDCD">1234</font>条数据</span>
			<input type="text" name="" style="float:right;">
			<s class="findPro" title="点击搜索商品" onClick="alert('sb');"></s>
		</p>
		<!-- 商品列表  第一列 -->
		<div class="p_list01">
			<c:forEach var="tgLi1" items="${tgLi1}">
				<div class="pro_list">
					<div class="pro_img">
						<img src="/images/1.jpg" width="230">
					</div>
					<div class="pro_name">${tgLi1.goodsName}</div>
					<div class="pro_spec">
						<span>潮流</span> <span>潮流</span>
					</div>
					<!-- <div class="pro_dis">
	    			撒旦认同感回家玩儿推广和儿童购和女斯蒂芬购层
	   			</div> -->
					<div class="pro_hit">
						<span class="pro_hit_1">${tgLi1.bePraisedCount}赞</span>
						<span style="float:right;">${tgLi1.viewCount}点击</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- 商品列表  第二列 -->
		<div class="p_list01">
			<c:forEach var="tgLi2" items="${tgLi2 }">
				<div class="pro_list">
					<div class="pro_img">
						<img src="/images/1.jpg" width="230">
					</div>
					<div class="pro_name">${tgLi2.goodsName}</div>
					<div class="pro_spec">
						<span>潮流</span> <span>潮流</span>
					</div>
					<!-- <div class="pro_dis">
	    			撒旦认同感回家玩儿推广和儿童购和女斯蒂芬购层
	   			</div> -->
					<div class="pro_hit">
						<span style="float:left;">${tgLi2.bePraisedCount}赞</span> <span
							style="float:right;">${tgLi2.viewCount}点击</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- 商品列表  第三列 -->
		<div class="p_list01">
			<c:forEach var="tgLi3" items="${tgLi3 }">
				<div class="pro_list">
					<div class="pro_img">
						<img src="/images/1.jpg" width="230">
					</div>
					<div class="pro_name">${tgLi3.goodsName}</div>
					<div class="pro_spec">
						<span>潮流</span> <span>潮流</span>
					</div>
					<!-- <div class="pro_dis">
	    			撒旦认同感回家玩儿推广和儿童购和女斯蒂芬购层
	   			</div> -->
					<div class="pro_hit">
						<span style="float:left;">${tgLi3.bePraisedCount}赞</span> <span
							style="float:right;">${tgLi3.viewCount}点击</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- 商品列表  第四列 -->
		<div class="p_list01" style="margin-right:0;">
			<c:forEach var="tgLi4" items="${tgLi4}">
				<div class="pro_list">
					<div class="pro_img">
						<img src="/images/1.jpg" width="230">
					</div>
					<div class="pro_name">${tgLi4.goodsName}</div>
					<div class="pro_spec">
						<span>潮流</span> <span>潮流</span>
					</div>
					<!-- <div class="pro_dis">
	    			撒旦认同感回家玩儿推广和儿童购和女斯蒂芬购层
	   			</div> -->
					<div class="pro_hit">
						<span style="float:left;">${tgLi4.bePraisedCount}赞</span> <span
							style="float:right;">${tgLi4.viewCount}点击</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

		<!-- 引用尾部页面 -->
		<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
