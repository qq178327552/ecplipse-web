<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- AJAX案例:
		以xml交互,完成省份-城市二级下拉联动
	1.引入外部js文本,创建AJAX异步对象
	2.在页面中设置表单选项
	3.定位文本框，同时提供焦点失去事件
	4.清空城市下拉框中的内容，除第一项外
	5.获取选择的省份,以发送填充市
	6.从AJAX异步对象中获取服务器响应的xml文档
	7.按照DOM规则，解析XML文档(innerHTML只能用在html/jsp中，不能用在xml中)
 --%>
<html>
  <head>
    <title>基于XML，以POST方式，完成省份-城市二级下拉联动</title>
    <!-- 1.引入外部js文本 -->
    <script type="text/javascript" src="js/ajax.js"></script>
  </head>
  <body>
	<!-- 2.在页面中设置表单选项 -->
	<select id="provinceID" style="width:111px">
		<option>选择省份</option>
		<option>湖南</option>
		<option>广东</option>
	</select>	
	&nbsp;&nbsp;&nbsp;
	<select id="cityID" style="width:111px">
		<option>选择城市</option>
	</select>	
	
	<script type="text/javascript">
		/*3.定位省份下拉框，同时添加内容改变事件*/
		document.getElementById("provinceID").onchange = function(){
			/*4.清空城市下拉框中的内容，除第一项外*/
			var cityElement = document.getElementById("cityID");
			cityElement.options.length = 1;
			/*5.获取选择的省份,以发送填充市*/
			var index = this.selectedIndex;//获取选中option标签的索引号，从0开始	
			var optionElement = this[index];//定位选中的option标签
			var province = optionElement.innerHTML;//获取选中的option标签中的内容，即省份
			if("选择省份" != province){//如果选中的内容不是"选择省份"
				var ajax = createAJAX();
				var method = "POST";
				var url = "${pageContext.request.contextPath}/ProvinceCityServlet?time="+new Date().getTime();
				ajax.open(method,url);
				ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");//设置AJAX请求头
				var content = "province=" + province;
				ajax.send(content);
				ajax.onreadystatechange = function(){
					if(ajax.readyState == 4){
						if(ajax.status == 200){
							/*6.从AJAX异步对象中获取服务器响应的xml文档*/
							var xmlDocument = ajax.responseXML;
							/*7.按照DOM规则，解析XML文档*/
							var cityElementArray = xmlDocument.getElementsByTagName("city");//获取为"city"标签的节点数组	
							for(var i=0;i<cityElementArray.length;i++){
								var city = cityElementArray[i].firstChild.nodeValue;//获取第i个节点下第一个孩子的值(也就是该节点的值)
								var optionElement = document.createElement("option");//创建选项
								optionElement.innerHTML = city;//把返回的城市添加到创建的option选项中
								cityElement.appendChild(optionElement);//事件开始处定位的"选择城市"标签添加选项
							}
						}
					}
				}
			}
		}
	</script>
  </body>
</html>






