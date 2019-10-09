package _a14_springMVC._7_视图解析器前后缀.handlerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import _a14_springMVC._7_视图解析器前后缀.po.Commodity;

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
		/*制定视图,配置了前后缀所以可以省略jsp的路径前后缀*/
		modelAndView.setViewName("commodityp");
		
		return modelAndView;
	}

}
