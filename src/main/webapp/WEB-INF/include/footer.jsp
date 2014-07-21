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
        	<p><a href="#">下载APP</a><span>  丨  我的微信：<a href="#">爱乐逛、爱乐逛助手</a>  丨  我们的微博：<a href="#">武汉爱乐逛</a>  丨</span><a href="#">关于爱乐逛</a></p>
            <p><span>客服邮箱：<a href="#">kefu@aileguang.com</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>版权所有：<a href="#">武汉谦通科技有限公司</a></span></p>
        </div>
        <div style="float:left; margin:40px 0px;">
        	<img src="images/telephone.png" />
        </div>
    </div>
  </body>
