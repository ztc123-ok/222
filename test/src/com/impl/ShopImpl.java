package com.impl;

import com.dao.ShopDao;
import com.vo.Seller;
import com.vo.Shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopImpl implements ShopDao {
	Connection getConnection() {
	    Connection conn = null;
	    try {
	      conn =new DbConfig().dbConfig();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	    return conn;
	  }
  
  public Shop fullshop(Seller s) throws SQLException {
    Connection conn = getConnection();
    String sql = "select * from shop where sellerid=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, s.getSellerid());
    ResultSet rs = ps.executeQuery();
    Shop shop = null;
    if (rs.next()) {
      shop = new Shop();
      shop.setShopid(rs.getInt(1));
      shop.setSellerid(rs.getString(2));
      shop.setShopname(rs.getString(3));
      shop.setShopcreated(rs.getString(4));
    } 
    return shop;
  }
}
