package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/8.
 */
public interface ArticleDao {

    /*
       创建文章
     */
    public void insertArticle(Article article);

    /*
        文章管理
     */
    public List<Article> selectByPage(@Param("page")Integer pagem, @Param("rows") Integer rows);

    public int updateArticle(Article article);

    public int allRows();
}
