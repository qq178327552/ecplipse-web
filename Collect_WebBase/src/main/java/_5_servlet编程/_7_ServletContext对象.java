package _5_servlet编程;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet对象中的：ServletContext
 * 
 * 1.web应用的所有配置信息对象(web.xml)，
 * 2.在加载web应用时创建该对象(早于ServletConfig创建),
 * 		但在ServletConfig对象中的getServletContext()方法中得到
 * 3.转发
 * 4.域对象:用于共享任意类型的数据(ServletContext是域对象其中之一)
 * 		ServletContext域对象		同一个web应用(全局的)
 * 		HttpSession域对象			同一个session中(私有的)
 * 		HttpServletRequest域对象	同一个请求中(转发)
 * 		PageContext域对象			同一个jsp页面中(当前页面)
 * 
 * 		域对象都有setAttribute(String,Object)方法键值对保存数据、getAttribute(String)获取数据、removeAttribute(String)清除数据
 * 		
 * 5.读取资源文件:java中的./中的点代表命令运行的路径，tomcat运行路径在tomcat的bin目录下，所以获取资源文件无法获取
 * 		用ServletContext类中的方法可以获取项目下资源文件
 * 
 * @author zheng
 *
 */
public class _7_ServletContext对象 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*1.ServletContext对象的使用*/
		ServletContext context=this.getServletConfig().getServletContext();//得到ServletContext对象
		context=this.getServletContext();//调用父类GenericServlet类中方法，其方法实现与上一句一样
		String contextPath=context.getContextPath();//得到web应用路径(/web_base,并不是项目名称，而是部署到tomcat的路径)
		context.getInitParameter("path");//获取<context-param>初始化参数中<param-name>为"path"对应的值
		Enumeration<String> contextEnums=context.getInitParameterNames();
		while(contextEnums.hasMoreElements()){
			String paramName=contextEnums.nextElement();//获取每一个参数的键
			String paramValue=this.getServletContext().getInitParameter(paramName);//获取每一个参数的值
		}
			/*转发,与重定向不同(重定向由浏览器请求,缺省的根目录在tomcatwebapps目录下)，
			 * 重定向url跳转到目标地址，缺点：不能用HttpServletRequest域对象保存数据,即重定向时服务器不能干预request请求(如添加数据)
			 * 而转发url不跳转地址,缺点：不能转发到web应用以外的资源*/
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/redirect/adv.html");//由服务器转发，根目录在web应用下(WebRoot路径)
		rd.forward(req, resp);//相当于接口，将请求的数据转发到rd获取的页面，再将页面响应的数据发送出去
		
		/*2.ServletContext做域对象,作用范围在整个web应用有效且唯一*/
		context.setAttribute("name", new Object(){});//数据保存ServletContext到域对象中,供该项目中其他服务(其他的uri)访问数据
		Object name=context.getAttribute("name");//取出其他uri中存入域对象的数据
		
		/*3.获取资源文件*/
		String path=this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");//此时缺省根目录在当前项目下,当前项目在Tomcat中编译到class路径下,返回资源文件绝对路径
		InputStream input=this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");//找资源文件直接返回流
	}
}
