package _7_监听器;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 监听ServletContext对象属性的变化
 * @author Jie.Yuan
 *
 */
public class _6_ServletContext属性监听 implements ServletContextAttributeListener {
	/*属性添加监听*/
	public void attributeAdded(ServletContextAttributeEvent sc) {
		ServletContext serCon = sc.getServletContext();//先获取ServletContext对象
		Object obj = serCon.getAttribute("userName");//获取添加的属性
		System.out.println("添加的属性：" + obj);//测试
	}
	/*属性移除监听*/
	public void attributeRemoved(ServletContextAttributeEvent sc) {
		System.out.println("属性移除");
		
	}
	/*属性被替换监听*/
	public void attributeReplaced(ServletContextAttributeEvent sc) {
		ServletContext serCon = sc.getServletContext();//获取ServletContext对象
		Object old = sc.getValue();//获取替换前的值
		System.out.println("原来的值：" + old);//测试
		Object obj_new = serCon.getAttribute("userName");//获取新值
		System.out.println("新值：" + obj_new);//测试
	}
}
