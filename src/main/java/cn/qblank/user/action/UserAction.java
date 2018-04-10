package cn.qblank.user.action;



import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.WebUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.qblank.user.entity.User;
import cn.qblank.user.service.IUserService;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>,ServletRequestAware,ServletResponseAware{
	private static final Log logger = LogFactory.getLog(UserAction.class);
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Autowired
	private IUserService userService;
	//回到主页面
	public String index() throws Exception{
		return "success";
	}
	//模型驱动注入
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
		logger.debug("进行登陆控制");
		user.setAuthority(1);
		User result = userService.Login(user);
		
		if (result != null) {
			WebUtils.setSessionAttribute(request, "login", "");
			WebUtils.setSessionAttribute(request, "sessionUser", result);
			return "success";
		}
		WebUtils.setSessionAttribute(request, "loginErr", "登陆失败,请重新登陆");
		return "loginJsp";
	}
	/**
	 * 访问登录静态页面
	 * @return
	 * @throws Exception
	 */
	public String loginJsp() throws Exception{
		WebUtils.setSessionAttribute(request, "loginErr", "");
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
	
	/**
	 * ajax注销
	 * @throws Exception
	 */
	public String withdraw() throws Exception{
		//注销
		WebUtils.setSessionAttribute(request, "sessionUser", "");
		return "success";
	}
	
	/**
	 * 访问通知界面
	 * @return
	 * @throws Exception
	 */
	public String noticeJsp() throws Exception{
		return "notice";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public void revisePwd() throws Exception{
		boolean flag = false;
		String msg = null;
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String rePwd = request.getParameter("rePwd");
		logger.debug("密码" + oldPwd + ":" + newPwd + ":" +rePwd);
		User user = (User) WebUtils.getSessionAttribute(request, "sessionUser");
		//判断密码是否正确
		if (oldPwd.equals(user.getPwd()) && newPwd.equals(rePwd)) {
			user.setPwd(newPwd);
			flag = userService.revisePwd(user);
		}
		msg = "input right password!!!";
		PrintWriter writer = response.getWriter();
		if (flag) {
			//向前台输出成功数据
			//String msg = URLDecoder.decode(URLDecoder.decode("修改成功", "UTF-8"),"UTF-8");
			writer.write("SUCCESS");
		}else {
			writer.write(msg);
		}
		writer.close();
	}
	
	/**
	 * 测试过滤器
	 * @return
	 * @throws Exception
	 */
	public String test() throws Exception{
		return "test";
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
}
