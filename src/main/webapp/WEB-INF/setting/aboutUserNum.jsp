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
    <div style="width:100%; background-color:#CCC;">
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
	                <td><div><span style="color:red;">*</span>为必填选项</div></td>
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
	        </div>
	   </div>
	</div>
	<jsp:include page="../include/footer.jsp"/>
  </body>
</html>
