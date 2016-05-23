package blog.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import blog.business.SystemService;
import blog.business.impl.RelationDBInitService;

/**
 * WebContext 容器监听类
 * @author Administrator
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {
	
	private List<SystemService> systemServices;
	
	private static final Logger logger = Logger.getLogger(ContextListener.class);
	
	public ContextListener() {
		// TODO Auto-generated constructor stub
		super();
		systemServices = new ArrayList<SystemService>();
		systemServices.add(new RelationDBInitService());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		logger.debug("系统 ["+event.getServletContext().getInitParameter("WebRootApp")+"] 开始销毁！");
		for(SystemService service : systemServices)
		{
			try{
				service.shutdown();
			}catch(Exception e)
			{
				logger.error("系统关闭服务"+service.getServiceName()+"失败!",e);
			}
		}
		logger.debug("系统 ["+event.getServletContext().getInitParameter("WebRootApp")+"] 销毁完成！");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		logger.debug("系统 ["+event.getServletContext().getInitParameter("WebRootApp")+"] 开始启动！");
		for(SystemService service : systemServices)
		{
			try{
				service.startup();
			}catch(Exception e)
			{
				logger.error("系统启动服务"+service.getServiceName()+"失败!",e);
			}
		}
		logger.debug("系统 ["+event.getServletContext().getInitParameter("WebRootApp")+"] 启动完成！");
	}

}
