package cn.wqk.manager.mapper;

import cn.wqk.manager.pojo.PatientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/03/17:41
 * @Description:
 */
@Mapper
@Repository
public interface PatientMapper {
    //新增病人
    int insertPatient(PatientInfo patientInfo);
    //修改病人信息
    int updatePatient(PatientInfo patientInfo);
    //删除病人信息
    int deletePatient(@Param("pid")int pid);
    //根据pid查询病人信息
    PatientInfo selectPatientByPid(@Param("pid")int pid);
    //查询所有病人（管理员用）
    List<PatientInfo> selectAllPatient();
}
