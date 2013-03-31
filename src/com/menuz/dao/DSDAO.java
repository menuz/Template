package com.menuz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * 此类描述的是：使用DataSource连接数据库的基类
 * @author: dmnrei@gmail.com
 * @version: 2013-3-31 下午6:29:55
 */
public class DSDAO extends DAO{
	protected static InitialContext context = null;
	protected DataSource dataSource = null;

	/**
	 * 
	 */
	public DSDAO() {
		try {
            if(context == null) {
                context = new InitialContext();
            }
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/testDS");
        } catch (NamingException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * 
	 */
	public Connection getConn() {
		Connection conn = null;
		try {
			conn =  dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}