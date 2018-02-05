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