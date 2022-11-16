package com.dao;

import com.vo.Wares;
import java.sql.SQLException;
import java.util.List;

public interface WaresDao {
  String insertwares(Wares paramWares) throws SQLException;
  
  List<Wares> selectwares() throws SQLException;
  
  void updatezt(Wares paramWares) throws SQLException;
  
  Wares getperwares(Wares paramWares) throws SQLException;
}
