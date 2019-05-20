package com.cn.betasoft.redis.services.impl;

import com.cn.betasoft.redis.model.Response;
import com.cn.betasoft.redis.services.RedisStringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZC-16-012 on 2018/7/31.
 *
 *
 */
@Service
public class RedisStringServiceImpl implements RedisStringService {

    @Autowired
    private ValueOperations opsForValue;

    @Autowired
    private RedisTemplate redisTemplate;

    private Logger logger= LoggerFactory.getLogger(RedisStringServiceImpl.class);



    @Override
    public Response set(String key, Object value) {
        try {
            opsForValue.set(key,value);
            return new Response(true,"redis添加数据成功 key="+key);
        }catch (Exception e){
            logger.error("保存缓存失败，key="+key,e);
            return new Response(false,"redis添加数据失败 key="+key);
        }
    }


    @Override
    public Object get(String key) {
        Object value = null;
        try {
            value = opsForValue.get(key);
        }catch (Exception e){
            logger.error("通过redis的key获取value失败,key="+key+e);
        }

        return value;
    }

    @Override
    public Response del(String key) {
        try {
            redisTemplate.delete(key);
            return new Response(true,"redis根据key删除数据成功,key="+key);
        }catch (Exception e){
            logger.error("删除缓存失败，key="+key,e);
            return new Response(false,"edis根据key删除数据失败,key="+key);
        }

    }

    @Override
    public Response del(Collection<String> keys) {
        try {
            redisTemplate.delete(keys);
            return new Response(true,"redis批量删除数据成功,key="+keys);
        }catch (Exception e){
            logger.error("删除缓存失败，key="+keys,e);
            return new Response(false,"redis批量删除数据失败,key="+keys);
        }
    }

    @Override
    public Response expire(String key, long time, TimeUnit timeUnit) {
        try {
            redisTemplate.expire(key,time,timeUnit);
            return new Response(true,"redis设置key的生命周期成功,key="+key+"|" +time+timeUnit+"到期");
        }catch (Exception e){
            logger.error("设置redis key的生命周期失败,key="+key,e);
            return new Response(false,"redis设置key的生命周期失败,key="+key);
        }
    }

    @Override
    public Response expireAt(String key, Date date) {
        try {
            redisTemplate.expireAt(key,date);
            String time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            return new Response(true,"redis设置key的生命周期成功,key="+key+"|" +time+"到期");
        }catch (Exception e){
            return new Response(false,"redis设置key的生命周期失败,key="+key);
        }
    }
}
