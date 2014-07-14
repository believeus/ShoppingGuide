<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
body {
	font-family: 微软雅黑, Microsoft YaHei, Helvetica !important;
	font-size: 14px;
	margin: 0px;
}
table {
	padding: 0px 45px;
}
table tr {
	height: 65px;
}
table td:first-of-type {
	width: 155px;
	text-align: right;
	font-weight: bold;
}
table td:nth-child(2) {
	width: 345px;
}
table td:nth-child(3) {
	width: 45px;
	padding-left: 10px;
}
table td:last-of-type {
	width: 350px;
}
input {
	width: 340px;
	height: 28px;
	font-size: 15px;
	border: 0px;
	padding: 0px 4px;;
}
</style>
</head>
<script type="text/javascript" src="/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/js/jquery.validate.js"></script>
<script type="text/javascript" src="/js/messages_cn.js"></script>
<script type="text/javascript" src="/js/validate.expand.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#username").blur(function() {
			$.ajax({
				type : "post",
				url : "/ajaxRegValidateUserName.jhtml",
				dataType : "json",
				data : $("#registForm").serialize(),
				contentType : "application/x-www-form-urlencoded",
				success : function(data) {
					if (data.message == "userNameError") {
						$("#nameMsg").text("用户名已存在!");
					}
				}
			});
		});
		$("#registForm").validate({
			rules : {
				userName : {
					required : true,
					minlength : 6
				},
				password : {
					required : true,
					minlength : 6
				},
				rpassword : {
					required : true,
					equalTo : "#password"
				}
			},
			messages : {
				userName : {
					required : "请输入用户名!",
					minlength : jQuery.format("用户名不能小于6个字符")
				},
				password : {
					required : "请输入密码",
					minlength : jQuery.format("密码不能小于6个字符")
				},
				rpassword : {
					required : "请输入确认密码",
					equalTo : "两次输入密码不一致"
				},
			}
		});
		$("#idnumber").blur(function() {

			$.ajax({
				type : "post",
				url : "/registidnumberandrealname.jhtml",
				dataType : "json",
				data : $("#registForm").serialize(),
				contentType : "application/x-www-form-urlencoded",
				success : function(data) {
					if (data.message == "nullInfo") {
						$("#reaMsg").text("");
						$("#numMsg").text("");
						$("#regist").show();
						$("#endMsg").text("");
					}
					if (data.message == "error") {
						$("#reaMsg").text("请填写您的真实姓名！");
						$("#numMsg").text("请填写您的真实身份证号码！");
						$("#regist").hide();
						$("#endMsg").text("请确保您输入了所有信息！");
					}
					if (data.message == "success") {
						$("#reaMsg").text("");
						$("#numMsg").text("");
						$("#regist").show();
						$("#endMsg").text("");
					}
				}
			});
		});

	});
</script>
<body>
	<div>
		<div style="height:125px; background-color:#69CDCD;">
			<div style="width:1000px; margin:0px auto; padding:20px 20px;">
				<img src="/images/Logo.png" />
			</div>
		</div>
		<div style="width:1000px; margin:0px auto; padding-top:35px;">
			<img src="/images/shop_rigist.png" />
			<form id="registForm" action="/registSuccess.jhtml" method="post">
			<div>
					<table>
						<tr>
							<td></td>
							<td><span style="color:red;">* </span><span>为必填选项</span></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><span style="color:red;">* </span><span>注册用户名：</span></td>
							<td>
								<div style="border:1px solid #C9C9C9; border-radius:2px;">
									<input type="text" id="username" name="userName"
										onkeyup="value=this.value.replace(/[^A-Za-z0-9]+/g,'')" />
								</div>
							</td>
							<td><img src="/images/good.gif" /></td>
							<td></td>
						</tr>
						<tr>
							<td><span style="color:red;">* </span><span>密码：</span></td>
							<td>
								<div style="border:1px solid #C9C9C9; border-radius:2px;">
									<input name="password" id="password" type="password" />
								</div>
							</td>
							<td><img src="/images/chacha.png" /></td>
							<td>
								<div
									style="width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
									<p style="line-height:28px; color:red; margin-left:20px;">密码不能为空</p>
								</div>
							</td>
						</tr>
						<tr>
							<td><span style="color:red;">* </span><span>确认密码：</span></td>
							<td>
								<div style="border:1px solid #C9C9C9; border-radius:2px;">
									<input name="rpassword" id="rpassword" type="password" />
								</div>
							</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><span style="color:red;">* </span><span>真实姓名：</span></td>
							<td>
								<div style="border:1px solid #C9C9C9; border-radius:2px;">
									<input name="realName" id="realName" type="text"/>
								</div>
							</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><span style="color:red;">* </span><span>性别：</span></td>
							<td>
								<div style="float:left; width:90px;">
									<input type="radio" name="gender" checked="checked"
										style="width:14px" value="男"/>男
								</div>
								<div style="float:left">
									<input type="radio" name="gender" style="width:14px" value="女"/>女
								</div>
							</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><span style="color:red;">* </span><span>身份证号：</span></td>
							<td>
								<div style="border:1px solid #C9C9C9; border-radius:2px;">
									<input name="idnumber" id="idnumber"
										onkeyup="value=this.value.replace(/\D+/g,'')" type="text" />
								</div>
							</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><span style="color:red;">* </span><span>手机号：</span></td>
							<td>
								<div style="border:1px solid #C9C9C9; border-radius:2px;">
									<input name="phoneNumber" id="phoneNumber" type="text" />
								</div>
							</td>
							<td></td>
							<td><img src="images/prompt.png" /></td>
						</tr>
						<tr>
							<td><span style="color:red;">* </span><span>推荐人：</span></td>
							<td>
								<div style="border:1px solid #C9C9C9; border-radius:2px;">
									<input name="referee" type="text" />
								</div>
							</td>
						</tr>
						<tr>
								<td><span style="color:red;">* </span><span>验证码：</span></td>
								<td>
									<div
										style="border:1px solid #C9C9C9; border-radius:2px; width:150px; display:inline-block;">
										<input type="text" style="width:140px;" />
									</div> <img src="images/yanzheng.png" style="vertical-align:middle;" />
								</td>
							</tr>
					</table>
					<div
						style="background-color:#5AB5B6; width:140px; height:34px; border-radius:3px; margin:0px auto;">
						<input type="submit"
							style="line-height:34px; color:#FFF; font-weight:bold; font-size:15px; text-align:center;"
							value="注册" />
					</div>
			</div>
			</form>
		</div>
	</div>
</body>
</html>
