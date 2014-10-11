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

<title>用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="X-UA-Compatible" content="IE=9"/>
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
	border: 1px solid #69cdcd;
	background: #69cdcd;
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
.error {
    color: red;
}
</style>
<style type="text/css">

	.brandImg{
			float:left;
			border: 1px solid;
			text-align: center;
			width: 229px;
			margin: 10px 10px 10px 0;
			height:231px;
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
	.add_img{
		border: 1px solid #69cdcd;
	    color: #69cdcd;
	    float: left;
	    font-size: 65px;
	    height: 231px;
	    line-height: 231px;
	    margin: 10px 10px 10px 0;
	    text-align: center;
	    width: 230px;
	    cursor:pointer;
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
		map.centerAndZoom("洪山区",12);                   // 初始化地图,设置城市和地图级别。
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
	
	$().ready(function() {
		
		var a =$("#Imgs .brandImg").size();
		var b = 1;
		$("#add_img").click(function(){
			var html='<div class="brandImg">'
				 +'<div id="preview_wrapper'+a+'" style="display:inline-block;width:227px;height:179px; background-color:#CCC; margin-top: 1px;">'  
					 +'<div id="preview_fake'+a+'" style="height:179px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)">'
					 	+'<img id="preview'+a+'"  style="width:227px;height:179px;" onload="onPreviewLoad(this,227,179)" src=""/><!--<span class="middle-money" value="'+b+'">设为默认</span>-->'
					 		+'</div>'    
					 	+'</div> '   
				+'<div style="text-align:left;"> '   
					+'<input id="goodsImg'+a+'" type="file" name="goodsImg'+a+'" style="width: 70px;" onchange="filename'+a+'.value=this.value;changeDefault(\'middle_money'+a+'\');onUploadImgChange(this,227,179,\'preview'+a+'\',\'preview_fake'+a+'\',\'preview_size_fake'+a+'\');"/>'  
					+'<input type="hidden" id="filename'+a+'" name="filename'+a+'">'
				+'</div>'    
					+'<img id="preview_size_fake1" style=" filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);visibility:hidden;width:0;height:0;display:none;"/>' 
				+'<div style="text-align: right; border-top: 1px dashed #E4E4E4; height: 24px; line-height: 24px; margin-right: 3px;"><a id="middle_money'+a+'" class="middle_money" href="javascript:void(0);" value="goodsImg'+a+'" style="float:left;display: none;">设为默认</a><a onclick="delete_pic(this,\'goodsImg'+a+'\')" href="javascript:void(0);">删除</a></div>'
				+'</div>';
				
			if($("#Imgs .brandImg").size() > 8){ 
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
					$("#moren").val($(this).attr("value"));
					easyDialog.open({
		                container: {
		                    header: '提示',
		                    content: '设置成功'
		                },
		                overlay: false
		            });
				});
			});
			$(".middle_money").each(function(){
				$(this).click(function(){
					$(".brandImg").css("border","1px solid #000000");
					$(this).parent().parent().css("border","1px solid #69cdcd");
					var vl=$(this).attr("value");
					if(vl.indexOf("Img") > 0 ){
						$("#morenIndex").val(vl);
						$("#moren").val("");
					}else{
						$("#morenIndex").val("");
						$("#moren").val(vl);
					}
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
				$("#moren").val($(this).attr("value"));
				easyDialog.open({
	                container: {
	                    header: '提示',
	                    content: '设置成功'
	                },
	                overlay: false
	            });
			});
		});
		$(".middle_money").each(function(){
			$(this).click(function(){
				$(".brandImg").css("border","1px solid #000000");
				$(this).parent().parent().css("border","1px solid #69cdcd");
				var vl=$(this).attr("value");
				if(vl.indexOf("Img") > 0 ){
					$("#morenIndex").val(vl);
					$("#moren").val("");
				}else{
					$("#morenIndex").val("");
					$("#moren").val(vl);
				}
				easyDialog.open({
	                container: {
	                    header: '提示',
	                    content: '设置成功'
	                },
	                overlay: false
	            });
			});
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
				shopOwnerName:{
					required : true
				},
				marketId:{
					required : true
				},
				goodsImg0:{
					required : true
				},
				goodsImg1:{
					required : true
				},
				goodsImg2:{
					required : true
				},
				goodsImg3:{
					required : true
				},
				goodsImg4:{
					required : true
				},
				goodsImg5:{
					required : true
				}
			},
			messages : {
				shopName : {
					required : "店铺名称必填"
				},
				address:{
					required : "请输入您的详细地址"
				},
				shopOwnerName:{
					required : "店主姓名必填"
				},
				marketId:{
					required:"商场必填"
				},
				goodsTypeId:{
					required:"商品类型必填"
				},
				phoneNum:{
					required : "联系电话必填"
				},
				goodsImg0:{
					required : "店铺图片必填"
				},
				goodsImg1:{
					required : "店铺图片必填"
				},
				goodsImg2:{
					required : "店铺图片必填"
				},
				goodsImg3:{
					required : "店铺图片必填"
				},
				goodsImg4:{
					required : "店铺图片必填"
				},
				goodsImg5:{
					required : "店铺图片必填"
				}
			}
		});
		
		
	});
</script>

<script type="text/javascript">    
		function onUploadImgChange(sender,offsetWidth,offsetHeight,preview,preview_fake,preview_size_fake){     
		    if( !sender.value.match( /.jpg|.gif|.png|.jpeg|.bmp/i ) ){     
		        //alert('图片格式无效！');  
		        easyDialog.open({
	                container: {
	                    header: '提示',
	                    content: '图片格式无效'
	                },
	                overlay: false
	            });
		        return false;     
		    }     
		    
		  //---------------
		    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
			var isSafari = userAgent.indexOf("Safari") > -1 && userAgent.indexOf("Chrome") < 1 ; //判断是否Safari
			if(isSafari){
				//alert("我是Safari浏览器");
				easyDialog.open({
	                container: {
	                    header: '提示',
	                    content: '图片可上传，但safari不支持图片预览，建议使用Firefox！'
	                },
	                overlay: false
	            });
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
		        /* sender.select();     
		        var imgSrc = document.selection.createRange().text; */ 
		        sender.select(); 
		        window.document.body.focus();    
		        var imgSrc = document.selection.createRange().htmlText;
		        
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
		$().ready(function(){
			
			$("#market").change(function(){
				var str = $("#provinceId").find("option:selected").text()+$("#cityId").find("option:selected").text()+$("#areaId").find("option:selected").text()+$("#market").find("option:selected").text();
				$(".markert").append("<input type='hidden' name='area' value='"+str+"'>");
			});
			/* $("#priceRange").blur(function(){
				var str = $("#provinceId").find("option:selected").text()+$("#cityId").find("option:selected").text()+$("#areaId").find("option:selected").text()+$("#market").find("option:selected").text();
				var area = $("#suggestId").val();
				//alert(area.substring(area.indexOf("区")+1));
				//alert(str.substring(str.indexOf("区")+1));
				alert(area.substring(area.indexOf(str)));
				var isture = area.indexOf(str);
				alert(isture);
				if(isture == -1){
					$("#suggestId").val("其他");
				}else{
					var a = area.substring(area.indexOf("区")+1);
					alert(a);
					$("#suggestId").val(a);
				}
			}); */
			$("input[type='submit']").click(function(){
				if($("#Imgs .brandImg").size() ==0){
					 easyDialog.open({
		                container: {
		                    header: '提示',
		                    content: '请上传店铺图片'
		                },
		                overlay: false
		            });
			        return false;
				}else{
					$("#registerForm").validate({
						
					});
				}
			});
		});
		
	</script>
	<script type="text/javascript">
	function changeDefault(id){
		$("#"+id).css("display","");
	}
		function delete_pic(object,path){	
			if(path == $("#moren").val()|| path == $("#morenIndex").val()){
				easyDialog.open({
	                container: {
	                    header: '提示',
	                    content: '已设置默认图片，不能删除'
	                },
	                overlay: false
	            });
				return false;
			}
			if(path!=""){
				Img(path);
			}
			$(object).closest("div").parent().remove();
		}
		function Img(path){
			var deleteImgs = $("#deleteImgs");
			
			if (deleteImgs.length > 0) { 
		     	//对象存在的处理逻辑
	            $("#deleteImgs").val(deleteImgs.val()+","+path);
		    } else {
		      	//对象不存在的处理逻辑
		      	var html='<input id="deleteImgs" type="hidden" name="deleteImgs" value="'+path+'"/>';
				$("#editShop").append(html);
		   }	
		}
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
			<span><font color="red">*</font>为必填选项</span> 
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
					<span style="font-weight:normal;">店主QQ号:</span>
					<input id="qq" type="text" name="qq" 
					 onkeyup="value=this.value.replace(/\D+/g,'')" maxlength="11"
					 style="width:345px;height:35px;line-height:35px;">
				</p>
				<p class="markert">
					<font color="red">*</font> <span style="font-weight:normal;">所在商场:</span>
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
					<select id="provinceId" name="provinceId">
						<!-- <option value="17">湖北省</option> -->
					</select>
					<select id="cityId" name="cityId">
						<!-- <option value="159">武汉市</option> -->
					</select>
					<select id="areaId" name="areaId"></select>
					<select id="market" name="market"></select>
					<input type="text" style="width: 0px;border:0;" name="marketId" id="marketId"/>
					<span></span>
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
					
					<c:forEach var="gli" items="${gList}">
						<label><input type="checkbox" name="goodsTypeId" value="${gli.goodsTypeId}">${gli.goodsTypeName}</label>
					</c:forEach>
					<%-- <select id="goodsTypeId" name="goodsTypeId">
						<option ></option>
							<option value="${gli.goodsTypeId}">${gli.goodsTypeName}</option>
					</select> --%>
				</p>
				<p>
					<span style="font-weight:normal;">价格区间：</span>
					<input id="priceRange" type="text" name="priceRange"
						style="width:345px;height:35px;line-height:35px;">
				</p>
				<div style="padding-left:40px;width:800px;height:auto;overflow:hidden;">
					<div style="width:300px;height:auto;float:left;">
						<span style="font-weight:normal;">营业执照：</span><br> 
						<div class="brandImg">
							 <div id="preview_wrapper111" style="display:inline-block;width:227px;height:179px; background-color:#CCC; margin-top: 1px;">    
							        <div id="preview_fake111" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)">  
							            <img id="preview111"  style="width:227px;height:179px;" onload="onPreviewLoad(this,227,179)" src=""/>
							        </div>    
							    </div>    
							    <div style="text-align:left;">    
							    <input id="shopLicenseImg" type="file" name="shopLicenseImg" style="width: 70px;" onchange="filename111.value=this.value;onUploadImgChange(this,227,179,'preview111','preview_fake111','preview_size_fake111');"/>  
							    <input type="hidden" id="filename111" name="filename111">
							    </div>    
							    <img id="preview_size_fake1" style=" filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);visibility:hidden;width:0;height:0;"/> 
						</div>
					</div>
					<div style="padding-left:40px;margin-top:20px;width:400px;height:auto;float:left;margin-top: 170px;">
						<span style="font-weight:normal;">营业执照号：</span>
						<input type="text" name="businessLicenseNo" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'')" style="margin-top:5px;"/><br/>
						<span>注：必须上传营业执照或填写营业执照号</span>
					</div>
				</div>
				<div class="shopShow" style="">
					<font color="red">*</font><span style="font-weight:normal;">店铺展示：</span>
					<span style="font-size:13px;">(最多可上传9张图片)</span>
					<input type="hidden" id="moren" name="moren" value="">
					<input type="hidden" id="morenIndex" name="morenIndex" value="">
					<br> 
					<div id="Imgs">
						<div id="add_img" class="add_img" title="添加店铺图片">+</div>
						<%-- <div class="brandImg">
							 <div id="preview_wrapper2" style="display:inline-block;width:227px;height:179px; background-color:#CCC; margin-top: 1px;">    
							        <div id="preview_fake2" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)">  
							            <img id="preview2"  style="width:227px;height:179px;" onload="onPreviewLoad(this,227,179)" src=""/>
							        	<!-- <span class="middle-money" value="0">设为默认</span> -->
							        </div>    
							    </div>    
							    <div style="text-align:left;">    
							    <input id="goodsImg2" type="file" name="goodsImg2" style="width: 70px;" onchange="filename2.value=this.value;onUploadImgChange(this,227,179,'preview2','preview_fake2','preview_size_fake2');"/>  
							    <input type="hidden" id="filename2" name="filename2">
							    </div>    
							    <img id="preview_size_fake2" style=" filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);visibility:hidden;width:0;height:0;"/> 
								<div style="text-align: right; border-top: 1px dashed #E4E4E4; height: 24px; line-height: 24px; margin-right: 3px;">
									<a class="middle_money" href="javascript:void(0);" value="${status.index}" style="float:left;">设为默认</a>
									<a onclick="delete_pic(this)" href="javascript:void(0);">删除</a>
								</div>
						</div> --%>
					</div>
				<div class="btn_div" style="margin-top:20px;">
					<input type="button" value="上一步" onClick="javascript:window.location.href='/register.jhtml'" style="background:#69CDCD;border :1px solid #69CDCD;"> 
						<input type="submit" value="下一步">
				</div>
				</div>
			</div>
		</form>
	</div>

	<!-- 引用尾部页面 -->
	<jsp:include page="include/footer.jsp" flush="true" />
	
</body>
</html>
