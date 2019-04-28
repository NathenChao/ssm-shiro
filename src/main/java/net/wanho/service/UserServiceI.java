package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/4/23.
 */
public interface UserServiceI {

    List<String> getRoles(String username);

    List<String> getPermissions(String username);

    void addUser(User user);

    String shiroMD5(String password,String salt);

    User getUser(String username);

    User queryUser(String username,String password);

    PageInfo<User> getAllUsers(Integer pageNum);

    void deleteUserByUid(Integer uid);









}
