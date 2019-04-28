package net.wanho.service.impl;

import net.wanho.dto.ZtreeDto;
import net.wanho.mapper.PermissionMapper;
import net.wanho.service.PermissionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 2019/4/27.
 */
@Service
public class PermissionServiceImpl implements PermissionServiceI{

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<ZtreeDto> getAllPermissions() {
        return permissionMapper.getAllPermissions();
    }

    @Override
    public List<Integer> getPermissionByRid(Integer rid) {
        return permissionMapper.getPermissionByRid(rid);
    }
}
