package com.course.testng.suite;

import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;

public class MultiThread {
    @Test(invocationCount = 10,threadPoolSize = 3)  //多线程通过注解的方式实现。3个线程同时运行，共执行10次
    public void test1(){
        System.out.println("hello----------");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
