package _8_文件上传下载;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * 文件上传工具-FileUpload
 * @author zheng
 */
public class _1_文件上传servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*1.文件上传工厂类*/
			FileItemFactory factory = new DiskFileItemFactory();
			/*2.创建文件上传核心工具类*/
			ServletFileUpload upload = new ServletFileUpload(factory);
			/*3.判断： 当前表单是否为文件上传表单*/
			if (upload.isMultipartContent(request)){
				/*4.把请求数据转换为一个个FileItem对象，再用集合封装*/
				List<FileItem> list = upload.parseRequest(request);
				/*5.遍历： 得到每一个上传的数据*/
				for (FileItem item: list){
					/*判断：普通文本数据*/
					if (item.isFormField()){
						/*普通文本数据*/
						String fieldName = item.getFieldName();	//表单元素名称
						String content = item.getString();		//表单元素名称， 对应的数据
					}
					else {
						/*文件上传表单*/
						String fieldName = item.getFieldName();	//表单元素名称
						String name = item.getName();			//文件名				
						String content = item.getString();		//表单元素名称， 对应的数据
						String type = item.getContentType();	//文件类型
						InputStream in = item.getInputStream(); //上传文件流
					}
				}
			}
			else {
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
