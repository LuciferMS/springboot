package com.springbootpro.ssm.com.springbootssm.app;

import com.springbootpro.ssm.com.springbootssm.service.ITestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private ITestUserService testUserService;

    @RequestMapping("/user")
    @ResponseBody
    String home(){
        return testUserService.getUserInHibernate() + "\n" +
                testUserService.getUserInTestDB() + "\n" +
                testUserService.saveUserInMall();
    }

}
