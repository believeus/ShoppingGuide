<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加店铺</title>

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
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2qkpDitMlFIilEPKy62fiWDe"></script>
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
	
	
	$().ready(function(){
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

		$("[id=businessRange]").click(function(){
			if($("[id=businessRange]:checked").length>5){
				this.checked=false;
			}
		});
		
		$("#submit").click(function(){
			
			var arr=new Array();
			$("[id=businessRange]:checked").each(function(){
				arr.push($(this).val());
			});
			
			var str="";
			for(var i=0;i<arr.length;i++){
				str+=arr[i]+",";
			}
			
			
			$("#businessRange").val=str.trim();
			
			//$("#addshopform").submit();
			
			//form validate
			$("#addshopform").validate({
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
					businessLicense :{
						required : true
					},
					priceRange:{
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
					businessLicense :{
						required : "请输入营业执照"
					},
					priceRange:{
						required : "价格区间必填"
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

	});	
		
</script>

</head>
<body>
	
		 <!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
		
		<div id="main" style="">
			<form id="addshopform" action="/addShopDetails.jhtml" method="post" autocomplete="off" novalidate="novalidate"  enctype="multipart/form-data">
			<input type="hidden" name="shopuserId" value="${sessionUser.shopUserId}"/>
			<table class="main_table1">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">店铺资料</p></td>
					<td style="width:56%;"></td>
					<td style="width:9%;">
						<input id="" type="submit" value="保存" style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" />
					</td>
					<td style="width:8%;">
						<input type="button" value="返回" onClick="javascript:window.history.back();" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" />
					</td>
					<td style="width:8%;">
						<input type="button" value="修改用户密码" onClick="javascript:window.location.href='/updatePsd.jhtml'" style="border:none;width:120px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" />
					</td>
				</tr>
			</table>
			<div style="width:1000px;height:auto;margin:0 auto;overflow:hidden;">
				<img src="/images/line.png">
			</div>		
			
				<table id="suib" style="margin:0px auto;" cellspacing="0">
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
			                <td colspan="3">
			                    <input id="suggestId" name="address" type="text" /><label style="color:#00f;font-size:13px;">(请在地图上选择)</label>
			                </td>
			              </tr>
			              <tr>
		              		<td colspan="4">
			                	<div id="searchResultPanel" style="display: none;width:150px;height:auto;"></div>
								<div id="l-map" style="width:1000px;height:350px;margin:0 auto;"></div>
		              		</td>
			              </tr>
			              <tr>
			              	<td><b><span style="color:red;">*&nbsp;&nbsp;</span>所在商场：</b></td>
			              	<td colspan="3">
			              		<select name="marketId" style="height: 30px; line-height: 30px; width: 310px;">
									<option></option>
									<c:forEach items="${marketList}" var="market">
										<option value="${market.marketId}">${market.marketName}</option>
									</c:forEach>
								</select>
			              	</td>
			              </tr>
			              <tr>
			                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>经营范围：</b></td>
			                
			                <td colspan="3">
			                	<div style="width:auto;">
				                	<%-- <c:forEach items="${range}" var="ran">
				                		<label style="text-align:cenetr;padding-right:8px;">
				                			<input style="width:auto;" id="businessRange" name="${ran.goodsTypeName}" type="checkbox" value="${ran.goodsTypeName}" />&nbsp;${ran.goodsTypeName}
			                			</label>
				                	</c:forEach> --%>
				                	<select id="goodsTypeId" name="goodsTypeId" style="height: 30px; line-height: 30px; width: 310px;">
										<option ></option>
										<c:forEach var="gli" items="${range}">
											<option value="${gli.goodsTypeId}">${gli.goodsTypeName}</option>
										</c:forEach>
									</select>
			                	</div>
			                	
			                </td>
			              </tr>
			              <tr>
			                <td><b><span style="color:red;">&nbsp;&nbsp;</span>价格区间：</b></td>
			                <td>
			                    <input id="priceRange" type="text" name="priceRange" style="width:310px;height:30px;"/>
			                </td>
			                <td><img id="priceImg" style="display:none;" src="images/chacha.png" /></td>
			                <td></td>
			              </tr>
			              
			            </table>
			       <table class="main_table3" style="">
					<tr>
						<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
						<td style="width:90%;" colspan="2"><div style=""></div>营业执照:</td>
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
							<div class="main_table3_div3">
								营业执照：<input type="text" name="businessLicense"><br/>
								注：可以上传营业执照或填写营业执照号
							</div>
						</td>
					</tr>
					<tr>
						<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
						<td style="width:90%;" colspan="2"><div style=""></div>店铺展示:</td>
					</tr>
	   				<tr style="">
						<td colspan="2" style=""></td>
						<td>
							<div class="brandImg">
								<span>
									<a onclick="file1.click()" href="javascript:return false;">点击上传图片</a>
								</span>
								<img style="width:229px;height:179px" src="" name="img"/>
							</div>
							<input type="file" style="display:none" id="file1" name="file1" onchange="filename1.value=this.value;loadImgFast(this,1)">
							<input type="hidden" id="filename1" name="filename1">
						</td>
					</tr>
					<!-- <tr>
						<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
						<td style="width:90%;" colspan="2"><div style="float:left;color:red;">*</div>店铺展示：</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>
							<div class="brandImg">
								<span>
									<a onclick="file2.click()" href="javascript:return false;">点击上传图片</a>
								</span>
								<img style="width:229px;height:179px" src="" name="img"/>
							</div>
							<input type="file" style="display:none" id="file2" name="file2" onchange="filename2.value=this.value;loadImgFast(this,2)">
							<input type="hidden" id="filename2" name="filename2">
						</td>
					</tr> -->
				</table>
			</form>
		</div>

		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
   	 	<script type="text/javascript">
			function loadImgFast(img,i){
				if (img.files && img.files[0]){
					var reader = new FileReader();
					reader.onload = function(evt){
						$(".brandImg:eq("+i+") img")[0].src = evt.target.result;
					};
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
