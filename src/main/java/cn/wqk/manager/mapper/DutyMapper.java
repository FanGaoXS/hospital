package cn.wqk.manager.mapper;

import cn.wqk.manager.pojo.Duty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/26/20:25
 * @Description: 医师值班表CRUD
 */
@Mapper
@Repository
public interface DutyMapper {
    //查询所有医师值班信息
    List<Duty> selectAllDuty();
    //根据医师编号did查询该医师的值班信息
    Duty selectDutyByDid(@Param("did")int did);
    //根据医师编号did修改该医师的值班信息
    int updateDutyByDid(Duty duty);
}
