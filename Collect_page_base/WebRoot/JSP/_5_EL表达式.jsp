<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%-- EL表达式
		主要作用：替换JSP中的表达式，向浏览器输出域对象中的变量值或表达式的结果
		语法：${变量或表达式}
		
	1.EL表达式获取域对象中的数据
	2.EL表达式输出对象的属性值
	3.EL表达式获得List对象,只能一个个获取
	4.EL表达式获得Map对象,只能一个个获取
	5.EL表达式计算
	
 --%>
<html>
	<head>
		<title>EL表达式</title>
	</head>
	<body>
		<%
			pageContext.setAttribute("name", "zhenghaoyuan"); //将变量放入page域中
		%>
		
		<!-- 1.EL表达式获取域对象中的数据 -->
		EL表达式自动取出的name值(相当于findAttribute()方法)：${name}
		EL表达式从page域中获取数据：${pageScope.name }
		EL表达式从request域中获取数据：${requestScope.name }
		EL表达式从session域中获取数据：${sessionScope.name }
		EL表达式从context域中获取数据：${applicationScope.name }
		
		<!-- 2.EL表达式输出对象的属性值 -->
		<%-- 存入域中是类时，可以获取其属性的值,点相当于属性的get()方法：${[类名].[属性] } --%>
		
		<!-- 3.EL表达式获得List对象,只能一个个获取 -->
		EL表达式获得List对象,中括号相当于get()方法：${list[0] }
		
		<!-- 4.EL表达式获得Map对象,只能一个个获取 -->
		EL表达式获得Map对象,中括号相当于get(key)方法：${Map['name'] }
		
		<!-- 5.EL表达式计算 -->
	</body>
</html>
