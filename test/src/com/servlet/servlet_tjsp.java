package com.servlet;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
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

import com.impl.WaresImpl;
import com.vo.Iscontent;
import com.vo.Shop;
import com.vo.Wares;

/**
 * Servlet implementation class servlet_tjsp
 */
@WebServlet("/servlet_tjsp")
public class servlet_tjsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_tjsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Shop shop = (Shop)session.getAttribute("shop");
	    String waresname=request.getParameter("waresname");
	    String waresprice=request.getParameter("waresprice");
	    String waresnumber=request.getParameter("waresnumber");
	    String waresclass=request.getParameter("waresclass");
	    String matketing=request.getParameter("matketing");
	    
	    Wares wa = new Wares();
	    wa.setWaresname(waresname);
	    if(waresprice!=""){
	    	wa.setWaresprice(Double.valueOf(waresprice));
	    }
	    if(waresnumber!=""){
	    	try{
	    		wa.setWaresnumber(Integer.valueOf(waresnumber));
	    	}catch(NumberFormatException e){
	    		String fabu_result="商品数量必须是大于0的整数";
	    		session.setAttribute("fabu_result", fabu_result);
	    		request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    	}
	    }else{
	    	String fabu_result="商品数量不能为空";
    		session.setAttribute("fabu_result", fabu_result);
    		request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    }
	    wa.setShopid(shop.getShopid());
	    wa.setWaresstate("putaway");
	    wa.setWarespicture((String)session.getAttribute("fn"));
	    wa.setWaresclass(waresclass);
	    wa.setMatkering(matketing);
	    System.out.println(wa+"!");
	    
	    Iscontent iscontent=new Iscontent();
	    String fabu_result=iscontent.fabu(wa);
	    session.setAttribute("fabu_result", fabu_result);
	    if(fabu_result.equals("发布成功")){
	    	WaresImpl war = new WaresImpl();
	    	try {
	    		fabu_result=war.insertwares(wa);
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	} 
	    	session.setAttribute("fabu_result", fabu_result);
	    	request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    }else{
	    	request.getRequestDispatcher("admin_waresup.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    }
	}

}
