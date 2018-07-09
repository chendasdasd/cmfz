package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 陈少 on 2018/7/8.
 */
public class Article implements Serializable {
    private String article_id;
    private String article_name;
    private String introduce;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    private String master_id;
    private String master_name;
    private String status;

    public Article() {
    }


    public Article(String article_id, String article_name, String introduce, Date date, String master_id, String master_name, String status) {
        this.article_id = article_id;
        this.article_name = article_name;
        this.introduce = introduce;
        this.date = date;
        this.master_id = master_id;
        this.master_name = master_name;
        this.status = status;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
