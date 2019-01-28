package com.zafu.nichang.controller;

import com.zafu.nichang.entity.vo.ResultVO;
import com.zafu.nichang.model.UserInfo;
import com.zafu.nichang.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ncg
 */
@RestController
@RequestMapping("/u")
public class UserController {

    /**
     * 日志
     */
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public ResultVO<UserInfo> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserInfo userInfo = userService.login(username, password);
        return ResultVO.success("登录成功", userInfo);
    }

}
