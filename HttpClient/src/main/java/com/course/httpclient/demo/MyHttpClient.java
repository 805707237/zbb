package com.course.httpclient.demo;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        String result;
        HttpGet get=new HttpGet("http://www.baidu.com");
        //HttpClient client=new DefaultHttpClient();
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

    }

    @Test
    public void test2() throws IOException {
        String result;
        CookieStore cookie;
        HttpGet get =new HttpGet("http://localhost:6004/getcookie2");
        //CloseableHttpClient client=HttpClientBuilder.create().build();
        DefaultHttpClient client=new DefaultHttpClient();
        get.setHeader("content-type","application/json");

        //HttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response=client.execute(get);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        cookie=client.getCookieStore();
        List<Cookie> cookies=cookie.getCookies();
        System.out.println(result);
        for (Cookie cookie1:cookies){
            System.out.println(cookie1.getName()+"  "+cookie1.getValue());
        }

    }

}