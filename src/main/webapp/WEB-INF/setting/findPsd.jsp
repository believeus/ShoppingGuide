<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/css/goodsAdd.css" />
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
			width:45px;	
			padding-left:10px;
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
  
  <body>
  	<jsp:include page="../include/header.jsp"/>
	    <div style="width:1000px; margin:0px auto; background-color:#fff;">
	    	<div style="padding-top:30px;">
	        	<div id="titl">
	                <div id="titl_name">
	                    <span>找回密码</span>&nbsp;&nbsp;
	                    <span style="color:#AEAEAE; text-transform:uppercase;">find back password</span>
	                </div>
	                <div class="butt01"><p>确认</p></div>
	                <div class="butt01" style="margin-right:20px;"><p>取消</p></div>
	            </div>
	            <img src="/images/line.png" />
	        </div>
	        <div style="clear:right;">
	        	<table class="main_table3" style="">
					<tr>
						<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
						<td style="" colspan="2"><div style="float:left;color:red;">*</div>营业执照:</td>
					</tr>
	   				<tr style="">
						<td colspan="2" style=""></td>
						<td>
							<div class="main_table3_div2" style="border:1px solid gray;margin-left:78px;"></div>
						</td>
						<td style="text-align: right;width: 200px;">营业执照号:</td>
						<td>
							<input type="text" name="" style="width:200px;margin-top:13px;"/>
							<div style="position:relative;top:10px;right:85px;font-size:13px;">注明：必须上传营业执照或者填写执照号</div>
						</td>
					</tr>
				</table>
	            <table>
	              <tr>
	                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</b></td>
	                <td>
	                    <input type="password" placeholder="请输入账号" />
	                </td>
	                <td><img src="images/chacha.png" /></td>
	                <td>
	                    <div style="width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
	                        <p style="line-height:28px; color:red; margin-left:20px;">密码不能为空</p>
	                    </div>
	                </td>
	              </tr>
	              <tr>
	                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>手机号码：</b></td>
	                <td>
	                    <input type="text" placeholder="请输入手机号码" />
	                </td>
	                <td><img src="images/good.gif" /></td>
	                <td></td>
	              </tr>
	              <tr>
	                <td><b><span style="color:red;">*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>验证码：</b></td>
	                <td>
	                    <input type="password" placeholder="请输入验证码" />
	                </td>
	                <td></td>
	                <td></td>
	              </tr>
	            </table>
	            <img src="/images/line.png">
	        </div>
		</div>
	<jsp:include page="../include/footer.jsp"/>
  </body>
</html>