package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 陈少 on 2018/7/6.
 */
public interface PictureDao {

    public List<Picture> selectAll(@Param("begin") Integer begin,@Param("rows") Integer rows);

    public int selectAllRows();

    public int insertPic(Picture picture);

    public int updatePic(@Param("pic_id") String pic_id,@Param("pic_desc") String pic_desc,@Param("pic_status") String pic_status);
}
