package cn.wqk.manager.mapper;

import cn.wqk.manager.pojo.Dept2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/11/11:52
 * @Description:
 */
@Mapper
@Repository
public interface Dept2Mapper {
    //查询出所有二类科室以及它所属的一类科室的相关信息
    List<Dept2> selectAllDept2();
}
