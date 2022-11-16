package com.dao;

import com.vo.Seller;
import java.sql.SQLException;
import java.util.List;

public interface SellerDao {
  void insertseller(Seller paramSeller) throws SQLException;
  
  Seller updateseller(Seller paramSeller) throws SQLException;
  
  void updatesellerpw(Seller paramSeller) throws SQLException;
  
  Seller sellerlogin(Seller paramSeller) throws SQLException;
  
  List<Seller> selectsellerpw() throws SQLException;
}
