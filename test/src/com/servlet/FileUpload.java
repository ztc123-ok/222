package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class FillUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String fn = null;
	    try {
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      ServletFileUpload upload = new ServletFileUpload((FileItemFactory)factory);
	      List<FileItem> items = upload.parseRequest((RequestContext)new ServletRequestContext(request));
	      Iterator<FileItem> fiIter = items.iterator();
	      FileItem fi = null;
	      while (fiIter.hasNext()) {
	        fi = fiIter.next();
	        if (fi.isFormField()) {
	          continue;
	        } 
	        try {
	          String ofn = fi.getName();
	          String updir = "C:\\Users\\周\\Desktop\\团队成果\\验收待完善\\test\\WebContent\\upload1\\";//这里我写死了request.getServletContext().getRealPath("/upload1");
	          String ext = ofn.substring(ofn.lastIndexOf("."));
	          String fnf = UUID.randomUUID().toString();
	          fn = String.valueOf(fnf) + ext;
	          String df = updir + fn;//updir+"\\"+fn;
	          System.out.println(updir);
	          System.out.println("df:" + df);
	          fi.write(new File(df));
	        } catch (Exception e) {
	          e.printStackTrace();
	        } 
	      } 
	    } catch (FileUploadException e) {
	      e.printStackTrace();
	    } 
	    HttpSession session = request.getSession();
	    session.setAttribute("fn", fn);
	    request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}

}
