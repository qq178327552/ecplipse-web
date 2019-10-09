package ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����XML����POST��ʽ�����ʡ��-���ж�����������
 * @author AdminTC
 */
public class _4_ProvinceCityServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String province = request.getParameter("province");
		/*֪ͨAJAX�첽���󣬷�������Ӧ������Ϊxml��ʽ��*/
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter pw = response.getWriter();//��ȡ�ַ������
		/*���xml��ʽ��IO����ajax*/
		pw.write("<?xml version='1.0' encoding='UTF-8'?>");
		pw.write("<root>");
		if("�㶫".equals(province)){
			pw.write("<city>����</city>");
			pw.write("<city>����</city>");
			pw.write("<city>��ɽ</city>");
		}else if("����".equals(province)){
			pw.write("<city>��ɳ</city>");
			pw.write("<city>����</city>");
			pw.write("<city>��̶</city>");
			pw.write("<city>����</city>");
		}
		pw.write("</root>");
		pw.flush();
		pw.close();
	}
}






