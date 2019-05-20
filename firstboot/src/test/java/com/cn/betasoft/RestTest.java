package com.cn.betasoft;


import com.cn.betasoft.redis.model.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZC-16-012 on 2018/8/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = myApp.class)
public class RestTest {

//    @Autowired
//    private RestTemplate restTemplate;


    @Test
    public void testList(){
        RestTemplate restTemplate= new RestTemplate();
        List<String> list= new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        String url="http://localhost:8080/list/lpushAll";
        String key="restList";
        Response response= restTemplate.postForObject(url+"?key="+key,list, Response.class);
        if (response.isStatus()){
            System.out.println(response.getMsg());
        }
    }

    @Test
    public void testMap(){
        RestTemplate restTemplate= new RestTemplate();
        String key="testMap";
        Map<String,String> map= new HashMap<String, String>();
        map.put("test1","1");
        map.put("test2","2");
        map.put("test3","3");
        map.put("test4","4");
        String url="http://localhost:8080/hash/hmset";
        Response response= restTemplate.postForObject(url+"?key="+key,map, Response.class);
        if (response.isStatus()){
            System.out.println(response.getMsg());
        }
    }

    /**
     * test constant pool is true
     */
    @Test
    public void testString() {
        String s0 = "hello";
        String s1 = "hello";
        String s2 = "he" + "llo";
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
    }

    /*
    * 测试引用
    * */





}
