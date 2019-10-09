package _8_文件上传下载;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class _2_改进文件上传servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/* 1.文件上传工厂 */
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File("C:/"));//设置上传临时目录，默认设置tomcat的temp目录下
			/*2. 创建文件上传核心工具类*/
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(30 * 1024 * 1024);//设置单个文件允许的最大的大小： 30M
			upload.setSizeMax(80 * 1024 * 1024);//设置文件上传表单允许的总大小: 80M
			upload.setHeaderEncoding("UTF-8");//设置上传表单文件名的编码,相当于：request.setCharacterEncoding("UTF-8");
			/*3.判断： 当前表单是否为文件上传表单*/
			if (upload.isMultipartContent(request)) {
				/*4.把请求数据转换为一个个FileItem对象，再用集合封装*/
				List<FileItem> list = upload.parseRequest(request);
				/*遍历： 得到每一个上传的数据*/
				for (FileItem item : list) {
					/*判断：普通文本数据*/
					if (item.isFormField()) {
						/*普通文本数据*/
						String fieldName = item.getFieldName(); //表单元素名称
						String content = item.getString(); //表单元素名称， 对应的数据
						// item.getString("UTF-8"); 指定处理编码
						System.out.println(fieldName + " " + content);
					}
					else {
						/*文件上传表单*/
						String fieldName = item.getFieldName(); //表单元素名称
						String content = item.getString(); //表单元素名称， 对应的数据
						
						String name = item.getName(); //文件名
						String type = item.getContentType(); //文件类型
						InputStream in = item.getInputStream(); //上传文件流
						/*把文件写入到指定目录,相同文件名的文件给用户添加一个唯一标记*/
						String id = UUID.randomUUID().toString();//随机生成一个唯一标记
						name = id + "#" + name;//与文件名拼接
						String path = getServletContext().getRealPath("/upload");// 获取上传基路径(与WEB-INF同级的/upload)
						
						File file = new File(path, name);// 创建目标文件
						item.write(file);//把文件写入到指定目录
						item.delete(); //删除系统产生的临时文件
					}
				}
			} else {
				System.out.println("当前表单不是文件上传表单，处理失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
