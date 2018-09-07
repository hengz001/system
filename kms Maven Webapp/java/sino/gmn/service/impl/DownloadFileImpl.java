package sino.gmn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sino.gmn.dao.DownloadFileMapper;
import sino.gmn.entity.DownloadFile;
import sino.gmn.service.DownloadFileService;

@Service("downloadFileService")
public class DownloadFileImpl implements DownloadFileService {

	@Autowired
	private DownloadFileMapper downloadFileDao;
	
	public int addDownloadFile(DownloadFile downloadFile) {
		return downloadFileDao.addDownloadFile(downloadFile);
	}

	public int deleteDownloadFile(int id) {
		return downloadFileDao.deleteDownloadFile(id);
	}

	public int updateDownloadFile(DownloadFile downloadFile) {
		return downloadFileDao.updateDownloadFile(downloadFile);
	}

	public DownloadFile searchDownloadFile(int id) {
		return downloadFileDao.searchDownloadFile(id);
	}
	
	public int countParamOrder(String name, String value){
		return downloadFileDao.countParamOrder(name, value);
	}

	public List<DownloadFile> searchPageParamOrder(int page, int rows, String name, String value, String sort, String order){
		if(null!=sort){
			if(sort.equals("uploadFileDate")){
				sort = "upload_file_date";
			}
			if(sort.equals("downloadFileDate")){
				sort = "download_file_date";
			}
		}
		return downloadFileDao.searchPageParamOrder((page-1)*rows, page*rows, name, value, sort, order);
	}
}
