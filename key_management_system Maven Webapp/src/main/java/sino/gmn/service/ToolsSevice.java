package sino.gmn.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface ToolsSevice {

	public int operationStream(InputStream in , List<String> key, List<String> value) throws IOException ;
	
	public String operationData(List<String> list,String data);
	
	public int replaceData(String data, List<String> key, List<String> value);
	
	public int copyFile(String fileName1,String fileName2) throws IOException;
	
	public int showFile(String fileName1,PrintStream out) throws IOException;
	
	public int hexDumpBuffer(PrintStream out,byte[] bs, int len, int lineLen ) throws UnsupportedEncodingException;
	
	public int hexDumpOneLine(byte[] bs, int len, int lineLen, int line) throws UnsupportedEncodingException;

	public int uploadFile(HttpServletRequest request,MultipartFile file1);
	
	public String getDownloadPath(HttpServletRequest request);
	
	public String[] getFiles(HttpServletRequest request);
	
	public int  downloadFileAction(HttpServletRequest request, HttpServletResponse  response, String fileName);

	public int operationHsm(String ip,String port,String inValue, Map<String, Object> map);
	
	public int unPackBCD(byte inBuf[], byte outBuf[], int len);
	
	public int packBCD(byte inBuf[], byte outBuf[], int len);
}
