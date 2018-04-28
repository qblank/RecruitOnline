<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>招聘会</title>
    <link rel="stylesheet" href="css/jobFair.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/goodinserter/jquery.cxcalendar.css">
    <!--<script src="js/jquery-1.8.2.js"></script>-->
    
    <!-- 引入bootstrapcss -->
   <!--  <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css"> -->
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <!-- <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script> -->
    
</head>
<body>
	<%@include file="./header.jsp" %>

    <div class="jobFairwrap">
        <form action="">
            <div class="search_tab">
                <h3>招聘会</h3>
                <div class="blank"></div>
                <div class="search_box">
                    <!--<label>
                        <input type="button" value="选择日期" class="datePicker" />
                    </label>
                    <span class="line">-</span>-->
                    <div class="search">
	                    <fieldset>
	                        <legend>选择日期和时间</legend>
	                        <label for="date_e">选择日期：</label>
	                        <input id="date_e" name="mydate" type="text" readonly>
	                        <input type="submit" value="搜索" class="search_sub">
	                    </fieldset>
                    </div>
                </div>
            </div>
        </form>
        <div class="jobFairList lh19">
            <ul>
                <li>
                    <div class="weightConpanyName weight">
                        <span>皇家医学院</span>
                    </div>
                    <div class="weight">
                        <span class="weightSchoolName">长沙医学院</span>
                        <span class="weightCity">[长沙]</span>
                    </div>
                    <div class="weightPos font14 gray">
                        <span class="weightAddress" title="雷锋大道">雷锋大道</span>
                        <span class="orangeFont">4</span>人关注
                    </div>
                    <div class="weightHoldTime font14 gray">
                        2018-01-20  15:00-17:00
                    </div>
                    <div class="clearFix">
                        <button class="btn_depart">立即参加</button>
                    </div>
                </li>
                <li>
                    <div class="weightConpanyName weight">
                        <span>皇家医学院</span>
                    </div>
                    <div class="weight">
                        <span class="weightSchoolName">长沙医学院</span>
                        <span class="weightCity">[长沙]</span>
                    </div>
                    <div class="weightPos font14 gray">
                        <span class="weightAddress" title="雷锋大道">雷锋大道</span>
                        <span class="orangeFont">4</span>人关注
                    </div>
                    <div class="weightHoldTime font14 gray">
                        2018-01-20  15:00-17:00
                    </div>
                    <div class="clearFix">
                        <button class="btn_depart">立即参加</button>
                    </div>
                </li>
                <li>
                    <div class="weightConpanyName weight">
                        <span>皇家医学院</span>
                    </div>
                    <div class="weight">
                        <span class="weightSchoolName">长沙医学院</span>
                        <span class="weightCity">[长沙]</span>
                    </div>
                    <div class="weightPos font14 gray">
                        <span class="weightAddress" title="雷锋大道">雷锋大道</span>
                        <span class="orangeFont">4</span>人关注
                    </div>
                    <div class="weightHoldTime font14 gray">
                        2018-01-20  15:00-17:00
                    </div>
                    <div class="clearFix">
                        <button class="btn_depart">立即参加</button>
                    </div>
                </li>
                <li>
                    <div class="weightConpanyName weight">
                        <span>皇家医学院</span>
                    </div>
                    <div class="weight">
                        <span class="weightSchoolName">长沙医学院</span>
                        <span class="weightCity">[长沙]</span>
                    </div>
                    <div class="weightPos font14 gray">
                        <span class="weightAddress" title="雷锋大道">雷锋大道</span>
                        <span class="orangeFont">4</span>人关注
                    </div>
                    <div class="weightHoldTime font14 gray">
                        2018-01-20  15:00-17:00
                    </div>
                    <div class="clearFix">
                        <button class="btn_depart">立即参加</button>
                    </div>
                </li>
            </ul>
        </div>
        
        <!-- 分页 -->
        <!-- <div class="page">
        	<ul class="pagination">
			    <li><a href="#">&laquo;</a></li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li><a href="#">&raquo;</a></li>
			</ul>
        </div> -->
    </div>
    
    
    <%-- <%@include file="./booter.jsp" %> --%>
</body>
<!--<script src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>-->
<script src="js/jquery-1.8.2.js"></script>
<script src="js/goodinserter/jquery.cxcalendar.js"></script>
<script src="js/goodinserter/jquery.cxcalendar.languages.js"></script>
<script>
    // 选择日期和时间
    $('#date_d').cxCalendar({
        type: 'datetime',
        format: 'YYYY-MM-DD HH:mm:ss'
    });

    // 限制可选日期
    $('#date_e').cxCalendar({
       /* wday: 0,
        onday: [1,2,3,4,5],
        // type: 'datetime',
        // format: 'YYYY-MM-DD HH:mm:ss',
        unday: [
            '3',
            '7-5',
            '7-15',
            '7-25',
            '2017-7-10',
            '2017-7-20',
            '2017-7-30'
        ],
        endDate: '2017-08-31'*/
    });
</script>
</html>