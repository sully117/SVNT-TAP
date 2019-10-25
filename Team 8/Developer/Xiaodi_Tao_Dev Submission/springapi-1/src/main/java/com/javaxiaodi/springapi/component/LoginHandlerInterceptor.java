package com.javaxiaodi.springapi.component;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author: Xiaodi Tao
 * @className: LoginHandlerInterceptor
 * @packageName: component
 * @description: This is the login handler class,
 * if the user does not login, he cannot use other functions
 * @data: 2019-10-25
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * @methodsName: preHandle
     * @description: Handle the cases before the target function is called
     * @param: HttpServletRequest request
     * @param: HttpServletResponse response
     * @param: Object handler
     * @return: boolean, if the user already login
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        org.slf4j.Logger Logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
        Object user = request.getSession().getAttribute("loginUser");
        // If we cannot get the user's session, it means he didn't login
        // go back to the login page
        if(user == null){
            Logger.info("The user didn't login, please login");
            return false;
        }else{
            // The user already login
            return true;
        }

    }

    // Post handler is used after the target method being called
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        org.slf4j.Logger Logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
        Logger.info("The user didn't login, please login");
    }
    // After completion is used after completion
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        org.slf4j.Logger Logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
        Logger.info("The user didn't login, please login");
    }
}

