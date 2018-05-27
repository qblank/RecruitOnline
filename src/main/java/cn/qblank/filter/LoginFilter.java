package cn.qblank.filter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.util.WebUtils;

import cn.qblank.user.entity.User;


/**
 * 登陆过滤器
 * @author evan_qb
 *
 */
public class LoginFilter implements Filter {
	private static final Log logger = LogFactory.getLog(LoginFilter.class);
	/**
	 * 默认后缀
	 */
	private static final String DEFAULT_ACTION_TAG = ".action";
	private static final String DEFAULT_ACTION_METHOD = "action";
	private static final String DEFAULT_URI_SEPARATOR = "/";
	private static final String PUBLICURL_CONTEXT_ID = "recruit.web.publicUrl";
	private static final String LOGINEDURL_CONTEXT_ID = "recruit.web.loginedUrl";
	private static final String ADMINURL_CONTEXT_ID = "recruit.web.adminUrl";
	
	private FilterConfig config;
	/**
	 * 初始化过滤器
	 * @param context
	 */
	private void initFilter(ServletContext context) {
		initPublicUrl(context);
		initLoginUrl(context);
		initAdminUrl(context);
		logger.info("权限过滤器初始化成功,[" + PUBLICURL_CONTEXT_ID + "," + LOGINEDURL_CONTEXT_ID + ","+ ADMINURL_CONTEXT_ID +"]初始化成功");
	}
	
	/**
	 * 设置过滤条件
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = getUrl(req);
		logger.debug(uri);
		//判断是否是公共资源
		if (isPublicUri(uri)) {
			chain.doFilter(req, resp);
			return;
		}
		
		//判断是否是管理员登陆
		if (!isAdminLogin(req) && isAdminPublicUri(uri)) {
			resp.sendRedirect("admin_adminLoginJsp.action");
			return;
		}
		//是否已登陆
		if (!isLogin(req) && isLoginedPublicUri(uri)) {
			resp.sendRedirect("user_loginJsp.action");
			return;
		}
		chain.doFilter(req, resp);
	}
								
	/**
	 * 获取返回的Uri
	 * @param request
	 * @return
	 */
	private static String getUrl(HttpServletRequest request) {
		String uri = request.getRequestURI();
		if (uri.endsWith(DEFAULT_ACTION_TAG)) {
			String action = request.getParameter(DEFAULT_ACTION_METHOD);
			if (StringUtils.isNotEmpty(action)) {
				uri = new StringBuffer(uri).append("?action=").append(action).toString();
			}
		}
		return uri;
	}
	
	/**
	 * 初始化公共资源
	 * @param context
	 */
	private void initPublicUrl(ServletContext context) {
		final String[] PUBLIC_URLS = {
				"/",
				"/index.action",
				"/user_loginJsp.action",
				"/user_login.action",
				"/user_register.action",
				"/job_firmDetail.action",
				"/job_jobdetail.action",
				"/admin_adminLoginJsp.action",
				"/admin_adminLogin.action",
				"/job_jobFair.action",
				"/job_searchPage.action",
				"/user_identityCode.action",
				"/user_registerJsp.action"
		};
		
		Map<String,String> publicUrlMap = new ConcurrentHashMap<>();
		for (String publicUrl : PUBLIC_URLS) {
			publicUrlMap.put(publicUrl, publicUrl);
		}
		context.setAttribute(PUBLICURL_CONTEXT_ID, publicUrlMap);
	}
	/**
	 * 初始化登录后才能访问的Url
	 * @param context
	 */
	private void initLoginUrl(ServletContext context) {
		final String[] LOGINED_URLS = {
				"/user_withdraw.action",
				"/user_test.action",
				"/user_noticeJsp.action",
				"/resume_resumeJsp.action",
				
		};
		Map<String,String> loginedUrlMap = new ConcurrentHashMap<>();
		for (String loginedUrl : LOGINED_URLS) {
			loginedUrlMap.put(loginedUrl, loginedUrl);
		}
		context.setAttribute(LOGINEDURL_CONTEXT_ID, loginedUrlMap);
	}
	
	/**
	 * 初始化管理员登陆才能访问的url
	 * @param context
	 */
	private void initAdminUrl(ServletContext context) {
		final String[] ADMIN_URLS = {
				"/admin_adminIndex.action"
		};
		Map<String,String> adminUrlMap = new ConcurrentHashMap<>();
		for (String adminUrl : ADMIN_URLS) {
			adminUrlMap.put(adminUrl, adminUrl);
		}
		context.setAttribute(ADMINURL_CONTEXT_ID, adminUrlMap);
	}
	
	/**
	 * 判断时否是公共资源
	 * @param uri
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean isPublicUri(String uri) {
		String subUri = uri.substring(uri.lastIndexOf(DEFAULT_URI_SEPARATOR), uri.length());
		
		Map<String,String> publicUrlMap = (Map<String,String>)this.config.getServletContext().getAttribute(PUBLICURL_CONTEXT_ID);
		
		return publicUrlMap.containsKey(subUri);
	}
	/**
	 * 判断是否登陆
	 * @param request
	 * @return
	 */
	private boolean isLogin(HttpServletRequest request) {
		Object sessionUser = WebUtils.getSessionAttribute(request, "sessionUser");
		return (sessionUser != null && !sessionUser.equals(""));
		
	}
	/**
	 * 判断是否是管理员登陆
	 * @param request
	 * @return
	 */
	private boolean isAdminLogin(HttpServletRequest request) {
		Object adminUser = WebUtils.getSessionAttribute(request, "adminUser");
		return (adminUser !=null && !adminUser.equals(""));
	}
	/**
	 * 登陆后可访问的公共url.
	 * @param uri
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	private boolean isLoginedPublicUri(String uri) {
		String subUri = uri.substring(uri.lastIndexOf(DEFAULT_URI_SEPARATOR), uri.length());
		
        Map<String,String> loginedUrlMap = (Map<String,String>)this.config.getServletContext().getAttribute(LOGINEDURL_CONTEXT_ID);
		
		return loginedUrlMap.containsKey(subUri);
	}
	@SuppressWarnings("unchecked")
	private boolean isAdminPublicUri(String uri) {
		String subUri = uri.substring(uri.lastIndexOf(DEFAULT_URI_SEPARATOR), uri.length());
		
        Map<String,String> adminUrlMap = (Map<String,String>)this.config.getServletContext().getAttribute(ADMINURL_CONTEXT_ID);
		
		return adminUrlMap.containsKey(subUri);
	}
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		initFilter(this.config.getServletContext());
	}
	
	/**
	 * 销毁过滤器
	 */
	private void destroyFilter() {
		ServletContext context = this.config.getServletContext();
		context.removeAttribute(PUBLICURL_CONTEXT_ID);
		context.removeAttribute(LOGINEDURL_CONTEXT_ID);
		this.config = null;
		
		logger.info("权限过滤器销毁成功,[" + PUBLICURL_CONTEXT_ID + "," + LOGINEDURL_CONTEXT_ID + "," + ADMINURL_CONTEXT_ID +"]移除成功");
	}
	public void destroy() {
		destroyFilter();
	}

}
