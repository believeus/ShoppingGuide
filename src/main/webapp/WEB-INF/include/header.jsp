<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" import="com.etech.variable.Variables" %>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<link rel="stylesheet" type="text/css" href="/css/easydialog.css">
<style type="text/css">
	h4{
		margin:0;
	}
	.msg{
		float:right; 
		margin-top:40px; 
		font-size:16px; 
		color:#056F6F; 
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
		width:100px;
		height:70px;
		background:#FFFFFF;
		display:none;
		position: relative;
	    text-align: center;
	    /* top: 10px; */
	    right:35px;
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
	input[type='text']{
		width:340px;
	}
	.easyDialog_wrapper .close_btn{
		width: 20px;
		font-size: 25px;
	}
</style>
<script type="text/javascript" src="/js/easydialog.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$(".hello").hover(function(){
			$(".setting").show();
		},function(){
			$(".setting").hide();
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
<script type="text/javascript">
jQuery.fn.placeholder = function(){
	var i = document.createElement('input'),
		placeholdersupport = 'placeholder' in i;
	if(!placeholdersupport){
		var inputs = jQuery(this);
		inputs.each(function(){
			var input = jQuery(this),
				text = input.attr('placeholder'),
				pdl = 0,
				height = input.outerHeight(),
				width = input.outerWidth(),
				placeholder = jQuery('<span class="phTips">'+text+'</span>');
			try{
				pdl = input.css('padding-left').match(/\d*/i)[0] * 1;
			}catch(e){
				pdl = 5;
			}
			placeholder.css({'margin-left': -(width-pdl),'height':height,'line-height':height+"px",'position':'absolute', 'color': "#555555", 'font-size' : "12px"});
			placeholder.click(function(){
				input.focus();
			});
			if(input.val() != ""){
				placeholder.css({display:'none'});
			}else{
				placeholder.css({display:'inline'});
			}
			placeholder.insertAfter(input);
			input.keyup(function(e){
				if(jQuery(this).val() != ""){
					placeholder.css({display:'none'});
				}else{
					placeholder.css({display:'inline'});
				}
			});
		});
	}
	return this;
};
</script>
<div style="height:135px;width:100%;background:#69CDCD;">
   	<div style="width:960px; padding-top:28px; margin-left:auto; margin-right:auto;height:auto;overflow: hidden;">
       	<div style="float:left;">
       		<a href="http://<%=Variables.domainName %>/login.jhtml" title="首页">
	       		<img alt="" src="/images/logo_new.png" width="65" height="65" style="position: absolute;">
	       		<img src="/images/Logo_b.png"/>
       		</a>
        </div>
        <c:if test="${sessionUser != null }">
	       	<div class="msg" style="">
	           	<a href="javascript:void(0);" class="hello" title="设置">
	           		设置
	       		</a>&nbsp;
	           	<!-- <a href="javascript:void(0);" title="查看消息" style="color:#056f6f;" onClick="easyDialog.open({container: {header: '提示',content: '该功能暂不开放，敬请期待！'},overlay: false});">消息(0)</a>&nbsp;|&nbsp; -->
	           	<a href="javascript:void(0);" title="查看消息" style="color:#056f6f;" >消息(0)</a>&nbsp;|&nbsp;
	           	<a href="http://<%=Variables.domainName %>/logout.jhtml" title="退出" style="color:#056f6f;">退出</a>&nbsp;|
	           	<a href="http://<%=Variables.domainName %>/menu.jhtml" style="color:#056f6f;" title="首页">首页</a>
		           	<div class="setting">
		           		<!-- <div style="width:103px;height:33px;line-height:33px;" title="设置">设置</div> -->
		           		
		           		<div style="width:103px;height:33px;line-height:33px;border-top:1px dotted #ccc;">
		           			<a href="http://<%=Variables.domainName %>/updatePsd.jhtml" title="修改密码" style="color:#056f6f;">修改密码</a>
		          		</div>
		           		<div style="width:103px;height:33px;line-height:33px;border-top:1px dotted #ccc;">
		           			<a href="http://<%=Variables.domainName %>/aboutUserNum.jhtml" title="关联帐号" style="color:#056f6f;">关联帐号</a>
		       			</div>
		           	</div>
	        </div>
        </c:if>
       </div>
</div>
<!-- IE7兼容性 -->
<!--[if IE 7]> 
	<script type="text/javascript">
		//alert("IE7");
		$().ready(function(){
			$(".setting").css("top","0px");
			$(".pageSize").css({"margin-left":"-74px","margin-top":"30px"});
		});
		
	</script>
	
<![endif]-->