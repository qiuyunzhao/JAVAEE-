package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Auther: QYZ
 * @Date: 2019/7/18 0018
 * @Description: * request对象学习：
 * * 		作用：request对象中封存了当前请求的所有请求信息
 * * 		使用：
 * * 			获取请求头数据(键值对的形式)
 * * 					req.getMethod();//获取请求方式
 * * 					req.getRequestURL();//获取请求URL信息
 * * 					req.getRequestURI();//获取请求URI信息
 * * 					req.getScheme();//获取协议
 * * 			获取请求行数据(键值对的形式)
 * * 					req.getHeader("键名");//返回指定的请求头信息
 * * 					req.getHeaderNames();//返回请求头的键名的枚举集合
 * * 			获取用户数据
 * * 					req.getParameter("键名");//返回指定的用户数据
 * * 					req.getParameterValues("键名");//返回同键不同值的请求数据(多选)，返回的数组。
 * * 					req.getParameterNames()//返回所有用户请求数据的枚举集合
 * * 			注意：
 * * 				如果要获取的请求数据不存在，不会报错，返回null。
 * *
 * * 		注意：
 * * 			request对象由tomcat服务器创建，并作为实参传递给处理请求的servlet的service方法。
 * @Version: 1.0
 */
public class RequestServlet_04 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*--------------------------------------获取请求头--------------------------------------*/
        //1.获取请求方式
        String method = req.getMethod();
        System.out.println("请求方式：" + method);
        //2.获取请求URL
        StringBuffer url = req.getRequestURL();
        String uri = req.getRequestURI();
        System.out.println("请求URL：" + url);
        System.out.println("请求URI：" + uri);
        //3.获取协议
        String protocol = req.getScheme();
        System.out.println("请求协议：" + protocol);

        /*--------------------------------------获取请求行--------------------------------------*/
        //1.获取指定的请求行信息
        String value1 = req.getHeader("User-Agent");
        System.out.println("请求头User-Agent：" + value1);

        String value2 = req.getHeader("aaa");   //不存在的键
        System.out.println(value2); //null

        //2.获取所有请求行的所有键的枚举
        Enumeration e = req.getHeaderNames();
        System.out.println("获取到的所有请求行信息的键值对");
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value3 = req.getHeader(key);
            System.out.println(key + ":" + value3);
        }

        /*--------------------------------------获取用户数据--------------------------------------*/
        //1.获取一个键对应一个值的数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname + ":" + pwd);

        String name = req.getParameter("name"); //不存在的键
        System.out.println("name:" + name); //null

        //2.获取同键不同值的多选数据
        String[] favs = req.getParameterValues("fav");
        if (favs != null) {
            for (String fav : favs) {
                System.out.println(fav);
            }
        }
        //获取所有的用户请求数据的键的枚举集合---req.getParameterNames()

    }
}
