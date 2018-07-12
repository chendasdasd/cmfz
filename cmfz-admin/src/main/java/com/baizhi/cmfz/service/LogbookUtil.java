package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Logbook;
import com.baizhi.cmfz.entity.Picture;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by 陈少 on 2018/7/9.
 */
@Aspect
public class LogbookUtil {

    public String id;

    @Autowired
    private LogbookService logbookService;
    @Autowired
    private MasterService masterService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private AdminService adminService;


    /*
        管理员登录方法的切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.AdminServiceImpl.login(..))")
    public void loginCell(){}

    /*
        添加业务逻辑方法切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.add*(..))")
    public void insertCell(){}

    /*
        修改业务逻辑方法切入点
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.change*(..))")
    public void updateCell(){}

    /**
     * 登录操作（后置通知）
     * @Param joinPoint
     * @Param object
     * @Param Throwable
     */
    @AfterReturning(value = "loginCell()",argNames = "joinPoint,object",returning ="object" )
    public void loginLog(JoinPoint joinPoint,Object object)throws Throwable{

        Admin admin=(Admin)object;
        if (admin==null){
            return;
        }

        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();

        Logbook logbook=new Logbook();
        id= UUID.randomUUID().toString().replaceAll("-", "");
        logbook.setId(id);
        logbook.setMessage(args[0].toString());
        logbook.setUserName(admin.getMgr_name());
        logbook.setResource("Admin");
        logbook.setAction("登录");
        logbook.setResult("success");
        logbookService.insertLogbook(logbook);
    }


    /**
     * 添加操作日志（后置通知）
     * @Param joinPoint
     * @Param object
     */

    @AfterReturning(value = "insertCell()",argNames ="joinPoint,object",returning ="object" )
    public void insertLog(JoinPoint joinPoint, Object object){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        if (joinPoint.getArgs()==null){
            return;
        }

        //获取方法名
        String methodName = joinPoint.getSignature().getName();

        //获取参数
        Object[] args = joinPoint.getArgs();

         id= UUID.randomUUID().toString().replaceAll("-", "");
         Logbook logbook=new Logbook();
         logbook.setId(id);
         logbook.setMessage(args[0].toString());
         Admin admin = (Admin) session.getAttribute("admin");

         if (admin!=null){
             logbook.setUserName(admin.getMgr_name());
         }
         logbook.setAction("添加");
         logbook.setResult("success");
         logbook.setResource(methodName.substring(3));

        System.out.println(logbook.toString());


         logbookService.insertLogbook(logbook);
    }


    /**
     * 管理员修改操作日志(后置通知)
     */
    @Around( "updateCell()")
    public Object updateLog(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取操作内容
        //String opContent = optionContent(joinPoint.getArgs(), methodName);

        // 创建日志对象
        id= UUID.randomUUID().toString().replaceAll("-", "");
        Admin admin = (Admin) session.getAttribute("admin");


        //获取参数
        Object[] args = joinPoint.getArgs();

        Logbook logbook=new Logbook();
        logbook.setMessage(args[0].toString());
        logbook.setId(id);
        if (admin!=null){
            logbook.setUserName(admin.getMgr_name());
        }
        logbook.setAction("修改");
        logbook.setResult("success");
        logbook.setResource(methodName.substring(6));

        logbookService.insertLogbook(logbook);

        return joinPoint.proceed();
        
    }

}
