package cn.qblank.job.entity;

import java.io.Serializable;
/**
 * 存储职位和公司的信息
 * @author evan_qb
 *
 */
public class Firm_t_position implements Serializable{
	private static final long serialVersionUID = 9080769181711379913L;
	private Firm firm;
	private Position position;
	
	public Firm getFirm() {
		return firm;
	}
	public void setFirm(Firm firm) {
		this.firm = firm;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	
}
