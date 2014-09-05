<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		
		var xmlHttp;
     	//该函数用于创建一个XMLHttpRequest对象
       function createXMLHttpRequest() {
			if (window.ActiveXObject) {
		  		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		    else if (window.XMLHttpRequest) {
		  		xmlHttp = new XMLHttpRequest();
		  	}
		}  
     	
     	$("#province").change(function(){
     		var selected=$(this).val();
     		//创建一个XMLHttpRequest对象
			createXMLHttpRequest();
			//将状态触发器绑定到一个函数
			xmlHttp.onreadystatechange = processor1;
			xmlHttp.open("GET", "getCity.jhtml?selected="+selected);
			//发送请求
			xmlHttp.send(null);
     	});
    	
		  //处理从服务器返回的XML文档并更新地市下拉列表
		  function processor1() {
			//定义一个变量用于存放从服务器返回的响应结果
			var result;
			if(xmlHttp.readyState == 4) { //如果响应完成
				if(xmlHttp.status == 200) {//如果返回成功
					//取出服务器返回的XML文档的所有city标签的子节点
					result = xmlHttp.responseXML.getElementsByTagName("city");
					//先清除地市列表的现有内容
					while (document.all.slt2.options.length>0){
						document.all.slt2.removeChild(document.all.slt2.childNodes[0]); 
					}
					document.all.slt2.add(new Option("请选择地市:","0"));
				//解析XML中的数据并更新地市列表
				for(var i=0;i<result.length;i++){
					var option = document.createElement("OPTION");
					option.text = result[i].childNodes[0].childNodes[0].nodeValue;//这就是取出<cityname>中的值
					option.value = result[i].childNodes[1].childNodes[0].nodeValue;//这就是取出<cityvalue>中的值
					document.all.slt2.options.add(option);//为地市列表中添加选项
				}
			}
		}
	} 
    	
   	$("#slt2").change(function(){
   		var cityId=$("#slt2").val();
   		window.location="fansAreaCount.jhtml?cityId="+cityId+"&shopId=${shopId}";
   	});
		
		<% 
			String[] name=(String[])request.getAttribute("area");
			String[] percent=(String[])request.getAttribute("precent");
			int len=percent.length-1;
			Double[] pre=new Double[len+1];
			for(int i=0;i<len+1;i++){
				String p=percent[i];
				pre[i]=Double.parseDouble(p);
			}
		%>
		
		$('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '<%=request.getAttribute("provinceName")%><%=request.getAttribute("cityName")%>各区/县比例图'
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
	            data: [<%	for(int i=0;i<len;i++){	%>
	            				<%=pre[i]%> ,
	            <% }	%> 
	            				<%=pre[len]%>
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
	                <a href="/fansCount.jhtml?url=job&shopId=${shopId }" title="职业">职业</a>
	                <%-- <a style="background-color:#00AAAA;border:1px solid #00AAAA;color:white;font-weight:bold;" href="/fansCount.jhtml?url=area&shopId=${shopId }" title="所在地">所在地</a> --%>
	                <a href="javascript:void(0);" title="所在地" onClick="alert('暂不开放，敬请期待！');">所在地</a>
	                <a href="/fansCount.jhtml?url=favourite&shopId=${shopId }" title="喜欢">喜欢</a>
	           		
	            </div>
	        </div>
	        <div style="margin-top:5px;margin-left:10px;">
			    	<select id="province" style="width:150px;">
			    		<option value="0" selected="selected">请选择省份:</option>
			    		<c:forEach items="${province }" var="pro">
			    			<option value="${pro.provinceId }">${pro.provinceName }</option>
			    		</c:forEach>
			    	</select>
			    	<select id="slt2" style="width:150px;disabled:true;">
		    			<option value="0" selected="selected">请选择地市:</option>
			    		
			    	</select>

						
			    </div>
	        <div id="container" style="width: auto; height: 550px; text-align: center;"></div>
	   </div>
	</div>
   <!-- 引用尾部页面 -->
	<jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
