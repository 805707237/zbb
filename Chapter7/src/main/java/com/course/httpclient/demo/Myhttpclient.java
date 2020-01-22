package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import java.io.IOException;

public class Myhttpclient {
    @Test
    public void test1() throws IOException {
        String result;          //用来存放我们的结果
        HttpGet get=new HttpGet("www.baidu.com");     //用来执行get方法
        //HttpClient client=new DefaultHttpClient();
        // 用来执行get方法的，DefaultHttpClient被弃用，HttpClientBuilder.create().build()代替
        HttpClient client= HttpClientBuilder.create().build();
        HttpResponse response= client.execute(get);
        System.out.println(client);
    }
}
