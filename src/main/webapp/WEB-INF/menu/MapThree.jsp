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
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<script language="JavaScript" src="js/jquery.js"></script>
	<script language="JavaScript" src="js/jquery.validate.js"></script>
	<script language="JavaScript" src="js/messages_cn.js"></script>
	<script language="JavaScript" src="js/highcharts.js"></script>
	
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
			color:#E63F00;
			font-weight:bold;
		}
	</style>
	<script type="text/javascript">
        $().ready(function(){
        	$("[id=shi]").change(function(){
        		var cityId=$(this).val();
        		if(cityId != 0){
	        		window.location="fansAreaCount.jhtml?cityId="+cityId;
        		}
        	});
        	
        });
    </script>
	
  </head>
  
  <body onload="getSheng();">
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
	                <a style="background-color:#00AAAA;color:white;font-weight:bold;" href="/fansCount.jhtml?url=area" title="所在地">所在地</a>
	                <a href="/fansCount.jhtml?url=favourite" title="喜欢">喜欢</a>
	            </div>
	        </div>
	    		<c:forEach items="${province }" varStatus="state" var="pro">
				    <div id="main_div" style="width:150px;height:50px;float:left;padding:20px 20px;" >
							<div>
								<span>${pro.provinceName }:</span><span style="display:none;">${pro.provinceId }</span>
							</div>	
	
					    	<select id="shi" style="width:120px;disabled:true;">
							    			<option value="0" selected="selected">请选择市区：</option>
					    		<c:forEach items="${allCity}" var="citys" begin="${state.index}" end="${state.index }">
					    			<c:forEach items="${citys }" var="city">
						    				<option id="choose" value="${city.cityId}">${city.cityName }</option>
					    			</c:forEach>
					    		</c:forEach>
					    	</select>
	
							
				    </div>
	    		</c:forEach>
	   </div>
	</div>
   <!-- 引用尾部页面 -->
	<jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>