package com.zafu.nichang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息类
 * @author 倪畅
 * @date ：Created in 2019/2/18 16:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    public String username;
    public String password;

}
