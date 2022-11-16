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
import com.vo.Seller;

/**
 * Servlet implementation class servlet_sjzc
 */
@WebServlet("/servlet_sjzc")
public class servlet_sjzc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_sjzc() {
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
		String id = request.getParameter("sellerid");
	    String pwd = request.getParameter("sellerpw");
	    String name = request.getParameter("sellername");
	    String phone = request.getParameter("sellerphone");
	    Seller se = new Seller();
	    se.setSellerid(String.valueOf(id));
	    se.setSellerpw(pwd);
	    se.setSellername(name);
	    se.setSellerphone(phone);
	    SellerImpl lj = new SellerImpl();
	    try {
	      lj.insertseller(se);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }

	    HttpSession session = request.getSession();
	    session.setAttribute("zhuce_result", "注册成功");
	    request.getRequestDispatcher("addrs.jsp").forward((ServletRequest)request, (ServletResponse)response);
	  }

}
