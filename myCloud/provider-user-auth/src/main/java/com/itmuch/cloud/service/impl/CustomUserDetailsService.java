package com.itmuch.cloud.service.impl;

import com.itmuch.cloud.model.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by ZC-16-012 on 2018/12/20.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    /**
    * 模拟2个账号：
     * 第一个账号是user,密码是password1,角色是user-role
     * 第二个账号是admin,密码是password2,角色是admin-role
    * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)){
           return new SecurityUser("user","password1","user-role");
        }else if ("admin".equals(username)){
            return new SecurityUser("admin","password2","admin-role");
        }else {
            return null;
        }

    }
}
