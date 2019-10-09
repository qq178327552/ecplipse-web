<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- JSP内置对象:pageContext对象  PageContext类型 (其他几个对象在web_base中讲述)
		
	1.pageContext对象使用(可获得其他八个内置对象)
	2.pageContext域对象(作用范围可设置，默认在当前页面下)
		ServletContext域对象		同一个web应用(全局的)
  		HttpSession域对象			同一个session中(私有的)
 		HttpServletRequest域对象	同一个请求中(转发)
  		PageContext域对象			同一个jsp页面中(当前页面)
  
  		域对象都有setAttribute(String,Object)方法键值对保存数据、getAttribute(String)获取数据、removeAttribute(String)清除数据
 --%>
<html>
	<head>
		<title>JSP内置对象:pageContext对象(其他几个对象在web_base中讲述)</title>
	</head>
	<body>
		<%
			/*1.pageContext对象使用(可获得其他八个内置对象)*/
			boolean judge = (out==pageContext.getOut());//结果为true
			judge=(session==pageContext.getSession());//结果为true
			
			/*2.pageContext域对象*/
			pageContext.setAttribute("name", new Object(){});//保存数据,仅保存在当前页面下
			pageContext.setAttribute("name", new Object(){},PageContext.REQUEST_SCOPE);//将数据保存在其他域中,此处保存在request域中
			Object name=pageContext.getAttribute("name");//获取数据
			name=pageContext.getAttribute("name",PageContext.REQUEST_SCOPE);//从其他域对象中获取数据,此处从request域中取出数据
		 	name=pageContext.findAttribute("name");//自动获取四个域中的数据对象(找到为止的查找顺序:page -> request -> session -> context(application))
		 	
		 	//当用转发到别的页面获取数据时，只有page域没数据，因为其作用域仅当前页面;重定向page和request域没数据
		 %>
	</body>
</html>
