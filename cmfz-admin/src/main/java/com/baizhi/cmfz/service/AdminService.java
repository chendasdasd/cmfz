package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;

/**
 * Created by 陈少 on 2018/7/5.
 */
public interface AdminService {

    public void register(Admin admin);

    public Admin login(String name);

    public void changeAdmin(String mgr_id,String newPwd);
}
