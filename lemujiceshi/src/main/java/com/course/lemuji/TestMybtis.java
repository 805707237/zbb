package com.course.lemuji;

import com.course.dao.UserDao;
import com.course.model.sql.QueryVo;
import com.course.model.sql.User;
import com.course.model.sql.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybtis {
    private InputStream in;
    private UserDao userDao;
    private SqlSession sqlsession;
    private static Logger log = LoggerFactory.getLogger(yyScript.class);
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
        //3.使用工厂生产SqlSession对象
        sqlsession=factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao=sqlsession.getMapper(UserDao.class);
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

    /**
     * 查询用户
     * */
    @Test
    public void UserList(){
        //5.使用代理对象执行方法
        List<Users> users=userDao.findAll();
        for(Users user:users){
            System.out.println(user);
        }
    }

    /**存数据**/
    @Test
    public void AddUser(){
        User user=new User();
        user.setId(10);
        user.setName("张三");
        user.setAge("10");
        user.setMax("男");
        user.setPassword("10086");
        userDao.addUser(user);
    }
    /**修改数据**/
    @Test
    public void UpdateUser(){
        User user=new User();
        user.setId(10);
        user.setName("zhangsan");
        user.setAge("11");
        user.setMax("女");
        user.setPassword("10080");
        userDao.updateUser(user);
    }
    /**删除数据**/
    @Test
    public void DelectUser(){
        userDao.delectUser(10);
    }
    /**查询单行**/
    @Test
    public void OneUser(){
        User user= userDao.oneUser(1);
        System.out.println(user.getName());
        Assert.assertEquals(user.getName(),"张三");
    }
    /**抛异常，测试报告导出**/
    @Test
    public void test0(){
        throw new RuntimeException("自己抛异常");
    }
    /**模糊查询**/
    @Test
    public void  TestName(){
        List<User> users=userDao.testName("%三%");
        for(User user:users){
            System.out.println(user);
        }
    }
    /**模糊查询二**/
    @Test
    public void  TestNameVo(){
        User user=new User();
        QueryVo queryVo=new QueryVo();
        user.setName("%三%");
        queryVo.setUser(user);
        List<User> users=userDao.testName("%三%");
        for(User u:users){
            System.out.println(u);
        }
    }
    /**查看记录条数**/
    @Test
    public void Count(){
        System.out.println(userDao.countUser());
        log.info("打印日志123");
    }
}
