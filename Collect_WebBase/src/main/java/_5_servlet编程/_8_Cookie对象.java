package _5_servlet编程;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * cookie类，用于存储会话数据，存放在客户端
 * 
 * 1.构造cookie对象(只能是字符串英文的数据)
 * 2.设置cookie(路径、时间、值)
 * 3.发送cookie到浏览器端保存,浏览器再次请求时会携带cookie在请求头
 * 4.接收cookie
 * 5.删除同名的cookie信息
 * 6.显示用户上次访问时间案例
 * 
 * @author zheng
 *
 */
public class _8_Cookie对象 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*1.创建cookie对象(需要创建名称和值)*/
		Cookie cookie=new Cookie("name","zhenghaoyuan");
		
		/*2.设置cookie*/
		cookie.setPath("/_2_WebBase");//设置cookie有效路径，为浏览器发送指定服务器时带上cookie的服务器路径信息,默认有效路径在当前web应用下
		cookie.setMaxAge(20);//设置cookie有效时间，正整数保存硬盘中，数值为保存时间长度,意味着20秒后cookie过期,从最后不调用cookie开始计算
		cookie.setMaxAge(-1);//设置cookie有效时间，负整数保存浏览器缓存中,数值大小无意义
		cookie.setMaxAge(0);//设置cookie有效时间，0为删除同名的cookie
		
		/*3.把cookie数据发送给浏览器(通过响应头发送:set-cookie),浏览器再次请求时会携带cookie在请求头*/
		resp.setHeader("set-cookie", cookie.getName()+"="+cookie.getValue());//在响应头中发送cookie键值，多个则以逗号分隔
		resp.addCookie(cookie);//response自动发送cooike方法
		
		/*4.接收浏览器发送的cookie信息*/
		String reqCookie=req.getHeader("cookie");//得到请求头的cookie全部信息
		Cookie[] reqCookies=req.getCookies();//获得请求的全部cookie
		if(reqCookies!=null){//先判断是否有cookie，防止空指针异常
			for(Cookie c:reqCookies){
				String name=c.getName();
				String value=c.getValue();
			}
		}
		
		/*5.删除同名的cookie信息*/
		Cookie cookieName = new Cookie("name","xxxx");
		cookieName.setMaxAge(0);//删除同名的cookie
		resp.addCookie(cookieName);
		System.out.println("删除成功");
		
		/*6.显示用户上次访问时间案例*/
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String curTime = format.format(new Date());//获取当前时间
		Cookie[] cookiesTimes = req.getCookies();//获取cookies
		String lastTime = null;
		if(cookiesTimes==null || lastTime==null){//当用户第一次访问时
			resp.getWriter().write("你是首次访问本网站，当前时间为："+curTime);//显示当前时间到浏览器
			Cookie cookieTime = new Cookie("lastTime",curTime);//创建Cookie对象
			cookieTime.setMaxAge(1*30*24*60*60);//保存一个月
			resp.addCookie(cookie);//把cookie发送到浏览器保存
		}
		if(cookiesTimes!=null){//当用户不是第一次访问时
			for (Cookie cookieTime : cookiesTimes) {
				if(cookieTime.getName().equals("lastTime")){
					lastTime = cookieTime.getValue();//上次访问的时间,有lastTime的cookie，已经是第n次访问
					resp.getWriter().write("欢迎回来，你上次访问的时间为："+lastTime+",当前时间为："+curTime);//第n次访问,把上次显示时间显示到浏览器
					cookieTime.setValue(curTime);//更新cookie
					cookieTime.setMaxAge(1*30*24*60*60);//设置cookie有效存储时间
					resp.addCookie(cookieTime);//把更新后的cookie发送到浏览器
					break;
				}
			}
		}
	}

}
