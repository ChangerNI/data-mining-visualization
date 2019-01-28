package com.zafu.nichang.service.impl;

import com.zafu.nichang.enums.ResultEnums;
import com.zafu.nichang.exception.DataMiningVisualizationException;
import com.zafu.nichang.mapper.UserMapper;
import com.zafu.nichang.model.UserInfo;
import com.zafu.nichang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

/**
 * @author 倪畅
 * 2018-01-28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 验证是否能成功登录
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    @Override
    public UserInfo login(String username, String password) {
        return Optional.ofNullable(userMapper.getLoginUser(username, password))
                .orElseThrow(() -> new DataMiningVisualizationException(ResultEnums.USER_NOT_FOUND));
    }

    @Override
    public void logout() {

    }


}
