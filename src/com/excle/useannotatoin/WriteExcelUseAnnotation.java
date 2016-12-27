package com.excle.useannotatoin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;


public class WriteExcelUseAnnotation {

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
	/**
	 * 样式列表
	 */
	private Map<String, CellStyle> styles;
	
	/**
	 * 当前行号
	 */
	private int rowNum = 0;
	
	List<Object[]> annotationList = new ArrayList<Object[]>(); 
	
	public WriteExcelUseAnnotation(Workbook wb,Sheet sheet){
		this.wb = wb;
		this.sheet = sheet;
	}
	
	
	public Row addRow(){
		return sheet.createRow(rowNum++);
	}
	
	public void initExcel(Class<?> cla){
		styles = createStyles(wb);
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
	
	public void setTitle(String title){
		Row row = addRow();
		Cell titleCell = row.createCell(0);
		titleCell.setCellStyle(styles.get("title"));
		titleCell.setCellValue(title);
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(),
				row.getRowNum(), 0, annotationList.size()-1));
	}
	
	public void setHead(){
		Row row =  addRow();
		for(int i = 0 ; i < annotationList.size() ; i ++){
			ExcelAnnotation ea = (ExcelAnnotation)annotationList.get(i)[0];
			Cell cell = row.createCell(i);
			cell.setCellValue(ea.title());
		}
	}
	
	public <E> WriteExcelUseAnnotation setData(List<E> list){
		try {
			for(int i = 0 ; i < list.size() ; i++){
				E e = list.get(i);
				Row row = addRow();
				for(int j = 0 ; j < annotationList.size() ; j++){
					Object[] obj = annotationList.get(j);
					ExcelAnnotation ea = (ExcelAnnotation)obj[0];
					Field f = (Field) obj[1];
					Method method = e.getClass().getMethod(GETTER_PREFIX+StringUtils.capitalize(f.getName()));
					String value = (String) method.invoke(e);
					Cell cell = row.createCell(j);
					cell.setCellValue(value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
	public void exportExcel(){
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
	
	/**
	 * 创建表格样式
	 * @param wb 工作薄对象
	 * @return 样式列表
	 */
	private Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
		
		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		Font titleFont = wb.createFont();
		titleFont.setFontName("Arial");
		titleFont.setFontHeightInPoints((short) 16);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(titleFont);
		styles.put("title", style);

		style = wb.createCellStyle();
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		Font dataFont = wb.createFont();
		dataFont.setFontName("Arial");
		dataFont.setFontHeightInPoints((short) 10);
		style.setFont(dataFont);
		styles.put("data", style);
		
		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_LEFT);
		styles.put("data1", style);

		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_CENTER);
		styles.put("data2", style);

		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		styles.put("data3", style);
		
		style = wb.createCellStyle();
		style.cloneStyleFrom(styles.get("data"));
//		style.setWrapText(true);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Font headerFont = wb.createFont();
		headerFont.setFontName("Arial");
		headerFont.setFontHeightInPoints((short) 10);
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(headerFont);
		styles.put("header", style);
		
		return styles;
	}
			
}
