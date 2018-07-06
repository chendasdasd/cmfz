package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈少 on 2018/7/5.
 */
public class Menu implements Serializable {

    private String menu_id;
    private String menu_name;
    private String menu_icon;
    private String menu_url;
    private String menu_level;
    private String menu_parentId;
    private List<Menu> levelTwo=new ArrayList<Menu>();

    public Menu() {
    }

    public Menu(String menu_id, String menu_name, String menu_icon, String menu_url, String menu_level, String menu_parentId, List<Menu> levelTwo) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.menu_icon = menu_icon;
        this.menu_url = menu_url;
        this.menu_level = menu_level;
        this.menu_parentId = menu_parentId;
        this.levelTwo = levelTwo;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getMenu_level() {
        return menu_level;
    }

    public void setMenu_level(String menu_level) {
        this.menu_level = menu_level;
    }

    public String getMenu_parentId() {
        return menu_parentId;
    }

    public void setMenu_parentId(String menu_parentId) {
        this.menu_parentId = menu_parentId;
    }

    public List<Menu> getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(List<Menu> levelTwo) {
        this.levelTwo = levelTwo;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "menu_id='" + menu_id + '\'' +
                ", menu_name='" + menu_name + '\'' +
                ", menu_icon='" + menu_icon + '\'' +
                ", menu_url='" + menu_url + '\'' +
                ", menu_level='" + menu_level + '\'' +
                ", menu_parentId='" + menu_parentId + '\'' +
                ", levelTwo=" + levelTwo +
                '}';
    }
}
