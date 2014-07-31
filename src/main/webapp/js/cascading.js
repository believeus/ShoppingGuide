/**
 * 使用方法
 *  前台使用方式
 *
   <script type="text/javascript">
	  $(function(){
			var cascade=new Cascade();
			// init 第一个参数为url,第二个参数为select的id,将后台返回 1:北京,2:武汉,3:天津 放入 provinceId中
			cascade.init("/initProvice.jhtml","provinceId");
			// provinceId 省selectId  /initCity.jhtml返回的市 1:钱江 2:武汉 放入 selectId是cityId中
			cascade.changeCascade("provinceId","/initCity.jhtml","cityId");
		    cascade.changeCascade("cityId", "/initArea.jhtml", "areaId");
		    cascade.changeCascade("areaId","/initMarket.jhtml","marketId");
	  });
    </script>
	<select id="provinceId"></select>
	<select id="cityId"></select>
	<select id="areaId"></select>
	<select id="marketId" name="marketId"></select>
   
   后台返回  1:北京,2:武汉,3:天津 即可
 * */

var Cascade=function(){
	this.init=function(initURL,parentId){
		
		$.post(initURL,function(message){
			var datas=message.split(",");
			for (var i = 0; i < datas.length; i++) {
				var data=datas[i].split(":");
				$("#"+parentId).append("<option value=" + data[0] + ">"+data[1]+ "</option>");
			}
		});
	};
	
	this.changeCascade=function(parentId,changeEvenURL,childId){
		$("#"+parentId).bind("change",function(){
			$.post(changeEvenURL,{"id":$(this).val()},function(message){
				$("#"+parentId).nextAll().find("option").remove();
				if(message=="")return;
				var datas=message.split(",");
				for (var i = 0; i < datas.length; i++) {
					var data=datas[i].split(":");
					$("#"+childId).append("<option value=" + data[0] + ">"+data[1]+ "</option>");
				}
			});
		});
	};
};