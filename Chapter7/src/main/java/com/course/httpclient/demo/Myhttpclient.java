package com.course.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class Myhttpclient {
    @Test
    public void test1() throws IOException {
        String result;          //用来存放我们的结果
        HttpGet get=new HttpGet("http:www.baidu.com");     //用来执行get方法
        //HttpClient client=new DefaultHttpClient();
        // 用来执行get方法的，DefaultHttpClient被弃用，HttpClientBuilder.create().build()代替
        HttpClient client= new DefaultHttpClient();
        //response接受响应.execute方法发送请求
        HttpResponse response= client.execute(get);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
//      result=EntityUtils.toString(HttpClientBuilder.create().build().execute(get).getEntity(),"utf-8");
        System.out.println(result);

    }
}