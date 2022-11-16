package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impl.WaresImpl;
import com.vo.Wares;

/**
 * Servlet implementation class servlet_pergood
 */
@WebServlet("/servlet_pergood")
public class servlet_pergood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_pergood() {
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
		int wid=Integer.parseInt(request.getParameter("wid"));
		
	    Wares w = new Wares();
	    Wares ware=null;
	    w.setWaresid(wid);
	    WaresImpl war = new WaresImpl();
	    try {
	      ware = war.getperwares(w);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	    HttpSession session = request.getSession();
	    session.setAttribute("ware", ware);
	    request.getRequestDispatcher("cus_shoptt.jsp").forward(request,response);
	  }

}
