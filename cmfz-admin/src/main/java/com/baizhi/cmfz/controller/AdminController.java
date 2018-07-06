package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 陈少 on 2018/7/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {

        ValidateCodeUtils utils = new ValidateCodeUtils(80, 30, 1);

        session.setAttribute("code",utils.getCode());
        // System.out.println(utils.getCode());//打印验证码

        utils.write(response.getOutputStream());

    }


    @RequestMapping("/login")
    public String login(String mgr_name , String mgr_pwd, @RequestParam("insertCode") String insertCode, HttpSession session){

        String code = (String) session.getAttribute("code");

        if (code.equals(insertCode)){
            Admin admin = adminService.login(mgr_name, mgr_pwd);
            if (admin!=null){
                session.setAttribute("admin",admin);
                return "forward:/main/main.jsp";
            }
        }
       return "redirect:/login.jsp";
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(String mgr_pwd,HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");

        String mgr_id = admin.getMgr_id();

       /*
       System.out.println(mgr_id);
        System.out.println(mgr_pwd);
        */

        adminService.changePwd(mgr_id,mgr_pwd);

        return "success";
    }

}
