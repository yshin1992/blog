package blog.controller.artical;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.constants.SysConstants;
import blog.constants.URLConstants;
import blog.dao.ArticalDao;
import blog.dao.impl.ArticalDaoImpl;
import blog.domain.Artical;
import blog.domain.User;
import blog.util.StringUtil;

/**
 * 新建Blog控制器
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.ARTICAL_CREATE})
public class ArticalCreateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher(URLConstants.PAGE_ARTICAL_CREATE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String htmlData = req.getParameter("content1");
		String type = req.getParameter("articalType");
		String title = req.getParameter("title");
		
		if(!StringUtil.isEmpty(htmlData) && !StringUtil.isEmpty(type) 
				&& !StringUtil.isEmpty(title)){
			Artical artical = new Artical();
			artical.setTitle(StringUtil.trimEmpty(title));
			artical.setTypeId(StringUtil.trimEmpty(type));
			artical.setContent(htmlData);
			User user = (User)req.getSession().getAttribute(SysConstants.CURRENT_USER);
			artical.setAuthorId(user.getId());
			artical.setCreateTime(new Timestamp(new Date().getTime()));
			ArticalDao artDao = new ArticalDaoImpl();
			int articalId = artDao.create(artical);
			if(articalId != -1)
			{
				req.setAttribute(SysConstants.OPERATE_RESULT, SysConstants.OPERATE_SUCCESS);
			}else{
				req.setAttribute(SysConstants.OPERATE_RESULT, SysConstants.OPERATE_FAILURE);
			}
			req.setAttribute(SysConstants.URL_RETURN, URLConstants.INDEX);
			req.getRequestDispatcher(URLConstants.PAGE_RESULT).forward(req, resp);
		}
	}
	
	

}
