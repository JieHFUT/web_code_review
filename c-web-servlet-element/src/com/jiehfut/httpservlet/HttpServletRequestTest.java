package com.jiehfut.httpservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/httpServlet")
public class HttpServletRequestTest extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 请求行相关的  GET POST URL http/1.1
        String method = req.getMethod();    // 获取请求方式
        String scheme = req.getScheme();    // 获取请求的协议
        String protocol = req.getProtocol();// 获取协议以及版本号
        String uri = req.getRequestURI();   // 获取项目内的资源路径
        String url = req.getRequestURL().toString();// 获取请求的项目内资源的完整的路径

        System.out.println("获取请求方式 method = " + method);
        System.out.println("获取请求的协议 scheme = " + scheme);
        System.out.println("获取协议以及版本号 protocol = " + protocol);
        System.out.println("获取项目内的资源路径 uri = " + uri);
        System.out.println("获取请求的项目内资源的完整的路径 url = " + url);

        /**
         * 获取请求方式 method = GET
         * 获取请求的协议 scheme = http
         * 获取协议以及版本号 protocol = HTTP/1.1
         * 获取项目内的资源路径 uri = /servletelement/httpServlet
         * 获取请求的项目内资源的完整的路径 url = http://localhost:8080/servletelement/httpServlet
         *
         * URI: 统一资源标识符  interface URI()              资源定位的要求和规范
         * URL: 统一资源定位符  class URL implements URI{}   具体的某一个资源的定位语法
         */



        // 请求头相关的  key:value ...








        // 请求体相关的

    }
}
