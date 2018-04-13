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
	$("#posTarget_edit").click(function(){
		toggle("#posTarget");
	});
	$("#graduate_edit").click(function(){
		toggle("#graduate");
	});
	$(".btnCancel").click(function(){
		$(".tabMain").slideUp();
	});
	/*li点击事件*/
	$("#btnMenu ul li").click(function(){
	    $(this).addClass("current").siblings("li").removeClass("current");
	});
	
	//个人联系
	postMsg($("#personInfo"),$('#personForm'),1);
	//联系方式
	postMsg($("#contactInfo"),$("#contactForm"),2);
	postMsg($("#graduateInfo"),$("#graduateForm"),3);
	postMsg($("#posTargetInfo"),$("#posTargetForm"),4);
	
	//给取消按钮添加点击事件
	$("#btnCancel").click(function(){
		 toggle('#person_info');
	});
	
});


/**
 * ajax提交表单
 * @param ele 按钮的id
 * @param target 表单的id
 * @param id 地址
 * @returns
 */
function postMsg(ele,target,id){
	$(function(){
		$(ele).click(function(){
			$.ajax({
				url: '/Recruit/resume_addPersonInfo.action?id=' + id,
				 data: $(target).serialize(),
				type: 'POST',
				success: function(){
					alert("添加成功");
				}
			});
		});
	});
}



//调用楼层跳跃进行跳转
(function(){
	var tabWraps = document.getElementsByClassName("tabWrap");
	var ul = document.getElementById("btnMenu");
	var liArr = ul.getElementsByTagName("li");
	jump(tabWraps,liArr);
})();


