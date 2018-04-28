package cn.qblank.resume.action;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.WebUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.qblank.resume.entity.Resume;
import cn.qblank.resume.service.IResumeCateService;
import cn.qblank.resume.service.IResumeService;
import cn.qblank.user.entity.User;

@Controller
@Scope("prototype")
public class ResumeAction extends ActionSupport implements ModelDriven<Resume>,ServletRequestAware,ServletResponseAware{
	private static Log logger = LogFactory.getLog(ResumeAction.class);
	
	@Autowired
	private IResumeCateService resumeCateService;
	@Autowired
	private IResumeService resumeServce;
	//驱动注入
	private Resume resume = new Resume();
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	/**
	 * 访问简历页面
	 * @return
	 */
	public String resumeJsp() throws Exception{
		//通过用户来绑定简历一对一
		User user = (User) WebUtils.getSessionAttribute(request, "sessionUser");
		//回显数据
		Resume resumeResult = resumeServce.findResumeByUid(user.getId());
		//存入session中
		WebUtils.setSessionAttribute(request, "resumeResult", resumeResult);
		/*ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = ac.getContextMap();
		request.put("resumeResult", resumeResult);*/
		
		return "resumeJsp";
	}
	
	/**
	 * 提交个人信息
	 * @throws Exception
	 */
	public void addPersonInfo () throws Exception{
		//获取编号
		String id = request.getParameter("id");
		User user = (User) WebUtils.getSessionAttribute(request, "sessionUser");
		//可以通过用户绑定id
		resume.setUid(user.getId());
		//result用户获取数据库简历信息  resume用户获取提交的信息
		Resume result = resumeServce.findResumeByUid(user.getId());
		
		if (result == null) {
			resumeServce.save(resume);
		}else {
			logger.debug(result.getRname());
			resume.setRid(result.getRid());
			switch (id) {
				case "1":
					//单独获取性别
					String rgender = request.getParameter("rgender");
					//将用户信息设置进结果中
					result.setRbirthday(resume.getRbirthday());
					result.setResidentialAddress(resume.getResidentialAddress());
					result.setRgraduateDate(resume.getRgraduateDate());
					result.setRidentityCard(resume.getRidentityCard());
					result.setRname(resume.getRname());
					result.setRoriginAddress(resume.getRoriginAddress());
					result.setRgender(rgender);
					result.setRevaluation(resume.getRevaluation());
					resumeServce.update(result);
					break;
				case "2":
					result.setRphone(resume.getRphone());
					result.setRemail(resume.getRemail());
					resumeServce.update(result);
					break;
				case "3":
					String reducationType = request.getParameter("reducationType");
					if (reducationType != null && !"".equals(reducationType)) {
						result.setReducationType(Integer.parseInt(reducationType));
					}
					result.setRschoolname(resume.getRschoolname());
					result.setRstartDate(resume.getRstartDate());
					result.setRgraduateDate(resume.getRgraduateDate());
					result.setRprofessional(resume.getRprofessional());
					resumeServce.update(result);
					break;
				case "4":
					String rcurrentStatus = request.getParameter("rcurrentStatus");
					if (rcurrentStatus != null && !"".equals(rcurrentStatus)) {
						result.setRcurrentStatus(rcurrentStatus);
					}
					result.setRnatureWork(resume.getRnatureWork());
					result.setRdesiredCity(resume.getRdesiredCity());
					result.setRdesiredIndustry(resume.getRdesiredIndustry());
					result.setRdesiredFunction(resume.getRdesiredFunction());
					result.setRdesiredSalary(resume.getRdesiredSalary());
					result.setRdesiredWorktime(resume.getRdesiredWorktime());
					resumeServce.update(result);
					break;
				default:
					break;
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write("success");
		pw.close();
	}
	
	/**
	 * 进入简历预览页面
	 * @return
	 */
	public String resumePre() {
		return "resumePre";
	}
	
	/**
	 * 将网页内容导出pdf文档
	 */
	public String exportResume() throws Exception{
		ServletInputStream in = request.getInputStream();
		//创建 POIFSFileSystem 对象  
        POIFSFileSystem poifs = new POIFSFileSystem();    
        //获取DirectoryEntry  
        DirectoryEntry directory = poifs.getRoot();    
        //创建输出流  
        OutputStream out = new FileOutputStream("d:\\html2word.doc");
      //创建文档,1.格式,2.HTML文件输入流  
        directory.createDocument("WordDocument", in);  
        //写入  
        poifs.writeFilesystem(out);  
        //释放资源  
        out.close();  
//        response.setHeader("Content-Disposition", "attachment;filename=" + out);
        logger.debug("success");
        return "resumeJsp";
	}
	

	
	@Override
	public Resume getModel() {
		return resume;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
