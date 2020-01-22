package com.course.testng.suite;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {     //参数传递
    @Test(dataProvider = "T1")
    public void Test1(String name,int age){
        System.out.println("Test1:"+name+","+age);
    }
    @DataProvider(name="T1")    //参数传递给Test1方法
    public Object[][] Obj(){
        Object[][] obj=new Object[][]{
                {"张三",20},
                {"李四",16}
        };
        return obj;
    }

    @Test(dataProvider = "T2")
    public void Test2(String name,int age){
        System.out.println("T2,name="+name+"   agr="+age);
    }
    @Test(dataProvider = "T2")
    public void Test3(String name,int age){
        System.out.println("T2,name="+name+"   agr="+age);
    }
    @DataProvider(name="T2")    //通过方法名传递参数
    public Object[][] Obj2(Method method){
        Object[][] obj=null;
        if(method.getName().equals("Test2")){
            obj=new Object[][]{
                    {"zbb1",10},
                    {"zbb2",20}
            };
        }
        if(method.getName().equals("Test3")){
            obj=new Object[][]{
                    {"张三",11},
                    {"李四",12}
            };
        }
        return obj;
    }

}
