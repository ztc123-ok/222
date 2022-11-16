package com.dao;

import com.vo.Seller;
import com.vo.Shop;
import java.sql.SQLException;

public interface ShopDao {
  Shop fullshop(Seller paramSeller) throws SQLException;
}
