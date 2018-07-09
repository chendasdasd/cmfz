package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 陈少 on 2018/7/6.
 */
@Controller
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    private PictureService pis;

    @RequestMapping("/allPicture")
    @ResponseBody
    public Map<String ,Object> showAllPic(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageIndex){
        return pis.findAll(nowPage,pageIndex);
    }

    @RequestMapping("/addPicture")
    @ResponseBody
    public void addaPicture(String picture_desc, String picture_status, MultipartFile picFile,
                            HttpServletRequest request, HttpSession session) throws IOException {

        String realPath = request.getRealPath("");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String substring = realPath.substring(0, lastIndexOf);
        String uploadPath = substring+"\\upload";

        String uuidName= UUID.randomUUID().toString().replace("-", "");

        //截取文件本身的后缀名
        String oldName=picFile.getOriginalFilename();
        String suffix=oldName.substring(oldName.lastIndexOf("."));

        picFile.transferTo(new File(uploadPath+"/"+uuidName+suffix));

        Picture picture = new Picture(uuidName,uuidName+suffix,null,picture_desc,picture_status);

        pis.addPicture(picture);
    }

    @RequestMapping("changePicture")
    @ResponseBody
    public String changePicture(String picture_id,String picture_desc,String picture_status){

        pis.changePicture(picture_id, picture_desc, picture_status);

        return "success";
    }
}
