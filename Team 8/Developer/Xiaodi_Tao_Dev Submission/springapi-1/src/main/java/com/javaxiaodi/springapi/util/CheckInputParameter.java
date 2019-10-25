package com.javaxiaodi.springapi.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: Xiaodi Tao
 * @className: CheckInputParameter
 * @packageName: util
 * @description: This class is used for handling SQL Injection
 * @data: 2019-10-25
 **/
@Component
@Aspect
public class CheckInputParameter {

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(CheckInputParameter.class);

    // It has the risk of SQL Injection
    private static final String IS_SQL_INJECTION = "The input parameter may cause SQL Injection";

    private static final String UNVALIDATED_INPUT = "The input is unvalidated";

    private static final String ERORR_INPUT = "Illegal parameter";

    //The Pointcut: All the methods in all the controllers
    @Pointcut("execution(* com.javaxiaodi.springapi.controller..*(..))")
    public void params() {
    }

    /**
     * Define the alert
     * @param joinPoint
     * @throws Throwable
     */
    @Around("params()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object[] args = joinPoint.getArgs();
        String str = String.valueOf(args);
        // Alert the SQL Injection risk
        if (!IllegalStrFilterUtil.sqlStrFilter(str)) {
            Logger.info(IS_SQL_INJECTION);
            new RuntimeException(ERORR_INPUT);
        }
        // Alert the illegal input
        if (!IllegalStrFilterUtil.isIllegalStr(str)) {
            Logger.info(UNVALIDATED_INPUT);
            new RuntimeException(ERORR_INPUT);
        }
        // Log the current api
        Object result = joinPoint.proceed();
        Logger.info("The api being requested...[" + request.getRequestURL() + "]");
        return result;
    }

}
