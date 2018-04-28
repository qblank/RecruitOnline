<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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

		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="resource/assets/js/bootstrap.min.js"></script>
		<script src="resource/assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="resource/assets/js/jquery.dataTables.min.js"></script>
		<script src="resource/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="resource/js/H-ui.js"></script> 
        <script type="text/javascript" src="resource/js/H-ui.admin.js"></script> 
        <script src="resource/assets/layer/layer.js" type="text/javascript" ></script>
        <script src="resource/assets/laydate/laydate.js" type="text/javascript"></script>
<title>用户列表</title>
</head>

<body>
<div class="page-content clearfix">
    <div id="Member_Ratings">
      <div class="d_Confirm_Order_style">
		    <div class="search_style">
		      <div class="title_names">搜索查询</div>
		      <ul class="search_content clearfix">
		       <!-- <li><label class="l_f">会员名称</label><input name="" type="text"  class="text_add" placeholder="输入会员名称、电话、邮箱"  style=" width:400px"/></li> -->
		       <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
		       <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
		      </ul>
		    </div>
     <!---->
     <!-- <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:void()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加用户</a>
        <a href="javascript:void()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
       </span>
       <span class="r_f">共：<b>2345</b>条</span>
     </div> -->
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="80">ID</th>
				<th width="100">用户名</th>
				<th width="100">真实姓名</th>
				<th width="120">手机</th>
				<th width="150">邮箱</th>
				<th width="150">学校</th>
				<th width="120">职业意向</th>
                <th width="100">期望薪水</th>
				<th width="120">专业</th>                
				<th width="70">操作</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach items="${userResumes}" var="userResume" varStatus="uState">
			<tr>
	          <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
	          <td>${uState.count}</td>
	          <td><u style="cursor:pointer" class="text-primary" onclick="member_show('${userResume.user.username}','http://localhost:8080/Recruit/admin_showUserDetail.action',${userResume.user.id },'500','400')">${userResume.user.username}</u></td>
	          <td>${userResume.resume.rname }</td>
	          <td>${userResume.user.phone }</td>
	          <td>${userResume.user.email }</td>
	          <td class="text-l">${userResume.resume.rschoolname }</td>
	          <td>${userResume.resume.rdesiredFunction}</td>
		      <td>${userResume.resume.rdesiredSalary }</td>
	          <td class="td-status"><span class="label label-success radius">${userResume.resume.rprofessional }</span></td>
	          <td class="td-manage">
	          <a onClick="member_show('${userResume.user.username}','http://localhost:8080/Recruit/admin_resumePre.action',${userResume.user.id},'1000','400')"  href="javascript:;" title="查看"  class="btn btn-xs btn-warning">查看</a> 
	          </td>
			</tr>
		</c:forEach>
      </tbody>
	</table>
   </div>
  </div>
 </div>
</div>
<!--添加用户图层-->
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content" id="userInfo">
	     <li><label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label><span class="add_name"><input value="" name="用户名" type="text"  class="text_add" id="username"/></span><div class="prompt r_f"></div></li>
	     <li><label class="label_name">密码：</label><span class="add_name"><input name="密码" id="pwd" type="text"  class="text_add" /></span><div class="prompt r_f"></div></li>
	     <li><label class="label_name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label><span class="add_name">
	     <label><input name="gender" type="radio" checked class="ace" value="男"><span class="lbl">男</span></label>&nbsp;&nbsp;&nbsp;
	     <label><input name="gender" type="radio" class="ace" value="女"><span class="lbl">女</span></label>&nbsp;&nbsp;&nbsp;
	     <label><input name="gender" type="radio" class="ace" value="保密"><span class="lbl">保密</span></label>
	     <!-- form-field-radio -->
	     </span>
	     <div class="prompt r_f"></div>
	     </li>
	     <li><label class="label_name">权限：</label><span class="add_name"><input name="权限" type="text" id="authority"  class="text_add" /></span><div class="prompt r_f"></div></li>
	     <li><label class="label_name">移动电话：</label><span class="add_name"><input name="移动电话" type="text" id="phone" class="text_add"/></span><div class="prompt r_f"></div></li>
	     <li><label class="label_name">电子邮箱：</label><span class="add_name"><input name="电子邮箱" type="text" id="email"  class="text_add"/></span><div class="prompt r_f"></div></li>
	     <li><label class="label_name">qq：</label><span class="add_name"><input name="qq" type="text" id="qq"  class="text_add"/></span><div class="prompt r_f"></div></li>
	     <li><label class="label_name">年龄：</label><span class="add_name"><input name="年龄" type="text" id="age"  class="text_add"/></span><div class="prompt r_f"></div></li>
	     <li class="adderss"><label class="label_name">家庭住址：</label><span class="add_name"><input name="家庭住址" id="address" type="text"  class="text_add" /></span><div class="prompt r_f"></div></li>
	     <li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span class="add_name">
	     <label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl">开启</span></label>&nbsp;&nbsp;&nbsp;
	     <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">关闭</span></label></span><div class="prompt r_f"></div></li>
    </ul>
 </div>
</body>
</html>
<script>
jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable( {
				"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		] } );
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
			
			
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			})
/*用户-添加*/
 $('#member_add').on('click', function(){
	 $("#authority").removeAttr("readonly");
    layer.open({
        type: 1,
        title: '添加用户',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style'),
		btn:['提交','取消'],
		yes:function(index,layero){	
		 var num=0;
		 var str="";
     $(".add_menber input[type$='text']").each(function(n){
          if($(this).val()=="")
          {
               
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
        	  $.ajax({
  				method: "POST",
  				url : "admin_addUser.action",
  				data:{
  					"gender":$("#userInfo input[name='gender']").val(),
  					"username":$("#username").val(),
  					"phone":$("#phone").val(),
  					"pwd":$("#pwd").val(),
  					"email":$("#email").val(),
  					"authority":$("#authority").val(),
  					"age":$("#age").val(),
  					"qq":$("#qq").val()
  				},		
  				success:function(data){
  					if(data == 'success'){
	  					layer.alert('添加成功！',{
	   			            title: '提示框',				
	   						icon:1,		
   						});
   						layer.close(index);	
  					}else{
  						layer.alert('添加失败！',{
	   			            title: '提示框',				
	   						icon:2,		
   						});
  					}
  					
  				},
  				fail:function(){
  					layer.alert('修改失败！',{
  			               title: '提示框',				
  						icon:2,		
  					});
  				}
  			});
        	  
		  }		  		     				
		}
    });
});
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url+'?uid='+id,w,h);
}
/*用户-停用*/
/* function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
} */

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!',{icon: 6,time:1000});
	});
}
/*用户-编辑*/
function member_edit(id){
	$("#authority").attr("readonly","readonly");
	$.ajax({
		dataType:"json",
		method:"POST",
		url:"Recruit/admin_updateUserShow.action?id=" + id,
		success: function(data){
			$("#username").val(data.username);
			$("#phone").val(data.phone);
			$("#authority").val(data.authority);
			$("#pwd").val(data.pwd);
			$("#email").val(data.email);
			$("#address").val("广东深圳");
		}
	});
	
	  layer.open({
        type: 1,
        title: '修改用户信息',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style'),
		btn:['提交','取消'],
		yes:function(index,layero){	
		 var num=0;
		 var str="";
     $(".add_menber input[type$='text']").each(function(n){
          if($(this).val()==""){
               
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,								
          }); 
		    num++;
            return false;            
          } 
		 });
		if(num>0){
			  return false;
		}else{
			$.ajax({
				method: "POST",
				url : "admin_updateUser.action?id=" + id,
				data:{
					"gender":$("#userInfo input[name='gender']").val(),
					"uid":id,
					"username":$("#username").val(),
					"phone":$("#phone").val(),
					"pwd":$("#pwd").val(),
					"email":$("#email").val()
				},		
				success:function(){
					layer.alert('修改成功！',{
			               title: '提示框',				
						icon:1,		
					});
					layer.close(index);	
				},
				fail:function(){
					layer.alert('修改失败！',{
			               title: '提示框',				
						icon:2,		
					});
				}
			});
			
			
		  }		  		     				
		}
    });
}
/*用户-删除*/
function member_del(obj,id){
	
	
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			url:"Recruit/admin_deleteUser.action?uid=" + id,
			method:"POST",
			success:function(){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			}
		})
		
	});
}
laydate({
    elem: '#start',
    event: 'focus' 
});

</script>