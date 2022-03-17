package com.test.spring.service.impl;

import com.test.spring.beans.User;
import com.test.spring.dao.IUserDao;
import com.test.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    @Autowired
    public UserServiceImpl(IUserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User getUser(){
        return userDao.getUser();
    }

    @Override
    @Transactional
    public void trans(){
        sub();
        //int i = 5/0;
        save();
    }

    private void sub(){
        System.out.println("扣钱");
        userDao.sub();
    }

    private void save(){
        System.out.println("收钱");
        userDao.save();
    }
}
