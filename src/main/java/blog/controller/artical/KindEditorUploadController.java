package blog.controller.artical;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import blog.constants.SysConstants;
import blog.constants.URLConstants;

/**
 * KindEditor富文本编辑器内容上传
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={URLConstants.ARTICAL_FILE_UPLOAD},
	initParams={@WebInitParam(name="attachmentPath",value=SysConstants.PATH_ATTACHMENT),
		@WebInitParam(name="maxSize",value="102400")
})
public class KindEditorUploadController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(KindEditorUploadController.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String attachmentPath = getServletConfig().getInitParameter("attachmentPath");
		
		String strSize = getServletConfig().getInitParameter("maxSize");
		//文件保存目录路径
		String savePath = req.getServletContext().getRealPath("/")+attachmentPath;
		//文件保存目录URL
		String saveUrl = req.getContextPath()+attachmentPath;
		//定义允许上传的文件扩展名
		Map<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		
		PrintWriter out = resp.getWriter();
		//最大文件大小
		long maxSize = Integer.parseInt(strSize);
		
		resp.setContentType("text/html;charset=UTF-8");
		
		if(!ServletFileUpload.isMultipartContent(req)){
			out.println("未选择文件");
			return ;
		}
		
		//检查目录 
		File uploadDir = new File(savePath);
		//检查目录写权限
		if(!uploadDir.exists()){
			uploadDir.mkdir();
		}
		String dirName = req.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if(!extMap.containsKey(dirName)){
			out.println("目录名错误!");
			return;
		}
		
		//创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> items;
		try {
			items = upload.parseRequest(req);
			Iterator<FileItem> itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				String fileName = item.getName();
				if (!item.isFormField()) {
					//检查文件大小
					if(item.getSize() > maxSize){
						out.println("上传文件大小超过限制。");
						return;
					}
					//检查扩展名
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
						out.println("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
						return;
					}

					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
					try{
						File uploadedFile = new File(savePath, newFileName);
						item.write(uploadedFile);
					}catch(Exception e){
						out.println("上传文件失败。");
						return;
					}

					JSONObject obj = new JSONObject();
					obj.put("error", 0);
					obj.put("url", saveUrl + newFileName);
					out.println(obj.toString());
				}
			}

		} catch (FileUploadException e1) {
			log.error("上传文件异常！",e1);
		}
		
	}
	
	
}
