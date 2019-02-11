package com.itmuch.cloud.service.impl;

import com.itmuch.cloud.model.User;
import com.itmuch.cloud.service.UserFeignClient;
import feign.Param;
import org.springframework.stereotype.Component;

/**
 * Created by ZC-16-012 on 2018/12/24.
 * feign 和 hystrix的整合,实现容错机制
 */
@Component
public class FeignClientFallback implements UserFeignClient {

    @Override
    public User findById( Long id) {
        User user =new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
}
