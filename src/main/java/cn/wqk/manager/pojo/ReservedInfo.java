package cn.wqk.manager.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 预约信息
 * @author 
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ReservedInfo {
    /**
     * 预约编号
     */
    private Integer rid;

    /**
     * 预约病人的编号
     */
    private Integer pid;

    /**
     * 被预约医生的编号
     */
    private Integer did;

    /**
     * 预约时间
     */
    private Date time;

    /**
     * 处理情况(已处理\未处理)
     */
    private String status;

    /**
     * 医师就诊时间
     */
    private Date endTime;

    private PatientInfo patientInfo;

    private DoctorInfo doctorInfo;

    private Dept1 dept1;

    private Dept2 dept2;
}