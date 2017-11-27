package com.freemarktest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkTest {
	
	

	public static void main(String[] args) {
		createPDF();

	}
	
	public void createWordTxt(){
		Configuration configuration = getConfiguration();
        try {  
        	 Template template = configuration.getTemplate("11.ftl");
        	 File outFile = new File("d://test.txt");
             
             //如果输出目标文件夹不存在，则创建
             /*if (!outFile.getParentFile().exists()){
                 outFile.getParentFile().mkdirs();
             }*/
             //将模板和数据模型合并生成文件 
             Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));

             Map dataMap = new HashMap();
             //生成文件
             template.process(dataMap, out);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	
	public static void createPDF(){
		try {
			String outFilePath = "D:/NewFile.html";
			Configuration configuration = getConfiguration();
			Template tp = configuration.getTemplate("11.ftl");
	    	File outFile = new File(outFilePath);
        	Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
	        Map dataMap = new HashMap();
	        tp.process(null, out);
	        
	        OutputStream os = new FileOutputStream("d://test.pdf"); 
	        String url=new File(outFilePath).toURI().toURL().toString();  
	        ITextRenderer renderer = new ITextRenderer();   
	        renderer.setDocument(url);  
	        ITextFontResolver fontResolver = renderer.getFontResolver();     
	         
	        //fontResolver.addFont("C:/WINDOWS/Fonts/SimSun.ttc",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);  
	    
	  
	        renderer.layout();  
	          
	          
	        renderer.createPDF(os);  
	        
	        
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Configuration getConfiguration(){
		Configuration configuration = new Configuration();  
        configuration.setDefaultEncoding("utf-8");  
        configuration.setClassForTemplateLoading(FreemarkTest.class, "/com/template");  
        return configuration;
	}
}
