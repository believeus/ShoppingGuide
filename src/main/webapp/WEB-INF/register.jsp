<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="X-UA-Compatible" content="IE=7"/>
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
			border:1px solid #69cdcd;
			background:#69cdcd;
			color:#FFFFFF;
			border-radius:4px;
			cursor:pointer;
		}
	</style>
  </head>
  <script type="text/javascript" src="/js/jquery.js"></script>
  <script type="text/javascript" src="/js/jquery.validate.js"></script>
  <script type="text/javascript">
	 function timeCountDown(obj,wait){
		if(wait == 0){
			$(obj).removeAttr("disabled");
			$(obj).val("免费获取验证码");
			$(obj).css("background","#69CDCD");
			wait=60;
		}else{
			$(obj).attr("disabled","false");
			$(obj).val("("+wait+"秒后重新获取短信信息)");
			$(obj).css("background","#E7E8EB");
			wait--;
			setTimeout(function(){
				timeCountDown(obj,wait);
			},1000)
		}
	}
  $(function(){
	  
	 /*  $("#phoneNumber").blur(function(){
			var phoneNum =$(this).val();
			var regPartton=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; //验证手机号
			if(!regPartton.test(phoneNum)){
				alert("手机格式不正确！");
			}
		}); */
	  
	  $("#validCode").click(function(){
		  if($("#registerForm").validate().element($("#phoneNumber"))){
			  timeCountDown(this,60);
			  var phoneNumber=$("#phoneNumber").val();
			  $("#numberCode").next().text("");
			  if(phoneNumber==""){
				  $("#phoneNumber").next().text("手机号必填!").css("color","red");
			  }else if(!(/^1[358]\d{9}$/.test(phoneNumber))){
				  $("#phoneNumber").next().text("手机号格式不正确!").css("color","red");
			  }else{
				  $("#validCode").attr('disabled',"false");
				  //将手机号码发送给webserivce,获取手机验证码
				  $.post("/generateValidCode.jhtml", {phoneNumber:phoneNumber},function(data){
					  if(/[0-9]{4}/.test(data.returnCode)){
						  $("#validCode").attr('disabled',"true");
					  }else{
						  $("#validCode").attr('disabled',"false");
						  $("#numberCode").next().text("获取验证码失败,请重新获取").css("color","red");
					  }
				  },"json");
			  }
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
	  				remote:"/validateNumberCode.jhtml"
	  			}
			},
			messages: {
				phoneNumber:{
					required:"帐号必填",
					rangelength:"帐号格式不正确",
					remote:"帐号已被注册"
				},
				password: {
					required:"密码必填",
					rangelength:"密码长度在6-11位之间"
				},
				comfirmPwd:{
					required:"确认密码必填",
					equalTo:"与商户密码不一致!"
				},
				numberCode:{
					required:"验证码必填",
					remote:"验证码不匹配"
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
    	</div>
    	<form id="registerForm" action="/dealRegister.jhtml" method="post" autocomplete="off">
    	<div class="stable">
    		<p style="padding-left: 70px;">
    			<font color="red">*</font>
    			<span style="font-weight:bold;">帐号：</span>
    			<!--  onblur="if(this.value =='') this.value = '请输入手机号'" onfocus="if(this.value == '请输入手机号') this.value = ''" value="请输入手机号" -->
    			<input type="text" id="phoneNumber" name="phoneNumber" placeholder="请输入帐号" style="width:345px;height:30px;line-height:30px;" 
    				   onkeyup="this.value=this.value.replace(/[^0-9-]+/,'')">
   				<span></span>
   			</p>
    		<p style="padding-left: 70px;">
    			<font color="red">*</font>
    			<span style="font-weight:bold;">密码：</span>
    			<input type="password" id="password" name="password"  placeholder="请输入密码"  style="width:345px;height:30px;line-height:30px;">
    			<span></span>
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">重复密码：</span>
    			<input type="password" id="comfirmPwd" name="comfirmPwd" placeholder="请输入确认密码" style="width:345px;height:30px;line-height:30px;">
    			<span></span>
   			</p>
    		<p>
    			<font color="red">*</font>
    			<span style="font-weight:bold;">短信验证：</span>
    			<input type="text" id="numberCode" name="numberCode" placeholder="请输入验证码" style="width:345px;height:30px;line-height:30px;">
    			<span></span>
    			<input class="btn" id="validCode" type="button" value="免费获取验证码" style="width:auto;">
   			</p>
   			<div class="btn_div">
   				<input type="submit" value="下一步">
			</div>
		</div>
		</form>
  	</div>
    
    <!-- 引用尾部页面 -->
    <jsp:include page="include/footer.jsp" flush="true" />
    
    <!-- IE8兼容性 -->
    <!--[if IE 8]>
		<script type="text/javascript">
			$().ready(function(){
				$("input[type='submit']").click(function(){
					var phoneNumber = $("#phoneNumber").val();
					if(phoneNumber == ""){
						//alert("请输入帐号");
						easyDialog.open({
			                container: {
			                    header: '提示',
			                    content: '请输入帐号'
			                },
			                overlay: false
			            });
						return false;
					}else{
						var regPartton=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; //验证手机号
						if(!regPartton.test(phoneNumber)){
							//alert("手机格式不正确！");
							easyDialog.open({
				                container: {
				                    header: '提示',
				                    content: '手机格式不正确！'
				                },
				                overlay: false
				            });
							return false;
						}
					}
					var password = $("#password").val();
					if(password == ""){
						//alert("请输入密码");
						easyDialog.open({
			                container: {
			                    header: '提示',
			                    content: '请输入密码'
			                },
			                overlay: false
			            });
						return false;
					}else{
						if(password.length <6 || password.length >11){
							//alert(" 密码长度在6-11位之间");
							easyDialog.open({
				                container: {
				                    header: '提示',
				                    content: '密码长度在6-11位之间'
				                },
				                overlay: false
				            });
							return false;
						}
					}
					var comfirmPwd = $("#comfirmPwd").val();
					if(comfirmPwd == ""){
						//alert("请输入重复密码");
						easyDialog.open({
			                container: {
			                    header: '提示',
			                    content: '请输入重复密码'
			                },
			                overlay: false
			            });
						return false;
					}else{
						if(comfirmPwd != password){
							//alert("重复密码与密码不匹配");
							easyDialog.open({
				                container: {
				                    header: '提示',
				                    content: '重复密码与密码不匹配'
				                },
				                overlay: false
				            });
							return false;
						}
					}
					var numberCode = $("#numberCode").val();
					if(numberCode == ""){
						//alert("请输入验证码");
						easyDialog.open({
			                container: {
			                    header: '提示',
			                    content: '请点击获取验证码'
			                },
			                overlay: false
			            });
						return false;
					}else{
						$("#validCode").click(function(){
						  if($("#registerForm").validate().element($("#phoneNumber"))){
							  timeCountDown(this,60);
							  var phoneNumber=$("#phoneNumber").val();
							  $("#numberCode").next().text("");
							  if(phoneNumber==""){
								  $("#phoneNumber").next().text("手机号必填!").css("color","red");
							  }else if(!(/^1[358]\d{9}$/.test(phoneNumber))){
								  $("#phoneNumber").next().text("手机号格式不正确!").css("color","red");
							  }else{
								  $("#validCode").attr('disabled',"false");
								  //将手机号码发送给webserivce,获取手机验证码
								  $.post("/generateValidCode.jhtml", {phoneNumber:phoneNumber},function(data){
									  if(/[0-9]{4}/.test(data.returnCode)){
										  $("#validCode").attr('disabled',"true");
									  }else{
										  $("#validCode").attr('disabled',"false");
										  $("#numberCode").next().text("获取验证码失败,请重新获取").css("color","red");
									  }
									  var nCode = data.returnCode;
										if(numberCode != nCode){
											//alert("验证码不匹配");
											easyDialog.open({
								                container: {
								                    header: '提示',
								                    content: '验证码不匹配'
								                },
								                overlay: false
								            });
											return false;
										}
								  },"json");
							  }
						  }
					  });
					}
				});
			});
		</script>
	<![endif]-->
  </body>
</html>
