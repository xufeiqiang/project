package com.cn.betasoft.redis.services.impl;

import com.cn.betasoft.redis.model.Response;
import com.cn.betasoft.redis.services.RedisHashService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by ZC-16-012 on 2018/8/3.
 */

@Service
public class RedisHashServiceImpl implements RedisHashService{

    @Autowired
    private HashOperations opsForHash;

    private Logger logger= LoggerFactory.getLogger(RedisHashServiceImpl.class);


    @Override
    public Response hmset(String key ,Map map) {
        try {
            opsForHash.putAll(key,map);
            return new Response(true,"redis添加map数据成功 key="+key);
        }catch (Exception e){
            logger.error("redis 保存map 失败",e);
            return new Response(false,"redis添加map数据失败 key="+key);
        }
    }

    @Override
    public Map hgetAll(String key) {
        Map map = null;
        try {
            map= opsForHash.entries(key);
        }catch (Exception e){
            logger.error("redis通过key取出map失败,key="+key,e);
        }

        return map;
    }
}
