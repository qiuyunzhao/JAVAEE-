package com.bjsxt.servlet;

import com.bjsxt.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: QYZ
 * @Date: 2019/7/21 0021
 * @Description:
 * @Version: 1.0
 */
@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        User u = (User) req.getSession().getAttribute("user");
        //获取网页浏览次数
        int nums=(int) this.getServletContext().getAttribute("nums");
        //处理请求信息
        //响应处理结果
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>欢迎" + u.getUname() + "访问尚学堂管理系统</h3><hr>");
        resp.getWriter().write("当前网页浏览次数为:"+nums);
        resp.getWriter().write("<form action='show' method='get'>");
        resp.getWriter().write("<input type='submit' value='查看个人信息'>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("<hr>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }

}
