package cn.qblank.admin.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 登陆记录
 * @author evan_qb
 *
 */
@Entity
public class LoginRecord {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id",strategy = "native")
	private Integer id;
	private String type;
	private String loginContent;
	private String address;
	private String username;
	private String loginUserIp;
	private String loginTime;
	private Integer uid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLoginContent() {
		return loginContent;
	}
	public void setLoginContent(String loginContent) {
		this.loginContent = loginContent;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginUserIp() {
		return loginUserIp;
	}
	public void setLoginUserIp(String loginUserIp) {
		this.loginUserIp = loginUserIp;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
