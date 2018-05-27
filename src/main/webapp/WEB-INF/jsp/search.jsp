<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>底部</title>
    <link rel="stylesheet" href="css/search.css">
</head>
<body>
    <div class="search_bg">
        <div class="job_num">
            <span><a href="#" class="pos">校园招聘在线职位</a></span>
            <ul>
                <li>4</li>
                <li>3</li>
                <li>2</li>
                <li>1</li>
            </ul>
        </div>
        <!-- 搜索框 -->
        <div class="sc_input">
            <button class="search" id="search">搜索</button>
            <input type="text" class="search_input" id="search_input" placeholder="请输入公司名或者职位">
        </div>
    </div>
</body>
<script type="text/javascript">
	var searchBtn = document.getElementById("search");
	var search_input = document.getElementById("search_input");
	//点击搜索
	searchBtn.onclick = function(){
		window.location.href = "job_searchPage.action?searchName=" + search_input.value;
	}
	//按下enter键
	search_input.onkeydown = function(e){
		if(e.keyCode == 13){
			window.location.href = "job_searchPage.action?searchName=" + search_input.value;
		}
	}
</script>
</html>