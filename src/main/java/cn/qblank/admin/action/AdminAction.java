package cn.qblank.admin.action;


import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.WebUtils;

import com.opensymphony.xwork2.ActionSupport;

import cn.qblank.admin.dao.impl.AdminUserDao;
import cn.qblank.admin.service.IAdminService;
import cn.qblank.user.entity.User;
import cn.qblank.user.service.IUserService;
import net.sf.json.JSONObject;
@Controller
public class AdminAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private Log logger = LogFactory.getLog(AdminAction.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IAdminService adminService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	/**
	 * 登陆界面
	 * @return
	 */
	public String adminLoginJsp() {
		return "adminLoginJsp";
	}

	/**
	 * 首页框架
	 * @return
	 */
	public String adminIndex() {
		return "adminIndex";
	}
	
	/**
	 * 系统首页
	 * @return
	 */
	public String home() {
		return "home";
	}
	
	/********用户管理*******/
	
	/**
	 * 个人信息
	 * @return
	 */
	public String adminInfo() {
		//测试
		User user = userService.findUserById(2);
		WebUtils.setSessionAttribute(request, "adminUser", user);
		
		return "adminInfo";
	}
	
	/**
	 * 用户信息管理
	 * @return
	 */
	public String userList() {
		List<User> ordinaryUser = adminService.findAllByAuthority(0);
		if (ordinaryUser != null) {
			WebUtils.setSessionAttribute(request, "ordinaryUser", ordinaryUser);
			System.out.println(ordinaryUser);
		}
		return "userList";
	}
	
	/**
	 * 删除用户
	 */
	public void deleteUser() {
		if (request.getParameter("uid") != null) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			adminService.deleteUserById(uid);
		}
	}
	
	/**
	 * 修改用户显示
	 */
	public void updateUserShow() throws Exception{
		String idStr = request.getParameter("id");
		if (idStr != null && !"".equals(idStr)) {
			int id = Integer.parseInt(idStr);
			PrintWriter pw = response.getWriter();
			User updateUser = userService.findUserById(id);
			JSONObject json = JSONObject.fromObject(updateUser);
			String jsonStr = json.toString();
			pw.write(jsonStr);
			pw.close();
		}
	}
	
	/**
	 * 修改用户
	 * @throws Exception
	 */
	public void updateUser() throws Exception{
		String id = request.getParameter("uid");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		logger.debug("username=" + username + ",phone=" + phone + ",pwd=" +
				pwd + ",email=" + email +  ",gender=" + gender);
		if (id != null) {
			int uid = Integer.parseInt(id);
			User user = userService.findUserById(uid);
			user.setUsername(username);
			user.setPhone(phone);
			user.setPwd(pwd);
			user.setEmail(email);
			user.setGender(gender);
			adminService.updateUser(user);
		}
		
	}
	
	/**
	 * 添加用户
	 * @throws Exception
	 */
	public void addUser() throws Exception{
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String authority = request.getParameter("authority");
		String gender = request.getParameter("gender");
		String ageStr = request.getParameter("age");
		String qq = request.getParameter("qq");
		
		logger.debug("username=" + username + ",phone=" + phone + ",pwd=" +
				pwd + ",email=" + email + "," + "authority=" + authority + ",gender=" + gender);
		User user = new User();
		user.setUsername(username);
		user.setPhone(phone);
		user.setPwd(pwd);
		user.setEmail(email);
		user.setGender(gender);
		user.setRegisterTime(new Date());
		user.setQq(qq);
		if (ageStr != null) {
			int age = Integer.parseInt(ageStr);
			user.setAge(age);
		}
		if (authority != null) {
			int auth = Integer.parseInt(authority);
			if (auth == 1 || auth == 2) {
				user.setAuthority(auth);
				adminService.addUser(user);
				PrintWriter pw = response.getWriter();
				pw.write("success");
				pw.close();
			}
		}
		
	}
	
	/********求职管理*******/
	
	/**
	 * 系统简历信息管理
	 * @return
	 */
	public String systemResumeInfo() {
		return "systemResumeInfo";
	}
	
	/**
	 * 简历文档信息管理
	 * @return
	 */
	public String resumeDocInfo() {
		return "resumeDocInfo";
	}
	
	/********应聘管理*******/
	
	/**
	 * 职位信息管理
	 * @return
	 */
	public String positionInfo() {
		return "positionInfo";
	}
	
	/**
	 * 应聘信息管理
	 * @return
	 */
	public String empManage() {
		return "empManage";
	}
	
	/**
	 * 招聘会信息管理
	 * @return
	 */
	public String jobFairManage() {
		return "jobFairManage";
	}
	
	/********系统管理*******/
	
	/**
	 * 系统设置
	 * @return
	 */
	public String systemSettings() {
		return "systemSettings";
	}
	
	/**
	 * 留言管理
	 * @return
	 */
	public String messageManage() {
		return "messageManage";
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
