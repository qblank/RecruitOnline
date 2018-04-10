package cn.qblank.job.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class FirmCate implements Serializable{
	@Id
	@GeneratedValue(generator = "fcid")
	@GenericGenerator(name = "fcid",strategy="native")
	private Integer fcid;
	private String fcname;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Firm> firms;
	
	public Integer getFcid() {
		return fcid;
	}
	public void setFcid(Integer fcid) {
		this.fcid = fcid;
	}
	public String getFcname() {
		return fcname;
	}
	public void setFcname(String fcname) {
		this.fcname = fcname;
	}
	public List<Firm> getFirms() {
		return firms;
	}
	public void setFirms(List<Firm> firms) {
		this.firms = firms;
	}
	@Override
	public String toString() {
		return "FirmCate [fcid=" + fcid + ", fcname=" + fcname + ", firms=" + firms + "]";
	}
	
}
