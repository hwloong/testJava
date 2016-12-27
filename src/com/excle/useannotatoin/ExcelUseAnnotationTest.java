package com.excle.useannotatoin;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;

import com.excle.Person;
import com.makedata.Makedata;

public class ExcelUseAnnotationTest {

	@Test
	public void test(){
		Person p = new Person();
		List<Person> list = Makedata.makeListdata(Person.class,10);
		//XSSFWorkbook wb = new XSSFWorkbook();
		SXSSFWorkbook wb = new SXSSFWorkbook();
		//HSSFWorkbook wb = new HSSFWorkbook();
		WriteExcelUseAnnotation weua = new WriteExcelUseAnnotation(wb,wb.createSheet());
		weua.initExcel(Person.class);
		weua.setTitle("测试");
		weua.setHead();
		weua.setData(list);
		weua.exportExcel();
	}
	
	@Test
	public void test1(){
		FileInputStream in = null;
		try {
			in = new FileInputStream("d://exceltext.xls");
			//XSSFWorkbook wb = new XSSFWorkbook(in);
			HSSFWorkbook wb = new HSSFWorkbook(in);
			ReadExcelUseAnnotation reu = new ReadExcelUseAnnotation(wb);
			List<Person> list =  reu.readExcel(in, 1, 0, Person.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
