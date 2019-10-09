/**
 * JS中的种对象
 * 		1.Date对象
 * 		2.Math对象
 * 		3.string对象
 * 		4.Array对象
 * 		5.自定义对象
 * 		6.window对象
 * 		7.status对象
 * 		8.location对象
 * 		9.history对象
 */
/*1.Date对象*/
	var nowStr = new Date().toLocaleString();
	window.document.write(nowStr + "<br/>");	
/*2.Math对象*/
	for(var i=1;i<=10;i++){
		document.write(Math.floor(Math.random()*9)+1 + "<br/>");//1到9之间的随机整数
	}
/*3.string对象*/
	var str = "Hello你好";
	var size = str.length; 
	alert(size);//输出为7
/*4.Array对象*/
	var array = new Array("语文","数学","英语",true,123);
	for(var i=0;i<array.length;i++){
		document.write(array[i] + "   ");
	}
/*5.自定义对象*/
	function Person(id,name,sal){
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	var p = new Person(1,"波波",7000);
	document.write("编号:" + p.id + "<br/>");
	document.write("姓名:" + p.name + "<br/>");
	document.write("薪水:" + p.sal + "<br/>");
/*6.window对象*/
	var url = "www.baidu.com";
	window.open(url);//重新打开网页
/*7.status对象*/
	var nowStr = new Date().toLocaleString();
	window.status = nowStr;//将当前时间设置到状态栏中
/*8.location对象*/
	var url = "04_images.html";
	window.location.href = url;//模拟用户在地址栏输入url访问其它页面的情况
/*9.history对象*/
	window.history.go(0);//演示刷新