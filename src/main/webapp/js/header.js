$(function(){
    /*控制下拉框*/
    function drawIt(target,icon,msg){
        $(target).mouseover(function(){
            $(msg).show();
            $(icon).attr("class","fa fa-angle-up");
        });
        $(target).mouseout(function(){
            $(icon).attr("class","fa fa-angle-down");
            $(msg).hide();
        });
    }
    //调用
    drawIt("#draw","#school","#compus");
    drawIt("#my","","#myMessage");
});