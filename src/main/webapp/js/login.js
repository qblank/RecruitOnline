/**
 * Created by evan_qb on 2018/1/18.
 */

/*用户名/密码是格式验证*/
$(function(){

    $("#phone").blur(function(){
        console.log(phone+"1");
        if ($("#phone").val() == null || $("#phone").val() == ""){
            $("#phoneMsg").text("登录名不能为空");
        }else{
            $("#phoneMsg").css("color","green");
            $("#phoneMsg").html("正确");
        }
    });

    $("#phone").focus(function(){
        $("#phoneMsg").text("");
    });

    $("#pwd").focus(function(){
        $("#pwdMsg").text("");
    });

    $("#pwd").blur(function(){
        if ($("#pwd").val() == null || $("#pwd").val() == ""){
            $("#pwdMsg").html("密码不能为空");
        }else{
            $("#pwdMsg").css("color","green");
            $("#pwdMsg").html("正确");
        }
    });

    $("#login_wrap").fadeIn(2000);
});
