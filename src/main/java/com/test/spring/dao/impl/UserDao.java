package com.test.spring.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.test.spring.beans.User;
import com.test.spring.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {
    private JdbcTemplate jdbcTemplate;//线程安全的

    @Autowired
    public UserDao(DruidDataSource druidDataSource){
        this.jdbcTemplate = new JdbcTemplate(druidDataSource);
        //System.out.println("构造方法");
    }

    @Autowired
    public void setDataSource(DruidDataSource druidDataSource){
        this.jdbcTemplate = new JdbcTemplate(druidDataSource);
        //System.out.println("set方法");
    }

    @Override
    public User getUser(){
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE id = 1", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save() {
        jdbcTemplate.update("UPDATE user SET balance = balance + 200 WHERE id = 2");
    }

    @Override
    public void sub() {
        jdbcTemplate.update("UPDATE user SET balance = balance - 200 WHERE id = 1");
    }
}
