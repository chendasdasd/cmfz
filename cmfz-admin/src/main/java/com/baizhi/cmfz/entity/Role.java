package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by 陈少 on 2018/7/12.
 */
public class Role implements Serializable {

    private String role_id;
    private String role_name;
    private String role_tag;

    public Role() {
    }

    public Role(String role_id, String role_name, String role_tag) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_tag = role_tag;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_tag() {
        return role_tag;
    }

    public void setRole_tag(String role_tag) {
        this.role_tag = role_tag;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id='" + role_id + '\'' +
                ", role_name='" + role_name + '\'' +
                ", role_tag='" + role_tag + '\'' +
                '}';
    }
}
