package cn.qblank.job.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Firm implements Serializable{
	@Id
	@GeneratedValue(generator = "fid")
	@GenericGenerator(name = "fid" , strategy = "native")
	private Integer fid;			//编号
	private String fname;			//公司名称
	private String fdesc;			//公司描述
	private String fsite;			//公司地点
	private String fnum;			//公司规模
	private String fcate;			//公司类型
	private Date foundTime;			//成立时间
	private String fregisterMoney;	//注册资金
	private String ftel;			//联系电话
	private String fleader;			//法人
	private String fleaderTel;		//法人电话
	private String flogo;
	private Integer fcid;			//公司类别编号
	private String industry; 		//公司行业
	@OneToMany()
	private List<Position> positions;
	public Firm(String fname, String fdesc, String fsite, String fnum, String fcate, Date foundTime,
			String fregisterMoney, String ftel, String fleader, String fleaderTel, String flogo) {
		this.fname = fname;
		this.fdesc = fdesc;
		this.fsite = fsite;
		this.fnum = fnum;
		this.fcate = fcate;
		this.foundTime = foundTime;
		this.fregisterMoney = fregisterMoney;
		this.ftel = ftel;
		this.fleader = fleader;
		this.fleaderTel = fleaderTel;
		this.flogo = flogo;
	}
	public Firm() {
		
	}
	
	public Integer getFcid() {
		return fcid;
	}
	public void setFcid(Integer fcid) {
		this.fcid = fcid;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	public String getFsite() {
		return fsite;
	}
	public void setFsite(String fsite) {
		this.fsite = fsite;
	}
	public String getFnum() {
		return fnum;
	}
	public void setFnum(String fnum) {
		this.fnum = fnum;
	}
	public String getFcate() {
		return fcate;
	}
	public void setFcate(String fcate) {
		this.fcate = fcate;
	}
	public Date getFoundTime() {
		return foundTime;
	}
	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}
	public String getFregisterMoney() {
		return fregisterMoney;
	}
	public void setFregisterMoney(String fregisterMoney) {
		this.fregisterMoney = fregisterMoney;
	}
	public String getFtel() {
		return ftel;
	}
	public void setFtel(String ftel) {
		this.ftel = ftel;
	}
	public String getFleader() {
		return fleader;
	}
	public void setFleader(String fleader) {
		this.fleader = fleader;
	}
	public String getFleaderTel() {
		return fleaderTel;
	}
	public void setFleaderTel(String fleaderTel) {
		this.fleaderTel = fleaderTel;
	}
	public String getFlogo() {
		return flogo;
	}
	public void setFlogo(String flogo) {
		this.flogo = flogo;
	}
	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	
	
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	@Override
	public String toString() {
		return "Firm [fid=" + fid + ", fname=" + fname + ", fdesc=" + fdesc + ", fsite=" + fsite + ", fnum=" + fnum
				+ ", fcate=" + fcate + ", foundTime=" + foundTime + ", fregisterMoney=" + fregisterMoney + ", ftel="
				+ ftel + ", fleader=" + fleader + ", fleaderTel=" + fleaderTel + ", flogo=" + flogo + "]";
	}
	
	
	
}
