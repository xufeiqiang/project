package com.itmuch.cloud.config;

import com.itmuch.cloud.service.UserFeignClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZC-16-012 on 2018/12/19.
 */
@Configuration
public class ConsumerConfig {


    /**
    * rest请求使用ribbon的LoadBalanced注解负载均衡
    * */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
