package sino.gmn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import sino.gmn.entity.Sjl22ApiCommand;
import sino.gmn.entity.Sjl22ApiCommandExample;

public interface Sjl22ApiCommandMapper {
    long countByExample(Sjl22ApiCommandExample example);

    int deleteByExample(Sjl22ApiCommandExample example);

    int insert(Sjl22ApiCommand record);

    int insertSelective(Sjl22ApiCommand record);

    List<Sjl22ApiCommand> selectByExample(Sjl22ApiCommandExample example);

    int updateByExampleSelective(@Param("record") Sjl22ApiCommand record, @Param("example") Sjl22ApiCommandExample example);

    int updateByExample(@Param("record") Sjl22ApiCommand record, @Param("example") Sjl22ApiCommandExample example);
    //Automatic
    /************************************************************************/
    //Manual
    
    Sjl22ApiCommand selectSj(int id);

    List<Sjl22ApiCommand> selectAllSj();
 
    List<Sjl22ApiCommand> selectSjRecord(@Param("first")int first,@Param("last")int last);
    
	List<Sjl22ApiCommand> selectSjRecordParam(Map<String, Object> sjl22Map);
    
    int getCount();
    
    int getCountParam(Map<String, Object> sjl22Map);
}