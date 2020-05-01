package com.course.lemuji;

import com.course.model.sql.User;

public class Testing {

    public static void main(String[] args) {
        User user=new User();
        user.setName("张三");
        user.setId(1);
        user.setMax("男");
        user.setAge("10");
        user.setPassword("123456");
        System.out.println(user.toString());
    }
}
