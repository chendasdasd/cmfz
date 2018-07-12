package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/12.
 */
public interface UserPermissionService {

    public List<Role> findHasRoles(String user_name);

    public List<Permission> findHasPermissions(String user_name);
}
