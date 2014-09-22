<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="com.etech.variable.Variables" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>资讯详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="X-UA-Compatible" content="IE=8"/>
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
			background: #5ab5b6;
		    border-radius: 3px;
		    color: #fff;
		    float: right;
		    font-weight: bold;
		    height: 34px;
		    line-height: 34px;
		    margin-right: 40px;
		    text-align: center;
		    width: 70px;
		    cursor:pointer;
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
			clear: both;	
			height:50px;
			display: inline-block;
			width：1000px;
		}
		#netitl p:first-of-type {
			float:left;
			width:250px;
		}
		#netitl p:nth-child(2) {
			float:left;
			width:115px;
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
			<p>所在位置：
	   			<a href="http://<%=Variables.domainName %>/menu.jhtml" title="菜单">菜单</a> >
	   			<a href="http://<%=Variables.domainName %>/infoList.jhtml" title="潮流资讯">潮流资讯</a> >
	   			<a href="http://<%=Variables.domainName %>/information.jhtml?newsId=${news.newsId}" title="资讯详情">资讯详情</a>
			</p>
	    	<div>
	            <div>
	                <h2>${news.title}</h2>
	            </div>
	            <div class="butt01" style="margin-right:20px;" onClick="javascript:window.history.back();">
	            	返回
            	</div>
	        </div>
	        <div id="netitl">
	            <p style="width:250px;float:left;">发布时间：<span>${news.addTime}</span></p>
	            <p style="width:115px;float:left;">浏览量：<a>${news.viewCount}</a></p>
	            <p style="width:155px;float:left;">转至：<span>${news.newsFrom}</span></p>
	            <p style="width:480px;float:left;">原文链接：
	            	<a title="${news.originalUrl }">
	            		${fn:substring(news.originalUrl, 0, 50)}
	            		<c:if test="${fn:length(news.originalUrl) > 50 }">
	            			...
	            		</c:if>
            		</a>
            	</p>
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
