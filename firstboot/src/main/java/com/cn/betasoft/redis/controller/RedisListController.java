package com.cn.betasoft.redis.controller;

import com.cn.betasoft.redis.annotation.Api;
import com.cn.betasoft.redis.model.Response;
import com.cn.betasoft.redis.services.RedisListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by ZC-16-012 on 2018/8/1.
 */

@RestController
@RequestMapping("/list")
@Api(value = "redis 操作list列表api,对外提供rest 接口")
public class RedisListController {
    @Autowired
    private RedisListService redisListService;

     @ResponseBody
     @PostMapping("lpushAll")
     public Response lpushAll(@RequestParam String key,@RequestBody List<String> value){
       return  redisListService.lpushAll(key,value);
     }

    @GetMapping("lpop/{key}")
    public Object lpop(@PathVariable String key) {
       return redisListService.lpop(key);
    }

    //查询list全部元素
    @GetMapping("lrange/{key}")
    public List lrange(@PathVariable String key){
       return redisListService.lrange(key,0,-1);
    }



}
