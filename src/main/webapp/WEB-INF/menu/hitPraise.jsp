<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>点赞记录</title>

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
			margin-right:30px;
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
			
		}
		.p_speci_p{
		    cursor: pointer;
		    display: block;
		    float: left;
		    font-size: 13px;
		    height: 20px;
		    margin-right: 15px;
		    padding: 3px 15px;
		    width: auto;
		    background:#EFEFEF;
		    color:#B3B3B3;
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
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">点赞记录</p></td>
					<td style="width:56%;"></td>
				</tr>
			</table>			
			<hr style="width:85%;border:1px solid #E8E8E8;" />
			
			<div class="p_main">
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
			</div>
			
		</div>

		<hr style="width:85%;border:1px solid #E8E8E8;" />
		
		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
