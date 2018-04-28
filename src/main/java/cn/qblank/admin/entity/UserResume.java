package cn.qblank.admin.entity;

import cn.qblank.resume.entity.Resume;
import cn.qblank.user.entity.User;

/**
 * 用于显示用户和简历的一些基本信息
 * @author evan_qb
 *
 */

public class UserResume {
	//用户
	/*private Integer uid;
	private String username;
	private String phone;
	private String email; 
	//简历
	private String rname;		//真实姓名
	private String rschoolname;
	private String rdesireFunction;
	private String rdesiredSalary;
	private String rprofessional;*/	//专业
	private User user;
	private Resume resume;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
}
