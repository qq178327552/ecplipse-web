package _5_servlet编程;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * web工程的Servlet，其路径与web.xml绑定，供外部访问
 * 
 * 1.web.xml文件中：
 * 		<servlet>标签显示名字与对应的类路径
 * 		<serclet-mapping>标签对应外部访问的路径
 * 
 * 2.改项目的外部访问路径：(是用工具将项目拷贝到webapps下时的名称)
 * 		右击项目-Properties-MyEcpilipse-Web-修改Web Context-root的路径，为外部访问的路径
 * 
 * 3.配置到tomcat服务器：
 * 		关联tomcat:Window-Preferences-MyEcplipse-Servers-Tomcat-选择Enable-选择对应tomcat版本的home directory路径
 * 
 * 4.项目部署到服务器：
 * 		Deploy and undeploy J2EE...选项-选中项目点"add"-选择配完的服务器-Finish
 * 
 * 5.启动服务器：
 * 		Run MyEcplipse Servers选项-选择配置的Tomcat-Start
 * 
 * @author zheng
 *
 */
public class _2_Servlet的web工程 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
