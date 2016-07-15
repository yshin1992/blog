package blog.constants;

public abstract class URLConstants {
	
	private static final String PAGE_PREFIX = "/WEB-INF/pages/";
	
	/****************** 用户相关页面和controller *******************/
	public static final String LOGIN = "/login.do";
	
	public static final String PAGE_LOGIN = PAGE_PREFIX + "login.jsp";
	
	public static final String PAGE_RESULT = PAGE_PREFIX + "common/result.jsp";
	
	public static final String INDEX = "/index.do";
	
	public static final String PAGE_INDEX = PAGE_PREFIX + "index.jsp";
	
	public static final String LOGINOUT = "/loginout.do";
	
	/****************** Blog相关页面和controller *******************/
	private static final String ARTICAL_PREFIX = "/artical";
	
	public static final String ARTICAL_CREATE = ARTICAL_PREFIX + "/create.do";
	
	public static final String PAGE_ARTICAL_CREATE = PAGE_PREFIX + ARTICAL_PREFIX + "/create.jsp";
	
	public static final String ARTICAL_FILE_UPLOAD = ARTICAL_PREFIX + "/fileUpload.do";
	
	public static final String ARTICAL_FILE_MANAGE = ARTICAL_PREFIX + "/fileManage.do";
	
	public static final String ARTICAL_DETAIL = ARTICAL_PREFIX + "/detail.do";
	
	public static final String PAGE_ARTICAL_DETAIL = PAGE_PREFIX + ARTICAL_PREFIX + "/detail.jsp";
	
	public static final String ARTICAL_DETAIL_JSON = ARTICAL_PREFIX + "/jsondetail.do";
	
	public static final String PAGE_ARTICAL_DETAIL_JSON = PAGE_PREFIX + ARTICAL_PREFIX + "/jsondetail.jsp";
	
	/****************** ArticalType相关页面和controller *******************/
	private static final String ARTICAL_TYPE_PREFIX = "/articalType";
	
	public static final String ARTICAL_INDEX = ARTICAL_TYPE_PREFIX +"/index.do";
	
	public static final String PAGE_ARTICAL_INDEX = PAGE_PREFIX + ARTICAL_PREFIX + "/type.jsp";
	
	public static final String ARTICAL_DELETE = ARTICAL_TYPE_PREFIX + "/delete.do";
	
	public static final String ARTICAL_ADD = ARTICAL_TYPE_PREFIX + "/add.do";
	
	public static final String ARTICAL_GET_CHILDS = ARTICAL_TYPE_PREFIX + "/getChilds.do";
	
}
