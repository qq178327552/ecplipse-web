package _5_servlet编程;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet对象中的：HttpServetRequest
 * 
 *1.tomcat服务器将收到的浏览器请求数据封装到该对象中
 *2.tomcat服务器再调用doGet()或doPost()方法，把request对象传入到servlet中
 *3.获取出入的参数(分doget()和dopost()两种请求)
 *
 * @author zheng
 *
 */
public class _4_HttpServetRequest对象 extends HttpServlet {
	/*接收Get方式提交的请求*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*从HttpServletRequest类中取出请 求数据(Get请求)*/
		String requestMethod=req.getMethod();//请求行中请求方式
		String requestURI=req.getRequestURI();//请求行中请求资源(URI)
		StringBuffer requestURL=req.getRequestURL();//请求行中请求资源(URL)
		String requestProtocol=req.getProtocol();//请求行中请求协议
		String requestHeader=req.getHeader("Host");//请求头,根据头名称获取请求头数据,此处获取Host的数据
		String contextPath = req.getContextPath();//获取请求的该上下文路径(对应到该包中)
		Enumeration<String> requestHeaders=req.getHeaderNames();//用迭代器得到所有的请求头名称列表
		while(requestHeaders.hasMoreElements()){
			String headerName=requestHeaders.nextElement();//获得所有请求头
			String headerValue=req.getHeader(headerName);//获得所有请求数据
		}
		/*与Post请求相同的代码*/
		String name=req.getParameter("name");//获得实体中name属性对应的值,但此方法从字节转换成字符，默认用iso-8859解码 (可:设置request的解码、过滤器、改服务器配置文件(server.xml,在改端口标签<Connector>后加入:URIEncoding="utf-8"))
		byte[] nameByte=name.getBytes("iso-8859-1");//当不设置默认编码或get请求时出现乱码问题时，先把"iso-8859"的字符还原成字节(编码)
		name=new String(nameByte,"utf-8");//再把字节转换成utf-8的字符(解码)
		Enumeration<String> enums=req.getParameterNames();//用迭代器获取所有实体的属性名称
		while(enums.hasMoreElements()){
			String paramName=enums.nextElement();//获取所有实体属性的名称
			if(!("hobits".equals(paramName))){//当"hobits"是多个值时，分类处理
				String paramValue=req.getParameter(paramName);//获取所有实体属性的值(只能获取有一个值的属性)
			}else{
				String[] hobits=req.getParameterValues(paramName);//获取一个属性对应多个值的情况，如"hobits"
				for(String hobit:hobits){
				}
			}
		}
		
	}
	
	/*接收Post方式提交的请求*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*从HttpServletRequest类中取出请 求数据(Post请求)*/
		InputStream input=req.getInputStream();//请求的实体内容，用流接收
		byte[] buf=new byte[1024];
		int len=0;
		while((len=input.read(buf))!=-1){
			String str=new String(buf,0,len);
		}
		req.setCharacterEncoding("utf-8");//设置请求的编码(防止乱码),仅Post请求时用(请求传来的数据都是以字节传送，getParameter()方法获取到的字符默认将接收的字节以iso-8859方式解码为字符)
			/*以下获取内容的方法在doGet()方法中也适用，所以可以重用*/
		String name=req.getParameter("name");//获得实体中name属性对应的值,但此方法从字节转换成字符，默认用iso-8859解码 (可:设置request的解码、过滤器、改服务器配置文件(server.xml,在改端口标签<Connector>后加入:URIEncoding="utf-8"))
		byte[] nameByte=name.getBytes("iso-8859-1");//当不设置默认编码或get请求时出现乱码问题时，先把"iso-8859"的字符还原成字节(编码)
		name=new String(nameByte,"utf-8");//再把字节转换成utf-8的字符(解码)
		Enumeration<String> enums=req.getParameterNames();//用迭代器获取所有实体的属性名称
		while(enums.hasMoreElements()){
			String paramName=enums.nextElement();//获取所有实体属性的名称
			if(!("hobits".equals(paramName))){//当"hobits"是多个值时，分类处理
				String paramValue=req.getParameter(paramName);//获取所有实体属性的值(只能获取有一个值的属性)
			}else{
				String[] hobits=req.getParameterValues(paramName);//获取一个属性对应多个值的情况，如"hobits"
				for(String hobit:hobits){
				}
			}
		}
		this.doGet(req, resp);//为避免代码重复(因为对于实体中的值获取属性，同样doGet()方法中也适用)
	
	}
}
