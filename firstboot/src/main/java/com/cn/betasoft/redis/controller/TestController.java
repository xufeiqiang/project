package com.cn.betasoft.redis.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by ZC-16-012 on 2019/1/22.
 * 模拟一个xaf 的rest 接口
 */
@RestController
public class TestController {


    @GetMapping("query/mo/{moType}")
    public String queryInstance(@PathVariable String moType){
        try {
            if ("host".equals(moType)){
                File file= ResourceUtils.getFile("classpath:Host.json");
                return  FileUtils.readFileToString(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
