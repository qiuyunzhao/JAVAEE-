package com.bjsxt.dao.impl;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.pojo.User;

import java.sql.*;

/**
 * @Auther: QYZ
 * @Date: 2019/7/20 0020
 * @Description:
 * @Version: 1.0
 */
public class LoginDaoImpl implements LoginDao {

    @Override
    public User checkLoginDao(String uname, String pwd) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User user = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");
            //创建SQL命令
            String sql = "select * from t_user where username=? and pwd=?";
            //创建执行SQL命令对象
            ps = conn.prepareStatement(sql);
            //设置占位符
            ps.setString(1, uname);
            ps.setString(2, pwd);
            //执行SQL
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("id"));
                user.setUname(rs.getString("username"));
                user.setPwd(rs.getString("pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            closeJDBCResource(conn, ps, rs);
        }
        return user;
    }

    @Override
    public User checkUidDao(String uid) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User user = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaspeek300", "root", "zhao17615110273");
            //创建SQL命令
            String sql = "select * from t_user where id=?";
            //创建执行SQL命令对象
            ps = conn.prepareStatement(sql);
            //设置占位符
            ps.setString(1, uid);
            //执行SQL
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("id"));
                user.setUname(rs.getString("username"));
                user.setPwd(rs.getString("pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            closeJDBCResource(conn, ps, rs);
        }
        return user;
    }

    /**
     * 释放数据库资源
     */
    private void closeJDBCResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
