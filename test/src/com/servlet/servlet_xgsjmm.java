package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impl.SellerImpl;
import com.vo.Iscontent;
import com.vo.Seller;

/**
 * Servlet implementation class servlet_xgsjmm
 */
@WebServlet("/servlet_xgsjmm")
public class servlet_xgsjmm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_xgsjmm() {
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
		String pwd1 = request.getParameter("pwd1");
	    String pwd2 = request.getParameter("pwd2");
	    String pwd3 = request.getParameter("pwd3");
	    HttpSession session = request.getSession();
	    Seller seller = (Seller)session.getAttribute("seller");
	    System.out.print(String.valueOf(seller.getSellerpw()) + "hhh");
	    Iscontent iscontent = new Iscontent();
	    String xgsjmm_result = iscontent.xgsjmm(seller, pwd1, pwd2, pwd3);
	    session.setAttribute("xgsjmm_result", xgsjmm_result);
	    if (xgsjmm_result.equals("修改成功")) {
	      seller.setSellerpw(pwd2);
	      SellerImpl lj = new SellerImpl();
	      try {
	        lj.updatesellerpw(seller);
	      } catch (SQLException e) {
	        e.printStackTrace();
	      } 
	      request.getRequestDispatcher("admin_change.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    } else {
	      request.getRequestDispatcher("admin_change.jsp").forward((ServletRequest)request, (ServletResponse)response);
	    } 
	  }

}
