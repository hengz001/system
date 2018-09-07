package sino.gmn.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sino.gmn.entity.DownloadFile;
import sino.gmn.service.DownloadFileService;
import sino.gmn.service.ToolsSevice;

@Service("ToolsSevice")
public class ToolsServiceImpl implements ToolsSevice {
	
	@Autowired
	private DownloadFileService downloadFileService;

	public int operationStream(InputStream in , List<String> key, List<String> value) throws IOException {
		byte[] buff = new byte[4096];
		int len;
		String data;
		StringBuffer sb = new StringBuffer();
		List<String> list = new ArrayList<String>();
		
		while((len=in.read(buff))!=-1) {
			sb.append(new String(buff, 0, len));
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
	
	public int uploadFile(MultipartFile file1){
		int rc = 1;
		String path;
		String time;
		String fileName;
		
		DownloadFile downloadFile = new DownloadFile();
		
		try {
			path = getDownloadPath();
			time = new Date().getTime()+"-";
			fileName = file1.getOriginalFilename();
			path = path+time+fileName;
			File file = new File(path);
			file1.transferTo(file);
			
			//record
			downloadFile.setName(time+fileName);
			downloadFile.setUrl(path);
//			downloadFile.setUser("x");
//			downloadFile.setComments("x");
			downloadFile.setFlag(1);
			downloadFile.setUploadFileDate(new Date());
//			downloadFile.setDownloadFileDate(new Date());
			downloadFileService.addDownloadFile(downloadFile);
		
		} catch (Exception e) {
			rc = 0;
			e.printStackTrace();
		}
		return rc;
	}
	
	public String getDownloadPath(){
		String path;
		path = "/download/";
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdir();
		}
		return path;
	}
	
	public String[] getFiles(){
		String path;
		File file;
		File files[];
		String fileNames[];
		
		path = getDownloadPath();
		file = new File(path);
		files = file.listFiles();
		fileNames = new String[files.length];
		
		for(int i=0; i<files.length; i++){
			fileNames[i] = files[i].getName();
		}
		
		return fileNames;
	}
	
	public int  downloadFileAction(HttpServletResponse  response, String fileName){
		int rc = 0;
		int len = 0;
		long fileLength;
		File file;
		String path;
		byte buf[] = new byte[2048];
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		path= getDownloadPath()+fileName;
		file= new File(path);
		fileLength = file.length();
		
		try {
			fileName = new String(fileName.getBytes("gb2312"), "ISO8859-1");
			
			response.setContentType("application/octet-stream"); 
			response.setHeader("Content-disposition", "attachment; filename="+fileName );
		    response.setHeader("Content-Length", String.valueOf(fileLength));  
		    
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			while((len = in.read(buf,0,buf.length))!=-1){
				out.write(buf,0,len);
				out.flush();
			}
			rc = 1;
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rc;
	}
	
	public int operationHsm(String ip,String port,String inValue, Map<String, Object> map){
		int rc = 0;
		Socket fd;
		byte[] inBuf;
		int inLen;
		byte[] outBuf;
		int outLen;
		
		inBuf = getCmd(inValue);
		inLen = inBuf.length;
		outBuf = new byte[6000];
		outLen = outBuf.length;
		
		if((fd=openSock(ip, port, 6000))==null){
			return rc;
		}
		
		if((rc = outLen = dataInteractive(fd, inBuf, inLen, outBuf, outLen)) <= 0){
			return rc;
		}
		
		byte outBufHex[] = new byte[outLen*2];
		unPackBCD(outBuf, outBufHex, outBufHex.length);
		
		map.put("recv", new String(outBuf,2,outLen-2));
		map.put("recvHex", new String(outBufHex,2,outBufHex.length-2));

		closeSock(fd);
		
		return rc;
	}
	
	public Socket openSock(String ip,String port,int timeout){
		
		int iPort;
		try {
			iPort = Integer.parseInt(port);
		} catch (Exception e) {
			return null;
		}
		
		Socket fd = new Socket();
		InetSocketAddress address = new InetSocketAddress(ip, iPort);
		try {
			fd.connect(address,timeout);
			fd.setSoTimeout(timeout);
		} catch (IOException e) {
			fd = null;
//			e.printStackTrace();
		}
		return fd;
	}
	
	public void closeSock(Socket fd){
		try {
			fd.close();
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
	
	public int dataInteractive(Socket fd,byte[] inBuf, int inLen,byte[] outBuf,int outLen){
		int rc = 0;
		InputStream in;
		OutputStream out;
		
		try {
			in = fd.getInputStream();
			out = fd.getOutputStream();
			
			out.write(inBuf, 0, inLen);
			rc = in.read(outBuf, 0, outLen);
			
			in.close();
			out.close();
		} catch (IOException e) {
			return rc;
//			e.printStackTrace();
		}
		
		
		return rc;
	}
	
	public byte[] getCmd(String data) {
		byte bs[];
		byte bs2[] ;
		short len;
		List<Byte> list = new ArrayList<>();
		
		data = data.replace(" ", "");
		transformationData(data,list);
		bs = new byte[list.size()];
		for(int i=0; i<list.size(); i++) {
			bs[i] = list.get(i);
		}
		
		len = (short)bs.length;
		
		bs2 = new byte[2+len];
		
		bs2[0] = (byte)((len & 0xFF00)>>8);
		
		bs2[1] = (byte)(len & 0x00FF);
		
		for(int i=0; i<len; i++) {
			bs2[2+i] = bs[i];
		}
		return bs2;
	}
	
	public String transformationData(String data,List<Byte> list) {
		int begin,end;
		byte bs[],bs2[];
		String start,center,last;
		
		begin = data.indexOf('<');
		end = data.indexOf('>');
		if(begin!=-1 && end!=-1) {
			start = data.substring(0, begin);
			center = data.substring(begin+1,end);
			last = data.substring(end+1,data.length());
			
			bs = center.getBytes();
			bs2 = new byte[ bs.length/2];
			packBCD(bs, bs2, bs.length);
			
			for(int i=0; i<start.length(); i++) {
				list.add(start.getBytes()[i]);
			}
			
			for(int i=0; i<bs2.length; i++) {
				list.add(bs2[i]);
			}
			data = last;
		}
		
		begin = data.indexOf('<');
		end = data.indexOf('>');
		if(begin!=-1 && end!=-1) {
			data = transformationData(data,list);
		}
		
		for(int i=0; i<data.length(); i++) {
			list.add(data.getBytes()[i]);
		}
		return data;
	}
	
	
	public int unPackBCD(byte inBuf[], byte outBuf[], int len){
		int active = 0;

		for(int i=0; i<len; i++){
			
			if(active == 1) {
				outBuf[i] = (byte) (inBuf[i/2]&0x0F);
			}else {
				outBuf[i] = (byte) ((inBuf[i/2]&0xF0)>>4);
			}
			active ^= 1;
			
			if(outBuf[i]<10 ) {
				outBuf[i] += '0';	
			}else{
				outBuf[i] += ('A'-10);
			}
		}
		return 0;
	}
	
	public int packBCD(byte inBuf[], byte outBuf[], int len)
	{
		byte in, out;
		int active = 0;
		
		for(int i=0; i<len; i++) 
		{
			in = inBuf[i];
			out = outBuf[i/2];
			
			if(in > '9') {
				in += 9;
			}
			
			if(active == 1) {
				outBuf[i/2] = (byte) ((out&0xF0) | (in&0x0F));
			}else {
				outBuf[i/2] = (byte) ((out&0x0F)|((in&0x0F)<<4));
			}
			active ^= 1;
		}
		return 0;
	}
}
