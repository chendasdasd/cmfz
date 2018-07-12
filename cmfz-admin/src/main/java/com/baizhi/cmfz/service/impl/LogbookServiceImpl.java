package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogbookDao;
import com.baizhi.cmfz.entity.Logbook;
import com.baizhi.cmfz.service.LogbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 陈少 on 2018/7/9.
 */
@Service
@Transactional
public class LogbookServiceImpl implements LogbookService {

    @Autowired
    private LogbookDao logbookDao;


    @Override
    public void insertLogbook(Logbook logbook) {
        logbookDao.insertLogbook(logbook);
    }

    @Override
    public Map<String, Object> showByPage(Integer page, Integer rows) {

        HashMap<String, Object> map = new HashMap<>();

        List<Logbook> logbooks = logbookDao.selectAll((page - 1) * rows, rows);
        int allRows = logbookDao.allRows();

        map.put("rows",logbooks);
        map.put("total",allRows);

        return map;
    }
}
