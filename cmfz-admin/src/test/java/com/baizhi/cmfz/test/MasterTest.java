package com.baizhi.cmfz.test;

import com.baizhi.cmfz.service.MasterService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by 陈少 on 2018/7/6.
 */
public class MasterTest {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        MasterService masterService= (MasterService) ctx.getBean("masterServiceImpl");

        Map<String, Object> allMaster = masterService.findAllMaster(0, 5, "");

        for (Map.Entry<String ,Object> entry: allMaster.entrySet() ) {
            System.out.println(entry);
        }
    }
}


