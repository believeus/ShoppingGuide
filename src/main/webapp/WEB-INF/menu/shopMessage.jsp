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

<title>店铺信息</title>

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
		.main_table2 tr {
		    line-height: 40px;
		    vertical-align: top;
		}
		.main_table2 tr:hover{
			background:#EAFCFC;
		}
		.pp{
			border: 1px solid gray;
		    border-radius: 0.2em;
		    display: block;
		    float: left;
		    font-size: 13px;
		    height: 20px;
		    line-height: 20px;
		    margin: 5px;
		    padding: 3px 15px;
		    width: auto;
		    background:#cccccc;
		    color:#666666;
		    border:1px solid #cccccc;
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
	});	
		
</script>

</head>
<body>   
		 <!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
		
		<div id="main" style="">
			<p style="margin:0 auto;width:1000px;">所在位置：
	   			<a href="/menu.jhtml" title="菜单">菜单</a> >
	   			<a href="/shopMsg.jhtml?shopId=${tshop.shopId}" title="店铺资料">店铺资料</a>
			</p>
			<table class="main_table1">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">店铺资料</p></td>
					<td style="width:56%;"></td>
					<td style="width:9%;">
						<input type="button" value="编辑" onClick="javascript:window.location.href='/editShopMsg.jhtml?shopId=${tshop.shopId}'" style="border:none;outline:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" />
					</td>
					<td style="width:8%;"><input type="button" value="返回" onClick="javascript:window.history.back();" style="border:none;width:68px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
					<td style="width:8%;"><input type="button" value="修改用户密码" onClick="javascript:window.location.href='/editPassword.jhtml'" style="border:none;width:120px;height:32px;background-color:#69CDCD;border-radius:.2em;color:white;" /></td>
				</tr>
			</table>			
			<div style="width:1000px;height:auto;margin:0 auto;overflow:hidden;">
				<img src="/images/line.png">
			</div>
			
			<table class="main_table2" cellspacing="0">
				<tr>
					<td style="color:red;">*</td>
					<td>店铺名称：</td>
					<td style="width:85%;">
						${tshop.shopName }
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td>店铺特色：</td>
					<td>
						<%-- ${tshop.shopBusinessScope } --%>
						<c:forEach var="feature" items="${features }">
							<p class="pp">${feature.featureName }</p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td style="">所在商场：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						${tshop.market.marketName}
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td style="">详细位置：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						${tshop.address}
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td style="">经营范围：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						
						<c:forEach var="goodsTypes" items="${tshop.goodsTypes }">
							${goodsTypes.goodsTypeName}
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td style="color:red;">*</td>
					<td style="">联系电话：</td>
					<td id="main_table2_td" class="main_table2_td" style="">
						${tshop.phoneNumber }
					</td>
				</tr>
			</table>


			<hr style="width:85%;border:1px solid #E8E8E8;" />
			
			<table class="main_table3" style="">
				<tr>
					<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
					<td style="width:90%;" colspan="2"><div style="float:left;color:red;">*</div>营业执照:</td>
				</tr>
   				<tr style="">
					<td colspan="2" style=""></td>
					<td>
					
						<div class="brandImg">
							<img style="width:229px;height:179px" src="<%=Variables.shopLicenseURL %>${tshop.businessLicensePhotoUrl }" name="img"/>
						</div>
						<div class="main_table3_div3">
							营业执照：${tshop.businessLicenseNo }<br/>
							注：必须上传营业执照或填写营业执照号
						</div>
					</td>
				</tr>
				<tr>
					<td style="width:1%;"><div class="main_table3_div1" style=""></div></td>
					<td style="width:90%;" colspan="2"><div style="float:left;color:red;">*</div>店铺预览:</td>
				</tr>
   				<tr style="">
					<td colspan="2" style=""></td>
					<td class="shopShow">
						<div class="brandImg" style="margin-top:20px;">
							<img style="width:229px;height:179px" src="<%=Variables.shopURL %>${tshop.shopPhotoUrl}" name="img"/>
						</div>
					</td>
				</tr>
			</table>
			
		</div>

		
		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
