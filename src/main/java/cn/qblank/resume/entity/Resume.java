package cn.qblank.resume.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Resume implements Serializable{
	@Id
	@GeneratedValue(generator = "rid")
	@GenericGenerator(name = "rid" , strategy = "native")
	private Integer rid;				//编号
	/** 个人信息**/
	private String rname;				//姓名
	private String rgender;				//性别
	private Date rbirthday;				//出生日期
	private String ridentityCard;		//身份证
	private String residentialAddress;	//现居住地
	private String roriginAddress;		//籍贯
	private Date rgraduateDate;			//毕业时间
	/**求职意向 **/
	private String rnatureWork;			//工作性质
	private String rdesiredCity;		//期望工作地点
	private String rdesiredIndustry;	//期望从事行业
	private String rdesiredFunction;	//期望从事职业
	private String rcurrentStatus;		//目前状况
	private String rdesiredSalary;		//期望薪资
	private String rdesiredWorktime;	//到职时间
	/**实习经历**/
	private String rcompanyName;			//工作单位
	private String rjobIndustry;			//行业类型
	private String rjobFunction;			//职位类型
	private Date rjobDateStart;			//入职时间
	private Date rjobDateEnd;				//离职时间
	private String rjobType;				//工作类型
	private Double rworkExperienceSalary;	//职位月薪
	private String rjobTitle;				//职务
	private String rjobExperienceDescribe;	//工作描述
	private String rjobReterence;			//证明人
	private String rjobReterencePhone;		//证明人电话
	/**项目经验**/
	private String rprojectName;			//项目名字
	private Date rprojectStartDate;			//项目开始时间
	private Date rprojectEndDate;			//项目结束时间
	private String rprojectTitle;			//项目中的职务
	private String rprojectResponsibility;	//项目中的职责
	private String rprojectDescription;		//项目描述
	/**技能**/
	private String skills;					//技能
	/**爱好**/
	private String hobbies;					//爱好
	public Resume() {
		
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRgender() {
		return rgender;
	}
	public void setRgender(String rgender) {
		this.rgender = rgender;
	}
	public Date getRbirthday() {
		return rbirthday;
	}
	public void setRbirthday(Date rbirthday) {
		this.rbirthday = rbirthday;
	}
	public String getRidentityCard() {
		return ridentityCard;
	}
	public void setRidentityCard(String ridentityCard) {
		this.ridentityCard = ridentityCard;
	}
	public String getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public String getRoriginAddress() {
		return roriginAddress;
	}
	public void setRoriginAddress(String roriginAddress) {
		this.roriginAddress = roriginAddress;
	}
	public Date getRgraduateDate() {
		return rgraduateDate;
	}
	public void setRgraduateDate(Date rgraduateDate) {
		this.rgraduateDate = rgraduateDate;
	}
	public String getRnatureWork() {
		return rnatureWork;
	}
	public void setRnatureWork(String rnatureWork) {
		this.rnatureWork = rnatureWork;
	}
	public String getRdesiredCity() {
		return rdesiredCity;
	}
	public void setRdesiredCity(String rdesiredCity) {
		this.rdesiredCity = rdesiredCity;
	}
	public String getRdesiredIndustry() {
		return rdesiredIndustry;
	}
	public void setRdesiredIndustry(String rdesiredIndustry) {
		this.rdesiredIndustry = rdesiredIndustry;
	}
	public String getRdesiredFunction() {
		return rdesiredFunction;
	}
	public void setRdesiredFunction(String rdesiredFunction) {
		this.rdesiredFunction = rdesiredFunction;
	}
	public String getRcurrentStatus() {
		return rcurrentStatus;
	}
	public void setRcurrentStatus(String rcurrentStatus) {
		this.rcurrentStatus = rcurrentStatus;
	}
	public String getRdesiredSalary() {
		return rdesiredSalary;
	}
	public void setRdesiredSalary(String rdesiredSalary) {
		this.rdesiredSalary = rdesiredSalary;
	}
	public String getRdesiredWorktime() {
		return rdesiredWorktime;
	}
	public void setRdesiredWorktime(String rdesiredWorktime) {
		this.rdesiredWorktime = rdesiredWorktime;
	}
	public String getRcompanyName() {
		return rcompanyName;
	}
	public void setRcompanyName(String rcompanyName) {
		this.rcompanyName = rcompanyName;
	}
	public String getRjobIndustry() {
		return rjobIndustry;
	}
	public void setRjobIndustry(String rjobIndustry) {
		this.rjobIndustry = rjobIndustry;
	}
	public String getRjobFunction() {
		return rjobFunction;
	}
	public void setRjobFunction(String rjobFunction) {
		this.rjobFunction = rjobFunction;
	}
	public Date getRjobDateStart() {
		return rjobDateStart;
	}
	public void setRjobDateStart(Date rjobDateStart) {
		this.rjobDateStart = rjobDateStart;
	}
	public Date getRjobDateEnd() {
		return rjobDateEnd;
	}
	public void setRjobDateEnd(Date rjobDateEnd) {
		this.rjobDateEnd = rjobDateEnd;
	}
	public String getRjobType() {
		return rjobType;
	}
	public void setRjobType(String rjobType) {
		this.rjobType = rjobType;
	}
	public Double getRworkExperienceSalary() {
		return rworkExperienceSalary;
	}
	public void setRworkExperienceSalary(Double rworkExperienceSalary) {
		this.rworkExperienceSalary = rworkExperienceSalary;
	}
	public String getRjobTitle() {
		return rjobTitle;
	}
	public void setRjobTitle(String rjobTitle) {
		this.rjobTitle = rjobTitle;
	}
	public String getRjobExperienceDescribe() {
		return rjobExperienceDescribe;
	}
	public void setRjobExperienceDescribe(String rjobExperienceDescribe) {
		this.rjobExperienceDescribe = rjobExperienceDescribe;
	}
	public String getRjobReterence() {
		return rjobReterence;
	}
	public void setRjobReterence(String rjobReterence) {
		this.rjobReterence = rjobReterence;
	}
	public String getRjobReterencePhone() {
		return rjobReterencePhone;
	}
	public void setRjobReterencePhone(String rjobReterencePhone) {
		this.rjobReterencePhone = rjobReterencePhone;
	}
	public String getRprojectName() {
		return rprojectName;
	}
	public void setRprojectName(String rprojectName) {
		this.rprojectName = rprojectName;
	}
	public Date getRprojectStartDate() {
		return rprojectStartDate;
	}
	public void setRprojectStartDate(Date rprojectStartDate) {
		this.rprojectStartDate = rprojectStartDate;
	}
	public Date getRprojectEndDate() {
		return rprojectEndDate;
	}
	public void setRprojectEndDate(Date rprojectEndDate) {
		this.rprojectEndDate = rprojectEndDate;
	}
	public String getRprojectTitle() {
		return rprojectTitle;
	}
	public void setRprojectTitle(String rprojectTitle) {
		this.rprojectTitle = rprojectTitle;
	}
	public String getRprojectResponsibility() {
		return rprojectResponsibility;
	}
	public void setRprojectResponsibility(String rprojectResponsibility) {
		this.rprojectResponsibility = rprojectResponsibility;
	}
	public String getRprojectDescription() {
		return rprojectDescription;
	}
	public void setRprojectDescription(String rprojectDescription) {
		this.rprojectDescription = rprojectDescription;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	@Override
	public String toString() {
		return "Resume [rid=" + rid + ", rname=" + rname + ", rgender=" + rgender + ", rbirthday=" + rbirthday
				+ ", ridentityCard=" + ridentityCard + ", residentialAddress=" + residentialAddress
				+ ", roriginAddress=" + roriginAddress + ", rgraduateDate=" + rgraduateDate + ", rnatureWork="
				+ rnatureWork + ", rdesiredCity=" + rdesiredCity + ", rdesiredIndustry=" + rdesiredIndustry
				+ ", rdesiredFunction=" + rdesiredFunction + ", rcurrentStatus=" + rcurrentStatus + ", rdesiredSalary="
				+ rdesiredSalary + ", rdesiredWorktime=" + rdesiredWorktime + ", rcompanyName=" + rcompanyName
				+ ", rjobIndustry=" + rjobIndustry + ", rjobFunction=" + rjobFunction + ", rjobDateStart="
				+ rjobDateStart + ", rjobDateEnd=" + rjobDateEnd + ", rjobType=" + rjobType + ", rworkExperienceSalary="
				+ rworkExperienceSalary + ", rjobTitle=" + rjobTitle + ", rjobExperienceDescribe="
				+ rjobExperienceDescribe + ", rjobReterence=" + rjobReterence + ", rjobReterencePhone="
				+ rjobReterencePhone + ", rprojectName=" + rprojectName + ", rprojectStartDate=" + rprojectStartDate
				+ ", rprojectEndDate=" + rprojectEndDate + ", rprojectTitle=" + rprojectTitle
				+ ", rprojectResponsibility=" + rprojectResponsibility + ", rprojectDescription=" + rprojectDescription
				+ ", skills=" + skills + ", hobbies=" + hobbies + "]";
	}
	
	
}
