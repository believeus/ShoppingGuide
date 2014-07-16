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
	<script language="JavaScript" src="js/jquery.js"></script>
	<style type="text/css">
		.s_main{
			width:1000px;
			height:auto;
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
		.stable p{
			line-height:60px;
			padding-left:40px;
			margin:0;
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
  <script type="text/javascript" src="/js/jquery.js"></script>
  <script type="text/javascript" src="/js/jquery.validate.js"></script>
  <script type="text/javascript">
  $(function(){
	  $("#validCode").click(function(){
		  var phoneNumber=$("#phoneNumber").val();
		  if(phoneNumber==""){
			  $("#phoneNumber").next().text("手机号必填!").css("color","red");
		  }else if(!(/^1[358]\d{9}$/.test(phoneNumber))){
			  $("#phoneNumber").next().text("手机号格式不正确!").css("color","red");
		  }else{
			  //将手机号码发送给webserivce,获取手机验证码
			  $.post("/achieveValidCode.jhtml", {phoneNumber:phoneNumber},"json");
		  }
	  });
	  $("#registerForm").validate({
			rules: {
				phoneNumber:{
					required: true,
					rangelength:[11,11],
					remote:"/validatePhoneNumber.jhtml"
				},
				password: {
					required: true,   
					rangelength:[6,16]
				},
	  			comfirmPwd:{
	  				required: true,
	  				equalTo:"#password"
	  			},
	  			numberCode:{
	  				required: true,
	  				remote:"/validatePhoneNumber.jhtml"
	  			}
			},
			messages: {
				phoneNumber:{
					required:"手机号必填",
					rangelength:"手机号码不足11位",
					remote:"手机号已被注册"
				},
				password: {
					required:"用户密码必填",
					rangelength:"密码长度在6-11位之间",
				},
				comfirmPwd:{
					required:"确认密码必填",
					equalTo:"与用户密码不一致!"
				}
			},
			errorPlacement: function(error, element) {  //验证消息放置的地方
		            error.appendTo(element.next().css("color","red"));   
		    },   
		    highlight: function(element, errorClass) {  //针对验证的表单设置高亮   
		            $(element).addClass(errorClass);   
		    }
		});
  });

  </script>
  <body bgcolor="#E7E8EB">
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
    	<div style="width:555px;height:30px;line-height:30px;margin-left:auto;margin-right:auto;">
    		<span><font color="red">*</font>为必填选项</span>
    		<span style="float:right;">已有帐号!<a href="/login.jhtml" style="color:red;">直接登录</a></span>
    	</div>
    	<form id="registerForm" action="#" method="post" autocomplete="off">
    	<div class="stable">
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">手机号码：</span>
    			<input type="text" id="phoneNumber" name="phoneNumber" placeholder="请输入手机号"
    				   style="width:345px;height:35px;line-height:35px;" 
    				   onkeyup="this.value=this.value.replace(/[^0-9-]+/,'')">
   				<span></span>
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">用户密码：</span>
    			<input type="password" id="password" name="password" placeholder="请输入密码"  style="width:345px;height:35px;line-height:35px;">
    			<span></span>
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">确定密码：</span>
    			<input type="password" id="comfirmPwd" name="comfirmPwd" placeholder="请输入确认密码" style="width:345px;height:35px;line-height:35px;">
    			<span></span>
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">用户昵称：</span>
    			<input type="text" id="nickName" name="nickName" placeholder="请输入昵称" style="width:345px;height:35px;line-height:35px;">
    			<span></span>
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">短信验证：</span>
    			<input type="text" name="numberCode" placeholder="请输入验证码" style="width:345px;height:35px;line-height:35px;">
    			<input class="btn" id="validCode" type="button" value="免费获取验证码">
   			</p>
   			<div class="btn_div">
   				<input type="submit" value="下一步">
			</div>
		</div>
		</form>
  	</div>
    
    <!-- 引用尾部页面 -->
    <jsp:include page="include/footer.jsp" flush="true" />
    
  </body>
</html>
