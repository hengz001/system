package sino.gmn.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sino.gmn.entity.GmnUser;
import sino.gmn.entity.GmnUserExample;

public interface GmnUserMapper {
    long countByExample(GmnUserExample example);

    int deleteByExample(GmnUserExample example);

    int insert(GmnUser record);

    int insertSelective(GmnUser record);

    List<GmnUser> selectByExample(GmnUserExample example);

    int updateByExampleSelective(@Param("record") GmnUser record, @Param("example") GmnUserExample example);

    int updateByExample(@Param("record") GmnUser record, @Param("example") GmnUserExample example);
}