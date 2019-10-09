package _5_servlet编程;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 自己写的Servlet类
 * <p>
 * 1.先导servlet-api.jar包 <br/>
 * 2.类继承HttpServlet类 <br/>
 * 3.重写doGet()方法 <br/>
 * 4.编译生成class文件，找到该类的class文件(右击项目-Properties-Resource下的Location路径) <br/>
 * 5.将class文件(及上面的包文件,即bin目录下的该文件所在文件夹一起)交给Tomcat(拷贝到Tomcat/webapps下-在该目录下新建一个项目文件夹-文件夹里新建"WEB-INF"文件夹-再在该目录下创建"classes"文件夹-拷贝到classes文件夹下) <br/>
 * 6.在classes同路径下创建web.xml文件，拷贝写<web-app>标签，在标签内加入<servlet>和<servlet-mapping>两个标签供外部访问路径 <br/>
 * 7.启动Tomcat，用浏览器访问：http://localhost:8080/(webapps下项目文件夹名称)/(web.xml位置的路径名称) <br/>
 * </p>
 * @author APPle
 *
 */
public class _1_Servlet基础 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*解决中文乱码问题*/
		resp.setContentType("text/html;charset=utf-8");
		/*向浏览器输出内容*/
		resp.getWriter().write("这是第一个servlet程序。当前时间为："+new Date());
	}
}
