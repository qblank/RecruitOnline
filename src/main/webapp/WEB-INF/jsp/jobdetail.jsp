<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>公司详情页</title>
    <link rel="stylesheet" href="css/jobdetail.css">
    <link rel="stylesheet" href="css/base.css">
    <script type="text/javascript" src="js/jobdetail.js"></script>
</head>
<body>
	<%@include file="./header.jsp" %>
    <div class="jobtetail_wrap">
        <div class="jobdetailInfowrap">
            <h4>${position.pname}</h4>
            <ul>
                <li class="cJobDetailTit">来&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;自:</li>
                <li class="marb">校园招聘网</li>
                <li class="cJobDetailTit">公司行业:</li>
                <li class="marb">${firm.industry }</li>
                <li class="cJobDetailTit">公司规模:</li>
                <li class="marb">${firm.fnum}</li>
                <li class="cJobDetailTit">公司类型:</li>
                <li class="marb">${firm.fcate}</li>
            </ul>

            <ul>
                <li class="cJobDetailTit">公司地点:</li>
                <li class="marb">${firm.fsite}</li>
                <li class="cJobDetailTit">职位类型:</li>
                <li class="marb">系统测试</li>
                <li class="cJobDetailTit">招聘人数:</li>
                <li class="marb">${position.pnum}</li>
                <li class="cJobDetailTit">发布时间:</li>
                <li class="marb">
                	<fmt:formatDate value="${position.pubdate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </li>
            </ul>
        </div>
        <button class="postjob" id="postjob">立刻投递</button>
        <div class="jobdetailtab">
            <ul>
                <li><a href="#">职位描述</a></li>
            </ul>
        </div>
        <div class="jobtetailtabdesc">
            <p>
                工作地点：${firm.fsite}
                <br><br>
                职位要求：
                <br><br>
                ${position.prequire}
            </p>
          <br/><br/>
            <p>
                 职位描述:
              <br/><br/>
              ${position.pdesc }
            </p>
            
             <p>
                 职责:
              <br/><br/>
              ${position.pduty }
            </p>
            <!-- 准备在这儿加上公司的职位 -->
            <ul >
            	<li class="positionList">
            		<div></div>
            	</li>
            </ul>
        </div>
    </div>
    <%@include file="./booter.jsp" %>
</body>
<script type="text/javascript">
	var postjob = document.getElementById("postjob");
	postjob.onclick = function(){
		alert("投递成功!!!");
		postjob.style.backgroundColor = "gray";
	}
</script>
</html>