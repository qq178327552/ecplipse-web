<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- AJAX基本代码用法
	1.创建AJAX异步对象(不同浏览器版本创建不同)
	2.使用AJAX一部对象发送到action类处理
		AJAX状态码：
			a). [0]: ajax一部对象创建好了，但没准备发送请求(未调用ajax.open())
			b). [1]: ajax已经准备发送请求了，但没有真正发送(调用了ajax.open(),但没调用ajax.send())
			c). [2]: ajax已经发送,但还没到达服务器(调用了ajax.send()) 
			d). [3]: 请求已经到达服务器,正在处理中,服务器正在响应返回的过程中
			e). [4]: ajax异步对象已完全接收到服务器的响应信息
		2.1).创建AJAX异步对象
		2.2).准备发送请求
		2.3).真正发送请求体的数据到服务器，如果请求体中无数据的话，就用null表示
		2.4).AJAX异步对象不断监听服务器响应的状态(共五种状态)
		2.5).从AJAX异步对象中获取服务器响应的HTML数据
		2.6).将结果按照DOM规则，动态添加到web页面指定的标签中
 --%>
<html>
  <head>
    <title>无需刷新整个Web页面显示服务器响应的当前时间</title>
  </head>
  <body>
	<script type="text/javascript">
		/*1.创建AJAX异步对象(不同浏览器版本创建不同)*/
		function createAJAX(){
			var ajax = null;
			try{
				/*如果IE5=IE12的话*/
				ajax = new ActiveXObject("microsoft.xmlhttp");
			}catch(e1){
				try{
					/*如果是非IE的话(火狐)*/
					ajax = new XMLHttpRequest();
				}catch(e2){
					alert("你的浏览器中不支持异步对象，请换浏览器");
				}
			}
			return ajax;
		}
	</script>
	
	当前时间：<span id="time"></span><br/>
	<input id="buttonID" type="button" value="获取当前时间"/><p/>
	<script type="text/javascript">
		/*2.使用AJAX一部对象发送到action类处理*/
		document.getElementById("buttonID").onclick = function(){
			/*2.1).创建AJAX异步对象*/
			var ajax = createAJAX();
			/*2.2).准备发送请求*/
			var method = "GET";
			var url = "${pageContext.request.contextPath}/AjaxTimeServlet?time=" + new Date().getTime();
			ajax.open(method,url);
			/*2.3).真正发送请求体的数据到服务器，如果请求体中无数据的话，就用null表示*/
			ajax.send(null);
			
			/*2.4).AJAX异步对象不断监听服务器响应的状态(共五种状态)*/
			ajax.onreadystatechange = function(){//当AJAX状态变化后,触发function()函数
				/*如果状态码为4的话*/
				if(ajax.readyState == 4){
					/*如果响应码为200的话*/
					if(ajax.status == 200){
						/*2.5).从AJAX异步对象中获取服务器响应的HTML数据(此处为servlet的时间字符串)*/
						var nowStr = ajax.responseText;
						/*2.6).将结果按照DOM规则，动态添加到web页面指定的标签中*/
						var spanElement = document.getElementById("time");
						spanElement.innerHTML = nowStr;
					}
				}
			} 
		}
	</script>
  </body>
</html>