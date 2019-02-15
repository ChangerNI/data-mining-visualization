package com.zafu.nichang.controller;

import com.zafu.nichang.entity.vo.ResultVO;
import com.zafu.nichang.model.UserInfo;
import com.zafu.nichang.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 倪畅
 * @date 2019-01-28
 */
@RestController
@CrossOrigin
@RequestMapping("/u")
public class UserController {

    /**
     * 日志
     */
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResultVO<UserInfo> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserInfo userInfo = userService.login(username, password);
        return ResultVO.success("登录成功", userInfo);
    }

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/save")
    public ResultVO<UserInfo> save(@RequestParam("username") String username, @RequestParam("password") String password) {
        userService.saveLoginUser(username, password);
        return ResultVO.success("注册成功");
    }
}
