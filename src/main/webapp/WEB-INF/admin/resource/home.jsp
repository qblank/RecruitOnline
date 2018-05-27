<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
       <link rel="stylesheet" href="resource/css/style.css"/>
       <link rel="stylesheet" href="resource/assets/css/font-awesome.min.css" />
       <link href="resource/assets/css/codemirror.css" rel="stylesheet" />
	<!--[if IE 7]>
	  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
	<![endif]-->
       <!--[if lte IE 8]>
	  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
	<![endif]-->
	<script src="assets/js/ace-extra.min.js"></script>
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
       		<!--[if !IE]> -->
	<script src="resource/assets/js/jquery.min.js"></script>        
	<!-- <![endif]-->
          	<script src="resource/assets/dist/echarts.js"></script>
       <script src="resource/assets/js/bootstrap.min.js"></script>
      <title>无标题文档</title>
</head>
		
<body>
<div class="page-content clearfix">
 <div class="alert alert-block alert-success">
  <button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>
  <i class="icon-ok green"></i>欢迎使用<strong class="green">后台管理系统<small>(测试版)</small></strong>,上次登录时间为<span>${lastLoginTime }<span>，登陆IP:${loginIp}.	
 </div>
 <div class="state-overview clearfix">
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <a href="#" title="网站企业数量">
                              <div class="symbol terques">
                                 <i class="icon-user"></i>
                              </div>
                              <div class="value">
                                  <h1>72</h1>
                                  <p>网站企业</p>
                              </div>
                          </a>
                      </section>
                  </div>
              </div>
             <!--实时交易记录-->
             <div class="clearfix">
             <div class="t_Record">
               <div id="main" style="height:300px; overflow:hidden; width:100%; overflow:auto" ></div>     
              </div> 
         <div class="news_style">
          <div class="title_name">最新消息</div>
          <ul class="list">
           <li><i class="icon-bell red"></i><a href="#">后台系统找那个是开通了。</a></li>
           <li><i class="icon-bell red"></i><a href="#">6月共处理订单3451比，作废为...</a></li>
           <li><i class="icon-bell red"></i><a href="#">后台系统找那个是开通了。</a></li>
           <li><i class="icon-bell red"></i><a href="#">后台系统找那个是开通了。</a></li>
           <li><i class="icon-bell red"></i><a href="#">后台系统找那个是开通了。</a></li>
          </ul>
         </div> 
         </div>
<!-- 获取当前时间 -->
<script type="text/javascript">
	getCurrentTime();

	function getCurrentTime(){
		var curTime = document.getElementById("curTime");
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		
		if(month < 10){
			month = "0" + month;
		}
		var hour = date.getHours();
		if(hour < 10){
			hour = "0" + hour;
		}
		var minute = date.getMinutes();
		if (minute < 10) {
			minute = "0" + minute;
		}
		var second = date.getSeconds();
		if (second < 10) {
			second = "0" + second;
		}
		
		var timeShow = year + "年" + month + "月" + day + "日" + " " + hour + "时" + minute + "分" + second + "秒";
		curTime.innerHTML = timeShow;
	}
	
	setInterval(getCurrentTime,1000);
</script>
 		
        <script type="text/javascript">
             $(document).ready(function(){
                  $(".t_Record").width($(window).width()-320);
                  //当文档窗口发生改变时 触发
            $(window).resize(function(){
                 $(".t_Record").width($(window).width()-320);
                });
         });
	 
	 
        require.config({
            paths: {
                echarts: 'resource/assets/dist'
            }
        });
        require(
            [
                'echarts',
				'echarts/theme/macarons',
                'echarts/chart/line',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
                'echarts/chart/bar'
            ],
            function (ec,theme) {
                var myChart = ec.init(document.getElementById('main'),theme);
               option = {
    title : {
        text: '各大城市工资水平',
        subtext: '实时获取月薪高低'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['IT','金融','医学','销售']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            /*data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']*/
            data : ['北京','上海','广州','深圳','杭州','南京','珠海','长沙','株洲','湘潭','娄底','邵阳']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'IT',
            type:'bar',
            data:[10000, 9380, 8860, 8780, 8380, 8188, 8888, 9320, 6420, 5200,4320 , 3000],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            }           
        },
        {
            name:'金融',
            type:'bar',
            data:[9870, 9080, 8460, 8380, 8180, 8088, 8388, 8320, 6320, 5200,4320 , 3000],
            markPoint : {
                data : [
                    {name : '月最高', value : 1182, xAxis: 7, yAxis: 1182, symbolSize:18},
                    {name : '月最低', value : 23, xAxis: 11, yAxis: 3}
                ]
            },
           
			
        }
		, {
            name:'医学',
            type:'bar',
            data:[12000, 9080, 8460, 8280, 8980, 8988, 8088, 8120, 6220, 5100,4120 , 4000],
            markPoint : {
                data : [
                    {name : '月最高', value : 172, xAxis: 7, yAxis: 172, symbolSize:18},
                    {name : '月最低', value : 23, xAxis: 11, yAxis: 3}
                ]
            },
           
		}
		, {
            name:'销售',
            type:'bar',
            data:[11000, 9280, 8160, 8580, 8380, 8288, 8188, 8220, 6020, 4800,4020 , 4000],
            markPoint : {
                data : [
                    {name : '月最高', value : 1072, xAxis: 7, yAxis: 1072, symbolSize:18},
                    {name : '月最低', value : 22, xAxis: 11, yAxis: 3}
                ]
            },
           
		}
    ]
};
                myChart.setOption(option);
            }
        );
    </script> 
     </div>
</body>
</html>
