package com.cn.betasoft.redis.controller;

import com.cn.betasoft.redis.model.Response;
import com.cn.betasoft.redis.annotation.Api;
import com.cn.betasoft.redis.services.RedisStringService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 */
@RestController
@RequestMapping("/string")
@Api(value = "redis 字符串api,对外提供rest 接口")
public class RedisStringController {

    private Logger logger= LoggerFactory.getLogger(RedisStringController.class);
    @Autowired
    private ValueOperations opsForValue;

    @Autowired
    private RedisStringService redisService;

    @ApiOperation(value = "操作string字符串,设置redis的K,V")
    @ApiImplicitParams({
            @ApiImplicitParam(name="key",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name="value",required = true,dataType = "String",paramType = "path")
    })
    @GetMapping("set/{key}/{value}")
    @ResponseBody
    public Response set(@PathVariable("key") String key,@PathVariable("value") Object value){
      return redisService.set(key,value);
    }

    @ApiOperation(value = "操作string字符串,根据key获取value")
    @ApiImplicitParam(name="key",required = true,dataType = "String",paramType = "path")
    @GetMapping("get/{key}")
    public Object get(@PathVariable("key") String key){
        return redisService.get(key);
    }

    @ApiOperation(value = "操作string字符串,根据key删除")
    @ApiImplicitParam(name="key",required = true,dataType = "String",paramType = "path")
    @GetMapping("del/{key}")
    @ResponseBody
    public Response delete(@PathVariable("key") String key){
      return redisService.del(key);
    }

    @GetMapping("expire/{key}/{time}")
    @ResponseBody
     public Response expire(@PathVariable("key") String key,@PathVariable("time") long time){
        return redisService.expire(key,time, TimeUnit.SECONDS);
    }

    @GetMapping("expireAt/{key}/{time}")
    @ResponseBody
    public Response expireDate(@PathVariable("key") String key, @PathVariable("time") String time) {
        Date date = null;
        try {
             date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return redisService.expireAt(key, date);
    }



}
