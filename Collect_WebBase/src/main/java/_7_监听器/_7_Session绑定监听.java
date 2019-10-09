package _7_监听器;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 监听此对象绑定到session上的过程，需要实现session特定接口
 * 
 * @author Jie.Yuan
 * 
 */
public class _7_Session绑定监听 implements HttpSessionBindingListener {
	private int id;
	private String name;
	/*对象放入session*/
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("用户对象已经放入session");
	}
	/*对象从session中移除*/
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("用户对象从session中移除！");
	}
	
	
	public _7_Session绑定监听() {
		super();
	}
	public _7_Session绑定监听(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
