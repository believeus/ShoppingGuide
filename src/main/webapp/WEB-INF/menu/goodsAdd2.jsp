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
<meta http-equiv="X-UA-Compatible" content="IE=8"/>
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
		.brandImg{
			float:left;
			border: 1px solid;
			text-align: center;
			width: 229px;
			margin-right: 20px;
			margin-bottom: 20px;
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
	$(function(){
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
			
			//alert($(".main_table3 .brandImg").size());
			if($(".main_table3 .brandImg").size() > 8){
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
		
		$("input[type='submit']").click(function(){
			var dis = $("#goodsDetail").val();
			var imgs = $("[id^='filename']");
			imgs.each(function(){
				if($(this).val() != "" || dis != ""){
					$("#main_form").submit();
					return false;
				}else{
					alert("请填写商品介绍或者选择商品图片");
					return  false;
				}
			});
		});
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
				<a href="/goodsAdd2.jhtml?shopId=${shopId }" title="商品添加">商品添加</a>
			</p>
			<table class="main_table1" style="">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">商品添加</p></td>
					<td style="width:65%;"><div style=""><a href="/goodsAdd.jhtml?shopId=${shopId }" style="font-size:16px;color:#69CDCD;">详细发布商品</a></div></td>
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
			
		
			<table class="main_table2" style="">
				<tr>
					<td></td>
					<td>商品简介：</td>
					<td>
						<textarea name="goodsDetailTextArea"  onchange="goodsDetail.value=this.value" onfocus="if(this.value == '请输入商品简介') this.value = ''" onblur="if(this.value =='') this.value = '请输入商品简介'">请输入商品简介</textarea>
					</td>
				</tr>
			</table>


			<div style="width:1000px;text-align:center;margin:0 auto;">
				<img src="/images/line.png">
			</div>
		<form id="main_form" method="post" action="/addSimpleGoods.jhtml" encType="multipart/form-data">
			<input type="hidden" name="shopId" value="${shopId}">
			<input type="hidden" name="goodsDetail" id="goodsDetail" >
			<table class="main_table3">
   				<tr>
					<td style="width:1%;"><div class="main_table3_div1" ></div></td>
					<td style="width:90%;" colspan="2"><div style="float:left;color:red;"></div>上传图片：<span style="font-size:13px;">(最多可上传9张图片)</span></td>
				</tr>
   				<tr>
					<td id="Imgs" colspan="3">
						<input type="hidden" id="moren" name="moren">
						<div id="add_img" class="add_img" title="添加店铺图片">+</div>
						<div class="brandImg">
							 <div id="preview_wrapper1" style="display:inline-block;width:227px;height:179px; background-color:#CCC; margin-top: 1px;">    
							        <div id="preview_fake1" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)">  
							            <img id="preview1"  style="width:227px;height:179px;" onload="onPreviewLoad(this,227,179)" src=""/>
							        	<span class="middle-money" value="0">设为默认</span>
							        </div>    
							    </div>    
							    <div style="text-align:left;">    
							    <input id="goodsImg1" type="file" name="goodsImg1" style="width: 70px;" onchange="filename1.value=this.value;onUploadImgChange(this,227,179,'preview1','preview_fake1','preview_size_fake1');"/>  
							    <input type="hidden" id="filename1" name="filename1">
							    </div>    
							    <img id="preview_size_fake1" style=" filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);visibility:hidden;width:0;height:0;"/> 
							<div style="text-align: right; border-top: 1px dashed #E4E4E4; height: 24px; line-height: 24px; margin-right: 3px;"><a onclick="delete_pic(this)" href="javascript:void(0);">删除</a></div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>

		
		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
