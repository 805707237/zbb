package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 返回Cookie的get请求
 */
@RestController
@Api(value = "/",description = "这个类里都是Get方法")
public class GetTest {

    @RequestMapping(value = "/getcookies",method = RequestMethod.GET)
    @ApiOperation(value = "登录接口",httpMethod = "GET")
    public String getcookie(HttpServletResponse response){
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "获取cookie成功";
    }

    /**
     *需要cookie才能访问的get请求
     */
    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    @ApiOperation(value = "需要cookie才能访问的get请求",httpMethod = "GET")
    public String Test1(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(Objects.isNull(cookies)){
            return "没有cookie信息,无法访问";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "访问成功";
            }
        }
        return "没有cookie信息,无法访问";
    }

    /**
     *需要参数访问的get请求。第一种方式
     * name是默认张三，
     * age无默认值，必填
     */
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    @ApiOperation(value = "需要参数访问的get请求。第一种方式",httpMethod = "GET")
    public Map<String,Integer> Test2(@RequestParam (value = "name",required = false,defaultValue = "张三")String name,
                        @RequestParam(value = "age",required = true)Integer age){
        Map <String,Integer> list=new HashMap<>();
        list.put("张三",20);
        list.put("李四",25);
        list.put("王五",19);
        return list;
    }

    /**
     *需要参数访问的get请求。第二种方式
     */
    @RequestMapping(value = "/test3/{name}/{age}",method = RequestMethod.GET)
    @ApiOperation(value = "需要参数访问的get请求。第二种方式",httpMethod = "GET")
    public Map<String,Integer> Test3(){
        Map<String,Integer> list=new HashMap<>();
        list.put("张三",20);
        list.put("李四",10);
        list.put("王五",12);
        return list;
    }

}