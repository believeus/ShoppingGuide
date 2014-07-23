<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆页面</title>

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
<script language="JavaScript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#login").click(function() {
			var userName = $("#userName").val();
			var password = $("#password").val();
			if(userName == "" || password == ""){
				$("#check").css("display","block");
				return false;
			}else{
				$.ajax({
					type : "post",
					url : "/ajaxLoginValid.jhtml",
					dataType : "json",
					data : $("#loginForm").serialize(),
					success : function(data) {
						if (data.message == "error") {
							//$("#msg").text("用户不存在!");
							$("#check").css("display","block");
							return false;
						}else if (data.message == "success") {
							location.href = "/menu.jhtml";
						}
					}
				});
			}
		});
		$("#register").click(function() {
			window.location.href = "/regist.jhtml";
		});
		
	});
</script>
</head>

<body>
	<div style="height:135px;width:100%;margin-top:-17px;">
    	<div style="width:960px; padding-top:28px; margin-left:auto; margin-right:auto;height:auto;overflow:hidden;">
        	<div style="float:left;">
        		<img src="images/Logo_.png"/>
            </div>
        	<div style="float:right; margin-top:40px; font-size:16px; color:#056F6F; line-height:0px;">
            	<p><a>关于爱乐逛</a></p>
            </div>
        </div>
	</div>
    
    <div style="width:100%; height:470px; background-color:#69CDCD;">
    	<div style="margin:0px auto; width:1000px; height:470px; background-image:url(images/computer.png); background-repeat: no-repeat;">
        	<div id="landdiv">
        	<form id="loginForm" action="/menu.jhtml" method="post">
            	<p class="log">
            		<b>账&nbsp;&nbsp;&nbsp;号：</b>
            		<input name="userName" id="userName" type="text" placeholder="请输入商户账号，或商场管理员账号" value=""/>
           		</p>
            	<p class="log" style="margin-bottom:12px;">
            		<b>密&nbsp;&nbsp;&nbsp;码：</b>
            		<input type="password" name="password" id="password" placeholder="请输入密码" value=""/>
           		</p>
                <p id="check" style="display: none; width:auto;">
                	<img src="/images/chacha.png" />&nbsp;
                    <span style="vertical-align:top; color:red; font-size:14px;">您输入的账户或密码不正确，请重新输入</span>
                </p>
            	
				<p id="check">
                    <span style="margin-left: 90px;">
                    	<a href="/findPsd.jhtml" title="找回密码">找回密码</a>
                   	</span>
                </p>
                <p id="check">
                    <span>没有商户账号？<a style="text-decoration:underline;color:red;" href="/register.jhtml">立即注册</a></span>
                </p>
                <div id="login">
                	<input class="sub_btn" type="button" value="登录"/> 
                </div>
               </form>
            </div>
        </div>
    </div>
    
    <!-- 引用尾部页面 -->
    <jsp:include page="include/footer.jsp" flush="true" />
    
</body>
</html>