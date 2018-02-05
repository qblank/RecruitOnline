package cn.qblank.user.action;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.qblank.user.entity.User;
import cn.qblank.user.service.IUserService;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IUserService userService;
	
	public String index() throws Exception{
		//测试
		User user = new User();
		user.setUsername("evan_qb");
		user.setPwd("aini1314");
		user.setAuthority(0);
		user.setRegisterTime(new Date(System.currentTimeMillis()));
		userService.saveUser(user);
		
		return "success";
	}
}
