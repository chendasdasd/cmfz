package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 陈少 on 2018/7/8.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void addArticle(Article article) {

        String uuid= UUID.randomUUID().toString().replaceAll("-", "");
        article.setArticle_id(uuid);

        articleDao.insertArticle(article);
    }

    @Override
    public Map<String, Object> showByPage(Integer page, Integer rows) {

        HashMap<String, Object> map = new HashMap<>();

        List<Article> articles = articleDao.selectByPage((page-1)*rows, rows);
        int allRows = articleDao.allRows();

        map.put("rows",articles);
        map.put("total",allRows);

        return map;
    }

    @Override
    public void changeArticle(Article article) {

        articleDao.updateArticle(article);

    }
}
