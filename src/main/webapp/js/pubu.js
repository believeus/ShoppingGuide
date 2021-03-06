/**
 *	作者：微笑
 *	QQ：904835003
 *	邮箱：904835003@qq.com
 *	支持原创、关注JquerySchool网站
 *	http://www.jq-school.com
 *	编写时间：2013-02-25
 */
$(window).load(function(){
    var data = [{"src":"/images/3.jpg"},{"src":"/images/4.jpg"},{"src":"/images/5.jpg"},{"src":"/images/6.jpg"},{"src":"/images/7.jpg"},{"src":"/images/8.jpg"},{"src":"/images/9.jpg"},{"src":"/images/10.jpg"}];
    PBL("#pubu",".pro_list",2);
    var ajaxkey = true;//设置ajax请求的开关,如需动态加载、需要打开这个开关
    $(window).scroll(function(){
        if (getDataCheck() && ajaxkey) {
            var pubu = $("#pubu");
            for(i in data){
                var box = $("<div class='pro_list'><div class='pro_img'><img src="+data[i].src+"  width='220'></div><div class='pro_name'></div><div class='pro_spec'></div><div class='pro_dis'></div><div class='pro_hit'></div></div>");
                pubu.append(box);
            }
            PBL("#pubu",".pro_list",2);
            //getData（"#pubu",".pro_list"）；//jquery的Ajax异步加载数据、需要从数据库加载的、需要调用该函数
        };
    });

});
/************************************************* ↓ 函数 ↓ */
//瀑布流主函数
function PBL(outer,boxs,style){//outer父级元素、boxs子级元素，style加载样式（ 1或者2 ）
    var pubu = $(outer);
    var box = $(boxs);
    var num = Math.floor($(document.body).width()/box.outerWidth());//根据浏览器宽度获得显示的列的数量
    //alert($(document.body).width()+"=width="+box.outerWidth());
    pubu.width(num*(box.outerWidth()));//给pubu的宽度赋值
    var allHeight = [];//定义一个数组存储所有列的高度
    for(var i=0;i<box.length;i++){
        if (i<num) {
            allHeight[i]=box.eq(i).outerHeight();
        }else{
            var minHeight = Math.min.apply({},allHeight);//获得所有的列中高度最小的列的高度
            var sy = getSy(minHeight,allHeight);//获取高度最小的列的索引
            getStyle(box.eq(i),minHeight,sy*box.eq(i).outerWidth(),i,style);
            allHeight[sy] += box.eq(i).outerHeight();
        }
    }
}
//获取高度最小的列的索引
function getSy(minH,allH){
    for(sy in allH){
        if(allH[sy]==minH) return sy;
    }
}
//请求数据的方法
function getData(){
    ajaxkey = false;
    $.ajax({
        type:"get",//设置get请求方式
        url:"request.php",//设置请求的脚本地址
        data:"",//设置请求的数据
        dataType:"json",//设置请求返回的数据格式
        success:function(data){
            var pubu = $();
            for(i in data){
                var box = $("<div class='box'><div class='pic'><img src="+data[i].src+"></div></div>");
                pubu.append(box);
            }
            PBL("#pubu",".pro_list",2);
        },
        complete:function(){
            ajaxkey = true;
        }
    });
}
//判断请求数据的开关
function getDataCheck(){
  //  var pubu = $("#pubu");
    var box = $(".pro_list");
    var lastboxHeight = $(box[box.length-1]).offset().top+Math.floor($(box[box.length-1]).outerHeight()/2);
    var documentHeight = $(window).height();
    var scrollTop = $(document).scrollTop();
    return lastboxHeight<documentHeight+scrollTop?true:false;
}
//存储开始请求数据条数的位置
var getStartNum = 0;
//设置请求数据加载的样式
function getStyle(boxs,top,left,index,style){
    if (getStartNum>=index) {
        return;
    }
    boxs.css("position","absolute");
    switch(style){
        case 1:
            boxs.css({
                "top":top+$(window).height(),
                "left":left
            });
            boxs.stop().animate({
                "top":top,
                "left":left
            },999);
        break;
        case 2:
            boxs.css({
                "top":top,
                "left":left,
                "opacity":"0"
            });
            boxs.stop().animate({
                "opacity":"1"
            },999);
    }
    getStartNum = index;//更新请求数据的条数位置
}