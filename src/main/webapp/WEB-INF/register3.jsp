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

	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			
			//选择
			$("[id='ta']").on('click',function(){
				if($(this).hasClass("current")){
					$(this).removeClass("current");		
				}else{
					$(this).addClass("current");		
				}
			});	
			
			//添加
			$("#addSpecial").on('click',function(){
				
				var text=$("#textSpecial").val();
				
				if(text == ""){
					alert("请输入关键字！");
				}else{
					var arr=new Array();
					arr=text.split(" ");
					for(var i=0;i<arr.length;i++){
						var v=arr[i];
						$("#tese").append("<a id='ta' name='xxx'>"+v+"</a>");
						//选择
						$("[id='ta']").click(function(){
							if($(this).hasClass("current")){
								$(this).removeClass("current");		
							}else{
								$(this).addClass("current");		
							}
						});	
					}
				}
			});
		});
</script>
</head>
<c:if test="${tList==null }">
	<c:redirect url="/tFeature.jhtml"></c:redirect>
</c:if>
<body bgcolor="#E7E8EB">
	<!-- 引用尾部页面 -->
	<jsp:include page="include/header.jsp" flush="true" />

	<div class="s_main">
		<p style="font-size: 22px; margin: 10px 0px; padding-left: 35px;">
			<font color="#69CDCD">商户注册</font> <font color="#AEAEAE">USER
				REGEDIT</font>
		</p>
		<p style="margin:10px 0;">
			<img src="images/r3.jpg" width="1000">
		</p>
		<div
			style="width:600px;height:30px;line-height:30px;margin-left:auto;margin-right:auto;">
			<span><font color="red">*</font>为必填选项</span> <span
				style="float:right;">已有帐号!<a href="/login.jhtml"
				style="color:red;">直接登录</a></span>
		</div>
		<form id="registerForm" action="/saveFeature.jhtml" method="post"
			autocomplete="off">
			<div class="stable">
				<div class="tese" id="tese">
					<c:forEach var="tli" items="${tList }">
						<span style="display: none;" name="featureId">${tli.featureId }</span>
						<a id="ta" name="featureName">${tli.featureName }</a>
					</c:forEach>
				</div>
				<p>
					<input id="textSpecial" type="text" name=""
						style="width:300px;height:30px;" /> <input id="addSpecial"
						class="add_tese" type="button" name="" value="添加" />
				</p>

				<div class="btn_div">
					<input type="submit" value="完成注册"
						style="background:#69CDCD;border:1px solid #69CDCD;">
				</div>
			</div>
		</form>
	</div>

	<!-- 引用尾部页面 -->
	<jsp:include page="include/footer.jsp" flush="true" />

</body>
</html>
