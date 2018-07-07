package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 陈少 on 2018/7/6.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Override
    public Map<String, Object> findAll(Integer nowPage, Integer pageIndex) {

        Integer begin=(nowPage-1)*pageIndex;

        List<Picture> pictures = pictureDao.selectAll(begin, pageIndex);

        int allRows = pictureDao.selectAllRows();
        HashMap<String, Object> map = new HashMap<>();

        map.put("total",allRows);
        map.put("rows",pictures);

        return map;
    }

    @Override
    public void addPicture(Picture picture) {
        String uuid= UUID.randomUUID().toString().replaceAll("-", "");

        picture.setPicture_id(uuid);

        pictureDao.insertPic(picture);
    }

    @Override
    public void updatePicture(String p_id, String p_desc, String p_status) {
        pictureDao.updatePic(p_id, p_desc, p_status);
    }
}
