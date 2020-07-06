package cn.wqk.manager.serviceImpl;

import cn.wqk.manager.mapper.DoctorMapper;
import cn.wqk.manager.mapper.ReservedMapper;
import cn.wqk.manager.pojo.DoctorInfo;
import cn.wqk.manager.pojo.ReservedInfo;
import cn.wqk.manager.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/03/23:08
 * @Description:
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private ReservedMapper reservedMapper;
    @Override
    public DoctorInfo selectDoctorByDid(int did) {
        return doctorMapper.selectDoctorByDid(did);
    }
    @Override
    public List<ReservedInfo> selectResByDid(int did) {
        return reservedMapper.selectResByDid(did);
    }
}
