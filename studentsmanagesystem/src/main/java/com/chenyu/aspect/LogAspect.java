package com.chenyu.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * Author chenyu
 * 2017/9/18 16:58
 */
@Aspect
@Component
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.chenyu.web.LoginController.loginPost(..))")
    public void logMsg() {


    }

    @Before("logMsg()")
    public void doBefore() {

        logger.info("准备登录");
    }

    @Pointcut("execution(* com.chenyu.web.LoginController.logout(..))")
    public void logoutMsg(){


    }
    @Before("logoutMsg()")
    public void logoutBefore(){

        logger.info("准备登出");
    }
    /*After("execution(* com.chenyu.web.LoginController.loginPost(..))")
    public void doAfter(){
        System.out.println("登录完成");
    }*/
}

