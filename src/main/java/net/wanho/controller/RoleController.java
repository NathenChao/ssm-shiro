package net.wanho.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import net.wanho.dto.ZtreeDto;
import net.wanho.mapper.PermissionMapper;
import net.wanho.mapper.RoleMapper;
import net.wanho.pojo.Role;
import net.wanho.service.PermissionServiceI;
import net.wanho.service.RoleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2019/4/26.
 */
@Controller
public class RoleController {

    @Autowired
    private RoleServiceI roleServiceI;

    @Autowired
    private PermissionServiceI permissionServiceI;

    @RequestMapping("showRoles")
    public String showRoles(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Map map){

        PageInfo<Role> rolePageInfo = roleServiceI.getPageRoles(pageNum);
        map.put("rolePageInfo", rolePageInfo);

        return "roleList";
    }



    @RequestMapping("showPermission")
    @ResponseBody
    public JSONObject showPermission(Integer rid){

        System.out.println(rid);
        List<ZtreeDto> allPermissions = permissionServiceI.getAllPermissions();

        JSONObject jsonResult = new JSONObject();
        jsonResult.put("allPermissions", allPermissions);
        List<Integer> permissionByRid = permissionServiceI.getPermissionByRid(rid);
        jsonResult.put("permissionByRid",permissionByRid );

        System.out.println(permissionByRid);

        return jsonResult;
    }




}
