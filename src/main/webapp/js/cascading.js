/**
 * 使用方法
 *  前台使用方式
 * var cascade=new Cascade();
   cascade.init("/initProvice.jhtml","parentId","/initCity.jhtml","childId");
   cascade.cascade("childId", "/initArea.jhtml", "areaId");
   cascade.cascade("areaId","/initMarket.jhtml","marketId");
   
   后台返回 1:北京,2:武汉,3:天津
 * */

var Cascade=function(){
	this.init=function(initURL,parentId,changeEvenURL,childId){
		
		$.post(initURL,function(message){
			var datas=message.split(",");
			for (var i = 0; i < datas.length; i++) {
				var data=datas[i].split(":");
				$("#"+parentId).append("<option value=" + data[0] + ">"+data[1]+ "</option>");
			}
		});
		
		$("#"+parentId).change(function(){
			$.post(changeEvenURL,{"id":$(this).val()},function(message){
				$("#"+childId).find("option").remove();
				var datas=message.split(",");
				for (var i = 0; i < datas.length; i++) {
					var data=datas[i].split(":");
					$("#"+childId).append("<option value=" + data[0] + ">"+data[1]+ "</option>");
				}
			});
		});
	}
	
	this.cascade=function(parentId,changeEvenURL,childId){
		$("#"+parentId).change(function(){
			$.post(changeEvenURL,{"id":$(this).val()},function(message){
				if(message==""){
					return;
				}
				$("#"+childId).find("option").remove();
				var datas=message.split(",");
				for (var i = 0; i < datas.length; i++) {
					var data=datas[i].split(":");
					$("#"+childId).append("<option value=" + data[0] + ">"+data[1]+ "</option>");
				}
			});
		});
	}
}