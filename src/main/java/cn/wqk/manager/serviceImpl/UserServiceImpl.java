package cn.wqk.manager.serviceImpl;

import cn.wqk.manager.mapper.UserMapper;
import cn.wqk.manager.pojo.PatientInfo;
import cn.wqk.manager.pojo.User;
import cn.wqk.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/02/11:56
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

}
