package com.baizhi.cmfz.test;

import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.PictureService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 陈少 on 2018/7/6.
 */
public class PictureTest {

   /* @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        PictureService pis= (PictureService) ctx.getBean("pictureServiceImpl");

        Map<String, Object> all = pis.findAll(1, 5);

        for (Map.Entry<String,Object> entry :all.entrySet()) {
            System.out.println(entry);
        }
    }*/

    @Test
    public void test2(){
        String uuid=UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
    }
}
