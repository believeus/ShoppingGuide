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

<title>编辑店铺信息</title>

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
		.main_table2 tr {
		    line-height: 20px;
		    vertical-align: top;
		}
		.main_table2 tr:hover{
			background:#EAFCFC;
		}
		.main_table2 input[type='text'] {
		    height: 30px;
		    line-height: 30px;
		    width: 400px;
		}
		.main_table2 tr td {
		    padding: 20px 0;
		}
		
		<!--  chqx  -->
		#suib {
			padding:0px 45px;	
			margin: 0px auto;
		}
		#suib tr {
			height:65px;
		}
		#suib tr:hover {
			background:#EAFCFC;
		}
		#suib td:first-of-type {
			width:155px;
		}
		#suib td:nth-child(2) {
			width:345px;	
		}
		#suib td:nth-child(3) {
			width:30px;	
		}
		#suib td:last-of-type {
			width:355px;	
		}
		#suib input {
			width:340px; 
			height:28px; 
			padding: 0px 4px;;
		}
		
		#shopSpec{
			padding-top:5px;
		}
		#shopSpec p{
			font-size:13px;
			border-radius:.2em;
			margin-right:15px;
			width:auto;
			border:1px solid gray;
			height:20px;
			line-height:20px;
			float:left;
			display:block;
			padding:3px 15px;
			cursor:pointer;
		}
		.inputClass{
			background-color:#69CDCD;
			border-radius:.2em;
			color:white;
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
<script type="text/javascript">
	$().ready(function(){
		var sels = $("#main_table2_td2 select");
		sels.each(function(){
			$(this).change(function(){
				var html = "<select name='' style='width:400px;text-align:center;margin-bottom:10px;'><option value=''>请选择..</option><option value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select>";
				alert(sels.length+"=sels.length");
				if(sels.length >5){
					alert("最多5个");
				}else{
					$(this).parent().append(html);
				}
			});
		});
		
		$("#add_img").click(function(){
			var a = $(".shopShow .brandImg").size() + 1;
			var html = "<div class='brandImg' style='margin-top:20px;float:left;'><span><a onclick='file"+a+".click()' href='javascript:return false;'>点击上传图片</a></span><img id='shopPhotoURL' style='width:229px;height:179px' src='' name='shopPhotoURL'/></div><input type='file' style='display:none' id='file"+a+"' name='file"+a+"' onchange='filename"+a+".value=this.value;loadImgFast(this,"+a+")'><input type='hidden' id='filename"+a+"' name='filename"+a+"'>";
			//alert($(".shopShow .brandImg").size());
			if($(".shopShow .brandImg").size() > 8){
				alert("最多9张图片");
			}else{
				$(".shopShow").append(html);
			}
		});

		$("#shopName").blur(function(){
			var shopName=$("#shopName").val();
			$.ajax({
				type : "post",
				url : "/editShopName.jhtml",
				dataType : "json",
				data :{"shopName":shopName} ,
				success : function(data) {
					if(data.message == "error"){
						$("#shopNameImg").css("display","block")[0].src="images/chacha.png";
						$("#shopNameMsg").css("display","block");
						$("#shopNameMsg2").css("display","none");
					}else if(data.message == "success"){
						$("#shopNameImg").css("display","block")[0].src="images/good.gif";
						$("#shopNameMsg").css("display","none");
						$("#shopNameMsg2").css("display","none");
					}else{
						$("#shopNameImg").css("display","none");
						$("#shopNameMsg").css("display","none");
						$("#shopNameMsg2").css("display","block");
					}
				}
			});
		});	
		
		$("#phoneNum").blur(function(){
			var phoneNum=$("#phoneNum").val();
			$.ajax({
				type : "post",
				url : "/phoneNum.jhtml",
				dataType : "json",
				data :{"phoneNum":phoneNum} ,
				success : function(data) {
					if(data.message == "success"){
						$("#phoneNumMsg").css("display","none");
						$("#phoneNumImg").css("display","block")[0].src="images/good2.gif";
					}else if(data.message == "error"){
						$("#phoneNumMsg").css("display","block");
						$("#phoneNumImg").css("display","block")[0].src="images/chacha.png";
					}else{
						$("#phoneNumMsg").css("display","none");
						$("#phoneNumImg").css("display","none");
					}
				}
			});
		});
		
		$("#qqNum").blur(function(){
			var qqNum=$("#qqNum").val();
			$.ajax({
				type : "post",
				url : "/qqNum.jhtml",
				dataType : "json",
				data :{"qqNum":qqNum} ,
				success : function(data) {
					if(data.message == "success"){
						$("#qqNumMsg").css("display","none");
						$("#qqNumImg").css("display","block")[0].src="images/good3.gif";
					}else{
						$("#qqNumMsg").css("display","block");
						$("#qqNumImg").css("display","block")[0].src="images/chacha.png";
					}
				}
			});
		});
		
		$("#businessRange").change(function(){
			if($("#businessTd select").length < 5){
				var buss=$("#businessRange").clone(true);
				$(this).unbind();
				$("#businessRange").attr("id","Range");
				$("#businessTd").append(buss);
			}
		});

	});	
		
</script>

</head>
<body>
	
		 <!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
		
		<div id="main" style="">
			<table class="main_table1">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">店铺资料</p></td>
					<td style="width:56%;"></td>
					<td style="width:9%;"><input type="button" value="保存" style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
					<td style="width:8%;"><input type="button" value="返回" onClick="javascript:window.history.back();" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
					<td style="width:8%;"><input type="button" value="修改用户密码" onClick="javascript:window.location.href='/updatePsd.jhtml'" style="border:none;width:120px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
				</tr>
			</table>			
			<hr style="width:85%;border:1px solid #E8E8E8;" />
			
			<table id="suib" style="margin:0px auto;">
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>店铺名称：</b></td>
		                <td>
		                    <input id="shopName" type="text" name="shopName">
		                </td>
		                <td><img id="shopNameImg" style="display:none;" src="images/chacha.png" /></td>
		                <td>
		                    <div id="shopNameMsg" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">输入格式不正确，请重新输入！</p>
		                    </div>
		                    <div id="shopNameMsg2" style="width:351px; height:31px; margin-bottom:14px; background-image:url(images/bg.png);background-position:-101px 407px;">
		                        <p style="line-height:28px; color:black; margin-left:20px;">名称长度为1-10个汉字，不能含有特殊字符!</p>
		                    </div>
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>详细位置：</b></td>
		                <td>
		                    <input id="location" name="location" type="text" />
		                </td>
		                <td></td>
		                <td></td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>经营范围：</b></td>
		                <td id="businessTd">
		                    <select id="businessRange" name="businessRange" style="width:340px;text-align:center;margin-bottom:10px;">
								<option value=""  selected="selected">请选择..</option>
								<option value="1">1======</option>
								<option value="2">2======</option>
								<option value="3">3=======</option>
								<option value="4">4==========</option>
								<option value="5">5=====</option>
							</select>
		                </td>
		                <td></td>
		                <td></td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">&nbsp;&nbsp;</span>价格区间：</b></td>
		                <td>
		                    <input id="priceRange" type="text" name="priceRange" />
		                </td>
		                <td></td>
		                <td></td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>联系电话：</b></td>
		                <td>
		                    <input id="phoneNum" type="text" name="phoneNum">
		                </td>
		                <td><img id="phoneNumImg" style="display:none;" src="images/chacha.png" /></td>
		                <td>
		                	<div id="phoneNumMsg" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">输入手机号不正确，请重新输入！</p>
		                    </div>
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>QQ号码：</b></td>
		                <td>
		                    <input onkeyup="value=this.value.replace(/\D+/g,'')" id="qqNum" type="text" name="qqNum" />
		                </td>
		                <td><img id="qqNumImg" style="display:none;" src="images/chacha.png" /></td>
		                <td>
		                	<div id="qqNumMsg" style="display:none;width:351px; height:28px; margin-bottom:14px; background-image:url(images/warning.png)">
		                        <p style="line-height:28px; color:red; margin-left:20px;">输入格式不正确，请重新输入！</p>
		                    </div>
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>店铺特色：</b></td>
		                <td colspan="2" id="shopSpec">
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
		                <td></td>
		              </tr>
		              <tr>
		              	<td><font color="red">*</font><span style="font-weight:normal;">营业执照：</span></td>
		              	<td>
		              		<div style="padding-left:40px;">
								<div class="brandImg" style="margin-top:20px;">
									<span>
										<a onclick="file0.click()" href="javascript:return false;">点击上传图片</a>
									</span>
									<img id="businessLicensePhoto" style="width:229px;height:179px" src="" name="businessLicensePhoto"/>
								</div>
								<input type="file" style="display:none" id="file0" name="lienseImg" onchange="filename0.value=this.value;loadImgFast(this,0)">
								<input type="hidden" id="filename0" name="filename0">
							</div>
		              	</td>
		              	<td></td>
		              	<td></td>
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
