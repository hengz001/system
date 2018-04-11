package sino.gmn.service.impl;

import java.util.Date;

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
		obj.setsCommand(obj.getsRequest().substring(0,2));
		obj.setsUpdateTime(new Date());
		obj.setsStatus(1);
		System.out.println(obj.toString());
		sjl22Dao.insert(obj);
		return 0;
	}
}
