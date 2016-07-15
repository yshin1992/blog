package blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.constants.SysConstants;
import blog.constants.URLConstants;
import blog.dao.UserDao;
import blog.dao.impl.UserDaoImpl;
import blog.domain.User;

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
		String userName = req.getParameter("username");
		String passwd = req.getParameter("passwd");
		if(null != userName && null != passwd)
		{
			UserDao dao = new UserDaoImpl();
			User user = dao.queryUser(userName, passwd);
			if(null != user)
			{
				req.getSession().setAttribute(SysConstants.CURRENT_USER, user);
				resp.sendRedirect(req.getContextPath()+URLConstants.INDEX);
				return ;
			}
		}
		req.setAttribute(SysConstants.ERROR_INFO, "用户名或密码错误!");
		req.getRequestDispatcher(URLConstants.PAGE_LOGIN).forward(req, resp);
	}

	
}
