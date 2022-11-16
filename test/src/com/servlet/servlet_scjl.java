package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impl.BuyerImpl;
import com.impl.OrderImpl;
import com.vo.Buyer;
import com.vo.Iscontent;
import com.vo.Order;
import com.vo.Seller;
import com.vo.Shop;

/**
 * Servlet implementation class servlet_scjl
 */
@WebServlet("/servlet_scjl")
public class servlet_scjl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_scjl() {
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
		Order or = new Order();
	    Date date = new Date();
	    
	    int waresid = Integer.parseInt(request.getParameter("waresid").trim());
	    int shopid = Integer.parseInt(request.getParameter("shopid").trim());
	    System.out.print("waresid:"+waresid);
	    System.out.print("shopid:"+shopid);
	    String buyerid = request.getParameter("buyerid");//之后自动获取
	    String waresnumber= request.getParameter("waresnumber");
	    if(!waresnumber.equals("")){
	    	or.setWaresnumber(Integer.valueOf(waresnumber));
	    }
	    String buyerphone = request.getParameter("buyerphone");
	    String buyeraddress = request.getParameter("buyeraddress");
	    
	    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    String str = format.format(date);
	    
	    //orderid需要自动生成
	    or.setWaresid(waresid);
	    or.setBuyerid(buyerid);
	    or.setShopid(shopid);
	    or.setOrdertime(str);
	    or.setBuyeraddress(buyeraddress);
	    or.setBuyerphone(buyerphone);
	    or.setOrderstate("未选择");
	    
	    System.out.println(or);
	    System.out.print(or);
	    Iscontent iscontent=new Iscontent();
	    
	    String buyit_result=iscontent.buyit(or);
	    HttpSession session = request.getSession();
	    session.setAttribute("buyit_result", buyit_result);
	    if(buyit_result.equals("购买成功")){
	    	System.out.print("上传：");
	    	OrderImpl lj1 = new OrderImpl();
	    	try {
	    		lj1.insertorder(or);
	    	} catch (SQLException e) {
	    		System.out.println("erro!!!!!!!!!!!!");
	    		e.printStackTrace();
	    	}
	    	request.getRequestDispatcher("servlet_yhspxx").forward((ServletRequest)request, (ServletResponse)response);
	    }else{
	    	request.getRequestDispatcher("admin_buyit.jsp?"+"wid="+waresid+"&shopid="+shopid).forward((ServletRequest)request, (ServletResponse)response);
	    }
	  }	

}
