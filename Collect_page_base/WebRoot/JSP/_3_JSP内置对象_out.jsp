<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- JSP内置对象
	 	request		HttpServletRequest类型
	 	response	HttpServletResponse类型
	 	config		ServletConfig类型
	 	application	ServletContext类型
	 	session		HttpSession类型(只有session为true时才能用)
	 	exception	Throwable类型(只有isErrorPage为true时才能用)
	 	page		Object(this)类型
	 	out			JspWriter类型,相当于带缓冲的PritWriter类：
	 			writer([内容])：向jsp缓冲区写出内容,缓冲区写入页面时机：缓冲区满、刷新缓冲区(out.flush())、关闭缓冲区(buffer="0kb")、执行完jsp页面
	 	pageContext	PageContext类型
		 		方便自定义的方法、自定义标签中也能使用内置对象
		 		自身也是域对象
	
	1.Out对象使用(其他几个对象在web_base中讲述)
 --%>
<html>
	<head>
		<title>JSP内置对象：Out对象(其他几个对象在web_base中讲述)</title>
	</head>
	<body>
		<%
			/*out对象使用*/
			out.write("abc");//相当于response.getWriter().write("abc");但用out带缓冲而PritWriter.write()方法直接输出给浏览器
			int surplusVolume=out.getRemaining();//查询缓冲区剩余的大小
			int currentVolume=out.getBufferSize();//查看现在缓冲区大小
		 %>
	</body>
</html>
