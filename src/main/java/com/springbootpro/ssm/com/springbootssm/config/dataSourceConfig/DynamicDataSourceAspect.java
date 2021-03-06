package com.springbootpro.ssm.com.springbootssm.config.dataSourceConfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/***
 * 数据源切面注解
 * 执行被TargetDataSource注解的方法前后，切换数据源
 */
@Aspect
@Order(-10)//保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

    private static final Logger log = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource){
        String dsId = targetDataSource.value();
        if( !DynamicDataSourceContextHolder.containsDataSource(dsId)){
            log.error("数据源:"+ targetDataSource.value() +"不存在,使用默认数据源 :" +
                    "\n" + point.getSignature());
        } else {
            log.info("使用数据源 : \n" + targetDataSource.value() + "\n" + point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(targetDataSource.value());
        }
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource){
        log.info("该数据源已使用完毕,正在从线程中取出....");
        DynamicDataSourceContextHolder.clearDataSourceType();
        log.info("取出完毕...");
    }
}
