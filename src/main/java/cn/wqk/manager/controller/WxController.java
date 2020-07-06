package cn.wqk.manager.controller;

import cn.wqk.manager.pojo.DoctorInfo;
import cn.wqk.manager.pojo.User;
import cn.wqk.manager.service.PatientService;
import cn.wqk.manager.service.UserService;
import cn.wqk.manager.service.WxService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/29/23:31
 * @Description: 微信小程序控制器
 */
@RestController
@RequestMapping("/wx")
@Api(tags = "微信小程序控制器")
public class WxController {
    @Autowired
    private WxService wxService;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;
    @RequestMapping("/selectDoctorByDept2Id")
    @ApiOperation("根据二类科室编号获得该科室医生")
    public String selectDoctorByDept2Id(@RequestParam("dept2Id")int dept2Id){
        //获得今天星期几
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1;
        List<DoctorInfo> doctorInfoList = wxService.selectDoctorByDept2Id(dept2Id);
        switch (day){
            case 1:
                for (DoctorInfo doctorInfo : doctorInfoList) {
                    doctorInfo.getDuty().setMondayA(-1);
                    doctorInfo.getDuty().setMondayP(-1);
                }
                break;
            case 2:
                for (DoctorInfo doctorInfo : doctorInfoList) {
                    doctorInfo.getDuty().setMondayA(-1);
                    doctorInfo.getDuty().setMondayP(-1);
                    doctorInfo.getDuty().setTuesdayA(-1);
                    doctorInfo.getDuty().setTuesdayP(-1);
                }
                break;
            case 3:
                for (DoctorInfo doctorInfo : doctorInfoList) {
                    doctorInfo.getDuty().setMondayA(-1);
                    doctorInfo.getDuty().setMondayP(-1);
                    doctorInfo.getDuty().setTuesdayA(-1);
                    doctorInfo.getDuty().setTuesdayP(-1);
                    doctorInfo.getDuty().setWednesdayA(-1);
                    doctorInfo.getDuty().setWednesdayP(-1);
                }
                break;
            case 4:
                for (DoctorInfo doctorInfo : doctorInfoList) {
                    doctorInfo.getDuty().setMondayA(-1);
                    doctorInfo.getDuty().setMondayP(-1);
                    doctorInfo.getDuty().setTuesdayA(-1);
                    doctorInfo.getDuty().setTuesdayP(-1);
                    doctorInfo.getDuty().setWednesdayA(-1);
                    doctorInfo.getDuty().setWednesdayP(-1);
                    doctorInfo.getDuty().setThursdayA(-1);
                    doctorInfo.getDuty().setThursdayP(-1);
                }
                break;
            case 5:
                for (DoctorInfo doctorInfo : doctorInfoList) {
                    doctorInfo.getDuty().setMondayA(-1);
                    doctorInfo.getDuty().setMondayP(-1);
                    doctorInfo.getDuty().setTuesdayA(-1);
                    doctorInfo.getDuty().setTuesdayP(-1);
                    doctorInfo.getDuty().setWednesdayA(-1);
                    doctorInfo.getDuty().setWednesdayP(-1);
                    doctorInfo.getDuty().setThursdayA(-1);
                    doctorInfo.getDuty().setThursdayP(-1);
                    doctorInfo.getDuty().setFridayA(-1);
                    doctorInfo.getDuty().setFridayP(-1);
                }
                break;
        }

        String jsonString = JSON.toJSONString(doctorInfoList);
        return jsonString;
    }
    @RequestMapping("/loginAndNewRes")
    @ApiOperation("患者登录然后新增预约")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        @RequestParam("did")int did,
                        @RequestParam("day")int day,
                        @RequestParam("noon")int noon){
        User user = userService.selectUserByUsername(username);
        if (user.getPassword().equals(password)&&user.getPermission().equals("patient")){
            Integer pid = user.getUid();
            int i = patientService.insertRes1(pid, did, day, noon);
            String jsonString = JSON.toJSONString(user);
            return jsonString;
        }else {
            return "failure";
        }
    }
}
