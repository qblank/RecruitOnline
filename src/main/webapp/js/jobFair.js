//分页
$(function(){
	//页面数字点击事件
	$(".jobFairwrap .page .pagination li .num").click(function(){
		$(this).addClass("current").parent().siblings("li").children(".num").removeClass("current");
	});
	
	var index = 0;
	//下一页
	$("#nextPage").click(function(){
		var page = $(".current").text();
		index = page - 1;
		console.log(index);
		if (index < $(".jobFairwrap .page .pagination li .num").length - 1) {
			index++;
			$(".jobFairwrap .page .pagination li .num").eq(index).addClass("current").parent().siblings("li").children(".num").removeClass("current");
		}else{
			alert("已经是最后一页了");
		}
	});
	
	//上一页
	$("#lastPage").click(function(){
		var page = $(".current").text();
		index = page - 1;
		if (index > 0) {
			index--;
			$(".jobFairwrap .page .pagination li .num").eq(index).addClass("current").parent().siblings("li").children(".num").removeClass("current");
		}else{
			alert("已经是第一页了");
		}
		
	});
});