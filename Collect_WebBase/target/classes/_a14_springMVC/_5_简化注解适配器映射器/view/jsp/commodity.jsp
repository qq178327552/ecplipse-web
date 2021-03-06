<%@ page language="java" contentType="text/html; charset=utf-8"  isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询商品列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/queryItems.action" method="post"></form>
	查询条件：
	<table width="100%" border=1>
		<tr>
			<td><input type="submit" value="查询"><input></td>
		</tr>
	</table>
	商品列表：
	<table width="100%" border=1>
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品描述</td>
		</tr>
		
		<c:forEach items="${commodity}" var="item">
		<tr>
			<td>${item.name}</td>
			<td>${item.price}</td>
		</tr>
		<tr>
		</tr>
		</c:forEach>
	</table>
</body>
</html>