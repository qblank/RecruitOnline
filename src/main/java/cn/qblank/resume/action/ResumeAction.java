package cn.qblank.resume.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.qblank.resume.entity.Resume;
import cn.qblank.resume.service.IResumeCateService;
import cn.qblank.resume.service.IResumeService;

@Controller
@Scope("prototype")
public class ResumeAction extends ActionSupport implements ModelDriven<Resume>{
	
	@Autowired
	private IResumeCateService resumeCateService;
	@Autowired
	private IResumeService resumeServce;
	//驱动注入
	private Resume resume = new Resume();
	
	/**
	 * 访问简历页面
	 * @return
	 */
	public String resumeJsp() throws Exception{
		//回显数据 先写死测试
		Resume resumeResult = resumeServce.findResumeById(1);
		//存入session中
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = ac.getContextMap();
		request.put("resumeResult", resumeResult);
		
		return "resumeJsp";
	}
	
	/**
	 * 提交个人信息
	 * @throws Exception
	 */
	public void addPersonInfo () throws Exception{
		//可以通过用户绑定id,查找出id,目前先静态设置
		resume.setRid(1);
		System.out.println(resume);
		resumeServce.saveOrUpdateResume(resume);
		System.out.println("修改成功");
	}

	
	@Override
	public Resume getModel() {
		return resume;
	}
}
