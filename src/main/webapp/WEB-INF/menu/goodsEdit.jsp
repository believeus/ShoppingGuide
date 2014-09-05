<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="com.etech.variable.Variables" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>商品编辑</title>

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
	
	.brandImg{
			float:left;
			border: 1px solid;
			text-align: center;
			width: 229px;
			margin-right: 15px;
			margin-bottom: 20px;
	}
	
	.middle-money {
	    background: url(/images/middle-money_bj.png) repeat-x scroll 0 0 rgba(0, 0, 0, 0);
	    bottom: 33px;
	    color: #ffffff;
	    font-family: "微软雅黑";
	    font-size: 13px;
	    font-weight: bold;
	    height: 32px;
	    line-height: 32px;
	   	position: relative;
	    text-align: center;
	    width: 227px;
	    /* margin-top:-32px; */
	    opacity:0.9;
	    cursor:pointer;
	    display:none;
	}
	#sid {
		 width: auto; 
		 height: auto; 
		 overflow: hidden; 
		 /* padding: 10px 0px; */
	}
	#sid label {
	    display: inline-block;
	    line-height: 30px;
	}
	.add_img{
		border: 1px solid #69cdcd;
	    color: #69cdcd;
	    float: left;
	    font-size: 65px;
	    height: 231px;
	    line-height: 231px;
	    margin: 0 15px 10px 0;
	    text-align: center;
	    width: 230px;
	    cursor:pointer;
	}
	#drag_con tr {
	    line-height: 34px;
	}
	.tab1 {
	    width: 900px;
	}
	.tab1 tr {
	    line-height: 32px !important;
	}
	.tab1 td {
	    font-size: 13px;
	    text-align:center;
	}
	.tab_ td {
	    color: #69CDCD;
	    font-weight: bold;
	}
	.td1:hover{
		background:#69CDCD;
		color:#FFFFFF;
	}
</style>
<script type="text/javascript">
function addclass(obj){
	if(obj.className == "inputClass"){
		obj.className = "";
	}else{
		obj.className = "inputClass";
	}
	var featureIds=new Array();
	$("#special.inputClass").each(function(){
		featureIds.push($(this).attr("value"));
	});
	$("#featureIds").val();
	$("#featureIds").val(featureIds);
}
	$().ready(function(){
		
		//如果图片为空
		$("input[type=submit]").click(function(){
			var fg = ${flag};
			if(fg!=1){
				if($(".brandImg").size() ==0){
					alert("请上传商品图片");
					return false;
				}
				if($("#filename1").val()==""){
					alert("请选择商品图片");
					return false;
				}else if($("#filename2").val()==""){
					alert("请选择商品图片");
					return false;
				}else if($("#filename3").val()==""){
					alert("请选择商品图片");
					return false;
				}else if($("#filename4").val()==""){
					alert("请选择商品图片");
					return false;
				}else if($("#filename5").val()==""){
					alert("请选择商品图片");
					return false;
				}else if($("#filename6").val()==""){
					alert("请选择商品图片");
					return false;
				}else if($("#filename7").val()==""){
					alert("请选择商品图片");
					return false;
				}else if($("#filename8").val()==""){
					alert("请选择商品图片");
					return false;
				}else if($("#filename9").val()==""){
					alert("请选择商品图片");
					return false;
				}
			}
			
		});
		
		var features = new Array();
		<c:forEach var="feature" items="${tgoodsFeatures }">
			$("p[value='${feature.featureId}']").attr("class","inputClass");
			features.push(${feature.featureId});
		</c:forEach>
		$("#featureIds").val(features);
		
		/* $("#pid").change(function(){
			//alert($(this).val());
			$.ajax({
				type : "post",
				url : "/findChildGoodsType.jhtml",
				dataType : "json",
				data :{"cId":$(this).val()} ,
				success : function(msg) {
					var list = msg.data;
					//alert(list);
					$("#cid").html("<option value=''>请选择..</option>");
					for(var i=0;i<list.length;i++){
						//alert(list[i].goodsTypeName);
						var html = "<option value='"+list[i].goodsTypeId+"'>"+list[i].goodsTypeName+"</option>";
						//html += html;
						$("#cid").append(html);
					}
					if(msg.message == "success"){
						
					}
				}
			});
		});
		$("#cid").change(function(){
			//alert($(this).val());
			$.ajax({
				type : "post",
				url : "/findChildGoodsType.jhtml",
				dataType : "json",
				data :{"cId":$(this).val()} ,
				success : function(msg) {
					var list = msg.data;
					//alert(list);
					$("#sid").html("");
					for(var i=0;i<list.length;i++){
						//alert(list[i].goodsTypeName);
						//var html = "<option value='"+list[i].goodsTypeId+"'>"+list[i].goodsTypeName+"</option>";
						var html = "<label><input name='goodsTypeId' type='checkbox' value='"+list[i].goodsTypeId+"' desc='"+list[i].goodsTypeName+"'>"+list[i].goodsTypeName+"</label>";
						//html += html;
						$("#sid").append(html);
					}
				}
			});
		}); */
		
		var a = $(".brandImg").size()+1;
		var b = $(".brandImg").size();
		$("#add_img").click(function(){
			var html='<div class="brandImg">'
				 +'<div id="preview_wrapper'+a+'" style="display:inline-block;width:227px;height:179px; background-color:#CCC; margin-top: 1px;">'  
					 +'<div id="preview_fake'+a+'" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)">'
					 	+'<img id="preview'+a+'"  style="width:227px;height:179px;" onload="onPreviewLoad(this,227,179)" src=""/><span class="middle-money" value="'+b+'">设为默认</span>'
					 		+'</div>'    
					 	+'</div> '   
				+'<div style="text-align:left;"> '   
					+'<input id="goodsImg'+a+'" type="file" name="goodsImg'+a+'" style="width: 70px;" onchange="filename'+a+'.value=this.value;onUploadImgChange(this,227,179,\'preview'+a+'\',\'preview_fake'+a+'\',\'preview_size_fake'+a+'\');"/>'  
					+'<input type="hidden" id="filename'+a+'" name="filename'+a+'">'
				+'</div>'    
					+'<img id="preview_size_fake1" style=" filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);visibility:hidden;width:0;height:0;"/>' 
				+'<div style="text-align: right; border-top: 1px dashed #E4E4E4; height: 24px; line-height: 24px; margin-right: 3px;"><a onclick="delete_pic(this)" href="javascript:void(0);">删除</a></div>'
				+'</div>';
				
			//alert($(".main_table2 .brandImg").size());
			if($(".main_table2 .brandImg").size() > 8){
				alert("最多9张图片");
			}else{
				$("#Imgs").append(html);
			}
			
			a++;
			b++;
			
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
					/* if($("#main_table2_td .inputClass").length >= 5){
						alert("最多选择5个");
					}else{
					} */
						$(this).addClass("inputClass");		
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
				return false;
			}else if(feature.length >5){
				alert("关键字在五个字以内！");
				return false;
			} else {
				$.post("/insertFeature2.jhtml",{feature:feature,features:$("#featureIds").val(),goodsId:${tgoods.goodsId}},function(result){
					var tfeatureId=result.match(/[0-9]+/);
					var tag=false;
					// 遍历显示出来的特色，判断当前添加的特色是否存在
					$("#main_table2_td_div p").each(function(){
						var pValue=$(this).attr("value");
						//如果存在，则直接设置选中。
						if(pValue==tfeatureId){
							tag=true;
							$(this).attr("class","inputClass");
							var featureIds=new Array();
							$("#special.inputClass").each(function(){
								featureIds.push($(this).attr("value"));
							});
							$("#featureIds").val();
							$("#featureIds").val(featureIds);
							return false;
						}
					});
					//如果不存在，则添加特色。
					if(!tag){
						$("#main_table2_td_div").append("<p id='special' class='inputClass' value="+tfeatureId+" onclick='addclass(this);'>" +feature+ "</p>");
						var featureIds=new Array();
						$("#special.inputClass").each(function(){
							featureIds.push($(this).attr("value"));
						});
						$("#featureIds").val();
						$("#featureIds").val(featureIds);
					}
					$("#textSpecial").val("");
				 });
			}
		});
		
		/* //添加
		$("#addSpecial").click(function() {
			var feature = $("#textSpecial").val();
			if (feature == "") {
				alert("请输入关键字！");
			} else {
				$.post("/insertFeature.jhtml",{feature:feature},function(result){
					var tfeatureId=result.match(/[0-9]+/);
					$("#main_table2_td_div").append("<p id='special' class='inputClass' value="+tfeatureId+" onclick='addclass(this);'>" +feature+ "</p>");
					$("#textSpecial").val("");
				 });
			}
			//location.reload();
		}); */
		
		//判断商品发布的状态
		//1,标准发布有必填字段，则验证必填项   flag=0
		//2,快速发布五必填字段，则不用验证     flag=1
		var flag = ${flag};
		//alert(flag);
		if(flag == 0){
			if($(".brandImg").size() ==0){
				$("#main_form").validate({
					rules : {
						goodsName : {
							required : true,
							rangelength : [ 1, 20 ]
						},
						goodsTypeId : {
							required : true,
							checked : true
						},
						featureIds:{
							required : true
						},
						goodsImg1:{
							required : true
						},
						goodsImg2:{
							required : true
						},
						goodsImg3:{
							required : true
						},
						goodsImg4:{
							required : true
						},
						goodsImg5:{
							required : true
						}
					},
					messages : {
						goodsName : {
							required : "商品名称必填",
							rangelength : "名称长度为1-20个汉字，不能含有特殊字符"
						},
						featureIds:{
							required : "商品特色必填"
						},
						goodsImg1:{
							required : "商品图片必填"
						},
						goodsImg2:{
							required : "商品图片必填"
						},
						goodsImg3:{
							required : "商品图片必填"
						},
						goodsImg4:{
							required : "商品图片必填"
						},
						goodsImg5:{
							required : "商品图片必填"
						}
					}
				}); 
			}else{
				$("#main_form").validate({
					rules : {
						goodsName : {
							required : true,
							rangelength : [ 1, 20 ]
						}
					},
					messages : {
						goodsName : {
							required : "店铺名称必填",
							rangelength : "名称长度为1-20个汉字，不能含有特殊字符"
						}
					}
				}); 
			}
		}
	});	
</script>

<script type="text/javascript">    
		function onUploadImgChange(sender,offsetWidth,offsetHeight,preview,preview_fake,preview_size_fake){     
		    if( !sender.value.match( /.jpg|.gif|.png|.jpeg|.bmp/i ) ){     
		        alert('图片格式无效！');     
		        return false;     
		    }     
		    
		    var objPreview = document.getElementById( preview );     
		    var objPreviewFake = document.getElementById( preview_fake );     
		    var objPreviewSizeFake = document.getElementById( preview_size_fake );    
		         
		    if( sender.files &&  sender.files[0] ){  
		        var reader = new FileReader();
				reader.onload = function(evt){objPreview.src = evt.target.result;};
		        reader.readAsDataURL(sender.files[0]);	   
		        
		    }else if( objPreviewFake.filters ){    
		        // IE7,IE8 在设置本地图片地址为 img.src 时出现莫名其妙的后果     
		        //（相同环境有时能显示，有时不显示），因此只能用滤镜来解决     
		             
		        // IE7, IE8因安全性问题已无法直接通过 input[file].value 获取完整的文件路径     
		        sender.select();     
		        var imgSrc = document.selection.createRange().text;     
		        
		        objPreviewFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;     
		        objPreviewSizeFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;     
		        autoSizePreview( objPreviewFake,offsetWidth,offsetHeight );     
		        objPreview.style.display = 'none';     
		    }     
		}     
		    
		function onPreviewLoad(sender,offsetWidth,offsetHeight){    
		    autoSizePreview( sender, offsetWidth, offsetHeight );     
		}     
		    
		function autoSizePreview( objPre, originalWidth, originalHeight ){     
		    var zoomParam = clacImgZoomParam( originalWidth, originalHeight, originalWidth, originalHeight );     
		    objPre.style.width = zoomParam.width + 'px';     
		    objPre.style.height = zoomParam.height + 'px';     
		}     
		    
		function clacImgZoomParam( maxWidth, maxHeight, width, height ){     
		    var param = { width:width, height:height, top:0, left:0 };     
		         
		    if( width>maxWidth || height>maxHeight ){     
		        rateWidth = width / maxWidth;     
		        rateHeight = height / maxHeight;     
		             
		        if( rateWidth > rateHeight ){     
		            param.width =  maxWidth;     
		            param.height = height / rateWidth;     
		        }else{     
		            param.width = width / rateHeight;     
		            param.height = maxHeight;     
		        }     
		    }     
		         
		    param.left = (maxWidth - param.width) / 2;     
		    param.top = (maxHeight - param.height) / 2;     
		         
		    return param;     
		}      
	</script>  
	
	<script type="text/javascript">
		function delete_pic(object,path){		
			if(path!=""){
				Img(path);
			}
			$(object).closest("div").parent().remove();
		}
		
		function Img(path){
			var deleteImgs = $("#deleteImgs");
			
			if (deleteImgs.length > 0) { 
		     	//对象存在的处理逻辑
	            $("#deleteImgs").val(deleteImgs.val()+","+path);
		    } else {
		      	//对象不存在的处理逻辑
		      	var html='<input id="deleteImgs" type="hidden" name="deleteImgs" value="'+path+'"/>';
				$("#main_form").append(html);
		   }	
			
		}
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
				<a href="/editGoods.jhtml?goodsId=${tgoods.goodsId }" title="商品编辑">商品编辑</a>
			</p>
		<form id="main_form" method="post" action="/updateGoods.jhtml" enctype="multipart/form-data">
			<input type="hidden" name="goodsId" value="${tgoods.goodsId }">
			<table class="main_table1" style="">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">商品编辑</p></td>
					<td style="width:65%;"></td>
					<td style="width:10%;">
						<input type="submit" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" value="保存" />
					</td>
					<td style="width:10%;">
						<input style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" type="button" value="返回" onClick="javascript:window.history.back();" title="点击取消"/>
					</td>
				</tr>
			</table>
			<div style="width:1000px;text-align:center;margin:0 auto;">
				<img src="/images/line.png">
			</div>
			
			<input type="hidden" name="shopId" value="${shopId}">
			<table class="main_table2" style="">
			<c:if test="${flag ==0 }">
				<tr>
					<c:if test="${flag == 0 }"><td style="color:red;">*</td></c:if>
					<c:if test="${flag == 1 }"><td style="color:red;"></td></c:if>
					<td>商品名称：</td>
					<td style="width:85%;"><input style="height:35px;" id="goodsName" name="goodsName" type="text" value="${tgoods.goodsName }"/></td>
				</tr>
				<tr>
					<c:if test="${flag == 0 }"><td style="color:red;">*</td></c:if>
					<c:if test="${flag == 1 }"><td style="color:red;"></td></c:if>
					<td>商品类型：</td>
					<td>
						<div id="selectGoodsType" style="float:left;height:auto;line-height:32px;width:710px;">
							<c:forEach items="${goodsTypes }" var="goodsType">
								<label><input style="display:inline-block;" type="checkbox" onClick="return false;" checked="checked">${goodsType.goodsTypeName }</label>
							</c:forEach>
							<label id="psed" class="error" style="display:none;">请选择商品类型</label>
						</div> 
						<input type="button" style="float:right;border:none;width:auto;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" onclick="boxAlpha();" value="修改商品类型" id="">
						<!-- <input id="" type="button" value="选择商品类型" onClick="boxAlpha();" style="border:none;width:auto;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;">
						-->
					</td>
				</tr>
				<tr>
					<td style="color:red;">*	
					</td>
					<td style="">特色：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						<div id="main_table2_td_div" style="height: auto; overflow: hidden; width: 840px;">
							<c:forEach var="tfeatures" items="${tfeatures }">
								<p id="special" name="special" value="${tfeatures.featureId }">${tfeatures.featureName }</p>
							</c:forEach>
							<c:forEach items="${fs }" var="fs">
								<p id="special" name="special" value="${fs.featureId }">${fs.featureName }</p>
							</c:forEach>
						</div>
						<input style="width:0;border:0;" type="text" value="" id="featureIds" name="featureIds">
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input id="textSpecial" name="textSpecial" style="height:35px;" type="text" />&nbsp;&nbsp;&nbsp;<input id="addSpecial" style="border:none;width:auto;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" type="button" value="添加" /></td>
				</tr>
			</c:if>
				<tr>
					<td></td>
					<td>商品简介：</td>
					<td>
						<textarea id="goodsDetail" name="goodsDetail"  style="width: 642px; height: 134px;resize:none;">${tgoods.introduction }</textarea>
					</td>
				</tr>
				<tr>
					<c:if test="${flag == 0 }"><td style="color:red;">*</td></c:if>
					<c:if test="${flag == 1 }"><td style="color:red;"></td></c:if>
					<td colspan="3">
						上传图片：
						<span style="font-size:13px;">(最多可上传9张图片)</span>
					</td>
				</tr>
   				<tr>
					<td colspan="3" id="Imgs">
						<div id="add_img" class="add_img" title="添加商品图片">+</div>
						<c:forEach var="path" items="${paths}" varStatus="status">
						 <c:if test="${path!='' }">
							<div class="brandImg">
								 <div id="preview_wrapper${status.index+1}" style="display:inline-block;width:227px;height:179px; background-color:#CCC; margin-top: 1px;">    
							        <div id="preview_fake${status.index+1}" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)">  
							            <img id="preview${status.index+1}"  style="width:227px;height:179px;" onload="onPreviewLoad(this,227,179)" src="<%=Variables.goodsPhotoURL %>${shopId}/${path }"/>
							        	<span class="middle-money" value="${status.index}">设为默认</span>
							        </div>    
							    </div>    
							    <div style="text-align:left;">    
							    <input id="goodsImg${status.index+1}" type="file" name="goodsImg${status.index+1}" style="width: 70px;" onchange="filename${status.index+1}.value=this.value;Img('${path}');onUploadImgChange(this,227,179,'preview${status.index+1}','preview_fake${status.index+1}','preview_size_fake${status.index+1}');"/>  
							    <input type="hidden" id="filename${status.index+1}" name="filename${status.index+1}" value="${path }">
							    </div>    
							    <img id="preview_size_fake${status.index+1}" style=" filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);visibility:hidden;width:0;height:0;"/> 
								<div style="text-align: right; border-top: 1px dashed #E4E4E4; height: 24px; line-height: 24px; margin-right: 3px;"><a onclick="delete_pic(this,'${path}')" href="javascript:void(0);">删除</a></div>
							</div>
						 </c:if> 
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="hidden" id="moren" name="moren">
					</td>
				</tr>
				<tr style="">
					<td colspan="3" style="text-align:right;">
						<input type="submit" style="margin-right:30px;border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" value="保存" />
						<input style="margin-right:30px;border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" type="button" value="返回" onClick="javascript:window.history.back();" title="点击取消"/>
					</td>
				</tr>
			</table>
			</form>
		</div>
	<script type="text/javascript">
	    $().ready(function(){
	    	$("#submit").click(function(){
	    		$("#selectGoodsType").html("");
	    		boxAlpha();
	    		var count = 0;
	    		var featureIds=new Array();
				var obj = $("input[name=goodsTypeId]:checkbox");
				$("#selectGoodsType").html("");
				for(var i=0;i<obj.length;i++){
					if(obj[i].checked){					
						featureIds.push(obj[i].value);
						count ++;	
						var html = "<label><input onClick='return false;' type='checkbox' name='goodsTypeId' value='"+obj[i].getAttribute("value")+"' checked='checked'>"+obj[i].getAttribute("desc")+"</label>";
						$("#selectGoodsType").append(html);
					}
				}
				/* if($("#selectGoodsType").html("")){
					var html = "<c:forEach items='${goodsTypes }' var='goodsType'><label><input type='checkbox' onClick='return false;' checked='checked'>${goodsType.goodsTypeName }</label></c:forEach>";
					$("#selectGoodsType").append(html);
				} */
	    	});
	    	
	    	$("input[type=submit]").click(function(){
	    		var fg = ${flag};
	    		if(fg !=1){
		    		var goodsType = $("#selectGoodsType").text();
		    		//alert(goodsType);
		    		if(goodsType == ''){
		    			alert("请选择商品类型");
		    			return false;
		    		}
	    		}
	    	});
	    
	    
	    	
	    $(".td1").each(function(){
	    	
	    	var goodsTypeId = ${goodsTypesId};
	    	if($(this).attr("value") == goodsTypeId){
	    		$(this).css({"color":"#FF5900","font-weight":"bold"});
	    	}
	    	
	    	$(this).click(function(){
	    		$.ajax({
		    		type : "post",
					url : "/findGoodsTypes.jhtml",
					dataType : "json",
					data :{"id":$(this).attr("value")},
					success : function(msg) {
						var list = msg.data;
						$("#main_table2_td_div").html("");
						for(var i=0;i<list.length;i++){
							var html = "<p value='"+list[i].featureId+"' name='special' id='special' onclick='addclass(this);'>"+list[i].featureName+"</p>";
							$("#main_table2_td_div").append(html);
						}
					}
		    	});
	    		
	    	}); 
	    	
	    	
	    	$(this).click(function(e){
	    		//alert($(this).attr("value"));
	    		$.ajax({
		    		type : "post",
					url : "/findChildGoodsType.jhtml",
					dataType : "json",
					data :{"cId":$(this).attr("value")},
					success : function(msg) {
						var list = msg.data;
						$("#sublist").html("");
						for(var i=0;i<list.length;i++){
							var html = "<label style='width:150px;height:25px;overflow:hidden;float:left;'><input name='goodsTypeId' type='checkbox' value='"+list[i].goodsTypeId+"' desc='"+list[i].goodsTypeName+"'>"+list[i].goodsTypeName+"</label>";
							$("#sublist").append(html);
							$("#sublist").css({
								top:e.pageY-129,
								left:e.pageX-124,
								border:"1px solid #69CDCD"
								}).hover(function(){
									$(this).show()
									},function(){
										$(this).hide();
							});
							$("#sublist").show();
						}
					}
		    	});
	    	});
	    });
	    
	    
    });
	</script>
<!-- alpha div -->
<div id="maskLayer" style="display:none">
<iframe id="maskLayer_iframe" frameBorder=0 scrolling=no style="filter:alpha(opacity=50)"></iframe>
<div id="alphadiv" style="filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5"></div>
	<div id="drag">
		<h3 id="drag_h">
			<b>请选择商品类型</b><span id="cancel" style="margin-left:20px;">取消</span><span id="submit">确定</span>	
		</h3>
		<div id="drag_con">
		<table class="tab_" style="float:left;margin-right:20px;">
			<c:forEach items="${gList }" var="pGoodsType" varStatus="status">
				<tr>
					<td class="" value="${pGoodsType.goodsTypeId }">${pGoodsType.goodsTypeName }</td>
				</tr>
			</c:forEach>
		</table>
		<table class="tab1" style="float:left;">
			<tr>
				<c:forEach items="${gt1 }" var="pGoodsType">
					<td class="td1" value="${pGoodsType.goodsTypeId }" >${pGoodsType.goodsTypeName }</td>
				</c:forEach>
			</tr>
		</table>
		<table class="tab1" style="float:left;">
			<tr>
				<c:forEach items="${gt2 }" var="pGoodsType">
					<td class="td1" value="${pGoodsType.goodsTypeId }" >${pGoodsType.goodsTypeName }</td>
				</c:forEach>
			</tr>
		</table>
		<table class="tab1" style="float:left;">
			<tr>
				<c:forEach items="${gt3 }" var="pGoodsType">
					<td class="td1" value="${pGoodsType.goodsTypeId }" >${pGoodsType.goodsTypeName }</td>
				</c:forEach>
			</tr>
		</table>
		<table class="tab1" style="float:left;width:700px;">
			<tr>
				<c:forEach items="${gt4 }" var="pGoodsType">
					<td class="td1" value="${pGoodsType.goodsTypeId }" >${pGoodsType.goodsTypeName }</td>
				</c:forEach>
			</tr>
		</table>
		<table class="tab1" style="float:left;">
			<tr>
				<c:forEach items="${gt5 }" var="pGoodsType">
					<td class="td1" value="${pGoodsType.goodsTypeId }" >${pGoodsType.goodsTypeName }</td>
				</c:forEach>
			</tr>
		</table>
		<table class="tab1" style="float:left;width: 500px;">
			<tr>
				<c:forEach items="${gt6 }" var="pGoodsType">
					<td class="td1" value="${pGoodsType.goodsTypeId }" >${pGoodsType.goodsTypeName }</td>
				</c:forEach>
			</tr>
		</table>
		<table class="tab1" style="float:left;width: 420px;">
			<tr>
				<c:forEach items="${gt7 }" var="pGoodsType">
					<td class="td1" value="${pGoodsType.goodsTypeId }" >${pGoodsType.goodsTypeName }</td>
				</c:forEach>
			</tr>
		</table>
		<table class="tab1" style="float:left;">
			<tr>
				<c:forEach items="${gt8 }" var="pGoodsType">
					<td class="td1" value="${pGoodsType.goodsTypeId }" >${pGoodsType.goodsTypeName }</td>
				</c:forEach>
			</tr>
		</table>
		<table class="tab1" style="float:left;width: 500px;">
			<tr>
				<c:forEach items="${gt9 }" var="pGoodsType">
					<td class="td1" value="${pGoodsType.goodsTypeId }" >${pGoodsType.goodsTypeName }</td>
				</c:forEach>
			</tr>
		</table>
		<div id="sublist" class="" style="width:300px;display:none;"></div>
			
			<%-- <select name="pid" id="pid">
				<option value="">请选择..</option>
				<c:forEach items="${gList }" var="pGoodsType">
					<option value="${pGoodsType.goodsTypeId }">${pGoodsType.goodsTypeName }</option>
				</c:forEach>
			</select>
			<select name="cid" id="cid">
				<option value="">请选择..</option>
			</select>
			<div id="sid">
				
			</div> --%>
			<!-- <script type="text/javascript">
				var d = new dTree('d');
				d.add(10,-1,'服饰');
				<c:forEach var="gli" items="${gList}" varStatus="status" >
					d.add(${gli.goodsTypeId},${gli.parentId},'authority','${status.index}','${gli.goodsTypeName}');
				</c:forEach>
				
				document.write(d);
				
				d.openAll();
			</script> -->
		</div><!-- drag_con end -->
	</div>
</div><!-- maskLayer end -->
<!-- alpha div end -->
<div id="sublist" style="display:none"></div>
		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
   	 	<script type="text/javascript" src="/js/drag.js"></script>
</body>
</html>
