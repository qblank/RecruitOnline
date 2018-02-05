$(function(){
    /*判断真实姓名*/
    $("#username").blur(function(){
        var username = $("#username").val();
        if (username == null || username == ""){
            $("#real_name").text("2~10个字符");
            $("#real_name").css("color","#FC8E00");
        }else{
            $("#real_name").text("正确");
            $("#real_name").css("color","#59B759");
        }
    });
    /*电话号码*/
    $("#phone").blur(function(){
        var phone = $("#phone").val();
        if (phone == null || phone == ""){
            $("#reg_phoneMsg").text("输入错误");
            $("#reg_phoneMsg").css("color","#FC8E00");
        }else{
            $("#reg_phoneMsg").text("正确");
            $("#reg_phoneMsg").css("color","#59B759");
        }
    });

    /*密码*/
    $("#pwd").blur(function(){
        var pwd = $("#pwd").val();
        if (pwd == null || pwd == ""){
            $("#reg_pwdMsg").text("格式错误");
            $("#reg_pwdMsg").css("color","#FC8E00");
        }else{
            $("#reg_pwdMsg").text("正确");
            $("#reg_pwdMsg").css("color","#59B759");
        }
    });

});