package _8_文件上传下载;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 处理文件上传与下载
 * 
 * @author Jie.Yuan
 * 
 */
public class _3_处理文件上传与下载 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");// 获取请求参数： 区分不同的操作类型
		if ("upload".equals(method))
			upload(request, response);// 上传
		if ("downList".equals(method))
			downList(request, response);// 进入下载列表
		if ("down".equals(method))
			down(request, response);// 下载
	}

	/** 2. 进入下载列表:先获取upload目录下所有文件的文件名，再保存；跳转到down.jsp列表展示 */
	private void downList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> fileNames = new HashMap<String, String>();// 初始化map集合Map<包含唯一标记的文件名,简短文件名>
		String bathPath = getServletContext().getRealPath("/upload");// 获取上传目录，及其下所有的文件的文件名
		File file = new File(bathPath);// 目录
		String list[] = file.list();// 目录下，所有文件名
		if (list != null && list.length > 0) {// 遍历，封装
			for (int i = 0; i < list.length; i++) {
				String fileName = list[i];// 全名
				String shortName = fileName.substring(fileName.lastIndexOf("#") + 1);// 短名
				fileNames.put(fileName, shortName);// 封装
			}
		}
		request.setAttribute("fileNames", fileNames);// 保存到request域
		request.getRequestDispatcher("/downlist.jsp").forward(request, response);// 转发
	}

	/** 3.处理下载 */
	private void down(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("fileName");// 获取用户下载的文件名称(url地址后追加数据,get)
		fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
		String basePath = getServletContext().getRealPath("/upload");// 先获取上传目录路径
		InputStream in = new FileInputStream(new File(basePath, fileName));// 获取一个文件流
		fileName = URLEncoder.encode(fileName, "UTF-8");// 如果文件名是中文，需要进行url编码
		response.setHeader("content-disposition", "attachment;fileName="+ fileName);// 设置下载的响应头
		OutputStream out = response.getOutputStream();// 获取response字节流
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = in.read(b)) != -1) {
			out.write(b, 0, len);//输出文件
		}
		out.close();// 关闭
		in.close();
	}
	/** 1.上传 */
	private void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*上传代码(同_2_UploadServlet_batter)*/
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();//文件上传工厂
			ServletFileUpload upload = new ServletFileUpload(factory);//创建文件上传核心工具类
			if (upload.isMultipartContent(request)) {//判断： 当前表单是否为文件上传表单
				List<FileItem> list = upload.parseRequest(request);//把请求数据转换为一个个FileItem对象，再用集合封装
				for (FileItem item : list) {//遍历： 得到每一个上传的数据
					if (item.isFormField()) {//判断：是否普通文本数据
						String fieldName = item.getFieldName(); //表单元素名称
						String content = item.getString(); //表单元素名称， 对应的数据
					}else {
						String fieldName = item.getFieldName(); //表单元素名称
						String content = item.getString(); //表单元素名称， 对应的数据
						String name = item.getName(); //文件名
						String type = item.getContentType(); //文件类型
						InputStream in = item.getInputStream(); //上传文件流
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
