package blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import blog.dao.ArticalTypeDao;
import blog.dao.impl.ArticalTypeDaoImpl;
import blog.domain.ArticalType;

/**
 * 文章类型添加Controller
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={"/articalType/add.do"})
public class ArticalTypeAddController extends HttpServlet {

	private static final Logger log = Logger.getLogger(ArticalTypeAddController.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String typeName = req.getParameter("typeName");
		String pidStr = req.getParameter("pid");
		if(null != typeName && null != pidStr)
		{
			try
			{
				Short pid = Short.valueOf(pidStr);
				ArticalType type = new ArticalType();
				type.setParentId(pid);
				type.setTypeName(typeName);
				ArticalTypeDao dao = new ArticalTypeDaoImpl();
				dao.create(type);
			}catch(Exception e)
			{
				log.error("添加文章类型异常!",e);
			}
		}
	}
	
}
