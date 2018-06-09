package com.springbootpro.ssm.com.springbootssm.service;

import com.springbootpro.ssm.com.springbootssm.pojo.User;

public interface ITestUserService {
    public User getUserInTestDB();

    public User getUserInHibernate();

    public User saveUserInMall();
}
