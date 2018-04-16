package sino.gmn.service;

import java.util.List;

import sino.gmn.entity.PageUtil;
import sino.gmn.entity.Sjl22ApiCommand;

public interface Sjl22ApiCommandService {
	
	public int add(Sjl22ApiCommand obj);
	
	public Sjl22ApiCommand selectSj(int id);

	public List<Sjl22ApiCommand> selectAllSj();
	
    public int getCount();
    
    public int getCountParam(String paramType,String param);
    
    public PageUtil getPage(int pageSize,int currpageNum);
    
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
    public List<Sjl22ApiCommand> selectSjRecord(int currpageNum,int pageSize);
    
    public List<Sjl22ApiCommand> selectSjRecordParam(int currpageNum,int pageSize,String paramType,String param);
}
