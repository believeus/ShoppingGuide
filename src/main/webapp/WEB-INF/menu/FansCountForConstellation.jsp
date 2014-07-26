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
		<% Double[] constellat=(Double[])request.getAttribute("constellat"); %>
		$('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '粉丝所属星座比例图'
	        },
	        xAxis: {
	            categories: [
	                '白羊座',
	                '金牛座',
	                '双子座',
	                '巨蟹座',
	                '狮子座',
	                '处女座',
	                '天秤座',
	                '天蝎座',
	                '射手座',
	                '摩羯座',
	                '水瓶座',
	                '双鱼座',
	                '其他'
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '百分比 (%)'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table><tr><td style="color:{series.color};padding:0"></td><td style="padding:0"></td></tr></table>',
	            shared: true,
	            valueSuffix: '%',
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '所占比例',
	            data: [	<%=constellat[0]%>,
	            		<%=constellat[1]%>,
	            		<%=constellat[2]%>,
	            		<%=constellat[3]%>,
	            		<%=constellat[4]%>,
	            		<%=constellat[5]%>,
	            		<%=constellat[6]%>,
	            		<%=constellat[7]%>,
	            		<%=constellat[8]%>,
	            		<%=constellat[9]%>,
	            		<%=constellat[10]%>,
	            		<%=constellat[11]%>,
	            		<%=constellat[12]%>]

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
	                <a href="/fansCount.jhtml?url=age" title="年龄">年龄</a>
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
