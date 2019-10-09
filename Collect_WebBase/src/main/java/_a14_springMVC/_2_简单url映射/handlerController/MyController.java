package _a14_springMVC._2_简单url映射.handlerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import _a14_springMVC._2_简单url映射.po.Commodity;

public class MyController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*创建数据模型*/
		List<Commodity> list = new ArrayList<Commodity>();
		Commodity commodity_1 = new Commodity();
		commodity_1.setName("笔记本");
		commodity_1.setPrice("2000");
		list.add(commodity_1);
		/*将数据模型放入ModelAndView*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("commodity", list);
		modelAndView.addObject("aa","ffff");
		/*制定视图*/
		modelAndView.setViewName("/_2_WebBase/src/main/java/_a14_springMVC/_2_简单url映射/view/jsp/commodity.jsp");
		
		return modelAndView;
	}

}
