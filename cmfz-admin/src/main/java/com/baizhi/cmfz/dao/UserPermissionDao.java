package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/12.
 */
public interface UserPermissionDao {

    //查询出用户拥有的所有角色
    public List<Role> selectHasRoles(String mgr_name);

    //查询用户拥有的所有权限
    public List<Permission> selectHasPermission(String mgr_name);
}
