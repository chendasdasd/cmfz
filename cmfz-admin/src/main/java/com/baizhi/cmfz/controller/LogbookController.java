package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Logbook;
import com.baizhi.cmfz.service.LogbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 陈少 on 2018/7/9.
 */
@Controller
@RequestMapping("/logbook")
public class LogbookController {

    @Autowired
    private LogbookService logbookService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> showByPage(Integer page,Integer rows){

        return logbookService.showByPage(page,rows);
    }

    @RequestMapping("/addLogbook")
    @ResponseBody
    public void addLogbook(Logbook logbook){
        logbookService.addLogbook(logbook);
    }
}
