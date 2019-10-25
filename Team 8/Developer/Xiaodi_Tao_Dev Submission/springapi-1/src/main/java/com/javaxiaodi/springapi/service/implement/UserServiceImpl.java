package com.javaxiaodi.springapi.service.implement;

import com.javaxiaodi.springapi.entity.User;
import com.javaxiaodi.springapi.repository.UserRepository;
import com.javaxiaodi.springapi.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author: Xiaodi Tao
 * @className: TicketServiceImpl
 * @packageName: service.implement
 * @description: This is the implementation for TicketService
 * @data: 2019-10-25
 **/
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JavaMailSenderImpl mailSender;
    // send email to the user when he is registering
    @Override
    public void sendRegisterEmail(User user){
        org.slf4j.Logger Logger = LoggerFactory.getLogger(UserServiceImpl.class);
        try{
            // set up the content, subject, emailAdress of the email
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("Hi from spring boot Xiaodi");
            simpleMailMessage.setText("You are registering ...");
            simpleMailMessage.setTo(user.getEmailAddress());
            simpleMailMessage.setFrom("racheltao666666@gmail.com");
            // send the email
            mailSender.send(simpleMailMessage);
        }catch (MailException e){
            Logger.info("Email sending error");
        }

    }
    // select all the User objects with the username
    @Override
    public List<User> findUerByName(String username) {
        return userRepository.findUerByName(username);
    }
    // save user object
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    // select all the User objects, caching
    @Override
    @Cacheable(cacheNames = {"user"})
    public List<User> findAll() {
        List<User> user = userRepository.findAll();
        return user;
    }
    //    @Override
    //    public List<User> findByUsernameAndPassword(String username, String password) {
    //        return registerRepository.findByUsernameAndPassword(username, password);
    //    }

}