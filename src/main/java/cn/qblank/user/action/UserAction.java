package cn.qblank.user.action;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.qblank.user.entity.User;
import cn.qblank.user.service.IUserService;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IUserService userService;
	
	//回到主页面
	public String index() throws Exception{
		return "success";
	}
	
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	/**
	 * 判断是否登录
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		user.setAuthority(0);
		User result = userService.Login(user);
		if (result != null && !"".equals(result)) {
			return "success";
		}
		System.out.println(user);
		return "login";
	}
	/**
	 * 访问登录静态页面
	 * @return
	 * @throws Exception
	 */
	public String loginJsp() throws Exception{
		return "loginJsp";
	}
	
	/**
	 * 访问注册静态页面
	 * @return
	 * @throws Exception
	 */
	public String registerJsp() throws Exception{
		return "registerJsp";
	}
	/**
	 * 注册
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception{
		//先默认为普通用户
		user.setAuthority(1);
		userService.register(user);
		return "register";
	}
	
}
