package com.course.testng;
import org.testng.annotations.*;

public class BasicAnnotation {

    @Test   //把方法标记为测试的一部分
    public void testCase1(){
        System.out.print("Test测试用例1");
    }

    @Test   //把方法标记为测试的一部分
    public void testCase2(){
        System.out.print("Test测试用例2");
    }

    @BeforeMethod   //测试方法运行前运行的方法
    public void beforeMethod(){
        System.out.print("BeforeMethod 测试方法之前运行的方法");
    }

    @AfterMethod    //测试方法运行后运行的方法
    public void afterMethod(){
        System.out.print("AfterMethod这是测试方法之后运行的");
    }

    @BeforeClass    //测试类运行前运行的方法
    public void BeforeClass(){
        System.out.print("BeforeClass类运行前运行的方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.print("AfterClass这是类运行之后运行的方法");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.print("BeforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.print("AfterSuite测试套件");
    }


}