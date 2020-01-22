package com.course.testng.suite;

import org.testng.annotations.Test;

public class PayTest {
    @Test(enabled=false)
    public void PayTest(){
        System.out.print("支付");
    }
}
