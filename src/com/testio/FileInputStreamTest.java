package com.testio;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStreamTest f = new FileInputStreamTest();
		//f.fileInputStreamTest();
		//f.readerTest();
		f.dataInputstreamTest();
	}
	
	public void fileInputStreamTest(){
		FileInputStream in = null;
		FileOutputStream os = null;
		try {
			in = new FileInputStream("e:/test.txt");
			os = new FileOutputStream("e:/test1.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int b = 0;
		try {
			while((b = in.read())!= -1){
				System.out.print((char)b);
				os.write(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void readerTest(){
		FileReader f = null;
		
		try {
			f = new FileReader("e:/test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int b  = 0;
		try {
			while((b = f.read()) != -1){
				System.out.print((char)b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void dataInputstreamTest(){
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("e:/test.txt");
			DataInputStream dis = new DataInputStream(fi);
			String s = "";
			while((s = dis.readLine()) != null){
				System.out.println(s);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
