package com.zafu.nichang.mapper;

import com.zafu.nichang.model.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 验证登录信息接口
     * @param username
     * @param password
     * @return
     */
    UserInfo getLoginUser(@Param("username")String username, @Param("password")String password);
}
