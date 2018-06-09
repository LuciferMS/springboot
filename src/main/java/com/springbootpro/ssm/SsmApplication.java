package com.springbootpro.ssm;

import com.springbootpro.ssm.com.springbootssm.config.dataSourceConfig.DynamicDataSourceRegister;
import com.springbootpro.ssm.com.springbootssm.pojo.User;
import com.springbootpro.ssm.com.springbootssm.service.ITestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Import(DynamicDataSourceRegister.class)
@EnableAutoConfiguration
public class SsmApplication extends SpringBootServletInitializer{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SsmApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SsmApplication.class, args);
	}
}
