/**
 * JavaScript基本用法:
 * 	1.弹出对话框
 * 	2.向页面输出数据
 * 	3.定义变量
 * 	4.javascript的数据类型
 * 	5.字符串转数字
 * 	6.javascript运算符
 * 	7.控制流程语句
 * 	8.undefined不是字符串，它是一种类型，判断某个变量是否为undefined
 * 附：
 * 	9.JavaScript优势
 * 	3.1.定义变量详解
 * 	4.1.数据类型详解
 * 	5.1.字符串转数字详解
 * 	6.1.运算符详解
 * 	7.1.控制流程语句详解
 * 	
 */
/*1.弹出对话框*/
	alert("郑皓元");//弹出对话框框
/*2.向页面输出数据*/
	document.write("1.页面引用");//向页面输出数据
/*3.定义变量*/
	var num = 100;//num为number类型
	var str = "郑";//str为string类型，注意js中的string类型用''或""均可
	var flag = true;//flag为boolean类型
/*4.javascript的数据类型*/
	var a=10;//声明var类型的变量(任意类型),存入10则a为number类型
	document.write("a的数据类型是:"+(typeof a));//查看a的数据类型
	a=true;//给a赋值，则a的数据类型变为boolean类型
	document.write("a现在的数据类型是:"+(typeof a));//查看a现在的数据类型
	document.write("a="+a+"<br/>");//向页面输出a的值，并换行
/*5.字符串转数字*/
	var a = "12";
	parseInt(a);//返回的是number类型的整数
	document.write("判断是不是整数，即可否运算:"+(parseInt(a)+1));
	document.write(isNaN("123")+"<br/>");//IsNaN()判断该字符串是否是 一个数字
/*6.javascript运算符*/
	document.write((1+true)+"<br/>");//加法:值为2
	document.write((1+false)+"<br/>");//加法:值为1
	document.write("hello"+1); //加法:作为连接符hello1
	document.write("除法运算是："+(10/3)+"<br/>"); //除法:如果两个整数相除不能整数的时候结果还是小数。
	document.write("10大于3吗？"+(10>3)+"<br/>");//比较运算符
	document.write("10字符串大于3字符串吗？"+("190">"19")+"<br/>"); //比较运算符:字符串与字符串比较
	document.write("10大于字符串9吗？"+( 10 > "9")+"<br/>"); //比较运算符:字符串还可以与数字进行比较。  凡是数字与字符串 进行比较，会先把字符串转换成数字再进行比较 的。
	document.write((true&&true)+"<br/>");//逻辑运算符
	document.write((true&&false)+"<br/>");//逻辑运算符
	document.write((false&&true)+"<br/>");//逻辑运算符
	document.write((false&&false)+"<br/>");//逻辑运算符
	document.write((true||true)+"<br/>");//逻辑运算符
	document.write((true||false)+"<br/>");//逻辑运算符
	document.write((false||true)+"<br/>");//逻辑运算符
	document.write((false||false)+"<br/>");//逻辑运算符
	var age = 10;
	document.write(age>18?"成年人":"未成年人");//三目运算符
/*7.控制流程语句*/
	var workAge = 0;
	var str ="";
	var b;
	if(b){
		document.write("明天过来面试！！");
	}else{
		document.write("不要在投我们公司了，不要你！");	
	}
	var option = "A";
	switch(option){
		case score>=90?"A":"B":
			document.write("java");
			break;
		case "B":
			document.write("ps");
		
		case "C":
			document.write("javascript");
			break;
		case "D":
			document.write("C++");
			break;
	}
/*8.undefined不是字符串，它是一种类型，判断某个变量是否为undefined*/
	var card;
	alert(card);//undefined类型
	if (card == undefined) {
		alert("card变量暂没值");
	} else {
		alert(card);
	}

/*
 9.JavaScript优势
	1).网页控制：
		html: 负责了一个页面的结构.
		css: 负责了一个页面的样式
		javascript： 负责与用户进行交互
	2).javascript的特点：
		跨平台
		安全性(javascript的代码不能直接访问硬盘的内容)
	3).javascript与java之间区别
		a).javascript是属于网景公司产品， java是sun公司的产品。
		b).javascript是基于对象的语言，java是面向对象的语言。
		c).javascript是解释型语言，java是解释、编译型语言。
		d).javascript是弱类型语言， java 是强类型语言。
			java中声明变量 的时候必须要明确该变量的数据类型。
			javascript声明变量不需要明确是何种数据类型， 任何的变量都是使用一个关键字var去声明即可。
 */
/*
 3.1.定义变量详解
 	var 变量名 = 数据;
	注:
		1). 在javascript中声明变量是 使用var关键字声明的，javascript中的变量可以存储任意的数据类型数据.
		2). javascript中变量数据类型是根据存储的值决定的，可以随时更改存储数据的类型。
		3). 定义了多个同名的变量是，后定义的同名变量是覆盖前面定义的同名变量。
		4). 声明变量的时候可以省略var关键字，但是不建议省略。
*/
/*
 4.1.数据类型详解
	1).number 小数与整数
	2).string 字符串 注意： javascript中没有字符的概念，只有字符串，字符串可以写在单引号或双引号中。
	3).boolean 布尔数据类型
	4).undefined  undefined代表该变量没有定义。
*/
/*
 5.1.字符串转数字详解
	1).parseInt()  可以把一个字符串转换成整数。
		当转换值为小数，则转换后舍去发成整数
		当转换值含有非数字的字符，那么parseInt方法会从字符串的首个字符开始寻找，一直找到非数字字符为止，然后就使用前面的数字字符转换成数字
		当转换值以字母开头，则报NaN(不是一个数字)
		当转换值以0开头整数，则从八进制转换十进制;若以0开头字符串，则去掉0后转换
		当转换值以0x开头字符串，则按十六进制转成十进制
	2).IsNaN()  判断该字符串是否是 一个数字,当不是一个数字返回true,
	3).parseFloat() 可以把一个字符串转换成小数。
*/
/*
 6.1.运算符详解
	1).+(加法、正数、 连接符)
		true 是1. false是0
	2).除法：
		如果两个整数相除不能整数的时候结果还是小数
	3).比较运算符，字符串与字符串的比较规则是：
		能找到对应位置上的不同字符，那么就比较第一个不同字符的大小。
		不能找到对应位置上的不同字符，这时候比较的是两个字符串的长度。
		字符串还可以与数字进行比较。  凡是数字与字符串 进行比较，会先把字符串转换成数字再进行比较。
	4).逻辑运算符:
		与、或、非
	5).三目运算符
		布尔表达式?值1:值2;
*/
/*
 7.1.控制流程语句详解
	1).控制流程语句:if语句:
		if(判断条件){
			符合条件执行的代码
		}
		if语句的特殊之处：在javascript中的if语句条件不单止可以写布尔表达式，还可以写任何的数据。
		number  非0为true, 0为false.
		string  内容不能空是true， 内容空的时候是false。
		undefined：false
		NaN:    false
	2).选择语句：switch语句
		switch(变量){
		case 值1:&nbsp;
			break;
		case 值2：
			break;
		...
		default：
			break;
		}
		特殊之处：在javascript中case后面可以跟常量与变量还可以跟表达式。
*/
	
	
	
	
