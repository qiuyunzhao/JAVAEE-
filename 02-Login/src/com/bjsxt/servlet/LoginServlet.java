package com.bjsxt.servlet;

import com.bjsxt.pojo.User;
import com.bjsxt.service.LoginService;
import com.bjsxt.service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Auther: QYZ
 * @Date: 2019/7/20 0020
 * @Description: * 请求中文乱码解决:
 * *  首先配置tomccat编码：点击 Edit Configutations 进入tomcat配置页面,在VM options中，输入 -Dfile.encoding=UTF-8
 * *  1、使用String进行数据重新编码，不区分方式
 * * 			uname=new String(uname.getBytes("iso8859-1"),"utf-8");
 * *  2、使用公共配置
 * * 		get方式：
 * * 			步骤一：req.setCharacterEncoding("utf-8");
 * * 			步骤二：
 * * 				在tomcat的目录下的conf目录中修改server.xml文件：在Connector标签中增加属性 useBodyEncodingForURI="true"
 * * 		post方式：
 * * 			req.setCharacterEncoding("utf-8");
 * <p>
 * * Servlet流程总结:
 * * 	   1.浏览器发起请求到服务器(请求)
 * *      2.服务器接受浏览器的请求，进行解析，创建request对象存储请求数据
 * *      3.服务器调用对应的servlet进行请求处理，并将request对象作为实参传递给servlet的方法
 * *         servlet的方法执行进行请求处理
 * *      		//设置请求编码格式
 * *      		//设置响应编码格式
 * *      		//获取请求信息
 * *      		//处理请求信息
 * *      			//创建业务层对象
 * *      			//调用业务层对象的方法
 * *      		//响应处理结果
 * <p>
 * * 请求转发 ：
 * *		作用:实现多个servlet联动操作处理请求，这样避免代码冗余，让servlet的职责更加明确。
 * *		使用：req.getRequestDispatcher("要转发的地址").forward(req, resp);
 * *			 地址：相对路径，直接书写servlet的别名即可。
 * *		特点:
 * *			一次请求，一个request对象,浏览器地址栏信息不改变。
 * *		注意：
 * *			请求转发后直接return结束即可。
 * *    reuqet作用域：解决了 “一次请求” 内的servlet的数据共享问题
 * <p>
 * *重定向：
 * *		解决了表单重复提交的问题，以及当前servlet无法处理的请求的问题。
 * *		使用:
 * *			resp.sendRedirect(String uri);
 * *		示例:
 * *			resp.sendRedirect("/login/main");
 * *		特点：
 * *			两次请求，两个request对象，浏览器地址栏信息改变
 * *		时机：
 * *			如果请求中有表单数据，而数据又比较重要，不能重复提交，建议使用重定向。
 * *			如果请求被Servlet接收后，无法进行处理，建议使用重定向定位到可以处理的资源。
 * <p>
 * *session解决主页面用户名显示为null的问题：
 * *		原因：
 * *			因为在用户登录成功后使用重定向显示主页面，两次请求，而用户的信息在第一次请求中，第二次请求中没有用户数据，所以显示为null
 * <p>
 * *使用ServletContext对象完成网页计数器
 * *		在用户登录校验中创建计数器并自增，然后存储到ServletContext对象中
 * *		在主页面里取出计数器数据显示给用户即可。
 * @Version: 1.0
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");  //防止中文乱码

        //1 设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        //2 获取请求信息
        String uname = req.getParameter("uname");
        //  uname = new String(uname.getBytes("iso8859-1"), "utf-8");//使用String进行数据重新编码防止中文乱码(不分请求方式)
        String pwd = req.getParameter("pwd");
        System.out.println("uname:pwd-->" + uname + ":" + pwd);

        //3 处理请求
        LoginService ls = new LoginServiceImpl();
        User u = ls.checkLoginService(uname, pwd);

        //4 响应处理结果
        if (u != null) {
            //创建Cookie信息实现三天免登录。
            Cookie c = new Cookie("uid", u.getUid() + "");   //cookie信息在浏览器中可以查看，不安全，所以cookie信息存的是数据库中对应id
            c.setMaxAge(3 * 24 * 3600); //设置Cookie的有效期
            c.setPath("/login/ck"); //设置有效路径
            resp.addCookie(c);  //添加Cookie信息

            System.out.println("User-->" + u.toString());

            //将数存储到session对象中
            HttpSession hs = req.getSession();
            hs.setAttribute("user", u);

            //创建网页计数器
            ServletContext sc = this.getServletContext();   //获取ServletContext对象
            if (sc.getAttribute("nums") != null) {
                int nums=Integer.parseInt((String) sc.getAttribute("nums"));  //获取计数数据
                nums += 1;  //计数器自增
                sc.setAttribute("nums", nums);  //再次存储到ServletContext对象中
            } else {
                sc.setAttribute("nums", 1);
            }

            //重定向(重新发一个新的请求直接到main)，解决了表单重复提交的问题
            resp.sendRedirect("/login/main");
            return;
        } else {
            //使用request对象实现不同Servlet的数据流转
            req.setAttribute("str", "用户名或密码错误");
            //请求转发（跳转到别名为page的Servlet请求）
            req.getRequestDispatcher("page").forward(req, resp);
            return;
        }

    }
}
