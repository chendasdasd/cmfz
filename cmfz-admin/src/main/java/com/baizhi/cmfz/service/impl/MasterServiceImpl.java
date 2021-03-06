package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 陈少 on 2018/7/6.
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDao masterDao;

    @Override
    public Map<String, Object> findAllMaster(Integer nowPage, Integer pageIndex,String master_name) {
        Integer begin=(nowPage-1)*pageIndex;
        String likeName="%"+master_name+"%";

        List<Master> masters = masterDao.selectAll(begin, pageIndex,likeName);
        int allRows = masterDao.selectAllRows(likeName);

        HashMap<String, Object> map = new HashMap<String,Object>();

        map.put("rows",masters);
        map.put("total",allRows);

        return map;
    }

    @Override
    public int addMaster(Master master) {
        return masterDao.insertMaster(master);
    }

    @Override
    public int changeMaster(Master master) {
        return masterDao.updateMaster(master);
    }

    @Override
    public List<Master> allMaster() {
        return masterDao.selectAllMaster();
    }

    @Override
    public String findOne(String master_id) {
        String master_name = masterDao.selectById(master_id);

        return master_name;
    }

}
