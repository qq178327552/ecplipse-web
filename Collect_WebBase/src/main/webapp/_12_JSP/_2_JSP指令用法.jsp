<!-- page指令 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%-- JSP指令用法
	 1.include包含指令
	 2.page翻译指令
 --%>
 
<html>
	<head>
		<title>JSP指令用法</title>
	</head>
	<body>
		<!-- 1.include包含指令-->
		<%@include file="./header.jsp"%><!-- 将当前项目下common/header.jsp文件的输出页面内容全部加载到此处(包括<head>和<title>) -->
		
		<!-- 2.page翻译指令,在jsp最开始写入-->
		<%--
				<%@page 
					language="java" 	//编译语言
					import="java.util.*,java.text.*"	//导入的包,用逗号分隔
					pageEncoding="utf-8" 				//翻译jsp的编码方式(从硬盘的jsp文件翻译成java文件的过程编码)
					contentType="text/html;charset=utf-8"	// 服务器发送浏览器的数据类型和内容编码(从class文件翻译给浏览器的过程编码)
					errorPage="/common/error.jsp" 			//当出现错误时自动跳转的页面
					isErrorPage="false" 					//指定当前页面是否为错误处理页面，设为true后可用exception.getMessage()获取错误原因
															//在web.xml中可设置全局错误处理:<error-page>
					buffer="8kb" 							//设置JSP缓冲区大小
					session="true"							//是否开启了session功能，开启可直接用session对象
					isELIgnored="false"						//是否忽略EL表达式
				%>
		 --%>
	</body>
</html>