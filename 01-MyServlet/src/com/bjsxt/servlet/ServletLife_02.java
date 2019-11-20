package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: QYZ
 * @Date: 2019/7/17 0017
 * @Description: 测试Servlet的生命周期
 *
 *   		1、从第一次调用到服务器关闭。
 *   		2、如果Servlet在web.xml中配置了load-on-startup，生命周期为从服务器启动到服务器关闭
 *   注意：
 *   		init方法是对Servlet进行初始化的一个方法，会在Servlet第一次加载进行存储时执行
 *  		destory方法是在servlet被销毁时执行，也就服务器关闭时。
 *
 * @Version: 1.0
 */
public class ServletLife_02 extends HttpServlet {

    int i = 0;

    //servlet第一次调用,class文件被加载到内存时init()被调用
    @Override
    public void init() throws ServletException {
        System.out.println("init()被调用");
    }

    //有请求时servlet()被调用
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Servlet Life");
        i++;
        System.out.println("service()被调用" + i);
    }

    //服务器关闭，内存中的Servlet被销毁
    @Override
    public void destroy() {
        System.out.println("destroy()被调用");
    }
}
