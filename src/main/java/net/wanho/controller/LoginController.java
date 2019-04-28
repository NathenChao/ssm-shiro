package net.wanho.controller;

import net.wanho.pojo.User;
import net.wanho.service.UserServiceI;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/25.
 */
@Controller
@RequestMapping("login")
public class LoginController {


    @Autowired
    private UserServiceI userServiceI;

    @RequestMapping("toLogin")
    public String toLogin(){

        return "login";
    }


    @RequestMapping("login")
    public String login(String username,String password,Map map){

        String viewName="hello";
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {

            map.put("login", "参数值不能为空");
        }
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            viewName = "index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return viewName;

    }

    @RequestMapping("addUser")
    public String addUser(User user, Map map){

        User user1 = userServiceI.getUser(user.getUsername());
        if (user1 == null) {
            userServiceI.addUser(user);
            return "redirect:/toLogin";
        }else {
            map.put("register","用户名存在，请重新注册！");
            return "hello";
        }


    }

}
