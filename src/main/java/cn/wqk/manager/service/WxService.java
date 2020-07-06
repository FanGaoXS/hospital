package cn.wqk.manager.service;

import cn.wqk.manager.pojo.DoctorInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/29/23:42
 * @Description: 微信小程序业务
 */
@Service
public interface WxService {
    /**
     *  根据二类科室编号查询医师
     * @param dept2Id
     * @return 医师集合
     */
    List<DoctorInfo> selectDoctorByDept2Id(int dept2Id);
}
