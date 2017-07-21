import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;


public class TestFinereport {

	
	public static void main(String[] args) throws Exception {
		String url = "http://10.167.210.185:9080/WebReport/ReportServer?reportlet=DOC%2F01HTL%2FJKHT%2F1.0NXD%2FXYZXJGLFWXY.cpt&format=pdf";
		URL pUrl28 = new URL(url);
		URLConnection pdfUrlcon28 = pUrl28.openConnection();
		pdfUrlcon28.connect();
		inputStreamToFileInputStream(pdfUrlcon28.getInputStream());
	}
	
	
	private static HashMap<String, Object> inputStreamToFileInputStream(InputStream is)
			throws IOException {
		File tmpfile = new File("D://tmp.pdf");
		OutputStream os = null;
		try {
			os = new FileOutputStream(tmpfile);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			os.close();
			is.close();
		}
		FileInputStream fileInputStream = new FileInputStream(tmpfile);
		
		HashMap<String, Object> result  = new HashMap<String, Object>();
		result.put("fileInputStream", fileInputStream);
		result.put("tmpfile",tmpfile);
		return result;
	}
}
