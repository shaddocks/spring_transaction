package com.test.spring;

import com.test.spring.config.JavaConfig;
import com.test.spring.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionTest {
    private ApplicationContext ioc;

    @Before
    public void test(){
        ioc = new AnnotationConfigApplicationContext(JavaConfig.class);
    }

    @Test
    public void test01(){
        IUserService userService = ioc.getBean(IUserService.class);
        userService.trans();
    }
}
