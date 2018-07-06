package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by 陈少 on 2018/7/5.
 */
public class Admin implements Serializable {

    private String mgr_id;
    private String mgr_name;
    private String mgr_pwd;
    private String salt;
    private String status;

    public Admin() {
    }

    public Admin(String mgr_id, String mgr_name, String mgr_pwd, String salt, String status) {
        this.mgr_id = mgr_id;
        this.mgr_name = mgr_name;
        this.mgr_pwd = mgr_pwd;
        this.salt = salt;
        this.status = status;
    }

    public String getMgr_id() {
        return mgr_id;
    }

    public void setMgr_id(String mgr_id) {
        this.mgr_id = mgr_id;
    }

    public String getMgr_name() {
        return mgr_name;
    }

    public void setMgr_name(String mgr_name) {
        this.mgr_name = mgr_name;
    }

    public String getMgr_pwd() {
        return mgr_pwd;
    }

    public void setMgr_pwd(String mgr_pwd) {
        this.mgr_pwd = mgr_pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "mgr_id='" + mgr_id + '\'' +
                ", mgr_name='" + mgr_name + '\'' +
                ", mgr_pwd='" + mgr_pwd + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
