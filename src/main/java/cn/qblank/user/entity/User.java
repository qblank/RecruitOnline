package cn.qblank.user.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id" , strategy = "native")
	private Integer id;
	private String username;
	private String pwd;
	private Integer authority;
	private Date registerTime;
	public User(Integer id, String username, String pwd, Integer authority, Date registerTime) {
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.authority = authority;
		this.registerTime = registerTime;
	}
	public User() {
		
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
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", authority=" + authority
				+ ", registerTime=" + registerTime + "]";
	} 
	
}
