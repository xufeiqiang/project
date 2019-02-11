package com.itmuch.cloud.controllers;


import com.itmuch.cloud.model.User;
import com.itmuch.cloud.service.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



/**
 * Created by ZC-16-012 on 2018/12/19.
 */
@RestController
public class MovieController {
    private static final Logger logger= LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UserFeignClient userFeignClient;


    /**
    * 传统的使用restTemplate调用rest请求
    * */
    @GetMapping("user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
    }

    @GetMapping("logUser")
    public void logUserInstance(){
        ServiceInstance serviceInstance=loadBalancerClient.choose("microservice-provider-user");
        logger.info("查看rest请求负载|{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }

    /**
    * 使用feign调用rest请求
    * */
    @GetMapping("feignUser/{id}")
    public User getUserById(@PathVariable("id") Long id){
      return  userFeignClient.findById(id);
    }


}
