package com.menuz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * 此类描述的是：super super base DAO
 * @author: dmnrei@gmail.com
 * @version: 2013-3-31 下午4:47:34
 */
public class DAO{	

	public DAO() {
		
	}
	
	/**
	 * 
		 * 此方法描述的是：Get SQL Connection
		 * @author: dmnrei@gmail.com
		 * @version: 2013-3-31 下午4:48:01
	 */
	public Connection getConn() {
		return null;
	}

	/**
	 * 
		 * 此方法描述的是：
		 * @author: dmnrei@gmail.com
		 * @version: 2013-3-31 下午4:48:47
	 */
	public void releaseSource(Connection conn, Statement stmt, ResultSet rs) {
	    try {
	    	if(rs != null) {
	    		rs.close();
	    		rs = null;
	    	}
	    	if (conn != null) {
				conn.close();
				conn = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}