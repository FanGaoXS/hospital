package cn.wqk.manager.serviceImpl;

import cn.wqk.manager.mapper.DoctorMapper;
import cn.wqk.manager.pojo.DoctorInfo;
import cn.wqk.manager.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/29/23:44
 * @Description: 微信小程序业务实现类
 */
@Service
public class WxServiceImpl implements WxService {
    @Autowired
    private DoctorMapper doctorMapper;
    @Override
    public List<DoctorInfo> selectDoctorByDept2Id(int dept2Id) {
        return doctorMapper.selectDoctorByDept2Id(dept2Id);
    }
}
