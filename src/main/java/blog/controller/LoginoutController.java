package blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.constants.SysConstants;
import blog.constants.URLConstants;

/**
 * 用户登出 
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.LOGINOUT})
public class LoginoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(null != req.getSession().getAttribute(SysConstants.CURRENT_USER))
		{
			req.getSession().invalidate();
		}
		req.getRequestDispatcher(URLConstants.PAGE_LOGIN).forward(req, resp);
	}
	
	
}
