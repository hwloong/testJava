package com.excle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class WriteExcel<T> {

	public void writeExcel(String[] headTitle, List<T> dateList) {
		// 创建工作簿对象
		XSSFWorkbook wb = new XSSFWorkbook();
		// 创建工作表
		XSSFSheet sheet = wb.createSheet();
		// 创建行
		XSSFRow row = sheet.createRow(0);
		// 标题
		for (int i = 0; i < headTitle.length; i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(headTitle[i].split(":")[1]);
		}
		// 创建单元格
		/*
		 * XSSFCell cell = row.createCell(0); cell.setCellValue("sss")
		 */;

		Iterator<T> it = dateList.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			T t = (T) it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (short i = 0; i < fields.length; i++) {
				XSSFCell cell = row.createCell(i);
				// Field field = fields[i];
				String fieldName = headTitle[i].split(":")[0];
				String getMethodName = "get"
						+ fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1);
				try {
					Class tClass = t.getClass();
					Method getMethod = tClass.getMethod(getMethodName,
							new Class[] {});
					Object value = getMethod.invoke(t);
					cell.setCellValue(String.valueOf(value));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		FileOutputStream fileoutputstream = null;
		try {
			fileoutputstream = new FileOutputStream("d://exceltext.xlsx");
			wb.write(fileoutputstream);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileoutputstream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Test
	public static void main(String args[]) {
		WriteExcel<Person> we = new WriteExcel<Person>();
		String[] headTitle = new String[] { "name:姓名","age:年龄", "mobile:手机号","address:地址"};
		List<Person> personList = new ArrayList<Person>();
		for (int i = 0; i < 11; i++) {
			Person p = new Person();
			p.setName("TOM" + i);
			p.setAge(20 + i + "");
			p.setMobile("1868888888" + i);
			p.setAddress("北京" + i);
			personList.add(p);
		}
		we.writeExcel(headTitle, personList);
	}
}
