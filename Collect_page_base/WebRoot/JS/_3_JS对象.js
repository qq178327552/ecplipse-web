/**
 * JS�е��ֶ���
 * 		1.Date����
 * 		2.Math����
 * 		3.string����
 * 		4.Array����
 * 		5.�Զ������
 * 		6.window����
 * 		7.status����
 * 		8.location����
 * 		9.history����
 */
/*1.Date����*/
	var nowStr = new Date().toLocaleString();
	window.document.write(nowStr + "<br/>");	
/*2.Math����*/
	for(var i=1;i<=10;i++){
		document.write(Math.floor(Math.random()*9)+1 + "<br/>");//1��9֮����������
	}
/*3.string����*/
	var str = "Hello���";
	var size = str.length; 
	alert(size);//���Ϊ7
/*4.Array����*/
	var array = new Array("����","��ѧ","Ӣ��",true,123);
	for(var i=0;i<array.length;i++){
		document.write(array[i] + "   ");
	}
/*5.�Զ������*/
	function Person(id,name,sal){
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
	var p = new Person(1,"����",7000);
	document.write("���:" + p.id + "<br/>");
	document.write("����:" + p.name + "<br/>");
	document.write("нˮ:" + p.sal + "<br/>");
/*6.window����*/
	var url = "www.baidu.com";
	window.open(url);//���´���ҳ
/*7.status����*/
	var nowStr = new Date().toLocaleString();
	window.status = nowStr;//����ǰʱ�����õ�״̬����
/*8.location����*/
	var url = "04_images.html";
	window.location.href = url;//ģ���û��ڵ�ַ������url��������ҳ������
/*9.history����*/
	window.history.go(0);//��ʾˢ��