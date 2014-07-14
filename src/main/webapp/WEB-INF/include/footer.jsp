<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'footer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#botto {
			float:left; 
			width:850px; 
			font-size:12px;
			color:#666; 
			margin:40px 0px;
		}
		a{
			text-decoration:none;
		}
		body{
			margin:0;
		}
	</style>
  </head>
  
  <body>
    <div style="width:100%;height:auto; margin:0;overflow:hidden;text-align:center;background:#FFFFFF;">
    	<div id="botto">
        	<p><a>下载APP</a><span>  丨  我的微信：爱乐逛、爱乐逛助手  丨  我们的微博：武汉爱乐逛  丨</span><a>关于爱乐逛</a></p>
            <p><span>客服邮箱：kefu@aileguang.com</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>版权所有：武汉谦通科技有限公司</span></p>
        </div>
        <div style="float:left; margin:40px 0px;">
        	<img src="images/telephone.png" />
        </div>
    </div>
  </body>
</html>
