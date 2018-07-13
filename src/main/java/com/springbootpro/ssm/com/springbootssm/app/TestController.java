package com.springbootpro.ssm.com.springbootssm.app;

import com.springbootpro.ssm.com.springbootssm.pojo.User;
import com.springbootpro.ssm.com.springbootssm.service.ITestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
@Api(value = "多数据源测试接口")
public class TestController {

    @Autowired
    private ITestUserService testUserService;

    @RequestMapping("getUserInHibernate")
    @ApiOperation(value = "从hibernate这个数据库获取数据",notes= "获取用户甲")
    public User toGetUserInHibernate(){
        return testUserService.getUserInHibernate();
    }

    @RequestMapping("getUserInTestDB")
    @ApiOperation(value = "从TestDB这个数据库获取数据",notes= "获取用户乙")
    public User toGetUserInTestDB(){
        return testUserService.getUserInTestDB();
    }

}
