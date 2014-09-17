<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>关联帐号</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="X-UA-Compatible" content="IE=7"/>
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" src="js/jquery.js"></script>
	<script type="text/javascript" src="/js/jquery.validate.js"></script>
	<style type="text/css">
		body {
			font-family: Microsoft YaHei !important;	
			font-size:14px;
			margin:0px;
		}
		#titl_name {
			float:left;
			margin-left:30px;
			font-size:22px;
			color:#69cdcd;
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
		#titl {
			height:34px; 
			width:1000px; 
			margin-bottom:10px;
		}
		.nav_div{
			line-height:60px;
			padding-left:40px;
			margin:0;
		}
		.nav_div:hover{
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
			border:1px solid #69CDCD;
			background:#69CDCD;
			color:#FFFFFF;
			border-radius:4px;
			cursor:pointer;
		}
		input {
			width:340px; 
			height:28px; 
			padding: 0px 4px;
		}
		</style>
  </head>
  <script type="text/javascript">
  	$(function(){
  		$("#aboutUserNumForm").validate({
  			rules:{
  				oldPassword:{
  					required: true
  					//remote:"/ajaxMacthPwd.jhtml"
  				},
  				phoneNumber:{
  					required: true,
  					rangelength:[11,11]
  					//remote:"/validatePhoneNumber.jhtml"
  				},
  				aboutPsd:{
  					required: true,
  					rangelength:[6,18]
  				},
  				confirmPsd:{
  					required: true,
  					equalTo: "#aboutPsd"
  				}
  			},
  			messages:{
  				oldPassword:{
  					required:"旧密码必填！",
  					remote:"输入旧密码不正确"
  				},
  				phoneNumber:{
  					required:"关联帐号必填！",
  					rangelength:"电话格式不正确，请输入11位手机号"
  					//remote:"该关联帐号已被关联"
  				},
  				aboutPsd:{
  					required:"关联密码必填！",
  					rangelength:"密码长度6-18位，必须含有字母！"
  				},
  				confirmPsd:{
  					required:"确认密码必填！",
  					equalTo: "两次输入密码不一致！"
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
  <body>
  	<jsp:include page="../include/header.jsp"/>
	    <div class="stable" style="width:1000px; margin:0px auto; background-color:#fff;">
	    	
	    	<p style="margin-bottom: 0px;">所在位置：
				<a title="菜单" href="/menu.jhtml">菜单</a> &gt;
	   			<a title="关联帐号" href="/aboutUserNum.jhtml">关联帐号</a>
			</p>
	    	
	    	<form id="aboutUserNumForm" action="/relationCount.jhtml" method="post">
		    	<div style="padding-top:30px;">
		        	<div id="titl">
		                <div id="titl_name">
		                    <span>关联账号</span>&nbsp;&nbsp;
		                    <span style="color:#AEAEAE; text-transform:uppercase;">user associate</span>
		                </div>
		                <div style="width:500px;float:right;" class="btn_div">
		                	<input type="hidden" value="" id="returnValue">
		                	<input type="hidden" value="" id="returnValue_pn">
		                	<input id="queding" style="width:70px;height:30px;margin:0px 20px;margin-left:100px;" type="button" value="确定" /> 
		                	<iframe style="display: none;" name="yz" id="yz" src="" width="200" height="200"></iframe>
		                	<!-- <input style="margin:0px 20px;margin-left:100px;" type="submit" value="确定" /> --> 
	                		<input style="width:70px;height:30px;" onClick="javascript:window.history.back();" type="button" value="取消" />
                		</div>
		            </div>
		            <img src="/images/line.png" />
		        </div>
		        <div style="clear:right;">
			         
					<div class="nav_div">
						<font color="red" style="margin-left:150px;">*&nbsp;</font>
		    			<span style="font-weight:bold;">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
		    			<input type="password" id="oldPassword" name="oldPassword" placeholder="请输入旧密码"
		    				   style="width:345px;height:35px;line-height:35px;">
		   				<span></span>
					</div>
					<div class="nav_div">
						<font color="red" style="margin-left:150px;">*&nbsp;</font>
		    			<span style="font-weight:bold;">关联手机：</span>
		    			<input type="text" id="phoneNumber" name="phoneNumber" placeholder="请输入关联手机号"
		    				   style="width:345px;height:35px;line-height:35px;">
		   				<span></span>
					</div>
					<div class="nav_div">
						<font color="red" style="margin-left:150px;">*&nbsp;</font>
		    			<span style="font-weight:bold;">关联密码：</span>
		    			<input type="password" id="aboutPsd" name="aboutPsd"
		    				   style="width:345px;height:35px;line-height:35px;">
		   				<span></span>
					</div>
					<div class="nav_div">
						<font color="red" style="margin-left:150px;">*&nbsp;</font>
		    			<span style="font-weight:bold;">确认密码：</span>
		    			<input type="password" id="confirmPsd" name="confirmPsd"
		    				   style="width:345px;height:35px;line-height:35px;">
		   				<span></span>
					</div>
			            
		        </div>
			</form>
	    
		</div>
	<jsp:include page="../include/footer.jsp"/>
	<script type="text/javascript">
		$().ready(function(){
			$("#queding").click(function(){
				var returnValue = $("#returnValue").val();
				var returnValue_pn = $("#returnValue_pn").val();
	  			if(returnValue == "false" || returnValue == ""){
	  				easyDialog.open({
		                container: {
		                    header: '提示',
		                    content: '旧密码不正确'
		                },
		                overlay: false
		            });
	  			}else if(returnValue_pn == "false" || returnValue_pn == ""){
	  				easyDialog.open({
		                container: {
		                    header: '提示',
		                    content: '该关联帐号已被关联'
		                },
		                overlay: false
		            });
	  			}else{
	  				$("#aboutUserNumForm").submit();
	  			}
	  		});
			$("#oldPassword").blur(function(){
				$("#yz").attr("src","http://test.aileguang.net/ajaxMacthPwd.jhtml?oldPassword="+$("#oldPassword").val());
			});
			$("#phoneNumber").blur(function(){
				$("#yz").attr("src","http://test.aileguang.net/validatePhoneNumber2.jhtml?phoneNumber="+$("#phoneNumber").val());
			});
		});
	</script>
  </body>
</html>
