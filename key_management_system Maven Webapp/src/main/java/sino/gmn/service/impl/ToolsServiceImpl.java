package sino.gmn.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import sino.gmn.service.ToolsSevice;

@Service("ToolsSevice")
public class ToolsServiceImpl implements ToolsSevice {

	public int operationStream(InputStream in , List<String> key, List<String> value) throws IOException {
		byte[] buff = new byte[4096];
		int len;
		String data;
		StringBuffer sb = new StringBuffer();
		List<String> list = new ArrayList<String>();
		
		while((len=in.read(buff))!=-1) {
			for (int i=0; i<len; i++) {
				sb.append((char)buff[i]);
			}
		}
		in.close();
		
		data = sb.toString();
		data = data.replace("\n", "");
		data = data.replace("\r", "");
		data = data.replace("\t", "");
		data = data.replace(" ", "");
		
		data = operationData(list, data);
		for(int i=0; i<list.size(); i++) {
			replaceData(list.get(i),key,value);
		}
		
		return 0;
	}
	
	public String operationData(List<String> list,String data) {
		int first;
		int last;
		
		first= data.indexOf("[");
		last= data.indexOf("]");
		
		if(last<first) {
			return null;
		}
		if(first == -1 || last == -1) {
			return data;
		}
		list.add(data.substring(first,last+1));
		data = data.substring(last+1);
		data = operationData(list, data);
		return data;
	}
	
	public int replaceData(String data, List<String> key, List<String> value) {
		int index;
		
		index = data.indexOf("|");
		if(index == -1) {
			return index;
		}
		key.add(data.substring(1,index));
		value.add(data.substring(index+1,data.length()-1));
		return 0;
	}
	
	public int copyFile(String fileName1,String fileName2) throws IOException {
		File file1;
		File file2;
		FileInputStream in;
		FileOutputStream out;
		byte[] buff = new byte[4096];
		int len;
		
		
		file1 = new File(fileName1);
		file2 = new File(fileName2);
		
		if(!file1.exists()) {
			file1.createNewFile();
		}
		if(!file2.exists()){
			file2.createNewFile();
		}
		
		in = new FileInputStream(file1);
		out = new FileOutputStream(file2);
		
		while((len=in.read(buff))!=-1) {
			out.write(buff, 0, len);
			out.flush();
		}
		
		in.close();
		out.close();
		return 0;
	}
	
	public int showFile(String fileName1,PrintStream out) throws IOException {
		File file1;
		FileInputStream in;
		byte[] buff = new byte[4096];
		int len;
		
		
		file1 = new File(fileName1);
		
		if(!file1.exists()) {
			file1.createNewFile();
		}
		in = new FileInputStream(file1);
		
		while((len=in.read(buff))!=-1) {
			hexDumpBuffer(out, buff, len, 16);
		}
		
		in.close();
		return 0;
	}
	
	public int hexDumpBuffer(PrintStream out,byte[] bs, int len, int lineLen ) throws UnsupportedEncodingException {
		int line;
		
		System.setOut(out);
		line = len/lineLen+(len%lineLen==0?0:1);
		
		for(int i=0; i<line; i++) {
			hexDumpOneLine(bs, len, lineLen, i);
		}
		return 0;
	}
	
	public int hexDumpOneLine(byte[] bs, int len, int lineLen, int line) throws UnsupportedEncodingException {
		
		System.out.printf("%06x [ ",line);
		for(int i=0; i<lineLen; i++) {
			if(len > (line*lineLen)+i) {
				System.out.printf("%02X ",bs[(line*lineLen)+i]);
			}else{
				System.out.print("   ");
			}
		}
		System.out.print("][ ");
		
		for(int i=0; i<lineLen; i++) {
			if(len > (line*lineLen)+i) {
				if(bs[(line*lineLen)+i]<32 || bs[(line*lineLen)+i]>127) {
					System.out.print('.');
				}else {
					System.out.printf("%c",bs[(line*lineLen)+i]);
				}
			}else{
				System.out.print(' ');
			}
		}
		System.out.println(" ]");
		return 0;
	}
}
