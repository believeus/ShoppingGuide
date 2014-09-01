<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

	<style type="text/css">
		#botto {
			float:left; 
			width:850px; 
			font-size:12px;
			color:#666; 
			margin:40px 0px;
		}
		#botto a:hover{
			color:#056f6f;			
			text-decoration:underline;
		}
		a{
			text-decoration:none;
			color:#666666;
		}
		body{
			margin:0;
			font-size:14px;
			font-family:Microsoft Yahei;
		}
		input[type='button']{
			cursor:pointer;
		}
	</style>
    <div style="width:100%;height:auto; margin:0;overflow:hidden;text-align:center;background:#FFFFFF;">
	    <img src="/images/line.png">
    	<div id="botto">
        	<p><a href="http://admin.aileguang.com/download/DownloadShopUser.html">下载APP</a><span>  丨  我的微信：<a href="http://weixin.qq.com/r/u0P95b7EQeM_rfqG9xap">爱乐逛、爱乐逛助手</a>  丨  我们的微博：<a href="http://weibo.cn/qr/userinfo?uid=5102446126">武汉爱乐逛</a>  丨</span><a href="http://www.aileguang.com">关于爱乐逛</a></p>
            <p><span>客服邮箱：<a href="#">kefu@aileguang.com</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>版权所有：<a href="#">武汉谦通科技有限公司</a></span></p>
            <p>鄂CP备12008896号-3</p>
        </div>
        <div style="float:left; margin:40px 0px;">
        	<img src="images/telephone.png" />
        </div>
    </div>
    
   <!--  <script type="text/javascript">
	//改写alert
	window.alert = function(txt)
	{
		var top = document.documentElement.scrollTop+(document.documentElement.clientHeight+300)/2 +"px";
		var left = document.documentElement.scrollLeft+(document.documentElement.clientWidth)/2 +"px";
		var shield = document.createElement("DIV");
		shield.id = "shield";
		shield.style.position = "absolute";
		shield.style.left = "0px";
		shield.style.top = "0px";
		shield.style.width = "100%";
		shield.style.height = document.body.scrollHeight+"px";
		shield.style.background = "#333";
		shield.style.opacity = "0.5";
		shield.style.textAlign = "center";
		shield.style.zIndex = "10000";
		shield.style.filter = "alpha(opacity=0)";
		var alertFram = document.createElement("DIV");
		alertFram.id="alertFram";
		alertFram.style.position = "absolute";
		alertFram.style.left = left;
		alertFram.style.top = top;
		alertFram.style.marginLeft = "-225px";
		alertFram.style.marginTop = "-75px";
		alertFram.style.width = "450px";
		alertFram.style.height = "150px";
		alertFram.style.background = "#ccc";
		alertFram.style.textAlign = "center";
		alertFram.style.lineHeight = "150px";
		alertFram.style.zIndex = "10001";
		strHtml = "<ul style=\"list-style:none;margin:0px;padding:0px;width:100%\">\n";
		//strHtml += "<li style=\"background:#ccc;text-align:right;font-weight:bold;height:32px;line-height:32px; border:1px solid #ccc;padding-right:15px;\"><a href='javascript:void(0);' onClick='close()'\\>&times;</a></li>";
		strHtml += " <li style=\"background:#fff;text-align:center;font-size:15px;height:120px;line-height:120px;border-left:1px solid #F9CADE;border-right:1px solid #F9CADE;\">"+txt+"</li>\n";
		strHtml += " <li style=\"background:#ccc;text-align:center;font-weight:bold;height:32px;line-height:32px; border:1px solid #ccc;\"><input type=\"button\" value=\"确 定\" onclick=\"doOk()\" /></li>\n";
		strHtml += "</ul>\n";
		alertFram.innerHTML = strHtml;
		document.body.appendChild(alertFram);
		document.body.appendChild(shield);
		var c = 0;
		this.doAlpha = function(){
			if (c++ > 20){clearInterval(ad);return 0;}
			shield.style.filter = "alpha(opacity="+c+");";
		}
		var ad = setInterval("doAlpha()",5);
		this.doOk = function doOk(){
			alertFram.style.display = "none";
			shield.style.display = "none";
		}
		alertFram.focus();
		document.body.onselectstart = function(){return false;};
		function close(){
			alertFram.style.display = "none";
			shield.style.display = "none";
		}
	}

</script> -->
  </body>
