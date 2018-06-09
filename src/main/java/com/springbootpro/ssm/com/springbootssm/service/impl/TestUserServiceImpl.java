package com.springbootpro.ssm.com.springbootssm.service.impl;

import com.springbootpro.ssm.com.springbootssm.config.dataSourceConfig.TargetDataSource;
import com.springbootpro.ssm.com.springbootssm.dao.IUserDao;
import com.springbootpro.ssm.com.springbootssm.pojo.User;
import com.springbootpro.ssm.com.springbootssm.service.ITestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUserServiceImpl implements ITestUserService {

    @Autowired
    private IUserDao iUserDao;


    @TargetDataSource("ds2")
    public User getUserInTestDB() {
        return iUserDao.getUserInTestDB();
    }


    @TargetDataSource("ds1")
    public User saveUserInMall() {
        return iUserDao.getUserInMall();
    }


    public User getUserInHibernate() {
        return iUserDao.getUserInHibernate();
    }
}
