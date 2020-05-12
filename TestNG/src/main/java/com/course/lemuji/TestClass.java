package com.course.lemuji;

import com.course.dao.UsersDao;
import com.course.model.sql.Users;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestClass {
    private UsersDao usersDao;
    private InputStream in;
    private SqlSession sqlsession;
    private static Logger log = LoggerFactory.getLogger(YyScript.class);

    @BeforeSuite
    public void mybatis() throws IOException {
        /**链接mybatis**/
        //1.读取配置文件
        in = Resources.getResourceAsStream("mybatisconfig.xml");
        //2.创建SqlSessionFactory对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        sqlsession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        usersDao = sqlsession.getMapper(UsersDao.class);
    }

    @Test
    public void test(){
        List<Users> u =usersDao.findAll();
        for(Users users:u){
            System.out.println(users);
        }
    }
    @Test
    public void test1(){
        Users users=new Users();
        users.getId();
    }

}
