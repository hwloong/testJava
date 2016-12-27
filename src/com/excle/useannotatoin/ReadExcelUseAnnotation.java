package com.excle.useannotatoin;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcelUseAnnotation {

	private static final String SETTER_PREFIX = "set";

	private static final String GETTER_PREFIX = "get";

	
	/**
	 *  创建工作簿对象
	 *  XSSFWorkbook xssWb 2007
	 *  SXSSFWorkbook 大数据
	 */
	private Workbook wb ;
	
	/**
	 *  创建工作表
	 *  XSSFSheet xssSheet 2007
	 *  SXSSFWorkbook 大数据
	 */
	private Sheet sheet ;
	
	List<Object[]> annotationList = new ArrayList<Object[]>(); 
	
	public ReadExcelUseAnnotation(Workbook wb){
		this.wb = wb;
	}
	
	public <E> List<E> readExcel(InputStream in,int headerNum, int sheetIndex,Class<?> cla){
		try {
			this.sheet = wb.getSheetAt(sheetIndex);
			excelClass(cla);
			int firstDataRow = headerNum + 1;
			List<E> dataList = new ArrayList<E>();
			if(annotationList!= null && annotationList.size() > 0){
				for(int i  = firstDataRow ; i < sheet.getLastRowNum()+headerNum ; i ++){
					E e = (E) cla.newInstance();
					Row row = sheet.getRow(i);
					for(int j = 0 ; j < annotationList.size() ; j++){
						Object[] obj = annotationList.get(j);
						Object val = this.getCellValue(row, j);
						if(val != null && !"".equals(val)){
							Field f = (Field) obj[1];
							Method method = e.getClass().getMethod(SETTER_PREFIX+StringUtils.capitalize(f.getName()),f.getType());
							method.invoke(e, val.toString());
						}
					}
					dataList.add(e);
				}
			}
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void excelClass(Class<?> cla){
		Field[] fields = cla.getDeclaredFields();
		for(Field f : fields){
			ExcelAnnotation ea = f.getAnnotation(ExcelAnnotation.class);
			if(ea != null){
				annotationList.add(new Object[]{ea,f});
			}
		}
		Collections.sort(annotationList, new Comparator<Object[]>() {
			public int compare(Object[] o1, Object[] o2) {
				return new Integer(((ExcelAnnotation)o1[0]).sort()).compareTo(
						new Integer(((ExcelAnnotation)o2[0]).sort()));
			};
		});
	}
	
	/**
	 * 获取单元格值
	 * @param row 获取的行
	 * @param column 获取单元格列号
	 * @return 单元格值
	 */
	public Object getCellValue(Row row, int column){
		Object val = "";
		try{
			Cell cell = row.getCell(column);
			if (cell != null){
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					val = cell.getNumericCellValue();
				}else if (cell.getCellType() == Cell.CELL_TYPE_STRING){
					val = cell.getStringCellValue();
				}else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA){
					val = cell.getCellFormula();
				}else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
					val = cell.getBooleanCellValue();
				}else if (cell.getCellType() == Cell.CELL_TYPE_ERROR){
					val = cell.getErrorCellValue();
				}
			}
		}catch (Exception e) {
			return val;
		}
		return val;
	}
}
