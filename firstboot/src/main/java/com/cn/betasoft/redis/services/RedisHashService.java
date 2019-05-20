package com.cn.betasoft.redis.services;

import com.cn.betasoft.redis.model.Response;

import java.util.Map;

/**
 * Created by ZC-16-012 on 2018/8/3.
 */
public interface RedisHashService {
    /**
    * redis-cli hmset命令
    * */
    public Response hmset(String key ,Map map);


    /**
    * redis-cli hgetall命令
    * */
    public Map hgetAll(String key);
  }
