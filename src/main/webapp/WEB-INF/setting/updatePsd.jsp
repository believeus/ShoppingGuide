<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
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
		table {
			padding:0px 45px;	
		}
		table tr {
			height:65px;
		}
		table td:first-of-type {
			width:155px;
			text-align:right;
		}
		table td:nth-child(2) {
			width:345px;	
		}
		table td:nth-child(3) {
			width:30px;	
		}
		table td:last-of-type {
			width:355px;	
		}
		input {
			width:340px; 
			height:28px; 
			padding: 0px 4px;;
		}
		</style>
  </head>
  <script type="text/javascript">
  	$(function(){
//   		验证旧密码
  		$("#oldPassword").blur(function(){
  			var oldPassword=$("#oldPassword").val();
  			$.ajax({
				type : "post",
				url : "/ajaxoldPwdValid.jhtml",
				dataType : "json",
				data :{"oldPassword":oldPassword} ,
				success : function(data) {
					if (data.message == "error") {
						//提示旧密码输入错误
						$("#oldPasswordMsg").css("display","block");
						$("#oldPasswordImg").css("display","block")[0].src="images/chacha.png";
					}else if (data.message == "success") {
						//
						$("#oldPasswordMsg").css("display","none");
						$("#oldPasswordImg").css("display","block")[0].src="images/good.gif";
					}else{
						$("#oldPasswordMsg").css("display","none");
						$("#oldPasswordImg").css("display","none");
					}
				}
			});
  			
  		});
  		
//		验证新密码
  		$("#newPwd").blur(function(){
  			var newPwd=$("#newPwd").val();
  			$.ajax({
				type : "post",
				url : "/ajaxnewPwdValid.jhtml",
				dataType : "json",
				data :{"newPwd":newPwd} ,
				success : function(data) {
					if (data.message == "error") {
						//提示新密码输入错误
						$("#newPwdMsg1").css("display","block");
						$("#newPwdMsg2").css("display","none");
						$("#newPwdImg").css("display","block")[0].src="images/chacha.png";
					}else if (data.message == "success") {
						//
						$("#newPwdMsg1").css("display","none");
						$("#newPwdMsg2").css("display","none");
						$("#newPwdImg").css("display","block")[0].src="images/good1.gif";
					}else{
						$("#newPwdMsg1").css("display","none");
						$("#newPwdMsg2").css("display","block");
						$("#newPwdImg").css("display","none");
					}
				}
			});
  			
  		});
//		验证两次密码输入相同		
  		$("#comfirmNewPwd").blur(function(){
  			
  			var newPwd=$("#newPwd").val();
  			var comfirmNewPwd=$("#comfirmNewPwd").val();
  			
  			$.ajax({
  				type : "post",
				url : "/ajaxcomparePwdValid.jhtml",
				dataType : "json",
				data :{"newPwd":newPwd,"comfirmNewPwd":comfirmNewPwd} ,
				success : function(data) {
					if (data.message == "error") {
						//提示旧密码输入错误
						$("#comfirmMsg").css("display","block");
						$("#comfirmImg").css("display","block")[0].src="images/chacha.png";
					}else if (data.message == "success") {
						//
						$("#comfirmMsg").css("display","none");
						$("#comfirmImg").css("display","block")[0].src="images/good2.gif";
					}else{
						$("#comfirmMsg").css("display","none");
						$("#comfirmImg").css("display","none");
					}
				}
  			});
  			
  		});
  		
  	});
  </script>
  <body>
  	<jsp:include page="../include/header.jsp"/>
    <div style="width:100%; ">
	    <div style="width:1000px; margin:0px auto; background-color:#fff;">
	    	<div style="padding-top:30px;">
	        	<div id="titl">
	                <div id="titl_name">
	                    <span>修改密码</span>&nbsp;&nbsp;
	                    <span style="color:#AEAEAE; text-transform:uppercase;">password change</span>
	                </div>
	                <div class="butt01"><p>确认</p></div>
	                <div class="butt01" onClick="javascript:window.history.back();" style="margin-right:20px;"><p>取消</p></div>
	            </div>
	            <img src="/images/line.png" />
	        </div>
	        <div style="clear:right;">
	        	<form id="updatePsdForm" method="post" action="">
		            <table>
		              <tr style="height:45px;">
		                <td></td>
		                <td><div><span style="color:red;">*</span>为必填选项</div></td>
		                <td></td>
		                <td></td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>旧&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：</b></td>
		                <td>
		                    <input id="oldPassword" name="oldPassword" type="password" placeholder="请输入旧密码" />
		                </td>
		                <td><img id="oldPasswordImg" style="display:none;" src="images/chacha.png" /></td>
		                <td>
		                    <div id="oldPasswordMsg" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">密码错误，请重新输入!</p>
		                    </div>
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>新&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：</b></td>
		                <td>
		                    <input id="newPwd" name="newPwd" type="password" placeholder="请输入新的密码" />
		                </td>
		                <td><img id="newPwdImg" style="display:none;" src="images/chacha.png" /></td>
		                <td>
		                	<div id="newPwdMsg1" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">输入格式不正确，请重新输入！</p>
		                    </div>
		                    <div id="newPwdMsg2" style="width:351px; height:31px; margin-bottom:14px; background-image:url(images/bg.png);background-position:-101px 407px;">
		                        <p style="line-height:28px; color:black; margin-left:20px;">密码长度6-18位，必须含有字母！</p>
		                    </div>
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>确认新密码：</b></td>
		                <td>
		                    <input id="comfirmNewPwd" name="comfirmNewPwd" type="password" placeholder="请再次输入新的密码" />
		                </td>
		                <td><img id="comfirmImg" style="display:none;" src="images/chacha.png" /></td>
		                <td>
		                	<div id="comfirmMsg" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">两次输入的密码不一致，请重新输入！</p>
		                    </div>
		                </td>
		              </tr>
		            </table>
	            </form>
	        </div>
	   </div>
	</div>
	<jsp:include page="../include/footer.jsp"/>
  </body>
</html>
