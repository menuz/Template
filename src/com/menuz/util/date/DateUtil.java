package com.menuz.util.date;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 此类描述的是：
 * @author: dmnrei@gmail.com
 * @version: Mar 31, 2013 3:06:46 PM
 */
public class DateUtil {	
	static SimpleDateFormat df_datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat df_date = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat df_time = new SimpleDateFormat("HH:mm:ss");
	
	/**
	 * 
		 * 此方法描述的是：
		 * @author: dmnrei@gmail.com
		 * @version: Mar 31, 2013 10:29:40 AM
	 */
	public static String getDatetime() {
		return  df_datetime.format(new Date());
	}
	
	public static String getDatetimeWithPattern(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	
	public static String getDate() {
		return df_date.format(new Date());
	}
	
	public static String getDateWithPattern(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	
	public static String getTime() {
		return df_date.format(new Date());
	}
	
	public static String getTimeWithPattern(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	
	/**
	 * 
		 * 此方法描述的是：得到前一天的日期
		 * @author: dmnrei@gmail.com
		 * @version: Dec 5, 2012 12:53:17 PM
	 */
	public static String getDateWithDayInterval(String pattern, int day) {
		Calendar c =  Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, day);
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		return sf.format(c.getTime());
	}
	
	public static int getDayOfWeek() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}
	
	public static int getTimeOfDay() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getHour(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getMinute(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.MINUTE);
	}
	
	public static int getSecond(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.SECOND);
	}
	
	public static String timestampToString(Timestamp t) {
		return df_datetime.format(t);
	}
	
	public static Timestamp stringToTimestamp(String str) {
		return Timestamp.valueOf(str);
	}
	
	/**
	 * 
		 * 此方法描述的是：高度定制,seconds默认为0,往前推或者往后推迟。
		 * @author: dmnrei@gmail.com
		 * @version: Mar 31, 2013 10:52:20 AM
	 */
	public static String timestampToString(Timestamp t, int seconds, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date d = new Date(t.getTime() + seconds * 1000);
		return df.format(d);
	}
}
