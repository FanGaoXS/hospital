package cn.wqk.manager.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 医师信息
 * @author 
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class DoctorInfo {
    /**
     * 医师编号（取自user表）
     */
    private Integer did;

    /**
     * 医师名字
     */
    private String name;

    /**
     * 医师性别
     */
    private String sex;

    /**
     * 医师年龄
     */
    private Integer age;

    /**
     * 所属二级科室
     */
    private Integer dept2_id;

    /**
     * 医师电话
     */
    private String phone;

    /**
     * 医师相关信息
     */
    private String information;

    /**
     * 医师头像路径
     */
    private String imgPath;

    private User user;

    private Dept2 dept2;

    private Duty duty;
}