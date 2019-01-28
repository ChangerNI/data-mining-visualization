package com.zafu.nichang.service.impl;

import com.zafu.nichang.ApplicationTests;
import com.zafu.nichang.model.UserInfo;
import com.zafu.nichang.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest extends ApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    public void login() {
        UserInfo userInfo = userService.login("123", "1");
    }
}