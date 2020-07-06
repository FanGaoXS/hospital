package cn.wqk.manager.controller;

import cn.wqk.manager.pojo.DoctorInfo;
import cn.wqk.manager.pojo.Duty;
import cn.wqk.manager.pojo.PatientInfo;
import cn.wqk.manager.pojo.User;
import cn.wqk.manager.service.PatientService;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/02/23:48
 * @Description:
 */
@Controller
@RequestMapping("/patient")
public class PatientController{
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientInfo patientInfo;
    //病人去首页
    @RequestMapping("/toIndex")
    public String toIndex(Model model){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        model.addAttribute("loginUser",loginUser);
        return "patient/index";
    }
    //病人去修改个人信息页面
    @RequestMapping("/toUpdate")
    public String toUpdate(Model model){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        PatientInfo patientInfo = patientService.selectPatientByPid(loginUser.getUid());
        model.addAttribute("patientInfo",patientInfo);
        return "patient/update";
    }
    //病人修改个人信息
    @RequestMapping("/update")
    @ResponseBody
    public String update(String name,
                         String password,
                         int age,
                         String sex){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        loginUser.setPassword(password);
        patientInfo.setName(name);
        patientInfo.setAge(age);
        patientInfo.setSex(sex);
        boolean b = patientService.updatePatient(loginUser, patientInfo);
        if (b){//修改个人信息成功
            return "修改成功";
        }else {//修改个人信息失败
            return "修改失败";
        }
    }
    //病人去新增预约页面
    @RequestMapping("/toNewRes")
    public String toNewRes(Model model){
        List<DoctorInfo> doctorInfoList = patientService.selectAllDoctor();
        model.addAttribute("doctorInfoList",doctorInfoList);
        return "patient/newRes";
    }
    //病人新增预约
    @RequestMapping("/newRes")
    @ResponseBody
    public String newRes(@RequestParam("did")int did,@RequestParam("timeNumber") int timeNumber){
        Subject subject = SecurityUtils.getSubject();
        User loginUser = (User) subject.getPrincipal();
        int pid = loginUser.getUid();
        boolean b = patientService.insertRes(pid, did, timeNumber);
        if (b){
            return "预约成功";
        }else {
            return "预约失败，请联系管理员";
        }
    }
    @RequestMapping("/selectDutyByDid")
    @ResponseBody
    public String selectDutyByDid(@RequestParam("did")int did){
        System.out.println("did="+did);
        Duty duty = patientService.selectDutyByDid(did);
        String jsonString = JSON.toJSONString(duty);
        return jsonString;
    }
}
