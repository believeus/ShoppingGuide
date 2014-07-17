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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
</style>
</head>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.validate.js"></script>
<script type="text/javascript" src="/js/messages_cn.js"></script>
<script type="text/javascript" src="/js/validate.expand.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2qkpDitMlFIilEPKy62fiWDe"></script>
<script type="text/javascript">
	$(function(){
		// 百度地图API功能
		var map = new BMap.Map("allmap");
		var gc = new BMap.Geocoder();    
		map.centerAndZoom("重庆",12);   // 初始化地图,设置城市和地图级别。
		map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用 
		
		var contextMenu = new BMap.ContextMenu();
		var txtMenuItem = [
		  {
		   text:'放大',
		   callback:function(){map.zoomIn()}
		  },
		  {
		   text:'缩小',
		   callback:function(){map.zoomOut()}
		  },
		  {
		   text:'放置到最大级',
		   callback:function(){map.setZoom(18)}
		  },
		  {
		   text:'查看全国',
		   callback:function(){map.setZoom(4)}
		  },
		  {
		   text:'在此添加标注',
		   callback:function(p){
		    var marker = new BMap.Marker(p), px = map.pointToPixel(p);
		    map.addOverlay(marker);
		   }
		  }
		 ];

		 for(var i=0; i < txtMenuItem.length; i++){
		  contextMenu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
		  if(i==1 || i==3) {
		   contextMenu.addSeparator();
		  }
		 }
		 map.addContextMenu(contextMenu);
		
		map.addEventListener("click", function(e){ 
		    var pt = e.point;
		    gc.getLocation(pt, function(rs){
		        var addComp = rs.addressComponents;
		        alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
		    });        
		});
	});
	
	$().ready(function() {
		$("#registerForm").validate({
			rules : {
				shopName : {
					required : true,
					rangelength : [ 1, 10 ]
				},
				goodsTypeName : {
					goodsTypeName : true
				},
				address:{
					required : true
				},
				businessLicenseNo :{
					required : true
				}
			},
			messages : {
				shopName : {
					required : "店铺名称必填",
					rangelength : "名称长度为1-10个汉字，不能含有特殊字符"
				},
				address:{
					required : "请输入您的详细地址"
				},
				businessLicenseNo :{
					required : "请输入您的价格区间"
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
		<form id="registerForm" action="/regTwoSuccess.jhtml" method="post" autocomplete="off">
			<div class="stable">
				<p>
					<font color="red">*</font> <span style="font-weight:normal;">店铺名称：</span>
					<input id="shopName" type="text" name="shopName"
						style="width:345px;height:35px;line-height:35px;">
				</p>
				<p>
					<font color="red">*</font> <span style="font-weight:normal;">详细位置：</span>
					<input id="address" type="password" name="address" style="width:345px;height:35px;line-height:35px;">
					<div id="allmap" style="width:350px;height:350px;"></div>
				</p>
				<p>
					<font color="red">*</font> <span style="font-weight:normal;">经营范围：</span>
					<select id="goodsTypeName" name="goodsTypeName">
						<option value="-2">请选择经营范围</option>
						<c:forEach var="gli" items="${gList}">
							<option value="${gli.goodsTypeName}">${gli.goodsTypeName}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<font color="red">*</font> <span style="font-weight:normal;">价格区间：</span>
					<input id="businessLicenseNo" type="text" name="businessLicenseNo"
						style="width:345px;height:35px;line-height:35px;">
				</p>
				<p>
					<span style="font-weight:normal;">营业执照：</span><br> <img id="businessLicensePhoto" src=""
						width="185" height="140" name="businessLicensePhoto">
				</p>
				<p>
					<span style="font-weight:normal;">店铺展示：</span><br> <img src=""
						width="185" height="140" id="shopPhotoURL" name="shopPhotoURL">
				</p>
				<div class="btn_div">
					<input type="button" value="上一步"
						onClick="javascript:window.location.href='/register.jhtml'"
						style="background:#69CDCD;border:1px solid #69CDCD;"> <input
						type="submit" value="下一步">
				</div>
			</div>
		</form>
	</div>

	<!-- 引用尾部页面 -->
	<jsp:include page="include/footer.jsp" flush="true" />

</body>
</html>
