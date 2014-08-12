<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>菜单页面</title>
    
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
			width:292px;
			height:390px;
			float:left;
			border-radius:4px;
			margin-right:37px;
			margin-bottom:20px;
			border:1px solid #d5f1f0;
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
		.s_menu_list_img div{
			background:url(/images/bg.png);
			width:90px;
			height:75px;
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
				$(".img1").css("background-position","-146px -245px");
			});
			$(".img1").parent().parent().mouseout(function(){
				$(".img1").css("background-position","-78px -245px");
			});
			$(".img2").parent().parent().mouseover(function(){
				$(".img2").css("background-position","-146px -311px");
			});
			$(".img2").parent().parent().mouseout(function(){
				$(".img2").css("background-position","-78px -311px");
			});
			$(".img3").parent().parent().mouseover(function(){
				$(".img3").css("background-position","-146px -378px");
			});
			$(".img3").parent().parent().mouseout(function(){
				$(".img3").css("background-position","-78px -378px");
			});
		});
	</script>
  </head>
  
  <body bgcolor="">
  	 <!-- 引用尾部页面 -->
    <jsp:include page="../include/header.jsp" flush="true" />
    
    <div class="s_main">
    	<p>所在位置：<a href="/menu.jhtml" title="菜单">菜单</a></p>
    	<div style="width: auto; height: auto; overflow: hidden;">
    	
    	<c:forEach var="shop" items="${shops}">
    		
    	<div class="s_menu">
    		<div class="s_menu_list" style="background:#2CB8AD;">
    			<div style="background:url(/images/bg.png);background-position:0 -260px;width:20px;height:25px;float:left;margin-left: 20px;margin-top: 28px;"></div>
   				<span style="margin-left:15px;font-size:20px;color:#FFFFFF;">${shop.shopName}</span>
   			</div>
    		<div class="s_menu_list">
    			<div class="s_menu_list_img">
   					<div class="img1" style="background-position:-78px -245px"></div>
   				</div>
   				<div class="s_menu_list_name" onClick="javascript:window.location.href='/myShop.jhtml?shopId=${shop.shopId}'">
   					<a href="/myShop.jhtml?shopId=${shop.shopId}" title="我的店铺">我的店铺</a>
   				</div>
    		</div>
    		<div class="s_menu_list">
    			<div class="s_menu_list_img">
   					<div class="img2" style="background-position:-78px -311px"></div>
   				</div>
   				<div class="s_menu_list_name" onClick="javascript:window.location.href='/showFans.jhtml'">
   					<a href="/showFans.jhtml?shopId=${shop.shopId}" title="我的粉丝">我的粉丝</a>
   				</div>
    		</div>
    		<div class="s_menu_list">
    			<div class="s_menu_list_img">
   					<div class="img3" style="background-position:-78px -378px"></div>
   				</div>
   				<div class="s_menu_list_name" onClick="javascript:window.location.href='/infoList.jhtml'">
   					<a href="/infoList.jhtml" title="潮流资讯">潮流资讯</a>
   				</div>
    		</div>
    		<div class="s_menu_list" style="background:#EAEAEA;">
    			<div class="s_menu_list_img">
   					<div class="img4" style="background-position:-78px -449px"></div>
   				</div>
   				<div class="s_menu_list_name">
   					<a href="javascript:void(0);" onClick="alert('暂无信息,敬请期待');" style="color:#555555" title="流行分析">流行分析</a>
   				</div>
    		</div>
    	</div>
    	</c:forEach>
    	<div class="s_menu"
    		style="border:2px dotted #E4E4E4;height:386px;line-height:386px;text-align:center;margin-right:0;cursor:pointer;"
    		onClick="alert('暂无信息');">
    		<a href="javascript:void(0);" title="点击添加新店铺" onClick="alert('暂无信息');"><font size="10" color="#E4E4E4">+</font></a>
    		<!-- href="/addShop.jhtml" -->
    	</div>
   		</div>
    </div>
    
    <!-- 引用尾部页面 -->
    <jsp:include page="../include/footer.jsp" flush="true" />
    
  </body>
</html>
