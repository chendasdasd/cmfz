package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 陈少 on 2018/7/5.
 */
public interface AdminDao {

    public void insertAdmin(Admin admin);

    public Admin selectByName(String name);

    public void updatePwd(@Param("mgr_id") String mgr_id,@Param("salt") String salt,@Param("mgr_pwd") String pwd);
}
