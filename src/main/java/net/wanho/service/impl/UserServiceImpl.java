package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.RoleMapper;
import net.wanho.mapper.UserMapper;
import net.wanho.pojo.User;
import net.wanho.service.UserServiceI;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/4/23.
 */
@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<String> getRoles(String username) {

        List<String> roles = userMapper.getRoles(username);

        return roles;
    }

    @Override
    public List<String> getPermissions(String username) {

        List<String> permissions = userMapper.getPermissions(username);
        return permissions;
    }

    @Override
    public void addUser(User user) {

        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        user.setPassword(shiroMD5(user.getPassword(),salt));
        userMapper.addUser(user);


    }

    @Override
    public String shiroMD5(String password, String salt) {
        String algorithmName="md5";
        ByteSource bytes = ByteSource.Util.bytes(salt);
        int hashIterations=2;
        Object object = new SimpleHash(algorithmName, password, bytes, hashIterations);
        return object.toString();
    }

    @Override
    public User getUser(String username) {

        User user = userMapper.getUser(username);

        return user;
    }

    @Override
    public User queryUser(String username, String password) {

        User user = userMapper.queryUser(username, password);

        return user;


    }

    @Override
    public PageInfo<User> getAllUsers(Integer pageNum) {

        PageHelper.startPage(pageNum, 5);
        List<User> users  = userMapper.getAllUsers();
        PageInfo<User> userPageInfo = new PageInfo<User>(users);


        return userPageInfo;
    }

    @Override
    public void deleteUserByUid(Integer uid) {

        roleMapper.deleteAllRole(uid);
        userMapper.deleteUserById(uid);

    }


}
