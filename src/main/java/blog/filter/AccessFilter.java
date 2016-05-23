package blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import blog.constants.SysConstants;
import blog.constants.URLConstants;

/**
 * 用户访问过滤器
 * @author Administrator
 *
 */
@WebFilter(filterName="accessFilter",urlPatterns={"*.do"})
public class AccessFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		if(null !=req.getSession().getAttribute(SysConstants.CURRENT_USER) 
				&& req.getRequestURL().indexOf(URLConstants.LOGIN) != -1)
		{
			//防止用户反复登录
			req.getRequestDispatcher(URLConstants.PAGE_INDEX).forward(request, response);
			return ;
		}
		if(null == req.getSession().getAttribute(SysConstants.CURRENT_USER) 
				&& !req.getRequestURI().endsWith(URLConstants.LOGIN))
		{
			//防止未登录的用户访问
			req.getRequestDispatcher(URLConstants.PAGE_LOGIN).forward(request, response);
			return ;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
