package cn.qblank.exportResume;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExportResumeTest {
	/** 
	 * Html到Word 
	 * @throws Exception 
	 */  
	@org.junit.Test  
	public void htmlToWord() throws Exception {  
	   URL url = new URL("http://localhost:8080/Recruit/resume_resumePre.action");  
	   InputStream is = url.openStream();  
	   OutputStream os = new FileOutputStream("d:\\resume.doc");  
	   this.inputStreamToWord(is, os);  
	}  
	  
	/** 
	 * 把is写入到对应的word输出流os中 
	 * 不考虑异常的捕获，直接抛出 
	 * @param is 
	 * @param os 
	 * @throws IOException 
	 */  
	private void inputStreamToWord(InputStream is, OutputStream os) throws IOException {  
	   POIFSFileSystem fs = new POIFSFileSystem();  
	   //对应于org.apache.poi.hdf.extractor.WordDocument  
	   fs.createDocument(is, "WordDocument");  
	   fs.writeFilesystem(os);  
	   os.close();  
	   is.close();  
	}  
}
