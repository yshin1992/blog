package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.constants.URLConstants;
import blog.dao.ArticalDao;
import blog.dao.impl.ArticalDaoImpl;
import blog.vo.ArticalPagination;
import blog.vo.ArticalVO;

/**
 * 首页(加载文章列表)
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.INDEX})
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArticalDao dao = new ArticalDaoImpl();
		List<ArticalVO> articalList = dao.queryByPage();
//		ArticalPagination ap = new ArticalPagination();
//		ap.setResList(articalList);
		req.setAttribute("articalList", articalList);
		req.getRequestDispatcher(URLConstants.PAGE_INDEX).forward(req, resp);
	}

	
}
