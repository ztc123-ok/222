package com.impl;

import java.sql.SQLException;

import com.dao.HistoryDao;
import com.vo.historyorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HistoryImpl implements HistoryDao{
	Connection getConnection() {
	    Connection conn = null;
	    try {
	      conn =new DbConfig().dbConfig();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	    return conn;
	  }
	  
	  
	  public List<historyorder> selecthistoryorder() throws SQLException {
		    Connection conn = getConnection();
		    String sql = "select * from historyorder";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();
		    List<historyorder> asd = new ArrayList<>();
		    historyorder order = null;
		    while (rs.next()) {
		      order = new historyorder();
		      order.setHistoryid(rs.getInt(1));
		      order.setWaresid(rs.getInt(2));
		      order.setShopid(rs.getInt(3));
		      order.setBuyerid(rs.getString(4));
		      order.setWaresnumber(rs.getInt(5));
		      order.setFinishtime(rs.getString(6));
		      order.setBuyeraddress(rs.getString(7));
		      order.setBuyerphone(rs.getString(8));
		      order.setResult(rs.getString(9));
		      asd.add(order);
		    } 
		    rs.close();
		    ps.close();
		    conn.close();
		    return asd;
		  }
	  
	  
	  
	  public void insertorder(historyorder or) throws SQLException{
		  
		  Connection conn = getConnection();
		    String sql = "insert into historyorder values(?,?,?,?,?,?,?,?,?)";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setInt(1, 0);
		    ps.setInt(2, or.getWaresid());
		    ps.setInt(3, or.getShopid());
		    ps.setString(4, or.getBuyerid());
		    ps.setInt(5, or.getWaresnumber());
		    ps.setString(6, or.getFinishtime());
		    ps.setString(7, or.getBuyeraddress());
		    ps.setString(8, or.getBuyerphone());
		    ps.setString(9, or.getResult());
		    ps.execute();
		  
	  }
}
