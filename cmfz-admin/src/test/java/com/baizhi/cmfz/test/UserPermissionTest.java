package com.baizhi.cmfz.test;

import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.UserPermissionService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/12.
 */
public class UserPermissionTest {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserPermissionService userPermissionServiceImpl = (UserPermissionService) classPathXmlApplicationContext.getBean("userPermissionServiceImpl");

        List<Role> hasRoles = userPermissionServiceImpl.findHasRoles("Curry");

        for (Role hasRole : hasRoles) {
            System.out.println(hasRole.toString());
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++");

        List<Permission> hasPermissions = userPermissionServiceImpl.findHasPermissions("Curry");

        for (Permission hasPermission : hasPermissions) {
            System.out.println(hasPermission.toString());
        }
    }
}
