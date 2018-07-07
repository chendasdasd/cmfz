package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/6.
 */
public interface MasterDao {

    public List<Master> selectAll(@Param("begin")Integer begin,@Param("rows")Integer rows,@Param("word") String word);

    public int selectAllRows(String word);

    public void insertMaster(Master master);

    public void updateMaster(Master master);

}
