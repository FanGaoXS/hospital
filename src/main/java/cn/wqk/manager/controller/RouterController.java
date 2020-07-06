package cn.wqk.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/06/01/9:06
 * @Description:
 */
@Controller
public class RouterController {
    @RequestMapping("/hello") @ResponseBody public String hello(){
        return "Hello";
    }
    @RequestMapping("/toUnauthor") @ResponseBody public String toUnauthor(){return "抱歉，你没有权限访问该页面";}
    @RequestMapping("/toDashboard") public String toDashboard(){
        return "dashboard";
    }
    @RequestMapping("/toIcons") public String toIcons(){
        return "icons";
    }
    @RequestMapping("/toMap") public String toMap(){
        return "map";
    }
    @RequestMapping("/toMaps") public String toMaps(){
        return "maps";
    }
    @RequestMapping("/toNotifications") public String toNotifications(){ return "notifications"; }
    @RequestMapping("/toTables") public String toTables(){
        return "tables";
    }
    @RequestMapping("/toTypography") public String toTypography(){
        return "typography";
    }
    @RequestMapping("/toUpgrade") public String toUpgrade(){
        return "upgrade";
    }
    @RequestMapping("/toUser") public String toUser(){
        return "user";
    }
    @RequestMapping({"/toLogin","/","/index"}) public String toLogin(){
        return "login";
    }
    @RequestMapping("/toRegister") public String toRegister(){
        return "register";
    }
    @RequestMapping("/test") public String test(){return "test";}
}
