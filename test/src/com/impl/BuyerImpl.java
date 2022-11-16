package com.impl;

import com.dao.BuyerDao;
import com.vo.Buyer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuyerImpl implements BuyerDao {
  Connection getConnection() {
    Connection conn = null;
    try {
      conn =new DbConfig().dbConfig();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return conn;
  }
  
  public Buyer insertbuyer(Buyer b) throws SQLException {
    Connection conn = getConnection();
    String sql = "insert into buyer(buyername,buyerid,buyerpw) values(?,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, b.getBuyername());
    ps.setString(2, b.getBuyerid());
    ps.setString(3, b.getBuyerpw());
    ps.execute();
    return null;
  }
  
  public void updatebuyer(Buyer b) throws SQLException {
    Connection conn = getConnection();
    String sql = "update buyer set buyeraddress=?,buyerphone=? where buyerid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, b.getBuyeraddress());
    ps.setString(2, b.getBuyerphone());
    ps.setString(3, b.getBuyerid());
    ps.execute();
  }
}
