package sino.gmn.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ToolsSevice {

	public int operationStream(InputStream in , List<String> key, List<String> value) throws IOException ;
	
	public String operationData(List<String> list,String data);
	
	public int replaceData(String data, List<String> key, List<String> value);
	
	public int copyFile(String fileName1,String fileName2) throws IOException;
	
	public int showFile(String fileName1,PrintStream out) throws IOException;
	
	public int hexDumpBuffer(PrintStream out,byte[] bs, int len, int lineLen ) throws UnsupportedEncodingException;
	
	public int hexDumpOneLine(byte[] bs, int len, int lineLen, int line) throws UnsupportedEncodingException;
}
