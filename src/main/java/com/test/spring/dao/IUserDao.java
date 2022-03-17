package com.test.spring.dao;

import com.test.spring.beans.User;

public interface IUserDao {
    User getUser();

    void save();

    void sub();
}
