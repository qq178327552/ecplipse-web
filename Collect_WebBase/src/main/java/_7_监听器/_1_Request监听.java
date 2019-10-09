package _7_监听器;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 监听request对象的创建或销毁
 * @author zheng
 */
public class _1_Request监听 implements ServletRequestListener{

	/*对象销毁*/
	public void requestDestroyed(ServletRequestEvent sre) {
		Object obj = sre.getServletRequest().getAttribute("cn");//获取request中存放的数据
		System.out.println(obj);
		System.out.println("Request域销毁");//用户访问数据传输完成(用户界面显示东西)触发该监听器方法
	}

	/*对象创建*/
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request域创建");//用户访问时触发该监听器方法
	}
}
