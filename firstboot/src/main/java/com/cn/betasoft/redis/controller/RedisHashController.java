package com.cn.betasoft.redis.controller;

import com.cn.betasoft.redis.annotation.Api;
import com.cn.betasoft.redis.model.Response;
import com.cn.betasoft.redis.services.RedisHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by ZC-16-012 on 2018/8/2.
 */

@RestController
@RequestMapping("/hash")
@Api(value = "redis操作hash,对外提供redis接口")
public class RedisHashController {

    @Autowired
    private RedisHashService redisHashService;

    @PostMapping("hmset")
    public Response hmset(@RequestParam String key,@RequestBody Map map){
       return redisHashService.hmset(key,map);
    }

    @GetMapping("hgetall/{key}")
    public Map hgetAll(@PathVariable String key){
        return redisHashService.hgetAll(key);
    }






}
