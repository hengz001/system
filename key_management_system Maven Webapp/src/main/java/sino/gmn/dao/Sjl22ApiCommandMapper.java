package sino.gmn.dao;

import java.util.List;
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
}