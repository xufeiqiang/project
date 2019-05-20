package com.cn.betasoft.appTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZC-16-012 on 2018/7/5.
 * spring boot 的hello world
 */

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String Hello(){
       return "hello springboot";
    }
}
