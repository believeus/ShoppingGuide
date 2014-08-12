<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>我的店铺</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" src="js/jquery.js"></script>
	<style type="text/css">
		.s_main{
			width:1000px;
			height:auto;
			overflow:hidden;
			margin:20px auto;
			background:#FFFFFF;
		}
		.s_menu{
			width:290px;
			height:312px;
			border-radius:4px;
			margin-right:auto;
			margin-left:auto;
		}
		.s_menu_list{
			width:290px;
			height:76px;
			line-height:76px;
			border:1px solid #D5F1F0;
			background:#EAFCFC;
		}
		.s_menu_list:hover{
			background:#69CDCD;
			color:#FFFFFF !important;
		}
		.s_menu_list_img{
			width:110px;
			height:75px;
			float:left;
			line-height:75px;
			text-align:center;
		}
		.s_menu_list_img img{
			margin-top:13px;
		}
		.s_menu_list_name{
			float:left;
			width:177px;
			height:75px;
			text-align:left;
			line-height:75px;
			cursor:pointer;
		}
		.s_menu_list_name:hover{
			color:#FFFFFF;
		}
		.s_menu_list_name a{
			color:#42C0B5;
			font-size:16px;
		}
	</style>
	<script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			$(".img1").parent().parent().mouseover(function(){
				$(".img1").css("background-position","-288px -253px");
			}).mouseout(function(){
				$(".img1").css("background-position","-222px -253px");
			});
			$(".img2").parent().parent().mouseover(function(){
				$(".img2").css("background-position","-288px -322px");
			}).mouseout(function(){
				$(".img2").css("background-position","-223px -322px");
			});
			$(".img3").parent().parent().mouseover(function(){
				$(".img3").css("background-position","-288px -386px");
			}).mouseout(function(){
				$(".img3").css("background-position","-222px -386px");
			});
		});
	</script>
  </head>
  
  <body bgcolor="">
  	 <!-- 引用尾部页面 -->
    <jsp:include page="../include/header.jsp" flush="true" />
    
    <div class="s_main">
   		<p>所在位置：
   			<a href="/menu.jhtml" title="菜单">菜单</a> >
   			<a href="/myShop.jhtml?shopId=${shop.shopId }" title="我的店铺">我的店铺</a>
		</p>
    	<div class="s_menu">
    		<div class="s_menu_list" style="background:#2CB8AD;">
    			<div style="background:url(/images/bg.png);background-position:0 -260px;width:20px;height:25px;float:left;margin-left: 20px;margin-top: 28px;"></div>
   				<span style="margin-left:20px;font-size:20px;color:#FFFFFF;">${shop.shopName}</span>
   			</div>
    		<div class="s_menu_list">
    			<div class="s_menu_list_img">
   					<div class="img1" style="background:url(/images/bg.png);width:65px;height:60px;background-position:-222px -253px;margin-top:10px;margin-left:15px;"></div>
   				</div>
   				<div class="s_menu_list_name" onClick="javascript:window.location.href='/myProducts.jhtml?shopId=${shop.shopId}'">
   					<a href="/myProducts.jhtml?shopId=${shop.shopId}" title="我的商品">我的商品</a>
   				</div>
    		</div>
    		<div class="s_menu_list">
    			<div class="s_menu_list_img">
   					<div class="img2" style="background:url(/images/bg.png);width:65px;height:60px;background-position:-223px -322px;margin-top:10px;margin-left:15px;"></div>
   				</div>
   				<div class="s_menu_list_name" onClick="javascript:window.location.href='/shopMsg.jhtml?shopId=${shop.shopId}'">
   					<a href="/shopMsg.jhtml?shopId=${shop.shopId}" title="店铺信息">店铺信息</a>
   				</div>
    		</div>
    		<div class="s_menu_list">
    			<div class="s_menu_list_img">
   					<div class="img3" style="background:url(/images/bg.png);width:65px;height:60px;background-position:-222px -386px;margin-top:10px;margin-left:15px;"></div>
   				</div>
   				<div class="s_menu_list_name" onClick="javascript:window.location.href='/shopPreview.jhtml?shopId=${shop.shopId}'">
   					<a href="/shopPreview.jhtml?shopId=${shop.shopId}" title="店铺预览">店铺预览</a>
   				</div>
    		</div>
    	</div>
    </div>
    
    <!-- 引用尾部页面 -->
    <jsp:include page="../include/footer.jsp" flush="true" />
    
  </body>
</html>
