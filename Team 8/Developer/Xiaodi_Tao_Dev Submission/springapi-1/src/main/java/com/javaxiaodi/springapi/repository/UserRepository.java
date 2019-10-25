package com.javaxiaodi.springapi.repository;

import com.javaxiaodi.springapi.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * @author: Xiaodi Tao
 * @className: UserRepository
 * @packageName: repository
 * @description: This is the repository for User
 * @data: 2019-10-25
 **/
public interface UserRepository extends CrudRepository<User, Integer> {
    // Select all the User objects with the username
    @Query(value = "select * from test.user where username=?1", nativeQuery = true)
    List<User> findUerByName(String username);
    // Select all Prediction objects in the database
    List<User> findAll();
}

