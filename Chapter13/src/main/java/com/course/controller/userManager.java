package com.course.controller;

import com.course.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("v1")
public class userManager {

    //打日志
    private static Logger log = LoggerFactory.getLogger(userManager.class);

    @Autowired
    private SqlSessionTemplate sql;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletResponse response){
//        int i=sql.selectOne("login",user);
//        Cookie cookie =new Cookie("login","true");
//        response.addCookie(cookie);
//        if(i==1){
//            log.info("欢迎回来"+user.getUserName());
//            return true;
//        }
//        else {
//            log.info("登录错误");
//            return false;
//        }
        int i=1;
        System.out.println("post请求"+i+"次");
        i++;
        return "请求成功";
    }

    @RequestMapping(value = "/v1",method = RequestMethod.GET)
    public String test(){
        int j=1;
        System.out.println("get请求"+j+"次");
        j++;
        return "臭不要脸";

    }

    @RequestMapping(value = "/v2",method = RequestMethod.GET)
    public String test3(String name){
//        List<String> userlist=new ArrayList<>();
//        userlist.add(name);
//        userlist.add(name.length()+"");
        System.out.println("请求成功");
        return "请求成功"+name;
    }

}
