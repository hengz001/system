package sino.gmn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sino.gmn.dao.CmdMapper;
import sino.gmn.entity.Cmd;
import sino.gmn.service.CmdService;

@Service("cmdService")
public class CmdServiceImpl implements CmdService{
	
	@Autowired
	private CmdMapper cmdDao;

	public int cmdAdd(Cmd cmd) {
		cmd.setDatetime(new Date());
		cmd.setFlag(1);
		return cmdDao.cmdAdd(cmd);
	}

	public int cmdDelete(int id) {
		return cmdDao.cmdDelete(id);
	}
	public int cmdDeleteArray(int[] array) {
		return cmdDao.cmdDeleteArray(array);
	}

	public int cmdUpdate(Cmd cmd) {
		cmd.setDatetime(new Date());
		cmd.setFlag(1);
		return cmdDao.cmdUpdate(cmd);
	}

	public int cmdUpdateAll(int flag){
		return cmdDao.cmdUpdateAll(flag);
	}
	
	public Cmd cmdSearch(int id) {
		return cmdDao.cmdSearch(id);
	}

	public int cmdDeleteReal(int id) {
		return cmdDao.cmdDeleteReal(id);
	}
	
	public List<Cmd> cmdSearchAll(){
		return cmdDao.cmdSearchAll();
	}
	
	public int cmdCountParamOrder(String name, String value){
		return cmdDao.cmdCountParamOrder(verifyParam(name), value);
	}

	public List<Cmd> cmdSearchPageParamOrder(int page, int rows, String name, String value, String sort, String order){
		return cmdDao.cmdSearchPageParamOrder((page-1)*rows, rows, verifyParam(name), value, verifyParam(sort), order);
	}
	
	public String verifyParam(String param1){
		if("id".equals(param1)){
			return param1;
		}
		if("command".equals(param1)){
			return param1;
		}
		if("request".equals(param1)){
			return param1;
		}
		if("response".equals(param1)){
			return param1;
		}
		if("user".equals(param1)){
			return param1;
		}
		if("note".equals(param1)){
			return param1;
		}
		if("flag".equals(param1)){
			return param1;
		}
		if("datetime".equals(param1)){
			return param1;
		}
		return null;
	}
}
