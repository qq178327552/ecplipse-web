/*向页面输出数据的JS代码,_2_function_javascript.html可调用*/
/**
 * JS中有三种定义函数的方式
 * 	1.正常方式
 * 	2.构造器方式，最后一个参数为函数体，每个参数都是字符串类型
 * 	3.直接量或匿名或无名方式
 */
/*1.正常方式(先)*/
	function add(num1,num2){
		return num1 + num2;
	}
	window.alert("10+20=" + add(10,20));
/*2.构造器方式，最后一个参数为函数体，每个参数都是字符串类型(后)*/
	var add = new Function("num1","num2","return num1+num2");
	window.alert("100+200=" + add(100,200));
/*3.直接量或匿名或无名方式(再)*/
	var add = function(num1,num2){
					return num1 + num2;
			  }
	window.alert("1000+2000=" + add(1000,2000)); 