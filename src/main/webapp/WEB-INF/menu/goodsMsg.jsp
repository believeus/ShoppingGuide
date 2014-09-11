<%@page import="com.etech.variable.Variables"%>
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

<title>商品信息</title>

<meta http-equiv="pragma" content="no-cache">

<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="X-UA-Compatible" content="IE=8"/>
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
		
		$("#pid").change(function(){
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
						var html = "<label><input name='goodsTypeId' type='checkbox' value='"+list[i].goodsTypeId+"'>"+list[i].goodsTypeName+"</label>";
						//html += html;
						$("#sid").append(html);
					}
				}
			});
		});
		
		var a =2;
		var b =1;
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
				//alert("最多9张图片");
				easyDialog.open({
	                container: {
	                    header: '提示',
	                    content: '最多9张图片'
	                },
	                overlay: false
	            });
			}else{
				$("#Imgs").append(html);
			}
			
			a++;
			b++;
			
			$(".middle-money").each(function(){
				$(this).click(function(){
					//alert($(this).attr("value")+"=this.val");
					$("#moren").val($(this).attr("value"));
					//alert("设置成功");
					easyDialog.open({
		                container: {
		                    header: '提示',
		                    content: '设置成功'
		                },
		                overlay: false
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
				//alert("设置成功");
				easyDialog.open({
	                container: {
	                    header: '提示',
	                    content: '设置成功'
	                },
	                overlay: false
	            });
			});
		});
		
		var specs = $("[id=special]");
		
		specs.each(function(){
			$(this).click(function(){
				if($(this).hasClass("inputClass")){
					$(this).removeClass("inputClass");
				}else{
					if($("#main_table2_td .inputClass").length >= 5){
						//alert("最多选择5个");
						easyDialog.open({
			                container: {
			                    header: '提示',
			                    content: '最多选择5个'
			                },
			                overlay: false
			            });
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
				//alert("请输入关键字！");
				easyDialog.open({
	                container: {
	                    header: '提示',
	                    content: '请输入关键字！'
	                },
	                overlay: false
	            });
			} else {
				$.post("/insertFeature.jhtml",{feature:feature},function(result){
					var tfeatureId=result.match(/[0-9]+/);
					$("#main_table2_td").append("<p id='special' class='inputClass' value="+tfeatureId+" onclick='addclass(this);'>" +feature+ "</p>");
					$("#textSpecial").val("");
				 });
			}
			//location.reload();
		});
		
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
				cid:{
					required : true
				},
				goodsImg1:{
					required : true
				}
			},
			messages : {
				goodsName : {
					required : "店铺名称必填",
					rangelength : "名称长度为1-20个汉字，不能含有特殊字符"
				},
				cid:{
					required : "商品类型必填"
				},
				goodsImg1:{
					required : "商品图片必填"
				}
			}
		});
	});	
</script>

<script type="text/javascript">    
		function onUploadImgChange(sender,offsetWidth,offsetHeight,preview,preview_fake,preview_size_fake){     
		    if( !sender.value.match( /.jpg|.gif|.png|.jpeg|.bmp/i ) ){     
		       // alert('图片格式无效！'); 
		        easyDialog.open({
	                container: {
	                    header: '提示',
	                    content: '图片格式无效！'
	                },
	                overlay: false
	            });
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
		        //（相同环境有时请输入商品简介能显示，有时不显示），因此只能用滤镜来解决     
		             
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
		function delete_pic(object){		
			$(object).closest("div").parent().remove();
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
				<a href="/goodsMsg.jhtml?goodsId=${tgoods.goodsId }" title="商品信息">商品信息</a>
			</p>
			<table class="main_table1" style="">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">商品信息</p></td>
					<td style="width:65%;"></td>
					<td style="width:10%;">
						<input type="button" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" value="编辑" onClick="javascript:window.location.href='/editGoods.jhtml?goodsId=${tgoods.goodsId}'"/>
					</td>
					<td style="width:10%;">
						<input style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" type="button" value="确认" onClick="javascript:window.location.href='/myProducts.jhtml?shopId=${tgoods.shopId}';" title="确认"/>
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
					<td style="color:red;"></td>
					<td>商品名称：</td>
					<td style="width:85%;">${tgoods.goodsName }</td>
				</tr>
				<tr>
					<td style="color:red;"></td>
					<td>商品类型：</td>
					<td>
						<c:forEach items="${goodsTypes }" var="goodsType">
							<span>${goodsType.goodsTypeName }</span>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td style="color:red;"></td>
					<td style="">特色：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						<c:forEach var="feature" items="${features }" varStatus="status">
							<c:if test="${status.index %4 ==0 }">
								<p style="background:#0BB5D9;color:#ffffff;">${feature.featureName }</p>
							</c:if>
							<c:if test="${status.index %4 ==1 }">
								<p style="background:#49BF85;color:#ffffff;">${feature.featureName }</p>
							</c:if>
							<c:if test="${status.index %4 ==2 }">
								<p style="background:#E36B77;color:#ffffff;">${feature.featureName }</p>
							</c:if>
							<c:if test="${status.index %4 ==3 }">
								<p style="background:#F8B95A;color:#ffffff;">${feature.featureName }</p>
							</c:if>
						</c:forEach>
					</td>
				</tr>
				</c:if>
				<tr>
					<td></td>
					<td>商品简介：</td>
					<td>
						${tgoods.introduction }
					</td>
				</tr>
				<tr>
					<td style="color:red;"></td>
					<td colspan="3">
						图片展示：
					</td>
				</tr>
   				<tr>
   					<td  colspan="2"></td>
					<td id="Imgs">
						<c:forEach items="${paths }" var="path">
							<c:if test="${path!='' }">
								<div class="brandImg">
								    <img src="<%=Variables.goodsPhotoURL %>${shopId}/${path }" width="229" height="179"/> 
								</div>
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td style="color:red;"></td>
					<td>记录查看:</td>
					<td colspan="2">
						<a href="/hitPraise.jhtml?goodsId=${tgoods.goodsId }" title="点赞">点赞<span style="color:#69CDCD;">(${size3 })</span></a>
						<a href="/hitFavorite.jhtml?goodsId=${tgoods.goodsId }" title="收藏">收藏<span style="color:#69CDCD;">(${size })</span></a>
						<a href="/hitCount.jhtml?goodsId=${tgoods.goodsId }" title="浏览">浏览<span style="color:#69CDCD;">(${size2 })</span></a>
					</td>
				</tr>
			</table>
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
					//alert("请选择商品类型");
					easyDialog.open({
		                container: {
		                    header: '提示',
		                    content: '请选择商品类型'
		                },
		                overlay: false
		            });
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
</body>
</html>
