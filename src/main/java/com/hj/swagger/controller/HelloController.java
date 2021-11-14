package com.hj.swagger.controller;

import com.hj.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
//Operation接口
@Api(tags = "Hello测试接口")
@RestController
public class HelloController {
    @PostMapping(value = "/hello")
    public String hello() {
        return "hello world!";
    }
    //只要我们的接口中存在实体类就会扫描到Swagger中
    @GetMapping(value = "/user")
    public User user(){
        return new User();
    }
    @ApiOperation("Hello控制类")//放在方法上
    @PostMapping("/welcome")
    public User user(@ApiParam("用户") User user){
        return user;
    }
}
