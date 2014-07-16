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

<title>商品添加</title>

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
	</style>

<script type="text/javascript">
	$().ready(function(){
		var specs = $("#main_table2_td p");
		specs.each(function(){
			$(this).click(function(){
				if($("#main_table2_td .inputClass").length >= 5){
					alert("最多选择5个");
				}else{
					alert(2);
					$(this).addClass("inputClass");		
				}
			},function(){
				$(this).removeClass("inputClass");
			});
		});
		
		$("#addSpecial").click(function(){
			var text=$("#textSpecial").val();
			
			if(text == ""){
				alert("添加失败！");
			}else{
				var arr=new Array();
				arr=text.split(" ");
				for(var i=0;i<arr.length;i++){
					var v=arr[i];
					$("#main_table2_td").append("&nbsp;&nbsp;").append($("#special").clone(true).removeClass("inputClass").text(v));
				}
			}
			
		});
		
		$("#main_form").validate({
			rules:{
				goodsName:{required:true},
				}
		},{
			messages:{
				goodsName:{required:"请输入商品名称！"},
			}
		});
		
		$("#main_table2_td_div input").click(function(){
			if($("#main_table2_td_div .inputClass").length >=5){
				
			}
		});

		
		$("#chooseType").change(function(){
			
			var id=$("#chooseType option:selected").val();
			alert(id);
			
			$.ajax({
				url:"",
				data:id,
				type:"post",
				dataType:"json",
				success:function(date){
					if(date.message == "success"){
						//弹出正确提示
					}else{
						//弹出错误提示
					}
				}
			});
		});
		
	});	
		
</script>

</head>
<body>
	
		<!-- <div id="nav" style="">
			<div class="nav_div1" style="">
				<img style="margin-top:30px;line-height:120px;" src="image/Logo.png" />
			</div>
			<div class="nav_div2" style="">
				<table class="nav_table" style="font-size:16px;">
					<tr>
						<td style="color:gray;font-size:17px;">admin，您好！</td>
						<td>&nbsp;&nbsp;</td>
						<td><a href="#" style="color:gray;">退出</a></td>

					</tr>
				</table>
			</div>
		</div> -->
		
		 <!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
		
		<div id="main" style="">
			<table class="main_table1" style="">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">商品添加</p></td>
					<td style="width:12%;"><div style=""><a href="#" style="font-size:12px;color:#69CDCD;">快速发布商品</a></div></td>
					<td style="width:56%;"></td>
					<td style="width:9%;"><input style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" type="button" value="取消" /></td>
					<td style="width:8%;"><input type="button" value="预览" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
				</tr>
			</table>			
			<hr style="width:85%;border:1px solid #E8E8E8;" />
			
			<form id="main_form" method="get" action="save.jhtml">
			<table class="main_table2" style="">
				<tr>
					<td style="color:red;">*</td>
					<td>商品名称：</td>
					<td style="width:85%;"><input style="height:35px;" id="goodsName" name="goodsName" type="text" /></td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td>商品类型：</td>
					<td>
						<select id="chooseType" name="chooseType" style="width:20%;">
							<option value="1">类型1</option>
							<option value="2">类型2</option>
							<option value="3">类型3</option>						
						</select>
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td style="">特色：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
							<p id="special" name="special" style="margin-top:13px;">潮流</p>
							<p id="special" name="special" style="">精致韩风</p>
							<p id="special" name="special" style="">商务休闲</p>
							<p id="special" name="special" style="">青春活力</p>
							<p id="special" name="special" style="">小清新</p>
							<p id="special" name="special" style="">欧美简约</p>
							
							<p id="special" name="special" style="">基础大众</p>
							<p id="special" name="special" style="">日系复古</p>
							<p id="special" name="special" style="">美式休闲</p>
							<p id="special" name="special" style="">英式学院</p>
							<p id="special" name="special" style="">商务正装</p>
							
							<p id="special" name="special" style="">中国风</p>
							<p id="special" name="special" style="">工装军旅</p>
							<p id="special" name="special" style="">嘻哈</p>
							<p id="special" name="special" style="">朋克</p>
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input id="textSpecial" name="textSpecial" style="height:35px;" type="text" />&nbsp;&nbsp;&nbsp;<input id="addSpecial" style="height:35px;width:60px;" type="button" value="添加" /></td>
				</tr>
				<tr>
					<td></td>
					<td>商品简介：</td>
					<td>
						<textarea id="goodsDetail" name="goodsDetail"  style="">
						</textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" style="height:35px;width:60px;" value="发布" /></td>
				</tr>
			</table>

			</form>

			<hr style="width:85%;border:1px solid #E8E8E8;" />
			
			<table class="main_table3" style="">
     				<tr>
					<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
					<td style="width:90%;" colspan="2"><div style="float:left;color:red;">*</div>上传图片：<span style="font-size:13px;">(最多可上传9张图片)</span></td>
				</tr>
     				<tr style="">
					<td colspan="2" style=""></td>
					<td>
						<div class="main_table3_div2" style="border:1px solid gray;"></div>
						<div class="main_table3_div3" style="border:1px solid gray;"></div>
						<div class="main_table3_div4" style="border:1px solid gray;"></div>
					</td>
				</tr>
			</table>
			
		</div>

		<hr style="width:85%;border:1px solid #E8E8E8;" />
		<!-- <div id="footer" style="margin-top:20px;">
			<div class="footer_div1" style="">
				<table class="footer_table">
					<tr class="footer_table_tr">
						<td><a href="#">下载APP</a></td>
						<td><p>&nbsp;|&nbsp;</p></td>
						<td><a href="#">我们的微信：爱乐逛、爱乐逛助手</a></td>
						<td><p>&nbsp;|&nbsp;</p></td>
						<td><a href="#">我们的微博：武汉爱乐逛</a></td>
					</tr>
					<tr>
						<td style="color:gray;">版权所有</td>
						<td style="color:gray;">&nbsp;:&nbsp;</td>
						<td style="color:gray;" colspan="3">武汉谦通科技有限公司</td>
					</tr>
				</table>
			</div>
			<div class="footer_div2" style="">
				<table>
					<tr>
						<td style="line-height:90px;font-size:21px;"><a href="#" style="text-decoration:none;color:#69CDCD;">400-851-9189</a></td><td><img src="image/phone.png" /></td>
					</tr>
				</table>
			</div>
		</div> -->
		
		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
