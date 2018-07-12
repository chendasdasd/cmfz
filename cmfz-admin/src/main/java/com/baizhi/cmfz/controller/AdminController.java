package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.utils.ValidateCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    public String login(String mgr_name ,boolean rememberMe, String mgr_pwd,
                        String insertCode, HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException {

        String code = (String) session.getAttribute("code");

        Subject subject = SecurityUtils.getSubject();

        if (code.equals(insertCode)){

            try {
                subject.login(new UsernamePasswordToken(mgr_name,mgr_pwd,rememberMe));

                return "forward:/main/main.jsp";
            }catch (UnknownAccountException e) {
                e.printStackTrace();
                return "redirect:/login.jsp";
            } catch (IncorrectCredentialsException ice){
                ice.printStackTrace();
                return "redirect:/login.jsp";
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return "redirect:/login.jsp";
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

        adminService.changeAdmin(mgr_id,mgr_pwd);


    }

}
