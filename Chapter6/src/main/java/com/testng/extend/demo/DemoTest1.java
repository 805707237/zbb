package com.testng.extend.demo;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class DemoTest1 {
    String a="1";
    @Test
    public void test1(){
        Assert.assertEquals(1,3);
    }
    @Test
    public void test2(){
        Assert.assertEquals(2,2);
    }
    @Test
    public void logDemo(){
        Reporter.log("输入日志信息123");
        throw new RuntimeException("报错信息111");
    }
}
