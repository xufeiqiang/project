package com.itmuch.cloud.controllers;

import com.itmuch.cloud.dao.UserDao;
import com.itmuch.cloud.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by ZC-16-012 on 2018/12/19.
 */
@RestController
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;


    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
      //获取当前用户
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      if (principal instanceof UserDetails){
          UserDetails userDetails= (UserDetails) principal;
          Collection<? extends GrantedAuthority>  grantedAuthorities= userDetails.getAuthorities();
          for (GrantedAuthority grantedAuthority: grantedAuthorities){
              logger.info("当前用户是{},角色是{}",userDetails.getUsername(),grantedAuthority.getAuthority());
          }
      }else {
          logger.warn("没有获取到当前任何用户和角色...");
      }
      return userDao.findOne(id);
    }


}
