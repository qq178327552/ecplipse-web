package _5_servlet编程;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet的生命周期
 * HttpServlet继承GenericServlet类，实现Http协议;GenericServlet继承Servlet，实现Servlet的生命周期方法
 * 
 * 1.构造方法		创建servlet对象的时候调用
 * 2.带参初始化方法	创建完servlet对象的时候调用
 * 3.无参初始化方法		由程序员编写初始化的方法
 * 4.service()方法	每次发出请求时调用
 * 5.destroy()对象销毁方法	销毁servlet对象的时候调用
 * 6.服务器启动时创建
 * 
 * @author zheng
 *
 */
public class _3_Servlet生命周期 extends HttpServlet {
	/*1.构造方法*/
	public _3_Servlet生命周期(){
		System.out.println("1.创建Servlet对象");
		/*创建servlet对象的时候调用。
		 * 默认情况下，第一次访问servlet的时候创建servlet对象,
		 * 只调用1次。
		 * 证明servlet对象在tomcat是单实例的。
		 * */
	}
	
	/*2.带参初始化方法*/
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("2.带参初始化方法");
		/*
		 *  创建完servlet对象的时候调用。
		 *  只调用1次。
		 *  是servlet生命周期的方法，一定会被服务器调用
		 * */
	}
	
	/*3.无参初始化方法*/
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("3.无参初始化方法");
		/*
		 * 编写servlet程序员编写的初始化方法
		 * */
		
	}
	
	/*4.service()方法*/
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("4.service()方法");
		/*
		 * 每次发出请求时调用。
		 * 调用n次。
		 * */
	}
	
	/*5.destroy()对象销毁方法*/
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("5.destroy()对象销毁方法");
		/*
		 * 销毁servlet对象的时候调用。
		 * 停止服务器或者重新部署web应用时销毁servlet对象。
		 * 只调用1次。
		 * */
	}
	/*6.服务器启动时创建:在web.xml中对应的<servle>t加<load-on-startup>*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("7.doGet()请求处理方法");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
