package com.javaxiaodi.springapi.controller;

import com.javaxiaodi.springapi.entity.Message;
import com.javaxiaodi.springapi.entity.User;
import com.javaxiaodi.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: Xiaodi Tao
 * @className: UserController
 * @packageName: controller
 * @description: This is the class for api related with user management
 * @data: 2019-10-25
 **/
@RestController
public class UserController {

    @Autowired
    UserService userService;
    // This register mothod will have username, password, password2, emailAddress as parameters,
    // it will return a Message object which contains the http status code, and descriptions
    @PostMapping("/user/register")
    public Message register(@RequestParam("username") String username, @RequestParam("password")
            String password, @RequestParam("password2") String password2,
                            @RequestParam("emailAddress") String emailAddress){
        Message message = new Message();
        //Validate the form, when it has empty input
        if(username.isEmpty()||password.isEmpty()||password2.isEmpty()||emailAddress.isEmpty()){
            message.setCode(400);
            message.setMessageDetails("Username, Password and emailAddress can not be empty");
            return message;
        }
        //Validate the form, when the two passwords cannot be matched up
        if(!password.equals(password2)){
            message.setCode(400);
            message.setMessageDetails("Password and password2 is not the same");
            return message;
        }
        //Validate the form, if the password or username length() is larger than 45, then it is invalid
        if(password.length()>45 || username.length()>45) {
            message.setCode(400);
            message.setMessageDetails("Password or username length out of bound");
            return message;
        }
        // Get all the user objects from database
        List<User> users = userService.findUerByName(username);
        // If the username hasn't been registered, create the user,
        // store it in databse
        if(users.size()==0){
            User registers=new User();
            registers.setPassword(password);
            registers.setUsername(username);
            registers.setEmailAddress(emailAddress);
            userService.save(registers);
            userService.sendRegisterEmail(registers);
            message.setCode(200);
            message.setMessageDetails("Register successfully!");
        }
        // If the username has already been registered, return error message
        else {
            message.setCode(400);
            message.setMessageDetails("The username has already been used");
        }
        return message;
      }

    // Return all the user objects
    @GetMapping(value = "user/all")
    public List<User> find(){
        return userService.findAll();
    }

    // This method will make the user to login
    @PostMapping(value = "/user/login")
    public Message login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         HttpSession session){
        Message message = new Message();
        //Validate the form, if the input is empty, return error message
        if(username==null || username.length()==0 || password==null || password.length() ==0) {
            message.setCode(400);
            message.setMessageDetails("Username or password cannot be empty");
            return message;
        }
        //Validate the form, if the input has length out of bound, return error message
        if(password.length()>45 || username.length()>45) {
            message.setCode(400);
            message.setMessageDetails("Password or username length out of bound");
            return message;
        }
        // Get all the user objects from database
        List<User> list = userService.findUerByName(username);
        // If the user hasn't been registered, return error message
        if(list.size() == 0) {
            message.setCode(400);
            message.setMessageDetails("The user has not been registered");
            return message;
        }
        // If the user has duplicated records, return error message
        if(list.size()>1) {
            message.setCode(400);
            message.setMessageDetails("The username has duplicates in database");
            return message;
        }
        // If the user is valid, set his session
        User user = list.get(0);
        String passwordValid = user.getPassword();
        if (password.equals(passwordValid)) {
            message.setCode(200);
            message.setMessageDetails("Login Successfully!");
            session.setAttribute("loginUser",username);
            return message;
        }else {
            message.setCode(400);
            message.setMessageDetails("The password is not correct");
            return message;
        }

    }
}
