package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.MasterService;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
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
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 陈少 on 2018/7/6.
 */
@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @RequestMapping("/showByPage")
    @ResponseBody
    public Map<String,Object> showByPage(@RequestParam("page")Integer nowPage , @RequestParam("rows") Integer pageIndex,
                                         HttpServletRequest request){

        String likeWord = request.getParameter("value");

        if (likeWord!=null){
            return masterService.findAllMaster(nowPage,pageIndex,likeWord);
        }
        return masterService.findAllMaster(nowPage,pageIndex,"");

    }


    @RequestMapping("/addMaster")
    @ResponseBody
    public void addMaster(String master_name, String introduce, MultipartFile masterPhoto,
                          HttpServletRequest request, HttpSession session) throws IOException {

        String realPath = request.getRealPath("");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String substring = realPath.substring(0, lastIndexOf);
        String uploadPath = substring+"\\upload";

        String uuidName= UUID.randomUUID().toString().replace("-", "");

        //截取文件本身的后缀名
        String oldName=masterPhoto.getOriginalFilename();
        String suffix=oldName.substring(oldName.lastIndexOf("."));

        masterPhoto.transferTo(new File(uploadPath+"/"+uuidName+suffix));

        Master master = new Master(uuidName, master_name, uuidName + suffix, introduce);

        masterService.addMaster(master);
    }


    @RequestMapping("/changeMaster")
    @ResponseBody
    public String changeMaster(Master master){

        masterService.changeMaster(master);

        return "changeSuccess";
    }

    @RequestMapping("/batchMaster")
    @ResponseBody
    public void batchMaster(MultipartFile excelFile,HttpServletRequest request) throws Exception {

        ImportParams params = new ImportParams();

        //表格标题（默认为0） 但是如果设置标题，九设为一
        params.setTitleRows(1);
        //设置表头
        params.setHeadRows(1);

        //是否保存上传的Excel
        params.setNeedSave(false);


        /*
        String realPath = request.getRealPath("");
        int lastIndexOf = realPath.lastIndexOf("\\");
        String substring = realPath.substring(0, lastIndexOf);
        String uploadPath = substring+"\\upload";


        File file = new File(uploadPath+"/"+excelFile.getOriginalFilename());
        excelFile.transferTo(file);
        */

        List<Master> masters = ExcelImportUtil.importExcel(excelFile.getInputStream(), Master.class, params);

        for (Master master : masters) {
            masterService.addMaster(master);
        }

    }
}
