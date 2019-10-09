package _7_监听器;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 监听session对象属性的变化
 * @author Jie.Yuan
 *
 */
public class _5_Session属性监听 implements HttpSessionAttributeListener {
	/*属性添加监听*/
	public void attributeAdded(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();//先获取session对象
		Object obj = session.getAttribute("userName");//获取添加的属性
		System.out.println("添加的属性：" + obj);//测试
	}
	/*属性移除监听*/
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("属性移除");
	}
	/*属性被替换监听*/
	public void attributeReplaced(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();//获取sesison对象
		Object old = se.getValue();//获取替换前的值
		System.out.println("原来的值：" + old);//测试
		Object obj_new = session.getAttribute("userName");//获取新值
		System.out.println("新值：" + obj_new);//测试
	}
}
