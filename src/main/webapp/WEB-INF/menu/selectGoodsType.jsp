<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>选择商品类型</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/dtree.css">
	<script language="JavaScript" src="js/jquery.js"></script>
	<script language="JavaScript" src="js/dtree.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		
		var d = new dTree('d');
	
		d.add(10,-1,'服饰');
		<c:forEach var="gli" items="${gList}" varStatus="status" >
			d.add(${gli.goodsTypeId},${gli.parentId},'authority','${status.index}','${gli.goodsTypeName}');
		</c:forEach>
		
		document.write(d);
		
		d.openAll();
	</script>
	<script type="text/javascript">
	    $().ready(function(){
	    	$("#submit").click(function(){
	    		var count = 0;
	    		var featureIds=new Array();
				var obj = document.all.authority;
				for(i=0;i<obj.length;i++){
					if(obj[i].checked){					
						featureIds.push(obj[i].value);
						count ++;				
					}
				}	
				if(featureIds == null){
					alert("请选择商品类型");
				}else{
					window.location.href="/goodsAdd.jhtml?shopId="+${shopId}+"&featureIds="+featureIds;
				}
	    	});
	    });
	</script>
  </head>
  
  <body>
  	<input id="goodsTypes" name="goodsTypes" type="hidden" value=""/>
    <input id="submit" type="button" value="确定返回添加商品">
  </body>
</html>
