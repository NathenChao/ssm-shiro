package net.wanho.mapper;

import net.wanho.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/4/23.
 */
public interface UserMapper {

    List<String> getRoles(@Param("username") String username);

    List<String> getPermissions(@Param("username") String username);

    void addUser(User user);


    User getUser(@Param("username") String username);


    User queryUser(@Param("username") String username, @Param("password") String password);


    List<User> getAllUsers();


    void deleteUserById(@Param("userId") Integer userId);

}
