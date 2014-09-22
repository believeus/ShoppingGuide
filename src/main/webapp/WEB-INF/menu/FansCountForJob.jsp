<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
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
		
		<%
			String[] name=(String[])request.getAttribute("name");
		
			String[] pre=(String[])request.getAttribute("pre");
			int len=pre.length-1;
			Double[] percent=new Double[pre.length];
			
			for(int i=0;i<pre.length;i++){
				percent[i]=Double.parseDouble(pre[i]);
			}
		%>
		
		$('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '粉丝职业比例图'
	        },
	        xAxis: {
	            categories: [<%	for(int i=0;i<len;i++){%>
	            		'<%=name[i]%>' ,
	            		
	            <% } %>
	            		'<%=name[len]%>'
	            ]
	        },
	        yAxis: {
	            min: 0.0,
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
	            data: [<%	for(int i=0;i<len;i++){%>
	            				<%=percent[i]%> ,
	            <% }	%> 
	            				<%=percent[len]%>
	            ]

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
			margin-right:30px;
			padding:2px 5px;
			cursor:pointer;
			border-radius:4px;
			line-height:24px;
		}
		#cleck a:hover {
			background-color:#00AAAA;
			font-weight:bold;
			color: #FFFFFF;
			border:1px solid #00AAAA;
		}
	</style>
  </head>
  
  <body>
  	 <!-- 引用尾部页面 -->
	 <jsp:include page="../include/header.jsp" flush="true" />
    <div>
	    <div style="width:1000px; height:800px; margin:0px auto; background-color:#fff; border:1px solid #ccc;">
	    	<p style="margin:5px auto;width:980px;">所在位置：
	   			<a title="菜单" href="/menu.jhtml">菜单</a> &gt;
	   			<a title="我的粉丝" href="/showFans.jhtml?shopId=${shopId }">我的粉丝</a> &gt;
	   			粉丝统计
			</p>
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
	                <a href="/fansCount.jhtml?url=sex&shopId=${shopId }" title="性别">性别</a>
	                <a href="/fansCount.jhtml?url=age&shopId=${shopId }" title="年龄">年龄</a>
	                <a href="/fansCount.jhtml?url=constellation&shopId=${shopId }" title="星座">星座</a>
	                <a href="/fansCount.jhtml?url=CZ&shopId=${shopId }" title="生肖">生肖</a>
	                <a style="background-color:#00AAAA;border:1px solid #00AAAA;color:white;font-weight:bold;" href="/fansCount.jhtml?url=job&shopId=${shopId }" title="职业">职业</a>
	                <%-- <a href="/fansCount.jhtml?url=area&shopId=${shopId }" title="所在地">所在地</a> --%>
	                <a href="javascript:void(0);" title="所在地" onClick="easyDialog.open({container: {header: '提示',content: '暂不开放，敬请期待！'},overlay: false});">所在地</a>
	                <a href="/fansCount.jhtml?url=favourite&shopId=${shopId }" title="喜欢">喜欢</a>
	            	
	            </div>
	        </div>
	        <div id="container" style="width: auto; height: 550px; text-align: center;"></div>
	   </div>
	</div>
   <!-- 引用尾部页面 -->
	<jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
