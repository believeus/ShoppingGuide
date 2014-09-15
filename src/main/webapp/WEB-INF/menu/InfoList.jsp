<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>潮流资讯</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="X-UA-Compatible" content="IE=8"/>
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		body {
			font-family: Microsoft YaHei !important;	
			font-size:14px;
			margin:0px;
		}
		#titl {
			height:34px; 
			margin-bottom:10px;
		}
		#titl_name1 {
			margin-left:30px;
			font-size:22px;
			color:#69cdcd;
		}
		table {
			margin:20px auto;
			width:900px;
		}
		table td {
			height:15px;
			border-bottom:1px solid #CCC;
		}
		table td:first-of-type {
			width:650px;
		}
		table td:first-of-type p:nth-child(2) {
			width:650px;
			color:#666;
			line-height:25px;
		}
		table td:nth-child(2) p {
			width:200px;
			text-align:center;
		}
		table td:nth-child(2) span {
			color:#F00;
		}
		p{
			margin:15px 0;
		}
		.pp input[type='button']{
			height:30px;
			background:#5AB5B6;
			border:1px solid #5AB5B6;
			border-radius:4px;
			color:#FFFFFF;
			cursor:pointer;
			margin-right:10px;
			padding:0 13px;
		}
		.pp input[type='text']{
			height:30px;
			border:2px solid #5AB5B6;
			margin-right:10px;
		}
		.findPro{
			background:url(/images/bg.png);
			background-position:-356px -455px;
			width:32px;
			height:30px;
			position:absolute;
			right:160px;
			cursor:pointer;
		}
		.findPro:hover{
			border-left:2px solid #5AB5B6;
			width:30px;
			height:28px;
		}
		.pageSize{
			position: absolute;
			width: 76px;
			/* left:300px; */
			background: #ffffff;
			border:1px solid #b8d3ee;
			box-shadow: 0 0 6px rgba(0, 0, 0, 0.1);
			margin-left:53px;
		}
		.pageSize li {
		    list-style: none outside none;
		    line-height:25px;
		}
		.pageSize li:hover {
			background:#d9f2f2;
			color:#FFFFFF;
			line-height: 25px;
		}
		.pageSize a {
		    display: inline-block;
		    width: 88px;
		}
		.pageSize a:hover {
			color:#FFFFFF;
		}
		
	</style>
	<link rel="stylesheet" type="text/css" href="css/pagination.css">
	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="js/pagination.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			
			var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
			var IE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !userAgent.indexOf("Opera") > -1;
			var FF = userAgent.indexOf("Firefox") > -1;
			var isChrome = navigator.userAgent.toLowerCase().match(/chrome/) != null;//判断是否是谷歌浏览器
			
			var isWin = (navigator.platform == "Win32") || (navigator.platform == "Windows");//判断操作系统
			if(isWin){
				//alert("你好,windows");
				if(FF){
					//alert("我是FF浏览器");
					$(".pageSize").css("margin-left","47px");
					$(".pageSize").css("width","68px");
				}
				if(isChrome){
				   	//alert("我是谷歌浏览器");
					$(".pageSize").css("margin-left","40px");
					$(".pageSize").css("width","68px");
				}
				if(IE){
				   	//alert("我是IE浏览器");
					$(".pageSize").css("margin-left","47px");
					$(".pageSize").css("width","68px");
				}
			}else{
				if(isChrome){
				   	//alert("我是谷歌浏览器");
				}
			}
			
			
			 $("#showPageSize").mouseover(function(){
				 $(".pageSize").show();
			 });
			 $("#showPageSize").mouseout(function(){
				 $(".pageSize").hide();
			 });
			 $(".pageSize").mouseover(function(){
				 $(".pageSize").show();
			 });
			 $(".pageSize").mouseout(function(){
				 $(".pageSize").hide();
			 });
		});
	</script>
  </head>
  
  <body>
    <jsp:include page="../include/header.jsp"/>
    <div>
	    <div style="width:1000px; margin:0px auto; background-color:#fff; border:1px solid #ccc;">
	    	<p>所在位置：
	   			<a href="/menu.jhtml" title="菜单">菜单</a> &gt;
	   			<a href="/infoList.jhtml" title="潮流资讯">潮流资讯</a>
			</p>
	    	<div style="padding-top:30px;">
	        	<div id="titl">
	                <div id="titl_name1">
	                    <span>潮流资讯</span>&nbsp;&nbsp;
	                    <span style="color:#AEAEAE; text-transform:uppercase;">Trend information</span>
	                </div>
	            </div>
	            <img src="/images/line.png"/>
	        </div>
	        <div style="border-bottom:1px solid #ccc; padding:10px 30px;">
	    		<input type="button" value="刷新" onClick="javascript:window.location.reload();" title="点击刷新">
	    		<input id="showPageSize" type="button" value="每页显示">
	    		<div class="pageSize" style="display:none;">
					<ul style="padding:0;margin:0;">
						<li><a href="/infoList.jhtml?num=10">10</a></li>
						<li><a href="/infoList.jhtml?num=20">20</a></li>
						<li><a href="/infoList.jhtml?num=30">30</a></li>
					</ul>
				</div>
	    		<span>共有<font color="#69CDCD">${size }</font>条数据</span>
	        </div>
	        <div style="width:900px;height:auto;overflow: hidden;margin:0 auto;">
	        	<table>
		        	<c:forEach var="news" items="${news}">
		            	<tr>
		                	<td>
		                    	<p style="font-weight:bold; font-size:16px;">
		                    		<a href="/information.jhtml?newsId=${news.newsId}" title="${news.title}">${news.title}</a>
	                    		</p>
		                    	<p title="${news.content}">
		                    		${fn:substring(news.content, 0, 40)}...
		                    		<%-- ${news.content} --%>
		                    	</p>
		                    </td>
		                    <td>
		                    	<p>${news.addTime}</p>
		                        <p><span>${news.viewCount}</span>次点击</p>
		                    </td>
		                </tr>
	                </c:forEach>
	            </table>
	        </div>
	   </div>
	</div>
	<div>
		<form action="infoList.jhtml" id="listForm">
			<jsp:include page="../include/pagination.jsp" flush="true" />
		</form>
	</div>
    <jsp:include page="../include/footer.jsp"/>
  </body>
</html>
