import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UploadServlet() {
		super();
	}
	
	// Used to download file after upload success
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String name = request.getParameter("downloadedFile"); // file name to download
		response.setHeader("Content-disposition", "attachment; filename=" + name);
				
	    try(
	    	// "uploads" is the folder inside the project's root folder
	    	InputStream in = request.getServletContext().getResourceAsStream("uploads/" + name);	
	    			
	        OutputStream out = response.getOutputStream()) 
	        {
	
	            byte[] buffer = new byte[1048];
	            int numBytesRead;
	            
	            while ((numBytesRead = in.read(buffer)) > 0) 
	                out.write(buffer, 0, numBytesRead);
	        }
	}

	// Used to upload file from JSP form
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Create "uploads" folder inside the project's root folder if not exists to store uploaded files
		String uploads = getServletContext().getRealPath("/") + "uploads";
		File create = new File(uploads);
		
		if (!create.exists()) 
			create.mkdirs();
				
		// Get file from request
		Part filePart = request.getPart("file"); // "file" is a name of input type file
		String selectedFileName = filePart.getSubmittedFileName(); // the name of file which is selection from the choose file dialog
		String extension = selectedFileName.substring(selectedFileName.indexOf(".") + 1);
		
		if(!extension.equals("txt") && !extension.equals("doc") && !extension.equals("docx") &&
		   !extension.equals("img") && !extension.equals("pdf") && !extension.equals("rar") &&
		   !extension.equals("zip"))
		{
			// Print message for unsupported file extension
			out.println("<h1>Unsupported file extension</h1>");
			return;
		}
		
		// get file name from textbox in JSP
		String textboxFileName = request.getParameter("name") + "." + extension; 
		
		// Save file to server
		InputStream fileContent = filePart.getInputStream();
		FileOutputStream fileOutputStream = new FileOutputStream(uploads + "/" + textboxFileName);
				
		int read = 0;
		byte[] bytes = new byte[1024];

		while ((read = fileContent.read(bytes)) != -1)
			fileOutputStream.write(bytes, 0, read);
		
		// Print message when upload success
		out.println("<h1>File has been uploaded</h1> <br>");
		out.println("Click <a href=\"UploadServlet?downloadedFile=" + textboxFileName + "\">here</a> to visite file");
	}
}
