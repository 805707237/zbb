package com.course.testng.groupClass;

import org.testng.annotations.Test;

@Test(groups = "stu2")
public class groupClass2 {
    public void st1(){
        System.out.println("stu2中st1");
    }
    public void st2(){
        System.out.println("stu2中st2");
    }
}
