package com.cn.betasoft.redis.services;

import com.cn.betasoft.redis.model.Response;

/**
 * Created by ZC-16-012 on 2018/8/7.
 */
public interface RedisSetService {

    /**
    * redis-cli sadd命令
    * */
   public Response sadd();
 }
