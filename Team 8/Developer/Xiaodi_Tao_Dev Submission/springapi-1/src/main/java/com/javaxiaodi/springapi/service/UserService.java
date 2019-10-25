package com.javaxiaodi.springapi.service;

import com.javaxiaodi.springapi.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author: Xiaodi Tao
 * @className: UserService
 * @packageName: service
 * @description: This is the service for User
 * @data: 2019-10-25
 **/
@Service
public interface UserService {
    // select all the User objects with the username
    List<User> findUerByName(String username);
    // save user object
    void save(User user);
    // select all the User objects, caching
    @Cacheable(cacheNames = {"user"})
    List<User> findAll();
    // send email to the user when he is registering
    void sendRegisterEmail(User user);
    // List<User> findByUsernameAndPassword(String username, String password);
}
