package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 陈少 on 2018/7/9.
 */
public class Logbook implements Serializable{
    private String id;
    private String userName;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date actionTime;
    private String resource;
    private String action;
    private String message;
    private String result;

    public Logbook() {
    }

    public Logbook(String id, String userName, Date actionTime, String resource, String action, String message, String result) {
        this.id = id;
        this.userName = userName;
        this.actionTime = actionTime;
        this.resource = resource;
        this.action = action;
        this.message = message;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
