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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
    public String login(String mgr_name ,String cbx, String mgr_pwd,
                        String insertCode, HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException {

        String code = (String) session.getAttribute("code");

        if (code.equals(insertCode)){
            Admin admin = adminService.login(mgr_name, mgr_pwd);
            if (admin!=null){

                if (cbx!=null){
                    Cookie cookie = new Cookie("username", URLEncoder.encode(mgr_name,"UTF-8"));
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }else{
                    Cookie cookie = new Cookie("username", URLEncoder.encode(mgr_name,"UTF-8"));
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

                session.setAttribute("admin",admin);
                return "forward:/main/main.jsp";
            }
        }
       return "redirect:/login.jsp";
    }

    @RequestMapping("/updatePwd")
    @ResponseBody
    public void updatePwd(String mgr_pwd,HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");

        String mgr_id = admin.getMgr_id();

       /*
       System.out.println(mgr_id);
        System.out.println(mgr_pwd);
        */

        adminService.changePwd(mgr_id,mgr_pwd);


    }

}
