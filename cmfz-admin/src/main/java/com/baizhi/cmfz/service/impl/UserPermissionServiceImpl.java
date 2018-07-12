package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.UserPermissionDao;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/12.
 */
@Service
@Transactional
public class UserPermissionServiceImpl implements UserPermissionService {
    @Autowired
    private UserPermissionDao userPermissionDao;

    @Override
    public List<Role> findHasRoles(String user_name) {

        return userPermissionDao.selectHasRoles(user_name);
    }

    @Override
    public List<Permission> findHasPermissions(String user_name) {
        return userPermissionDao.selectHasPermission(user_name);
    }
}
