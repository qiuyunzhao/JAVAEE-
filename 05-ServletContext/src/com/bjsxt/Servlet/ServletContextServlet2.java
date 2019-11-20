package com.bjsxt.Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: QYZ
 * @Date: 2019/7/28 0028
 * @Description:
 * @Version: 1.0
 */
@WebServlet(name = "ServletContextServlet2",urlPatterns = "/context2")
public class ServletContextServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取ServletContext对象
        ServletContext sc = this.getServletContext();

        //获取数据
        String str = (String) sc.getAttribute("str");
        System.out.println("ServletContextServlet2-->" + str);
    }
}
