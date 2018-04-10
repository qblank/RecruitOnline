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
                <li><a href="javascript:void(0)" class="fa fa-home currSel" aria-hidden="true">&nbsp;&nbsp;我的校园</a></li>
                <li><a href="javascript:void(0)" class="fa fa-cogs" aria-hidden="true">&nbsp;&nbsp;账号设置</a></li>
                <li><a href="javascript:void(0)" class="fa fa-american-sign-language-interpreting" aria-hidden="true">&nbsp;&nbsp;简历管理</a></li>
                <li><a href="javascript:void(0)" class="fa fa-bar-chart" aria-hidden="true">&nbsp;&nbsp;投递记录</a></li>
                <li ><a href="javascript:void(0)" class="fa fa-calendar"  aria-hidden="true">&nbsp;&nbsp;我的招聘会</a></li>
                <li><a href="javascript:void(0)" class="fa fa-user-plus" aria-hidden="true">&nbsp;&nbsp;关注的公司</a></li>
            </ul>
        </div>
        
        <!--右边-->
        <c:if test="${true }">
	        <div class="rightWrapper">
	            <div class="topWrapper">
	                <div class="tabWrapper">
	                    <ul id="tabNav">
	                        <li class="current">还未开始</li>
	                        <li >已经结束</li>
	                    </ul>
	                </div>
	            </div>
	        </div>
        </c:if>
        
        <!-- 右下内容 -->
        <c:if test="${true}">
	        <div class="right_content">
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
        </c:if>
    </div>
    
    <%@include file="./booter.jsp" %>
</body>
<script src="js/jquery-1.8.2.js"></script>
<script src="js/notice.js"></script>
</html>