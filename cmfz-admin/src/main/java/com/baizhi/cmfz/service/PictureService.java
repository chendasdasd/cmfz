package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;

/**
 * Created by 陈少 on 2018/7/6.
 */
public interface PictureService {

    public Map<String ,Object> findAll(Integer begin,Integer rows);

    public int addPicture(Picture picture);

    public int changePicture(String p_id,String p_desc,String p_status);

}
