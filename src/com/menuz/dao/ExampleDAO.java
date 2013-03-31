package com.menuz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExampleDAO extends JdbcDAO {
	/**
 	 * 
 		 * 此方法描述的是： 往bus_instant_info添加一条即时记录
 		 * @param 
 	     * @return void 
 		 * @version: Oct 17, 2012 6:59:53 PM
 		 * @author: dmnrei@gmail.com
 	 */
	public void insertInstantData(double lat, double lon, int bus_id, int route_id,
			int direction_id, int sf, int st, double time)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into bus_instant_info (bus_id, latitude, longitude, speedKmHr, heading, stopFrom, stopTo, time, directionId, uploadTime, collector_type) values(?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bus_id);
			pstmt.setDouble(2, lat);
			pstmt.setDouble(3, lon);
			pstmt.setDouble(4, 0.0);
			pstmt.setDouble(5, 0.0);
			pstmt.setInt(6, sf);
			pstmt.setInt(7, st);
			pstmt.setDouble(8, time);
			pstmt.setInt(9, direction_id);
			pstmt.setLong(10, new Date().getTime());
			// 北斗
			pstmt.setInt(11, 1);
			pstmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			releaseSource(conn, pstmt, null);
		}
	}
	
	
	 
    /**
     * 
    	 * 此方法描述的是：抓取route表到内存
    	 * @author: dmnrei@gmail.com
    	 * @version: Nov 12, 2012 6:40:10 PM
     */
    public Map<Integer, String> queryAllString() {
    	Map<Integer,String> routeMap = new HashMap<Integer, String>();
        String sql = "select * from route";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
        	conn = getConn();
        	stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String route = rs.getString("route");
                routeMap.put(id, route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	releaseSource(conn, stmt, rs);
        }
        return routeMap;
    }
}
