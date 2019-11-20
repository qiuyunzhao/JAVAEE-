package com.bjsxt.servlet;

import com.bjsxt.pojo.User;
import com.bjsxt.service.LoginService;
import com.bjsxt.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: QYZ
 * @Date: 2019/7/21 0021
 * @Description: 整个程序的入口
 * <p>
 * * Cookie信息校验
 * * 		判断请求中是否携带正确的Cookie信息
 * * 		如果有则校验Cookie信息是否正确
 * * 			如果校验正确则直接响应主页面给用户
 * * 			如果校验不正确则响应登录页面给用户
 * * 		没有则请求转发给登录页面
 * @Version: 1.0
 */
@WebServlet(name = "CookieServlet", urlPatterns = "/ck")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //2.设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //3.获取请求信息
        Cookie[] cks = req.getCookies();    //获取Cookie信息
        //4.处理请求信息
        if (cks != null) {
            //遍历Cookie信息
            String uid = "";
            for (Cookie c : cks) {
                if ("uid".equals(c.getName())) {
                    uid = c.getValue();
                }
            }
            //校验UID是否存在
            if ("".equals(uid)) {
                req.getRequestDispatcher("page").forward(req, resp);    //请求转发
                return;
            } else {
                //校验UID用户信息
                LoginService ls = new LoginServiceImpl();   //获取业务层对象
                User u = ls.checkUidService(uid);
                if (u != null) {
                    req.getSession().setAttribute("user", u);    //将用户数据存储到session对象中

                    //网页计数器自增
                    int nums = (int) this.getServletContext().getAttribute("nums");
                    nums += 1;
                    this.getServletContext().setAttribute("nums", nums);

                    resp.sendRedirect("/login/main");   //重定向
                    return;
                } else {
                    //5.响应处理结果
                    req.getRequestDispatcher("page").forward(req, resp);    //请求转发
                    return;
                }
            }
        } else {
            //5.响应处理结果
            req.getRequestDispatcher("page").forward(req, resp);    //请求转发
            return;
        }
    }
}
