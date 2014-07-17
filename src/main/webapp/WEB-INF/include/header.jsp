<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style type="text/css">
	.hello{
		width:auto;
		height:30px;
		color:#056F6F;
	}
	.hello.hover .setting{
		display: block !important;
	}
	.setting{
		width:auto;
		height:100px;
		background:#FFFFFF;
		display:none;
		position: absolute;
	    text-align: center;
	    top: 52px;
	    z-index:999;
	    border:1px solid #e4e4e4;
	}
	.setting a:hover{
		text-decoration:underline;
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
	});
</script>
<div style="height:135px;width:100%;background:#69CDCD;">
   	<div style="width:960px; padding-top:28px; margin-left:auto; margin-right:auto;">
       	<div style="float:left;">
       		<a href="/login.jhtml" title="首页"><img src="/images/Logo_b.png"/></a>
        </div>
       	<div style="float:right; margin-top:40px; font-size:16px; color:#056F6F; line-height:0px;">
           	<a href="javascript:void(0);" class="hello">admin,你好！</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           	<a href="" title="查看消息">消息(0)</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
           	<a href="" title="设置">设置</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
           	<a href="" title="退出">退出</a>
           	<div class="setting">
           		<div style="width:103px;height:33px;line-height:33px;">admin,你好！</div>
           		<div style="width:103px;height:33px;line-height:33px;border-top:1px dotted #ccc;"><a href="/updatePsd.jhtml" title="修改密码">修改密码</a></div>
           		<div style="width:103px;height:33px;line-height:33px;border-top:1px dotted #ccc;"><a href="/aboutUserNum.jhtml" title="关联帐号">关联帐号</a></div>
           	</div>
        </div>
       </div>
</div>
