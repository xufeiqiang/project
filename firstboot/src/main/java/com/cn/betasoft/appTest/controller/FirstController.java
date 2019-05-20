package com.cn.betasoft.appTest.controller;


import com.cn.betasoft.appTest.model.Person;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZC-16-012 on 2018/7/5.
 * spring boot 构建一个restful风格的
 */
@RestController
public class FirstController {
    //,produces = "application/json"
    @RequestMapping(value = "/prop/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Person getData(@PathVariable int id){
        Person p= new Person();
        p.setId(id);
        p.setAge(27);
        p.setName("xufeixiang");
        return p;
    }
}
