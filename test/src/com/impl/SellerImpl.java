package com.impl;

import com.dao.SellerDao;
import com.vo.Seller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SellerImpl implements SellerDao {
	Connection getConnection() {
	    Connection conn = null;
	    try {
	      conn =new DbConfig().dbConfig();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	    return conn;
	  }
  
  public void insertseller(Seller s) throws SQLException {
    Connection conn = getConnection();
    String sql = "insert into seller(sellername,sellerid,sellerpw,sellerphone) values(?,?,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, s.getSellername());
    ps.setString(2, s.getSellerid());
    ps.setString(3, s.getSellerpw());
    ps.setString(4, s.getSellerphone());
    ps.execute();
  }
  
  public Seller updateseller(Seller s) throws SQLException {
    Connection conn = getConnection();
    String sql = "update seller set sellerphone=? where sellerid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.execute();
    return null;
  }
  
  public void updatesellerpw(Seller s) throws SQLException {
    Connection conn = getConnection();
    String sql = "update seller set sellerpw=? where sellerid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, s.getSellerpw());
    ps.setString(2, s.getSellerid());
    ps.execute();
  }
  
  public Seller sellerlogin(Seller s) throws SQLException {
    Connection conn = getConnection();
    String sql = "select sellerid,sellerpw from seller";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, s.getSellerid());
    ps.setString(2, s.getSellerpw());
    ResultSet rs = ps.executeQuery();
    Seller seller = null;
    if (rs.next()) {
      seller = new Seller();
      seller.setSellername(rs.getString(1));
    } 
    return seller;
  }
  
  public List<Seller> selectsellerpw() throws SQLException {
    String sql = "select * from seller";
    Connection conn = getConnection();
    Statement stat = conn.createStatement();
    ResultSet rs = stat.executeQuery(sql);
    List<Seller> asd = new ArrayList<>();
    Seller seller = null;
    while (rs.next()) {
      seller = new Seller();
      seller.setSellername(rs.getString(1));
      seller.setSellerid(rs.getString(2));
      seller.setSellerpw(rs.getString(3));
      seller.setSellerphone(rs.getString(4));
      seller.setShopid(rs.getInt(5));
      asd.add(seller);
    } 
    rs.close();
    stat.close();
    conn.close();
    return asd;
  }
}
