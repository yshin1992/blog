package blog.controller.articaltype;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import blog.constants.URLConstants;
import blog.dao.ArticalTypeDao;
import blog.dao.impl.ArticalTypeDaoImpl;
import blog.domain.ArticalType;

/**
 * 文章类型添加Controller
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.ARTICAL_ADD})
public class ArticalTypeAddController extends HttpServlet {

	private static final Logger log = Logger.getLogger(ArticalTypeAddController.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String typeName = req.getParameter("typeName");
		String pidStr = req.getParameter("pid");
		if(null != typeName && null != pidStr)
		{
			try
			{
				ArticalType type = new ArticalType();
				String id = UUID.randomUUID().toString().toUpperCase();
				type.setId(id);
				type.setParentId(pidStr.trim());
				type.setTypeName(typeName);
				ArticalTypeDao dao = new ArticalTypeDaoImpl();
				dao.create(type);
				//返回新增的主键id
				resp.getWriter().println(id);
			}catch(Exception e)
			{
				log.error("添加文章类型异常!",e);
			}
		}
	}
}
