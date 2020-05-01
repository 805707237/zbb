package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value = "/v1",description = "这是我的Post请求")
@RequestMapping("/v1")
public class PostTest {
    private static Cookie cookie;

    @RequestMapping(value = "/zbb",method= RequestMethod.POST)
    public String test1(HttpServletResponse response,
                        @RequestParam(value = "name",required = true) String name,
                        @RequestParam(value = "password",required = true)String password) {
        if(name.equals("zhangsan") && password.equals("123456")) {
            cookie = new Cookie("login", "ture");
            response.addCookie(cookie);
            return "登入成功";
        }
        return "登录错误";
    }

    /**
     *需要携带cookie访问的post
     */
    @RequestMapping(value = "/getzbb",method = RequestMethod.POST)
    @ApiOperation(value = "这是需要cookie才能访问的post请求",httpMethod = "POST")
    public String test2(HttpServletRequest request, @RequestBody User u){
        Cookie[] cookies=request.getCookies();
        User user=new User();
        if(Objects.isNull(cookies)){
            return "没有cookie";
        }
        for(Cookie c : cookies){
            if(c.getName().equals("login")&&c.getValue().equals("true")&&u.getName().equals("zhangsan")
                && u.getAge().equals("18") && u.getSex().equals("男")){
                user.setName("李四");
                user.setAge("11");
                user.setSex("女");
                return  user.toString();
            }
        }
        return "访问失败啦";
    }
}