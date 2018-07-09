package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by 陈少 on 2018/7/9.
 */
public class Logbook implements Serializable{
    private String id;
    private String userName;
    private String actionTime;
    private String resource;
    private String action;
    private String message;

    public Logbook() {
    }

    public Logbook(String id, String userName, String actionTime, String resource, String action, String message) {
        this.id = id;
        this.userName = userName;
        this.actionTime = actionTime;
        this.resource = resource;
        this.action = action;
        this.message = message;
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

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
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

    @Override
    public String toString() {
        return "Logbook{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", actionTime='" + actionTime + '\'' +
                ", resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
