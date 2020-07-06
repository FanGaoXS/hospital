package cn.wqk.manager.mapper;

import cn.wqk.manager.pojo.ManagerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/03/23:13
 * @Description:
 */
@Mapper
@Repository
public interface ManagerMapper {
    //查看所有管理者
    List<ManagerInfo> selectAllManager();
    //根据编号查询管理者
    ManagerInfo selectManagerByMid(@Param("mid")int mid);
    //新增管理者
    int insertManager(ManagerInfo managerInfo);
    //删除管理者
    int deleteManager(@Param("mid")int mid);
    //修改管理者信息
    int updateManager(ManagerInfo managerInfo);
}
