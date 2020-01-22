package com.course.testng.suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
    @AfterTest
    @Parameters({"name","age"})
    public void test1(String name,int age){
        System.out.println("name="+name+"、  age="+age);
    }

}
