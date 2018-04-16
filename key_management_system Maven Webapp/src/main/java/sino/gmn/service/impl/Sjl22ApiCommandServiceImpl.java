package sino.gmn.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sino.gmn.dao.Sjl22ApiCommandMapper;
import sino.gmn.entity.PageUtil;
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

	public int getCount() {
		return sjl22Dao.getCount();
	}
	
	public int getCountParam(String paramType,String param){
		Map<String, Object> map = new HashMap<String, Object>();
		if(null != paramType && null != param){
			map.put(paramType, param);
		}
		return sjl22Dao.getCountParam(map);
	}

	
	/*
	private int totalCount;//总数
    private int pageSize=10;//每页显示数量
    private int currpageNum;//当前页
    private int pageCount;//总页数
    private int prePage;//上一页
    private int nextPage;//下一页
    private boolean hasPrePage;//是否有上一页
    private boolean hasNextPage;//是否有下一页
    private int firstPage;//第一页
    private int lastPage;//最后一页
    private int currentcount;//当前从第多少条数据开始显示
	*/
	
	public PageUtil getPage(int pageSize,int currpageNum) {
		PageUtil page = new PageUtil();
		
		page.setCurrpageNum(currpageNum);
		page.setPageSize(pageSize);
		page.setTotalCount(getCount());
		return page;
	}

	public List<Sjl22ApiCommand> selectSjRecord(int currpageNum,int pageSize) {
		return sjl22Dao.selectSjRecord((currpageNum-1)*pageSize, pageSize);
	}
	
	public List<Sjl22ApiCommand> selectSjRecordParam(int currpageNum,int pageSize,String paramType,String param) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(paramType, param);
		map.put("first", (currpageNum-1)*pageSize);
		map.put("last", pageSize);
		return sjl22Dao.selectSjRecordParam(map);
	}
	
}



