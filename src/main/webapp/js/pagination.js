/**
 * 分页
 */
$().ready(function(){
	
	var $listForm = $("#listForm");
	var $pageNumber = $("#pageNumber");
	
	//页码跳转
	$.pageSkip = function(pageNumber) {
		$pageNumber.val(pageNumber);
		$listForm.submit();
		return false;
	};
	
	
});