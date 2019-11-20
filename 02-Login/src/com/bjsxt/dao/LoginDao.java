package com.bjsxt.dao;

import com.bjsxt.pojo.User;

/**
 * @Auther: QYZ
 * @Date: 2019/7/20 0020
 * @Description:
 * @Version: 1.0
 */
public interface LoginDao {
    //根据用户名和密码获取用户信息
    User checkLoginDao(String uname,String pwd);
    //根据uid获取用户信息
    User checkUidDao(String uid);
}
