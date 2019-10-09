package ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ˢ������Webҳ����ʾ��������Ӧ�ĵ�ǰʱ��
 * @author AdminTC
 */
public class _1_AjaxTimeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowStr = sdf.format(new Date());
		//�����ķ�ʽ�������Ӧ��AJAX�첽������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();//����response�������ݶ���(ֻҪ���յ����󲻹�������ʲô�����ص�ǰʱ���ַ���)
		pw.write(nowStr);//���͸�AJAX������
		pw.flush();
		pw.close();
	}
}





