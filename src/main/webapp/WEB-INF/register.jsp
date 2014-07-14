<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.s_main{
			width:1000px;
			height::auto;
			overflow:hidden;
			margin:20px auto;
			background:#FFFFFF;
		}
		.stable{
			width:800px;
			height:auto;
			overflow:hidden;
			margin-left:auto;
			margin-right:auto;
		}
		.stable th{
			text-align:left;
		}
		.stable p{
			line-height:60px;
			padding-left:40px;
		}
		.stable p:hover{
			background:#EAFCFC;
		}
		.btn{
			width:140px;
			height:30px;
			border:1px solid #69CDCD;
			background:#69CDCD;
			color:#FFFFFF;
			border-radius:4px;
			cursor:pointer;
		}
		.btn_div{
			width:800px;
			height:auto;
			overflow:hidden;
			margin-left:auto;
			margin-right:auto;
			text-align:center;
			margin-bottom:5px;
		}
		.btn_div input{
			width:70px;
			height:30px;
			border:1px solid #CCCCCC;
			background:#CCCCCC;
			color:#FFFFFF;
			border-radius:4px;
			cursor:pointer;
		}
	</style>
  </head>
  
  <body bgcolor="#E7E8EB" style="margin:0;">
  	 <!-- 引用尾部页面 -->
    <jsp:include page="include/header.jsp" flush="true" />
    
    <div class="s_main">
    	<p style="font-size: 22px; margin: 10px 0px; padding-left: 35px;">
    		<font color="#69CDCD">商户注册</font> 
    		<font color="#AEAEAE">USER REGEDIT</font>
   		</p>
    	<p style="margin:10px 0;">
    		<img src="images/r1.jpg" width="1000">
    	</p>
    	<div style="width:600px;height:30px;line-height:30px;margin-left:auto;margin-right:auto;">
    		<span><font color="red">*</font>为必填选项</span>
    		<span style="float:right;">已有帐号!<a href="/login.jhtml" style="color:red;">直接登录</a></span>
    	</div>
    	<div class="stable">
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">用户名称：</span>
    			<input type="text" name="" style="width:345px;height:35px;line-height:35px;">
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">用户密码：</span>
    			<input type="password" name="" style="width:345px;height:35px;line-height:35px;">
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">确定密码：</span>
    			<input type="password" name="" style="width:345px;height:35px;line-height:35px;">
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">用户昵称：</span>
    			<input type="text" name="" style="width:345px;height:35px;line-height:35px;">
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">短信验证：</span>
    			<input type="text" name="" style="width:345px;height:35px;line-height:35px;">
    			<input class="btn" type="button" value="免费获取验证码">
   			</p>
   			<div class="btn_div">
   				<input type="button" value="下一步" style="">
			</div>
    	</div>
    </div>
    
    <!-- 引用尾部页面 -->
    <jsp:include page="include/footer.jsp" flush="true" />
    
  </body>
</html>