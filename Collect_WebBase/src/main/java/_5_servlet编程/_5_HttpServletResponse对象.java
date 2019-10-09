package _5_servlet编程;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet对象中的：HttpServletResponse
 * 
 * 1.tomcat服务器将相应的信息封装到该对象中
 * 2.tomcat服务器再调用doGet()或doPost()方法，传入人response对象和request对象
 * 3.程序员通过response对象改变响应信息
 * 4.tomcat服务器把response对象的内容(PrintWriter)转换成响应格式内容，再发送给浏览器解析
 * 
 * 5.请求重定向
 * 6.定时刷新
 * 7.改变数据类型及数据编码方式
 * 8.以下载方式打开资源
 * 
 * @author zheng
 *
 */
public class _5_HttpServletResponse对象 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*HttpServletResponse对象的使用*/
		resp.setCharacterEncoding("utf-8");//设置相应实体的编码方式(默认write()方法将字符转字节发送时以iso-8859转换;当以OutputStream字节发送时不存在乱码问题，因为发送只能以字节发送发送什么就接收什么)
		resp.setStatus(404);//改变响应行的状态码
		resp.sendError(404);//改变响应行的状态码+404错误页面
		resp.setHeader("server", "Boss");//增改响应头
		resp.getWriter().write("hello");//增添发送实体内容,先获取PrintWriter对象，再发送内容
		resp.getOutputStream().write("hello".getBytes());//增添发送实体内容,以字节发送
			/*5.请求重定向(超链接跳转页面)：302状态吗+location响应头。浏览器会自动向服务器发两次请求，第一次获取302状态吗+location，第二次请求访问location*/
		resp.setStatus(302);
		resp.setHeader("location", "/_2_WebBase/redirect/adv.html");//重定向由浏览器发送，缺省的根目录在webapps路径下
		resp.sendRedirect("/_2_WebBase/redirect/adv.html");//上面两句统一的简化写法
		/*对比其他跳转链接*/
		resp.getWriter().write("<html><body><a href='/day11/target.html'>超链接</a></body></html>");//html页面的超连接href
		resp.getWriter().write("<html><body><form action='/day11/target.html'><input type='submit'/></form></body></html>");//html页面中的form提交地址
			/*6.定时刷新：响应头含Refresh*/
		resp.setHeader("refresh", "1");//每隔1秒刷新一次页面
		resp.setHeader("refresh", "3;url=/_2_WebBase/redirect/adv.html");//隔3秒后跳转页面
			/*改变数据类型及数据编码方式*/
		resp.setHeader("content-type", "text/html");//改变服务器发送给浏览器的数据类型,其类型值在conf文件web.xml中<mime-mapping>有规定
		resp.setContentType("text/xml;charset=utf-8;charset=utf-8");//前面方法与上面一句代码等价(该句用xml解析),后面增添resp的编码方式，即相当于：resp.setCharacterEncoding("utf-8");
		resp.setContentType("image/jpg");//发送jpg图片格式,发送时用流发送(resp.getOutputStream().write(buf,0,len);)
			/*以下载方式打开资源*/
		resp.setHeader("Content-Disposition", "attachment; filename="+(new File("E:/a.txt")).getName());
	
	}
}
