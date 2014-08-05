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

<title>我的粉丝</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
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
		
		$("[id=note]").click(function(){
			$input=$(this).parent().prev();
			$input.css("display","");
			$input.prev().css("display","none");
			$input.focus();
			
			$input.blur(function(){
				var nickName=$input.val();
				var phoneUserId=$(this).prev().prev().val();
				
				$.post("toChangeNote.jhtml",
						{"nickName":nickName,"phoneUserId":phoneUserId});
				location.replace("/showFans.jhtml");
			});
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
	   			<a href="/myFans.jhtml" title="我的粉丝">我的粉丝</a>
			</p>
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
				<c:forEach items="${fans }" varStatus="state" var="fan">
					<div class="p_list">
						<div class="p_top">
							<div class="p_top_img">
								<img src="/images/header.png" width="50" height="50">
							</div>
							<div class="p_top_word">
								<div class="p_top_word_name">
									<span class="nName">
									<c:if test="${fan.nickName == ''}">
										<input type="hidden" value="${fan.phoneUserId }" />
										<span id="nickName">
											<a id="changeNick">${fan.userName }</a>
										</span>
										<input id="nickNameInput" maxlength="11" type="text" style="display:none;width:100px;" value='${fan.userName }' />
										<font color="#32A8A8"><a id="note" style="cursor: pointer;">(添加备注)</a></font>
									</c:if>
									<c:if test="${fan.nickName != ''}">
										<input type="hidden" value="${fan.phoneUserId }" />
										<span id="nickName">
											<a id="changeNick">${fan.nickName }</a>
										</span>
										<input id="nickNameInput" maxlength="11" type="text" style="display:none;width:100px;" value='${fan.nickName }' />
										<font color="#32A8A8"><a id="note" style="cursor: pointer;">(修改备注)</a></font>
									</c:if>
									</span>
									<span class="nSex">${fan.gender }</span>
								</div>
								<div class="p_top_word_time">
									<span class="nTime">${fan.addTime }</span>
									<span class="nRecord"></span>
								</div>
							</div>
						</div>
						
						<div class="p_speci">
							<c:forEach items="${featurelist}" var="feature" begin="${state.index }" end="${state.index }" >
									<c:forEach items="${feature}" var="fe">
										<p class="p_speci_p">${fe}</p>
									</c:forEach>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		
		 <!-- 引用尾部页面 -->
   	 	<jsp:include page="../include/footer.jsp" flush="true" />
</body>
</html>
