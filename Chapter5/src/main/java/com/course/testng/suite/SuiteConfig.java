package com.course.testng.suite;
import org.testng.annotations.*;

public class SuiteConfig {  //配置类，测试套件配置
    @BeforeSuite
    public void beforeSuite(){
        System.out.print("BeforeSuite运行了");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.print("AfterSuite运行了");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.print("BeforeTest运行了");
    }
    @AfterTest
    public void afterTest(){
        System.out.print("AfterTest运行了");
    }

}
