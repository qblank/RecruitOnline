package cn.qblank.job.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_position")
public class Position implements Serializable{
	@Id
	@GeneratedValue(generator = "pid")
	@GenericGenerator(name = "pid",strategy ="native")
	private Integer pid;			//职位编号
	private String pname;			//职位名字
	private Integer pnum;			//所需人数
	private String pdesc;			//职位描述
	private Integer fid;			//公司编号
	private String pduty;			//职责
	private String prequire;		//要求	
	private String pcontactPeople;	//联系人
	private String pcontactTel;		//联系电话
	private String pcontactEmail;	//联系有相同
	private Integer cid; 			//类别编号
	private Date pubdate;			//发布时间
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getPduty() {
		return pduty;
	}
	public void setPduty(String pduty) {
		this.pduty = pduty;
	}
	public String getPrequire() {
		return prequire;
	}
	public void setPrequire(String prequire) {
		this.prequire = prequire;
	}
	public String getPcontactPeople() {
		return pcontactPeople;
	}
	public void setPcontactPeople(String pcontactPeople) {
		this.pcontactPeople = pcontactPeople;
	}
	public String getPcontactTel() {
		return pcontactTel;
	}
	public void setPcontactTel(String pcontactTel) {
		this.pcontactTel = pcontactTel;
	}
	public String getPcontactEmail() {
		return pcontactEmail;
	}
	public void setPcontactEmail(String pcontactEmail) {
		this.pcontactEmail = pcontactEmail;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	@Override
	public String toString() {
		return "Position [pid=" + pid + ", pname=" + pname + ", pnum=" + pnum + ", pdesc=" + pdesc + ", fid=" + fid
				+ ", pduty=" + pduty + ", prequire=" + prequire + ", pcontactPeople=" + pcontactPeople
				+ ", pcontactTel=" + pcontactTel + ", pcontactEmail=" + pcontactEmail + ", cid=" + cid + "]";
	}
	public Position(Integer pid, String pname, Integer pnum, String pdesc, Integer fid, String pduty, String prequire,
			String pcontactPeople, String pcontactTel, String pcontactEmail, Integer cid) {
		this.pid = pid;
		this.pname = pname;
		this.pnum = pnum;
		this.pdesc = pdesc;
		this.fid = fid;
		this.pduty = pduty;
		this.prequire = prequire;
		this.pcontactPeople = pcontactPeople;
		this.pcontactTel = pcontactTel;
		this.pcontactEmail = pcontactEmail;
		this.cid = cid;
	}
	public Position() {
		
	}
	
}
