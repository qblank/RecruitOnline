<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>注册</title>
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/bg.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
    <script src="js/jquery-1.8.2.js"></script>
</head>
<body>
    <canvas id="canvas"></canvas>
    <div class="register_wrap">
        <span class="title">注册</span>
        <div class="content">
                <form action="/Recruit/user_register.action" method="POST">
                    <table>
                        <tr>
                            <td>真实姓名</td>
                            <td><input type="text" placeholder="姓名(必填)" id="username" name="username"></td>
                            <td>
                                <span class="real_name" id="real_name">2~10个字符</span>
                            </td>
                        </tr>
                        <tr>
                            <td>手机号/邮箱</td>
                            <td><input type="text" placeholder="输入手机号/邮箱" id="phone" name="phone"></td>
                            <td><span id="reg_phoneMsg" class="reg_phoneMsg">电话号码</span></td>
                        </tr>
                        <tr>
                            <td>密&nbsp;码</td>
                            <td><input type="password" placeholder="输入密码" id="pwd" name="pwd"></td>
                            <td><span id="reg_pwdMsg" class="reg_pwdMsg">6~10个字符</span></td>
                        </tr>
                        <tr>
                            <td colspan="3"><input type="submit" value="注册" class="login_btn" /></td>
                        </tr>
                        <tr>
                            <td colspan="3" align="left">已有账号,去<a href="/Recruit/user_loginJsp.action">登录</a></td>
                        </tr>
                    </table>
                </form>
        </div>
    </div>
    <%@include file="./booter.jsp" %>
</body>
<script src="js/bg.js"></script>
<script src="js/register.js"></script>
</html>