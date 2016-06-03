package blog.controller.articaltype;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.constants.URLConstants;
import blog.dao.ArticalTypeDao;
import blog.dao.impl.ArticalTypeDaoImpl;
import blog.domain.ArticalType;

/**
 * 文章类型主页
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.ARTICAL_INDEX})
public class ArticalTypeIndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 查询出文章ID的所有子文章类型
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String queryId = req.getParameter("id");
		ArticalType type = null;
		if(null != queryId)
		{
			type = new ArticalType();
			type.setId(Short.valueOf(queryId));
		}
		
		ArticalTypeDao typeDao = new ArticalTypeDaoImpl();
		List<ArticalType> typeList = typeDao.reverse(type);
		req.setAttribute("resList", typeList);
		req.getRequestDispatcher(URLConstants.PAGE_ARTICAL_INDEX).forward(req, resp);
	}
	
	
}
