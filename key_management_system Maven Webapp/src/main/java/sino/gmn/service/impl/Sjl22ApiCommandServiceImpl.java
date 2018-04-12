package sino.gmn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sino.gmn.dao.Sjl22ApiCommandMapper;
import sino.gmn.entity.Sjl22ApiCommand;
import sino.gmn.service.Sjl22ApiCommandService;

@Service("Sjl22ApiCommandService")
public class Sjl22ApiCommandServiceImpl implements Sjl22ApiCommandService {

	@Autowired
	Sjl22ApiCommandMapper sjl22Dao;
	
	public int add(Sjl22ApiCommand obj){
		if(null==obj || null==obj.getsRequest() || 2>obj.getsRequest().length()){
			return -1;
		}
		if(null==obj.getsUpdateUser() || "".equals(obj.getsUpdateUser())){
			obj.setsUpdateUser("X");
		}
		obj.setsCommand(obj.getsRequest().substring(0,2));
		obj.setsUpdateTime(new Date());
		obj.setsStatus(1);
		sjl22Dao.insert(obj);
		return 0;
	}

	public Sjl22ApiCommand selectSj(int id) {
		return sjl22Dao.selectSj(id);
	}

	public List<Sjl22ApiCommand> selectAllSj() {
		return sjl22Dao.selectAllSj();
	}
}
