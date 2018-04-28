package cn.qblank.job.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.WebUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.qblank.job.entity.Firm;
import cn.qblank.job.entity.FirmCate;
import cn.qblank.job.entity.Position;
import cn.qblank.job.service.IJobCateService;
import cn.qblank.job.service.IJobService;

@Controller
@Scope("prototype")
public class JobAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = -6140086064530486350L;
	
	private HttpServletRequest request;
	@Autowired
	private IJobService jobService;
	@Autowired
	private IJobCateService jobCateService;
	
	/**
	 * 获取公司信息并返回首页
	 * @throws Exception
	 */
	public String indexJsp() throws Exception{
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = ac.getContextMap();
		//获取所有类
		List<FirmCate> firmCates = jobCateService.findAllFirmCate();
		List<Firm> firmITs = null;
		for (int i = 0; i < firmCates.size(); i++) {
			firmITs = jobService.findCateById(i + 1, 0, 6);
			firmCates.get(i).setFirms(firmITs);
		}
		//获取IT类的公司
		request.put("firmCates", firmCates);
		return "indexJsp";
	}
	
	/**
	 * 跳转到jobDetail中
	 */
	public String firmDetail() throws Exception{
		//通过编号查找公司信息
		String fid = request.getParameter("fid");
		if (fid != null) {
			Firm firm = jobService.findById(Integer.parseInt(fid));
			List<Position> positions = jobService.findPosByFirm(firm);
			//使用WebUtils工具类将firm的信息存储进去
			WebUtils.setSessionAttribute(request, "firm", firm);
			WebUtils.setSessionAttribute(request, "positions", positions);
		}
		return "firmDetail";
	}
	
	/**
	 * 进入work细节目录
	 * @return
	 * @throws Exception
	 */
	public String jobdetail() throws Exception {
		String pid = request.getParameter("pid");
		if (pid != null) {
			int spid = Integer.parseInt(pid);
			 Position position = jobService.findPosById(spid);
			 WebUtils.setSessionAttribute(request, "position", position);
		}
		return "jobdetail";
	}
	
	/**
	 * 进入招聘会的页面
	 * @return
	 * @throws Exception
	 */
	public String jobFair() throws Exception{
		
		
		return "jobFair";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	
}
