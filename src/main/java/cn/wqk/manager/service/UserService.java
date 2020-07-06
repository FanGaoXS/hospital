package cn.wqk.manager.service;

import cn.wqk.manager.pojo.PatientInfo;
import cn.wqk.manager.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/02/11:54
 * @Description:
 */
@Service
public interface UserService {
    //根据用户名查询用户（shiro登录用）
    User selectUserByUsername(String username);
}
