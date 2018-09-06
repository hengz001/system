package sino.gmn.service;

import java.util.List;

import sino.gmn.entity.DownloadFile;

public interface DownloadFileService {
	
	public int addDownloadFile(DownloadFile downloadFile);
	
	public int deleteDownloadFile(int id);
	
	public int updateDownloadFile(DownloadFile downloadFile);
	
	public DownloadFile searchDownloadFile(int id);
	
	public int countParamOrder(String name, String value);
	
	public List<DownloadFile> searchPageParamOrder(int page, int rows, String name, String value, String sort, String order);
}
