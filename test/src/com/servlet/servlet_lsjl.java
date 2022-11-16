package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impl.HistoryImpl;
import com.vo.historyorder;

/**
 * Servlet implementation class servlet_lsjl
 */
@WebServlet("/servlet_lsjl")
public class servlet_lsjl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_lsjl() {
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
		 HistoryImpl ord = new HistoryImpl();
		    List<historyorder> asd = new ArrayList<>();
		    HttpSession session = request.getSession();
		    try {
		      asd = ord.selecthistoryorder();
		    } catch (Exception exception) {}
		    System.out.print(asd);
		    session.setAttribute("lsjlxx", asd);
		    request.getRequestDispatcher("admin_lsjl.jsp").forward((ServletRequest)request, (ServletResponse)response);
		  }

		
		

}
