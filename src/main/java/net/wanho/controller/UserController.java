package net.wanho.controller;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.JsonResult;
import net.wanho.pojo.Role;
import net.wanho.pojo.User;
import net.wanho.service.RoleServiceI;
import net.wanho.service.UserServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/23.
 */
@Controller
@RequestMapping("login")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

    @Autowired
    private RoleServiceI roleServiceI;

/*
    @RequestMapping("getRoles")
    public String getRoles(Map map){
        List<String> roles = userServiceI.getRoles("dc");

        map.put("roles", roles);

        return "hello";
    }


    @RequestMapping("getPermission")
    public String getPermission(Map map){
        List<String> permissions = userServiceI.getPermissions("dc");

        map.put("roles", permissions);

        return "hello";
    }*/


/*    @RequiresRoles("admin")
    @RequestMapping("admin")
    public String admin(){

        return "index";
    }


    @RequiresPermissions("operation:add")
    @RequestMapping("getPermission")
    public String getPermission(){

        return "index";
    }*/



    @RequestMapping("showUser")
    public String showUser(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Map map){

        PageInfo<User> userPageInfo = userServiceI.getAllUsers(pageNum);

        map.put("userPageInfo",userPageInfo);
        List<Role> roles = roleServiceI.getAllRoles();
        System.out.println("roles=============="+roles);
        map.put("roles", roles);

        return "userslist";
    }


    @RequestMapping("queryRole")
    @ResponseBody
    public JsonResult queryRole(Integer userId,Map map){

        List<Role> roles = roleServiceI.getRoleByUserId(userId);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(200);
        jsonResult.setMsg("查找成功");
        jsonResult.setObject(roles);

        return jsonResult;
    }



    @RequestMapping(value="/test",method= RequestMethod.POST)
    public String test(@RequestParam("uid") int uid,@RequestParam(value = "rid[]") int[] rid){

        System.out.println(uid);

        roleServiceI.updateUserAndRole(uid,rid);

        return null;
    }


    @RequestMapping("deleteUser")
    public String deleteUser(Integer uid){

        userServiceI.deleteUserByUid(uid);

        return "redirect:/login/showUser";
    }


}
