package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Role;
import net.wanho.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/4/23.
 */
public interface RoleServiceI {


    List<Role> getAllRoles();

    List<Role> getRoleByUserId(Integer userId);


    void updateUserAndRole(Integer uid,int[] rid);

    PageInfo<Role> getPageRoles(Integer pageNum);




}
