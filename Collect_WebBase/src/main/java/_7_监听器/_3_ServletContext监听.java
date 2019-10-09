package _7_监听器;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听ServletContext对象创建或销毁
 * @author Jie.Yuan
 *
 */
public class _3_ServletContext监听 implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext域销毁");//tomcat停止时触发该监听器方法
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext域销毁创建");//tomcat启动时触发该监听器方法
	}

}
