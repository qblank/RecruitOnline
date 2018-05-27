package cn.qblank.job.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.WebUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.qblank.job.entity.Firm;
import cn.qblank.job.entity.FirmCate;
import cn.qblank.job.entity.Firm_t_position;
import cn.qblank.job.entity.JobFair;
import cn.qblank.job.entity.JobFairShow;
import cn.qblank.job.entity.Position;
import cn.qblank.job.service.IJobCateService;
import cn.qblank.job.service.IJobService;
import cn.qblank.position.service.IPositionService;

@Controller
@Scope("prototype")
public class JobAction extends ActionSupport implements ServletRequestAware{
	private Log logger = LogFactory.getLog(JobAction.class);
	private static final long serialVersionUID = -6140086064530486350L;
	
	private HttpServletRequest request;
	@Autowired
	private IJobService jobService;
	@Autowired
	private IJobCateService jobCateService;
	@Autowired
	private IPositionService positionService;
	
	
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
			firmITs = jobService.findCateById(i + 1, 0, 12);
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
		//用户存储页面所需数据
		List<JobFairShow> jobFairShows = new ArrayList<>();
		//查询招聘会的信息
		List<JobFair> jobFairs = jobService.findAllJobFair();
		for (JobFair jobFair : jobFairs) {
			Firm firm = jobService.findById(jobFair.getFid());
			//将查询到的信息封装到JobFairShow中
			JobFairShow jobFairShow = new JobFairShow();
			jobFairShow.setCompanyName(firm.getFname());
			jobFairShow.setSchoolName(jobFair.getSchoolName());
			jobFairShow.setAddress(jobFair.getAddress());
			jobFairShow.setStartTime(jobFair.getStartTime());
			jobFairShow.setEndTime(jobFair.getEndTime());
			jobFairShow.setCity(jobFair.getCity());
			//将封装的数据放入集合中
			jobFairShows.add(jobFairShow);
		}
//		WebUtils.setSessionAttribute(request, "jobFairShows", jobFairShows);
		request.setAttribute("jobFairShows", jobFairShows);
		return "jobFair";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * 跳转到搜索页面
	 * @return
	 * @throws Exception
	 */
	public String searchPage() throws Exception{
		//获取搜索的关键字
		String searchName = request.getParameter("searchName");
		if (StringUtils.isNotEmpty(searchName)) {
			searchName = new String(searchName.getBytes("ISO-8859-1"),"UTF-8");
			//模糊查询出者职位
			/*List<Firm> searchFirms = jobService.findFirmByName(searchName);
			request.setAttribute("searchFirms", searchFirms);*/
			List<Position> searchPositions = positionService.findByName(searchName);
			//用于存储数据
			List<Firm_t_position> firmPositions = new ArrayList<>();
			if (searchPositions!= null && searchPositions.size() > 0) {
				for (Position position : searchPositions) {
					//通过职位查出公司
					Firm firm = jobService.findById(position.getFid());
					Firm_t_position firmPosition = new Firm_t_position();
					firmPosition.setPosition(position);
					firmPosition.setFirm(firm);
					firmPositions.add(firmPosition);
				}
				//将封装的数据存储到域中
				request.setAttribute("searchPositions", firmPositions);
			}
		}else {
			List<Position> searchPostions = positionService.findAllPos();
			//用于存储数据
			List<Firm_t_position> firmPositions = new ArrayList<>();
			for (Position position : searchPostions) {
				//通过职位查出公司
				Firm firm = jobService.findById(position.getFid());
				Firm_t_position firmPosition = new Firm_t_position();
				firmPosition.setPosition(position);
				firmPosition.setFirm(firm);
				firmPositions.add(firmPosition);
			}
			request.setAttribute("searchPositions", firmPositions);
		}
		return "searchPage";
	}

	
}
