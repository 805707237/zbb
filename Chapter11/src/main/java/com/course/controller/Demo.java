package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/",description = "sql语句类")
@RequestMapping
public class Demo {

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/sql1", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数", httpMethod = "GET")
    public int test1() {
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    @ApiOperation(value = "新加用户", httpMethod = "POST")
    public int test2(@RequestBody User user) {
        return template.insert("addUser", user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int test3(@RequestBody User user){
        return template.update("updateUser",user);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public int test4(@RequestParam Integer id){
        return template.delete("deleteUser",id);
    }

}