<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.css">
</head>
<div class="headerwrap">
    <div class="nav container">
        <ul>
            <li class="text-left">
                <a href="#">
                    <img src="images/logo.png" class="logo" width="160px" height="45px">
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/index.action">
                    <i class="fa fa-home" aria-hidden="true"></i>
                </a>
            </li>
            <c:if test="${not empty sessionUser}">
	            <li id="draw">
	                <a href="#">
	                    <span class="myConpus">我的校园&nbsp;</span>
	                    <i class="fa fa-angle-down" id="school"></i>
	                </a>
	            <div class="compus" id="compus">
	                <ul>
	                    <li><a href="index.html">我的校园</a></li>
	                    <li><a href="${pageContext.request.contextPath }/resume_resumeJsp.action">简历管理</a></li>
	                    <li><a href="${pageContext.request.contextPath }/job_jobFair.action">我的招聘会</a></li>
	                </ul>
	            </div>
	            </li>
            </c:if>
            <c:if test="${empty sessionUser}">
            	<li></li>
            </c:if>
            <li><a href="#">找全职</a></li>
            <li><a href="#">找兼职</a></li>
            <li><a href="jobFair.html">招聘会</a></li>
            <c:if test="${not empty sessionUser}">
	            <li id="my">
	                <a href="#">
	                    <img src="images/header/me.jpg" width="30" height="30" class="me">
	                    <span class="my_name">
	                    		${sessionUser.username}
	                    </span>
	                </a>
	                <div id="myMessage" class="myMessage">
	                    <ul>
	                        <li><a href="notice.html">通知</a></li>
	                        <li><a href="${pageContext.request.contextPath }/user_noticeJsp.action?pageId=2">账号管理</a></li>
	                        <li><a href="${pageContext.request.contextPath }/user_withdraw.action">退出</a></li>
	                    </ul>
	                </div>
	            </li>
            </c:if>
            <c:if test="${empty sessionUser}">
            	<li id="my">
	                <a href="${pageContext.request.contextPath }/user_loginJsp.action">登陆</a>&nbsp;&nbsp;
	                <a href="${pageContext.request.contextPath }/user_registerJsp.action">注册</a>
	            </li>
	         </c:if>
	         <li><a href="${pageContext.request.contextPath }/admin_adminLoginJsp.action">管理员入口</a></li>
        </ul>
    </div>
</div>
<script src="js/jquery-1.8.2.js"></script>
<script src="js/header.js"></script>
