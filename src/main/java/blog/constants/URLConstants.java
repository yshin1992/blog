package blog.constants;

public interface URLConstants {
	
	static String PAGE_PREFIX = "/WEB-INF/pages/";
	
	/****************** 用户相关页面和controller *******************/
	static String LOGIN = "/login.do";
	
	static String PAGE_LOGIN = PAGE_PREFIX + "login.jsp";
	
	static String PAGE_RESULT = PAGE_PREFIX + "common/result.jsp";
	
	static String INDEX = "/index.do";
	
	static String PAGE_INDEX = PAGE_PREFIX + "index.jsp";
	
	static String LOGINOUT = "/loginout.do";
	
	/****************** Blog相关页面和controller *******************/
	static String ARTICAL_PREFIX = "/artical";
	
	static String ARTICAL_CREATE = ARTICAL_PREFIX + "/create.do";
	
	static String PAGE_ARTICAL_CREATE = PAGE_PREFIX + ARTICAL_PREFIX + "/create.jsp";
	
	/****************** ArticalType相关页面和controller *******************/
	static String ARTICAL_TYPE_PREFIX = "/articalType";
	
	static String ARTICAL_INDEX = ARTICAL_TYPE_PREFIX +"/index.do";
	
	static String PAGE_ARTICAL_INDEX = PAGE_PREFIX + ARTICAL_PREFIX + "/type.jsp";
	
	static String ARTICAL_DELETE = ARTICAL_TYPE_PREFIX + "/delete.do";
	
	static String ARTICAL_ADD = ARTICAL_TYPE_PREFIX + "/add.do";
	
	static String ARTICAL_GET_CHILDS = ARTICAL_TYPE_PREFIX + "/getChilds.do";
	
}
