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
	
		 <!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
		
		<div id="main" style="">
			<table class="main_table1" style="">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">商品添加</p></td>
					<td style="width:12%;"><div style=""><a href="#" style="font-size:12px;color:#69CDCD;">详细发布商品</a></div></td>
					<td style="width:56%;"></td>
					<td style="width:9%;"><input style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" type="button" value="取消" /></td>
					<td style="width:8%;"><input type="button" value="预览" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
				</tr>
			</table>			
			<hr style="width:85%;border:1px solid #E8E8E8;" />
			
			<form id="main_form" method="get" action="save.jhtml">
			<table class="main_table2" style="">
				<tr>
					<td></td>
					<td>商品简介：</td>
					<td>
						<textarea id="goodsDetail" name="goodsDetail"  style=""></textarea>
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
		
		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
