package cn.wqk.manager.service;

import cn.wqk.manager.pojo.DoctorInfo;
import cn.wqk.manager.pojo.ReservedInfo;
import org.apache.ibatis.annotations.Param;
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
public interface DoctorService {
    //根据医师id查询医师
    DoctorInfo selectDoctorByDid(int did);
    //根据医师id查询预约
    List<ReservedInfo> selectResByDid(int did);
}
