package cn.wqk.manager.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 二类科室
 * @author 
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Dept2 {
    /**
     * 二类科室编号
     */
    private Integer dept2_id;

    /**
     * 二类科室名字
     */
    private String name;

    private Dept1 dept1;
}