package cn.wqk.manager.serviceImpl;

import cn.wqk.manager.mapper.*;
import cn.wqk.manager.pojo.*;
import cn.wqk.manager.service.ManagerService;
import cn.wqk.manager.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/03/23:08
 * @Description:
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private ReservedMapper reservedMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Dept2Mapper dept2Mapper;
    @Autowired
    private User user;
    @Autowired
    private DoctorInfo doctorInfo;
    @Autowired
    private PatientInfo patientInfo;
    @Override
    public ManagerInfo selectManagerByMid(int mid) {
        return managerMapper.selectManagerByMid(mid);
    }

    @Override
    public List<ReservedInfo> selectAllRes() {
        return reservedMapper.selectAllRes();
    }

    @Override
    public List<PatientInfo> selectAllPatient() {
        return patientMapper.selectAllPatient();
    }

    @Override
    public List<DoctorInfo> selectAllDoctor() {
        return doctorMapper.selectAllDoctor();
    }

    @Override
    public List<Dept2> selectAllDept2() {
        return dept2Mapper.selectAllDept2();
    }

    @Override
    public int insertDoctor(String name,String username, String password, int age, String sex,
                            int dept2_id, String phone, String information, MultipartFile file)throws DataAccessException {
        user.setUsername(username);
        user.setPassword(password);
        user.setPermission("doctor");
        doctorInfo.setName(name);
        doctorInfo.setAge(age);
        doctorInfo.setSex(sex);
        doctorInfo.setDept2_id(dept2_id);
        doctorInfo.setPhone(phone);
        doctorInfo.setInformation(information);
        try{
            userMapper.insertUser(user);
            doctorInfo.setDid(user.getUid());
            String fileName = Integer.toString(user.getUid());
            String fileDir="/hospital/img/doctor/";
            String imgPath = FileUtils.uploadFile(file, fileDir,fileName);
            doctorInfo.setImgPath(imgPath);
            doctorMapper.insertDoctor(doctorInfo);
            return user.getUid();
        }catch (DataAccessException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int updateDoctor(int did, String name, String password, int age, String sex,
                                int dept2_id, String phone, String information) throws DataAccessException {
        user.setUid(did);
        user.setPassword(password);
        user.setPermission("doctor");
        doctorInfo.setDid(did);
        doctorInfo.setName(name);
        doctorInfo.setAge(age);
        doctorInfo.setSex(sex);
        doctorInfo.setDept2_id(dept2_id);
        doctorInfo.setPhone(phone);
        doctorInfo.setInformation(information);
        try {
            userMapper.updateUser(user);
            doctorMapper.updateDoctor(doctorInfo);
            return doctorInfo.getDid();
        }catch (DataAccessException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int deleteDoctor(int did) throws DataAccessException{
        try {
            userMapper.deleteUser(did);
            doctorMapper.deleteDoctor(did);
            return did;
        }catch (DataAccessException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int updatePatient(String password, String name, int age,
                             String sex, int pid) throws DataAccessException{
        user.setUid(pid);
        user.setPassword(password);
        user.setPermission("patient");
        patientInfo.setPid(pid);
        patientInfo.setName(name);
        patientInfo.setAge(age);
        patientInfo.setSex(sex);
        try {
            userMapper.updateUser(user);
            patientMapper.updatePatient(patientInfo);
            return patientInfo.getPid();
        }catch (DataAccessException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int deletePatient(int pid)throws DataAccessException {
        try {
            userMapper.deleteUser(pid);
            patientMapper.deletePatient(pid);
            return pid;
        }catch (DataAccessException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return 0;
        }
    }
}
