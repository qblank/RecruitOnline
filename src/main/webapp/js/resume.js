/**
 * Created by evan_qb on 2018/1/25.
 */

/**
 * 编辑框切换
 */
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

/*li点击事件*/
$("#btnMenu ul li").click(function(){
    $(this).addClass("current").siblings("li").removeClass("current");
});