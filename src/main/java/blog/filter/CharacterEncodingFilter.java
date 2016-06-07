package blog.filter;

import static blog.constants.SysConstants.DEFAULT_CHARSET;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 字符编码过滤器
 * 
 * @author Administrator
 *
 */
@WebFilter(filterName = "characterEncodingFilter", urlPatterns = { "*.do" }, initParams = {
		@WebInitParam(name="charset",value=DEFAULT_CHARSET)
})
public class CharacterEncodingFilter implements Filter {

	private String charset;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding(charset);
		chain.doFilter(req, resp);
//		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding(charset);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		charset = config.getInitParameter("charset");
	}

}
