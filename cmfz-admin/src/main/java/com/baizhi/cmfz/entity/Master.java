package com.baizhi.cmfz.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by 陈少 on 2018/7/6.
 */
public class Master implements Serializable{

    @Excel(name="上师编号")
    private String master_id;
    @Excel(name="上师法名")
    private String master_name;
    @Excel(name="上师头像")
    private String master_photo;
    @Excel(name="上师简介")
    private String introduce;

    public Master() {
    }

    public Master(String master_id, String master_name, String master_photo, String introduce) {
        this.master_id = master_id;
        this.master_name = master_name;
        this.master_photo = master_photo;
        this.introduce = introduce;
    }

    public String getMaster_id() {
        return master_id;
    }

    public void setMaster_id(String master_id) {
        this.master_id = master_id;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    public String getMaster_photo() {
        return master_photo;
    }

    public void setMaster_photo(String master_photo) {
        this.master_photo = master_photo;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Master{" +
                "master_id='" + master_id + '\'' +
                ", master_name='" + master_name + '\'' +
                ", master_photo='" + master_photo + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
