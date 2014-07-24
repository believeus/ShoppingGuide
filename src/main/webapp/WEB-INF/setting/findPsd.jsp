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
			height:34px; 
			border-radius:3px; 
			float:right;
			margin-right:40px;
		}
		.butt01 p {
			line-height:34px; 
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
		table {
			padding:0px 45px;	
		}
		table tr {
			height:65px;
		}
		table td:first-of-type {
			width:155px;
			text-align:right;
		}
		table td:nth-child(2) {
			width:345px;	
		}
		table td:nth-child(3) {
			width:45px;	
			padding-left:10px;
		}
		table td:last-of-type {
			width:350px;	
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
			
			.deleteProductImage:hover{
				color:#C9033B !important;
			}
		</style>
  </head>
  <script type="text/javascript">
  	$(function(){
  		
  		$("#license").blur(function(){
  			var license=$("#license").val();
  			$.ajax({
  				type : "post",
				url : "/licenseNum.jhtml",
				dataType : "json",
				data :{"license":license} ,
				success : function(data) {
					if(data.message == "error"){
						$("#licenseMsg")[0].innerHTML="营业执照格式不正确！";
						$("#licenseMsg").css("color","red");
					}else if(data.message == "success"){
						$("#licenseMsg")[0].innerHTML="营业执照格式正确！";
						$("#licenseMsg").css("color","black");
					}else{
						$("#licenseMsg")[0].innerHTML="注明：必须上传营业执照或者填写执照号";
						$("#licenseMsg").css("color","black");
					}
				}
  			});
  		});
  		
  		$("#userNum").blur(function(){
  			var userNum=$("#userNum").val();
  			$.ajax({
  				type : "post",
				url : "/userNum.jhtml",
				dataType : "json",
				data :{"userNum":userNum} ,
				success : function(data) {
					if(data.message == "error"){
						$("#userNumImg").css("display","block");
						$("#userNumMsg").css("display","block");
					}else if(data.message == "success"){
						$("#userNumImg").css("display","block")[0].src="images/good.gif";
						$("#userNumMsg").css("display","none");
					}else{
						$("#userNumImg").css("display","none");
						$("#userNumMsg").css("display","none");
					}
				}
  			});
  		});
  		
  		$("#telphone").blur(function(){
  			var userNum=$("#telphone").val();
  			$.ajax({
  				type : "post",
				url : "/userNum.jhtml",
				dataType : "json",
				data :{"userNum":userNum} ,
				success : function(data) {
					if(data.message == "error"){
						$("#telImg").css("display","block");
						$("#telMsg").css("display","block");
					}else if(data.message == "success"){
						$("#telImg").css("display","block")[0].src="images/good1.gif";
						$("#telMsg").css("display","none");
					}else{
						$("#telImg").css("display","none");
						$("#telMsg").css("display","none");
					}
				}
  			});
  		});
  		
  		$("#submit").click(function(){
  			document.form1.submit();
  		});
  		
  		
  	});
  </script>
  <body>
  	<jsp:include page="../include/header.jsp"/>
	    <div style="width:1000px; margin:0px auto; background-color:#fff;">
	    	<div style="padding-top:30px;">
	        	<div id="titl">
	                <div id="titl_name">
	                    <span>找回密码</span>&nbsp;&nbsp;
	                    <span style="color:#AEAEAE; text-transform:uppercase;">find back password</span>
	                </div>
	                <div id="submit" class="butt01"><p>确认</p></div>
	                <div class="butt01" style="margin-right:20px;"><p>取消</p></div>
	            </div>
	            <img src="/images/line.png" />
	        </div>
	        <div style="clear:right;">
	        	<table class="main_table3" style="">
					<tr>
						<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
						<td style="" colspan="2"><div style="float:left;color:red;">*</div>营业执照:</td>
					</tr>
	   				<tr style="">
						<td colspan="2" style=""></td>
						<td>
							<div class="brandImg">
								<span>
									<a onclick="file0.click()" href="javascript:return false;">点击上传图片</a>
								</span>
								<img style="width:229px;height:179px" src="" name="img"/>
							</div>
							<input type="file" style="display:none" id="file0" name="file0" onchange="filename0.value=this.value;loadImgFast(this,0)">
							<input type="hidden" id="filename0" name="filename0">
						</td>
					</tr>
				</table>
	            <table>
	              <tr>
	                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>手机号码：</b></td>
	                <td>
	                    <input type="text" placeholder="请输入手机号码" />
	                </td>
	                <td><img src="images/good.gif" /></td>
	                <td></td>
	              </tr>
	              <tr>
	                <td><b><span style="color:red;">*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>验证码：</b></td>
	                <td>
	                    <input type="password" placeholder="请输入验证码" />
	                </td>
	                <td></td>
	                <td></td>
	              </tr>
	            </table>

	        </div>
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
