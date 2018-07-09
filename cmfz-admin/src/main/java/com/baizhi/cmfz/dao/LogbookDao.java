package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Logbook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/9.
 */
public interface LogbookDao {

    public void insertLogbook(Logbook logbook);

    public List<Logbook> selectAll(@Param("page") Integer page,@Param("rows") Integer rows);

}
