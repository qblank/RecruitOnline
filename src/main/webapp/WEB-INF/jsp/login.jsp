<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>登陆</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bg.css">
    <script src="js/jquery-1.8.2.js"></script>
</head>
<body>
    <canvas id="canvas"></canvas>
    <div class="login_wrap" id="login_wrap">
        <span class="title">登录</span>
        <div class="content">
            <form action="/Recruit/user_login.action" method="POST">
                <!--用户名-->
                <i class="fa fa-user-circle-o" aria-hidden="true"></i>
                <input type="text" placeholder="输入手机号/邮箱" id="phone" name="username">
                <span id="phoneMsg" class="phoneMsg"></span>
                <br><br>
                <!--密码-->
                <i class="fa fa-key" aria-hidden="true"></i>
                <input type="password" placeholder="输入密码" id="pwd" name="pwd">
                <span id="pwdMsg" class="pwdMsg"></span>
                <br><br>
                <input type="checkbox" id="remeber" />下次自动登录<a href="#">忘记密码?</a>
                去<a href="/Recruit/user_registerJsp.action">注册</a>
                <br><br>
                <input type="submit" value="登录" class="login_btn" />
                 <span class="loginErr">${loginErr}</span>
            </form>
            
        </div>
    </div>
   
    <%@include file="./booter.jsp" %>
</body>
<script src="js/login.js"></script>
<script src="js/bg.js"></script>
</html>