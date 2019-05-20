package com.cn.betasoft.redis.services;

import com.cn.betasoft.redis.model.Response;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZC-16-012 on 2018/7/31.
 * 通过redisTemplate的 api 拓展方法
 */
public interface RedisStringService {

    /**
    *  redis-cli set命令
    * */
    public Response set(String key, Object value);


    /**
    * redis-cli get 命令
    * */

    public Object get(String key);


    /**
    * redis-cli del 命令
     * 删除key
    * */

   public Response del(String key);

   /**
   *  redis-cli del 命令
    * 批量删除key的集合
   * */
    public Response del(Collection<String> keys);

    /**
    * redis-cli expire命令
     * @param key redis 的key
     * @param time 时间
     * @param  timeUnit 单位
    * */
    public Response expire(String key,long time ,TimeUnit timeUnit);

    /**
    * redis-cli expireAt命令
     * 指定key在指定的日期失效
    * */

    public Response expireAt(String key,Date date);


   }
