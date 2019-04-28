package net.wanho.mapper;

import net.wanho.dto.ZtreeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DELL on 2019/4/27.
 */
public interface PermissionMapper {

    List<ZtreeDto> getAllPermissions();

    List<Integer> getPermissionByRid(@Param("rid") Integer rid);


}
