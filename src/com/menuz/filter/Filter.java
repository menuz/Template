package com.menuz.filter;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * 此类描述的是：过滤器
 * @author: dmnrei@gmail.com
 * @version: 2013-3-31 下午6:32:42
 */
public class Filter {
	public Filter() {
		
	}
	
	public static List<String> filter(List<String> agencies) {
		for (Iterator it = agencies.iterator(); it.hasNext();) { 
			String agency =  (String)it.next(); 
            if (agency.equals("2") ||
            		agency.equals("3") ||
            			agency.equals("4") ||
            				agency.equals("5")){ 
                it.remove(); 
            } 
        }
		return agencies;
	}
}
