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
 * 3. 带图片资源以及附件的邮件
 * @author Jie.Yuan
 *
 */
public class _3_发送附件邮件 {
	// 初始化参数
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
		message.setSubject("带附件邮件");//设置标题
		message.setSender(sendMan);//设置 发件人
		message.setRecipient(RecipientType.TO, new InternetAddress("lisi@itcast.com"));//设置邮件是发送或抄送及 接收人
		message.setSentDate(new Date());//设置邮件发送时间
		/*带附件邮件开发*/
		MimeMultipart mixed = new MimeMultipart("mixed");// 构建一个总的邮件块
		MimeBodyPart left = new MimeBodyPart();// 左侧： （文本+图片资源）
		MimeBodyPart right = new MimeBodyPart();// 右侧： 附件
		/*添加附件*/
		String attr_path = this.getClass().getResource("a.docx").getPath();
		DataSource attr_ds = new FileDataSource(new File(attr_path));
		DataHandler attr_handler = new DataHandler(attr_ds);
		right.setDataHandler(attr_handler);
		right.setFileName("a.docx");
		/*设置邮件related块内容*/
		MimeMultipart related = new MimeMultipart("related");//构建一个多功能邮件块
		/*设置到总邮件快的左侧中*/
		left.setContent(related);
		
		MimeBodyPart content = new MimeBodyPart();//构建多功能邮件块内容 = 左侧文本 + 右侧图片资源
		MimeBodyPart resource = new MimeBodyPart();
		String filePath = _3_发送附件邮件.class.getResource("8.jpg").getPath();//设置具体图片内容
		DataSource ds = new FileDataSource(new File(filePath));
		DataHandler handler = new DataHandler(ds);
		resource.setDataHandler(handler);
		resource.setContentID("8.jpg");
		content.setContent("<img src='cid:8.jpg'/>  好哈哈！", "text/html;charset=UTF-8");// 设置具体文本内容
		related.addBodyPart(content);
		related.addBodyPart(resource);
		/*设置到总邮件块*/
		mixed.addBodyPart(left);
		mixed.addBodyPart(right);
		/*总邮件快，设置到邮件对象中*/
		message.setContent(mixed);
		
		Transport trans = session.getTransport();//发送
		trans.connect("zhangsan", "888");
		trans.sendMessage(message, message.getAllRecipients());
		trans.close();
	}
}










