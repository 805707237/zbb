package com.course.testng.suite;

import org.testng.annotations.Test;

public class ExpectedException {
    @Test(expectedExceptions = Exception.class)
    public void expectd1(){         //此方法没有产生异常。所以执行失败
        System.out.println("这是一个异常测试1");
    }

    @Test(expectedExceptions = Exception.class)
    public void expectd2(){         //此方法抛出一个异常，执行成功
        System.out.println("这是一个异常测试2");
        throw new RuntimeException();
    }
}
