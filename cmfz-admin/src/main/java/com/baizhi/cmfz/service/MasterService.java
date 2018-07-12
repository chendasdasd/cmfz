package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * Created by 陈少 on 2018/7/6.
 */
public interface MasterService {

    public Map<String,Object> findAllMaster(Integer nowPage,Integer pageIndex,String master_name);

    public int addMaster(Master master);

    public int changeMaster(Master master);

    public List<Master> allMaster();

    public String findOne(String master_id);
}
