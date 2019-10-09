package _3_socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * socket服务器端程序
 * <p>
 * 1.创建ServerSocket <br/>
 * 2.接收客户端的连接  <br/>
 * 3.读取本地的test.html文件  <br/>
 * 4.构建数据输出通道  <br/>
 * 5.发送数据  <br/>
 * 6.关闭资源  <br/>
 * </p>
 * @author zheng
 */
public class Socket_服务器端 {
	/**
	 * 入口方法
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/*1.创建ServerSocket*/
		ServerSocket server = new ServerSocket(8080);
		System.out.println("服务器已经启动成功....");
		while(true){
			/*2.接收客户端的连接*/
			Socket socket = server.accept();
			/*3.读取本地的test.html文件*/
			FileInputStream in = new FileInputStream(new File("e:/web/test.html"));
			/*4.构建数据输出通道*/
			OutputStream out = socket.getOutputStream();
			/*5.发送数据*/
			byte[] buf = new byte[1024];
			int len = 0;
			while( (len=in.read(buf))!=-1 ){
				out.write(buf, 0, len);
			}
			/*6.关闭资源*/
			out.close();
			in.close();
		}
	}
}
