package com.baizhi.cmfz.test;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/5.
 */
public class MenuTest {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        MenuService menuService = (MenuService) ctx.getBean("menuServiceImpl");

        List<Menu> allMenu = menuService.findAllMenu();

        /*for (Menu menu : allMenu) {
            System.out.println(menu);
        }*/

        String s = JSON.toJSONString(allMenu);
        System.out.println(s);

    }
}
