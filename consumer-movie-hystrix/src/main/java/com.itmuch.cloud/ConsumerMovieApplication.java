package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created by ZC-16-012 on 2018/12/19.
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerMovieApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsumerMovieApplication.class,args);
    }
}
