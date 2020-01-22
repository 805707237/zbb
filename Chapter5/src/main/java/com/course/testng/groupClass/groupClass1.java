package com.course.testng.groupClass;

import org.testng.annotations.Test;

@Test(groups = "stu1")
public class groupClass1 {
    public void st1(){
        System.out.println("stu1中st1");
    }
    public void st2(){
        System.out.println("stu1中st2");
    }
}
