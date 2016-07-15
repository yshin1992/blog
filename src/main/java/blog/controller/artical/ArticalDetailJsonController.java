package blog.controller.artical;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import blog.constants.URLConstants;
import blog.dao.ArticalDao;
import blog.dao.impl.ArticalDaoImpl;
import blog.util.StringUtil;
import blog.vo.ArticalVO;

/**
 * 获取JSON格式的文章内容
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.ARTICAL_DETAIL_JSON})
public class ArticalDetailJsonController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(URLConstants.PAGE_ARTICAL_DETAIL_JSON).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String articalId = req.getParameter("id");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		if(!StringUtil.isEmpty(articalId))
		{
			ArticalDao dao = new ArticalDaoImpl();
			ArticalVO vo = dao.queryByPK(Integer.parseInt(articalId));
			if(null != vo){
				out.println(JSONObject.fromObject(vo).toString());
			}
			
		}else{
			out.println("内容为空!");
		}
		out.flush();
	}
	
}
