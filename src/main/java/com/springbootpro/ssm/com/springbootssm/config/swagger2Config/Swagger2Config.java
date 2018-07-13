package com.springbootpro.ssm.com.springbootssm.config.swagger2Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    public Docket createRestAPI(){
        List<Parameter> params = new ArrayList<>();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getAPIInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(params)
                .apiInfo(getAPIInfo());
    }

    private ApiInfo getAPIInfo(){
         return new ApiInfoBuilder()
                .title("Restful接口管理")
                .description("LuciferMS")
                .termsOfServiceUrl("https://www.cnblogs.com/LuciferMS/")
                .version("1.0")
                .build();
    }
}
