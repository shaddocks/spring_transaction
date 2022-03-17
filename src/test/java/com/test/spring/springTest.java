package com.test.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.test.spring.beans.User;
import com.test.spring.config.JavaConfig;
import com.test.spring.dao.IUserDao;
import com.test.spring.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.security.Key;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class springTest {
    private ApplicationContext ioc;

    @Before
    public void test(){
        ioc = new AnnotationConfigApplicationContext(JavaConfig.class);
    }

    @Test
    public void test01(){
        JdbcTemplate bean = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        Long aLong = bean.queryForObject("SELECT count(*) FROM grade", Long.class);
        System.out.println(aLong);
    }

    //查询单个实体 字段名与属性一致
    @Test
    public void test02(){
        JdbcTemplate bean = ioc.getBean("jdbcTemplate", JdbcTemplate.class);//字段名和属性名不一致，需使用lambda来set属性值
        User user = bean.queryForObject("SELECT * FROM user WHERE id = 1", new BeanPropertyRowMapper<>(User.class));//自动将属性与数据库字段映射
        System.out.println(user);
    }

    //查询单个实体 字段名与属性不一致
    @Test
    public void test03(){
        JdbcTemplate bean = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        User user = bean.queryForObject("SELECT * FROM user WHERE id = 1", (resultSet, i) -> {
            User o = new User();
            o.setId(resultSet.getInt("id"));
            o.setRealname(resultSet.getString("realname"));
            o.setCardno(resultSet.getString("cardno"));
            o.setBalance(resultSet.getInt("balance"));
            return o;
        });
        System.out.println(user);
    }

    //查询List实体
    @Test
    public void test04(){
        JdbcTemplate bean = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        List<User> users = bean.query("SELECT * FROM user WHERE id = 1", (resultSet, i) -> {
            User o = new User();
            o.setId(resultSet.getInt("id"));
            o.setRealname(resultSet.getString("realname"));
            o.setCardno(resultSet.getString("cardno"));
            o.setBalance(resultSet.getInt("balance"));
            return o;
        });
        System.out.println(users);
    }

    //新增 不管新增，删除，修改都是update, 且会返回一个受影响行数
    @Test
    public void test05(){
        JdbcTemplate bean = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        int result = bean.update("INSERT INTO user(id, realname, cardno, balance) values(?, ?, ?, ?)", 5, "淼焱", "123455", 2000);
        System.out.println(result);
    }

    //修改
    @Test
    public void test06(){
        JdbcTemplate bean = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        int result = bean.update("UPDATE user SET balance = balance - 200 WHERE id = ?", 1);
        System.out.println(result);
    }

    //删除
    @Test
    public void test07(){
        JdbcTemplate bean = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        int result = bean.update("DELETE FROM user WHERE id = ?", 5);
        System.out.println(result);
    }

    //具名参数处理
    @Test
    public void test08(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 6);
        map.put("realname", "小蓝");
        map.put("cardno", "123445");
        map.put("balance", 80000);
        NamedParameterJdbcTemplate bean = ioc.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
        //delete: id = :id, map,
        int result = bean.update("INSERT INTO user(id, realname, cardno, balance) values=:map", map);// 错误的
        System.out.println(result);
    }

    @Test
    public void test09(){
        IUserService bean = ioc.getBean(IUserService.class);
        System.out.println(bean.getUser());
    }
}
