package com.util;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Bus;
import com.model.Cache;
import com.model.Direction;
import com.model.GPS;
import com.model.Instruction;
import com.model.Route;
import com.model.Stop;
import com.model.TimeAtStop;
import com.model.TimeBetweenStop;
import com.util.track.model.PredictedStop;
import com.util.track.model.Request;

/**
 * 
 * 此类描述的是：提取公共部分
 * @author: dmnrei@gmail.com
 * @version: Nov 12, 2012 6:49:09 PM
 */
public class TableLoader {
	
	public static Instruction loadInstruction(java.sql.ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
        String content = rs.getString("content");
        int routeId = rs.getInt("busId");
        Timestamp ct = rs.getTimestamp("createTime");
        
        Instruction instruction = new Instruction(id, content, routeId, ct);
        return instruction;
	}
	
}
