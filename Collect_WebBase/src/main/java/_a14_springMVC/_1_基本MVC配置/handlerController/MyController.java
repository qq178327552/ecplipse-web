package _a14_springMVC._1_基本MVC配置.handlerController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import _a14_springMVC._1_基本MVC配置.po.Commodity;
/**
 * MVC模式:Model(模型)、View(视图)、Control(控制器)
 * 	控制器作用Control:用程序中的Servlet,获取数据 -> 调用Service业务处理 -> 跳转页面(重定向)
 * 
 * SpringMVC架构:
 * 	请求->
 * 	前段控制器处理请求(DispatcherServlet) ->
 * 	调用处理器映射器将URL映射到处理器适配器 ->
 * 	调用处理器适配器查看调用哪个Controller执行Handler ->
 * 	调用Controller执行Handler,返回ModelAndView类 ->
 * 	根据ModelAndView调用视图解析器,解析视图 ->
 * 	跳转到视图进行视图渲染填充request域,从而返回请求
 * @author zheng
 *
 */
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
		modelAndView.setViewName("/_2_WebBase/src/main/java/_a14_springMVC/_1_基本MVC配置/view/jsp/commodity.jsp");
		
		return modelAndView;
	}

}
