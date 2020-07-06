package cn.wqk.manager.controller;

import cn.wqk.manager.pojo.PatientInfo;
import cn.wqk.manager.pojo.User;
import cn.wqk.manager.service.PatientService;
import cn.wqk.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/01/9:51
 * @Description:
 */
@Controller
public class LoginController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;
    //登录，使用shiro框架来判断
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model){
        //获取当前登录用户
        Subject subject= SecurityUtils.getSubject();
        //封装用户登录的数据，以便校验
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {//成功
            subject.login(token);//subject对象匹配token里的登录密码
            User currentUser = (User)subject.getPrincipal();//获取到当前登录成功的User对象
            String permission = currentUser.getPermission();//获取到当前User对象的permission权限
            if (permission.equals("doctor")){
                return "redirect:doctor/toIndex";
            }else if (permission.equals("manager")){
                return "redirect:manager/toIndex";
            }else {
                return "redirect:patient/toIndex";
            }
        }catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){//密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
    //病人注册
    @RequestMapping("/register")
    public String register(User user,
                           PatientInfo patientInfo,
                           Model model){
        boolean b = patientService.registerPatient(user, patientInfo);
        if (b){
            //如果注册成功，重定向到登录页面
            return "redirect:/toLogin";
        }else {
            //注册失败
            model.addAttribute("msg","注册失败，用户名或者名字重复");
            return "register";
        }
    }
    //用户退出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index";
    }
    //Ajax判断用户名是否重复
    @RequestMapping("/checkUsername")
    @ResponseBody
    public boolean checkUsername(@RequestParam("username")String username){
        User user = userService.selectUserByUsername(username);
        if (user!=null){//存在该用户，表示用户名重复
            return false;
        }else {//不存在该用户，用户名可用
            return true;
        }
    }
}
