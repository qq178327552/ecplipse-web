package _a14_springMVC._5_简化注解适配器映射器.handlerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import _a14_springMVC._5_简化注解适配器映射器.po.Commodity;

import org.springframework.stereotype.Controller;

/*1.使用@Controller标识为一个控制器*/
@Controller
public class MyController{
	/*2.使用@@RequestMapping("")标识访问的url*/
	@RequestMapping("/queryItems1.action")
	public ModelAndView query1(){
		/*创建数据模型*/
		List<Commodity> list = new ArrayList<Commodity>();
		Commodity commodity_1 = new Commodity();
		commodity_1.setName("笔记本1");
		commodity_1.setPrice("2000");
		list.add(commodity_1);
		/*将数据模型放入ModelAndView*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("commodity", list);
		modelAndView.addObject("aa","ffff");
		/*制定视图*/
		modelAndView.setViewName("/_2_WebBase/src/main/java/_a14_springMVC/_5_简化注解适配器映射器/view/jsp/commodity.jsp");
		
		return modelAndView;
	}
	@RequestMapping("/queryItems2.action")
	public ModelAndView query2(){
		/*创建数据模型*/
		List<Commodity> list = new ArrayList<Commodity>();
		Commodity commodity_1 = new Commodity();
		commodity_1.setName("笔记本2");
		commodity_1.setPrice("1000");
		list.add(commodity_1);
		/*将数据模型放入ModelAndView*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("commodity", list);
		modelAndView.addObject("aa","ffff");
		/*制定视图*/
		modelAndView.setViewName("/_2_WebBase/src/main/java/_a14_springMVC/_5_简化注解适配器映射器/view/jsp/commodity.jsp");
		
		return modelAndView;
		
	}
}
