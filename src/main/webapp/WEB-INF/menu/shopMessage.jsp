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

<title>店铺信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="/css/goodsAdd.css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script language="JavaScript" src="js/jquery.validate.js"></script>
<script language="JavaScript" src="js/messages_cn.js"></script>
	<style type="text/css">
		.inputClass{
			background-color:#69CDCD;
			border-radius:.2em;
			color:white;
		}
		.main_table2_td p{
			font-size:13px;
			border-radius:.2em;
			margin-right:15px;
			width:auto;
			border:1px solid gray;
			height:20px;toggle
			line-height:20px;
			float:left;
			display:block;
			padding:3px 15px;
			cursor:pointer;
		}
		.main_table2 tr {
		    line-height: 40px;
		    vertical-align: top;
		}
		.main_table2 tr:hover{
			background:#EAFCFC;
		}
	</style>

<script type="text/javascript">
	$().ready(function(){
		
	});	
		
</script>

</head>
<body>
	
		 <!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
		
		<div id="main" style="">
			<table class="main_table1">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">店铺资料</p></td>
					<td style="width:56%;"></td>
					<td style="width:9%;">
						<input type="button" value="编辑" onClick="javascript:window.location.href='/editShopMsg.jhtml'" style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" />
					</td>
					<td style="width:8%;"><input type="button" value="返回" onClick="javascript:window.history.back();" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
					<td style="width:8%;"><input type="button" value="修改用户密码" style="border:none;width:120px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
				</tr>
			</table>			
			<hr style="width:85%;border:1px solid #E8E8E8;" />
			
			<table class="main_table2" cellspacing="0">
				<tr>
					<td style="color:red;">*</td>
					<td>店铺名称：</td>
					<td style="width:85%;">
						色调法规回家
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td>店铺介绍：</td>
					<td>
						玩儿体育附件玩儿体育覆盖和请问儿童法规遇见你玩儿头发规划额度发给你玩儿体育购买
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td style="">详细位置：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						玩儿体育房管局吗请问而非推广那
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td style="">经营范围：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						玩儿体育房管局吗请问而非推广那
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td style="">联系电话：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						13112345678
					</td>
				</tr>
			</table>


			<hr style="width:85%;border:1px solid #E8E8E8;" />
			
			<table class="main_table3" style="">
				<tr>
					<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
					<td style="width:90%;" colspan="2"><div style="float:left;color:red;">*</div>营业执照:</td>
				</tr>
   				<tr style="">
					<td colspan="2" style=""></td>
					<td>
						<div class="main_table3_div2" style="border:1px solid gray;"></div>
						<div class="main_table3_div3" style="border:1px solid gray;"></div>
						<div class="main_table3_div4" style="border:1px solid gray;"></div>
					</td>
				</tr>
				<tr>
					<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
					<td style="width:90%;" colspan="2"><div style="float:left;color:red;">*</div>二维码:</td>
				</tr>
   				<tr style="">
					<td colspan="2" style=""></td>
					<td>
						<div class="main_table3_div2" style="border:1px solid gray;"></div>
					</td>
				</tr>
			</table>
			
		</div>

		<hr style="width:85%;border:1px solid #E8E8E8;" />
		
		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
