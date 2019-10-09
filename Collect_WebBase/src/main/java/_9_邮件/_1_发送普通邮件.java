package _9_邮件;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
/**
 * 1. 发送一封普通邮件
 * 		javaEE中邮件功能，用自带的mail.jar文件会有问题(该项目由JavaEE写,所以有问题)
 * 			解决办法:在javaee.jar中的mail文件夹(需要改javaEE)
 * @author Jie.Yuan
 */
public class _1_发送普通邮件 {
	public void testSend() throws Exception {
		/*1.邮件固定参数*/
		Properties prop = new Properties();
		prop.put("mail.transport.protocol", "smtp");	// 指定协议
		prop.put("mail.smtp.host", "localhost");		// 主机   stmp.qq.com
		prop.put("mail.smtp.port", 25);					// 端口
		prop.put("mail.smtp.auth", "true");				// 用户密码认证
		prop.put("mail.debug", "true");					// 调试模式
		/*2.创建一个邮件的会话*/
		Session session = Session.getDefaultInstance(prop);
		/*3.创建邮件体对象 (整封邮件对象)*/
		MimeMessage message = new MimeMessage(session);
		/*4.设置邮件体参数*/
		message.setSubject("我的第一封邮件	");//设置标题
		message.setSentDate(new Date());//设置邮件发送时间
		message.setSender(new InternetAddress("zhangsan@itcast.com"));//设置 发件人
		message.setRecipient(RecipientType.TO, new InternetAddress("lisi@itcast.com"));//设置邮件是发送或抄送及 接收人
		message.setText("正文");//设置简单纯文本邮件
		message.saveChanges();//设置保存邮件(可选)
		/*5.发送*/
		Transport trans = session.getTransport();
		trans.connect("zhangsan", "123");//输入发件人邮件帐号和密码
		trans.sendMessage(message, message.getAllRecipients());//发送邮件,将message发送给所有收件人
		trans.close();
	}
}














