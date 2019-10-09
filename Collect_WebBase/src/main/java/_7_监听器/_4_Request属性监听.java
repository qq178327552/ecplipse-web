package _7_监听器;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * 监听Request对象属性的变化
 * 
 * @author Jie.Yuan
 * 
 */
public class _4_Request属性监听 implements ServletRequestAttributeListener {
	/*属性添加监听*/
	public void attributeAdded(ServletRequestAttributeEvent sr) {
		ServletRequest serReq = sr.getServletRequest();//先获取Request对象
		Object obj = serReq.getAttribute("userName");//获取添加的属性
		System.out.println("添加的属性：" + obj);//测试
	}
	/*属性移除监听*/
	public void attributeRemoved(ServletRequestAttributeEvent sr) {
		System.out.println("属性移除");
	}
	/*属性修改监听*/
	public void attributeReplaced(ServletRequestAttributeEvent sr) {
		ServletRequest serReq = sr.getServletRequest();//获取sesison对象
		Object old = sr.getValue();//获取替换前的值
		System.out.println("原来的值：" + old);//测试
		Object obj_new = serReq.getAttribute("userName");//获取新值
		System.out.println("新值：" + obj_new);//测试
	}
}
