package com.course.dao;

import com.course.model.sql.Users;

import java.util.List;


public interface UsersDao {
    /**获取用户信息，包括验证码**/
    Users getUsers(String mobile);


    /**查询所有用户接口**/
    List<Users> findAll();
}
