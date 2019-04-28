package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.RoleMapper;
import net.wanho.mapper.UserMapper;
import net.wanho.pojo.Role;
import net.wanho.pojo.User;
import net.wanho.service.RoleServiceI;
import net.wanho.service.UserServiceI;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/4/23.
 */
@Service
public class RoleServiceImpl implements RoleServiceI {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public List<Role> getRoleByUserId(Integer userId) {
        return roleMapper.getRoleByUserId(userId);
    }

    @Override
    public void updateUserAndRole(Integer uid, int[] rid) {

        roleMapper.deleteAllRole(uid);
        for (int i = 0;i<rid.length ;i++){
            roleMapper.insertUserAndRole(uid,rid[i]);
        }
    }

    @Override
    public PageInfo<Role> getPageRoles(Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Role> allRoles = roleMapper.getAllRoles();
        PageInfo<Role> rolePageInfo = new PageInfo<Role>(allRoles);



        return rolePageInfo;
    }


}
