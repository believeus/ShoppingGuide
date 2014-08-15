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

<title>商品添加</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="/css/goodsAdd.css" />
<link rel="stylesheet" type="text/css" href="/css/css.css" />
<link rel="stylesheet" type="text/css" href="css/dtree.css">
<script language="JavaScript" src="/js/jquery.js"></script>
<script language="JavaScript" src="/js/jquery.validate.js"></script>
<script language="JavaScript" src="/js/messages_cn.js"></script>
<script type="text/javascript" src="/js/validate.expand.js"></script>
<script type="text/javascript" src="/js/drag.js"></script>
<script language="JavaScript" src="js/dtree.js"></script>
	<style type="text/css">
		.inputClass{
			background:#69CDCD;
			border:1px solid #69CDCD !important;
			border-radius:.2em;
			color:white;
		}
		.error {
		    color: red;
		}
		.main_table2_td p{
			font-size:13px;
			border-radius:.2em;
			margin:5px;
			width:auto;
			border:1px solid gray;
			height:20px;
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
<script type="text/javascript">
function addclass(obj){
	if(obj.className == "inputClass"){
		obj.className = "";
	}else{
		obj.className = "inputClass";
	}
}
	$().ready(function(){
		
		$("#add_img").click(function(){
			var a = $(".main_table2 .brandImg").size();
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
		
		var specs = $("[id=special]");
		
		specs.each(function(){
			$(this).click(function(){
				if($(this).hasClass("inputClass")){
					$(this).removeClass("inputClass");
				}else{
					if($("#main_table2_td .inputClass").length >= 5){
						alert("最多选择5个");
					}else{
						$(this).addClass("inputClass");		
					}
				}
				var featureIds=new Array();
				$("#special.inputClass").each(function(){
					featureIds.push($(this).attr("value"));
				});
				$("#featureIds").val();
				$("#featureIds").val(featureIds);
			});
		});
		
		//添加
		$("#addSpecial").click(function() {
			var feature = $("#textSpecial").val();
			if (feature == "") {
				alert("请输入关键字！");
			} else {
				$.post("/insertFeature.jhtml",{feature:feature},function(result){
					var tfeatureId=result.match(/[0-9]+/);
					$("#main_table2_td").append("<p id='special' class='inputClass' value="+tfeatureId+" onclick='addclass(this);'>" +feature+ "</p>");
					$("#textSpecial").val("");
				 });
			}
			location.reload();
		});
		
		$("#main_form").validate({
			rules : {
				goodsName : {
					required : true,
					rangelength : [ 1, 20 ]
				},
				goodsTypeId : true
			},
			messages : {
				goodsName : {
					required : "店铺名称必填",
					rangelength : "名称长度为1-20个汉字，不能含有特殊字符"
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
			<p style="margin:0 auto;width:1000px;">所在位置：
				<a href="/menu.jhtml" title="菜单">菜单</a> >
   				<a href="/myShop.jhtml?shopId=${shopId }" title="我的店铺">我的店铺</a> >
				<a href="/myProducts.jhtml?shopId=${shopId }" title="商品列表">商品列表</a> >
				<a href="/goodsAdd.jhtml?shopId=${shopId }" title="商品添加">商品添加</a>
			</p>
		<form id="main_form" method="post" action="/addDetailedGoods.jhtml" enctype="multipart/form-data">
			<table class="main_table1" style="">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">商品添加</p></td>
					<td style="width:65%;"><div style=""><a href="/goodsAdd2.jhtml?shopId=${shopId}" style="font-size:12px;color:#69CDCD;">快速发布商品</a></div></td>
					<td style="width:10%;">
						<input type="submit" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" value="预览" />
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
					<td style="color:red;">*</td>
					<td>商品名称：</td>
					<td style="width:85%;"><input style="height:35px;" id="goodsName" name="goodsName" type="text" /></td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td>商品类型：</td>
					<td>
						<input id="" type="button" value="选择商品类型" onClick="boxAlpha();" style="border:none;width:auto;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;">
						<div id="selectGoodsType"></div>
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td style="">特色：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						<c:forEach var="tfeatures" items="${tfeatures }">
							<p id="special" name="special" value="${tfeatures.featureId }">${tfeatures.featureName }</p>
						</c:forEach>
						<input type="hidden" value="" id="featureIds" name="featureIds">
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input id="textSpecial" name="textSpecial" style="height:35px;" type="text" />&nbsp;&nbsp;&nbsp;<input id="addSpecial" style="border:none;width:auto;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" type="button" value="添加" /></td>
				</tr>
				<tr>
					<td></td>
					<td>商品简介：</td>
					<td>
						<textarea id="goodsDetail" name="goodsDetail"  style="width: 642px; height: 134px;resize:none;"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div style="float:left;color:red;">*</div>
						上传图片：<input id="add_img" type="button" value="添加商品图片" style="border:none;width:auto;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;"/>
						<span style="font-size:13px;">(最多可上传9张图片)</span>
					</td>
				</tr>
   				<tr>
					<td colspan="3">
						<div class="brandImg" style="margin-top:20px;float:left;">
							<span>
								<a onclick="file0.click()" href="javascript:return false;">点击上传图片</a>
							</span>
							<span style="height:32px;display:none;" class="middle-money" id="" value="0">设为默认</span>
							<img id="shopPhotoURL" style="width:229px;height:179px" src="" name="shopPhotoURL"/>
						</div>
						<input type="file" style="display:none" id="file0" name="goodsImg" onchange="filename0.value=this.value;loadImgFast(this,0)">
						<input type="hidden" id="filename0" name="goodsImg">
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="hidden" id="moren" name="moren" value="">
					</td>
				</tr>
			</table>
			</form>
		</div>
	<script type="text/javascript">
	    $().ready(function(){
	    	$("#submit").click(function(){
	    		boxAlpha();
	    		var count = 0;
	    		var featureIds=new Array();
				var obj = document.all.authority;
				$("#selectGoodsType").html("");
				for(var i=0;i<obj.length;i++){
					if(obj[i].checked){					
						featureIds.push(obj[i].value);
						count ++;	
						var html = "<label><input onClick='return false;' type='checkbox' name='goodsTypeId' value='"+obj[i].getAttribute("value")+"' checked='checked'>"+obj[i].getAttribute("desc")+"</label>";
						$("#selectGoodsType").append(html);
					}
				}	
				if(featureIds == null && featureIds == ""){
					alert("请选择商品类型");
				}else{
					
				}
	    	});
	    });
	</script>
<!-- alpha div -->
<div id="maskLayer" style="display:none">
<iframe id="maskLayer_iframe" frameBorder=0 scrolling=no style="filter:alpha(opacity=50)"></iframe>
<div id="alphadiv" style="filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5"></div>
	<div id="drag">
		<h3 id="drag_h">
			<b>请选择商品类型</b><span id="submit">确定</span>	
		</h3>
		<div id="drag_con">
			<script type="text/javascript">
				var d = new dTree('d');
			
				d.add(10,-1,'服饰');
				<c:forEach var="gli" items="${gList}" varStatus="status" >
					d.add(${gli.goodsTypeId},${gli.parentId},'authority','${status.index}','${gli.goodsTypeName}');
				</c:forEach>
				
				document.write(d);
				
				d.openAll();
			</script>
		</div><!-- drag_con end -->
	</div>
</div><!-- maskLayer end -->
<!-- alpha div end -->
<div id="sublist" style="display:none"></div>
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
