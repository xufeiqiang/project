package com.itmuch.cloud.service;

import com.itmuch.cloud.config.FeignConfiguration;
import com.itmuch.cloud.model.User;
import com.itmuch.cloud.service.impl.FeignClientFallback;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZC-16-012 on 2018/12/20.
 *  configuration属性指定feign的配置类
 */
@FeignClient(name = "microservice-provider-user",
        configuration = FeignConfiguration.class,fallback = FeignClientFallback.class)
public interface UserFeignClient {


    /**
    * 使用feign自带的注解,这里就不使用springMVC的注解
     *
     * @param id url的占位符(参数) id
    * */
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);


}
