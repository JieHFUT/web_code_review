package com.jiehfut.lifecycle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Tomcat 创建并且管理 Servlet 的过程
 *
 * 1.Servlet 实例化   =============>  构造器   =======>  第一次请求的时候执行
 * 2.Servlet 初始化   =============>  init    =======>  构造完毕就执行
 * 3.Servlet 接收请求，处理请求 服务  => service() ======>  每次请求都会执行
 * 4.Servlet 销毁     =============> destory()  =====>  关闭 Tomcat 服务的时候执行
 *
 * ==> 得到一个结论：Servlet 在 Tomcat 是单例的
 *
 *
 *
 */

@WebServlet("/lifeCycle")
public class LifeCycle extends HttpServlet {

    public LifeCycle() {
        System.out.println("构造器");
    }


    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }


}
