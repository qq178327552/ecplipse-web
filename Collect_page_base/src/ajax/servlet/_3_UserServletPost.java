package ajax.servlet;

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
public class _3_UserServletPost extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//post请求会将请求体中的汉字自动进行UTF-8的编码
		String username = request.getParameter("username");//接收"username"属性值
		System.out.println("username=" + username);
		String tip = "resources/MsgSent.gif";//返回图片路径
		if("杰克".equals(username)){
			tip = "images/MsgError.gif";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
	}
}







