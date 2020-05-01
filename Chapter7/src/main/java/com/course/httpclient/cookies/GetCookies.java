package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class GetCookies {
    private String url;
    private ResourceBundle bundle;
    CookieStore store;


    @Test(timeOut = 3000)
    //依赖test1方法，超时时间为3000毫秒
    public void test1() throws IOException {
        Reporter.log("登入接口，获取cookie");
        //执行application配置文件
        bundle=ResourceBundle.getBundle("application");
        //配置文件的里url地址赋值给url
        url=bundle.getString("url");

        String result;
        //访问接口
        HttpGet get=new HttpGet(this.url+bundle.getString("登录"));
        //HttpClient client = HttpClientBuilder.create().build();
        //用来执行get方法
        DefaultHttpClient client =new DefaultHttpClient();
        //返回值赋值给result
        result= EntityUtils.toString(client.execute(get).getEntity(),"utf-8");
        System.out.println(result);
        //获取cookie信息，报错再store对象中
        this.store= client.getCookieStore();
        //赋值给cookieList
        List<Cookie> cookieList=store.getCookies();

        //输出cookies
        for(Cookie cookie:cookieList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println(name+" : "+value);
        }
    }

    @Test(dependsOnMethods ={"test1"})
    public void test2() throws IOException {
        String message;
        HttpGet get=new HttpGet(this.url+bundle.getString("使用cookie"));
        DefaultHttpClient client=new DefaultHttpClient();
        //使用cookie
        client.setCookieStore(this.store);
        HttpResponse response=client.execute(get);
        int code=response.getStatusLine().getStatusCode();
        System.out.println(code);
        if(code==200) {
            message = EntityUtils.toString(response.getEntity());
            //打印返回信息
            System.out.println(message);
        }
    }
    @Test(dependsOnMethods = {"test1"})
    public void test3() throws IOException {
        String message;
        HttpPost post=new HttpPost(this.url+bundle.getString("postcookie"));
        DefaultHttpClient client=new DefaultHttpClient();
        //设置头信息
        post.setHeader("content-type","application/json");
        //设置json格式参数
        JSONObject json =new JSONObject();
        json.put("name","zbb");
        json.put("sex","man");
        //设置Cookie信息
        client.setCookieStore(this.store);
        //将参数信息添加到请求中
        StringEntity entity=new StringEntity(json.toString(),"utf-8");
        post.setEntity(entity);
        HttpResponse response=client.execute(post);
        message=EntityUtils.toString(response.getEntity());
        System.out.println(message);
        JSONObject re=new JSONObject(message);
        String name=(String) re.get("name");
        String sex= (String) re.get("sex");
        Assert.assertEquals("赵彬彬",name);
        Assert.assertEquals("16",sex);
    }
}