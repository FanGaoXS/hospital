package cn.wqk.manager.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 一类科室
 * @author 
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Dept1{
    /**
     * 一类科室编号
     */
    private Integer dept1_id;

    /**
     * 一类科室名字
     */
    private String name;

    /**
     * 一类科室电话
     */
    private String phone;
}