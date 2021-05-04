package com.fish.system.utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName AppListener
 * @Description 监听器，用于监听Tomcat的启动和销毁
 * @Author 柚子茶
 * @Date 2020/11/26 12:23
 * @Version 1.0
 */
@WebListener
public class AppListener implements ServletContextListener {

	/**
	 * @Description 程序的上下文初始化
	 * @author 柚子茶
	 * @date 2020/11/26 12:24
	 * @param sce ServletContextEvent类的实例化对象
	 * @return 无返回结果
	 **/
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("Path",servletContext.getContextPath());
	}

	/**
	 * @Description Tomcat服务器销毁时调用该方法
	 * @author 柚子茶
	 * @date 2020/11/26 12:27
	 * @param sce ServletContextEvent类的实例化对象
	 * @return 无返回结果
	 **/
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
