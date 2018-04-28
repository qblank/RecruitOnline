<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="resource/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="resource/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="resource/assets/css/ace.min.css" />
		<link rel="stylesheet" href="resource/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="resource/assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="resource/css/style.css"/>
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="resource/assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="resource/assets/js/ace-extra.min.js"></script>
		<!--[if lt IE 9]>
		<script src="resource/assets/js/html5shiv.js"></script>
		<script src="resource/assets/js/respond.min.js"></script>
		<![endif]-->
		<script src="resource/js/jquery-1.9.1.min.js"></script>        
        <script src="resource/assets/layer/layer.js" type="text/javascript"></script>
<title>登陆</title>
</head>

<body class="login-layout">
<div class="logintop">    
    <span>欢迎后台管理界面平台</span>    
    <ul>
    <li><a href="#">返回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    <div class="loginbody">
<div class="login-container">
	<div class="center">
		<h1>
			<!--<i class="icon-leaf green"></i>-->
			<!--<span class="orange">evan_qb</span>-->
			<span class="white">招聘网站后台管理系统</span>
		</h1>
	</div>
<div class="space-6"></div>
		<div class="position-relative">
			<div id="login-box" class="login-box widget-box no-border visible">
				<div class="widget-body">
					<div class="widget-main">
						<h4 class="header blue lighter bigger">
							<i class="icon-coffee green"></i>
							管理员登陆
						</h4>
	
						<div class="login_icon"><img src="resource/images/login.png" /></div>
	
						<form class="" id="loginForm" method="post" action="/Recruit/admin_adminLogin.action">
							<fieldset>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="text" class="form-control" placeholder="登录名"  name="username" />
										<i class="icon-user"></i>
									</span>
								</label>
	
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="password" class="form-control" placeholder="密码" name="pwd" />
										<i class="icon-lock"></i>
									</span>
								</label>
	
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<select name="authority" id="">
											<option value="">请选择角色</option>
											<option value="2">企业用户</option>
											<option value="0">管理员</option>
										</select>
									</span>
								</label>
								<div class="space"></div>
								<div class="clearfix">
									<label class="inline">
										<input type="checkbox" class="ace">
										<span class="lbl">保存密码</span>
									</label>
									<!-- 显示错误信息 -->
									<span style="color:red;position: absolute;left:220px;bottom:10px;">${adminLoginErr }</span>
									<button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="login_btn">
										<i class="icon-key"></i>
										登陆
									</button>
								</div>
	
								<div class="space-4"></div>
							</fieldset>
						</form>
					</div>
					<div class="toolbar clearfix">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="loginbm">版权所有  2018  <a href="">长沙医学院</a> </div><strong></strong>
</body>
</html>
<script>
$('#login_btn').on('click', function(){
	     var num=0;
		 var str="";
	     $("input[type$='text']").each(function(n){
	          if($(this).val()==""){
	               
				   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
	                title: '提示框',				
					icon:0,	
	          }); 
			    num++;
	            return false;
	          } 
		});
		if(num>0){  return false;}	 	
	    else{
			  layer.alert('登陆成功！',{
               title: '提示框',				
			   icon:1,		
			  });	
			 //提交表单
			 postForm();
		}     						
		
	})

</script>
<script type="text/javascript">
function postForm(){
	var btn = document.getElementById("login_btn");
	var loginForm = document.getElementById("loginForm");
	loginForm.submit();
}
</script>
