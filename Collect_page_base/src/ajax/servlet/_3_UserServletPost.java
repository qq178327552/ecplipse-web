package ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����HTML����GET��POST��ʽ�����ע���û����Ƿ������ݿ����Ѵ��� 
 * @author AdminTC
 */
public class _3_UserServletPost extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//post����Ὣ�������еĺ����Զ�����UTF-8�ı���
		String username = request.getParameter("username");//����"username"����ֵ
		System.out.println("username=" + username);
		String tip = "resources/MsgSent.gif";//����ͼƬ·��
		if("�ܿ�".equals(username)){
			tip = "images/MsgError.gif";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
	}
}







