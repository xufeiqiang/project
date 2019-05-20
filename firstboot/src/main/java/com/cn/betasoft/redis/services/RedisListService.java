package com.cn.betasoft.redis.services;

import com.cn.betasoft.redis.model.Response;

import java.util.Collection;
import java.util.List;

/**
 * Created by ZC-16-012 on 2018/8/1.
 *
 * redis-cli 操作list的 api拓展
 */
public interface RedisListService {

    /**
    * redis-cli lpush 命令
    * */
    public Response lpushAll(String key,Collection<String> list);


    /**
    * redis-cli lpop命令
    * */

    public Object lpop(String key);

    /**
    * redis-cli lrange命令
     * @param start list 开始位置
     * @param end list 结果位置,为-1 时表示list的最后一个元素
     *
    * */
    public List lrange(String key,long start,long end);
  }
