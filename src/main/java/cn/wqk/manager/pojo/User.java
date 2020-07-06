package cn.wqk.manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用户信息
 * @author 
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class User{
    /**
     * 用户编号
     */
    private Integer uid;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户权限
     */
    private String permission;
}