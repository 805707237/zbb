package com.course.dao;



import com.course.model.sql.QueryVo;
import com.course.model.sql.User;
import com.course.model.sql.Users;
import java.util.List;


/**
 * 用户持久层接口
 * **/
public interface UserDao {

    /**获取用户信息，包括验证码**/
    Users getUsers(String mobile);

    /**查询所有用户接口**/
    List<Users> findAll();

    /**存用户数据接口**/
    void addUser(User user);

    /**修改用户信息**/
    void updateUser(User user);

    /**删除用户信息**/
    void delectUser(int id);

    /**查询单行**/
    User oneUser(int id);

    /**模糊查询**/
    List<User> testName(String name);

    /**模糊查询二**/
    List<User> TestNameVo(QueryVo queryVo);

    /**查看用户条数**/
    int countUser();
}

