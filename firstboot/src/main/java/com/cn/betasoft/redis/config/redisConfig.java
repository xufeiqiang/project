package com.cn.betasoft.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZC-16-012 on 2018/7/27.
 * redis 配置类
 */
@Configuration
public class redisConfig {


    /**
     * 配置redisTemplate 进行序列化
     *redisTemplate.opsForValue();//操作字符串
     *redisTemplate.opsForHash();//操作hash
     *redisTemplate.opsForList();//操作list
     *redisTemplate.opsForSet();//操作set
     *redisTemplate.opsForZSet();//操作有序set
     */

    /*@Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        //创建一个模板类
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        //将刚才的redis连接工厂设置到模板类中
        template.setConnectionFactory(factory);
        return template;
    }*/

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        // 创建一个模板类
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        // 将redis连接工厂设置到模板类中
        template.setConnectionFactory(factory);
        // 设置key的序列化器
        template.setKeySerializer(new StringRedisSerializer());
        // 设置value的序列化器
        //使用Jackson 2，将对象序列化为JSON
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //json转对象类，不设置默认的会将json转成hashmap
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);

        //序列化hash类型的key,value
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.afterPropertiesSet();
        return template;
    }

   /**
   * 对字符串类型的数据进行操作
   * */
    @Bean
    public ValueOperations opsForValue(RedisTemplate redisTemplate){
       return    redisTemplate.opsForValue();
    }

    /**
    * 对list进行操作
    * */

    @Bean
    public ListOperations opsForList(RedisTemplate redisTemplate){
        return redisTemplate.opsForList();
    }

    /**
    * 对hash 进行操作
    * */
    @Bean
    public HashOperations opsForHash(RedisTemplate redisTemplate){
       return redisTemplate.opsForHash();
    }

    /**
    * 对set 进行操作
    * */
    @Bean
    public SetOperations opsForSet(RedisTemplate redisTemplate){
        return redisTemplate.opsForSet();
    }

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }


}
