<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="X-UA-Compatible" content="IE=8"/>
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/css/goodsAdd.css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" src="js/jquery.js"></script>
	<style type="text/css">
		body {
			font-family: Microsoft YaHei !important;	
			font-size:14px;
			margin:0px;
		}
		#titl_name {
			float:left;
			margin-left:30px;
			font-size:22px;
			color:#69cdcd;
		}
		.butt01 {
			background-color:#5AB5B6; 
			height:34px;
			width:70px; 
			border-radius:3px; 
			float:right;
			margin-right:40px;
		}
		.butt01 p {
			color:#FFF; 
			font-weight:bold; 
			font-size:15px; 
			margin:auto;
			text-align:center;
			cursor:pointer;
		}
		#titl {
			height:34px; 
			width:1000px; 
			margin-bottom:10px;
		}
		.stable{
			width:800px;
			height:auto;
			overflow:hidden;
			margin-left:auto;
			margin-right:auto;
		}
		.stable p{
			line-height:60px;
			padding-left:40px;
			margin:0;
		}
		.stable p:hover{
			background:#EAFCFC;
		}
		.btn{
			width:140px;
			height:30px;
			border:1px solid #69CDCD;
			background:#69CDCD;
			color:#FFFFFF;
			border-radius:4px;
			cursor:pointer;
		}
		input {
			width:340px; 
			height:28px; 
			padding: 0px 4px;;
		}
		</style>
		<style type="text/css">
			
			.brandImg{
				border-color: #B8B8B8 #DCDCDC #DCDCDC #B8B8B8;
			    border-radius: 2px 2px 2px 2px;
			    border-style: solid;
			    border-width: 1px;
			   /* background-color: #666666; */
			    width:227px;
			    height:auto;
			    position:relative;
			    float:left;
			    margin-right:15px;
			    margin-left:200px;
			}
			
			.btn_div{
				width:800px;
				height:auto;
				overflow:hidden;
				margin-left:auto;
				margin-right:auto;
				text-align:center;
				margin-bottom:5px;
			}
			.btn_div input{
				width:70px;
				height:30px;
				border:1px solid #69CDCD;
				background:#69CDCD;
				color:#FFFFFF;
				border-radius:4px;
				cursor:pointer;
			}
			.deleteProductImage:hover{
				color:#C9033B !important;
			}
		</style>
		<script type="text/javascript" src="/js/jquery.js"></script>
  		<script type="text/javascript" src="/js/jquery.validate.js"></script>
  </head>
  <script type="text/javascript">
  	$(function(){
  		
  		function timeCountDown(obj,wait){
  			if(wait == 0){
  				$(obj).removeAttr("disabled");
  				$(obj).val("免费获取验证码");
  				$(obj).css("background","#69CDCD");
  				wait=60;
  			}else{
  				$(obj).attr("disabled","false");
  				$(obj).val("("+wait+"秒后重新获取短信信息)");
  				$(obj).css("background","#E7E8EB");
  				wait--;
  				setTimeout(function(){
  					timeCountDown(obj,wait);
  				},1000)
  			}
  		}
  		
  		$("#validCode").click(function(){
			if($("#findPsdForm").validate().element($("#telphoneNum"))){
  			  	timeCountDown(this,60);
  			 var phoneNumber=$("#telphoneNum").val();
  			  $("#telphoneNum").next().text("");
  			  if(phoneNumber==""){
  				  $("#telphoneNum").next().text("手机号必填!").css("color","red");
  			  }else if(!(/^1[358]\d{9}$/.test(phoneNumber))){
  				  $("#telphoneNum").next().text("手机号格式不正确!").css("color","red");
  			  }else{
  				  $("#validCode").attr('disabled',"false");
  				  //将手机号码发送给webserivce,获取手机验证码
  				  $.post("/generateValidCode.jhtml", {phoneNumber:phoneNumber},function(data){
  					 if(/[0-9]{4}/.test(data.returnCode)){
  						  $("#validCode").attr('disabled',"true");
  					  }else{
  						 $("#validCode").attr('disabled',"false");
  						  $("#telphoneNum").next().text("获取验证码失败,请重新获取").css("color","red");
  					  }
  				  },"json");
  			  }
			}
  		});
  		
  		$("#findPsdForm").validate({
  			rules:{
  				telphoneNum:{
  					required: true,
					rangelength:[11,11]
  				},
	  			numberCode:{
	  				required: true,
	  				remote:"/validateNumberCode.jhtml"
	  			},
	  			shopLicenseImg:{
	  				required: true
	  			}
  			},
  			messages:{
  				telphoneNum:{
  					required:"手机号必填",
					rangelength:"手机号码不足11位",
  				},
				numberCode:{
					required:"验证码必填",
					remote:"验证码不匹配"
				},
				shopLicenseImg:{
					required:"图片必须上传"
				},
  			},
			errorPlacement: function(error, element) {  //验证消息放置的地方
	            error.appendTo(element.next().css("color","red"));   
		    },   
		    highlight: function(element, errorClass) {  //针对验证的表单设置高亮   
		            $(element).addClass(errorClass);   
		    }
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
	
  <body>
  	<jsp:include page="/WEB-INF/include/header.jsp"/>
	    <div class="stable" style="width:1000px; margin:0px auto; background-color:#fff;">
	    	<p style="margin:0 auto;width:1000px;">所在位置：
				<a title="菜单" href="/menu.jhtml">菜单</a> &gt;
   				<a title="找回密码" href="/findPsd.jhtml">找回密码</a>
			</p>
	    	<form id="findPsdForm" method="post" action="/findPsdLogic.jhtml" enctype="multipart/form-data">
		    	<div>
		    		<div style="padding-top:30px;">
			        	<div id="titl">
						    <div id="titl_name">
							    <span>找回密码</span>&nbsp;&nbsp;
							    <span style="color:#AEAEAE; text-transform:uppercase;">find back password</span>
							</div>
							<div style="width:500px;float:right;" class="btn_div">
								<input style="margin:0px 20px;margin-left:100px;" type="submit" value="确定" /> 
								<input style="width:70px;height:30px;" type="button" value="取消" onClick="javascript:window.history.back();"/>
							</div>
						</div>
			            <img src="/images/line.png" />
			        </div>
		    	</div>
		    	<p><font color="red" style="margin-left:150px;">*</font>营业执照</p>
		    	<div class="brandImg">
					<div id="preview_wrapper1" style="display:inline-block;width:227px;height:179px; background-color:#CCC; margin-top: 1px;">    
				        <div id="preview_fake1" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)">  
				            <img id="preview1"  style="width:227px;height:179px;" onload="onPreviewLoad(this,227,179)" src=""/>
				        </div>    
				    </div>    
				    <div style="text-align:center;">    
					    <input id="shopLicenseImg" type="file" name="shopLicenseImg" style="width: 227px;" onchange="filename.value=this.value;onUploadImgChange(this,227,179,'preview1','preview_fake1','preview_size_fake1');"/>  
					    <input type="hidden" id="filename" name="filename"/>
						<label class="error" for="shopLicenseImg" style="color:red;"></label>
				    </div>    
				    <img id="preview_size_fake1" style=" filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);visibility:hidden;width:0;height:0;"/> 
				</div>
				<p style="clear:both;">
					<font color="red" style="margin-left:150px;">*&nbsp;</font>
	    			<span style="font-weight:bold;">手机号码：</span>
	    			<input type="text" id="telphoneNum" name="telphoneNum" placeholder="请输入手机号" style="width:345px;height:35px;line-height:35px;" 
	    				   onkeyup="this.value=this.value.replace(/[^0-9-]+/,'')">
	   				<span></span>
				</p>
				<p>
					<font color="red" style="margin-left:150px;">*&nbsp;</font>
	    			<span style="font-weight:bold;">短信验证：</span>
	    			<input type="text" id="numberCode" name="numberCode" placeholder="请输入验证码" style="width:345px;height:35px;line-height:35px;">
	    			<span></span>
	    			<input class="btn" id="validCode" type="button" value="免费获取验证码">
	    			<span></span>
				</p>
	   		</form>
		</div>
		
	<jsp:include page="../include/footer.jsp"/>
  </body>
</html>
