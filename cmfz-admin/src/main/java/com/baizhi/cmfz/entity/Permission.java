package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by 陈少 on 2018/7/12.
 */
public class Permission implements Serializable {

    private String permission_id;
    private String permission_name;
    private String permission_tag;

    public Permission() {
    }

    public Permission(String permission_id, String permission_name, String permission_tag) {
        this.permission_id = permission_id;
        this.permission_name = permission_name;
        this.permission_tag = permission_tag;
    }

    public String getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(String permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public String getPermission_tag() {
        return permission_tag;
    }

    public void setPermission_tag(String permission_tag) {
        this.permission_tag = permission_tag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permission_id='" + permission_id + '\'' +
                ", permission_name='" + permission_name + '\'' +
                ", permission_tag='" + permission_tag + '\'' +
                '}';
    }
}
