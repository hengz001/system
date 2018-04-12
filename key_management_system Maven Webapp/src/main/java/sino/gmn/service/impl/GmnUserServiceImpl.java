package sino.gmn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sino.gmn.dao.GmnUserMapper;
import sino.gmn.entity.GmnUser;
import sino.gmn.service.GmnUserService;

@Service("GmnUserService")
public class GmnUserServiceImpl implements GmnUserService{

	@Autowired
	private GmnUserMapper gm;
	
	public int insert(GmnUser record) {
		gm.insert(record);
		return 0;
	}

}
