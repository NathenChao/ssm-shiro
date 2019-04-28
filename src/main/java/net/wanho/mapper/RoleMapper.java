package net.wanho.mapper;

import net.wanho.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/4/25.
 */
public interface RoleMapper {



    List<Role> getAllRoles();

    List<Role> getRoleByUserId(@Param("userId") Integer userId);

    void deleteAllRole(@Param("userId") Integer userId);

    void insertUserAndRole(@Param("uid") Integer uid, @Param("rid") Integer rid);

}
