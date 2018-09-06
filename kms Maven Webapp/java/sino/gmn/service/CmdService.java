package sino.gmn.service;

import java.util.List;
import sino.gmn.entity.Cmd;

public interface CmdService {
	
	public int cmdAdd(Cmd cmd);
	
	public int cmdDelete(int id);
	
	public int cmdDeleteArray(int[] array);
	
	public int cmdUpdate(Cmd cmd);
	
	public int cmdUpdateAll(int flag);
	
	public Cmd cmdSearch(int id);
	
	public int cmdDeleteReal(int id);
	
	public List<Cmd> cmdSearchAll();
	
	public int cmdCountParamOrder(String name, String value);

	public List<Cmd> cmdSearchPageParamOrder(int page, int rows, String name, String value, String sort, String order);
}
