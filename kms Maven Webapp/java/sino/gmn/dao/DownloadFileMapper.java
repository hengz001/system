package sino.gmn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import sino.gmn.entity.DownloadFile;

public interface DownloadFileMapper {
	
	public int addDownloadFile(DownloadFile downloadFile);
	
	public int deleteDownloadFile(int id);
	
	public int updateDownloadFile(DownloadFile downloadFile);
	
	public DownloadFile searchDownloadFile(int id);

	public int countParamOrder(@Param("param1")String name, @Param("param2")String value);
	
	public List<DownloadFile> searchPageParamOrder(@Param("page")int page, @Param("rows")int rows,@Param("param1")String name, @Param("param2")String value,@Param("sort")String sort,@Param("order")String order);
	
}
