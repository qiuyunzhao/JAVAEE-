package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Auther: QYZ
 * @Date: 2019/7/28 0028
 * @Description:
 * @Version: 1.0
 */
@WebServlet(name = "NumServlet", urlPatterns = "/num", loadOnStartup = 1)
public class NumServlet extends HttpServlet {

    //覆写init初始化方法，将文件中的数据读取到ServletContext对象中
    @Override
    public void init() throws ServletException {
        //获取文件路径
        String path = this.getServletContext().getRealPath("/nums/nums.txt");
        System.out.println("init()-path-->" + path);
        //声明流对象
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String nums = br.readLine();
            System.out.println("nums-->" + nums);
            this.getServletContext().setAttribute("nums", nums);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //覆写销毁方法，存储计数器到文件中
    @Override
    public void destroy() {
        //获取网页计数器
        int nums = (int) this.getServletContext().getAttribute("nums");
        //获取文件路径
        String path = this.getServletContext().getRealPath("/nums/nums.txt");
        System.out.println("destroy()-path-->" + path + "-----nums:" + nums);
        //声明流对象
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            bw.write(nums + "");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
