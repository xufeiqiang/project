package com.itmuch.cloud.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * Created by ZC-16-012 on 2018/12/20.
 * 该类可以不用加@configuration 注解，如果加了，那么该类不能放在主应用程序上下文@ComponentScan所扫描的包中
 * 还可以自定义feign的编码器，解码器，拦截器
 */
public class FeignConfiguration {

    /**
    * 返回feign默认的原生契约，这样就可以使用feign自带的注解了
    * */
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

    //拦截器,这个http basic的认证的账号和密码我不是很理解
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
    }
    /**
    * feign的日志配置，
     * basic 仅记录请求方法,URL,响应状态代码以及执行时间
     * FULL:记录请求和响应的header、body和元数据
    * */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }

}
