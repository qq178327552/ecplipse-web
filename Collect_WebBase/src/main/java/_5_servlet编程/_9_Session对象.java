package _5_servlet编程;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * HttpSession类，用于存储会话数据，存放在服务端
 * 
 * session作用域：并非所有访问都能取到session值,
 * 		在哪个session域对象保存的数据，只有该域对象才能取出
 * session有效时间：
 * 		默认情况下保存30分钟
 * 
 * 1.创建session对象
 * 		先给session对象分配一个id(jsessionid),然后存储session数据
 * 		再把jsessionid作为cookie值发送浏览器
 * 		浏览器带着cookie再次访问浏览器会带着cookie中jsession访问服务器
 * 		服务器得到jsessionid,在服务器内存中搜索存放的编号的session对象
 * 2.设置session对象
 * 3.保存会话数据到session对象
 * 4.获取session对象中的数据
 * 
 * @author zheng
 *
 */
public class _9_Session对象 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*1.创建session对象*/
		HttpSession session=req.getSession(true);//根据客户访问创建该客户的session,参数不填默认true代表创建或得到客户的session，即当服务器无该客户的session时会创建session
																		   //参数为false时当没有匹配的session时会返回null，并不会创建session
		
		/*2.设置session对象*/
		String id=session.getId();//获取session的jsessionid编号
		session.setMaxInactiveInterval(20);//设置session有效时间，默认30分钟,此设置设置20秒有效时间，也可在web.xml全局中修改session有效时间
		session.invalidate();//销毁session对象
		Cookie c=new Cookie("JSESSIONID",session.getId());//可防止关闭浏览器无法访问session,发送cookie保存本地
		c.setMaxAge(60*60);//保存本地1小时
		resp.addCookie(c);
		
		/*3.保存会话数据到session对象*/
		session.setAttribute("name",new Object(){});
		
		/*4.获取session对象中的数据*/
		Object name=session.getAttribute("name");
	}
}
