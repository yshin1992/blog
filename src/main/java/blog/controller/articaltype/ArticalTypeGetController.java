package blog.controller.articaltype;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import blog.constants.URLConstants;
import blog.dao.ArticalTypeDao;
import blog.dao.impl.ArticalTypeDaoImpl;
import blog.domain.ArticalType;

/**
 * 获取文章类型(JSON类型)
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.ARTICAL_GET_CHILDS})
public class ArticalTypeGetController extends HttpServlet {

	private static final Logger log = Logger.getLogger(ArticalTypeGetController.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String parentId = req.getParameter("id");
		log.debug("接收到获取文章子类型的请求，父类型:"+parentId);
		if(null != parentId)
		{
			try
			{
				ArticalTypeDao typeDao = new ArticalTypeDaoImpl();
				ArticalType type = new ArticalType();
				type.setId(parentId);
				List<ArticalType> resList = typeDao.reverse(type);
				JSONArray arr = JSONArray.fromObject(resList);
				resp.getWriter().write(arr.toString());
			}catch(Exception e)
			{
				log.error("查询文章子类型异常!",e);
			}
		}
	}

	
}
