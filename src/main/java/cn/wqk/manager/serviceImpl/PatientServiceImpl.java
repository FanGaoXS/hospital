package cn.wqk.manager.serviceImpl;

import cn.wqk.manager.mapper.*;
import cn.wqk.manager.pojo.*;
import cn.wqk.manager.service.PatientService;
import cn.wqk.manager.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/03/23:10
 * @Description:
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ReservedMapper reservedMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private ReservedInfo reservedInfo;
    @Autowired
    private DutyMapper dutyMapper;
    @Autowired
    private Duty duty;
    @Override
    public boolean registerPatient(User user, PatientInfo patientInfo)throws DataAccessException {
        //尝试捕获病人注册时的异常信息
        try {
            //注册成功
            user.setPermission("patient");
            int i = userMapper.insertUser(user);
            patientInfo.setPid(user.getUid());
            int i1 = patientMapper.insertPatient(patientInfo);
            return true;
        }catch (DataAccessException e){
            //注册失败
            //@Transactional事物捕获异常，如果try发生异常，则回滚事物。
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean updatePatient(User user, PatientInfo patientInfo) throws DataAccessException{
        try {
            int i = userMapper.updateUser(user);
            patientInfo.setPid(user.getUid());
            int i1 = patientMapper.updatePatient(patientInfo);
            return true;//修改成功
        }catch (DataAccessException e){
            //@Transactional事物捕获异常，如果try发生异常，则回滚事物。
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return false;//修改失败
        }
    }

    @Override
    public PatientInfo selectPatientByPid(int pid) {
        return patientMapper.selectPatientByPid(pid);
    }

    @Override
    public boolean insertRes(int pid, int did, int timeNumber) {
        reservedInfo.setPid(pid);
        reservedInfo.setDid(did);
        //获取当前系统时间戳（毫秒形式）
        long nowTime = new Date().getTime();
        Timestamp time;
        switch (timeNumber){
            case 1:
                nowTime+=1000*60*120;//系统当前时间加上2小时
                time= new Timestamp(nowTime);
                reservedInfo.setTime(time);
                break;
            case 2:
                nowTime+=1000*60*180;//系统当前时间加上2小时
                time= new Timestamp(nowTime);
                reservedInfo.setTime(time);
                break;
            case 3:
                nowTime+=1000*60*240;//系统当前时间加上2小时
                time= new Timestamp(nowTime);
                reservedInfo.setTime(time);
                break;
        }
        reservedInfo.setStatus("预约中");
        int i = reservedMapper.insertRes(reservedInfo);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int insertRes1(int pid, int did, int day, int noon) {
        reservedInfo.setPid(pid);
        reservedInfo.setDid(did);
        reservedInfo.setStatus("预约中");
        Map<Integer, Date> dateOfWeek = DateUtils.dateOfWeek();
        Date date = dateOfWeek.get(day);
        if (noon==1){//上午
            reservedInfo.setTime(new Timestamp(date.getTime()-1000*60*60*6));
        }else {
            reservedInfo.setTime(new Timestamp(date.getTime()+1000*60*60*6));
        }
        int i = reservedMapper.insertRes(reservedInfo);
        int rid=reservedInfo.getRid();
        duty.setDid(did);
        switch (day){
            case 1:
                if (noon==1){
                    duty.setMondayA(rid);
                }else {
                    duty.setMondayP(rid);
                }
                break;
            case 2:
                if (noon==1){
                    duty.setTuesdayA(rid);
                }else {
                    duty.setTuesdayP(rid);
                }
                break;
            case 3:
                if (noon==1){
                    duty.setWednesdayA(rid);
                }else {
                    duty.setWednesdayP(rid);
                }
                break;
            case 4:
                if (noon==1){
                    duty.setThursdayA(rid);
                }else {
                    duty.setThursdayP(rid);
                }
                break;
            case 5:
                if (noon==1){
                    duty.setFridayA(rid);
                }else {
                    duty.setFridayP(rid);
                }
                break;
        }
        dutyMapper.updateDutyByDid(duty);
        return rid;
    }

    @Override
    public List<ReservedInfo> selectResByPid(int pid) {
        return reservedMapper.selectResByPid(pid);
    }

    @Override
    public List<DoctorInfo> selectAllDoctor() {
        return doctorMapper.selectAllDoctor();
    }

    @Override
    public Duty selectDutyByDid(int did) {
        return dutyMapper.selectDutyByDid(did);
    }
}
