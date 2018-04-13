<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>通知界面</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/notice.css">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
</head>
<body>
	<%@include file="./header.jsp" %>
    <div class="mainWrapper">
        <!--左边-->
        <div class="leftWrapper">
            <div class="userImageWrapper">
                <div class="user_img">
					<img alt="" src="images/header/me.jpg" width="102px" height="102px">
                </div>
                <h4>evan_qb</h4>
            </div>
            <ul class="leftNav" id="leftNav">
	                <li><a href="javascript:void(0)" target="targetPage" class="fa fa-home" aria-hidden="true">&nbsp;&nbsp;我的校园</a></li>
	                <li><a href="javascript:void(0)" class="fa fa-cogs currSel" aria-hidden="true">&nbsp;&nbsp;账号设置</a></li>
	                <li><a href="javascript:void(0)" class="fa fa-american-sign-language-interpreting" aria-hidden="true">&nbsp;&nbsp;简历管理</a></li>
	                <li><a href="javascript:void(0)" class="fa fa-bar-chart" aria-hidden="true">&nbsp;&nbsp;投递记录</a></li>
	                <li ><a href="javascript:void(0)" class="fa fa-calendar"  aria-hidden="true">&nbsp;&nbsp;我的招聘会</a></li>
	                <li><a href="javascript:void(0)" class="fa fa-user-plus" aria-hidden="true">&nbsp;&nbsp;投递的公司</a></li>
            </ul>
        </div>
        	<div class="rightWrapper" id="nav1">
	            <div class="topWrapper">
	                <div class="tabWrapper">
	                    <ul id="tabNav">
	                        <li class="current">我的校园</li>
	                    </ul>
	                </div>
	            </div>
	        </div>
        	
        	<div class="rightWrapper" id="nav2" style="display:block">
	            <div class="topWrapper">
	                <div class="tabWrapper">
	                    <ul id="tabNav">
	                        <li class="current">修改密码</li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	        
	        <div class="rightWrapper" id="nav3">
	            <div class="topWrapper">
	                <div class="tabWrapper">
	                    <ul id="tabNav">
	                        <li class="current">我的简历</li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	        
	        <div class="rightWrapper" id="nav4">
	            <div class="topWrapper">
	                <div class="tabWrapper">
	                    <ul id="tabNav">
	                        <li class="current">投递记录</li>
	                    </ul>
	                </div>
	            </div>
	        </div>
        
	        <!--右边-->
	        <div class="rightWrapper" id="nav5">
	            <div class="topWrapper">
	                <div class="tabWrapper">
	                    <ul id="tabNav">
	                        <li class="current">还未开始</li>
	                        <li >已经结束</li>
	                    </ul>
	                </div>
	            </div>
	        </div>
        	
        	<div class="rightWrapper" id="nav6">
	            <div class="topWrapper">
	                <div class="tabWrapper">
	                    <ul id="tabNav">
	                        <li class="current">我的投递</li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	       
	        
	        <!-- 右下内容 -->
	        <!-- 我的校园 -->
	        <div class="right_content" id="content1">
	        	<span class="nav_title">|我的校园</span>
	        	<br><br>
	        </div>
	        
	        <!-- 修改密码 -->
	        <div class="right_content" id="content2" style="display:block">
	        	<span class="nav_title">|账号设置</span>
	        	<br><br>
	              <form name="formC" id="formC">
		              <ul class="nL_formbox">
		                  <li>
		                      <label for="" class="nL_listName">
		                          旧密码</label>
		                          <input type="password" id="oldPwdInp" name="oldPwd"/>
		                          <span id="img-x-validate-1007" class="img-x-validate-error"></span>
		                          <span id="oldpw" class="nL_validate_tips nL_validate_tips_l tip-x-validate-error">请输入你登录的密码</span>
		                  </li>
		                  <li>
		                      <label for="" class="nL_listName">
		                          新密码</label>
		                          <input type="password" id="newPwdInp" name="newPwd">
		                          <span id="img-x-validate-1008" class="img-x-validate-error"></span>
		                          <span id="oldpn" class="nL_validate_tips nL_validate_tips_l tip-x-validate-error">密码为6-20位的字母、数字和下划线</span>
		                  </li>
		                  <li>
		                      <label for="" class="nL_listName">
		                          重复新密码</label>
		                          <input type="password" id="repPwdInp" name="rePwd">
		                          <span id="img-x-validate-1009" class="img-x-validate-error"></span>
		                          <span id="oldpr" class="nL_validate_tips nL_validate_tips_l tip-x-validate-error">请再次输入密码</span>
		                  </li>
		              </ul>
		              <button id="subbutton" type="button" class="revisePwd" id="revisePwd" onclick="revisePwd()">
		                  确定修改</button>
	              </form>
	        </div>
	        
	        <!-- 简历管理 -->
	        <div class="right_content" id="content3">
	        	<span class="nav_title">|简历管理</span>
	        	<br><br>
	        </div>
	        
	        <!-- 投递记录 -->
	        <div class="right_content" id="content4">
	        	<span class="nav_title">|投递记录</span>
	        	<br><br>
	        </div>
	        <!-- 我的招聘会 -->
	        <div class="right_content" id="content5">
	        	<span class="nav_title">|我的招聘会</span>
	        	<br><br>
	        </div>
	        
	        <!-- 投递的公司 -->
	        <div class="right_content" id="content6">
	        	<span class="nav_title">|投递的公司</span>
	        	<br><br>
	        </div>
    </div>
    <%@include file="./booter.jsp" %>
</body>
<script src="js/jquery-1.8.2.js"></script>
<script src="js/notice.js"></script>
</html>