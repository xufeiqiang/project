package com.itmuch.cloud.controllers;


import com.itmuch.cloud.model.User;
import com.itmuch.cloud.service.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    * 使用hystrix的容错机制，使的findById方法具有容错能力
    * */
    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    @GetMapping("user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
    }

    //回退方法 findByIdFallBack，如果消费者请求服务者服务失败，则会走这个回退方法,
    // 注意：参数类型必须要和需要容错的方法findById的类型一样，否则会找不到该容错方法
    public User findByIdFallBack(Long id,Throwable throwable){
        logger.error("进入Hystrix容错方法,出现容错的原因:",throwable);
        User user= new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
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
