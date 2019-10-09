package _a14_springMVC._3_http适配器.handlerController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import _a14_springMVC._3_http适配器.po.Commodity;

/**
 * 该方法用于修改定义的响应内容及格式(如json格式)
 * @author zheng
 *
 */
public class MyController implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*创建数据模型*/
		List<Commodity> list = new ArrayList<Commodity>();
		Commodity commodity_1 = new Commodity();
		commodity_1.setName("笔记本");
		commodity_1.setPrice("2000");
		list.add(commodity_1);
		/*2.填充模型数据*/
		request.setAttribute("commodity", list );
		/*3.设置转发的视图*/
		request.getRequestDispatcher("/_2_WebBase/src/main/java/_a14_springMVC/_3_http适配器/view/jsp/commodity.jsp").forward(request, response);
	}

}
