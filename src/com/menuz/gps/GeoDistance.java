package com.menuz.gps;

/**
 * 
 * 此类描述的是：计算经纬度之间的物理距离
 * @author: dmnrei@gmail.com
 * @version: Mar 31, 2013 2:22:51 PM
 */
public class GeoDistance {
	private static double EARTH_RADIUS = 6378137.00;	//地球半径(m)
	private static double rad(double d)
	{
	   return d * Math.PI / 180.0;
	}
	
	/**
	 * 
		 * 此方法描述的是：计算两个GPS之间的实际物理距离
	     * @param lat1
	     * @param lng1
	     * @param lat2
	     * @param lng2
	     * @return
	     * @author: dmnrei@gmail.com
	     * @version: 2013-3-31 下午6:33:06
	 */
	public static double computeCompareDistance(double lat1, double lng1, double lat2, double lng2)
	{
	   double radLat1 = rad(lat1);
	   double radLat2 = rad(lat2);
	   double a = radLat1 - radLat2;
	   double b = rad(lng1) - rad(lng2);
	   
	   double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
			   	Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
	   s = s * EARTH_RADIUS;  
	   s = Math.round(s * 10000) / 10000;
	   return s;
	}
}
