package cn.qblank.admin.action;


import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.WebUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.qblank.admin.entity.LoginRecord;
import cn.qblank.admin.entity.UserResume;
import cn.qblank.admin.service.IAdminService;
import cn.qblank.job.entity.Position;
import cn.qblank.position.service.IPositionService;
import cn.qblank.resume.entity.Resume;
import cn.qblank.resume.service.IResumeService;
import cn.qblank.user.entity.User;
import cn.qblank.user.service.IUserService;
import cn.qblank.util.TimeUtil;
import cn.qblank.util.UserConstant;
import cn.qblank.util.Utils;
import net.sf.json.JSONObject;
@Controller
public class AdminAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ModelDriven<User>{
	private Log logger = LogFactory.getLog(AdminAction.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IResumeService resumeService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Autowired
	private IPositionService positionService;
	//模型驱动注入
	private User user = new User();
	
	/**
	 * 登陆界面
	 * @return
	 */
	public String adminLoginJsp() {
		return "adminLoginJsp";
	}
	/**
	 * 判断是否登陆成功
	 * @return
	 */
	public String adminLogin() {
		request.setAttribute("adminLoginErr", "");
		User adminUser = userService.Login(user);
		if (adminUser != null) {
			WebUtils.setSessionAttribute(request, "adminUser", adminUser);
			
			//插入登陆记录
			LoginRecord record = new LoginRecord();
			setLoginRecord(adminUser, record);
			adminService.insertLoginRecord(record);
			return "adminIndex";
		}
		request.setAttribute("adminLoginErr", "登陆失败");
		return "adminLoginJsp";
	}

	/**
	 * 首页框架
	 * @return
	 */
	public String adminIndex() {
		/*request.setAttribute("adminLoginErr", "");
		User adminUser = userService.Login(user);
		if (adminUser != null) {
			WebUtils.setSessionAttribute(request, "adminUser", adminUser);
			
			//插入登陆记录
			LoginRecord record = new LoginRecord();
			setLoginRecord(adminUser, record);
			adminService.insertLoginRecord(record);
			return "adminIndex";
		}
		request.setAttribute("adminLoginErr", "登陆失败");
		return "adminLoginJsp";*/
		return "adminIndex";
	}
	
	/**
	 * 设置登陆记录
	 * @param adminUser
	 * @param record
	 */
	private void setLoginRecord(User adminUser, LoginRecord record) {
		record.setUid(adminUser.getId());
		record.setLoginTime(TimeUtil.DateToString(new Date(), "yyyy-MM-dd hh:mm:ss"));
		record.setLoginContent("登陆成功");
		record.setLoginUserIp(Utils.getIPAddress(request));
		record.setUsername(adminUser.getAuthority().toString());
		record.setAddress("广东");
		record.setType("web端");
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
		//查询出登陆记录表
		User user = (User) WebUtils.getSessionAttribute(request, "adminUser");
		List<LoginRecord> records = adminService.findAllRecordByUser(user);
		WebUtils.setSessionAttribute(request, "records", records);
		return "adminInfo";
	}
	
	/**
	 * 退出系统
	 */
	public void exitSystem() {
		logger.debug("退出系统");
		WebUtils.setSessionAttribute(request, "adminUser", "");
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
	
	/**
	 * 查看用户详情
	 */
	public String showUserDetail() {
		//通过编号查找用户信息
		String uidStr = request.getParameter("uid");
		if (uidStr != null && !"".equals(uidStr)) {
			int uid = Integer.parseInt(uidStr);
			User userDetail = userService.findUserById(uid);
			WebUtils.setSessionAttribute(request, "userDetail", userDetail);
		}
		return "showUserDetail";
	}
	
	/********求职管理*******/
	
	/**
	 * 系统简历信息管理
	 * @return
	 */
	public String systemResumeInfo() {
		//查询所有投递的简历
//		List<Resume> resumes = resumeService.findAllResume("1");
		List<UserResume> userResumes = new ArrayList<>();
		List<User> users = adminService.findAllByAuthority(0);
		for (User user : users) {
			UserResume userResume = new UserResume();
			Resume resume = userService.findResumeByUser(user);
			userResume.setUser(user);
			userResume.setResume(resume);
			/*logger.debug(userResume.getUser().getUsername() + "的工资是:" + userResume.getResume().getRdesiredSalary());*/
			userResumes.add(userResume);
		}
		
		/*for (UserResume ur : userResumes) {
			logger.debug(ur.getUser().getUsername() + "的工资是:" + ur.getResume().getRdesiredSalary());
		}*/
		WebUtils.setSessionAttribute(request, "userResumes", userResumes);
		return "systemResumeInfo";
	}
	
	/**
	 * 查看简历细节
	 * @return
	 */
	public String resumePre() {
		//获取用户编号
		String resumeIdStr = request.getParameter("uid");
		if (StringUtils.isNotEmpty(resumeIdStr)) {
			int resumeId = Integer.parseInt(resumeIdStr);
			Resume resume = resumeService.findResumeByUid(resumeId);
			WebUtils.setSessionAttribute(request, "adminResume", resume);
		}
		return "resumePre";
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
		//获取公司编号
		//先写死
		
		//查询所有简历
		List<Position> positions = positionService.findAllPos(6);
		//放入request域中
		request.setAttribute("positions", positions);
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

	@Override
	public User getModel() {
		return user;
	}
	
}
