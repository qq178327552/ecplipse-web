<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- AJAX案例:
		输入用户名显示 图标 看用户名是否存在
	1.引入外部js文本,创建AJAX异步对象
	2.在页面中设置表单选项
	3.定位文本框，同时提供焦点失去事件
 --%>
<html>
  <head>
    <title>基于HTML，以GET或POST方式，检查注册用户名是否在数据库中已存在</title>
	<!-- 1.引入外部js文本 -->
    <script type="text/javascript" src="AJAX/_3_ajax.js"></script>
  </head>
  <body>
	<!-- 2.在页面中设置表单选项 -->
	用户名[POST]：<input id="usernameID" type="text" maxlength="4"/>
	<span id="resID">
	</span>
	
	<script type="text/javascript">
		/*3.定位文本框，同时提供焦点失去事件*/
		document.getElementById("usernameID").onblur = function(){
			var username = this.value;//获取文本框中内容
			var ajax = createAJAX();
			var method = "POST";//设置post请求
			var url = "${pageContext.request.contextPath}/UserServlet?time="+new Date().getTime();//请求url加日期,防止浏览器掉缓存页面
			ajax.open(method,url);
			ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");//设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
			var content = "username=" + username;
			ajax.send(content);//发送post请求
			ajax.onreadystatechange = function(){
				if(ajax.readyState == 4){
					if(ajax.status == 200){
						var tip = ajax.responseText;
						/*创建img标签*/
						var imgElement = document.createElement("img");
						/*设置img标签的src/width/height的属性值*/
						imgElement.src = tip;
						imgElement.style.width = "12px";
						imgElement.style.height = "12px";
						
						var spanElement = document.getElementById("resID");//定位span标签
						spanElement.innerHTML = "";//清空span标签中的内容
						spanElement.appendChild(imgElement);//将img标签加入到span标签中
					}
				}
			}
		}
	</script>
  </body>
</html>






