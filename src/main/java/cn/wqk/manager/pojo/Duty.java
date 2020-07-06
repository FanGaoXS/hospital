package cn.wqk.manager.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * duty
 * @author 
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Duty  {
    /**
     * 医师编号
     */
    private Integer did;

    /**
     * 星期一上午
     */
    private Integer mondayA;

    /**
     * 星期一下午
     */
    private Integer mondayP;

    /**
     * 星期二上午
     */
    private Integer tuesdayA;

    /**
     * 星期二下午
     */
    private Integer tuesdayP;

    /**
     * 星期三上午
     */
    private Integer wednesdayA;

    /**
     * 星期三下午
     */
    private Integer wednesdayP;

    /**
     * 星期四上午
     */
    private Integer thursdayA;

    /**
     * 星期四下午
     */
    private Integer thursdayP;

    /**
     * 星期五上午
     */
    private Integer fridayA;

    /**
     * 星期五下午
     */
    private Integer fridayP;

}