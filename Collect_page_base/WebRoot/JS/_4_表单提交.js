/**
 *  ���ύ
 * 		1.��JS�ύ��
 * 
 */
/*1.��JS�ύ��*/
	var inputElement = document.getElementsByTagName("input")[0];//��λ�ύ��ť
	inputElement.onclick = function(){//Ϊ�ύ��ť��ӵ����¼�
		var formElement = document.forms[0];//��λ<form>��ǩ��forms��ʾdocument���������б��ļ��ϣ�ͨ���±����ò�ͬ�ı�����0��ʼ
		formElement.submit();//�ύ�����ύ��action����ָ���ĵط�
	}