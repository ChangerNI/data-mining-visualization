package com.zafu.nichang.service.impl;

import com.zafu.nichang.enums.ResultEnums;
import com.zafu.nichang.exception.UserException;
import com.zafu.nichang.mapper.UserMapper;
import com.zafu.nichang.model.UserInfo;
import com.zafu.nichang.service.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

/**
 * @author 倪畅
 * 2018-01-28
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    /**
     * 验证是否能成功登录
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    @Override
    public UserInfo login(String username, String password) throws IOException{
        return Optional.ofNullable(userMapper.getLoginUser(username, password))
                .orElseThrow(() -> new UserException(ResultEnums.INNER_ERROR));
    }

    @Override
    public void logout() {

    }


}
