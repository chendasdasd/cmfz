package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Logbook;

import java.util.Map;

/**
 * Created by 陈少 on 2018/7/9.
 */
public interface LogbookService {

    public void addLogbook(Logbook logbook);

    public Map<String ,Object> showByPage(Integer page,Integer rows);

}
