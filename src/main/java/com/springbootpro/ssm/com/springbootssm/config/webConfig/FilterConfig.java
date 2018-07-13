package com.springbootpro.ssm.com.springbootssm.config.webConfig;

import org.apache.catalina.filters.RemoteIpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * Configuration注解,提供一种以java代码的形式来完成之前xml的配置
 * 主要用于完成bean的注册工作和工程资源的初始化
 * 配置可以有先后之分 用order注解可以确定先后顺序，越小越先
 */
@Configuration
public class FilterConfig {

    private static final Logger log = LoggerFactory.getLogger(FilterConfig.class);

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    public class MyFilter implements Filter{

        @Override
        public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
            log.info("my filter init.....");
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            log.info("pass by my filter");
            filterChain.doFilter(servletRequest, servletResponse);
        }

        @Override
        public void destroy() {
            log.info("my filter destroy");
        }
    }
}
