package blog.business.impl;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import blog.business.SystemService;
import blog.util.C3P0DBUtil;

/**
 * 关系型数据库初始化类
 * @author Administrator
 *
 */
public class RelationDBInitService implements SystemService {

	private static final Logger logger = Logger.getLogger(RelationDBInitService.class);
	
	private static DataSource ds;
	
	@Override
	public Map<String, Object> startup() throws Exception{
		logger.debug("初始化连接池");
		ds = C3P0DBUtil.getDataSource();
		logger.debug("初始化连接池成功");
		return null;
	}

	@Override
	public void shutdown() throws Exception{
		logger.warn("关闭数据库连接池");
		C3P0DBUtil.closeDataSource(ds);	
		logger.warn("关闭数据库连接池成功");
	}

	@Override
	public String getServiceName() {
		return "RelationDBInitService";
	}

}
