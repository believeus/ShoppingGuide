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

<title>My JSP 'Regist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_cn.js"></script>
<script type="text/javascript">
	function regist() {
		$().ready(function() {
			$("#registForm").validate({
				rules : {
					password : {
						required : true,
						minlength : 6
					},
					rpassword : {
						required : true,
						minlength : 6,
						equalTo : "#password"
					},
					realName : {
						required : true,
						minlength : 2
					},
					idnumber : {
						required : true,
						minlength : 15,
						maxlength : 18
					}

				},
				messages : {
					password : {
						required : "请输入密码",
						minlength : jQuery.format("密码不能小于{6}个字 符")
					},
					rpassword : {
						required : "请输入确认密码",
						minlength : "确认密码不能小于6个字符",
						equalTo : "两次输入密码不一致不一致"
					},
					realName : {
						required : "请输入您的真实姓名"
					},
					idnumber : {
						required : "请输入您的身份证号，身份证号为15-18位"
					}
				}
			});
		});

	}

	function checkUserName() {
		var userNameTest = "/^[0-9a-zA-Z]{6,18}$/";
		if (userNameTest.test($("#username").val())) {
			$("#nameMsg").text("请输入6-18位的英文数字组合的用户名!");
		} else {
			$().ready(function() {
				$.ajax({
					type : "post",
					url : "/ajaxLoginValid.jhtml",
					dataType : "json",
					data : $("#loginForm").serialize(),
					success : function(data) {
						alert(data.message);
						if (data.message == "用户名可用") {
							$("#nameMsg").text("用户名可用!");
						} else {
							if (data.message == "用户名已存在") {
								$("#nameMsg").text("用户名已存在!");
							}
						}

					}
				})
			});

		}

	}
</script>
<body>
	<form id="registForm" action="">
		<table>
			<tr>
				<td>注册用户名:</td>
				<td><input name="userName" onblur="checkUserName()" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password"
					class="{required:true,minlength:6}" /></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password" name="rpassword"
					class="{required:true,minlength:6,equalTo:'#password'}" /></td>
			</tr>
			<tr>
				<td>真实姓名:</td>
				<td><input name="realName" id="realName" /></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><input type="radio" name="gender" checked="checked" />男<input
					type="radio" name="gender" />女</td>
			</tr>
			<tr>
				<td>身份证号:</td>
				<td><input name="idnumber" id="idnumber" /></td>
			</tr>
			<tr>
				<td>手机号:</td>
				<td><input name="phoneNumber" /></td>
			</tr>
			<tr>
				<td>推荐人:</td>
				<td><input name="referee" />(没有可不填)</td>
			</tr>
			<tr>
				<td>验证码:</td>
				<td><input><img /><a href="#">刷新</a></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="image" src=""
					value="注册" id="regist" onclick="regist()" /></td>

			</tr>


		</table>
	</form>
</body>
</html>
