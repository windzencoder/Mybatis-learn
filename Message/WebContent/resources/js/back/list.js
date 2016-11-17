/*
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	//alert("test");
	$("#mainForm").attr("action", basePath + "/DeleteBatch.action");
	$("#mainForm").submit();
}

$(function() {

	//alert("test");

})

