package com.zafu.nichang.service;

import com.zafu.nichang.model.UserInfo;

import java.io.IOException;

/**
 * 登录接口
 * @author 倪畅
 * 2019-01-28
 */
public interface UserService {
    /**
     * 登录接口
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     * @throws IOException io异常 接口调用所产生
     */
    UserInfo login(String username, String password);

    /**
     * 退出登录
     */
    void logout();
}
