package cn.wqk.manager.controller;

import cn.wqk.manager.pojo.ReservedInfo;
import cn.wqk.manager.pojo.User;
import cn.wqk.manager.service.DoctorService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/02/23:48
 * @Description:
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController{
    @Autowired
    DoctorService doctorService;
    @RequestMapping("/toHistory")
    public String toHistory(Model model){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User loginUser = (User)session.getAttribute("loginUser");
        List<ReservedInfo> reservedInfoList = doctorService.selectResByDid(loginUser.getUid());
        model.addAttribute("reservedInfoList",reservedInfoList);
        return "doctor/history";
    }
    @RequestMapping("/toRes")
    public String toRes(Model model){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User loginUser = (User)session.getAttribute("loginUser");
        List<ReservedInfo> reservedInfoList = doctorService.selectResByDid(loginUser.getUid());
        model.addAttribute("reservedInfoList",reservedInfoList);
        return "doctor/res";
    }
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "doctor/index";
    }
}
