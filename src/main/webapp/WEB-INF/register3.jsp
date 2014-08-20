<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>用户注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.s_main {
	width: 1000px;
	height: auto;
	overflow: hidden;
	margin: 20px auto;
	background: #FFFFFF;
}

.stable {
	width: 800px;
	height: auto;
	overflow: hidden;
	margin-left: auto;
	margin-right: auto;
}

.tese {
	width: auto;
	height: auto;
	margin-top: 10px;
	margin-bottom: 20px;
	padding: 10px;
}

.tese a {
	border: 1px solid #e4e4e4;
	color: #555555;
	border-radius: 3px;
	margin:5px;
	padding: 5px;
	/* line-height: 40px; */
	display:inline-block;
	margin-buttom:5px;
	cursor: pointer;
}

.btn {
	width: 140px;
	height: 30px;
	border: 1px solid #69CDCD;
	background: #69CDCD;
	color: #FFFFFF;
	border-radius: 4px;
	cursor: pointer;
}

.btn_div {
	width: 800px;
	height: auto;
	overflow: hidden;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	margin-bottom: 5px;
}

.btn_div input {
	width: 70px;
	height: 30px;
	border: 1px solid #CCCCCC;
	background: #CCCCCC;
	color: #FFFFFF;
	border-radius: 4px;
	cursor: pointer;
}

.add_tese {
	background: #ffffff;
	border: 1px solid #e4e4e4;
	border-radius: 4px;
	color: #000000;
	cursor: pointer;
	height: 30px;
	margin-left: 25px;
	width: 60px;
}

.current {
	background: #69cdcd;
	border: 1px solid #69cdcd !important;
	color: #ffffff !important;
}
</style>
<script type="text/javascript" src="/js/jquery.js"></script>
<script src="/js/jquery.json.js" type="text/javascript"></script>
<script type="text/javascript">

	function addclass(obj){
		if(obj.className == "current"){
			obj.className = "";
		}else{
			obj.className = "current";
		}
	}
	$().ready(function() {
		//选择
		$("[id='ta']").click(function() {
			if ($(this).hasClass("current")) {
				$(this).removeClass("current");
			} else {
				$(this).addClass("current");
			}
		});
		//添加
		$("#addSpecial").click(function() {
			var feature = $("#textSpecial").val();
			if (feature == "") {
				alert("请输入关键字！");
			} else {
				$.post("/insertFeature.jhtml",{feature:feature},function(result){
					var tfeatureId=result.match(/[0-9]+/);
					$("#tese").append("<a id='ta' class='current' value="+tfeatureId+" onclick='addclass(this);'>" +feature+ "</a>");
					$("#textSpecial").val("");
				 });
			}
		});
		
		$("#submit").click(function() {
			var featureIds=new Array();
			$("#ta.current").each(function(){
				featureIds.push($(this).attr("value"));
			});
			$.post("/saveFeature.jhtml",{"featureIds":featureIds.toString(),"sessionUserId":${sessionUser.shopUserId}},function(result){
				if(result=="success"){
					top.location.href="/menu.jhtml?userName="+${sessionUser.userName};
				}else if(result=="error"){
					top.location.href="/login.jhtml";
				}
				
			});
		});
	});
</script>
</head>
<body bgcolor="#E7E8EB">
	<!-- 引用尾部页面 -->
	<jsp:include page="include/header.jsp" flush="true" />

	<div class="s_main">
		<p style="font-size: 22px; margin: 10px 0px; padding-left: 35px;">
			<font color="#69CDCD">商户注册</font> <font color="#AEAEAE">USER REGEDIT</font>
		</p>
		<p style="margin:10px 0;">
			<img src="images/r3.jpg" width="1000">
		</p>
		<div
			style="width:600px;height:30px;line-height:30px;margin-left:auto;margin-right:auto;">
			<span><font color="red">*</font>为必填选项</span>
		</div>
		<form id="registerForm" action="/saveFeature.jhtml" method="post"
			autocomplete="off">
			<div class="stable">
				<div class="tese" id="tese">
					<c:forEach var="tli" items="${tList}">
						<a id="ta" value="${tli.featureId}">${tli.featureName }</a>
					</c:forEach>
				</div>
				<p>
					<input id="textSpecial" type="text" name="" style="width:300px;height:30px;" />
					<input id="addSpecial" class="add_tese" type="button" name="" value="添加" />
				</p>

				<div class="btn_div">
					<input id="submit" type="button" value="完成注册" style="background:#69CDCD;border:1px solid #69CDCD;">
				</div>
			</div>
		</form>
	</div>

	<!-- 引用尾部页面 -->
	<jsp:include page="include/footer.jsp" flush="true" />

</body>
</html>
