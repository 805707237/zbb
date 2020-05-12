package com.course.lemuji;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import com.course.dao.UserDao;
import com.course.model.api.api;
import com.course.model.phone;
import com.course.model.sql.Users;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;

public class yyScript {
    private String yytoken;
    private UserDao userDao;
    private InputStream in;
    private SqlSession sqlsession;
    private CloseableHttpClient client;
    private CloseableHttpClient client1;
    private static Logger log = LoggerFactory.getLogger(yyScript.class);
    /**
     * 链接数据库
     * 测试开始前执行
     * */
    @BeforeSuite
    public void mybatis() throws IOException {
        /**链接mybatis**/
        //1.读取配置文件
        in= Resources.getResourceAsStream("mybatisconfig.xml ");
        //2.创建SqlSessionFactory对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //3.使用工厂生产SqlSession对象
        sqlsession=factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao=sqlsession.getMapper(UserDao.class);

        /**登录**/
        String url=phone.yyurl;
        HttpPost getcode =new HttpPost(url);//地址
        getcode.setHeader("content-type","application/json");//设置请求头
        JSONObject json=new JSONObject();   //json对象
        json.put("key","13300000000");
        json.put("type","5");
        json.put("method", api.smscode);
        StringEntity entity=new StringEntity(json.toString(),"utf-8");  //将JSON格式参数加到方法中
        getcode.setEntity(entity); //参数加到请求中
        this.client = api.createSSLClientDefault();//跳过证书方法
        this.client1= HttpClientBuilder.create().build();//获取client对象，用来发送请求
        this.client.execute(getcode);//发送验证码
        Users users=userDao.getUsers("13300000000");//将13300000000用户从数据库映射到Users类
        HttpPost login=new HttpPost(url);
        JSONObject json1=new JSONObject();
        json1.put("key","13300000000");
        json1.put("code",users.getCode());
        json1.put("method", api.login);
        StringEntity entity1=new StringEntity(json1.toString(),"utf-8");  //将JSON格式参数加到方法中
        login.setEntity(entity1);
        HttpResponse response= this.client.execute(login);//登录
        String result=EntityUtils.toString(response.getEntity(),"utf-8");
        JSONObject jsonReponse=new JSONObject(result);
        System.out.println(jsonReponse.toString());
        this.yytoken=new JSONObject(jsonReponse.get("data").toString()).get("token").toString();
        System.out.println(this.yytoken);
    }

    /**
     * 释放资源
     * 测试结束时执行
     * */
    @AfterSuite
    public void Over()throws Exception{
        sqlsession.commit();//提交事务
        //释放资源
        sqlsession.close();
        in.close();
        log.info("测试结束！！！！！！测试结束！！！！！！测试结束！！！！！！");
    }

    /**代理商入住审核列表**/
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
    @Test(dataProvider ="yyq1")
    public void organAgencyAuditService(String name,String pageNumber,String pageSize,
                                        String status, String statusCode) throws IOException {
        HttpPost post=new HttpPost(phone.yyurl);
        post.setHeader("Content-Type","application/json;charset=UTF-8");
        post.setHeader("Authorization",this.yytoken);
        JSONObject json=new JSONObject();
        json.put("name",name);
        json.put("method",api.organAgencyAuditService);
        json.put("pageNumber",pageNumber);
        json.put("pageSize",pageSize);
        json.put("status",status);
        StringEntity entity=new StringEntity(json.toString(),"utf-8");  //将JSON格式参数加到方法中
        post.setEntity(entity);
        CloseableHttpClient client = api.createSSLClientDefault();
        HttpResponse response=client.execute(post);
        String relult=EntityUtils.toString(response.getEntity(),"utf-8");
        JSONObject jsonObject=new JSONObject(relult);
        String a= jsonObject.getString("statusCode");
        Reporter.log("name"+name+ "method:"+api.organAgencyAuditService+",pageNumber:"+pageNumber+"," +
                "pageSize:"+pageSize+"status"+status);
        Reporter.log("响应结果： "+relult);
        log.info(relult);
        Assert.assertEquals(a,statusCode);
    }


}