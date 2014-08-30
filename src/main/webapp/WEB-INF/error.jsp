<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8"/>
<title>错误页面</title>

<style type="text/css">
body {
	font-family: Microsoft YaHei !important;	
	font-size:14px;
	margin:0px;
}
#landdiv {
	float:left; 
	width:360px;
	height:270px; 
	margin-top:125px; 
	margin-left:640px;
}
.log {
	font-size:15px;
}
#landdiv input[type='text']{
	height:35px;
	width:260px;
	padding-left:8px;
}
#landdiv input[type='password']{
	height:35px;
	width:260px;
	padding-left:8px;
}
-webkit-input-placeholder{
	color:#CCC;
}
:-moz-placeholder{ 
	color:#CCC;
}

#check {
	margin:0px 0px 8px 58px;
	font-size:14px;
}
#check span{
	color:#666;
}
#login {
	width:140px;
	height:35px;
	background-color:#69CDCD;
	border-radius:3px;
	font-size:16px;
	color:#fff;
	margin:15px auto;
	cursor:pointer;
}
#login p {
	line-height:35px;
	margin:0px;
	text-align:center;
	cursor:pointer;
}
.sub_btn{
	border:1px solid #69CDCD;
	background:#69CDCD;
	color:#FFFFFF;
	width:135px;
	height:35px;
	cursor:pointer;
}
</style>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="/js/jquery.js"></script>
<script language="JavaScript" src="/js/jquery.validate.js"></script>
</head>

<body>
	<jsp:include page="include/header.jsp" flush="true" />
    
    <div style="margin: 0px auto; width: 1000px; text-align: center; font-size: 16px; height: 330px; line-height: 330px;">
    	<span>您的操作出现错误。<a href="/menu.jhtml" title="点击返回首页">点击返回首页</a></span>
    </div>
    <!-- 引用尾部页面 -->
    <jsp:include page="include/footer.jsp" flush="true" />
    
</body>
</html>