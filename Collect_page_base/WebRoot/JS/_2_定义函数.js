/*��ҳ��������ݵ�JS����,_2_function_javascript.html�ɵ���*/
/**
 * JS�������ֶ��庯���ķ�ʽ
 * 	1.������ʽ
 * 	2.��������ʽ�����һ������Ϊ�����壬ÿ�����������ַ�������
 * 	3.ֱ������������������ʽ
 */
/*1.������ʽ(��)*/
	function add(num1,num2){
		return num1 + num2;
	}
	window.alert("10+20=" + add(10,20));
/*2.��������ʽ�����һ������Ϊ�����壬ÿ�����������ַ�������(��)*/
	var add = new Function("num1","num2","return num1+num2");
	window.alert("100+200=" + add(100,200));
/*3.ֱ������������������ʽ(��)*/
	var add = function(num1,num2){
					return num1 + num2;
			  }
	window.alert("1000+2000=" + add(1000,2000)); 