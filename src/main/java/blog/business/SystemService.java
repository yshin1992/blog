package blog.business;

import java.util.Map;

/**
 * 系统服务类
 * 包含启动方法和关闭方法
 * @author Administrator
 *
 */
public interface SystemService{
	
	public Map<String,Object> startup() throws Exception;
	
	public void shutdown() throws Exception;
	
	public String getServiceName();
}
