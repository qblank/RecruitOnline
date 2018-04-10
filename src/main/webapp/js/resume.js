/**
 * Created by evan_qb on 2018/1/25.
 */

/**
 * 编辑框切换
 */
$(function(){
	function toggle(ele){
	    if ($(ele).css("display") === "none"){
	        $(ele).slideDown();
	    }else{
	        $(ele).slideUp();
	    }
	}
	$('#person_edit').click(function(){
	    toggle('#person_info');
	});
	$('#contact_edit').click(function(){
	    toggle('#contact');
	});
	$(".btnCancel").click(function(){
		toggle(ele)
	});
	/*li点击事件*/
	$("#btnMenu ul li").click(function(){
	    $(this).addClass("current").siblings("li").removeClass("current");
	});
	
	//使用ajax提交请求(个人信息)
	$("#personInfo").click(function(){
		alert("添加成功");
		$.ajax({
			url: '/Recruit/resume_addPersonInfo.action',
			 data: $('#personForm').serialize(),
			type: 'POST'
		});
		
	});
	
	//给取消按钮添加点击事件
	$("#btnCancel").click(function(){
		 toggle('#person_info');
	});
	
});