package com.cn.betasoft;

import com.cn.betasoft.redis.model.HostModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZC-16-012 on 2018/7/31.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = myApp.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
    * 将java对象 序列化转换成json 保存到redis
    * */
    @Test
    public void testJson(){
        List<HostModel> hostModels= new ArrayList<HostModel>();
        for (int i=0;i<3;i++){
            HostModel hostModel= new HostModel();
            hostModel.setName("xu="+i);
            hostModel.setIp("127.0.0.1="+i);
            hostModel.setUuid("ssh8925="+i);
            hostModels.add(hostModel);

        }
        redisTemplate.opsForValue().set("host2",hostModels);
    }

    /**
    * 将redis中的json数据反序列化成java对象
    * */
    @Test
    public void getJsontoBean(){
        ValueOperations<String, List<HostModel>> valueOperations= redisTemplate.opsForValue();
        List<HostModel> host2= valueOperations.get("host2");
        System.out.print("host2="+host2);
    }
}
