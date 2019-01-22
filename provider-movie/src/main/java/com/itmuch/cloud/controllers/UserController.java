package com.itmuch.cloud.controllers;

import com.itmuch.cloud.dao.UserDao;
import com.itmuch.cloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZC-16-012 on 2018/12/19.
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;


    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userDao.findOne(id);
    }
}
