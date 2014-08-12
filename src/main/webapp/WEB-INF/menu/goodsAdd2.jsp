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
		.middle-money {
		    background: url(/images/middle-money_bj.png) repeat-x scroll 0 0 rgba(0, 0, 0, 0);
		    bottom: 0;
		    color: #ffffff;
		    font-family: "微软雅黑";
		    font-size: 13px;
		    font-weight: bold;
		    height: 32px;
		    line-height: 32px;
		   	position: relative;
		    text-align: center;
		    width: 230px;
		    /* margin-top:-32px; */
		    opacity:0.9;
		    cursor:pointer;
		    display:none;
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
	$(function(){
		$("#add_img").click(function(){
			var a = $(".main_table3 .brandImg").size();
			var html = "<div class='brandImg' style='margin-top:20px;float:left;'><span><a onclick='file"+a+".click()' href='javascript:return false;'>点击上传图片</a></span><span value='"+a+"' id='' class='middle-money' style='height:32px;display:none;'>设为默认</span><img id='shopPhotoURL' style='width:229px;height:179px' src='' name='shopPhotoURL'/></div><input type='file' style='display:none' id='file"+a+"' name='goodsImg"+a+"' onchange='filename"+a+".value=this.value;loadImgFast(this,"+a+")'><input type='hidden' id='filename"+a+"' name='goodsImg"+a+"'>";
			//alert($(".shopShow .brandImg").size());
			if($(".main_table3 .brandImg").size() > 8){
				alert("最多9张图片");
			}else{
				$(".brandImg").parent().append(html);
			}
			$(".middle-money").each(function(){
				$(this).click(function(){
					//alert($(this).attr("value")+"=this.val");
					$("#moren").val($(this).attr("value"));
					alert("设置成功");
				});
			});
			$(".brandImg").each(function(){
				$(this).mouseover(function(){
					$(this).find(".middle-money").css("display","block");
				}).mouseout(function(){
					$(this).find(".middle-money").css("display","none");
				});
			}); 
		});
		
		$(".brandImg").each(function(){
			$(this).mouseover(function(){
				$(this).find(".middle-money").css("display","block");
			}).mouseout(function(){
				$(this).find(".middle-money").css("display","none");
			});
		}); 
		
		$(".middle-money").each(function(){
			$(this).click(function(){
				//alert($(this).attr("value")+"=this.val");
				$("#moren").val($(this).attr("value"));
				alert("设置成功");
			});
		});
		
		$("input[type='submit']").click(function(){
			var dis = $("#goodsDetail").val();
			var imgs = $("[id^='filename']");
			imgs.each(function(){
				if($(this).val() != "" || dis != ""){
					$.post("/addSimpleGoods.jhtml",$("#main_form").serialize(),function(){
						//window.location.href = "/myProducts.jhtml";
					});
				}else{
					alert("请填写商品介绍或者选择商品图片");
					return  false;
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
			<p style="margin:0 auto;width:1000px;">所在位置：
				<a href="/menu.jhtml" title="菜单">菜单</a> >
   				<a href="/myShop.jhtml?shopId=${shopId }" title="我的店铺">我的店铺</a> >
				<a href="/myProducts.jhtml?shopId=${shopId }" title="商品列表">商品列表</a> >
				<a href="/goodsAdd2.jhtml?shopId=${shopId }" title="商品添加">商品添加</a>
			</p>
		<form id="main_form" method="post" action="/addSimpleGoods.jhtml" enctype="multipart/form-data">
			<table class="main_table1" style="">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">商品添加</p></td>
					<td style="width:65%;"><div style=""><a href="/goodsAdd.jhtml?shopId=${shopId }" style="font-size:12px;color:#69CDCD;">详细发布商品</a></div></td>
					<td style="width:10%;">
						<input type="submit" style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" value="预览" />
					</td>
					<td style="width:10%;">
						<input style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" type="button" value="取消" onClick="javascript:window.history.back();" title="点击取消"/>
					</td>
				</tr>
			</table>			
			<div style="width:1000px;text-align:center;margin:0 auto;">
				<img src="/images/line.png">
			</div>
			
			<input type="hidden" name="shopId" value="${shopId}">
			<table class="main_table2" style="">
				<tr>
					<td></td>
					<td>商品简介：</td>
					<td>
						<textarea id="goodsDetail" name="goodsDetail">请输入商品简介</textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td>
						
					</td>
				</tr>
			</table>


			<div style="width:1000px;text-align:center;margin:0 auto;">
				<img src="/images/line.png">
			</div>
			
			<table class="main_table3" style="">
    				<tr>
						<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
						<td style="width:90%;" colspan="2"><div style="float:left;color:red;">*</div>上传图片：<input id="add_img" type="button" value="添加商品图片" onClick=""/><span style="font-size:13px;">(最多可上传9张图片)</span></td>
					</tr>
    				<tr style="">
						<td colspan="2" style="">
							<input type="hidden" id="moren" name="moren" value="">
						</td>
						<td>
							<div class="brandImg" style="margin-top:20px;float:left;">
								<span>
									<a onclick="file0.click()" href="javascript:return false;">点击上传图片</a>
								</span>
								<span style="height:32px;display:none;" class="middle-money" id="" value="0">设为默认</span>
								<img id="shopPhotoURL" style="width:229px;height:179px" src="" name="goodsImg"/>
							</div>
							<input type="file" style="display:none" id="file0" name="goodsImg" onchange="filename0.value=this.value;loadImgFast(this,0)">
							<input type="hidden" id="filename0" name="goodsImg">
						</td>
					</tr>
			</table>
		</form>
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
