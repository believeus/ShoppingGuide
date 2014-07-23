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
/* 			width:45px;	 */
/* 			padding-left:10px; */
		}
		table td:last-of-type {
			width:350px;	
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
  		
//   		验证当前帐号密码
  		$("#password").blur(function(){
  			var password=$("#password").val();
  			$.ajax({
  				type : "post",
				url : "/ajaxAssociatePasswordValid.jhtml",
				dataType : "json",
				data :{"password":password} ,
				success : function(data) {
					if (data.message == "error") {
						//提示当前帐号密码输入错误
						$("#passwordMsg").css("display","block");
						$("#passwordImg").css("display","block")[0].src="images/chacha.png";
					}else if(data.message == "success"){
						//
						$("#passwordMsg").css("display","none");
						$("#passwordImg").css("display","block")[0].src="images/good.gif";
					}else if(data.message == "nu"){
						$("#passwordMsg").css("display","none");
						$("#passwordImg").css("display","none");
						
					}
				}
  			});
  		});
  		
//   		验证关联帐号
  		$("#aboutUser").blur(function(){
  			var aboutUser=$("#aboutUser").val();
  			$.ajax({
  					type : "post",
  					url : "/ajaxAssociateUserValid.jhtml",
  					dataType : "json",
  					data :{"aboutUser":aboutUser} ,
  					success : function(data) {
  						if (data.message == "error") {
  							//提示帐号为空
  							$("#userMsg1").css("display","block");
  							$("#userMsg2").css("display","none");
  							$("#userImg").css("display","block")[0].src="images/chacha.png";
  						}else if(data.message == "success"){
  							//
  							$("#userMsg1").css("display","none");
  							$("#userMsg2").css("display","none");
  							$("#userImg").css("display","block")[0].src="images/good1.gif";
  						}else{
  							$("#userMsg1").css("display","none");
  							$("#userMsg2").css("display","block");
  							$("#userImg").css("display","none");
  						}
  					}
  			});
  		});
  		
//   		验证关联帐号密码
		$("#aboutPwd").blur(function(){
			var aboutPwd=$("#aboutPwd").val();
			$.ajax({
				type : "post",
				url : "/ajaxAssociateNewPwdValid.jhtml",
				dataType : "json",
				data :{"aboutPwd":aboutPwd} ,
				success : function(data) {
					if (data.message == "error") {
						//提
						$("#pwdMsg1").css("display","block");
						$("#pwdMsg2").css("display","none");
						$("#aboutPwdImg").css("display","block")[0].src="images/chacha.png";
					}else if (data.message == "success") {
						//
						$("#pwdMsg1").css("display","none");
						$("#pwdMsg2").css("display","none");
						$("#aboutPwdImg").css("display","block")[0].src="images/good2.gif";
					}else{
						$("#pwdMsg1").css("display","none");
						$("#pwdMsg2").css("display","block");
						$("#aboutPwdImg").css("display","none");
					}
				}
			});
		});
  		
//   		验证两次密码输入相同
  		$("#comfirmPwd").blur(function(){
  			var aboutPwd=$("#aboutPwd").val();
  			var comfirmPwd=$("#comfirmPwd").val();
  			
  			$.ajax({
  				type : "post",
				url : "/ajaxAssociateComparePwdValid.jhtml",
				dataType : "json",
				data :{"aboutPwd":aboutPwd,"comfirmPwd":comfirmPwd} ,
				success : function(data) {
					if (data.message == "error") {
						$("#confirmpwdMsg").css("display","block");
						$("#comfirm").css("display","block")[0].src="images/chacha.png";
					}else if(data.message == "success"){
						$("#confirmpwdMsg").css("display","none");
						$("#comfirm").css("display","block")[0].src="images/good3.gif";
					}else{
						$("#confirmpwdMsg").css("display","none");
						$("#comfirm").css("display","none");
					}
				}
  			});
  			
  		});
  		
  	});
  </script>
  <body>
  	<jsp:include page="../include/header.jsp"/>
	    <div style="width:1000px; margin:0px auto; background-color:#fff;">
	    	<div style="padding-top:30px;">
	        	<div id="titl">
	                <div id="titl_name">
	                    <span>关联账号</span>&nbsp;&nbsp;
	                    <span style="color:#AEAEAE; text-transform:uppercase;">user associate</span>
	                </div>
	                <div class="butt01"><p>确认</p></div>
	                <div class="butt01" style="margin-right:20px;"><p>取消</p></div>
	            </div>
	            <img src="/images/line.png" />
	        </div>
	        <div style="clear:right;">
	            <table>
	              <tr style="height:45px;">
	                <td></td>
	                <td><div style="font-size:13px;"><span style="color:red;">*</span>为必填选项</div></td>
	                <td></td>
	                <td></td>
	              </tr>
	              <tr>
	                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</b></td>
	                <td>
	                    <input type="password" placeholder="请输入当前主账号的密码" />
	                </td>
	                <td><img src="images/chacha.png" /></td>
	                <td>
	                    <div style="width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
	                        <p style="line-height:28px; color:red; margin-left:20px;">密码不能为空</p>
	                    </div>
	                </td>
	              </tr>
	              <tr>
	                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</b></td>
	                <td>
	                    <input type="text" placeholder="请输入要关联的账号" />
	                </td>
	                <td><img src="images/good.gif" /></td>
	                <td></td>
	              </tr>
	              <tr>
	                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</b></td>
	                <td>
	                    <input type="password" placeholder="请输入要关联账号的密码" />
	                </td>
	                <td></td>
	                <td></td>
	              </tr>
	              <tr>
	                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>确认密码：</b></td>
	                <td>
	                    <input type="password" placeholder="请再次输入要关联账号的密码" />
	                </td>
	                <td></td>
	                <td></td>
	              </tr>
	            </table>
	        	<form id="aboutUserNumForm" method="post" action="">
		            <table>
		              <tr style="height:45px;">
		                <td></td>
		                <td><div><span style="color:red;">*</span>为必填选项</div></td>
		                <td></td>
		                <td></td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</b></td>
		                <td>
		                    <input id="password" name="password" type="password" placeholder="请输入当前主账号的密码" />
		                </td>
		                <td>
		                	<img id="passwordImg" style="display:none;" src="images/chacha.png" /></td>
		                <td style="width:355px;">
		                    <div id="passwordMsg" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">密码错误，请重新输入!</p>
		                    </div>
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</b></td>
		                <td>
		                    <input id="aboutUser" name="aboutUser" type="text" placeholder="请输入要关联的账号" />
		                </td>
		                <td><img id="userImg" style="display:none;" src="images/chacha.png" /></td>
		                <td>
		                	<div id="userMsg1" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">输入手机号不正确，请重新输入！</p>
		                    </div>
		                    <div id="userMsg2" style="display:;width:351px; height:31px; margin-bottom:14px; background-image:url(images/bg.png);background-position:-101px 407px;">
		                        <p style="line-height:28px; color:black; margin-left:20px;">账号仅支持手机号注册！</p>
		                    </div>
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</b></td>
		                <td>
		                    <input id="aboutPwd" name="aboutPwd" type="password" placeholder="请输入要关联账号的密码" />
		                </td>
		                <td><img id="aboutPwdImg" style="display:none;" src="images/chacha.png" /></td>
		                <td>
		                	<div id="pwdMsg1" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">输入格式不正确，请重新输入！</p>
		                    </div>
		                    <div id="pwdMsg2" style="display:;width:351px; height:31px; margin-bottom:14px;background-image:url(images/bg.png);background-position:-101px 407px;">
		                        <p style="line-height:28px; color:black; margin-left:20px;">密码长度6-18位，必须含有字母！</p>
		                    </div>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>确认密码：</b></td>
		                <td>
		                    <input id="comfirmPwd" name="comfirmPwd" type="password" placeholder="请再次输入要关联账号的密码" />
		                </td>
		                <td><img id="comfirm" style="display:none;" src="images/chacha.png" /></td>
		                <td>
		                	<div id="confirmpwdMsg" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">两次输入的密码不一致，请重新输入！</p>
		                    </div>
		              </tr>
		            </table>
	            </form>
	        </div>
		</div>
	<jsp:include page="../include/footer.jsp"/>
  </body>
</html>
