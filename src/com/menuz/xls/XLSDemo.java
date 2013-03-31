package com.menuz.xls;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 
 * 此类描述的是：XLS操作例子
 * @author: dmnrei@gmail.com
 * @version: 2013-3-31 下午6:39:31
 */
public class XLSDemo {
	public void input() {
		
	}
	
	public void output() {
		String sourcefile = "D:\\test.xls";
		OutputStream os = null;
		Workbook rwb = null;
		try {
			os = new FileOutputStream(sourcefile);
			WritableWorkbook wb = Workbook.createWorkbook(os);
			
			int number = wb.getNumberOfSheets();
			WritableSheet ws = wb.createSheet("mysheet", number + 1);
			
			// 产生标题
			ws.addCell(new Label(0, 0, "id"));
			ws.addCell(new Label(1, 0, "routeId"));
			ws.addCell(new Label(2, 0, "directionId"));
			ws.addCell(new Label(3, 0, "timeOfDay"));
			ws.addCell(new Label(4, 0, "dayOfWeek"));
			ws.addCell(new Label(5, 0, "stopId"));
			ws.addCell(new Label(6, 0, "time"));
			ws.addCell(new Label(7, 0, "ct"));
			
			// 第一行内容
			ws.addCell(new Label(0, 1, "1"));
			ws.addCell(new Label(1, 1, "1"));
			ws.addCell(new Label(2, 1, "1"));
			ws.addCell(new Label(3, 1, "1"));
			ws.addCell(new Label(4, 1, "1"));
			ws.addCell(new Label(5, 1, "1"));
			ws.addCell(new Label(6, 1, "1"));
			ws.addCell(new Label(7, 1, "1"));
			
			wb.write();
			wb.close();
			os.flush();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (os != null) {
					os.close();
					os = null;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new XLSDemo().output();
	}
}
