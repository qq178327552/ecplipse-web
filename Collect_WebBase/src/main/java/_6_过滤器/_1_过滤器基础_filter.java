package _6_过滤器;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 过滤器
 * 		用户请求先访问流程：该过滤器 --> servlet --> 该过滤器 --> JSP
 * 
 * 过滤器执行流程：
 * 	1.创建实例
 * 	2.执行过滤器初始化方法
 * 	3.执行过滤器业务处理方法
 * 	4.执行Servlet中的方法
 * 	5.Servlet处理完成，又回到过滤器
 * @author zheng
 *
 */
public class _1_过滤器基础_filter implements Filter{
	/*创建实例*/
	public _1_过滤器基础_filter(){
		System.out.println("1.创建过滤器实例");
	}
	/*执行过滤器初始化方法*/
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2.执行过滤器初始化方法");
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
