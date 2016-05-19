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
 * 用户登录
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.LOGIN})
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(URLConstants.PAGE_LOGIN).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute(SysConstants.OPERATE_RESULT, SysConstants.OPERATE_SUCCESS);
		req.setAttribute(SysConstants.URL_RETURN , URLConstants.LOGIN );
		req.getRequestDispatcher(URLConstants.PAGE_RESULT).forward(req, resp);
	}

	
}
