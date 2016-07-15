package blog.controller.artical;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.constants.SysConstants;
import blog.constants.URLConstants;
import blog.dao.ArticalDao;
import blog.dao.impl.ArticalDaoImpl;
import blog.util.StringUtil;
import blog.vo.ArticalVO;

/**
 * 或者文章信息Controller
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.ARTICAL_DETAIL})
public class ArticalDetailController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		if(!StringUtil.isEmpty(id)){
			ArticalDao dao = new ArticalDaoImpl();
			ArticalVO vo = dao.queryByPK(Integer.parseInt(id));
			if(null != vo){
				req.setAttribute("artical", vo);
				req.getRequestDispatcher(URLConstants.PAGE_ARTICAL_DETAIL).forward(req, resp);
				return;
			}
		}
		req.setAttribute(SysConstants.URL_RETURN, URLConstants.INDEX);
		req.setAttribute(SysConstants.OPERATE_RESULT, SysConstants.OPERATE_FAILURE);
		req.getRequestDispatcher(URLConstants.PAGE_RESULT).forward(req, resp);
	}
	
	
}
