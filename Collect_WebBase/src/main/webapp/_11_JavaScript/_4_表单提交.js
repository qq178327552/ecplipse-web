/**
 *  表单提交
 * 		1.用JS提交表单
 * 
 */
/*1.用JS提交表单*/
	var inputElement = document.getElementsByTagName("input")[0];//定位提交按钮
	inputElement.onclick = function(){//为提交按钮添加单击事件
		var formElement = document.forms[0];//定位<form>标签，forms表示document对象中所有表单的集合，通过下标引用不同的表单，从0开始
		formElement.submit();//提交表单，提交到action属性指定的地方
	}