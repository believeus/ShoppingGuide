<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script language="JavaScript" src="/js/jquery.js"></script>
<script language="JavaScript" src="/js/jquery.validate.js"></script>
<script language="JavaScript" src="/js/messages_cn.js"></script>
<script type="text/javascript" src="/js/validate.expand.js"></script>
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
<style type="text/css">
	.brandImg span{
		display:block;
		position:absolute;
		top:0px;left:0px;
		width:229px;
		height:179px;
	}
	
	.brandImg{
		border-color: #B8B8B8 #DCDCDC #DCDCDC #B8B8B8;
	    border-radius: 2px 2px 2px 2px;
	    border-style: solid;
	    border-width: 1px;
	    background-color: #666666;
	    width:229px;
	    height:179px;
	    position:relative;
	    margin-right:15px;
	}
	
	.brandImg span:hover{
		background-color:#FFFFFF;
	    opacity: 0.7;
	    filter:alpha(opacity=50);
	    -moz-opacity:0.5;
	    -khtml-opacity: 0.5;
	}
	
	.brandImg span a{
		display:block;
		position:absolute;
		top:80px;
		left:65px;
		color:#d5d5d5;
	}
	
	.deleteProductImage:hover{
		color:#C9033B !important;
	}
</style>
<script type="text/javascript">
	$().ready(function(){
		
		$("#add_img").click(function(){
			var a = $(".main_table3 .brandImg").size();
			var html = "<div class='brandImg' style='margin-top:20px;float:left;'><span><a onclick='file"+a+".click()' href='javascript:return false;'>点击上传图片</a></span><img id='shopPhotoURL' style='width:229px;height:179px' src='' name='shopPhotoURL'/></div><input type='file' style='display:none' id='file"+a+"' name='file"+a+"' onchange='filename"+a+".value=this.value;loadImgFast(this,"+a+")'><input type='hidden' id='filename"+a+"' name='filename"+a+"'>";
			//alert($(".shopShow .brandImg").size());
			if($(".main_table3 .brandImg").size() > 8){
				alert("最多9张图片");
			}else{
				$(".brandImg").parent().append(html);
			}
		});
		
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
			rules : {
				goodsName : {
					required : true,
					rangelength : [ 1, 10 ]
				},
				goodsTypeId : {
					goodsTypeName : true
				}
			},
			messages : {
				goodsName : {
					required : "店铺名称必填",
					rangelength : "名称长度为1-10个汉字，不能含有特殊字符"
				}
			}
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
					<td style="width:12%;"><div style=""><a href="/goodsAdd2.jhtml" style="font-size:12px;color:#69CDCD;">快速发布商品</a></div></td>
					<td style="width:56%;"></td>
					<td style="width:9%;">
						<input style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" type="button" value="取消" onClick="javascript:window.history.back();" title="点击取消"/>
					</td>
					<td style="width:8%;"><input type="button" value="预览" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
				</tr>
			</table>
			<div style="width:1000px;text-align:center;margin:0 auto;">
				<img src="/images/line.png">
			</div>
			
			<form id="main_form" method="post" action="/addDetailedGoods.jhtml">
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
						<select id="goodsTypeId" name="goodsTypeId" style="width:20%;">
						<option value="-2">请选择商品类型</option>
						<c:forEach var="gli" items="${gList}">
							<option value="${gli.goodsTypeId}">${gli.goodsTypeName}</option>
						</c:forEach>
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
						<textarea id="goodsDetail" name="goodsDetail"  style="width: 642px; height: 134px;resize:none;"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" style="height:35px;width:60px;" value="发布" /></td>
				</tr>
			</table>

			</form>

			<div style="width:1000px;text-align:center;margin:0 auto;">
				<img src="/images/line.png">
			</div>
			
			<table class="main_table3" style="">
     				<tr>
					<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
					<td style="width:90%;" colspan="2"><div style="float:left;color:red;">*</div>上传图片：<input id="add_img" type="button" value="添加商品图片" onClick=""/><span style="font-size:13px;">(最多可上传9张图片)</span></td>
				</tr>
     				<tr style="">
					<td colspan="2" style=""></td>
					<td>
						<div class="brandImg" style="margin-top:20px;float:left;">
							<span>
								<a onclick="file0.click()" href="javascript:return false;">点击上传图片</a>
							</span>
							<img id="shopPhotoURL" style="width:229px;height:179px" src="" name="shopPhotoURL"/>
						</div>
						<input type="file" style="display:none" id="file0" name="file0" onchange="filename0.value=this.value;loadImgFast(this,0)">
						<input type="hidden" id="filename0" name="filename0">
					</td>
				</tr>
			</table>
			
		</div>

		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
   	 	<script type="text/javascript">
			function loadImgFast(img,i){
				if (img.files && img.files[0]){
					var reader = new FileReader();
					reader.onload = function(evt){$(".brandImg:eq("+i+") img")[0].src = evt.target.result;}
		            reader.readAsDataURL(img.files[0]);	
				}else if(window.navigator.userAgent.indexOf("MSIE")>=1){
				   	file.select(); 
		   			path = document.selection.createRange().text;
		   			$(".brandImg:eq("+i+") img")[0].src = path;
		   		} 
			}
		</script>
</body>
</html>
