package com.cn.betasoft.redis.services.impl;

import com.cn.betasoft.redis.model.Response;
import com.cn.betasoft.redis.services.RedisSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;

/**
 * Created by ZC-16-012 on 2018/8/7.
 */
public class RedisSetServiceImpl implements RedisSetService{

    @Autowired
    private SetOperations opsForSet;

    @Override
    public Response sadd() {
        try {

        }catch (Exception e){

        }
        return null;
    }
}
