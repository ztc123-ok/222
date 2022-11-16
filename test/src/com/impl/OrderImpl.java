package com.impl;

import com.dao.OrderDao;
import com.vo.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements OrderDao {
	Connection getConnection() {
	    Connection conn = null;
	    try {
	      conn =new DbConfig().dbConfig();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	    return conn;
	  }
  
  public void insertorder(Order o) throws SQLException {
    Connection conn = getConnection();
    String sql = "insert into orderr(waresid,shopid,buyerid,waresnumber,ordertime,buyeraddress,buyerphone,orderstate) values(?,?,?,?,?,?,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, o.getWaresid());
    ps.setInt(2, o.getShopid());
    ps.setString(3, o.getBuyerid());
    ps.setInt(4, o.getWaresnumber());
    ps.setString(5, o.getOrdertime());
    ps.setString(6, o.getBuyeraddress());
    ps.setString(7, o.getBuyerphone());
    ps.setString(8, o.getOrderstate());
    ps.execute();
  }
  
  public List<Order> selectorder() throws SQLException {
    Connection conn = getConnection();
    String sql = "select * from orderr";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    List<Order> asd = new ArrayList<>();
    Order order = null;
    while (rs.next()) {
      order = new Order();
      order.setOrderid(rs.getInt(1));
      order.setWaresid(rs.getInt(2));
      order.setShopid(rs.getInt(3));
      order.setBuyerid(rs.getString(4));
      order.setWaresnumber(rs.getInt(5));
      order.setOrdertime(rs.getString(6));
      order.setBuyeraddress(rs.getString(7));
      order.setBuyerphone(rs.getString(8));
      order.setOrderstate(rs.getString(9));;
      asd.add(order);
    } 
    rs.close();
    ps.close();
    conn.close();
    return asd;
  }

@Override
public Order fullorder(Order order) throws SQLException {
	Connection conn = getConnection();
    String sql = "select * from orderr where orderid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, order.getOrderid());
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
    	order.setOrderid(rs.getInt(1));
        order.setWaresid(rs.getInt(2));
        order.setShopid(rs.getInt(3));
        order.setBuyerid(rs.getString(4));
        order.setWaresnumber(rs.getInt(5));
        order.setOrdertime(rs.getString(6));
        order.setBuyeraddress(rs.getString(7));
        order.setBuyerphone(rs.getString(8));
        order.setOrderstate(rs.getString(9));
    } 
    return order;
}
public void updatezt(Order o) throws SQLException {
    Connection conn = getConnection();
    String sql = "update orderr set orderstate=? where orderid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(2, o.getOrderid());
    ps.setString(1, o.getOrderstate());
    ps.execute();
  }
public void updatezt_all(Order o) throws SQLException {
    Connection conn = getConnection();
    String sql = "update orderr set orderstate=? where waresid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(2, o.getWaresid());
    ps.setString(1, o.getOrderstate());
    ps.execute();
  }
}
