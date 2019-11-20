package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: QYZ
 * @Date: 2019/7/20 0020
 * @Description:
 * @Version: 1.0
 */
public class PageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //2 获取请求信息
        //3 处理请求
        //4 响应处理结果
        String str = (String) req.getAttribute("str"); //获取request作用域数据
        System.out.println("str-->" + str);

        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");

        //来自请求转发则包含str信息，来自服务器则没有
        if (null != str) {
            resp.getWriter().write("<font color='red' size='20px'>" + str + "</font>");
        }

        resp.getWriter().write("<body>");
        resp.getWriter().write("<form action='login' method='post'>");
        resp.getWriter().write("用户名：<input type='test' name='uname' value=''/><br/>");
        resp.getWriter().write("密  码：<input type='password' name='pwd' value=''/><br/>");
        resp.getWriter().write("登录：<input type='submit' value='登录'/><br/>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
