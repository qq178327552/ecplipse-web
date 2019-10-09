package _9_邮件;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;


/**
 * 带图片资源的邮件
 * @author Jie.Yuan
 *
 */
public class _2_发送图片邮件 {
	private static Properties prop;// 初始化参数
	private static InternetAddress sendMan = null;// 发件人
	static {
		prop = new Properties();
		prop.put("mail.transport.protocol", "smtp");	// 指定协议
		prop.put("mail.smtp.host", "localhost");		// 主机   stmp.qq.com
		prop.put("mail.smtp.port", 25);					// 端口
		prop.put("mail.smtp.auth", "true");				// 用户密码认证
		prop.put("mail.debug", "true");					// 调试模式
		try {
			sendMan = new InternetAddress("zhangsan@itcast.com");
		} catch (AddressException e) {
			throw new RuntimeException(e);
		}
	}
	public void testSend() throws Exception {
		Session session = Session.getDefaultInstance(prop);//创建邮件会话
		MimeMessage message = new MimeMessage(session);//创建邮件对象
		/*邮件中设置超链接*/
		message.setContent("<a href='#'>百度</a>", "text/html;charset=UTF-8");
		/*设置参数：标题、发件人、收件人、发送时间、内容*/
		message.setSubject("带图片邮件");//设置标题
		message.setSender(sendMan);//设置 发件人
		message.setRecipient(RecipientType.TO, new InternetAddress("lisi@itcast.com"));//设置邮件是发送或抄送及 接收人
		message.setSentDate(new Date());//设置邮件发送时间
		/*设置邮件内容: 多功能用户邮件 (related)*/
		MimeMultipart related = new MimeMultipart("related");//构建一个多功能邮件块(related块:可以包含文本+资源(该块不包含附件,mixed邮件块可三者都包含))
		MimeBodyPart content = new MimeBodyPart();//创建文本内容
		MimeBodyPart resource = new MimeBodyPart();//创建资源内容
		/*设置具体资源*/
		String filePath = _2_发送图片邮件.class.getResource("8.jpg").getPath();
		DataSource ds = new FileDataSource(new File(filePath));
		DataHandler handler = new DataHandler(ds);
		resource.setDataHandler(handler);
		resource.setContentID("8.jpg");   //设置资源名称，给外键引用
		/*设置具体文本*/
		content.setContent("<img src='cid:8.jpg'/>  好哈哈！", "text/html;charset=UTF-8");
		/*填充*/
		related.addBodyPart(content);
		related.addBodyPart(resource);//填充块
		message.setContent(related);//把构建的复杂邮件快，添加到邮件中
		/*发送*/
		Transport trans = session.getTransport();//发送
		trans.connect("zhangsan", "123");
		trans.sendMessage(message, message.getAllRecipients());
		trans.close();
	}
}