package _a13_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基于HTML，以GET或POST方式，检查注册用户名是否在数据库中已存在 
 * @author AdminTC
 */
public class _2_UserServletGet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String username = request.getParameter("username");//获取ajax中get请求的username字段
		byte[] buf = username.getBytes("ISO8859-1");
		username = new String(buf,"UTF-8");//浏览器发送的是ISO8859-1编码，所以解码成UTF-8
		System.out.println("username=" + username);
		String tip = "<font color='green'>可以注册</font>";//准备发送的字符串,可以注册显示绿色
		if("杰克".equals(username)){
			tip = "<font color='red'>该用户已存在</font>";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
	}
}







