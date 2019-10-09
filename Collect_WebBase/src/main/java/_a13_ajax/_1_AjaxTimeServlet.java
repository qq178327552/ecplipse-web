package _a13_ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 无需刷新整个Web页面显示服务器响应的当前时间
 * @author AdminTC
 */
public class _1_AjaxTimeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowStr = sdf.format(new Date());
		//以流的方式将结果响应到AJAX异步对象中
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();//创建response返回数据对象(只要接收到请求不管请求是什么都返回当前时间字符串)
		pw.write(nowStr);//发送给AJAX数据流
		pw.flush();
		pw.close();
	}
}





