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

<title>My JSP 'ShopInfo.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
#middle {
	width: 1000px;
	height: 1000px;
	margin-left: 170px;
}
#cs {
	font-size: 22px;
	color: #69CDCD;
}
#icon {
	width: 6px;
	height: 30px;
	background-color: #69CDCD;
}
#maintab tr{
	background-color: #E9FDFC;
}
table img {
	margin-right: -60px;
}
#btncss{
	height:34px;
	border: none;
	background-color: #69CDCD;
	outline: none;
}
p{
	font-size: 15px;
	color: gray;
}
</style>

</head>

<body>
	<div style="height:125px; background-color:#69CDCD;">
		<div style="width:1000px; margin:0px auto; padding:20px 20px;">
			<img src="images/Logo.png" />
			<div style="margin-left: 730px;margin-top: -30px;">
			 <span>admin,您好！&nbsp;&nbsp;&nbsp;<a>退出</a></span>
			</div>
		</div>
	</div>
	<div id="middle">
		<div id="top" style="margin-top:10px;">
			<span id="cs">店铺资料</span> <span style="margin-left: 500px;"><input
				type="button" id="btncss" value="编辑" />&nbsp;&nbsp;<input id="btncss" type="button"
				value="返回" />&nbsp;&nbsp;<input id="btncss" type="button" value="修改用户名密码" /></span> <br />
			<hr style="width: 1100px;border: 1px solid;color:#E8E8E8; margin-left: -72px;"/>
		</div>
		<div id="tabinfo">
			<table id="maintab" width="300px" height="400px" align="center"
				style="margin-left:30px;margin-top:50px; text-align: center;">
				<tr>
					<td><img src="/images/shopname.png" /></td>
					<td><span>店铺名称:</span></td>
					<td><p>${tshop.shopName }</p></td>
				</tr>
				<tr>
					<td><img src="/images/detailedAddress.png" /></td>
					<td><span>详细位子:</span></td>
					<td><p>${tshop.address }</p></td>
				</tr>
				<tr>
					<td><img src="/images/scope.png" /></td>
					<td><span>经营范围:</span></td>
					<td><p>${tshop.address }</p></td>
				</tr>
				<tr>
					<td><img src="/images/qujian.png" /></td>
					<td><span>价格区间:</span></td>
					<td><p>xxxx</p></td>
				</tr>
				<tr>
					<td><img src="/images/phone.png" /></td>
					<td><span>联系电话:</span></td>
					<td><p>xxxx</p></td>
				</tr>
				<tr>
					<td><img src="/images/qq.png" /></td>
					<td><span>QQ号码:</span></td>
					<td><p>xxxx</p></td>
				</tr>
			</table>
			<div id="characteristic" style="margin-left: 46px;">
				<table id="maintab" width="700px;">
					<tr>
						<td><img src="images/characteristic.png"
							style="margin-right: 0px;" /></td>
						<td><span style="margin-left: 10px;">店铺特色:</span></td>
						<td><span style="font-size: 16px;color: gray;">潮流&nbsp;&nbsp;&nbsp;精致韩风&nbsp;&nbsp;&nbsp;商务休闲&nbsp;&nbsp;&nbsp;
								青春活力&nbsp;&nbsp;&nbsp;小清新<br />欧美简约&nbsp;&nbsp;&nbsp;基础大众&nbsp;&nbsp;&nbsp;
								日系复古&nbsp;&nbsp;&nbsp;美式休闲&nbsp;&nbsp;&nbsp;英式美院&nbsp;&nbsp;&nbsp;
								<br />商务正装&nbsp;&nbsp;&nbsp;中国风&nbsp;&nbsp;&nbsp;工装军旅&nbsp;&nbsp;&nbsp;嘻哈
								&nbsp;&nbsp;&nbsp;朋克
						</span></td>
					</tr>
				</table>
			</div>
				<hr style="width: 1100px;border: 1px solid;color:#E8E8E8; margin-left: -72px;"/>
			<div id="license">
				<table width="700px" height="100px">
					<tr>
						<td><div id="icon"></div></td>
						<td><span style="margin-left: -200px;">营业执照: </span></td>
					</tr>
					<tr>
						<td><img src="images/com.png"/></td>
						<td>营业执照号：<input /><br />
						<span style="color: gray;font-size: 17px; padding-top: 10px;">注：必须上传营业执照或者填写执照号</span></td>
					</tr>
				</table>


			</div>
			<div id="reveal">
				<table>
					<tr>
						<td><div id="icon"></div></td>
						<td><span>店铺展示:</span></td>
					</tr>
					<tr>
						<td colspan="2"><img src="images/com.png"/></td>
					</tr>
				</table>
				
			</div>
		</div>
	</div>
	<div id="foot">
		<hr style="width: 1100px;border: 1px solid;color:#E8E8E8;" />
		<br />
		<div id="foottext" style="font-size: 13px;color: gray; margin-left: 200px; float: left;" >
			<span>下载APP|我们的微信：爱乐逛、爱乐逛助手|我们的微博：武汉爱乐逛</span><br /> <span>版权所有：武汉谦通科技有限公司</span>
		</div>
		<div id="footimg" style="float: left; margin-left: 200px; margin-top: -20px;">
			<img src="images/telephone.png"/>
		</div>
	</div>
</body>
</html>
