package cn.qblank.job.entity;

public class JobFairShow {
	private String companyName;
	private String schoolName;
	private String address;
	private String city;
	private String num;	//关注人数
	private String startTime;
	private String endTime;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "JobFairShow [companyName=" + companyName + ", schoolName=" + schoolName + ", address=" + address
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
