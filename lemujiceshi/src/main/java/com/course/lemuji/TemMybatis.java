package com.course.lemuji;

import com.course.dao.TemDao;
import com.course.dao.UserDao;
import com.course.dao.ZbbDao;
import com.course.model.sql.Haha;
import com.course.model.sql.Tem;
import com.course.model.sql.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

public class TemMybatis {

    private InputStream in;
    private SqlSession sqlsession;
    private static Logger log = LoggerFactory.getLogger(yyScript.class);
    private TemDao temDao;
    private UserDao userDao;

    private InputStream in1;
    private SqlSession sqlsession1;
    private ZbbDao zbbDao;
    /**
     * 链接数据库
     * 测试开始前执行
     * */
    @BeforeSuite
    public void mybatis() throws IOException {
        //1.读取配置文件
        in= Resources.getResourceAsStream("mybatisconfig.xml ");
        //2.创建SqlSessionFactory对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //3.使用工厂生产SqlSession对象 参数加上true自动提交事务
        sqlsession=factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        temDao=sqlsession.getMapper(TemDao.class);
        userDao=sqlsession.getMapper(UserDao.class);

        in1= Resources.getResourceAsStream("config1.xml");
        //2.创建SqlSessionFactory对象
        SqlSessionFactoryBuilder builder1=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory1=builder1.build(in1);
        //3.使用工厂生产SqlSession对象 参数加上true自动提交事务
        sqlsession1=factory1.openSession();
        zbbDao=sqlsession1.getMapper(ZbbDao.class);
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
        System.out.println("测试结束。");
    }
    @Test
    public void TemList(){
        List<Tem> tem= temDao.findAll();
        for(Tem t:tem){
            System.out.println(t);
        }
    }
    /**多表查询，一对一查询**/
    @Test
    public void TemUser(){
        List<Tem> tem=temDao.temUser();
        for(Tem t:tem){
            System.out.println(t);
            System.out.println(t.getUser());
        }
    }

    @Test
    public void test(){
        Haha haha=zbbDao.test1(1);
        System.out.println(haha.toString());
    }
//    /**多表查询，一对多查询**/
//    @Test
//    public void UsersTem(){
//        List<User> u=userDao.usersTem();
//        for(User user:u){
//            System.out.println(user);
//            System.out.println(user.getTems());
//            System.out.println("-----------------------------");
//        }
//    }

}