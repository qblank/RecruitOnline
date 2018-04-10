/**
 * Created by evan_qb on 2018/1/28.
 */
$(function(){
    /*左边导航栏*/
    $("#leftNav li a").click(function(){
        $(this).addClass("currSel").parents("li").siblings("li").
            children("a").removeClass("currSel");
    });

    $("#tabNav li").click(function(){
        $(this).addClass("current").siblings("li").removeClass("current");
    });
    
});

/**
 * 账号管理
 * @param e
 * @returns
 */
$(function(){
	/**
	 * 密码验证
	 * @author evan_qb
	 * e  输入框的id
	 * tip 提示框的id
	 * content 内容的id
	 */
	function accountManage(e,tip,content){
		$(e).blur(function(){
			$(tip).fadeIn(500);
			var oldPwdInp = $(e).val();
			if (oldPwdInp.length >= 6 && oldPwdInp.length <= 20) {
				
				
				$("#repPwdInp").blur(function(){
					//判断密码是否一致
					var newPwdInp = $("#newPwdInp").val();
					var rePwdInp = $("#repPwdInp").val();
					if (newPwdInp != rePwdInp ) {
						content = "两次输入的密码不一致";
						console.log("content");
						$("#oldpr").html(content);
						$("#oldpr").css("background","url(images/notice/tips_spirit.jpg) no-repeat scroll 0 4px transparent");
					}else{
						$("#oldpr").html("");
						$("#oldpr").css("background","url(images/notice/tips_spirit.jpg) repeat scroll 0 16px transparent");
					}
				});
				$(tip).html("");
				$(tip).css("background","url(images/notice/tips_spirit.jpg) repeat scroll 0 16px transparent");
				
			}else{
				$(tip).html(content);
				$(tip).css("background","url(images/notice/tips_spirit.jpg) no-repeat scroll 0 4px transparent");
			}
		});
		
		$(e).focus(function(){
			$(tip).fadeOut(1000);
		});
	}
	
	//旧密码
	accountManage($("#oldPwdInp"),$("#oldpw"),"请输入你登陆的密码");
	//新密码
	accountManage($("#newPwdInp"),$("#oldpn"),"密码为6-20位的字母、数字和下划线");
	//重复输入
	accountManage($("#repPwdInp"),$("#oldpr"),"请再次输入密码");
	
	
});


/**
 * ajax提交表单
 * oldpwd
 * newpwd
 * repwd 重复密码
 */
function revisePwd(){
	$(function(){
		$.ajax({
			type: "POST",
			url: "Recruit/user_revisePwd.action",
			dataType: "text",
			data: $("#formC").serialize(),
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			success : function(msg){
				alert(msg);
				$("#formC input").val("");
				$("#formC span").hide();
			},
			error: function(){
				alert("修改失败");
			}
		});
	});
}
