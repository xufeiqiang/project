package com.cn.betasoft;

import org.junit.Test;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by ZC-16-012 on 2018/8/9.
 */
public class RunTime {

    @Test
    public void testMemory() {
        Runtime runTime = Runtime.getRuntime();
        long maxMemory = runTime.maxMemory() / 1024 / 1024;
        long totalMemory = runTime.totalMemory() / 1024 / 1024;

        System.out.printf("maxMemory = %s-----totalMemory = %s", maxMemory, totalMemory);
    }


    @Test
    public void testSystem() throws Exception{
       String str= System.getProperty("JAVA_HOME");
       Properties props= System.getProperties();
       props.store(new FileOutputStream("prop.properties"),"system properties");
    }

}