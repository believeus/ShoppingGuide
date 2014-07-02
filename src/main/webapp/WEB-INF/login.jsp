<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
		function initValidator(base){
		    //异步验证用户名
		    jQuery.validator.addMethod("checkUserName", function(value, element){
		        var result = false;
		        // 设置同步
		        $.ajaxSetup({
		            async: false
		        });
		        var param = {
		            userName: value
		        };
		        $.post(base + "/ajaxLoginValid.jhtml", param, function(data){
		            result = (1 == data);
		        });
		        // 恢复异步
		        $.ajaxSetup({
		            async: true
		        });
		        return result;
		    }, "用户名已经存在");
		
		$("#register").click(function() {

			window.location.href = "/Regist.jhtml";

		});

	});
</script>


</head>

<body>
	<form id="loginForm" action="/" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input name="userName" id="username" /><span id="msg" style="color: red"></span></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td><input type="button" id="login" value="登陆" /></td>
				<td><input type="button" value="注册" id="register" /></td>
			</tr>

		</table>
	</form>
</body>
</html>
