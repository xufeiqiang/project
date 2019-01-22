package com.itmuch.cloud;

import com.itmuch.cloud.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by ZC-16-012 on 2018/12/27.
 * 服务网关
 *
 * 1.客户端调用不同的微服务导致客户端的复杂
 * 2.认证复杂，每个服务都需要独立认证
 * 3.假如某个微服务使用防火墙策略，无法直接访问
 * 使用Zuul,让所有的客户端请求都经过Zuul
 *
 *
 * 例如：http://localhost:8050/consumer-movie/user/1
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulAppcation {

    public static void main(String[] args){
        SpringApplication.run(ZuulAppcation.class,args);
    }

    @Bean
    public PreRequestLogFilter preRequestLogFilter(){
        return new PreRequestLogFilter();
    }

}
