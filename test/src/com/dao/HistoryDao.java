package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.vo.historyorder;

public interface HistoryDao {
	void insertorder(historyorder or) throws SQLException;
	List<historyorder> selecthistoryorder() throws SQLException;
	List<historyorder> selecthistoryorderwaresid(int waresid) throws SQLException;
}
