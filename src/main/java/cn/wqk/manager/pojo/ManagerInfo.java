package cn.wqk.manager.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 管理者信息
 * @author 
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ManagerInfo{
    /**
     * 管理者编号（取自user表）
     */
    private Integer mid;

    /**
     * 管理者姓名
     */
    private String name;

    /**
     * 管理者性别
     */
    private String sex;

    private User user;
}