package com.springbootpro.ssm.com.springbootssm.dao;

import com.springbootpro.ssm.com.springbootssm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IUserDao {

    @Select("SELECT u.id, u.username, u.nickname, u.password " +
            "FROM T_USER u " +
            "WHERE u.nickname = 'Shayla'")
    User getUserInTestDB();

    @Select("SELECT u.id, u.username, u.nickname, u.password " +
            "FROM T_USER u " +
            "WHERE u.id = '1'")
    User getUserInMall();

    @Select("SELECT u.id, u.username, u.nickname, u.password " +
            "FROM T_USER u " +
            "WHERE u.nickname = '123'")
    User getUserInHibernate();
}
