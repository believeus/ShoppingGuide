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

<title>浏览记录</title>

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
			height:auto;
			float:left;
			margin-right:47px;
			margin-bottom:30px;
			border:1px solid #69CDCD;
			border-radius:4px;
			margin-top:20px;
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
			height:auto;
			width:281px;
			padding:10px;
			overflow:hidden;
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
	</style>

<script type="text/javascript">
	$().ready(function(){
		/* $("[id=note]").click(function(){
			$input=$(this).parent().prev();
			$input.css("display","");
			$input.prev().css("display","none");
			$input.focus();
			
			$input.blur(function(){
				var nickName=$input.val();
				var phoneUserId=$(this).prev().prev().val();
				
				$.post("/changeNote.jhtml",{"nickName":nickName,"phoneUserId":phoneUserId});
				var url = "/hitCount.jhtml?goodsId="+${goodsId};
				location.replace(url);
			});
		}); */
		
		$("[id=note]").click(function(){
			$input=$(this).parent().prev();
			$input.css("display","");
			$input.prev().css("display","none");
			var fo=$input.val();
			$input.val("").focus().val(fo);
			
			$input.blur(function(){
				var nickName=$(this).val();
				var phoneUserId=$(this).prev().prev().val();
				$.post(	"/changeNote.jhtml",
						{"nickName":nickName,"phoneUserId":phoneUserId},
						function(data){
							//$("#changeNick").html(data.user.nickName);
							var url = "/hitCount.jhtml?goodsId="+${goodsId};
							location.replace(url);
						},
						"json");
			});
		});
	});	
		
</script>

</head>
<body>
	
		 <!-- 引用尾部页面 -->
   		 <jsp:include page="../include/header.jsp" flush="true" />
		
		<div id="main" style="">
			<table class="main_table1">
				<tr style="">
					<td style="width:15%;"><p style="font-size:24px;color:#69CDCD;">浏览记录</p></td>
					<td style="width:56%;"></td>
				</tr>
			</table>			
			
			<div class="p_main" style="">
			<img src="/images/line.png">
				<c:forEach items="${tphoneusers }" varStatus="state" var="puser">
					<div class="p_list" style="">
						<div class="p_top">
							<div class="p_top_img">
								<img src="/images/header.png" width="50" height="50">
							</div>
							<div class="p_top_word">
								<div class="p_top_word_name">
									<span class="nName">
									<c:if test="${puser.nickName == ''}">
										<input type="hidden" value="${puser.phoneUserId }" />
										<span id="nickName">
											<a id="changeNick">${puser.userName }</a>
										</span>
										<input id="nickNameInput" maxlength="11" type="text" style="display:none;width:100px;" value='${puser.userName }' />
										<font color="#32A8A8"><a id="note" style="cursor: pointer;">(添加备注)</a></font>
									</c:if>
									<c:if test="${puser.nickName != ''}">
										<input type="hidden" value="${puser.phoneUserId }" />
										<span id="nickName">
											<a id="changeNick">${puser.nickName }</a>
										</span>
										<input id="nickNameInput" maxlength="11" type="text" style="display:none;width:100px;" value='${puser.nickName }' />
										<font color="#32A8A8"><a id="note" style="cursor: pointer;">(修改备注)</a></font>
									</c:if>
									</span>
									<span class="nSex">${puser.gender }</span>
								</div>
								<div class="p_top_word_time">
									<span class="nTime">${puser.addTime }</span>
									<span class="nRecord"></span>
								</div>
							</div>
						</div>
						
						<div class="p_speci">
							<c:forEach items="${featurelist1}" var="feature" begin="${state.index }" end="${state.index }" >
									<c:forEach items="${feature}" var="fe" varStatus="status">
										<c:if test="${status.index %4 ==0 }">
											<p class="p_speci_p" style="background:#0BB5D9;color:#FFFFFF;">${fe}</p>
										</c:if>
										<c:if test="${status.index %4 ==1 }">
											<p class="p_speci_p" style="background:#49BF85;color:#FFFFFF;">${fe}</p>
										</c:if>
										<c:if test="${status.index %4 ==2 }">
											<p class="p_speci_p" style="background:#E36B77;color:#FFFFFF;">${fe}</p>
										</c:if>
										<c:if test="${status.index %4 ==3 }">
											<p class="p_speci_p" style="background:#F8B95A;color:#FFFFFF;">${fe}</p>
										</c:if>
									</c:forEach>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
			
			<div class="p_main" style="float:left;padding:10px 15px;">
				<c:forEach items="${phoneuser2 }" varStatus="state" var="phuser">
					<div class="p_list" style="clear:both;">
						<div class="p_top">
							<div class="p_top_img">
								<img src="/images/header.png" width="50" height="50">
							</div>
							<div class="p_top_word">
								<div class="p_top_word_name">
									<span class="nName">
									<c:if test="${phuser.nickName == ''}">
										<input type="hidden" value="${phuser.phoneUserId }" />
										<span id="nickName">
											<a id="changeNick">${phuser.userName }</a>
										</span>
										<input id="nickNameInput" maxlength="11" type="text" style="display:none;width:100px;" value='${phuser.userName }' />
										<font color="#32A8A8"><a id="note" style="cursor: pointer;">(添加备注)</a></font>
									</c:if>
									<c:if test="${phuser.nickName != ''}">
										<input type="hidden" value="${phuser.phoneUserId }" />
										<span id="nickName">
											<a id="changeNick">${phuser.nickName }</a>
										</span>
										<input id="nickNameInput" maxlength="11" type="text" style="display:none;width:100px;" value='${phuser.nickName }' />
										<font color="#32A8A8"><a id="note" style="cursor: pointer;">(修改备注)</a></font>
									</c:if>
									</span>
									<span class="nSex">${phuser.gender }</span>
								</div>
								<div class="p_top_word_time">
									<span class="nTime">${phuser.addTime }</span>
									<span class="nRecord"></span>
								</div>
							</div>
						</div>
						
						<div class="p_speci">
							<c:forEach items="${featurelist2}" var="feature" begin="${state.index }" end="${state.index }" >
									<c:forEach items="${feature}" var="fe">
										<p class="p_speci_p">${fe}</p>
									</c:forEach>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
			
			<div class="p_main" style="float:left;padding:10px 15px;">
				<c:forEach items="${phoneuser3 }" varStatus="state" var="phouser">
					<div class="p_list" style="clear:both;">
						<div class="p_top">
							<div class="p_top_img">
								<img src="/images/header.png" width="50" height="50">
							</div>
							<div class="p_top_word">
								<div class="p_top_word_name">
									<span class="nName">
									<c:if test="${phouser.nickName == ''}">
										<input type="hidden" value="${phouser.phoneUserId }" />
										<span id="nickName">
											<a id="changeNick">${phouser.userName }</a>
										</span>
										<input id="nickNameInput" maxlength="11" type="text" style="display:none;width:100px;" value='${phouser.userName }' />
										<font color="#32A8A8"><a id="note" style="cursor: pointer;">(添加备注)</a></font>
									</c:if>
									<c:if test="${phouser.nickName != ''}">
										<input type="hidden" value="${phouser.phoneUserId }" />
										<span id="nickName">
											<a id="changeNick">${phouser.nickName }</a>
										</span>
										<input id="nickNameInput" maxlength="11" type="text" style="display:none;width:100px;" value='${phouser.nickName }' />
										<font color="#32A8A8"><a id="note" style="cursor: pointer;">(修改备注)</a></font>
									</c:if>
									</span>
									<span class="nSex">${phouser.gender }</span>
								</div>
								<div class="p_top_word_time">
									<span class="nTime">${phouser.addTime }</span>
									<span class="nRecord"></span>
								</div>
							</div>
						</div>
						
						<div class="p_speci">
							<c:forEach items="${featurelist3}" var="feature" begin="${state.index }" end="${state.index }" >
									<c:forEach items="${feature}" var="fe" varStatus="status">
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
