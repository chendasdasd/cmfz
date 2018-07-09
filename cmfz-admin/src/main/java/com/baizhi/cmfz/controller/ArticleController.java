package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.MasterService;
import org.apache.commons.io.FilenameUtils;
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
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 陈少 on 2018/7/8.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private MasterService masterService;

    @RequestMapping("/addArticle")
    @ResponseBody
    public void addArticle(Article article){

        String master_name = masterService.findOne(article.getMaster_id());

        article.setMaster_name(master_name);

        if (article.getStatus()==null){
            article.setStatus("off");
        }

        articleService.addArticle(article);

    }

    @RequestMapping("/uploadPic")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException { // MultipartFile[] 代表多文件上传
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString().replace("-", "")+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/upload/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }



    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String ,Object> showAll(@RequestParam("page")Integer nowPage,@RequestParam("rows")Integer pageSize){

        Map<String, Object> map = articleService.showByPage(nowPage, pageSize);

       /* for (Map.Entry<String,Object> entry :map.entrySet()) {
            System.out.println(entry);
        }*/

        return map;

    }

    @RequestMapping("/changeArticle")
    @ResponseBody
    public void changeArticle(Article article){
        articleService.changeArticle(article);
    }

}

