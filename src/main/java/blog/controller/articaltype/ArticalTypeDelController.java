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
 * 文章类型删除controller
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.ARTICAL_DELETE})
public class ArticalTypeDelController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String delId = req.getParameter("id");
		if(null != delId){
			ArticalTypeDao typeDao = new ArticalTypeDaoImpl();
			ArticalType parent = new ArticalType();
			parent.setId(delId);
			List<ArticalType> childs = typeDao.reverse(parent);
			/**
			 * 当文章类型有子类型时，提示不能删除
			 */
			if(null != childs && childs.size() > 0){
				resp.getWriter().print("-1");
				return;
			}
			int delRows = typeDao.delete(delId);
			resp.getWriter().print(delRows);
		}
	}

}
