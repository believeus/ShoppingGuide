<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
	<div style="height:135px;width:100%;background:#69CDCD;">
    	<div style="width:960px; padding-top:28px; margin-left:auto; margin-right:auto;">
        	<div style="float:left;">
        		<img src="images/Logo_b.png"/>
            </div>
        	<div style="float:right; margin-top:40px; font-size:16px; color:#056F6F; line-height:0px;">
            	<p><a>关于爱乐逛</a></p>
            </div>
        </div>
	</div>
  </body>
</html>
