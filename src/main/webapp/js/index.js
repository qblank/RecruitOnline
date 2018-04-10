/**
 * Created by evan_qb on 2018/1/17.
 */
/*工学*/
var technology = ["力学类","机械类","材料",
    "仪器仪表类","能源动力","电气信息类",
    "电子信息学","计算机科学与技术","土建类","水利类","测绘类",
    "化工类","地矿类"];
/*理工学*/
var ligong = ["数学","物理学","天文学类","地理科学类",
"大气科学类","地球物理学类","海洋科学类","地质学",
    "生物科学","生命科学","心理学"];
/*农学*/
var agriculture = ["农业","植物学类","动物生态学","动物医学类","草业科学类","森林资源类"]
/*医学*/
var csmu = ["药学","医学","公共卫生学类"];
/*法学*/
var law = ["法学","公安学类","社会学类"];
/*其他*/
var others = ["历史学","艺术学","教育学","体育学类"];
$(function(){
    /**
     * 导航栏添加a标签
     */
    function appendA(ele){
        for(var i = 0;i<ele.length;i++){
            $(".detail_all").append("<a href='#'>" + ele[i] +"</a>");
        }
    }
    /**
     * 添加数据到导航中
     */
    function append(curText){
        $(".detail_all").empty();
        //var curText = ele.text();
        $("#detail").show();
        $(".detail_title").html(curText);
        if (curText != null || curText != " "){
            switch (curText){
                case "工学":
                    appendA(technology);
                    break;
                case "理学":
                    appendA(ligong);
                    break;
                case "农学":
                    appendA(agriculture);
                    break;
                case "医学":
                    appendA(csmu);
                    break;
                case "法学":
                    appendA(law);
                    break;
                case "其他":
                    appendA(others);
                    break;
            }
        }
    }
    initColor();
    /**
     * 控制导航的颜色
     */
    function initColor(){
        var colors = ["#BC7219","#A05C2E",
            "#6BCAF9","#39B0FA",
            "#D8644A","#CF4024",
            "#2FA8F4","#5066E9",
            "#E3C31C","#F0A829",
            "#B87FCF","#9C5CC2",
            "#8DDF34","#6AC936"];

        //获取所有的盒子
        var pros = document.getElementsByClassName("pro_nav");
        for(var i = 0;i < pros.length;i++){
            pros[i].style.backgroundImage = "linear-gradient(to right,"+ colors[2*i] +"," + colors[2*i+1] +")";
        }
    }
    //获取li当前的值
    var curText;
    //获取所有a标签
    $("#left_nav li").mouseover(function(){
        curText = $(this).text();
        append(curText);
    });
    $("#detail").mouseover(function(){
        append(curText);
    });
    $("#detail").mouseover(function(){
        append(curText);
        $("#detail").show();
    });
    $("#left_nav li").mouseout(function () {
        $("#detail").hide();
        //$("#detail .detail_all").children("a").remove();
        $(".detail_all").empty();
    });

    $("#detail").mouseout(function(){
        $("#detail").hide();
    });

    /***实现楼层跳跃***/
    //获取所有模块
    function jump(){
        var models = document.getElementsByClassName("model");
        //获取li
        var ul = document.getElementById("lefts_nav");
        var liArr = ul.getElementsByTagName("li");
        console.log(liArr.length);
        var target = 0;
        var leader = 0;
        var timer = null;
        //利用for循环给两个数组的元素上色
        for(var i=0;i<liArr.length;i++){
            //属性绑定索引值
            liArr[i].index = i;
            //2.老三步。(并绑定事件)循环绑定，为每一个li绑定点击事件
            liArr[i].onclick = function () {
                //获取索引值。
                target = models[this.index].offsetTop;
                //要用定时器，先清除定时器
                clearInterval(timer);
                //利用缓动动画原理实现屏幕滑动
                timer = setInterval(function () {
                    //获取步长
                    var step = (target-leader)/10;
                    //判断步长是否为负值，如果是，向下取整，否则，向上取整
                    step = step>0?Math.ceil(step):Math.floor(step);
                    //屏幕滑动
                    leader = leader + step;
                    window.scrollTo(0,leader);
                    //清除定时器
                    if(Math.abs(target-leader)<=Math.abs(step)){
                        window.scrollTo(0,target);
                        clearInterval(timer);
                    }
                },50);
            }
        }
    }

    //用scroll事件模拟盒子距离最顶端的距离。
    window.onscroll = function () {
        //每次屏幕滑动，把屏幕卷去的头部赋值给leader,模拟获取显示区域距离顶部的距离
        leader = scroll().top;
    }

    function scroll() {  // 开始封装自己的scrollTop
        return {
            "top": window.pageYOffset || document.body.scrollTop || document.documentElement.scrollTop,
            "left":  window.pageXOffset || document.body.scrollLeft || document.documentElement.scrollLeft
        }
    }

    jump();
});