package com.baizhi.cmfz.utils;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.service.UserPermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/11.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserPermissionService userPermissionService;

    /**
     *获取授权信息方法 角色信息+权限信息
     *
     * 支持三种权限校验方式：
     *          1、编程式：subject.hasRole  hasRoles .......
     *          2、标签式
     *                  标签库
     *          3、注解式
     */


    //获取授权信息方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //System.out.println("授权信息查询库表了");


        String username = (String) principalCollection.getPrimaryPrincipal();

        List<Role> hasRoles = userPermissionService.findHasRoles(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        for (Role role : hasRoles) {
            info.addRole(role.getRole_tag());
        }

        List<Permission> hasPermissions = userPermissionService.findHasPermissions(username);
        for (Permission permission : hasPermissions) {
            info.addStringPermission(permission.getPermission_tag());
        }


        return info;
    }

    //获取认证信息方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String username = usernamePasswordToken.getUsername();


        Admin admin = adminService.login(username);

        if (admin!=null){
            return new SimpleAuthenticationInfo(admin.getMgr_name(),
                    admin.getMgr_pwd(), ByteSource.Util.bytes(admin.getSalt()),
                    admin.getMgr_id());
        }
        return null;
    }
}
