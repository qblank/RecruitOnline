package cn.qblank.job.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Firm_t_position implements Serializable{
	@Id
	private Integer Firm_fid;
	private Integer positions_pid;
	
	
	public Integer getFirm_fid() {
		return Firm_fid;
	}
	public void setFirm_fid(Integer firm_fid) {
		Firm_fid = firm_fid;
	}
	public Integer getPositions_pid() {
		return positions_pid;
	}
	public void setPositions_pid(Integer positions_pid) {
		this.positions_pid = positions_pid;
	}
	
	
}
