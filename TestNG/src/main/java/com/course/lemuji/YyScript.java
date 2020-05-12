package com.course.lemuji;

import com.course.model.api.Url;
import com.course.model.api.Yyapi;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;


public class YyScript {
    /**代理商入住审核列表参数**/
    @DataProvider(name="yyq1")
    public  Object[][] parameter(){
        Object[][] result=new Object[][]{
                {"杭州乐木几","1","10","1","2000"},
                {null,"1","10","1","2000"},
                {"杭州乐木几","1","10",null,"2000"},
                {"","哈哈","10","6","3000"},
                {"","1","哈哈","","3000"},
                {"","","10","","3000"},
                {"","1","","","3000"},
                {"",null,"10","","3000"},
                {"","1",null,"","3000"},
                {"","5","10","","2000"}
        };
        return result;
    }
    /**代理商入住审核列表）**/
    @Test(dataProvider ="yyq1",enabled = true)
    public void organAgencyAuditService(String name,String pageNumber,String pageSize,
                                        String status, String statusCode) throws IOException {
        HttpPost post=new HttpPost(Url.yyurl);
        post.setHeader("Content-Type","application/json;charset=UTF-8");
        post.setHeader("Authorization",SuiteConfig.yytoken);
        JSONObject json=new JSONObject();
        json.put("name",name);
        json.put("method",Yyapi.organAgencyAuditService);
        json.put("pageNumber",pageNumber);
        json.put("pageSize",pageSize);
        json.put("status",status);
        StringEntity entity=new StringEntity(json.toString(),"utf-8");  //将JSON格式参数加到方法中
        post.setEntity(entity);
        HttpResponse response=SuiteConfig.client.execute(post);
        String relult=EntityUtils.toString(response.getEntity(),"utf-8");
        JSONObject jsonObject=new JSONObject(relult);
        String a= jsonObject.getString("statusCode");
        Reporter.log("name"+name+ "method:"+Yyapi.organAgencyAuditService+",pageNumber:"+pageNumber+"," +
                "pageSize:"+pageSize+"status"+status);
        Reporter.log("响应结果： "+relult);
        SuiteConfig.log.info(relult);
        Assert.assertEquals(a,statusCode);
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
    }

    /**商品_商品分类-列表**/
    @Test
    public void commodityList() throws IOException {
        HttpPost post=new HttpPost(Url.yyurl);
        post.setHeader("Content-Type","application/json;charset=UTF-8");
        post.setHeader("Authorization",SuiteConfig.yytoken);
        JSONObject json=new JSONObject();
        json.put("method","com.lemuji.pubs.general.commodityList");
        StringEntity entity=new StringEntity(json.toString(),"utf-8");  //将JSON格式参数加到方法中
        post.setEntity(entity);
        HttpResponse response=SuiteConfig.client.execute(post);
        String relult=EntityUtils.toString(response.getEntity(),"utf-8");
        JSONObject jsonObject=new JSONObject(relult);
        Reporter.log("com.lemuji.pubs.general.commodityList");
        Reporter.log("响应结果： "+relult);
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
        Assert.assertEquals("2000",jsonObject.getString("statusCode"));
        Assert.assertEquals("请求成功",jsonObject.getString("message"));
    }

    @Test(enabled = false)
    public void test1(){
        System.out.println("这是一条忽略测试");
    }
    @BeforeMethod
    public void test2(){
        System.out.println("每条测试方法执行后执行得方法");
    }
    @AfterClass
    public void test3(){
        System.out.println("测试类执行后执行的方法");
    }
}