package com.bjsxt.service.impl;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.dao.impl.LoginDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.LoginService;

/**
 * @Auther: QYZ
 * @Date: 2019/7/20 0020
 * @Description:
 * @Version: 1.0
 */
public class LoginServiceImpl implements LoginService {

    //创建Dao层对象
    LoginDao ld = new LoginDaoImpl();

    //校验用户登录信息
    @Override
    public User checkLoginService(String uname, String pwd) {
        return ld.checkLoginDao(uname,pwd);
    }

    //校验用户Cookie信息
    @Override
    public User checkUidService(String uid) {
        return ld.checkUidDao(uid);
    }

}
