package cn.wqk.manager.service;

import cn.wqk.manager.pojo.*;
import org.springframework.stereotype.Service;
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
public interface ManagerService {
    //根据id查询管理者
    ManagerInfo selectManagerByMid(int mid);
    //查询所有预约信息
    List<ReservedInfo> selectAllRes();
    //查询所有病人
    List<PatientInfo> selectAllPatient();
    //查询所有医师
    List<DoctorInfo> selectAllDoctor();
    //列出所有二类科室信息
    List<Dept2> selectAllDept2();

    /*
        管理员身份新增医师
        @Param:
            name:医师的名字
            username:医师登录用户名
            password:医师登录密码
            age:医师年龄
            sex:医师性别
            dept2_id:医师分配的二类科室的id
            phone:医师电话
            information:医师详情描述
            file:上传的图片
        @return:
            返回插入成功的医师的编号
            0表示插入失败
    */
    int insertDoctor(String name,
                     String username,
                     String password,
                     int age,
                     String sex,
                     int dept2_id,
                     String phone,
                     String information,
                     MultipartFile file);

    /*
        管理员身份修改医师
        @Param:
            did:需要被修改的医师的编号
            name:修改后的医师的名字
            password:修改后医师的密码
            age:修改后医师的年龄
            sex:修改后医师的性别
            dept2_id:修改后医师的二类科室id
            phone:修改后医师的电话
            information:修改后医师的描述
            file:上传后需要修改的图片
         @return:
            返回修改成功的医师编号
            0:修改失败

    */
    int updateDoctor(int did,
                     String name,
                     String password,
                     int age,
                     String sex,
                     int dept2_id,
                     String phone,
                     String information);

    /*
        管理员身份删除医师
        @Param:
            did:需要被删除医师的编号
        @return:
            返回删除的医师的编号
            0:删除失败
    */
    int deleteDoctor(int did);

    /*
        管理员身份修改患者
        @Param:
            password:修改患者的密码
            name:修改患者的名字
            age:修改患者的年龄
            sex:修改患者的性别
            pid:需要修改患者的编号
        @return:
            返回修改成功的患者的编号
            0:修改失败
    */
    int updatePatient(String password,
                      String name,
                      int age,
                      String sex,
                      int pid);

    /*
        管理员身份删除医师
        @Param:
            pid:需要被删除的患者的编号
        @return:
            返回被删除的患者的编号
            0:删除失败
    */
    int deletePatient(int pid);
}
