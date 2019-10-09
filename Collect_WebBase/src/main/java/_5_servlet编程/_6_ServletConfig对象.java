package _5_servlet编程;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *  Servlet对象中的：ServletConfig
 * 
 * 1.当前servlet的配置信息对象(<servlet>标签),
 * 2.在创建完servlet对象之后，调用init方法前创建
 * 
 * @author zheng
 *
 */
public class _6_ServletConfig对象 extends HttpServlet {
	/*可从init()中得到ServletConfig对象*/
	private ServletConfig config=null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config=config;//在init()方法中可以获取ServletConfig对象
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*使用ServletConfig对象*/
		config=this.getServletConfig();//调用父类GenericServlet类中方法，可直接拿到ServletConfig对象
		String path=config.getInitParameter("path");//获取<servlet>初始化参数中<param-name>为"path"对应的值
		Enumeration<String> configEnums=this.getServletConfig().getInitParameterNames();//用迭代器获取所有<param-name>的键名
		while(configEnums.hasMoreElements()){
			String paramName=configEnums.nextElement();//获取每一个参数的键
			String paramValue=this.getServletConfig().getInitParameter(paramName);//获取每一个参数的值
		}
		String servletName = this.getServletConfig().getServletName();//获取当前在配置文件中配置的Servlet的名称(_4_ServletObject)
	
	}
}
