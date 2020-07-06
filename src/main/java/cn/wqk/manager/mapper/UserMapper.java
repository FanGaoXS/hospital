package cn.wqk.manager.mapper;

import cn.wqk.manager.pojo.PatientInfo;
import cn.wqk.manager.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/02/11:43
 * @Description:
 */
@Mapper
@Repository
public interface UserMapper {
    //根据用户名查询用户是否存在（用于登录比对）
    User selectUserByUsername(@Param("username") String username);
    //新增用户表
    int insertUser(User user);
    //修改用户表
    int updateUser(User user);
    //删除用户表
    int deleteUser(@Param("uid")int uid);
}
