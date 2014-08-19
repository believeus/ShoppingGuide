<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style type="text/css">
	.msg{
		float:right; 
		margin-top:40px; 
		font-size:16px; 
		color:#056F6F; 
		line-height:0px;
	}
	.hello{
		width:auto;
		height:30px;
		color:#056F6F;
	}
	.msg a:hover{
		text-decoration:underline;
	}
	.setting{
		width:auto;
		height:100px;
		background:#FFFFFF;
		display:none;
		position: absolute;
	    text-align: center;
	    top: 52px;
	    right:370px;
	    z-index:999;
	    border:1px solid #e4e4e4;
	    padding:0 5px;
	}
	.setting a:hover{
		text-decoration:underline;
	}
	input[type='button']{
		border:none;
		width:auto;
		height:32px;
		background-color:#69CDCD;
		border-radius:.2em;
		color:white;
		cursor:pointer;
	}
</style>
<script type="text/javascript">
	$().ready(function(){
		$(".hello").hover(function(){
			$(".setting").show();	
		});
		$(".setting").mouseout(function(){
			$(".setting").hide();			
		}).mouseover(function(){
			$(".setting").show();	
		});
		
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		var IE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !userAgent.indexOf("Opera") > -1;
		if(IE){
		   	//alert("我是IE浏览器");
			$("img").css("border","0");
		}
		
	});
</script>
<div style="height:135px;width:100%;background:#69CDCD;">
   	<div style="width:960px; padding-top:28px; margin-left:auto; margin-right:auto;">
       	<div style="float:left;">
       		<a href="/login.jhtml" title="首页"><img src="/images/Logo_b.png"/></a>
        </div>
        <c:if test="${sessionUser != null }">
       	<div class="msg" style="">
           	<a href="javascript:void(0);" class="hello" title="${sessionUser.nickName}">
           		${fn:substring(sessionUser.nickName, 0, 6)}
       		</a>&nbsp;&nbsp;&nbsp;,你好！
           	<a href="" title="查看消息" style="color:#056f6f;">消息(q)</a>&nbsp;|&nbsp;
           	<a href="/logout.jhtml" title="退出" style="color:#056f6f;">退出</a>|
           	<a href="/menu.jhtml" style="color:#056f6f;" title="首页">首页</a>
	           	<div class="setting">
	           		<div style="width:103px;height:33px;line-height:33px;" title="${sessionUser.nickName}">${fn:substring(sessionUser.nickName, 0, 6)}</div>
	           		
	           		<div style="width:103px;height:33px;line-height:33px;border-top:1px dotted #ccc;">
	           			<a href="/updatePsd.jhtml" title="修改密码" style="color:#056f6f;">修改密码</a>
	          		</div>
	           		<div style="width:103px;height:33px;line-height:33px;border-top:1px dotted #ccc;">
	           			<a href="/aboutUserNum.jhtml" title="关联帐号" style="color:#056f6f;">关联帐号</a>
	       			</div>
	           	</div>
        </div>
        </c:if>
       </div>
</div>
