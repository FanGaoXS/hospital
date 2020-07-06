package cn.wqk.manager.mapper;

import cn.wqk.manager.pojo.DoctorInfo;
import cn.wqk.manager.pojo.PatientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/03/17:40
 * @Description:
 */
@Mapper
@Repository
public interface DoctorMapper {
    //查询所有医师
    List<DoctorInfo> selectAllDoctor();
    //根据医师编号查询医师信息
    DoctorInfo selectDoctorByDid(@Param("did")int did);
    //新增医师
    int insertDoctor(DoctorInfo doctorInfo);
    //修改医师信息
    int updateDoctor(DoctorInfo doctorInfo);
    //删除医师信息
    int deleteDoctor(@Param("did")int did);
    //根据二类科室编号查询医师
    List<DoctorInfo> selectDoctorByDept2Id(@Param("dept2Id")int dept2Id);
}
