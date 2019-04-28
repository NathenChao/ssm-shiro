package net.wanho.service;

import net.wanho.dto.ZtreeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DELL on 2019/4/27.
 */
public interface PermissionServiceI {

    List<ZtreeDto> getAllPermissions();

    List<Integer> getPermissionByRid(Integer rid);



}
