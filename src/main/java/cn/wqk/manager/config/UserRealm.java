package cn.wqk.manager.config;

import cn.wqk.manager.pojo.User;
import cn.wqk.manager.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();//拿到user对象
        info.addStringPermission(currentUser.getPermission());//获取到该user对象的权限并赋给它
        return info;
    }

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取前端给予的Token对象里面封装了用户名和密码
        UsernamePasswordToken userToken=(UsernamePasswordToken)authenticationToken;
        //将token里的用户名用来查询数据库里是否存在该用户
        User user = userService.selectUserByUsername(userToken.getUsername());
        if (user==null){//如果用户不存在
            return null;//抛出异常UnknownAccountException
        }
        /*
            取到User对象，然后存到Shiro的session里
        */
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser",user);
        //返回明文密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
