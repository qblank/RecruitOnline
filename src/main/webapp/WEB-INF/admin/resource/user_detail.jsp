<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
 		<link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="resource/css/style.css"/>       
        <link href="resource/assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="resource/assets/css/ace.min.css" />
        <link rel="stylesheet" href="resource/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="resource/assets/js/jquery.min.js"></script>
       	<title>用户查看</title>
</head>
<body>
<div class="member_show" >
<div class="member_jbxx clearfix" >
  <img class="img" src="resource/images/user.png">
  <dl  class="right_xxln">
  <dt><span class="">${userDetail.username}</span></dt>
  <dd class="" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
  </dl>
</div>
<div class="member_content">
  <ul>
   <li><label class="label_name">性别：</label><span class="name">${userDetail.gender }</span></li>
   <li><label class="label_name">性别：</label><span class="name">${userDetail.age }</span></li>
   <li><label class="label_name">手机：</label><span class="name">${userDetail.phone }</span></li>
   <!-- <li><label class="label_name">固定电话：</label><span class="name">021-454443344</span></li> -->
   <li><label class="label_name">邮箱：</label><span class="name">${userDetail.email }</span></li>
   <li><label class="label_name">地址：</label><span class="name">北京市 海定区</span></li>
   <li><label class="label_name">注册时间：</label><span class="name"><fmt:formatDate value="${userDetail.registerTime }" pattern="yyy-MM-dd"/></span></li>
   <c:choose>
   		<c:when test="${userDeail.authority == 1 }">
   			<li><label class="label_name">权限：</label><span class="name">普通用户</span></li>
   		</c:when>
   		<c:when test="${userDeail.authority == 2 }">
   			<li><label class="label_name">权限：</label><span class="name">企业用户</span></li>
   		</c:when>
   		<c:when test="${userDeail.authority == 3 }">
   			<li><label class="label_name">权限：</label><span class="name">管理员</span></li>
   		</c:when>
   </c:choose>
   <li><label class="label_name">qq：</label><span class="name">${userDetail.qq }</span></li>
   
  </ul>
</div>
</div>
</body>
</html>