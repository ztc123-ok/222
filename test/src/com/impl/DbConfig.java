package com.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConfig {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	  
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	  
	public static final String USER = "root";
	  
	public static final String PWD = "root";
	
	public Connection dbConfig() throws SQLException{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL, USER, PWD);
	}
}
