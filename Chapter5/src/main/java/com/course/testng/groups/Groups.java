package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Groups {
    @Test(groups = "t1")
    public void test1(){
        System.out.print("111111111");
    }
    @Test(groups = "t1")
    public void test2(){
        System.out.print("222222222222");
    }
    @Test(groups = "t2")
    public void test3(){
        System.out.print("3333333333");
    }
    @BeforeGroups("t1")
    public void qq(){
        System.out.print("t1组开始执行");
    }
    @AfterGroups("t1")
    public void ww(){
        System.out.println("t1组执行结束");
    }
}