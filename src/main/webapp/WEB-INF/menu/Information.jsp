<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>资讯详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript" src="js/jquery.js"></script>
	<style>
		h2 {
			float:left;
			margin:4px auto 25px auto;
			font-size:24px;
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
		#netitl {
			clear:left;	
			height:50px;
		}
		#netitl p:first-of-type {
			float:left;
			width:270px;
		}
		#netitl p:nth-child(2) {
			float:left;
			width:125px;
		}
		#netitl p:nth-child(3) {
			float:left;
			width:155px;
		}
		#netitl p:nth-child(4) {
			float:left;
		}
		hr {
			border:1px solid #CCC;
		}
		#img_ {
			margin:40px auto;
			width:710px;
		}
		#tes1 {
			width:815px;
			margin:auto;
			letter-spacing:1px;
		}
	</style>
  </head>
  
  <body>
	<!-- 引用尾部页面 -->
	 <jsp:include page="../include/header.jsp" flush="true" />
    <div>
		<div style="width:1000px; margin:auto; padding-top:30px;">
	    	<div>
	            <div>
	                <h2>男人装百期嘉年华璀璨起航 一场力与美的饕餮盛宴</h2>
	            </div>
	            <div class="butt01"><p>确认</p></div>
	            <div class="butt01" style="margin-right:20px;"><p>取消</p></div>
	        </div>
	        <div id="netitl">
	            <p>发布时间：<span>2014年7月16日12:16</span></p>
	            <p>浏览量：<a>1234</a></p>
	            <p>转至：<span>男人装时尚杂志</span></p>
	            <p>原文链接：<a>www.aileguang.com</a></p>
	        </div>
	        <hr />
	        <div id="img_">
	        	<img src="images/zixun.jpg"/>
	        </div>
	        <div id="tes1">
	        	<h4>瘦马诙谐脱口秀戏说《男人装》百期历程 世界吉尼斯纪录诞生</h4>
	        	<p>9月12日，由时尚传媒集团旗下顶级男性杂志《男人装》主办的百期嘉年华盛典在京璀璨起航，整个盛典现场流光溢彩，超凡舞台空间布局、活力无限功能区域设计、绚烂迷离的舞美灯光、激情四射的动感音乐，一场力与美的饕餮盛宴华丽绽放！</p>
	        	<p>盛典当日，时尚传媒集团总裁刘江、时尚传媒集团出版副总裁瘦马、《男人装》助理出版人路璐、《男人装》主编陈修远、著名纪录片导演范立欣、导演郝杰、新锐作家史航、林天宏等嘉宾名流悉数到场；崔健、韩庚、姚笛、王学兵、阿朵、郁可唯、郝云、丁当、曹云金、、孙菲菲、陈志朋、迪克牛仔、何晟铭、郑亦桐、张译、杨洋、李欣汝、王若心、侯璎珏、刘雨欣、于咏琳、甘婷婷、孔维、GALA乐队、大棒乐队、张耀栋等当红演艺明星均亲临现场，以各自的方式送上对《男人装》百期的诚挚祝福, 所有来宾与《男人装》团队、百位忠实读者、京城主流媒体一起尽享《男人装》百期嘉年华狂欢派对的幸福时光！</p>
	            <h4>瘦马诙谐脱口秀戏说《男人装》百期历程 世界吉尼斯纪录诞生</h4>
	        	<p>9月12日，由时尚传媒集团旗下顶级男性杂志《男人装》主办的百期嘉年华盛典在京璀璨起航，整个盛典现场流光溢彩，超凡舞台空间布局、活力无限功能区域设计、绚烂迷离的舞美灯光、激情四射的动感音乐，一场力与美的饕餮盛宴华丽绽放！</p>
	        	<p>盛典当日，时尚传媒集团总裁刘江、时尚传媒集团出版副总裁瘦马、《男人装》助理出版人路璐、《男人装》主编陈修远、著名纪录片导演范立欣、导演郝杰、新锐作家史航、林天宏等嘉宾名流悉数到场；崔健、韩庚、姚笛、王学兵、阿朵、郁可唯、郝云、丁当、曹云金、、孙菲菲、陈志朋、迪克牛仔、何晟铭、郑亦桐、张译、杨洋、李欣汝、王若心、侯璎珏、刘雨欣、于咏琳、甘婷婷、孔维、GALA乐队、大棒乐队、张耀栋等当红演艺明星均亲临现场，以各自的方式送上对《男人装》百期的诚挚祝福, 所有来宾与《男人装》团队、百位忠实读者、京城主流媒体一起尽享《男人装》百期嘉年华狂欢派对的幸福时光！</p>
	        </div>
	    </div>
	</div>
	 <!-- 引用尾部页面 -->
 	<jsp:include page="../include/footer.jsp" flush="true" />
  </body>
</html>
