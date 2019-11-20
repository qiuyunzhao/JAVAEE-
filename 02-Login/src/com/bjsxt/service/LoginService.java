package com.bjsxt.service;

import com.bjsxt.pojo.User;

/**
 * @Auther: QYZ
 * @Date: 2019/7/20 0020
 * @Description:
 * @Version: 1.0
 */
public interface LoginService {
    //校验用户登录信息
    User checkLoginService(String uname, String pwd);
    //校验用户Cookie信息
    User checkUidService(String uid);
}
