package cn.qblank.user.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id",strategy="native")
	private Integer id;
	private Integer rid;	//简历编号
	private String gender;
	private Integer age;
	private String username;
	private String pwd;
	private String phone;
	private Integer authority;
	private Date registerTime;
	private String email;
	private String qq;
	
	public User(String username, String pwd, String phone, Integer authority, Date registerTime) {
		this.username = username;
		this.pwd = pwd;
		this.phone = phone;
		this.authority = authority;
		this.registerTime = registerTime;
	}
	
	public String getEmail() {
		return email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public User() {
		
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getAuthority() {
		return authority;
	}
	public void setAuthority(Integer authority) {
		this.authority = authority;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", phone=" + phone + ", authority="
				+ authority + ", registerTime=" + registerTime + "]";
	}
	
}
