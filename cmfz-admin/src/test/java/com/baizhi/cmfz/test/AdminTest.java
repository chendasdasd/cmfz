package com.baizhi.cmfz.test;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 陈少 on 2018/7/5.
 */
public class AdminTest {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        AdminService as= (AdminService) ctx.getBean("adminServiceImpl");

        Admin admin=new Admin(null,"Curry","123456",null,"0");

        as.register(admin);
    }

    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        AdminService as= (AdminService) ctx.getBean("adminServiceImpl");

        Admin admin = as.login("Curry", "123456");

        System.out.println(admin);

    }
}
