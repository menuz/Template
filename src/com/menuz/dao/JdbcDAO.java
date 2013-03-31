 package com.menuz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * 此类描述的是：使用JDBC连接数据库的基类
 * @author: dmnrei@gmail.com
 * @version: 2013-3-31 下午6:32:19
 */
public class JdbcDAO extends DAO{	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/restbus";
	private static String user = "root";
	private static String password = "gpsserver!@#$%";

	/**
	 * 
	 */
	public JdbcDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	/**
	 * 
	 */
	public Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			if (conn!= null && !conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}