package _6_过滤器;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 获取过滤器初始化参数
 * @author zheng
 *
 */
public class _2_获取过滤器初始化参数 {
	/*创建实例*/
	public _2_获取过滤器初始化参数(){
		System.out.println("1.创建过滤器实例");
	}
	/*执行过滤器初始化方法*/
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2.执行过滤器初始化方法");
		/***************获取过滤器初始化参数************************/
		// 获取过滤器在web.xml中配置的初始化参数
		String encoding = filterConfig.getInitParameter("encoding");
		System.out.println(encoding);

		// 获取过滤器在web.xml中配置的初始化参数 的名称
		Enumeration<String> enums = filterConfig.getInitParameterNames();
		while (enums.hasMoreElements()) {
			// 获取所有参数名称：encoding、path
			String name = enums.nextElement();
			// 获取名称对应的值
			String value = filterConfig.getInitParameter(name);
			System.out.println(name + "\t" + value);
		}
	}

	/*过滤器业务处理方法： 在请求到达servlet之前先进入此方法处理公用的业务逻辑操作*/
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("3.执行过滤器业务处理方法");
		/*放行 (如果有下一个过滤器，进入下一个过滤器，否则就执行访问servlet)*/
		chain.doFilter(request, response);
		
		System.out.println("5.Servlet处理完成，又回到过滤器");
	}
	/*销毁过滤器方法*/
	public void destroy() {
		System.out.println("6. 销毁过滤器实例");
	}
}
