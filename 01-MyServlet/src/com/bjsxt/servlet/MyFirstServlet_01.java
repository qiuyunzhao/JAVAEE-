package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: QYZ
 * @Date: 2019/7/15 0015
 * @Description:
 * @Version: 1.0
 */
public class MyFirstServlet_01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("this is my first servlet.");
        System.out.println("this is my first servlet.");
    }
}
