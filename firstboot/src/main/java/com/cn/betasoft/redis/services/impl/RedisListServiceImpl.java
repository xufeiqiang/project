package com.cn.betasoft.redis.services.impl;

import com.cn.betasoft.redis.model.Response;
import com.cn.betasoft.redis.services.RedisListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by ZC-16-012 on 2018/8/1.
 *
 * 操作 redis list列表类型
 */
@Service
public class RedisListServiceImpl implements RedisListService {

    @Autowired
    private ListOperations opsForList;

    private Logger logger= LoggerFactory.getLogger(RedisListServiceImpl.class);

    @Override
    public Response lpushAll(String key,Collection<String> list) {
        try {
            opsForList.leftPushAll(key,list);
            return new Response(true,"redis添加list数据成功 key="+key);
        }catch (Exception e){
            logger.error("redis 保存list 失败",e);
            return new Response(false,"redis添加list数据失败 key="+key);
        }
    }

    @Override
    public Object lpop(String key) {
        Object obj = null;
        try {
            obj =  opsForList.leftPop(key);
        }catch (Exception e){
            logger.error("redis 操作list,从列表左端弹出元素失败",e);
        }

        return obj;
    }

    @Override
    public List  lrange(String key,long start,long end) {
        List list=null;
        try {
            list= opsForList.range(key,start,end);
        }catch (Exception e){
            logger.error("redis 操作list,从列表查询元素失败",e);
        }
       return list;
    }
}
