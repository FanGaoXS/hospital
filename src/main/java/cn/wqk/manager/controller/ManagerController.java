package cn.wqk.manager.controller;

import cn.wqk.manager.pojo.*;
import cn.wqk.manager.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/04/22:10
 * @Description:
 */
@Controller
@RequestMapping("/manager")
public class ManagerController{
    @Autowired
    private ManagerService managerService;
    @RequestMapping("/update")
    @ResponseBody
    public String update(){
        return "ok";
    }
    @RequestMapping("/toPatient")
    public String toPatient(Model model){
        List<PatientInfo> patientInfoList = managerService.selectAllPatient();
        model.addAttribute("patientInfoList",patientInfoList);
        return "manager/patient";
    }
    @RequestMapping("/toDoctor")
    public String toDoctor(Model model){
        List<DoctorInfo> doctorInfoList = managerService.selectAllDoctor();
        model.addAttribute("doctorInfoList",doctorInfoList);
        List<Dept2> dept2List = managerService.selectAllDept2();
        model.addAttribute("dept2List",dept2List);
        return "manager/doctor";
    }
    @RequestMapping("/toRes")
    public String toRes(Model model){
        List<ReservedInfo> reservedInfoList = managerService.selectAllRes();
        model.addAttribute("reservedInfoList",reservedInfoList);
        return "manager/res";
    }
    @RequestMapping("/toIndex")
    public String toIndex(Model model){
        /*
              通过SecurityUtils.getSubject()得到Subject对象
              再通过Subject的getSession方法得到存在Shiro中session存的User对象
              Shiro先认证，再得到Session。
        */
        Session session = SecurityUtils.getSubject().getSession();
        User loginUser = (User)session.getAttribute("loginUser");
        ManagerInfo managerInfo = managerService.selectManagerByMid(loginUser.getUid());
        model.addAttribute("managerInfo",managerInfo);
        return "manager/index";
    }
    @RequestMapping("/newDoctor")
    @ResponseBody
    public String newDoctor(@RequestParam("name")String name,
                            @RequestParam("username")String username,
                            @RequestParam("password")String password,
                            @RequestParam("age")int age,
                            @RequestParam("sex")String sex,
                            @RequestParam("dept2_id")int dept2_id,
                            @RequestParam("phone")String phone,
                            @RequestParam("information")String information,
                            @RequestParam("file")MultipartFile file){
        /*System.out.println("file="+file);
        System.out.println("name="+name);
        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println("age="+age);
        System.out.println("sex="+sex);
        System.out.println("dept2_id="+dept2_id);
        System.out.println("phone="+phone);
        System.out.println("information="+information);*/
        int i = managerService.insertDoctor(name,username, password, age, sex, dept2_id, phone, information, file);
        if (i>0){
            return "新增医师成功";
        }else {
            return "新增医师失败，请联系管理员";
        }
    }
    @RequestMapping("/updateDoctor")
    @ResponseBody
    public String updateDoctor(@RequestParam("did")int did,
                               @RequestParam("name")String name,
                               @RequestParam("password")String password,
                               @RequestParam("age")int age,
                               @RequestParam("sex")String sex,
                               @RequestParam("dept2_id")int dept2_id,
                               @RequestParam("phone")String phone,
                               @RequestParam("information")String information){
        int i = managerService.updateDoctor(did, name, password, age, sex, dept2_id, phone, information);
        if (i>0){
            return "修改医师信息成功";
        }else {
            return "修改医师信息失败，请联系管理员";
        }

    }
    @RequestMapping("/deleteDoctor")
    @ResponseBody
    public String deleteDoctor(@RequestParam("did")int did){
        int i = managerService.deleteDoctor(did);
        System.out.println("did="+did);
        if (i>0){
            return "删除医师信息成功";
        }else {
            return "删除医师信息失败，请联系管理员";
        }
    }
    @RequestMapping("/updatePatient")
    @ResponseBody
    public String updatePatient(@RequestParam("password")String password,
                                @RequestParam("name")String name,
                                @RequestParam("age")int age,
                                @RequestParam("sex")String sex,
                                @RequestParam("pid")int pid){
        int i = managerService.updatePatient(password, name, age, sex, pid);
        if (i>0){
            return "修改病人信息成功";
        }else {
            return "修改病人信息失败，请联系管理员";
        }
    }
    @RequestMapping("/deletePatient")
    @ResponseBody
    public String deletePatient(@RequestParam("pid")int pid){
        int i = managerService.deletePatient(pid);
        if (i>0){
            return "删除病人信息成功";
        }else {
            return "删除病人信息失败，请联系管理员";
        }
    }
}
