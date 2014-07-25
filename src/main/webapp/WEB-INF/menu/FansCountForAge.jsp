<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>粉丝统计</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="JavaScript" src="js/jquery.js"></script>
	<script language="JavaScript" src="js/jquery.validate.js"></script>
	<script language="JavaScript" src="js/messages_cn.js"></script>
	<script language="JavaScript" src="js/highcharts.js"></script>
	<script type="text/javascript">
	$().ready(function(){
		<% double[] age=(double[])request.getAttribute("ageCount"); %>
		$('#container').highcharts({
			chart: { 
				type: 'bar' 
			},
			title: {
				text: '粉丝年龄分布图' 
			}, 
			xAxis: { 
				categories: ['未知','10-19岁', '20-29岁', '30-39岁', '40-49岁', '50-59岁'],
				title: {
					text: null
				} 
			},
			yAxis: { 
				min: 0,
				title: {
					text: 'Percentage (%)',
					align: 'high'
				}, 
				labels: { 
					overflow: 'justify' 
				} 
			},
			tooltip: {
				valueSuffix: '%'
			}, 
			plotOptions: {
				bar: {
					dataLabels: {
						enabled: true 
					} 
				}
			}, 
			legend: { 
				layout: 'vertical',
				align: 'right', 
				verticalAlign: 'top',
				x: -40, 
				y: 20,
				floating: true,
				borderWidth: 1, 
				backgroundColor: '#FFFFFF',
				shadow: true
			},
			credits: {
				enabled: false
			}, 
			series: [{ 
				name: '所占比例',
				data: [	<%=age[5] %>,
						<%=age[0]%>,
						<%=age[1]%>,
						<%=age[2]%>,
						<%=age[3]%>,
						<%=age[4]%>],
			}]
		});
		
	});	
		
</script>
	<style>
		#titl {
			height:34px; 
			width:1000px; 
			margin-bottom:10px;
		}
		#titl_name1 {
			float:left;
			margin-left:30px;
			font-size:22px;
			color:#69cdcd;
		}
		#titl_name2 {
			float:right;
			margin-right:40px;
			color:#666;
		}
		#cleck {
			width:800px; 
			height:65px;
			margin:auto;
		}
		#cleck a {
			float:left;
			width:50px;
			height:24px;
			letter-spacing:1px;
			text-align:center;
			border:1px solid #ccc;
			background-color:#E6E6E6;
			margin-right:30px;
			padding:2px 5px;
			cursor:pointer;
			border-radius:4px;
			line-height:24px;
		}
	</style>
  </head>
  
  <body>
  	 <!-- 引用尾部页面 -->
	 <jsp:include page="../include/header.jsp" flush="true" />
    <div>
	    <div style="width:1000px; height:800px; margin:0px auto; background-color:#fff; border:1px solid #ccc;">
	    	<div style="padding-top:30px;">
	        	<div id="titl">
	                <div id="titl_name1">
	                    <span>粉丝统计</span>&nbsp;&nbsp;
	                    <span style="color:#AEAEAE; text-transform:uppercase;">Fans statistics</span>
	                </div>
	                <div id="titl_name2">
	                	<p>数据由&nbsp;武汉谦通分析&nbsp;提供</p>
	                </div>
	            </div>
	        </div>
	        <div style="border-bottom:1px solid #ccc;">
	            <div id="cleck">
	                <a href="/fansCount.jhtml?url=sex" title="性别">性别</a>
	                <a href="/fansCount.jhtml?url=age" title="年龄">年龄</最爱a>
	                <a href="/fansCount.jhtml?url=constellation" title="星座">星座</a>
	                <a href="/fansCount.jhtml?url=CZ" title="生肖">生肖</a>
	                <a href="/fansCount.jhtml?url=job" title="职业">职业</a>
	                <a href="javascript:void(0);" title="所在地" onClick="alert('暂无信息');">所在地</a>
	                <a href="/fansCount.jhtml?url=favourite" title="喜欢">喜欢</a>
	            </div>
	        </div>
	        <div id="container" style="width: auto; height: 658px; text-align: center;"></div>
	   </div>
	</div>
   <!-- 引用尾部页面 -->
	<jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
