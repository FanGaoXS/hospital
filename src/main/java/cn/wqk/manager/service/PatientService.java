package cn.wqk.manager.service;

import cn.wqk.manager.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/03/23:09
 * @Description:
 */
@Service
public interface PatientService {
    //病人注册，true注册成功，false注册失败
    boolean registerPatient(User user, PatientInfo patientInfo);
    //修改病人信息，true修改成功，false修改失败
    boolean updatePatient(User user,PatientInfo patientInfo);
    //根据病人编号查询病人信息
    PatientInfo selectPatientByPid(int pid);
    //新增预约，true新增成功，false新增失败
    boolean insertRes(int pid, int did, int timeNumber);

    /**
     *  新增预约
     * @param pid 病人编号
     * @param did 医师编号
     * @param day 星期几
     * @param noon 上午或者下午
     * @return 预约成功的预约号
     */
    int insertRes1(int pid,int did,int day,int noon);
    //根据病人编号查询历史预约
    List<ReservedInfo> selectResByPid(int pid);
    //查询出所有医师信息
    List<DoctorInfo> selectAllDoctor();
    //根据did查询医师的值班信息
    Duty selectDutyByDid(int did);
}
