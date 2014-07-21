<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <script src="/js/jquery.js" type="text/javascript"></script>
    <script src="/js/jquery.json.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $("#json").click(function () {

             //数组里的字段的命名和类型要和一般处理程序里定义的类里的变量要一样

             //否则会出问题
                var postdata = new Array();
                postdata[1] = { id: 1, number: "yes" };
                postdata[2] = { id: 2, number: "no" };

 

                var postData = $.toJSON(postdata);  //把数组转换成json字符串

                //将json字符串反序列化，这个只是测试一下数组是否转换成json字符串

                var content = $.parseJSON(postData);
                $.each(content, function () {
                    alert(this.number);
                });

                //post提交并处理

                $.post("json.ashx", { "array": postData }, function (data, status) {
                    if (status == "success") {
                        alert(data);
                    }
                });

            });
        });
    </script>
</head>
<body>
<input type="button" value="json" id="json"/>
</body>
</html>
