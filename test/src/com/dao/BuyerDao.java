package com.dao;

import com.vo.Buyer;
import java.sql.SQLException;

public interface BuyerDao {
  Buyer insertbuyer(Buyer paramBuyer) throws SQLException;
  
  void updatebuyer(Buyer paramBuyer) throws SQLException;
}
