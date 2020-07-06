package cn.wqk.manager.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 病人信息
 * @author
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class PatientInfo{
    /**
     * 用户编号(取自user表)
     */
    private Integer pid;

    /**
     * 病人姓名
     */
    private String name;

    /**
     * 病人年龄
     */
    private Integer age;

    /**
     * 病人性别
     */
    private String sex;

    private User user;
}