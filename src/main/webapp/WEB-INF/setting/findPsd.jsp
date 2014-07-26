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
			    float:left;
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
				border:1px solid #CCCCCC;
				background:#CCCCCC;
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
  		$("#findPsdForm").validate({
  			rules:{
  				telphoneNum:{
  					required: true,
					rangelength:[11,11],
					remote:"/validatePhoneNumber.jhtml"
  				},
	  			numberCode:{
	  				required: true
	  			},
	  			filename:{
	  				required: true
	  			}
  			},
  			messages:{
  				telphoneNum:{
  					required:"手机号必填",
					rangelength:"手机号码不足11位",
					remote:"验证码不匹配"
  				},
				numberCode:{
					required:"验证码必填"
				},
				filename:{
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
  <body>
  	<jsp:include page="../include/header.jsp"/>
	    <div class="stable" style="width:1000px; margin:0px auto; background-color:#fff;">
	    	<form id="findPsdForm" method="post" action="">
		    	<div>
		    		<div style="padding-top:30px;">
			        	<div id="titl">
						    <div id="titl_name">
							    <span>找回密码</span>&nbsp;&nbsp;
							    <span style="color:#AEAEAE; text-transform:uppercase;">find back password</span>
							</div>
							<div style="width:700px;" class="btn_div"><input style="margin:0px 20px;margin-left:100px;" type="submit" value="确定" /> <input type="button" value="取消" /></div>
						</div>
			            <img src="/images/line.png" />
			        </div>
		    	</div>
		    	<p><font color="red" style="margin-left:150px;">*</font>营业执照</p>
		    	<div>
		    		<div class="brandImg" style="margin-left:200px;">
						<span>
							<a onclick="file0.click()" href="javascript:return false;">点击上传图片</a>
						</span>
						<img style="width:229px;height:179px" src="" name="img" id="licenseImg"/>
					</div>
					<input type="file" style="display:none" id="file0" name="file0" onchange="filename.value=this.value;loadImgFast(this,0)">
					<input type="hidden" id="filename" name="filename"/>
					<span></span>
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
