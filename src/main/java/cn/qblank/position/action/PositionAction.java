package cn.qblank.position.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.qblank.job.entity.Position;
import cn.qblank.position.service.IPositionService;

@Controller
public class PositionAction extends ActionSupport implements ServletRequestAware{
	private Log logger = LogFactory.getLog(PositionAction.class);
	
	private HttpServletRequest request;
	
	@Autowired
	private IPositionService positionService;
	
	/**
	 * 查看职位详细内容
	 * @return
	 */
	public String posdetail() {
		Position pos = positionService.findPosById(1);
		
		return "posdetail";
	}
	
	/**
	 * 查看一个公司下的所有职位
	 * @return
	 */
	public String findAllPos() {
		List<Position> positions = positionService.findAllPos(1);
		
		return "";
	}
	
	
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
