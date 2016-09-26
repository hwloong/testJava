package com.excle;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ReadeExcel<T> {

	public List<T> readeExcel(String[] headTitle, FileInputStream in,
			Class class_) {
		List list = new ArrayList();
		try {
			// 创建工作簿对象
			XSSFWorkbook wb = new XSSFWorkbook(in);
			// 创建工作表
			XSSFSheet sheet = wb.getSheetAt(0);
			// 总行数
			int rowEnd = sheet.getLastRowNum();
			for (int i = 0; i < rowEnd; i++) {
				// 行
				XSSFRow row = sheet.getRow(i);
				// 单元格
				Object obj = class_.newInstance();
				for (int j = 0; j < headTitle.length; j++) {
					XSSFCell cell = row.getCell(j);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String callvalue = cell.getStringCellValue();
					String fieldName = headTitle[j];
					String getMethodName = "set"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					Method getMethod = class_.getMethod(getMethodName,
							String.class);
					getMethod.invoke(obj, callvalue);
				}
				list.add((T) obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list.toString());
		return list;
	}

	@Test
	public static void main(String args[]) {
		ReadeExcel<Person> re = new ReadeExcel<Person>();
		String[] headTitle = new String[] { "name", "age", "mobile" };
		FileInputStream in = null;
		try {
			in = new FileInputStream("d:/exceltext.xlsx");
			List<Person> personList = re
					.readeExcel(headTitle, in, Person.class);
			System.out.println(personList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
