<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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

<title>我的粉丝</title>

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
			height:20px;
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
		.p_main{
			width:1000px;
			height:auto;
			overflow:hidden;
			margin:0 auto;
		}
		.p_list{
			width:300px;
			height:200px;
			float:left;
			margin-right:47px;
			margin-bottom:30px;
			border:1px solid #69CDCD;
			border-radius:4px;
		}
		.p_top{
			width:300px;
			height:65px;
			background:#69CDCD;
		}
		.p_top_img{
			width:65px;
			height:65px;
			float:left;
			margin-top: 5px;
    		text-align: center;
		}
		.p_top_img img{
			border:2px solid #FFFFFF;
			border-radius:3px;
		}
		.p_top_word{
			height:65px;
			width:235px;
			float:left;
		}
		.p_top_word_name{
			width:235px;
			height:30px;
			line-height:30px;
			font-size:15px;
			padding-left:10px;
		}
		.p_top_word_time{
			width:235px;
			height:30px;
			line-height:30px;
			font-size:15px;
			padding-left:10px;
		}
		.nName{
			float:left;
			color:#FFFFFF;
		}
		.nSex{
			float:right;
			color:#FFFFFF;
			margin-right:15px;
		}
		.nTime{
			float:left;
			color:#FFFFFF;
			font-size:13px;
		}
		.nRecord{
			float:right;
			color:#FFFFFF;
			margin-right:15px;
		}
		.p_speci{
			height:135px;
			width:300px;
			padding:10px;
		}
		.p_speci_p{
		    cursor: pointer;
		    display: block;
		    float: left;
		    font-size: 13px;
		    height: 20px;
		    margin: 5px 15px 5px 0;
		    padding: 3px 15px;
		    width: auto;
		    background:#EFEFEF;
		    color:#B3B3B3;
		}
		.gougou{
			background: url("/images/bg.png") repeat scroll -41px -332px rgba(0, 0, 0, 0);
		    height: 20px;
		    margin-left: 6px;
		    margin-top: 4px;
		    position: absolute;
		    width: 20px;
		}
	</style>

<script type="text/javascript">
	$().ready(function(){
		
	});	
		
</script>

</head>
<body>
	
		 <!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
		
		<div id="main" style="">
			<table class="main_table1">
				<tr style="">
					<td style=""><p style="font-size:24px;color:#69CDCD;">我的粉丝</p></td>
					<td>
						<input type="button" value="粉丝统计" onClick="javascript:window.location.href='/fansCount.jhtml?url=sex'" style="float:right;">
					</td>
				</tr>
			</table>			
			
			<div class="p_main">
				<img src="/images/line.png" style="margin-bottom:20px;">
				
<<<<<<< Updated upstream
				<div class="p_list">
					<div class="p_top">
						<div class="p_top_img">
							<img src="/images/header.png" width="50" height="50">
						</div>
						<div class="p_top_word">
							<div class="p_top_word_name">
								<span class="nName">昵称最多六字<font color="#32A8A8">(备注四字)</font></span>
								<span class="nSex">女</span>
							</div>
							<div class="p_top_word_time">
								<span class="nTime">2014年7月16日 12：59</span>
								<span class="nRecord">已关注</span>
								<s class="gougou"></s>
							</div>
						</div>
					</div>
					<div class="p_speci">
						<p class="p_speci_p">潮流</p>
						<p class="p_speci_p">潮流</p>
						<p class="p_speci_p">潮流</p>
						<p class="p_speci_p">商务休闲</p>
						<p class="p_speci_p">青春活力</p>
						<p class="p_speci_p">精致韩风</p>
						<p class="p_speci_p">小清新</p>
					</div>
				</div>
				
				<div class="p_list">
					<div class="p_top">
						<div class="p_top_img">
							<img src="/images/header.png" width="50" height="50">
						</div>
						<div class="p_top_word">
							<div class="p_top_word_name">
								<span class="nName">昵称最多六字<font color="#32A8A8">(备注四字)</font></span>
								<span class="nSex">女</span>
							</div>
							<div class="p_top_word_time">
								<span class="nTime">2014年7月16日 12：59</span>
								<span class="nRecord">已关注</span>
								<s class="gougou"></s>
							</div>
						</div>
					</div>
					<div class="p_speci">
						<p class="p_speci_p">潮流</p>
						<p class="p_speci_p">精致韩风</p>
						<p class="p_speci_p">商务休闲</p>
						<p class="p_speci_p">青春活力</p>
						<p class="p_speci_p">小清新</p>
					</div>
				</div>
				
				<div class="p_list" style="margin-right:0;">
					<div class="p_top">
						<div class="p_top_img">
							<img src="/images/header.png" width="50" height="50">
						</div>
						<div class="p_top_word">
							<div class="p_top_word_name">
								<span class="nName">昵称最多六字<font color="#32A8A8">(备注四字)</font></span>
								<span class="nSex">女</span>
							</div>
							<div class="p_top_word_time">
								<span class="nTime">2014年7月16日 12：59</span>
								<span class="nRecord">已关注</span>
								<s class="gougou"></s>
							</div>
						</div>
					</div>
					<div class="p_speci">
						<p class="p_speci_p">潮流</p>
						<p class="p_speci_p">精致韩风</p>
						<p class="p_speci_p">商务休闲</p>
						<p class="p_speci_p">青春活力</p>
						<p class="p_speci_p">小清新</p>
					</div>
				</div>
=======
				<c:forEach items="fans" var="fan">
>>>>>>> Stashed changes
				
					<div class="p_list">
						<div class="p_top">
							<div class="p_top_img">
								<img src="/images/header.png" width="50" height="50">
							</div>
<<<<<<< Updated upstream
							<div class="p_top_word_time">
								<span class="nTime">2014年7月16日 12：59</span>
								<span class="nRecord">已关注</span>
								<s class="gougou"></s>
=======
							<div class="p_top_word">
								<div class="p_top_word_name">
									<span class="nName">昵称最多六字<font color="#32A8A8">(备注四字)</font></span>
									<span class="nSex">女</span>
								</div>
								<div class="p_top_word_time">
									<span class="nTime">2014年7月16日 12：59</span>
									<span class="nRecord">已关注</span>
								</div>
>>>>>>> Stashed changes
							</div>
						</div>
						<div class="p_speci">
							<p class="p_speci_p">潮流</p>
							<p class="p_speci_p">潮流</p>
							<p class="p_speci_p">潮流</p>
							<p class="p_speci_p">商务休闲</p>
							<p class="p_speci_p">青春活力</p>
							<p class="p_speci_p">精致韩风</p>
							<p class="p_speci_p">小清新</p>
						</div>
						<div class="p_top_word">
							<div class="p_top_word_name">
								<span class="nName">昵称最多六字<font color="#32A8A8">(备注四字)</font></span>
								<span class="nSex">女</span>
							</div>
							<div class="p_top_word_time">
								<span class="nTime">2014年7月16日 12：59</span>
								<span class="nRecord">已关注</span>
								<s class="gougou"></s>
							</div>
						</div>
					</div>
					<div class="p_speci">
						<p class="p_speci_p">潮流</p>
						<p class="p_speci_p">精致韩风</p>
						<p class="p_speci_p">商务休闲</p>
						<p class="p_speci_p">青春活力</p>
						<p class="p_speci_p">小清新</p>
					</div>
				
				</c:forEach>
			</div>
		</div>

		
		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
