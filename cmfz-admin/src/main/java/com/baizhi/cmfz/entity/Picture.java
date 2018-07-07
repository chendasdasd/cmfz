package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 陈少 on 2018/7/6.
 */
public class Picture implements Serializable {

    private String picture_id;
    private String picture_path;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date picture_date;
    private String picture_desc;
    private String picture_status;


    public Picture() {
    }

    public Picture(String picture_id, String picture_path, Date picture_date, String picture_desc, String picture_status) {
        this.picture_id = picture_id;
        this.picture_path = picture_path;
        this.picture_date = picture_date;
        this.picture_desc = picture_desc;
        this.picture_status = picture_status;
    }

    public String getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(String picture_id) {
        this.picture_id = picture_id;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public Date getPicture_date() {
        return picture_date;
    }

    public void setPicture_date(Date picture_date) {
        this.picture_date = picture_date;
    }

    public String getPicture_desc() {
        return picture_desc;
    }

    public void setPicture_desc(String picture_desc) {
        this.picture_desc = picture_desc;
    }

    public String getPicture_status() {
        return picture_status;
    }

    public void setPicture_status(String picture_status) {
        this.picture_status = picture_status;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picture_id='" + picture_id + '\'' +
                ", picture_path='" + picture_path + '\'' +
                ", picture_date=" + picture_date +
                ", picture_desc='" + picture_desc + '\'' +
                ", picture_status='" + picture_status + '\'' +
                '}';
    }
}
