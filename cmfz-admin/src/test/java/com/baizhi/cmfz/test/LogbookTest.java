package com.baizhi.cmfz.test;

import com.baizhi.cmfz.entity.Logbook;
import com.baizhi.cmfz.service.LogbookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 陈少 on 2018/7/9.
 */
public class LogbookTest {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        LogbookService logbookService = (LogbookService) ctx.getBean("logbookServiceImpl");

        System.out.println(logbookService);
        //Logbook logbook = new Logbook("aaaaa",null,null,null,null,null,null);
        //logbookService.insertLogbook(logbook);
    }

    @Test
    public void test2(){
        String methodName="changeAdmin";
        String s = methodName.substring(6);
        System.out.println(s);
    }
}
