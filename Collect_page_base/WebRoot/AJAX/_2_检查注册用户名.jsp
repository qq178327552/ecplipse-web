<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- AJAX案例:
		以GET或POST方式，检查注册用户名是否在数据库中已存在
		1.在页面中设置表单选项
		2.创建AJAX异步对象，即XMLHttpRequest
		3.定位文本框，同时提供焦点失去事件
 --%>
<html>
  <head>
    <title>基于HTML，以GET或POST方式，检查注册用户名是否在数据库中已存在</title>
  </head>
  <body>
	<!-- 1.页面表单输入用户名,当光标移出后发送servlet判断是否存在用户名 -->
	<form>
		用户名[GET]：<input id="usernameID" type="text" name="username" maxlength="4"/>
		光标移出后，立即检查结果
	</form>
	<hr/>
	<span id="resID"></span>
	
	<script type="text/javascript">
		/*2.创建AJAX异步对象，即XMLHttpRequest*/
		function createAJAX(){
			var ajax = null;
			try{
				ajax = new ActiveXObject("microsoft.xmlhttp");
			}catch(e1){
				try{
					ajax = new XMLHttpRequest();
				}catch(e2){
					alert("你的浏览器不支持ajax，请更换浏览器");
				}
			}
			return ajax;
		}
	</script>
	
	<script type="text/javascript">
		/*3.定位文本框，同时提供焦点失去事件*/
		document.getElementById("usernameID").onblur = function(){
			var username = this.value;//获取文本框中输入的值
			if(username.length == 0){//如果用户没有填内容
				document.getElementById("resID").innerHTML = "用户名必填";//提示"用户名必填" 
			}else{
				username = encodeURI(username);//对输入的汉字进行UTF-8(U8)的编码
				var ajax = createAJAX();//创建ajax
				var method = "GET";
				var url = "${pageContext.request.contextPath}/UserServlet?time="+new Date().getTime()+"&username=" + username;
				ajax.open(method,url);
				ajax.send(null);
				ajax.onreadystatechange = function(){
					if(ajax.readyState == 4){
						if(ajax.status == 200){
							var tip = ajax.responseText;
							document.getElementById("resID").innerHTML = tip;//提示在servlet中返回的结果
						}
					}
				}
			}
		}
	</script>
  </body>
</html>