<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.etech.variable.Variables" %>
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
		/* #suib input {
			width:340px; 
			height:28px; 
			padding: 0px 4px;;
		} */
		
		#shopSpec{
			padding-top:5px;
		}
		#shopSpec p{
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
		.inputClass{
			background-color:#69CDCD;
			border-radius:.2em;
			color:white;
		}
		.error {
		    color: red;
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
		.current {
			background: #69cdcd;
			border: 1px solid #69cdcd !important;
			color: #ffffff !important;
		}
		.middle-money {
		    background: url(/images/middle-money_bj.png) repeat-x scroll 0 0 rgba(0, 0, 0, 0);
		    bottom: 0;
		    color: #ffffff;
		    font-family: "微软雅黑";
		    font-size: 13px;
		    font-weight: bold;
		    height: 32px;
		    line-height: 32px;
		   	position: relative;
		    text-align: center;
		    width: 230px;
		    /* margin-top:-32px; */
		    opacity:0.9;
		    cursor:pointer;
		    display:none;
		}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2qkpDitMlFIilEPKy62fiWDe"></script>
<script type="text/javascript">
$(function(){
	var features = new Array();
	<c:forEach var="feature" items="${shopfeatures }">
		$("p[value='${feature.featureId}']").attr("class","current");
		features.push(${feature.featureId});
	</c:forEach>
		$("#featureIds").val(features);
	<c:forEach var="goodstype" items="${tgoodstypes }">
		$("input[value='${goodstype.goodsTypeId}']").attr("checked","checked");
	</c:forEach>
	// 百度地图API功能
	function G(id) {
	    return document.getElementById(id);
	}

	var map = new BMap.Map("l-map");
	map.centerAndZoom("北京",12);     // 初始化地图,设置城市和地图级别。
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
	
	$("#provinceId").change(function(){
		  var provinceId=$("#provinceId").find("option:selected").text();	
		  map.centerAndZoom(provinceId,12);  
		});
		$("#cityId").change(function(){
			  var cityId=$("#provinceId").find("option:selected").text()+$("#cityId").find("option:selected").text();
			  map.centerAndZoom(cityId,12);  
		});
		$("#areaId").change(function(){
			  var areaId=$("#provinceId").find("option:selected").text()+$("#cityId").find("option:selected").text()+$("#areaId").find("option:selected").text();	
			  map.centerAndZoom(areaId,12);  
		});
});
	$().ready(function(){
		
		$("#add_img").click(function(){
			var a = $(".shopShow .brandImg").size() +1;
			var html = "<div style='padding-left:40px;'><div class='brandImg' style='margin-top:20px;float:left;'><span><a onclick='file"+a+".click()' href='javascript:return false;'>点击上传图片</a></span><span value='"+a+"' id='' class='middle-money' style='height:32px;display:none;'>设为默认</span><img id='shopPhotoURL' style='width:229px;height:179px' src='' name='shopPhotoURL'/></div><input type='file' style='display:none' id='file"+a+"' name='file"+a+"' onchange='filename"+a+".value=this.value;loadImgFast(this,"+a+")'><input type='hidden' id='filename"+a+"' name='filename"+a+"'></div>";
			//alert($(".shopShow .brandImg").size());
			if($(".shopShow .brandImg").size() > 8){
				alert("最多9张图片");
			}else{
				$(".shopShow .brandImg").parent().parent().append(html);
			}
			
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
		
		$("#shopSpec p").click(function(){
			if($(this).hasClass("current")){
				$(this).removeClass("current");
			}else{
				$(this).addClass("current");
			}
			
			var featureIds=new Array();
			var featureNames=new Array();
			$("#special.current").each(function(){
				featureIds.push($(this).attr("value"));
				featureNames.push($(this).text());
			});
			// 在店铺表中插入店铺特色
			$.post("/insertBussnessScope.jhtml",{featureNames:featureNames.toString()},function(result){
				
			 });
			
			$("#featureIds").val();
			$("#featureIds").val(featureIds);
			
		});
		
		/* $("#businessRange").change(function(){
			if($("#businessTd select").length < 5){
				var buss=$("#businessRange").clone(true);
				$(this).unbind();
				$("#businessRange").attr("id","Range");
				$("#businessTd").append(buss);
			}
		}); */
		
		$("#editShop").validate({
			rules : {
				shopName : {
					required : true
				},
				goodsTypeId : {
					required : true
				},
				businessLicense :{
					required : true
				},
				marketId:{
					required : true
				},
				filename0:{
					required : true
				}
			},
			messages : {
				shopName : {
					required : "店铺名称必填",
				},
				businessLicense :{
					required : "请输入营业执照"
				},
				marketId:{
					required:"商场必填"
				},
				goodsTypeId:{
					required:"商品类型必填"
				},
				filename0:{
					required : "请上传营业执照"
				}
			}
			
		});
	});	
		
</script>

</head>
<body>
	
		 <!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
		<div id="main" style="">
		<p style="margin:0 auto;width:1000px;">所在位置：
   			<a href="/menu.jhtml" title="菜单">菜单</a> >
   			<a href="/editShopMsg.jhtml?shopId=${tshop.shopId}" title="编辑店铺资料">编辑店铺资料</a>
		</p>
		<form id="editShop" action="updateShop.jhtml" method="post" enctype="multipart/form-data">
		<input type="hidden" name="shopuserId" value="${sessionUser.shopUserId}"/>
		<input type="hidden" name="shopId" value="${tshop.shopId}"/>
			<table class="main_table1">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">店铺资料</p></td>
					<td style="width:56%;"></td>
					<td style="width:9%;"><input type="submit" value="保存" style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;cursor:pointer;" /></td>
					<td style="width:8%;"><input type="button" value="返回" onClick="javascript:window.history.back();" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
					<td style="width:8%;"><input type="button" value="修改用户密码" onClick="javascript:window.location.href='/updatePsd.jhtml'" style="border:none;width:120px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
				</tr>
			</table>			
			<div style="width:1000px;height:auto;margin:0 auto;overflow:hidden;">
				<img src="/images/line.png">
			</div>
			
			<table id="suib" style="margin:0px auto;" cellspacing="0">
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>店铺名称：</b></td>
		                <td colspan="3">
		                    <input id="shopName" type="text" name="shopName" value="${tshop.shopName }">
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>店铺特色：</b></td>
		                <td colspan="3" id="shopSpec">
							<c:forEach var="features" items="${features }">
								<p id="special" name="special" value="${features.featureId}" style="">${features.featureName }</p>
							</c:forEach>
							 <input type="hidden" name="featureIds" id="featureIds" value=""/>
		                </td>
		               
		              </tr>
		              <tr>
		                 <td><b><span style="color:red;">*&nbsp;&nbsp;</span>所在商场：</b></td>
		                  <script type="text/javascript">
		                  	$(function(){
		                  		 $("#hide").bind("click",function(){
		                  			$("#marketName").next().hide();
		                  		 });
		                  		 $("#marketName").next().hide();
		                  		 $("#editMarket").bind("click",function(){
		                  			$("#marketName").next().show();
		                  		 });
		                  		 $("#market").click(function(){
		                  			var text="";
		                  			text=$("#provinceId").find("option:selected").text()+
		                  			     $("#cityId").find("option:selected").text()+
		                  			     $("#areaId").find("option:selected").text()+
		                  			     $("#market").find("option:selected").text();
		                  			
								    $("#marketName > span").text(text);
								    $("#marketId").val($("#market").find("option:selected").val());
								 });
		                  	});
		                  	
		                  </script>
		                 <td colspan="2" id="marketName"><span>${tshop.market.marketName}</span><a href="javascript:void(0);" id="editMarket"><font color="red">更改</font></a></td>
		                 <td>
			               <script type="text/javascript" src="/js/cascading.js"></script>
						   <script type="text/javascript">
							  $(function(){
									var cascade=new Cascade();
									cascade.initRoot("/initProvice.jhtml","provinceId","--请选择省--");
									cascade.changeCascade("provinceId","/initCity.jhtml","cityId","--请选择市--");
								    cascade.changeCascade("cityId", "/initArea.jhtml", "areaId","--请选择区--");
								    cascade.changeCascade("areaId","/initMarket.jhtml","market","--请选择商场--");
								    $("#market").click(function(){
								    	$("#marketId").val($(this).val());
								    });
							  });
							</script>
							<select id="provinceId"></select>
							<select id="cityId"></select>
							<select id="areaId"></select>
							<select id="market"></select>
							<input type="text" style="width:0px;border:0;" name="marketId" id="marketId" value="${tshop.market.marketId}" />
							<a id="hide" href="javascript:void(0)"><font color="red">隐藏</font></a>
							<span></span>
		               </td>
		              </tr>
		              
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>详细位置：</b></td>
		                <td colspan="3">
		                    <input id="suggestId" name="address" type="text" value="" placeholder="${tshop.address }"/>
		                    <label style="color:#00f;font-size:13px;">(若更改地址请点击地址选择，若不改，则为原地址)</label><br/>
		                   <%-- <label style="color:#00f;font-size:13px;">原地址是：${tshop.address }</label> --%>
		                </td>
		              </tr>
		              <tr>
	              		<td colspan="4">
		                	<div id="searchResultPanel" style="display: none;width:150px;height:auto;"></div>
							<div id="l-map" style="width:1000px;height:350px;margin:0 auto;"></div>
	              		</td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">*&nbsp;&nbsp;</span>经营范围：</b></td>
		                <td id="businessTd" colspan="3">
		                	<c:forEach var="gli" items="${range}">
								<label><input type="checkbox" name="goodsTypeId" value="${gli.goodsTypeId}">${gli.goodsTypeName}</label>
							</c:forEach>
		                   <%--  <select id="goodsTypeId" name="goodsTypeId" style="width:340px;text-align:center;margin-bottom:10px;">
								<c:forEach var="gli" items="${range}">
									<option value="${gli.goodsTypeId}">${gli.goodsTypeName}</option>
								</c:forEach>
							</select> --%>
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">&nbsp;&nbsp;</span>价格区间：</b></td>
		                <td colspan="3">
		                    <input id="priceRange" type="text" name="priceRange" value="${tshop.priceRange }"/>
		                </td>
		              </tr>
		              <tr>
		                <td><b><span style="color:red;">&nbsp;&nbsp;</span>联系电话：</b></td>
		                <td colspan="3">
		                    <input id="phoneNum" type="text" name="phoneNum" value="${tshop.phoneNumber }">
		                </td>
		              </tr>
		              <tr>
		              	<td><font color="red">*</font>营业执照号：</td>
		              	<td colspan="3">
		              		<input type="text" name="lisenceId" value="${tshop.businessLicenseNo }">
		              	</td>
		              </tr>
		              <tr>
		              	<td><font color="red">*</font><span style="font-weight:normal;">营业执照：</span></td>
		              	<td>
		              		<div style="padding-left:40px;">
								<div class="brandImg" style="margin-top:20px;">
									<span>
										<a onclick="file0.click()" href="javascript:return false;">点击上传图片</a>
									</span>
									<img id="businessLicensePhoto" style="width:229px;height:179px" src="<%=Variables.shopLicenseURL %>${tshop.businessLicensePhotoUrl }" name="businessLicensePhoto"/>
								</div>
								<input type="file" style="display:none" id="file0" name="shopLicenseImg" onchange="filename0.value=this.value;loadImgFast(this,0)">
								<input type="hidden" id="filename0" name="filename0">
							</div>
		              	</td>
		              	<td></td>
		              	<td></td>
		              </tr>
		              <tr>
		              	<td><font color="red">*</font><span style="font-weight:normal;">店铺预览：</span>
		              	<input id="add_img" type="button" value="添加商品图片" onClick=""/><br/>
		              	<span style="font-size:13px;">(最多可上传9张图片)</span>
		              	<input type="hidden" id="moren" name="moren" value="">
		              	</td>
		              	<td class="shopShow" colspan="3">
		              		<c:forEach var="path" items="${path }" varStatus="status">
		              		<div style="padding-left:40px;">
								<div class="brandImg" style="margin-top:20px;">
									<span>
										<a onclick="file${status.index+1}.click()" href="javascript:return false;">点击上传图片</a>
									</span>
									<span style="height:32px;display:none;" class="middle-money" id="" value="${status.index}">设为默认</span>
									<img id="shopPhotoURL" style="width:229px;height:179px" src="<%=Variables.shopURL %>${path }" name="shopPhotoURL"/>
								</div>
								<input type="file" style="display:none" id="file${status.index+1}" name="shopImg" onchange="filename${status.index+1}.value=this.value;loadImgFast(this,${status.index+1})">
								<input type="hidden" id="filename${status.index+1}" name="filename${status.index+1}">
							</div>
							</c:forEach>
		              	</td>
		              </tr>
		            </table>
	            </form>
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
