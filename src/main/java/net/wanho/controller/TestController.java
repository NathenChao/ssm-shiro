package net.wanho.controller;

import net.wanho.pojo.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/23.
 */
@Controller
@RequestMapping("login")
public class TestController {


    @RequestMapping("hello")
    public String hello(Map map){

        map.put("msg", "hello");

        return "hello";
    }

    @RequestMapping("toLogin1")
    public String test( ){



        return "login";
    }



        @RequiresPermissions("operation:update")
        @RequestMapping("updateStudent")
        public String  updateStudent(User user) {



            return "hello";

        }





}
