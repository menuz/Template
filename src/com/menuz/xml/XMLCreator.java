package com.menuz.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 
 * 此类描述的是： 用于生成publicXMLFeed?command=routeConfig&a=1&r=101
 * @author: dmnrei@gmail.com
 * @version: Oct 22, 2012 9:33:29 PM
 */
public class XMLCreator {
	private Document document;
	private Element body;
	private Element route;
	private Element direction;
	private Element path;
	
	public XMLCreator() {
		document = DocumentHelper.createDocument();
		body = document.addElement("body");
		body.addAttribute("copyright", "All data copyright ZJUT 2011.");
	}
	
	public void addRoute(String tag, String title, String versionId) {
		route = body.addElement("route").addAttribute("tag", tag).addAttribute("title", title).addAttribute("versionId", versionId);
	}
	
	public void addStop(String tag, String title, String shortTitle, String latitude, String longitude, String stopId) {
		route.addElement("stop").addAttribute("tag", tag).addAttribute("title", title)
		.addAttribute("shortTitle", shortTitle).addAttribute("lat", latitude)
		.addAttribute("lon", longitude).addAttribute("stopId", stopId);
	}
	
	public void addDirection(String tag, String title) {
		direction = route.addElement("direction").addAttribute("tag", tag).addAttribute("title", title);
	}
	
	public void addStop(String tag) {
		direction.addElement("stop").addAttribute("tag", tag);
	}
	
	public Document toDocument() {
		return document;
	}
	
	/**
	 * 
		 * 此方法描述的是：xml在web程序中使用，需要注明reponse.setContentType("text/xml");
		 * @author: dmnrei@gmail.com
		 * @version: Mar 31, 2013 3:47:58 PM
	 */
	public static void main(String[] args) {
		XMLCreator creator = new XMLCreator();
		creator.addRoute("1", "校车1号线", "1");
		creator.addStop("起始站", "起始站", "start","30.0", "120.0", "1");
		creator.addStop("终点站", "终点站", "end","30.0", "120.0", "2");
		creator.addDirection("1", "朝晖->本部");
		creator.addStop("1");
		creator.addStop("2");
		String xml = creator.toDocument().asXML();
		System.out.println(xml);
	}
}
