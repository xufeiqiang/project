package com.cn.betasoft.lambdaTest;

import com.cn.betasoft.myApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZC-16-012 on 2018/10/19.
 * test lambda表达式
 * lambda表达式代替匿名内部类的创建对象，表达式的代码块将会实现抽象方法的方法体
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = myApp.class)
public class LambdaTest {
    public void eat(Eatable e){
        e.taste();
    }

    /*@Test
    public void test(){
        LambdaTest lambdaTest= new LambdaTest();
        lambdaTest.eat(()->{
            System.out.println("吃个毛线啊，艹");
        });
    }*/


}

 interface Eatable{
   void taste();
}


