package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: QYZ
 * @Date: 2019/7/24 0024
 * @Description:
 * @Version: 1.0
 */
@WebServlet(name = "SessionServlet2", urlPatterns = "/ss2")
public class SessionServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        System.out.println("session2--JSESSIONID："+hs.getId());
        System.out.println("session2--name："+hs.getAttribute("name"));

        resp.getWriter().write("session2学习");
    }
}
