package cn.wqk.manager.mapper;

import cn.wqk.manager.pojo.ReservedInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/03/10:07
 * @Description:
 */
@Mapper
@Repository
public interface ReservedMapper {
    //查看所有预约
    List<ReservedInfo> selectAllRes();
    //根据病人编号查询预约
    List<ReservedInfo> selectResByPid(@Param("pid")int pid);
    //根据医师编号查询预约
    List<ReservedInfo> selectResByDid(@Param("did")int did);
    //新增预约
    int insertRes(ReservedInfo reservedInfo);
    //删除预约
    int deleteRes(@Param("rid")int rid);
    //修改预约
    int updateRes(ReservedInfo reservedInfo);
}
