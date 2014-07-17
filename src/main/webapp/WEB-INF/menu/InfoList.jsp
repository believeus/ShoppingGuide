<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>潮流资讯</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
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
	</style>
	<script type="text/javascript" src="/js/jquery.js"></script>
  </head>
  
  <body>
    <jsp:include page="../include/header.jsp"/>
    <div>
	    <div style="width:1000px; margin:0px auto; background-color:#fff; border:1px solid #ccc;">
	    	<div style="padding-top:30px;">
	        	<div id="titl">
	                <div id="titl_name1">
	                    <span>潮流资讯</span>&nbsp;&nbsp;
	                    <span style="color:#AEAEAE; text-transform:uppercase;">Trend information</span>
	                </div>
	            </div>
	            <img src="/images/line.png"/>
	        </div>
	        <div style="border-bottom:1px solid #ccc; padding-left:30px;">
	            <p class="pp">
		    		<input type="button" value="刷新">
		    		<input type="button" value="每页显示">
		    		<span>共有<font color="#69CDCD">1234</font>条数据</span>
		    		<input type="text" name="" style="float:right;">
		    	</p>
	        </div>
	        <div>
	        	<table>
	            	<tr>
	                	<td>
	                    	<p style="font-weight:bold; font-size:16px;">
	                    		<a href="/information.jhtml" title="">京东苏宁价格战内幕 一场恶意做空的阴谋</a>
                    		</p>
	                    	<p>京东苏宁电商价格战，京东苏宁国美价格战打响，苏宁国美股价暴跌，15日开盘后...</p>
	                    </td>
	                    <td>
	                    	<p>2014年7月16日</p>
	                        <p><span>1234</span>次点击</p>
	                    </td>
	                </tr>
	                <tr>
	                	<td>
	                    	<p style="font-weight:bold; font-size:16px;">
		                    	<a href="/information.jhtml" title="">如何用好最直接的电子商务推广方式</a>
	                    	</p>
	                    	<p>电子商务的快速发展让各位企业主更加重视企业运营的成本。而在众多营销手段中,说较低的...</p>
	                    </td>
	                    <td>
	                    	<p>2014年7月16日</p>
	                        <p><span>423</span>次点击</p>
	                    </td>
	                </tr>
	                <tr>
	                	<td>
	                    	<p style="font-weight:bold; font-size:16px;">
	                    		<a href="/information.jhtml" title="">电子商务推广的两大方向</a>
                    		</p>
	                    	<p>电子商务推广就是将企业的全部信息详细地完美地展现在客户面前，通过强大的互联网...</p>
	                    </td>
	                    <td>
	                    	<p>2014年7月16日</p>
	                        <p><span>124</span>次点击</p>
	                    </td>
	                </tr>
	                <tr>
	                	<td>
	                    	<p style="font-weight:bold; font-size:16px;">
	                    		<a href="/information.jhtml" title="">京东苏宁价格战内幕 一场恶意做空的阴谋</a>
                    		</p>
	                    	<p>京东苏宁电商价格战，京东苏宁国美价格战打响，苏宁国美股价暴跌，15日开盘后...</p>
	                    </td>
	                    <td>
	                    	<p>2014年7月16日</p>
	                        <p><span>1234</span>次点击</p>
	                    </td>
	                </tr>
	                <tr>
	                	<td>
	                    	<p style="font-weight:bold; font-size:16px;">
	                    		<a href="/information.jhtml" title="">如何用好最直接的电子商务推广方式</a>
                    		</p>
	                    	<p>电子商务的快速发展让各位企业主更加重视企业运营的成本。而在众多营销手段中,说较低的...</p>
	                    </td>
	                    <td>
	                    	<p>2014年7月16日</p>
	                        <p><span>423</span>次点击</p>
	                    </td>
	                </tr>
	            </table>
	        </div>
	        <div style="width:800px; margin:auto;s">
	        	<p style="text-align:right;">上一页《 1 2 3 4 5 》 下一页</p>
	        </div>
	   </div>
	</div>
    <jsp:include page="../include/footer.jsp"/>
  </body>
</html>
