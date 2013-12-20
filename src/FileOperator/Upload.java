package FileOperator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{
//			String uploadPath = "C:/temp2/"; // 用于存放上传文件的目录
//			String tempPath = "C:/temp"; // 用于存放临时文件的目录
			String uploadPath = "//Users//lin.shuning//Works//SoftWare//eclipse j2ee//JavaFileUpload//"; // 用于存放上传文件的目录
			String tempPath = "//Users//lin.shuning//Works//SoftWare//eclipse j2ee//JavaFileUpload//temp"; // 用于存放临时文件的目录
			String subDir = "user id";
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(4096);
				factory.setRepository(new File(tempPath));
//				factory.setRepository(new File(request.getRealPath("/")+ "ImagesUploadTemp"));

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);

				// Set overall request size constraint
				upload.setSizeMax(1024*1024*10);

				List items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					// 忽略其他不是文件域的所有表单信息
					if (!item.isFormField()) {
						String originalPath = item.getName();
	                    String originalFileName = originalPath.substring(originalPath.lastIndexOf('\\') + 1);
	                    Calendar cal = Calendar.getInstance();
	                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	                    String dateStr = formatter.format(cal.getTime());
	                    File uploadedFile = new File(uploadPath+ "/" + subDir+ "/" + dateStr + "_" + originalFileName);
	                    uploadedFile.createNewFile();
	                    item.write(uploadedFile);
					}
				}

			} catch (Exception e) {
				// 可以跳转出错页面
//				response.sendRedirect("error.jsp");
				e.printStackTrace();
			}
			response.sendRedirect("upload.jsp");

		}

	}

}
