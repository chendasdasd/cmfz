package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.Map;

/**
 * Created by 陈少 on 2018/7/8.
 */
public interface ArticleService {

    public void addArticle(Article article);

    /*
        文章管理
     */
    public Map<String ,Object> showByPage(Integer page, Integer rows);

    public void changeArticle(Article article);
}
