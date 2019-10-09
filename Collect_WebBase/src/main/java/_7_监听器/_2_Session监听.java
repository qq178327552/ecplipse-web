package _7_监听器;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听Session对象创建、销毁
 * @author Jie.Yuan
 *
 */
public class _2_Session监听 implements HttpSessionListener{

	// 创建
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session域创建");//用户访问并配置了session时触发该监听器方法
	}

	// 销毁
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session域销毁");//根据服务器设置session销毁时间触发该监听器方法
	}

}
