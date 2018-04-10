package cn.qblank.resume.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ResumeCate implements Serializable{
	
	 /*
		private String personInfo;		//个人信息
		private String contactStyle;	//联系方式
		private String learnExperience;	//教育经历
		private String target;			//求职意向
		private String workExperience;	//实习经验
		private String projectExperience;	//项目经验
		private String describe;		//自我评价
		private String hobbies;			//爱好
		private String skills;			//技能
	 */	
	@Id
	@GeneratedValue(generator = "rcid")
	@GenericGenerator(name = "rcid" , strategy = "native")
	private Integer rcid;
	private String text;
	public ResumeCate() {
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public ResumeCate(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "ResumeCate [rcid=" + rcid + ", text=" + text + "]";
	}
	
}
