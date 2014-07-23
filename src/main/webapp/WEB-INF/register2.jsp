	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
.s_main {
	width: 1000px;
	height: auto;
	overflow: hidden;
	margin: 20px auto;
	background: #FFFFFF;
}

.stable {
	width: 800px;
	height: auto;
	overflow: hidden;
	margin-left: auto;
	margin-right: auto;
}

.stable p {
	line-height: 60px;
	padding-left: 40px;
	margin: 0;
}

.stable p:hover {
	background: #EAFCFC;
}

.btn {
	width: 140px;
	height: 30px;
	border: 1px solid #69CDCD;
	background: #69CDCD;
	color: #FFFFFF;
	border-radius: 4px;
	cursor: pointer;
}

.btn_div {
	width: 800px;
	height: auto;
	overflow: hidden;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	margin-bottom: 5px;
}

.btn_div input {
	width: 70px;
	height: 30px;
	border: 1px solid #CCCCCC;
	background: #CCCCCC;
	color: #FFFFFF;
	border-radius: 4px;
	cursor: pointer;
}
.shopShow{
	padding-left: 40px; 
	margin-top: 20px; 
	height: auto; 
	overflow: hidden;
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
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.validate.js"></script>
<script type="text/javascript" src="/js/messages_cn.js"></script>
<script type="text/javascript" src="/js/validate.expand.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2qkpDitMlFIilEPKy62fiWDe"></script>
</head>
<script type="text/javascript">
	$(function(){
		
		
		// 百度地图API功能
		function G(id) {
		    return document.getElementById(id);
		}

		var map = new BMap.Map("l-map");
		map.centerAndZoom("北京",12);                   // 初始化地图,设置城市和地图级别。
		map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
		
		var gc = new BMap.Geocoder();    
		map.addEventListener("click", function(e){        
		    var pt = e.point;
		    gc.getLocation(pt, function(rs){
		        var addComp = rs.addressComponents;
		        $("#suggestId").val(addComp.province + ""+ addComp.city + "" + addComp.district + "" + addComp.street + "" + addComp.streetNumber);
		        //alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
		    });        
		});
		
		var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		    {"input" : "suggestId"
		    ,"location" : map
		});

		ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
		var str = "";
		    var _value = e.fromitem.value;
		    var value = "";
		    if (e.fromitem.index > -1) {
		        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		    }    
		    str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		    
		    value = "";
		    if (e.toitem.index > -1) {
		        _value = e.toitem.value;
		        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		    }    
		    str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		    G("searchResultPanel").innerHTML = str;
		});

		var myValue;
		ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
		var _value = e.item.value;
		    myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		    G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
		    
		    setPlace();
		});

		function setPlace(){
		    map.clearOverlays();    //清除地图上所有覆盖物
		    function myFun(){
		        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
		        map.centerAndZoom(pp, 18);
		        map.addOverlay(new BMap.Marker(pp));    //添加标注
		    }
		    var local = new BMap.LocalSearch(map, { //智能搜索
		      onSearchComplete: myFun
		    });
		    local.search(myValue);
		}
	});
	
	$().ready(function() {
		
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
		
		$("#registerForm").validate({
			rules : {
				shopName : {
					required : true
				},
				goodsTypeId : {
					required : true
				},
				address:{
					required : true
				},
				businessLicenseNo :{
					required : true
				},
				shopOwnerName:{
					required : true
				},
				marketId:{
					required : true
				}
			},
			messages : {
				shopName : {
					required : "店铺名称必填",
				},
				address:{
					required : "请输入您的详细地址"
				},
				businessLicenseNo :{
					required : "请输入您的价格区间"
				},
				shopOwnerName:{
					required : "店主姓名必填"
				},
				marketId:{
					required:"商场必填"
				},
				goodsTypeId:{
					required:"商品类型必填"
				}
			}
		});
	});
</script>
<body bgcolor="#E7E8EB">
	<!-- 引用尾部页面 -->
	<jsp:include page="include/header.jsp" flush="true" />
	<div class="s_main">
		<p style="font-size: 22px; margin: 10px 0px; padding-left: 35px;">
			<font color="#69CDCD">商户注册</font> <font color="#AEAEAE">USER
				REGEDIT</font>
		</p>
		<p style="margin:10px 0;">
			<img src="images/r2.jpg" width="1000">
		</p>
		<div
			style="width:600px;height:30px;line-height:30px;margin-left:auto;margin-right:auto;">
			<span><font color="red">*</font>为必填选项</span> <span
				style="float:right;">已有帐号!<a href="/login.jhtml"
				style="color:red;">直接登录</a></span>
		</div>
		<form id="registerForm" action="/dealRegister2.jhtml" method="post" autocomplete="off" enctype="multipart/form-data" >
			<input type="hidden" name="shopuserId" value="${sessionUser.shopUserId}"/>
			<div class="stable">
				<p>
					<font color="red">*</font> <span style="font-weight:normal;">店铺名称:</span>
					<input id="shopName" type="text" name="shopName" style="width:345px;height:35px;line-height:35px;">
				</p>
				<p>
					<font color="red">*</font> <span style="font-weight:normal;">店主姓名:</span>
					<input id="shopOwnerName" type="text" name="shopOwnerName" style="width:345px;height:35px;line-height:35px;">
				</p>
				<p>
					<font color="red">*</font> <span style="font-weight:normal;">所在商场:</span>
					<select name="marketId" style="width:345px;height:35px;line-height:35px;">
						<option></option>
						<c:forEach items="${marketList}" var="market">
							<option value="${market.marketId}">${market.marketName}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<div id="r-result" style="height:30px;width:auto;padding-left:40px;margin-bottom:20px;">
						<font color="red">*</font>
						<span style="font-weight:normal;">店铺地址:</span>
						<input type="text" id="suggestId" name="address" size="20" value="百度" style="width:345px;height:35px;line-height:35px;"/>
					</div>
					<div id="searchResultPanel" style="display: none;width:150px;height:auto;"></div>
					<div id="l-map" style="width:auto;height:350px;margin-left:40px;"></div>
				</p>
				<p>
					<font color="red">*</font> <span style="font-weight:normal;">经营范围：</span>
					
					<select id="goodsTypeId" name="goodsTypeId">
						<option ></option>
						<c:forEach var="gli" items="${gList}">
							<option value="${gli.goodsTypeId}">${gli.goodsTypeName}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<font color="red">*</font> <span style="font-weight:normal;">价格区间：</span>
					<input id="businessLicenseNo" type="text" name="businessLicenseNo"
						style="width:345px;height:35px;line-height:35px;">
				</p>
				<div style="padding-left:40px;">
					<font color="red">*</font><span style="font-weight:normal;">营业执照：</span><br> 
					<div class="brandImg" style="margin-top:20px;">
						<span>
							<a onclick="file0.click()" href="javascript:return false;">点击上传图片</a>
						</span>
						<img id="businessLicensePhoto" style="width:229px;height:179px" src="" name="businessLicensePhoto"/>
					</div>
					<input type="file" style="display:none" id="file0" name="shopLicenseImg" onchange="filename0.value=this.value;loadImgFast(this,0)">
					<input type="hidden" id="filename0">
				</div>
				<div class="shopShow" style="">
					<font color="red">*</font><span style="font-weight:normal;">店铺展示：</span><input id="add_img" type="button" value="添加展示图片" onClick=""/><br> 
					<div class="brandImg" style="margin-top:20px;float:left;">
						<span>
							<a onclick="file1.click()" href="javascript:return false;">点击上传图片</a>
						</span>
						<img id="shopPhotoURL" style="width:229px;height:179px" src="" name="shopPhotoURL"/>
					</div>
					<input type="file" style="display:none" id="file1" name="file1" onchange="filename1.value=this.value;loadImgFast(this,1)">
					<input type="hidden" id="filename1" name="filename1">
				</div>
				<div class="btn_div" style="margin-top:20px;">
					<input type="button" value="上一步" onClick="javascript:window.location.href='/register.jhtml'" style="background:#69CDCD;border :1px solid #69CDCD;"> 
						<input type="submit" value="下一步">
				</div>
			</div>
		</form>
	</div>

	<!-- 引用尾部页面 -->
	<jsp:include page="include/footer.jsp" flush="true" />
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
