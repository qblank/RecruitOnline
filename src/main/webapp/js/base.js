/**
 * 抽取公用的js
 */



/**
 * 楼层跳跃
 * @returns
 */
function jump(models,liArr){
        var target = 0;
        var leader = 0;
        var timer = null;
        //利用for循绑定索引值
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


/**
 * ajax提交表单
 * @param ele 按钮的id
 * @param target 表单的id
 * @param id 地址
 * @param method 所需做的操作
 * @author evan_qb
 * @returns
 */
function postMsg(ele,target,targetUrl,method){
	$(function(){
		$(ele).click(function(){
			$.ajax({
				url: targetUrl,
				 data: $(target).serialize(),
				type: 'POST',
				success: function(){
					alert("添加成功");
				}
			});
		});
	});
}
