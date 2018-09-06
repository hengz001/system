package sino.gmn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sino.gmn.entity.Cmd;

public interface CmdMapper {

	public int cmdAdd(Cmd cmd);
	
	public int cmdDelete(int id);
	
	public int cmdDeleteArray(int[] array);
	
	public int cmdUpdate(Cmd cmd);
	
	public int cmdUpdateAll(int flag);
	
	public Cmd cmdSearch(int id);
	
	public int cmdDeleteReal(int id);
	
	public List<Cmd> cmdSearchAll();
	
	public int cmdCountParamOrder(@Param("param1")String name, @Param("param2")String value);

	public List<Cmd> cmdSearchPageParamOrder(@Param("page")int page, @Param("rows")int rows,@Param("param1")String name, @Param("param2")String value,@Param("sort")String sort,@Param("order")String order);
}