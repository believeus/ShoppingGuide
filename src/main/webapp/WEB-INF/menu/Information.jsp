<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>资讯详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" src="js/jquery.js"></script>
	<style>
		h2 {
			float:left;
			margin:4px auto 25px auto;
			font-size:24px;
		}
		.butt01 {
			background-color:#5AB5B6; 
			height:34px;
			width:70px; 
			height:34px; 
			border-radius:3px; 
			float:right;
			margin-right:40px;
		}
		.butt01 p {
			line-height:34px; 
			color:#FFF; 
			font-weight:bold; 
			font-size:15px; 
			margin:auto;
			text-align:center;
			cursor:pointer;
		}
		#netitl {
			clear:left;	
			height:50px;
		}
		#netitl p:first-of-type {
			float:left;
			width:270px;
		}
		#netitl p:nth-child(2) {
			float:left;
			width:125px;
		}
		#netitl p:nth-child(3) {
			float:left;
			width:155px;
		}
		#netitl p:nth-child(4) {
			float:left;
		}
		hr {
			border:1px solid #CCC;
		}
		#img_ {
			margin:40px auto;
			width:710px;
		}
		#tes1 {
			letter-spacing: 1px;
		    line-height: 35px;
		    margin: auto;
		    text-indent: 30px;
		    width: 815px;
		}
	</style>
  </head>
  
  <body>
	<!-- 引用尾部页面 -->
	 <jsp:include page="../include/header.jsp" flush="true" />
    <div>
		<div style="width:1000px; margin:auto; padding-top:30px;">
	    	<div>
	            <div>
	                <h2>${news.title}</h2>
	            </div>
	            <div class="butt01"><p>确认</p></div>
	            <div class="butt01" style="margin-right:20px;" onClick="javascript:window.history.back();"><p>取消</p></div>
	        </div>
	        <div id="netitl">
	            <p>发布时间：<span>${news.addTime}</span></p>
	            <p>浏览量：<a>${news.viewCount}</a></p>
	            <p>转至：<span>${news.newsFrom}</span></p>
	            <p>原文链接：<a>${news.originalUrl}</a></p>
	        </div>
	       <img src="/images/line.png">
	        
	        <div id="tes1">
	        	${news.content}
	        </div>
	    </div>
	</div>
	 <!-- 引用尾部页面 -->
 	<jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
